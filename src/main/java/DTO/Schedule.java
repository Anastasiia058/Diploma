package DTO;

import java.util.Scanner;

public class Schedule {
    public int idSchedule;
    public String timeArrival;
    public String timeDeparture;
    public String dayWeek;
    public int trip;
    public int idRoute;
    public int idStation;


    @Override
    public String toString() {
        return  "idSchedule =" + idSchedule +
                ", arrival = '" + timeArrival + '\'' +
                ", departure = '" + timeDeparture + '\'' +
                ", trip = " + trip +
                ", day_week = " + dayWeek +
                ", id_route = " + idRoute +
                ", id_station = " + idStation;
    }
}
