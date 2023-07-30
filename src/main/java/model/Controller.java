package model;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Controller {

    private static final String DAY_WEEK_PATTERN = "^(Пн|Вт|Ср|Чт|Пт|Сб|Нд)$";
    static Scanner scanner = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println("Вітаємо у системі. Ця програма допоможе вам дізнатися інформацію \nпро проведення посадки на потяги, " +
                "стан потягів, попередить \nпро настання аварійної ситуації.\n" + "\n");
    }

    public static int chooseAction() {
        System.out.println("Вітаємо у системі. Ця програма допоможе вам дізнатися інформацію \nпро проведення посадки на потяги, " +
                "стан потягів, попередить \nпро настання аварійної ситуації.\n" + "\n" +
                "Оберіть потрібну дію.\n" +
                "1. Дізнатися рух поїздів на станції \n" +
                "2. Розклад та статус потягу \n" +
                "3. Внесення змін у систему (доступ лише після введення паролю)\n");
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
        System.out.println("\nОберіть потрібну дію.\n" +
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
        System.out.println("\nВведіть назву станції, з якої плануєте відправлятись.\n");
        return scanner.nextLine();
    }
    public static String chooseNameRoute() {
        System.out.println("\nВведіть маршрут. Наприклад, Київ-Харків.\n");
        return scanner.nextLine();
    }
    public static String chooseTimeArrival() {
        System.out.println("\nВведіть час від. Наприклад 22, або 22:10 для годин та хвилин\n");
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
        System.out.println("\nФормат введення: Пн, Вт, Ср, Чт, Пт, Сб або Нд\n");
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
        System.out.println("Яка це поїздка для цього маршруту");
        String trip = scanner.nextLine();
        if (trip.matches("^\\d+$")) {
            System.out.println("Дані прийнято " + trip);
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readTrainTrip();
        }
        return Integer.parseInt(trip);
    }

    public static int readIdTrack() {
        System.out.println("Введіть колію, з якого буде відправлятися потяг на станції");
        String track = scanner.nextLine();
        if (track.matches("^\\d+$")) {
            System.out.println("Дані прийнято " + track);
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readIdTrack();
        }
        return Integer.parseInt(track);
    }

    public static String chooseCheckDay() {
        System.out.println("\nВведіть день тижня. Наприклад Пн або Ср\n");
        return scanner.nextLine();
    }

    public static String readPassword() {
        System.out.println("\nДля того, щоб внести зміни у систему, введіть, будь ласка, пароль\n");
        return scanner.nextLine();
    }
}
