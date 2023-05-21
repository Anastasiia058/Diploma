package model;

import DAO.TrainDAO;
import DTO.Train;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class BreakTrain extends TimerTask {

    @Override
    public void run() {
        Random random = new Random();
        double r = random.nextDouble();
        //System.out.println(r);
        if (r > 0.95) {
            TrainDAO trainDAO = new TrainDAO();
            List<Train> trains;
            try {
                trains = trainDAO.readAllTrains();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (trains != null && !trains.isEmpty()) {
                Train train = trains.get(getRandomElement(trains));
                train.statusTrain = "Аварія";
                Train updatedTrain = trainDAO.updateTrain(train);
                System.out.println("\nУВАГА АВАРІЯ!\nПоїзд номер " + updatedTrain.idTrain + " " + updatedTrain.nameTrain + " зламаний.\n");
            }
        }
    }
    public int getRandomElement(List elements)
        {
            Random rand = new Random();
            return rand.nextInt(elements.size());
        }
}
