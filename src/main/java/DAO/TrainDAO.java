package DAO;

import DTO.Train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainDAO {
    public static Statement statement;

    private static Scanner scanner = new Scanner(System.in);
    public TrainDAO() {

        statement = DataBase.getStatement();
    }

    public void createTrain(Train train) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("INSERT INTO train (name_train, type_train, class_train, status_train) values ('" +
                train.nameTrain + "', '" +
                train.typeTrain + "', '" +
                train.classTrain + "', '" +
                train.statusTrain + "')");
    }

    public ArrayList <Train> readAllTrains() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM train");
        ArrayList<Train> trains = new ArrayList<>();
        while(resultSet.next()) {
            Train train = new Train();
            train.idTrain = resultSet.getInt("id_train");
            train.nameTrain = resultSet.getString("name_train");
            train.typeTrain = resultSet.getString("type_train");
            train.classTrain = resultSet.getInt("class_train");
            train.statusTrain = resultSet.getString("status_train");
            trains.add(train);
        }
        return trains;
    }

    public Train findTrainByID (int idTrain) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train where id_train=" + idTrain);
            if (resultSet.next()) {
                Train train = new Train();
                train.idTrain = resultSet.getInt("id_train");
                train.nameTrain = resultSet.getString("name_train");
                train.typeTrain = resultSet.getString("type_train");
                train.classTrain = resultSet.getInt("class_train");
                train.statusTrain = resultSet.getString("status_train");
                return train;
            }
            else throw new SQLException("Поїзда з id = " + idTrain + " не існує.");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Train updateTrain (Train train) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            boolean execute = statement.execute("UPDATE train SET name_train = '" +
                    train.nameTrain +
                    "', type_train = '" +
                    train.typeTrain +
                    "', class_train = '" +
                    train.classTrain +
                    "', status_train = '" +
                    train.statusTrain +
                    "' WHERE id_train = " +
                    train.idTrain);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train where id_train=" + train.idTrain);
            if (resultSet.next()) {
                Train newTrain = new Train();
                newTrain.idTrain = resultSet.getInt("id_train");
                newTrain.nameTrain = resultSet.getString("name_train");
                newTrain.typeTrain = resultSet.getString("type_train");
                newTrain.classTrain = resultSet.getInt("class_train");
                newTrain.statusTrain = resultSet.getString("status_train");
                return newTrain;
            }
            else throw new SQLException("Такого поїзда не існує. Оновлення неможливе");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTrainByID (int idTrain) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean result = statement.execute("DELETE FROM train where id_train =" + idTrain);
    }
}
