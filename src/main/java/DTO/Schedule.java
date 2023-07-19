package DTO;

import java.util.Scanner;

public class Schedule {
    public int idSchedule;
    public String timeArrival;
    public String timeDeparture;
    public String dayWeek;
    public int trip;
    public int idRoute;
    public int idStation;

    /*private static final String Time_Date_PATTERN = "^(([0,1][0-9])|(2[0-3])):[0-5][0-9]\\s(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)$";*/
    private static final String Time_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    Scanner scanner = new Scanner(System.in);

    public void readDeparture() {
        System.out.println("Введіть час та дату ВІДПРАВЛЕННЯ у форматі HH:MM:SS");
        timeArrival = scanner.nextLine();
        if (timeArrival.matches(Time_PATTERN)) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readDeparture();
        }
    }

    public void readArrival() {
        System.out.println("Введіть час та дату ПРИБУТТЯ у форматі HH:MM:SS");
        timeArrival = scanner.nextLine();
        if (timeArrival.matches(Time_PATTERN)) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readArrival();
        }
    }

    @Override
    public String toString() {
        return  "idSchedule =" + idSchedule +
                ", arrival = '" + timeArrival + '\'' +
                ", departure = '" + timeDeparture + '\'' +
                ", trip = " + trip +
                ", day_week = " + dayWeek +
                ", id_route = " + idRoute +
                ", id_station = " + idStation;
    }
}
