package DAO;

import DTO.Schedule;
import DTO.Track;
import DTO.Train;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleDAOTest {
    ScheduleDAO scheduleDAO = new ScheduleDAO();

    @Test
    void createSchedule() throws SQLException, ClassNotFoundException {
        Schedule schedule = new Schedule();
        schedule.timeArrival = "12:19:00";
        schedule.timeDeparture = "12:30:00";
        schedule.idStation = 3;
        //schedule.idRoute = 4;
        scheduleDAO.createSchedule(schedule);
    }

    /*@Test
    void readAllSchedule() throws SQLException, ClassNotFoundException {
        ArrayList<Schedule> schedules = scheduleDAO.readAllSchedule();
        for (Schedule schedule: schedules) {
            System.out.println(schedule.idSchedule + ". "+ schedule.timeArrival + " " + schedule.timeDeparture +" "+ schedule.idTrain+" "+ schedule.idStation +" " + schedule.idRoute);
        }
    }*/

    @Test
    void readAllSchedule() throws SQLException, ClassNotFoundException {
        ArrayList<Schedule> schedules = scheduleDAO.readAllSchedule();
        for (Schedule schedule: schedules) {
            System.out.println(schedule.idSchedule + ". "+ schedule.timeArrival + " " + schedule.timeDeparture +" "+ schedule.idStation);
        }
    }

    /*@Test
    void findArrivalDepartureByID() throws SQLException, ClassNotFoundException {
        int idSchedule = 3;
        Schedule schedule = scheduleDAO.findArrivalDepartureByID(idSchedule);
        System.out.println(schedule.idSchedule + ". "+ schedule.timeArrival + " " + schedule.timeDeparture +" "+ schedule.idTrain+" "+ schedule.idStation +" " + schedule.idRoute);
    }*/

    @Test
    void findArrivalDepartureByID() throws SQLException, ClassNotFoundException {
        int idSchedule = 3;
        Schedule schedule = scheduleDAO.findScheduleById(idSchedule);
        System.out.println(schedule.idSchedule + ". "+ schedule.timeArrival + " " + schedule.timeDeparture +" "+ schedule.idStation);
    }

    /*@Test
    void updateSchedule() throws SQLException, ClassNotFoundException {
        Schedule schedule = new Schedule();
        schedule.idSchedule = 3;
        schedule.timeArrival = "2023-01-13 23:45:00";
        schedule.timeDeparture = "2023-01-14 18:17:00";
        Schedule newSchedule =scheduleDAO.updateSchedule(schedule);
        System.out.println(schedule.idSchedule + ". "+ schedule.timeArrival + " " + schedule.timeDeparture +" "+ schedule.idTrain+" "+ schedule.idStation +" " + schedule.idRoute);
    }*/

    @Test
    void updateSchedule() throws SQLException, ClassNotFoundException {
        Schedule schedule = new Schedule();
        schedule.idSchedule = 6;
        schedule.timeArrival = "08:28:00";
        schedule.timeDeparture = "09:19:00";
        schedule.idStation = 17;
        Schedule newSchedule = scheduleDAO.updateSchedule(schedule);
        System.out.println(schedule.idSchedule + ". "+ schedule.timeArrival + " " + schedule.timeDeparture +" "+ schedule.idStation);
    }

    @Test
    void deleteScheduleByID() throws SQLException, ClassNotFoundException {
        Schedule schedule = new Schedule();
        schedule.idSchedule = 1;
        scheduleDAO.deleteScheduleByID(1);
    }
}