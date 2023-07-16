package DAO;

import DTO.Train;
import DTO.TrainHasRoute;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainHasRouteDAO {
    public static Statement statement;

    private static Scanner scanner = new Scanner(System.in);
    public TrainHasRouteDAO() {

        statement = DataBase.getStatement();
    }

    public void createTrainHasRoute(TrainHasRoute scoreboard) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("INSERT INTO train_has_route (id_train, id_route) values ('" +
                scoreboard.idTrain + "', '" +
                scoreboard.idRoute + "')");
    }

    public ArrayList<TrainHasRoute> readAllTrainsWithRouts() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM train_has_route");
        ArrayList<TrainHasRoute> trainsWithRouts = new ArrayList<>();
        while(resultSet.next()) {
            TrainHasRoute trainWithRouts = new TrainHasRoute();
            trainWithRouts.idTrain = resultSet.getInt("id_train");
            trainWithRouts.idRoute = resultSet.getInt("id_route");
            trainsWithRouts.add(trainWithRouts);
        }
        return trainsWithRouts;
    }

    public TrainHasRoute findTrainWithRoutsByID (int idTrain) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train_has_rout where id_train=" + idTrain);
            if (resultSet.next()) {
                TrainHasRoute trainWithRouts = new TrainHasRoute();
                trainWithRouts.idTrain = resultSet.getInt("id_train");
                trainWithRouts.idRoute = resultSet.getInt("id_route");
                return trainWithRouts;
            }
            else throw new SQLException("Поїзда з id = " + idTrain + " не існує.");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TrainHasRoute updateTrainHasRoute (TrainHasRoute scoreboard) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            boolean execute = statement.execute("UPDATE train_has_route SET id_train = '" +
                    scoreboard.idTrain +
                    "', id_route = '" +
                    scoreboard.idRoute);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train_has_route where id_train=" + scoreboard.idTrain);
            if (resultSet.next()) {
                TrainHasRoute newTrainHasRoute = new TrainHasRoute();
                newTrainHasRoute.idTrain = resultSet.getInt("id_train");
                newTrainHasRoute.idRoute = resultSet.getInt("id_route");
                return newTrainHasRoute;
            }
            else throw new SQLException("Такого поїзда не існує. Оновлення неможливе");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTrainHasRouteByID (int idTrain) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean result = statement.execute("DELETE FROM train_has_route where id_train =" + idTrain);
    }
}

