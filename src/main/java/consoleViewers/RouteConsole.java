package consoleViewers;

import DTO.Route;
import DTO.Train;

import java.util.ArrayList;

public class RouteConsole {
    public static void print(ArrayList<Route> routs) {
        System.out.println(String.format(
                "%1$4s | %2$25s ",
                "id", "Назва маршруту"));
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Route route : routs) {
            System.out.println(String.format(
                    "%1$4d | %2$25s",
                    route.idRoute, route.nameRoute));
        }
        System.out.println("\n");
    }
}
