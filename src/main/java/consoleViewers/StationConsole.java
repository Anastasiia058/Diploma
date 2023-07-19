package consoleViewers;

import DTO.Station;
import DTO.Train;

import java.util.ArrayList;

public class StationConsole {
    public static void print(ArrayList<Station> stations) {
        System.out.println(String.format(
                "%1$4s | %2$25s",
                "id", "Назва станції"));
        System.out.println("-----------------------------------------");
        for (Station station : stations) {
            System.out.println(String.format(
                    "%1$4d | %2$25s",
                    station.idStation, station.nameStation));
        }
        System.out.println("\n");
    }
}
