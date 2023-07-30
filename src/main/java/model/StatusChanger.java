package model;

import DAO.ScoreboardDAO;
import DAO.TrackDAO;
import DAO.TrainDAO;
import DTO.Scoreboard;
import DTO.Track;
import DTO.Train;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class StatusChanger extends TimerTask {

    TrackDAO trackDAO= new TrackDAO();
    TrainDAO trainDAO = new TrainDAO();
    ScoreboardDAO scheduleDAO = new ScoreboardDAO();
    public static void main(String[] args) {
        StatusChanger statusChanger = new StatusChanger();
        statusChanger.run();
    }



    @Override
    public void run() {



        LocalDateTime localDateTime = LocalDateTime.now();
        //LocalTime timeNow = localDateTime.toLocalTime();
        DayOfWeek day = localDateTime.getDayOfWeek();


        LocalTime timeNow = LocalTime.of(4, 35);




        List<Scoreboard> scoreboards = scheduleDAO.readAllScheduleForOperativeTrains();
        Map<Integer, List<Scoreboard>> integerListMap = scoreboards.stream().collect(Collectors.groupingBy(Scoreboard::getIdTrain));

        bookingStationByWaitingTrain(integerListMap, day, timeNow);
        bookingStationByNewTrain(integerListMap, day, timeNow);





         else {
                train.statusTrain = "В дорозі";
                List<Track> tracks = trackDAO.findAllTracksByStationId(entry.getKey());
                for (Track track : tracks){
                    if (track.trackStatus.equals("Посадка")){
                        track.trackStatus = "Вільна";
                        track.idStation = null;
                        trackDAO.updateTrack(track);
                    }
                }
            }

            //System.out.println(newTrain);
        }
    }

    void bookingStationByWaitingTrain(Map<Integer, List<Scoreboard>> integerListMap, DayOfWeek day, LocalTime timeNow){
        List <Train> trains = trainDAO.findTrainByStatus("Ремонт");
        for (Train train: trains){
            List<Scoreboard> scoreboards = integerListMap.get(train.idTrain);
            //todo - ljltkfn



        }




    }


    void bookingStationByNewTrain(Map<Integer, List<Scoreboard>> integerListMap, DayOfWeek day, LocalTime timeNow) {
        for (Map.Entry<Integer, List<Scoreboard>> entry : integerListMap.entrySet()) {
            List<Scoreboard> scoreboardForTrain = entry.getValue().stream()
                    .filter(scoreboard -> scoreboard.dayWeek.equals(DayWeek.valueOf(day.toString()).label))
                    .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeArrival()).isBefore(timeNow))
                    .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeDeparture()).isAfter(timeNow))
                    .collect(Collectors.toList());

            Train train = trainDAO.findTrainByID(entry.getKey());

            // Якщо список не поржній - прибув потяг який потребує посадку
            if (!scoreboardForTrain.isEmpty()) {

                for (Scoreboard currentScoreboard : scoreboardForTrain) {
                    ArrayList<Track> tracks = trackDAO.findAllTracksByStationIdAndTrackStatus(currentScoreboard.idStation, "Вільна");
                    if (!tracks.isEmpty()) {
                        Track track = tracks.get(0);
                        track.trackStatus = "Посадка";
                        track.idTrain = currentScoreboard.idTrain;
                        trackDAO.updateTrack(track);
                        train.statusTrain = "Посадка";
                    } else {
                        train.statusTrain = "Очікує колію";
                    }
                    trainDAO.updateTrain(train);
                }
            }
        }
    }
}
