package model;

import DAO.*;
import DTO.*;
import checkObject.CheckAnswer;
import checkObject.CheckRoute;
import checkObject.CheckStation;
import checkObject.CheckTrain;
import consoleViewers.RouteConsole;
import consoleViewers.ScoreboardConsole;
import consoleViewers.StationConsole;
import consoleViewers.TrainConsole;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminLogic {

    public static void chooseAdminCommand() throws SQLException, ClassNotFoundException{

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
            trainDAO.createTrain(train);
            chooseAdminCommand();
        }
        if (adminCommand == 2) {
            TrainDAO trainDAO = new TrainDAO();
            ArrayList<Train> trainList = trainDAO.readAllTrains();
            TrainConsole.printTrainConsole(trainList);
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
            trainDAO.updateTrain(train);
            chooseAdminCommand();
        }
        if (adminCommand == 3) {
            TrainDAO trainDAO = new TrainDAO();
            ArrayList<Train> trainList = trainDAO.readAllTrains();
            TrainConsole.printTrainConsole(trainList);
            Integer idTrain = CheckTrain.readIdTrain();
            trainDAO.deleteTrainByID(idTrain);
            chooseAdminCommand();
        }
        if (adminCommand == 4) {
            RouteDAO routeDAO = new RouteDAO();
            ArrayList<Route> routeList = routeDAO.readAllRoutes();
            RouteConsole.printRouteConsole(routeList);
            Integer idRoute = CheckRoute.readIdRoute();
            String nameRoute = CheckRoute.readNameRoute();
            Route route  = new Route();
            route.idRoute =  idRoute;
            route.nameRoute = nameRoute;
            RouteDAO routeDAO1 = new RouteDAO();
            routeDAO1.createRoute(route);
            System.out.println("Маршрут створено "+ route.toString());
            System.out.println("Бажаєте додати станції у маршрут?");
            if (CheckAnswer.check()) {
                ScheduleLogic.addStationScheduleCommand(route);
            }
            System.out.println("Бажаєте підв'язати маршрут до потяга?");
            if (CheckAnswer.check()){
                TrainDAO trainDAO = new TrainDAO();
                ArrayList<Train> trainList = trainDAO.readAllTrains();
                TrainConsole.printTrainConsole(trainList);
                Integer idTrain = CheckTrain.readIdTrain();
                TrainHasRoute trainHasRoute = new TrainHasRoute();
                trainHasRoute.idTrain = idTrain;
                trainHasRoute.idRoute = idRoute;
                TrainHasRouteDAO trainHasRouteDAO = new TrainHasRouteDAO();
                trainHasRouteDAO.createTrainHasRoute(trainHasRoute);
            }
            chooseAdminCommand();
        }
        if (adminCommand == 5) {
            RouteDAO routeDAO = new RouteDAO();
            ArrayList<Route> routeList = routeDAO.readAllRoutes();
            RouteConsole.printRouteConsole(routeList);
            Integer idRoute = CheckRoute.readIdRoute();
            String nameRoute = CheckRoute.readNameRoute();
            Route route = new Route();
            route.idRoute = idRoute;
            route.nameRoute= nameRoute;
            routeDAO.updateRoute(route);
            System.out.println("Бажаєте додати/змінити/видалити станції у маршрут");
            if (CheckAnswer.check()) {
                ScheduleLogic.updateStationScheduleCommand(route);
            }
            chooseAdminCommand();
        }
        if (adminCommand == 6) {
            RouteDAO routeDAO = new RouteDAO();
            ArrayList<Route> routeList = routeDAO.readAllRoutes();
            RouteConsole.printRouteConsole(routeList);
            Integer idRoute = CheckRoute.readIdRoute();
            routeDAO.deleteRouteByID(idRoute);
            chooseAdminCommand();
        }
        if (adminCommand == 7) {
            String nameStation = CheckStation.readNameStation();
            Station station= new Station();
            station.nameStation = nameStation;
            StationDAO stationDAO = new StationDAO();
            stationDAO.createStation(station);
            chooseAdminCommand();
        }
        if (adminCommand == 8) {
            StationDAO stationDAO = new StationDAO();
            ArrayList<Station> stationList = stationDAO.readAllStations();
            StationConsole.printStationConsole(stationList);
            Integer idStation = CheckStation.readIdStation();
            String nameStation = CheckStation.readNameStation();
            Station station = new Station();
            station.idStation = idStation;
            station.nameStation = nameStation;
            stationDAO.updateStation(station);
            chooseAdminCommand();
        }
        if (adminCommand == 9) {
            StationDAO stationDAO = new StationDAO();
            ArrayList<Station> stationList = stationDAO.readAllStations();
            StationConsole.printStationConsole(stationList);
            Integer idStation = CheckStation.readIdStation();
            ArrayList<Scoreboard> routs = ScoreboardDAO.findRouteByStationId(idStation);
            if (routs.isEmpty()){
                stationDAO.deleteStationByID(idStation);
                System.out.println("Станцію видалено з бази даних");
            } else {
                System.out.println("Дану станцію неможливо видалити з бази даних, оскільки існують потяг/-и, що курсують через неї");
                ScoreboardConsole.printScoreboardConsoleWithRoute(routs);
                System.out.println("Будь ласка, оберіть '5. Редагувати маршрут', щоб скорегувати зупинки потяга у маршруті, а потім поверніться до '9. Видалити станцію'");
            }
            chooseAdminCommand();
        }
    }
}
