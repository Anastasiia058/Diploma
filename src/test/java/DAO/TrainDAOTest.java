package DAO;

import DTO.Train;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainDAOTest {
    TrainDAO trainDAO = new TrainDAO();

    @Test
    void createTrain() throws SQLException, ClassNotFoundException {
        Train train = new Train ();
        train.nameTrain = "Оберіг";
        train.typeTrain = "Нічний швидкий";
        train.classTrain = 2;
        train.statusTrain = "В дорозі";
        TrainDAO trainDAO = new TrainDAO();
        trainDAO.createTrain(train);
    }

    @Test
    void readAllTrains() throws SQLException, ClassNotFoundException {
        ArrayList<Train> trains = trainDAO.readAllTrains();
        for (Train train: trains) {
        System.out.println(train.idTrain +" "+ train.nameTrain);
        }
    }

    @Test
    void findTrainByID() throws SQLException, ClassNotFoundException {
        int idTrain = 3;
        Train train = trainDAO.findTrainByID(idTrain);
        System.out.println(train.nameTrain);
    }

    @Test
    void updateTrain() throws SQLException, ClassNotFoundException {
        Train train = new Train();
        train.nameTrain = "Оберіг";
        train.typeTrain = "Нічний швидкий";
        train.classTrain = 2;
        train.statusTrain = "В дорозі";
        train = trainDAO.updateTrain(train);
        System.out.println(train.nameTrain);
    }

    @Test
    void deleteTrainByID() throws SQLException, ClassNotFoundException {
        Train train = new Train();
        train.idTrain = 10;
        trainDAO.deleteTrainByID(2);
    }

    @Test
    void fixAllTrains() throws SQLException, ClassNotFoundException {
        List<Train> trains = trainDAO.readAllTrains();
        for (Train train:trains) {
            train.statusTrain = "В дорозі";
            trainDAO.updateTrain(train);
        }
    }
}