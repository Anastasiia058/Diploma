package consoleViewers;

import DTO.Scoreboard;

import java.util.ArrayList;

public class ScoreboardConsole {

    public static void print(ArrayList<Scoreboard> scoreboards) {
        System.out.println(String.format(
                "%1$4s | %2$10s |  %3$18s |%4$12s | %5$16s | %6$7s | %7$12s",
                "№", "Поїзд", "Маршрут", "Час прибуття", "Час відправлення", "№ Колії", "Cтан потяга"));
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Scoreboard scoreboard : scoreboards) {
            System.out.println(String.format(
                    "%1$4d | %2$10s | %3$18s | %4$12s | %5$16s | %6$7s | %7$12s",
                    scoreboard.idRoute, scoreboard.nameTrain, scoreboard.nameRoute, scoreboard.timeArrival, scoreboard.timeDeparture, scoreboard.trackNumber, scoreboard.statusTrain));
        }
        System.out.println("\n");
    }

}
