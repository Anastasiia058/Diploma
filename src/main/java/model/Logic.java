package model;

import DAO.*;
import DTO.*;
import consoleViewers.*;

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
            ScoreboardConsole.printScoreboardConsole(scoreboards);
            chooseCommand();
        }
        if (command == 2) {
            String nameRoute = Controller.chooseNameRoute();
            String nameDay = Controller.chooseCheckDay();
            ArrayList<Scoreboard> timeTable = scoreboardDAO.readTimeTableByNameRouteAndDayWeek(nameRoute, nameDay);
            TimeTableConsole.printTimeTableConsole(timeTable);
            chooseCommand();
        }

        if (command == 3) {
            String password = Controller.readPassword();
            if (!password.equals("root")) {
                System.out.println("Пароль невірний");
                chooseCommand();
            }
            else {
                AdminLogic.chooseAdminCommand();
            }
        }
    }
}
