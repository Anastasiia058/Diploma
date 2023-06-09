package consoleViewers;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Controller {
    static Scanner scanner = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println("Вітаємо у системі. Ця програма допоможе вам дізнатися інформацію про проведення посадки на потяги, " +
                "стан потягів, попередить про настання аварійної ситуації.");
    }
    public static int chooseAction() {
        System.out.println("Оберіть потрібну дію.\n" +
                "1. Дізнатися рух поїздів на станції \n" +
                "2. Розклад та статус потягу");
        String command =  scanner.nextLine();
        if (!StringUtils.isNumeric(command)){
            System.out.println("Невірна команда");
            chooseAction();
        }
        return Integer.parseInt(command);
    }
    public static String chooseNameStation() {
        System.out.println("Введіть назву станції, з якої плануєте відправлятись.");
        return scanner.nextLine();
    }
    public static String chooseNameRoute() {
        System.out.println("Введіть маршрут. Наприклад, Київ-Харків.");
        return scanner.nextLine();
    }
    public static String chooseTimeArrival() {
        System.out.println("Введіть час від. Наприклад, 09:00:00 або перші 2 цифри для годин. Наприклад 22");
        String time = scanner.nextLine();
        if (StringUtils.isNumeric(time)){
            Integer timeInt = Integer.parseInt(time);
            if (timeInt >= 0 && timeInt <= 99){
                return timeInt + ":00:00";
            }
        }
        return time;
    }

    public static String chooseCheckDay() {
        System.out.println("Введіть день тижня. Наприклад Пн або Ср");
        return scanner.nextLine();
    }

}
