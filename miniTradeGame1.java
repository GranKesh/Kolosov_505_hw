import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class miniTradeGame {
    // Игровые данные
    private static final String[] locations = {
        "Лесная застава",
        "Прибрежный город", 
        "Горное поселение",
        "Столичный рынок"
    };
    
    private static final String[] goodsNames = {
        "лесные ягоды", "речная рыба", "горный кристалл", "столичные ткани"
    };
    
    private static final int[] goodsPrices = {10, 15, 50, 30};
    
    private static final String[] events = {
        "На пути вас ограбили разбойники! Потеряна часть товара",
        "Удачная сделка! Цены выросли",
        "Налог от местного правителя. Придется заплатить",
        "Праздник в городе! Спрос на все товары повышен",
        "Ничего особенного не произошло"
    };
    
    // Игрок
    private static int playerGold = 100;
    private static int playerLocation = 0;
    private static int playerDay = 1;
    
    // Инвентарь
    private static String[] inventoryNames = new String[10];
    private static int[] inventoryQuantities = new int[10];
    private static int inventorySize = 0;
    
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {
        startGame();
    }
    
    public static void startGame() {
        initializeGame();
        gameLoop();
    }
    
    public static void initializeGame() {
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ТОРГОВУЮ НОВЕЛЛУ!");
        System.out.println("Вы - начинающий торговец. Ваша цель: разбогатеть!");
        showStatus();
        showHelp();
    }
    
    public static void showStatus() {
        System.out.println("\n=== День " + playerDay + " ===");
        System.out.println("Местоположение: " + locations[playerLocation]);
        System.out.println("Золото: " + playerGold);
        System.out.println("Инвентарь:");
        
        if (inventorySize == 0) {
            System.out.println("   Пусто");
        } else {
            for (int i = 0; i < inventorySize; i++) {
                System.out.println("   " + (i + 1) + ". " + inventoryNames[i] + " - " + inventoryQuantities[i] + " шт.");
            }
        }
    }
    
    public static void showHelp() {
        System.out.println("\nКоманды:");
        System.out.println("купить [номер] [количество] - купить товар");
        System.out.println("продать [номер] [количество] - продать товар");
        System.out.println("путешествовать [номер] - отправиться в другое место");
        System.out.println("статус - показать состояние");
        System.out.println("помощь - показать команды");
        System.out.println("выход - закончить игру");
        System.out.println("\nДоступные товары:");
        for (int i = 0; i < goodsNames.length; i++) {
            int buyPrice = calculatePrice(i, playerLocation, true);
            int sellPrice = calculatePrice(i, playerLocation, false);
            System.out.println("   " + (i + 1) + ". " + goodsNames[i] + " (покупка: " + buyPrice + ", продажа: " + sellPrice + ")");
        }
    }
    
    public static int calculatePrice(int goodIndex, int locationIndex, boolean isBuying) {
        int basePrice = goodsPrices[goodIndex];
        double[] locationMultipliers = {1.0, 1.2, 0.8, 1.5};
        double locationMultiplier = locationMultipliers[locationIndex];
        double tradeMultiplier = isBuying ? 1.0 : 0.7;
        
        return (int) Math.round(basePrice * locationMultiplier * tradeMultiplier);
    }
    
    public static int findItemInInventory(String itemName) {
        for (int i = 0; i < inventorySize; i++) {
            if (inventoryNames[i].equals(itemName)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void removeItemFromInventory(int index) {
        for (int i = index; i < inventorySize - 1; i++) {
            inventoryNames[i] = inventoryNames[i + 1];
            inventoryQuantities[i] = inventoryQuantities[i + 1];
        }
        inventorySize--;
        inventoryNames[inventorySize] = null;
        inventoryQuantities[inventorySize] = 0;
    }
    
    public static void buyItem(String input) {
        Pattern pattern = Pattern.compile("купить\\s+(\\d+)\\s+(\\d+)");
        Matcher matcher = pattern.matcher(input);
        
        if (!matcher.find()) {
            System.out.println("Неправильный формат. Используйте: купить [номер] [количество]");
            return;
        }
        
        int goodIndex = Integer.parseInt(matcher.group(1)) - 1;
        int quantity = Integer.parseInt(matcher.group(2));
        
        if (goodIndex < 0 || goodIndex >= goodsNames.length) {
            System.out.println("Неверный номер товара");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Количество должно быть больше 0");
            return;
        }
        
        if (inventorySize >= inventoryNames.length) {
            System.out.println("Инвентарь полон! Максимум " + inventoryNames.length + " разных товаров");
            return;
        }
        
        int price = calculatePrice(goodIndex, playerLocation, true);
        int totalCost = price * quantity;
        
        if (playerGold < totalCost) {
            System.out.println("Недостаточно золота! Нужно: " + totalCost + ", есть: " + playerGold);
            return;
        }
        
        playerGold -= totalCost;
        
        String itemName = goodsNames[goodIndex];
        int existingIndex = findItemInInventory(itemName);
        
        if (existingIndex != -1) {
            inventoryQuantities[existingIndex] += quantity;
        } else {
            inventoryNames[inventorySize] = itemName;
            inventoryQuantities[inventorySize] = quantity;
            inventorySize++;
        }
        
        System.out.println("Куплено " + quantity + " " + itemName + " за " + totalCost + " золота");
        nextDay();
    }
    
    public static void sellItem(String input) {
        Pattern pattern = Pattern.compile("продать\\s+(\\d+)\\s+(\\d+)");
        Matcher matcher = pattern.matcher(input);
        
        if (!matcher.find()) {
            System.out.println("Неправильный формат. Используйте: продать [номер] [количество]");
            return;
        }
        
        int inventoryIndex = Integer.parseInt(matcher.group(1)) - 1;
        int quantity = Integer.parseInt(matcher.group(2));
        
        if (inventoryIndex < 0 || inventoryIndex >= inventorySize) {
            System.out.println("Неверный номер товара в инвентаре");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Количество должно быть больше 0");
            return;
        }
        
        String itemName = inventoryNames[inventoryIndex];
        int currentQuantity = inventoryQuantities[inventoryIndex];
        
        if (currentQuantity < quantity) {
            System.out.println("Недостаточно товара! Есть: " + currentQuantity + ", хотите продать: " + quantity);
            return;
        }
        
        int goodIndex = -1;
        for (int i = 0; i < goodsNames.length; i++) {
            if (goodsNames[i].equals(itemName)) {
                goodIndex = i;
                break;
            }
        }
        
        if (goodIndex == -1) {
            System.out.println("Ошибка: товар не найден");
            return;
        }
        
        int price = calculatePrice(goodIndex, playerLocation, false);
        int totalIncome = price * quantity;
        
        playerGold += totalIncome;
        
        int newQuantity = currentQuantity - quantity;
        inventoryQuantities[inventoryIndex] = newQuantity;
        
        if (newQuantity <= 0) {
            removeItemFromInventory(inventoryIndex);
        }
        
        System.out.println("Продано " + quantity + " " + itemName + " за " + totalIncome + " золота");
        nextDay();
    }
    
    public static void travel(String input) {
        Pattern pattern = Pattern.compile("путешествовать\\s+(\\d+)");
        Matcher matcher = pattern.matcher(input);
        
        if (!matcher.find()) {
            System.out.println("Неправильный формат. Используйте: путешествовать [номер]");
            System.out.println("Доступные локации:");
            for (int i = 0; i < locations.length; i++) {
                System.out.println("   " + (i + 1) + ". " + locations[i]);
            }
            return;
        }
        
        int locationIndex = Integer.parseInt(matcher.group(1)) - 1;
        
        if (locationIndex < 0 || locationIndex >= locations.length) {
            System.out.println("Неверный номер локации");
            return;
        }
        
        if (locationIndex == playerLocation) {
            System.out.println("Вы уже в этой локации!");
            return;
        }
        
        int travelCost = 20;
        if (playerGold < travelCost) {
            System.out.println("Недостаточно золота для путешествия! Нужно: " + travelCost);
            return;
        }
        
        playerGold -= travelCost;
        playerLocation = locationIndex;
        
        System.out.println("Вы отправились в " + locations[locationIndex]);
        System.out.println("Стоимость путешествия: " + travelCost + " золота");
        nextDay();
    }
    
    public static void randomEvent() {
        String event = events[random.nextInt(events.length)];
        System.out.println("\nСобытие: " + event);
        
        int eventIndex = -1;
        for (int i = 0; i < events.length; i++) {
            if (events[i].equals(event)) {
                eventIndex = i;
                break;
            }
        }
        
        switch(eventIndex) {
            case 0:
                if (inventorySize > 0) {
                    int stolenIndex = random.nextInt(inventorySize);
                    String stolenName = inventoryNames[stolenIndex];
                    int stolenQuantity = Math.max(1, (int)(inventoryQuantities[stolenIndex] * 0.3));
                    int newQuantity = inventoryQuantities[stolenIndex] - stolenQuantity;
                    inventoryQuantities[stolenIndex] = newQuantity;
                    System.out.println("Потеряно " + stolenQuantity + " " + stolenName);
                    
                    if (newQuantity <= 0) {
                        removeItemFromInventory(stolenIndex);
                    }
                }
                break;
            case 1:
                playerGold += 30;
                System.out.println("Получено бонусное золото: +30");
                break;
            case 2:
                int tax = Math.min(25, playerGold);
                playerGold -= tax;
                System.out.println("Уплачен налог: " + tax + " золота");
                break;
        }
    }
    
    public static void nextDay() {
        playerDay++;
        
        if (random.nextDouble() < 0.3) {
            randomEvent();
        }
        
        if (playerGold >= 500) {
            System.out.println("\nПОЗДРАВЛЯЕМ! ВЫ СТАЛИ БОГАТЫМ ТОРГОВЦЕМ!");
            System.out.println("Итог: " + playerDay + " дней, " + playerGold + " золота");
            scanner.close();
            System.exit(0);
        }
        
        if (playerGold <= 0 && inventorySize == 0) {
            System.out.println("\nВЫ РАЗОРИЛИСЬ! ИГРА ОКОНЧЕНА");
            scanner.close();
            System.exit(0);
        }
        
        showStatus();
    }
    
    public static void gameLoop() {
        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine().toLowerCase().trim();
            
            if (input.equals("выход")) {
                System.out.println("Спасибо за игру!");
                break;
            }
            
            if (input.startsWith("купить")) {
                buyItem(input);
            } else if (input.startsWith("продать")) {
                sellItem(input);
            } else if (input.startsWith("путешествовать")) {
                travel(input);
            } else if (input.equals("статус")) {
                showStatus();
            } else if (input.equals("помощь")) {
                showHelp();
            } else {
                System.out.println("Неизвестная команда. Введите \"помощь\" для списка команд.");
            }
        }
        
        scanner.close();
    }
}