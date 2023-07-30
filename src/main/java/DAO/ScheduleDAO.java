package DAO;

import DTO.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class ScheduleDAO {

    public static Statement statement;

    public ScheduleDAO() {
        statement = DataBase.getStatement();
    }

    public void createSchedule (Schedule schedule) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String updateRequest = "INSERT INTO schedule (arrival, departure, day_week, trip, id_route, id_station, id_track) values ('" +
                schedule.timeArrival +"', '" +
                schedule.timeDeparture +"', '" +
                schedule.dayWeek +"', " +
                schedule.trip +", " +
                schedule.idRoute + ", " +
                schedule.idStation + ", " +
                schedule.idTrack + ")";
        System.out.println(updateRequest);
        statement.executeUpdate(updateRequest);
    }

    public ArrayList<Schedule> readAllSchedule() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM schedule");
        ArrayList<Schedule> arrivalDeparture = new ArrayList<>();
        while(resultSet.next()) {
            Schedule schedule = new Schedule();
            schedule.idSchedule = resultSet.getInt("id_schedule");
            schedule.timeArrival = resultSet.getString("arrival");
            schedule.timeDeparture = resultSet.getString("departure");
            schedule.dayWeek = resultSet.getString("day_week");
            schedule.trip = resultSet.getInt("trip");
            schedule.idRoute = resultSet.getInt("id_route");
            schedule.idStation = resultSet.getInt("id_station");

            arrivalDeparture.add(schedule);
        }
        return arrivalDeparture;
    }

    public Schedule findArrivalDepartureByID (int idSchedule) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM schedule where id_schedule=" + idSchedule);
        if (resultSet.next()) {
            Schedule schedule = new Schedule();
            schedule.idSchedule = resultSet.getInt("id_schedule");
            schedule.timeArrival= resultSet.getString("arrival");
            schedule.timeDeparture = resultSet.getString("departure");
            schedule.dayWeek = resultSet.getString("day_week");
            schedule.trip = resultSet.getInt("trip");
            schedule.idRoute = resultSet.getInt("id_route");
            schedule.idStation = resultSet.getInt("id_station");
            return schedule;
        }
        else throw new SQLException();
    }

    public Schedule updateSchedule (Schedule schedule) throws  ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean execute = statement.execute("UPDATE schedule SET arrival = '" +
                schedule.timeArrival + "', departure = '" +
                schedule.timeDeparture + "', day_week = '" +
                schedule.dayWeek + "', trip = '" +
                schedule.trip + "' WHERE id_schedule = " +
                schedule.idSchedule);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM schedule where id_schedule=" + schedule.idSchedule);
        if (resultSet.next()) {
            Schedule newSchedule = new Schedule();
            newSchedule.idSchedule = resultSet.getInt("id_schedule");
            newSchedule.timeArrival = resultSet.getString("arrival");
            newSchedule.timeDeparture = resultSet.getString("departure");
            schedule.dayWeek = resultSet.getString("day_week");
            schedule.trip = resultSet.getInt("trip");
            schedule.idStation = resultSet.getInt("Station_id_station");
            return newSchedule;
        }
        else throw new SQLException("Такого розкладу не існує. Оновлення неможливе");
    }

    public void deleteScheduleByID (int idSchedule) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean result = statement.execute("DELETE FROM schedule where id_schedule =" + idSchedule);
    }


}

