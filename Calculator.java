import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        
        System.out.print("Введите тип операции (+, -, *, /): ");
        String operationType = scanner.nextLine();
        
        System.out.print("Введите первое число: ");
        double firstNumber = getValidNumber(scanner);
        
        System.out.print("Введите второе число: ");
        double secondNumber = getValidNumber(scanner);
        
        double result = 0; 
        boolean validOperation = true;
        String errorMessage = "";
        
        switch (operationType.toLowerCase()) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    validOperation = false;
                    errorMessage = "Деление на ноль невозможно!";
                }
                break;
            default:
                validOperation = false;
                errorMessage = "Неизвестная операция '" + operationType + "'";
                break;
        }
        
        if (validOperation) {
            System.out.printf(name + " ваш результат: " + result);
        } else {
            System.out.printf(name + "" + errorMessage);
        }
        
        scanner.close();
    }
    
    private static double getValidNumber(Scanner scanner) {
    while (true) {
        String input = scanner.nextLine();
        try {
            double number = Double.parseDouble(input);
            return number; // если успешно - возвращаем число
        } catch (NumberFormatException e) {
            // если ошибка - сообщаем и цикл повторяется
            System.out.print("Ошибка! Введите корректное число: ");
        }
    }
}
}
