package model;

import DAO.ScoreboardDAO;
import DTO.Scoreboard;
import DTO.Train;
import checkObject.CheckTrain;
import consoleViewers.Controller;
import consoleViewers.ScoreboardConsole;
import consoleViewers.TimeTableConsole;

import java.sql.SQLException;
import java.util.ArrayList;

public class Logic {

    static ScoreboardDAO scoreboardDAO = new ScoreboardDAO();
    public static void chooseCommand() throws SQLException, ClassNotFoundException {
        int command = Controller.chooseAction();
        if (command == 1) {
            String nameStation = Controller.chooseNameStation();
            String timeArrival = Controller.chooseTimeArrival();
            ArrayList<Scoreboard> scoreboards = scoreboardDAO.readScoreboardsByStationNameAndArrival(nameStation, timeArrival);
            ScoreboardConsole.print(scoreboards);
            chooseCommand();
        }
        if (command == 2) {
            String nameRoute = Controller.chooseNameRoute();
            String nameDay = Controller.chooseCheckDay();
            ArrayList<Scoreboard> timeTable = scoreboardDAO.readTimeTableByNameRoute(nameRoute, nameDay);
            TimeTableConsole.print(timeTable);
            chooseCommand();
        }

        if (command == 3) {
            String password = Controller.readPassword();
            if (!password.equals("root")) {
                System.out.println("Пароль невірний");
                chooseCommand();
            }
            else {
                int adminCommand = Controller.chooseAdminAction();
                if (adminCommand == 1) {
                    String nameTrain = CheckTrain.readTrain();





                }
                    String nameStation = Controller.chooseNameStation();
                    String timeArrival = Controller.chooseTimeArrival();
                    ArrayList<Scoreboard> scoreboards = scoreboardDAO.readScoreboardsByStationNameAndArrival(nameStation, timeArrival);
                    ScoreboardConsole.print(scoreboards);
                    chooseCommand();
            }

        }
    }

}
