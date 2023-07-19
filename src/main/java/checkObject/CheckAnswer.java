package checkObject;

import java.util.Locale;
import java.util.Scanner;

public class CheckAnswer {

    public static boolean check () {
        System.out.println("Введіть 'Так' або 'Ні'");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.toLowerCase().equals("так") || (answer.toLowerCase().equals("ні"))) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Введіть 'Так' або 'Ні'");
            check();
        }
        return answer.toLowerCase().equals("так");
    }
}
