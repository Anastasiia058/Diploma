package checkObject;

import java.util.Scanner;

public class CheckRoute {

    public static String readRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть усі станції маршруту, починаючи зі станції відправлення");
        String nameRoute = scanner.nextLine();
        if (nameRoute.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readRoute();
        }
        return nameRoute;
    }
}
