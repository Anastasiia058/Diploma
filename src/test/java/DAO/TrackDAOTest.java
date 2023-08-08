package DAO;

import DTO.Route;
import DTO.Track;
import DTO.Train;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrackDAOTest {
    TrackDAO trackDAO = new TrackDAO();

    @Test
    void createTrack() throws SQLException, ClassNotFoundException {
            Track track = new Track();
            track.trackStatus = "Вільна";
            track.trackNumber = 1;
            track.idStation = 1;

            trackDAO.createTrack(track);
    }

    @Test
    void readAllTracks() throws SQLException, ClassNotFoundException {
        ArrayList<Track> tracks = trackDAO.readAllTracks();
        for (Track track: tracks) {
            System.out.println(track.idTrack + " " + track.trackStatus + " " + track.trackNumber + " " + track.idStation);
        }
    }

    @Test
    void findTrackByID() throws SQLException, ClassNotFoundException {
        int idTrack = 3;
        Track track = trackDAO.findTrackByID(idTrack);
        System.out.println(track.idTrack + " " + track.trackStatus + " " + track.trackNumber + " " + track.idStation);
    }

    @Test
    void updateTrack() throws SQLException, ClassNotFoundException {
        Track track = new Track();
        track.idTrack = 6;
        track.trackStatus = "Вільна";
        track.trackNumber = 2;
        track.idStation =3;
        Track newTrack = trackDAO.updateTrack(track);
        System.out.println(newTrack.trackStatus );
    }

    @Test
    void deleteTrackByID() throws SQLException, ClassNotFoundException {
        Track track = new Track();
        track.idTrack = 1;
        trackDAO.deleteTrackByID(1);
    }
}