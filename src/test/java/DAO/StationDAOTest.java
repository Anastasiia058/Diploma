package DAO;

import DTO.Station;
import DTO.Train;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StationDAOTest {
    StationDAO stationDAO = new StationDAO();

    @Test
    void createStation() throws SQLException, ClassNotFoundException {
        Station station = new Station();
        station.nameStation = "Яблучко";
        StationDAO stationDAO = new StationDAO();
        stationDAO.createStation(station);
    }

    @Test
    void readAllStations() throws SQLException, ClassNotFoundException {
        ArrayList<Station> stations = stationDAO.readAllStations();
        for (Station station : stations) {
            System.out.println(station.nameStation);
        }
    }

    @Test
    void findStationByID() throws SQLException, ClassNotFoundException {
            int idStation = 1;
            Station station = stationDAO.findStationByID(idStation);
            System.out.println(station.nameStation);
        }

    @Test
    void updateStation() throws SQLException, ClassNotFoundException {
        Station station = new Station();
        station.idStation = 1;
        station.nameStation = "Яблунька";
        Station newStation =stationDAO.updateStation(station);
        System.out.println(station.idStation + ". " + station.nameStation);
    }

    @Test
    void deleteStationByID() throws SQLException, ClassNotFoundException {
        Station station = new Station();
        station.idStation = 1;
        stationDAO.deleteStationByID(1);
    }
}