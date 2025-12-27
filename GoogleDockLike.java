import java.util.Scanner;
import java.util.Arrays;

public class GoogleDockLike {
    public static void main(String[] args) {

        String[] name = new String[5];
        int[] age = new int[5];
        String[] email = new String[5];
        String[] profession = new String[5];
        String[] insta = new String[5];

        Scanner in = new Scanner(System.in);
        for (int i = 0; i<5; i++) {
            System.out.println("Введите ваше имя: ");
            name[i] = in.nextLine();

            System.out.println("Введите ваш возраст: ");
            age[i] = in.nextInt();
            String skip = in.nextLine();

            System.out.println("Введите вашу почту: ");
            email[i] = in.nextLine();

            System.out.println("Введите вашу профессию: ");
            profession[i] = in.nextLine();

            System.out.println("Введите ваш инстаграмм: ");
            insta[i] = in.nextLine();
        }

        String longestName = "";
        for (int i = 0; i < 4; i++) {
            if (name[i].length() > name[i+1].length()) {
                longestName = name[i];
            } else {
                longestName = name[i+1];
            }
        }
        System.out.println("Самое длинное имя: " + longestName);

        double avgAge;
        double totalAge = 0;
        for (int i = 0; i < 5; i++) {
            totalAge += age[i];
        }
        avgAge = totalAge / age.length;
        System.out.println("Средний возраст пользователей: " + avgAge);

        for (int i = 0; i < email.length; i++) {
            String newEmail = email[i];
            int dogIndex = newEmail.indexOf("@");

            if (dogIndex != -1) {
                newEmail = newEmail.substring(0, dogIndex + 1);
                System.out.println("Почта до @ " + newEmail);
            }
        }

        String[] temp = new String[profession.length];
        int uniqueCount = 0;

        for (int i = 0; i < profession.length; i++) {
            String current = profession[i];
            boolean found = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j].equals(current)) {
                    found = true;
                    break;
                }
            }

            // если нет, добавляем
            if (!found) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        String[] result = new String[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        System.out.println("Уникальные профессии: " + Arrays.toString(result));

        in.close();
    }
}