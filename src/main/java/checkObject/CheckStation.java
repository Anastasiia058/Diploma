package checkObject;

import java.util.Scanner;

public class CheckStation {

    private static Scanner scanner = new Scanner(System.in);
    public static int readIdStation() {
        System.out.println("Викристовуйте цифру");
        String idStation = scanner.nextLine();
        if (idStation.matches("^\\d+$")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readIdStation();
        }
        return Integer.parseInt(idStation);
    }
    public static String readNameStation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву станції");
        String nameStation = scanner.nextLine();
        if (nameStation.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readNameStation();
        }
        return nameStation;
    }
}
