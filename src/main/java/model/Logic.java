package model;

import DAO.RouteDAO;
import DAO.ScoreboardDAO;
import DAO.TrainDAO;
import DAO.TrainHasRouteDAO;
import DTO.Route;
import DTO.Scoreboard;
import DTO.Train;
import DTO.TrainHasRoute;
import checkObject.CheckAnswer;
import checkObject.CheckRoute;
import checkObject.CheckTrain;
import consoleViewers.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    String nameTrain = CheckTrain.readNameTrain();
                    String typeTrain = CheckTrain.readTypeTrain();
                    Integer classTrain = CheckTrain.readClassTrain();
                    String statusTrain = CheckTrain.readStatusTrain();
                    Train train = new Train();
                    train.nameTrain = nameTrain;
                    train.typeTrain = typeTrain;
                    train.classTrain = classTrain;
                    train.statusTrain = statusTrain;
                    TrainDAO trainDAO = new TrainDAO();
                    trainDAO.createTrain(train);}
                if (adminCommand == 2) {
                    TrainDAO trainDAO = new TrainDAO();
                    ArrayList<Train> trainList = trainDAO.readAllTrains();
                    TrainConsole.print(trainList);
                        Integer idTrain = CheckTrain.readIdTrain();
                        String nameTrain = CheckTrain.readNameTrain();
                        String typeTrain = CheckTrain.readTypeTrain();
                        Integer classTrain = CheckTrain.readClassTrain();
                        String statusTrain = CheckTrain.readStatusTrain();
                        Train train = new Train();
                        train.idTrain = idTrain;
                        train.nameTrain = nameTrain;
                        train.typeTrain = typeTrain;
                        train.classTrain = classTrain;
                        train.statusTrain = statusTrain;
                        trainDAO.updateTrain(train);}
                if (adminCommand == 3) {
                    TrainDAO trainDAO = new TrainDAO();
                    ArrayList<Train> trainList = trainDAO.readAllTrains();
                    TrainConsole.print(trainList);
                    Integer idTrain = CheckTrain.readIdTrain();
                    trainDAO.deleteTrainByID(idTrain);}
                if (adminCommand == 4) {
                    Integer idRoute = CheckRoute.readIdRoute();
                    String nameRoute = CheckRoute.readNameRoute();
                    Route route  = new Route();
                    route.idRoute =  idRoute;
                    route.nameRoute = nameRoute;
                    RouteDAO routeDAO = new RouteDAO();
                    routeDAO.createRoute(route);
                    System.out.println("Бажаєте підв'язати маршрут до потяга?");
                    if (CheckAnswer.check()){
                        TrainDAO trainDAO = new TrainDAO();
                        ArrayList<Train> trainList = trainDAO.readAllTrains();
                        TrainConsole.print(trainList);
                        Integer idTrain = CheckTrain.readIdTrain();
                        TrainHasRoute trainHasRoute = new TrainHasRoute();
                        trainHasRoute.idTrain = idTrain;
                        trainHasRoute.idRoute = idRoute;
                        TrainHasRouteDAO trainHasRouteDAO = new TrainHasRouteDAO();
                        trainHasRouteDAO.createTrainHasRoute(trainHasRoute);
                    }
                }
                if (adminCommand == 5) {
                    RouteDAO routeDAO = new RouteDAO();
                    ArrayList<Route> routeList = routeDAO.readAllRoutes();
                    RouteConsole.print(routeList);
                    Integer idRoute = CheckRoute.readIdRoute();
                    String nameRoute = CheckRoute.readNameRoute();
                    Route route = new Route();
                    route.idRoute = idRoute;
                    route.nameRoute= nameRoute;
                    routeDAO.updateRoute(route);}



                }

        }
    }

}
