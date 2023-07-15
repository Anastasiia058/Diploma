package checkObject;

import java.util.Scanner;

public class CheckTrain {

    public static String readTrain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву поїзда");
        String nameTrain = scanner.nextLine();
        if (nameTrain.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readTrain();
        }
        return nameTrain;
    }
}
