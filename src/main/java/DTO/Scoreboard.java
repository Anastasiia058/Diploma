package DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Scoreboard {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public int idSchedule;
    public int idTrain;
    public int idRoute;
    public String typeTrain;
    public String nameRoute;
    public String nameTrain;
    public int idStation;
    public String nameStation;
    public String timeArrival;
    public String timeDeparture;
    public int trackNumber;
    public String statusTrain;
    public String dayWeek;
    public int trip;

    Scanner scanner = new Scanner(System.in);

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public LocalTime getLocalTimeArrival (){
        return LocalTime.parse(timeArrival, formatter);
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getStatusTrain() {
        return statusTrain;
    }

    public void setStatusTrain(String statusTrain) {
        this.statusTrain = statusTrain;
    }

    public void readStation() {
        System.out.println("Введіть назву станції, з якої буде здійснюватись посадка.");
        nameStation = scanner.nextLine();
        if (nameStation.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readStation();
        }
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "idTrain=" + idTrain +
                ", nameTrain='" + nameTrain + '\'' +
                ", idStation=" + idStation +
                ", nameStation='" + nameStation + '\'' +
                ", timeArrival='" + timeArrival + '\'' +
                ", timeDeparture='" + timeDeparture + '\'' +
                ", trackNumber=" + trackNumber +
                ", statusTrain='" + statusTrain + '\'' +
                ", trip = " + trip +
                ", day_week " + dayWeek +
                '}';
    }
}

