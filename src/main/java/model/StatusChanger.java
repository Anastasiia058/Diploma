package model;

import DAO.ScoreboardDAO;
import DAO.TrackDAO;
import DAO.TrainDAO;
import DTO.Scoreboard;
import DTO.Track;
import DTO.Train;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class StatusChanger extends TimerTask {

    TrainDAO trainDAO = new TrainDAO();

    @Override
    public void run() {
        //LocalTime now = LocalTime.now();
        //LocalTime now = LocalTime.of(4, 30);
        LocalTime now = LocalTime.of(0, 10);

        ScoreboardDAO scheduleDAO = new ScoreboardDAO();
        TrackDAO trackDAO= new TrackDAO();

        List<Scoreboard> scoreboards = scheduleDAO.readAllScheduleForOperativeTrains();

        Map<Integer, List<Scoreboard>> integerListMap = scoreboards.stream().collect(Collectors.groupingBy(Scoreboard::getIdTrain));

        for (Map.Entry<Integer, List<Scoreboard>> entry : integerListMap.entrySet()){
            List<Scoreboard> scoreboardForTrain = entry.getValue().stream()
                    .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeArrival()).isBefore(now))
                    .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeDeparture()).isAfter(now))
                    .collect(Collectors.toList());

            Train train = trainDAO.findTrainByID(entry.getKey());

            if (!scoreboardForTrain.isEmpty()){
                for (Scoreboard currentScoreboard : scoreboardForTrain){
                    ArrayList<Track> tracks = trackDAO.findAllTracksByStationIdAndTrackStatus(currentScoreboard.idStation, "Вільна");
                    if (!tracks.isEmpty()){
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
            } else {
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
            Train newTrain = trainDAO.updateTrain(train);
            //System.out.println(newTrain);
        }
    }
}
