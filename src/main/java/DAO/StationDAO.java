package DAO;

import DTO.Station;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StationDAO {
    public static Statement statement;

    public StationDAO() {

        statement = DataBase.getStatement();
    }
    public void createStation(Station station) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("INSERT INTO station (name_station) values ('" +
                station.nameStation + "')");
    }
    public ArrayList<Station> readAllStations() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM station");
        ArrayList<Station> stations = new ArrayList<>();
        while(resultSet.next()) {
            Station station = new Station();
            station.idStation = resultSet.getInt("id_station");
            station.nameStation = resultSet.getString("name_station");
            stations.add(station);
        }
        return stations;
    }
    public Station findStationByID (int idStation) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM station where id_station=" + idStation);
        if (resultSet.next()) {
            Station station = new Station();
            station.idStation = resultSet.getInt("id_station");
            station.nameStation = resultSet.getString("name_station");
            return station;
        }
        else throw new SQLException();
    }

    public Station updateStation (Station station) throws  ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean execute = statement.execute("UPDATE station SET name_station = '" + station.nameStation + "' WHERE id_station = " + station.idStation);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM station where id_station=" + station.idStation);
        if (resultSet.next()) {
            Station newStation = new Station();
            newStation.idStation = resultSet.getInt("id_station");
            newStation.nameStation = resultSet.getString("name_station");
            return newStation;
        }
        else throw new SQLException("Такої станції не існує. Оновлення неможливе");
    }

    public void deleteStationByID (int idStation) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean result = statement.execute("DELETE FROM station where id_station =" + idStation);
    }
}
