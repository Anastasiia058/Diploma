package model;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Controller {

    private static final String HH_MM_SS_PATTERN = "(?:[01]\\d|2[0-3]):(?:[0-5]\\d):(?:[0-5]\\d)";
    private static final String HH_MM_PATTERN = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    private static final String HH_PATTERN = "^(0[0-9]|1[0-9]|2[0-3])$";
    private static final String DAY_WEEK_PATTERN = "^(Пн|Вт|Ср|Чт|Пт|Сб|Нд)$";
    static Scanner scanner = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println("Вітаємо у системі. Ця програма допоможе вам дізнатися інформацію про проведення посадки на потяги, " +
                "стан потягів, попередить про настання аварійної ситуації." +
                "Оберіть ваш статус у системі:" +
                "1. Пасажир" +
                "2. Адміністратор");

    }
    public static int chooseAction() {
        System.out.println("Оберіть потрібну дію.\n" +
                "1. Дізнатися рух поїздів на станції \n" +
                "2. Розклад та статус потягу \n" +
                "3. Внесення змін у систему (доступ лише після введення паролю)");
        String command =  scanner.nextLine();
        if (!StringUtils.isNumeric(command)){
            System.out.println("Невірна команда");
            chooseAction();
        }
        return Integer.parseInt(command);
    }

    public static int chooseScheduleAction() {
        System.out.println("Оберіть потрібну дію.\n" +
                "1. Додати станцію у маршрут \n" +
                "2. Змінити станцію у маршрут \n" +
                "3. Видалити станцію у маршруті");
        String command =  scanner.nextLine();
        if (!StringUtils.isNumeric(command)){
            System.out.println("Невірна команда");
            chooseScheduleAction();
        }
        return Integer.parseInt(command);
    }

    public static int chooseAdminAction() {
        System.out.println("Оберіть потрібну дію.\n" +
                "1. Додати  потяг\n" +
                "2. Редагувати потяг\n" +
                "3. Видалити потяг\n" +
                "4. Додати маршрут\n" +
                "5. Редагувати маршрут\n" +
                "6. Видалити маршрут\n" +
                "7. Додати станцію\n" +
                "8. Редагувати станцію\n" +
                "9. Видалити станцію\n" +
                "0. Вийти з адмін-консолі\n");
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
        System.out.println("Введіть час від. Наприклад, 09:00:00 або 9  Наприклад 22 або 22:10 для годин та хвилин");
        String time = scanner.nextLine();
        if (StringUtils.isNumeric(time)){
            Integer timeInt = Integer.parseInt(time);
            if (timeInt >= 0 && timeInt <= 99){
                return timeInt + ":00:00";
            }
        }
        return time;
    }

    public static String readDayWeek() {
        System.out.println("Введіть час відправлення від у форматі Пн, Вт, Ср, Чт, Пт, Сб або Нд");
        String dayWeek = scanner.nextLine();
        if (dayWeek.matches(DAY_WEEK_PATTERN)) {
            System.out.println("Дані прийнято " + dayWeek);
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readDayWeek();
        }
        return dayWeek;
    }

    public static int readTrainTrip() {
        System.out.println("яка це поїздка для цього паршруту");
        String trip = scanner.nextLine();
        if (trip.matches("^\\d+$")) {
            System.out.println("Дані прийнято " + trip);
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readTrainTrip();
        }
        return Integer.parseInt(trip);
    }

    public static String readTime() {
        System.out.println("Введіть час відправлення від у форматі HH:MM:SS або HH:MM або HH");
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

    public static String chooseCheckDay() {
        System.out.println("Введіть день тижня. Наприклад Пн або Ср");
        return scanner.nextLine();
    }

    public static String readPassword() {
        System.out.println("Для того, щоб внести зміни у систему, введіть, будь ласка, пароль");
        return scanner.nextLine();
    }
}
