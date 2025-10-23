import java.util.Scanner;

public class InteractiveTeaBrewing {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean waterBoiled = false;
    private static boolean cupPrepared = false;
    private static boolean teaAdded = false;
    
    public static void main(String[] args) {
        System.out.println("ПРОЦЕСС ЗАВАРИВАНИЯ ЧАЯ\nP.s отвечать на английском");
        
        // Основной процесс заваривания чая
        checkWaterBoiling();    // проверка чайника
        checkCupPreparation();  // проверка стакана  
        checkTeaAddition();     // проверка заварки
        pourWaterToCup();       
        steepTeaProcess();      // Настаивание
        
        System.out.println("ЧАЙ ГОТОВ!");
    }
    
    // Проверка кипячения воды в чайнике
    public static void checkWaterBoiling() {
        System.out.println("1. Состояние чайника:");
        System.out.print("Вода вскипела? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("да") || answer.equals("yes")) {
            waterBoiled = true;
            System.out.println("Вода закипела\n");
        } else {
            waterBoiled = false;
            System.out.println("Подождать, чайник еще кипятится\n");
            checkWaterBoiling();
        }
    }
    
    // Проверка подготовки стакана
    public static void checkCupPreparation() {
        if (!waterBoiled) {
            System.out.println("Сначала вскипятите воду");
            checkWaterBoiling();
            return;
        }
        
        System.out.println("2. Подготовка стакана:");
        System.out.print("Стакан чистый? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("да") || answer.equals("yes")) {
            cupPrepared = true;
            System.out.println("Стакан готов\n");
        } else {
            cupPrepared = false;
            System.out.println("Помыть и протереть стакан\n");
            checkCupPreparation();
        }
    }
    
    // Проверка добавления заварки
    public static void checkTeaAddition() {
        if (!cupPrepared) {
            System.out.println("Сначала подготовьте стакан");
            checkCupPreparation();
            return;
        }
        
        System.out.println("3. Добавление заварки:");
        System.out.print("Заварка добавлена в стакан? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("да") || answer.equals("yes")) {
            teaAdded = true;
            System.out.println("Заварка добавлена\n");
        } else {
            teaAdded = false;
            System.out.println("Добавьте заварку в стакан\n");
            checkTeaAddition();
        }
    }
    
    // Заливка воды в стакан с заваркой
    public static void pourWaterToCup() {
        if (!teaAdded) {
            System.out.println("Добавьте заварку");
            checkTeaAddition();
            return;
        }
        
        System.out.println("4. Заливка воды:");
        System.out.print("Залить кипяток в стакан? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("да") || answer.equals("yes")) {
            System.out.println("Вода залита\n");
        } else {
            System.out.println("Залейте вскипяченую воду\n");
            pourWaterToCup();
        }
    }
    
    // Процесс заваривания чая
    public static void steepTeaProcess() {
        System.out.println("5. Заваривание чая:");
        System.out.print("Прошло 3 минуты? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("да") || answer.equals("yes")) {
            System.out.println("Чай готов\n");
        } else {
            System.out.println("Подождать ещё, чай заваривается\n");
            steepTeaProcess();
        }
    }
}