import java.util.regex.*;


public class Main {
    
    // 1. Проверка палиндрома
    public static boolean isPalindromeV1(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }
	
	// Не уверен можно ли было использовать стринг билдер а также не до конца понял как он работает так что вот еще вариант без него.
	public static boolean isPalindromeV2(String str) {
    String cleanStr = str.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();
    int left = 0;
    int right = cleanStr.length() - 1;
    
    while (left < right) {
        if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
	}
	// 2. Удаление дубликатов
	public static String removeDupl(String str) {
    String result = ""; 
    for (int i = 0; i < str.length(); i++) {
        char currentChar = str.charAt(i);  
        if (result.indexOf(currentChar) == -1) { 
            result += currentChar;  
        }
    }
    return result;
	}
	
	// 3. Первое не дублируб=ющееся вхождение.
	public static Character firstNonRepChar(String str) {
    for (int i = 0; i < str.length(); i++) {
        char currentChar = str.charAt(i);
        if (str.indexOf(currentChar) == str.lastIndexOf(currentChar)) {
            return currentChar;
        }
    }
    return null;
	}
	
	// 4. замена "а" на "@"
	public static String replaceAWith(String str) {
    return str.replace('a', '@');
	}
	
	//5
	public static int countWords(String str) {
    if (str == null || str.trim().isEmpty()) {
        return 0;
    }
    String trimmed = str.trim();
    int wordCount = 0;
    boolean inWord = false;
    for (int i = 0; i < trimmed.length(); i++) {
        if (trimmed.charAt(i) == ' ') {
            inWord = false;
        } else {
            if (!inWord) {
                wordCount++;
                inWord = true;
            }
        }
    }
    return wordCount;
	}
	
	//6.
	public static boolean equalsIgnoreCaseV1(String str1, String str2) {
    return str1.equalsIgnoreCase(str2);
	}
	
	public static boolean equalsIgnoreCaseV2(String str1, String str2) {
    if (str1 == null || str2 == null) {
        return str1 == str2;  
    }
    return str1.toLowerCase().equals(str2.toLowerCase());
	}
	
	//7.
	public static boolean isValidRus(String phone) {
    String regex = "^(\\+7\\s?\\(\\d{3}\\)\\s?\\d{3}-\\d{2}-\\d{2}|8\\d{10})$";
    return phone.matches(regex);
	}
	
	//8.
	public static void findNumbers(String text) {
    Pattern pattern = Pattern.compile("-?\\d+(?:\\.\\d+)?");
    Matcher matcher = pattern.matcher(text);
    
    System.out.print("Найденные числа: ");
    while (matcher.find()) {
        System.out.print(matcher.group() + " ");
    }
    System.out.println();
	}
	
	//9
	public static String normSpaces(String str) {
    return str.replaceAll("\\s+", " ");
	}
	
	//10.
	public static boolean isValidEmail(String email) {
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email.matches(regex);
	}
	
	//11. тут както через форматы вроде можно
	public static String formatProdInfo(String name, double price) {
    double roundedPrice = Math.round(price * 100.0) / 100.0;
    return "Товар: " + name + ", Цена: " + roundedPrice + " руб.";
	}
	
	//12.
	public static String joinStrings(String[] strings) {
    return String.join("; ", strings);
}

public static void main(String[] args) {
        //1
        System.out.println("1.'А роза упала на лапу Азора': " + 
            isPalindromeV1("А роза упала на лапу Азора"));
		System.out.println("1.'А роза упала на лапу Азора': " + 
            isPalindromeV2("А роза упала на лапу Азора"));
        
        //2
        System.out.println("2.'programming': " + 
            removeDupl("programming"));
        
        //3
        System.out.println("3.'бисмилях': " + 
            firstNonRepChar("бисмилях"));
        
        //4
        System.out.println("4.'Java': " + 
            replaceAWith("Java"));
        
        //5
        System.out.println("5.'  Hello   World  Java  ': " + 
            countWords("  Hello   World  Java  "));
        
        //6
        System.out.println("6.'ПУЗО ГАБЕНА' и 'пузо габена': " + 
            equalsIgnoreCaseV1("ПУЗО ГАБЕНА", "пузо габена"));
		System.out.println("6.'ПУЗО ГАБЕНА' и 'пузо габена': " + 
            equalsIgnoreCaseV2("ПУЗО ГАБЕНА", "пузо габена"));
        
        //7
        System.out.println("7.'+7 (983) 598-65-20': " + 
            isValidRus("+7 (983) 598-65-20"));
        
        //8
		System.out.print("8.: ");
		findNumbers("Цены: 100, 25.5, -30, 123.45 рублей");
        
        //9
        System.out.println("9. 'Много    пробелов   здесь': '" + 
            normSpaces("Много    пробелов   здесь") + "'");
        
        // 10
        System.out.println("10.'kolosov.egor007@gmail.com': " + 
            isValidEmail("kolosov.egor007@gmail.com"));
        
        //11
        System.out.println("11. " + formatProdInfo("Мама Сиджея", 214912.5334));
        
        //12
        String[] dryFruit = {"Мёртвый", "Банан", "Либерала"};
        System.out.println("12.: " + joinStrings(dryFruit));
    }
}