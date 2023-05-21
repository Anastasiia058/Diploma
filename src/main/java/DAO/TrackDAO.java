package DAO;

import DTO.Track;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrackDAO {
    public static Statement statement;

    public TrackDAO() {
        statement = DataBase.getStatement();
    }

    public void createTrack(Track track) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("INSERT INTO track (track_status, track_number, Station_id_station, Train_id_train) values ('" +
                track.trackStatus + "', " +
                track.trackNumber + ", " +
                track.idStation + ", " +
                track.idTrain + ")");
    }

    public ArrayList<Track> readAllTracks() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM track");
        ArrayList<Track> tracks = new ArrayList<>();
        while(resultSet.next()) {
            Track track = new Track();
            track.idTrack = resultSet.getInt("id_track");
            track.trackStatus = resultSet.getString("track_status");
            track.trackNumber = resultSet.getInt("track_number");
            track.idStation = resultSet.getInt("Station_id_station");
            track.idTrain = resultSet.getInt("Train_id_train");
            tracks.add(track);
        }
        return tracks;
    }
    public Track findTrackByID (int idTrack) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM track where id_track=" + idTrack);
        if (resultSet.next()) {
            Track track = new Track();
            track.idTrack = resultSet.getInt("id_track");
            track.trackStatus = resultSet.getString("track_status");
            track.trackNumber = resultSet.getInt("track_number");
            track.idStation = resultSet.getInt("Station_id_Station");
            track.idTrain = resultSet.getInt("Train_id_train");
            return track;
        }
        else throw new SQLException();
    }

    public  ArrayList<Track> findAllTracksByTrainId (int trainId){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train_schedule.track " +
                    "WHERE Train_id_train = " + trainId);
            ArrayList<Track> tracks = new ArrayList<>();
            while(resultSet.next()) {
                Track track = new Track();
                track.idTrack = resultSet.getInt("id_track");
                track.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                track.idStation = resultSet.getInt("Station_id_station");
                track.idTrain = resultSet.getInt("Train_id_train");
                tracks.add(track);
            }
            return tracks;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Track> findAllTracksByStationIdAndTrackStatus(int idStation, String trackStatus) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train_schedule.track " +
                    "WHERE Station_id_station = " + idStation + " AND track_status = '" + trackStatus + "';");
            ArrayList<Track> tracks = new ArrayList<>();
            while(resultSet.next()) {
                Track track = new Track();
                track.idTrack = resultSet.getInt("id_track");
                track.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                track.idStation = resultSet.getInt("Station_id_station");
                track.idTrain = resultSet.getInt("Train_id_train");
                tracks.add(track);
            }
            return tracks;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Track updateTrack (Track track) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            boolean execute = statement.execute("UPDATE track SET track_status = '" + track.trackStatus +
                    "', track_number = " + track.trackNumber +
                    ", Station_id_station = " + track.idStation +
                    ", Train_id_train = " + track.idTrain +
                    " WHERE id_track = " + track.idTrack);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM track where id_track=" + track.idTrack);
            if (resultSet.next()) {
                Track newTrack = new Track();
                newTrack.idTrack = resultSet.getInt("id_track");
                newTrack.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                newTrack.idStation = resultSet.getInt("Station_id_station");
                track.idTrain = resultSet.getInt("Train_id_train");
                return newTrack;
            }
            else throw new SQLException("Такої колії не існує. Оновлення неможливе");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTrackByID (int idTrack) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean result = statement.execute("DELETE FROM track where id_track =" + idTrack);
    }
}
