package model;

import DAO.*;
import DTO.*;
import checkObject.CheckAnswer;
import checkObject.CheckSchedule;
import checkObject.CheckStation;
import consoleViewers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleLogic {

    static ScoreboardDAO scoreboardDAO = new ScoreboardDAO();
    static StationDAO stationDAO= new StationDAO();

    static ScheduleDAO scheduleDAO = new ScheduleDAO();

    public static void chooseScheduleCommand(Route route) throws SQLException, ClassNotFoundException {
        ArrayList<Scoreboard> scoreboards = scoreboardDAO.readTimeTableByIdRoute(route.idRoute);
        ScoreboardConsole.print(scoreboards);
        int command = Controller.chooseScheduleAction();
        if (command == 1) {
            System.out.println("\n");
            ArrayList<Station> stations = stationDAO.readAllStations();
            StationConsole.print(stations);
            System.out.println("\n");
            System.out.println("Введіть id станції");
            Integer idStation = CheckStation.readIdStation();

            System.out.println("Введіть час прибуття на станцію");
            String timeArrival = CheckSchedule.readTime();

            System.out.println("Введіть час відправлення зі станції");
            String timeDeparture = CheckSchedule.readTime();

            System.out.println("Введіть день тижня");
            String day = Controller.readDayWeek();

            System.out.println("Введіть яка поїздка для поїзда");
            Integer trip = Controller.readTrainTrip();

            Schedule schedule  = new Schedule();
            schedule.idRoute = route.idRoute;
            schedule.idStation =  idStation;
            schedule.trip = trip;
            schedule.timeArrival =  timeArrival;
            schedule.timeDeparture = timeDeparture;
            schedule.dayWeek = day;

            System.out.println("\n До маршруту номер " + route.idRoute + " " + route.nameRoute + " буде добавленя зупинка " + schedule.toString() + ". \n Ви підтвердуєте?");
            if (CheckAnswer.check()){
                scheduleDAO.createSchedule(schedule);
                System.out.println("Новий розклад маршруту номер " + route.idRoute + " " + route.nameRoute);
                StationConsole.print(stationDAO.readAllStations());
            }

            chooseScheduleCommand(route);
        }



        }


    
}
