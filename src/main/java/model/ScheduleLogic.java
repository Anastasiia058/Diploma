package model;

import DAO.*;
import DTO.*;
import checkObject.CheckAnswer;
import checkObject.CheckSchedule;
import checkObject.CheckStation;
import checkObject.CheckTrain;
import consoleViewers.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleLogic {

    static ScoreboardDAO scoreboardDAO = new ScoreboardDAO();
    static StationDAO stationDAO = new StationDAO();
    static ScheduleDAO scheduleDAO = new ScheduleDAO();

    public static void addStationScheduleCommand(Route route) throws SQLException, ClassNotFoundException {
        ArrayList<Scoreboard> scoreboards = scoreboardDAO.readTimeTableByIdRoute(route.idRoute);
        ScoreboardConsole.print(scoreboards);
        int command = Controller.chooseScheduleAction();
        if (command == 1) {
            ArrayList<Station> stations = stationDAO.readAllStations();
            StationConsole.print(stations);
            Integer idStation = CheckStation.readIdStation();
            System.out.println("Введіть час прибуття на станцію");
            String timeArrival = CheckSchedule.readTime();
            System.out.println("Введіть час відправлення зі станції");
            String timeDeparture = CheckSchedule.readTime();
            String day = Controller.readDayWeek();
            Integer trip = Controller.readTrainTrip();
            Integer track = Controller.readIdTrack();

            Schedule schedule = new Schedule();
            schedule.idRoute = route.idRoute;
            schedule.idStation = idStation;
            schedule.trip = trip;
            schedule.timeArrival = timeArrival;
            schedule.timeDeparture = timeDeparture;
            schedule.dayWeek = day;
            schedule.idTrack = track;

            System.out.println("До маршруту номер " + route.idRoute + " " + route.nameRoute + " буде добавленя зупинка " + schedule.toString() + ". \n Ви підтверджуєте?");
            if (CheckAnswer.check()) {
                scheduleDAO.createSchedule(schedule);
                System.out.println("Новий розклад маршруту номер " + route.idRoute + " " + route.nameRoute);
                ScoreboardConsole.print(scoreboardDAO.readTimeTableByIdRoute(route.idRoute));
                Controller.chooseScheduleAction();
            }

            addStationScheduleCommand(route);
        }

        if (command == 2) {
            AdminLogic.chooseAdminCommand();

        }
    }

    public static void updateStationScheduleCommand(Route route) throws SQLException, ClassNotFoundException {
        ArrayList<Scoreboard> scoreboards = scoreboardDAO.readTimeTableByIdRoute(route.idRoute);
        ScoreboardConsole.print(scoreboards);
        int command = Controller.chooseFullScheduleAction();
        if (command == 1) {
            ArrayList<Station> stations = stationDAO.readAllStations();
            StationConsole.print(stations);
            Integer idStation = CheckStation.readIdStation();
            System.out.println("Введіть час прибуття на станцію");
            String timeArrival = CheckSchedule.readTime();
            System.out.println("Введіть час відправлення зі станції");
            String timeDeparture = CheckSchedule.readTime();
            String day = Controller.readDayWeek();
            Integer trip = Controller.readTrainTrip();
            Integer track = Controller.readIdTrack();

            Schedule schedule = new Schedule();
            schedule.idRoute = route.idRoute;
            schedule.idStation = idStation;
            schedule.trip = trip;
            schedule.timeArrival = timeArrival;
            schedule.timeDeparture = timeDeparture;
            schedule.dayWeek = day;
            schedule.idTrack = track;

            System.out.println("До маршруту номер " + route.idRoute + " " + route.nameRoute + " буде добавленя зупинка " + schedule.toString() + ".\n " +
                    "Ви підтверджуєте?");

            if (CheckAnswer.check()) {
                scheduleDAO.createSchedule(schedule);
                System.out.println("Новий розклад маршруту номер " + route.idRoute + " " + route.nameRoute);
                ScoreboardConsole.print(scoreboardDAO.readTimeTableByIdRoute(route.idRoute));
                Controller.chooseScheduleAction();
            }

            updateStationScheduleCommand(route);
        }

        if (command == 2) {
            ArrayList<Station> stations = stationDAO.readAllStations();
            StationConsole.print(stations);
            Integer idStation = CheckStation.readIdStation();
            System.out.println("Введіть час прибуття на станцію");
            String timeArrival = CheckSchedule.readTime();
            System.out.println("Введіть час відправлення зі станції");
            String timeDeparture = CheckSchedule.readTime();
            String day = Controller.readDayWeek();
            Integer trip = Controller.readTrainTrip();
            Integer track = Controller.readIdTrack();

            Schedule schedule = new Schedule();
            schedule.idRoute = route.idRoute;
            schedule.idStation = idStation;
            schedule.trip = trip;
            schedule.timeArrival = timeArrival;
            schedule.timeDeparture = timeDeparture;
            schedule.dayWeek = day;
            schedule.idTrack = track;

            System.out.println("У маршруті номер " + route.idRoute + " " + route.nameRoute + " буде оновлена зупинка " + schedule.toString() + ". \n Ви підтверджуєте?");
            if (CheckAnswer.check()) {
                scheduleDAO.updateSchedule(schedule);
                System.out.println("Новий розклад маршруту номер " + route.idRoute + " " + route.nameRoute);
                ScoreboardConsole.print(scoreboardDAO.readTimeTableByIdRoute(route.idRoute));
                Controller.chooseScheduleAction();
            }
            updateStationScheduleCommand(route);
        }

            if (command == 3) {
                ArrayList<Scoreboard> scoreboards1 = scoreboardDAO.readTimeTableByIdRoute(route.idRoute);
                TimeTableConsole.printWithId(scoreboards1);
                Integer idSchedule = CheckSchedule.readIdSchedule();
                Schedule schedule1 = scheduleDAO.findScheduleById(idSchedule);
                Integer idStation = schedule1.idStation;
                Station station = stationDAO.findStationByID(idStation);
                System.out.println("У маршруті номер " + route.idRoute + " " + route.nameRoute + " буде видалена зупинка " + station.nameStation + ". \n Ви підтверджуєте?");
                if (CheckAnswer.check()) {
                scheduleDAO.deleteScheduleByID(idSchedule);
                    System.out.println("Актуальні зупинки маршруту: " + route.idRoute + " " + route.nameRoute);
                ArrayList<Scoreboard> scoreboards2 = scoreboardDAO.readTimeTableByIdRoute(route.idRoute);
                TimeTableConsole.printWithId(scoreboards2);
                }
                updateStationScheduleCommand(route);
        }
            if (command == 4) {
                Controller.chooseAdminAction();
            }
    }
}

