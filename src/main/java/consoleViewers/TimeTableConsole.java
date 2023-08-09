package consoleViewers;

import DTO.Scoreboard;

import java.util.ArrayList;

public class TimeTableConsole {
    public static void print(ArrayList<Scoreboard> scoreboards) {
        if (scoreboards == null) {
            System.out.println("Поїзд курсує в інший день. Спробуйте ще раз");
            return;
        }

        System.out.println("\n");
        System.out.println("Потяг: "+  scoreboards.get(0).nameTrain);
        System.out.println("Стан потягу: " + scoreboards.get(0).statusTrain);
        System.out.println("\n");
        System.out.println(String.format(
                "%1$25s | %2$12s | %3$12s | %4$8s |",
                "Станція", "Прибуття", "Відправлення", "День"));
        System.out.println("----------------------------------------------------------------------");
        for (Scoreboard table : scoreboards) {
            System.out.println(String.format(
                    "%1$25s | %2$12s | %3$12s | %4$8s |",
                    table.nameStation, table.timeArrival, table.timeDeparture, table.dayWeek));
        }
        System.out.println("\n");
    }

    public static void printWithId(ArrayList<Scoreboard> scoreboards) {
        if (scoreboards == null) {
            System.out.println("Поїзд курсує в інший день. Спробуйте ще раз");
            return;
        }

        System.out.println("\n");
        System.out.println("Потяг: "+  scoreboards.get(0).nameTrain);
        System.out.println("Стан потягу: " + scoreboards.get(0).statusTrain);
        System.out.println("\n");
        System.out.println(String.format(
                "%1$11s | %2$25s | %3$12s | %4$12s | %5$8s |",
                "Id розкладу", "Станція", "Прибуття", "Відправлення", "День"));
        System.out.println("----------------------------------------------------------------------");
        for (Scoreboard scoreboard : scoreboards) {
            System.out.println(String.format(
                    "%1$11s | %2$25s | %3$12s | %4$12s | %5$8s |",
                    scoreboard.idSchedule, scoreboard.nameStation, scoreboard.timeArrival, scoreboard.timeDeparture, scoreboard.dayWeek));
        }
        System.out.println("\n");
    }
}
