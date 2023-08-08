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
import java.util.*;
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

        LocalTime timeNow = LocalTime.of(16, 27);
        List<Scoreboard> scoreboards = scheduleDAO.readAllScheduleForOperativeTrains();
        Map<Integer, List<Scoreboard>> integerListMap = scoreboards.stream().collect(Collectors.groupingBy(Scoreboard::getIdTrain));

        runFromStation(scoreboards, day, timeNow);
        bookingStationByWaitingTrain(scoreboards, day, timeNow);
        bookingStationByNewTrain(scoreboards, day, timeNow);
    }

    void runFromStation(List<Scoreboard> scoreboards, DayOfWeek day, LocalTime timeNow) {
        Map<Integer, List<Scoreboard>> findTrainByStatus = scoreboards.stream()
                .filter(scoreboard -> scoreboard.dayWeek.equals(DayWeek.valueOf(day.toString()).label))
                .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeArrival()).isAfter(timeNow))
                .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeDeparture()).isBefore(timeNow))
                .filter(scoreboard -> scoreboard.statusTrain.contains("Посадка"))
                .collect(Collectors.groupingBy(Scoreboard::getIdTrain));

        for (Map.Entry<Integer, List<Scoreboard>> entry : findTrainByStatus.entrySet()) {
            Train train = trainDAO.findTrainByID(entry.getKey());
            Integer idTrack =  Integer.parseInt(train.statusTrain.split("-")[1]);
            train.statusTrain = "В дорозі";
            trainDAO.updateTrain(train);
            Track track = trackDAO.findTrackByID(idTrack);
            track.trackStatus = "Вільна";
            trackDAO.updateTrack(track);

        }
    }

    void bookingStationByWaitingTrain(List<Scoreboard> allScoreboards, DayOfWeek day, LocalTime timeNow){
            List<Scoreboard> scoreboards = allScoreboards.stream()
                    .filter(scoreboard -> scoreboard.statusTrain.equals("Очікує колію"))
                    .collect(Collectors.toList());
            if (scoreboards != null && !scoreboards.isEmpty()){
                scoreboards.sort(Comparator.comparing(Scoreboard::getLocalTimeArrival));
                for (int i =0; i < scoreboards.size(); i++){
                    if(scoreboards.get(i).getLocalTimeArrival().isAfter(timeNow)){
                        Integer idStation = scoreboards.get(i-1).idStation;
                        System.out.println(idStation.toString());
                        List <Track> tracks = trackDAO.findAllTracksByStationIdAndStatus(scoreboards.get(i-1).idStation, "Вільна");
                        if (tracks != null && !tracks.isEmpty()){
                            Track track = tracks.get(0);
                            track.trackStatus = "Посадка";
                            Train train = trainDAO.findTrainByID(scoreboards.get(i).idTrain);
                            trackDAO.updateTrack(track);
                            train.statusTrain = "Посадка:"+track.idTrack;
                            trainDAO.updateTrain(train);
                            System.out.println(tracks.toString());
                        }
                    break;
                }
            }
        }
    }


    void bookingStationByNewTrain(List<Scoreboard> scoreboards, DayOfWeek day, LocalTime timeNow) {
        Map<Integer, List<Scoreboard>> findTrainByStatus = scoreboards.stream()
                .filter(scoreboard -> scoreboard.dayWeek.equals(DayWeek.valueOf(day.toString()).label))
                .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeArrival()).isAfter(timeNow))
                .filter(scoreboard -> LocalTime.parse(scoreboard.getTimeDeparture()).isBefore(timeNow))
                .filter(scoreboard -> scoreboard.statusTrain.contains("В дорозі"))
                .collect(Collectors.groupingBy(Scoreboard::getIdTrain));

        for (Map.Entry<Integer, List<Scoreboard>> entry : findTrainByStatus.entrySet()) {
            Train train = trainDAO.findTrainByID(entry.getKey());
            ArrayList<Track> tracks = trackDAO.findAllTracksByStationIdAndTrackStatus(entry.getValue().get(0).idStation, "Вільна");
            if (!tracks.isEmpty()) {
                Track track = tracks.get(0);
                track.trackStatus = "Посадка";
                trackDAO.updateTrack(track);
                train.statusTrain = "Посадка:"+track.idTrack;
            } else {
                train.statusTrain = "Очікує колію";
            }
            trainDAO.updateTrain(train);
        }
    }
}
