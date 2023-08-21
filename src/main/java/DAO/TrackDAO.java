package DAO;

import DTO.Track;
import utill.Debuger;

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
        statement.executeUpdate("INSERT INTO track (track_status, track_number, id_station) values ('" +
                track.trackStatus + "', " +
                track.trackNumber + ", " +
                track.idStation + ")");
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
            track.idStation = resultSet.getInt("id_station");
            tracks.add(track);
        }
        return tracks;
    }
    public Track findTrackByID (int idTrack) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM track where id_track=" + idTrack);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (resultSet.next()) {
                Track track = new Track();
                track.idTrack = resultSet.getInt("id_track");
                track.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                track.idStation = resultSet.getInt("id_Station");
                return track;
            }
            else throw new SQLException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  ArrayList<Track> findAllTracksByStationId (int idStation){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train_schedule.track " +
                    "WHERE id_station = " + idStation );
            ArrayList<Track> tracks = new ArrayList<>();
            while(resultSet.next()) {
                Track track = new Track();
                track.idTrack = resultSet.getInt("id_track");
                track.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                track.idStation = resultSet.getInt("id_station");
                tracks.add(track);
            }
            return tracks;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  ArrayList<Track> findAllTracksByStationIdAndStatus (int idStation, String status){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String request = "SELECT * FROM train_schedule.track " +
                    "WHERE id_station = " + idStation +
                    " AND track_status = '" + status + "'";
            Debuger.printDebug(request);
            ResultSet resultSet = statement.executeQuery(request);
            ArrayList<Track> tracks = new ArrayList<>();
            while(resultSet.next()) {
                Track track = new Track();
                track.idTrack = resultSet.getInt("id_track");
                track.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                track.idStation = resultSet.getInt("id_station");
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
                    "WHERE id_station = " + idStation + " AND track_status = '" + trackStatus + "';");
            ArrayList<Track> tracks = new ArrayList<>();
            while(resultSet.next()) {
                Track track = new Track();
                track.idTrack = resultSet.getInt("id_track");
                track.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                track.idStation = resultSet.getInt("id_station");
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
            String request = "UPDATE track SET track_status = '" + track.trackStatus +
                    "', track_number = " + track.trackNumber +
                    ", id_station = " + track.idStation +
                    " WHERE id_track = " + track.idTrack;
            Debuger.printDebug(request);
            boolean execute = statement.execute(request);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM track where id_track=" + track.idTrack);
            if (resultSet.next()) {
                Track newTrack = new Track();
                newTrack.idTrack = resultSet.getInt("id_track");
                newTrack.trackStatus = resultSet.getString("track_status");
                track.trackNumber = resultSet.getInt("track_number");
                newTrack.idStation = resultSet.getInt("id_station");
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
        boolean result = statement.execute("DELETE FROM track where id_track = " + idTrack);
    }
}
