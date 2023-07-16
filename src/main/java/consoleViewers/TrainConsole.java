package consoleViewers;

import DTO.Scoreboard;
import DTO.Train;

import java.util.ArrayList;

public class TrainConsole {
    public static void print(ArrayList<Train> trains) {
        System.out.println(String.format(
                "%1$4s | %2$25s |  %3$20s |%4$12s | %5$16s",
                "№", "Назва поїзда", "Тип", "Клас поїзда", "Статус потяга"));
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Train train : trains) {
            System.out.println(String.format(
                    "%1$4d | %2$25s | %3$18s | %4$12s | %5$16s",
                    train.idTrain, train.nameTrain, train.typeTrain, train.classTrain, train.statusTrain));
        }
        System.out.println("\n");
    }
}
