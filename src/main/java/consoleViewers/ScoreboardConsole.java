package consoleViewers;

import DTO.Scoreboard;

import java.util.ArrayList;

public class ScoreboardConsole {

    public static void printScoreboardConsole(ArrayList<Scoreboard> scoreboards) {
        System.out.println(String.format(
                "%1$6s | %2$18s |  %3$18s | %4$12s | %5$12s | %6$16s | %7$7s | %8$12s",
                "№", "Поїзд", "Маршрут", "День тижня", "Час прибуття", "Час відправлення", "№ Колії", "Cтан потяга"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        for (Scoreboard scoreboard : scoreboards) {
            System.out.println(String.format(
                    "%1$6d | %2$18s | %3$18s | %4$12s | %5$12s | %6$16s | %7$7s | %8$12s",
                    scoreboard.idRoute, scoreboard.nameTrain, scoreboard.nameRoute, scoreboard.dayWeek, scoreboard.timeArrival, scoreboard.timeDeparture, scoreboard.trackNumber, scoreboard.statusTrain));
        }
        System.out.println("\n");
    }

    public static void printScoreboardConsoleWithRoute(ArrayList<Scoreboard> scoreboards) {
        System.out.println(String.format(
                "%1$6s | %2$18s |  %3$18s | %4$12s | %5$20s | %6$11s | %7$20s ",
                "№", "Поїзд", "Маршрут", "День тижня", "Порядковий № поїздки", "ID станції", "Назва станції"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        for (Scoreboard scoreboard : scoreboards) {
            System.out.println(String.format(
                    "%1$6d | %2$18s | %3$18s | %4$12s | %5$20s | %6$11s | %7$20s ",
                    scoreboard.idRoute, scoreboard.nameTrain, scoreboard.nameRoute, scoreboard.dayWeek, scoreboard.trip, scoreboard.idStation, scoreboard.nameStation));
        }
        System.out.println("\n");
    }
}
