package checkObject;

import java.util.Scanner;

public class CheckStation {

    public static String readStation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву станції");
        String nameStation = scanner.nextLine();
        if (nameStation.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readStation();
        }
        return nameStation;
    }
}
