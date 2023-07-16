package checkObject;

import java.util.Scanner;

public class CheckTrain {

    private static Scanner scanner = new Scanner(System.in);

    public static int readIdTrain() {
        System.out.println("Введіть id поїзда");
        String idTrain = scanner.nextLine();
        if (idTrain.matches("([/^\\d+$/])")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readIdTrain();
        }
        return Integer.parseInt(idTrain);
    }

    public static String readNameTrain() {
        System.out.println("Введіть назву поїзда");
        String nameTrain = scanner.nextLine();
        if (nameTrain.matches("([А-ЯҐІЇ{1}\\s][а-яґії{30}\\s]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readNameTrain();
        }
        return nameTrain;
    }

    public static String readTypeTrain() {
        System.out.println("Введіть тип поїзда");
        String typeTrain = scanner.nextLine();
        if (typeTrain.matches("([А-ЯҐІЇ{1}\\s][а-яґії{30}\\s]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readTypeTrain();
        }
        return typeTrain;
    }

    public static int readClassTrain() {
        System.out.println("Введіть клас поїзда");
        String classTrain = scanner.nextLine();
        if (classTrain.matches("([/^[1-3]$/])")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readClassTrain();
        }
        return Integer.parseInt(classTrain);
    }

    public static String readStatusTrain() {
        System.out.println("Введіть статус поїзда");
        String statusTrain = scanner.nextLine();
        if (statusTrain.matches("([А-ЯҐІЇ{1}\\s][а-яґії{30}\\s]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readStatusTrain();
        }
        return statusTrain;
    }
}
