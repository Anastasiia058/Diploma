package checkObject;

import model.Controller;

import java.util.Scanner;

public class CheckSchedule {
    private static final String HH_MM_SS_PATTERN = "(?:[01]\\d|2[0-3]):(?:[0-5]\\d):(?:[0-5]\\d)";
    private static final String HH_MM_PATTERN = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    private static final String HH_PATTERN = "^(0[0-9]|1[0-9]|2[0-3])$";
    static Scanner scanner = new Scanner(System.in);

    public static String readTime() {
        System.out.println("Формат введення: HH:MM:SS або HH:MM або HH");
        String timeArrival = scanner.nextLine();
        if (timeArrival.matches(HH_MM_SS_PATTERN)) {
            System.out.println("Дані прийнято " + timeArrival);
            return timeArrival;
        } else if (timeArrival.matches(HH_MM_PATTERN)){
            timeArrival = timeArrival + ":00";
        } else if (timeArrival.matches(HH_PATTERN)){
            timeArrival = timeArrival + ":00:00";
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readTime();
        }
        System.out.println("Дані прийнято " + timeArrival);
        return timeArrival;
    }

    public static Integer readIdSchedule() {
        System.out.println("Введіть id запису розкладу");
        String idSchedule = scanner.nextLine();
        if (idSchedule.matches("^\\d+$")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readIdSchedule();
        }
        return Integer.parseInt(idSchedule);
    }
}