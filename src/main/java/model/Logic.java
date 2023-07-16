package model;

import DAO.ScoreboardDAO;
import DAO.TrainDAO;
import DTO.Scoreboard;
import DTO.Train;
import checkObject.CheckTrain;
import consoleViewers.Controller;
import consoleViewers.ScoreboardConsole;
import consoleViewers.TimeTableConsole;
import consoleViewers.TrainConsole;

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

            }

        }
    }

}
