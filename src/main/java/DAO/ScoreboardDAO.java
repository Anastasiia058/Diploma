package DAO;

import DTO.Scoreboard;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import utill.Debuger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreboardDAO {
    public static Statement statement;
    public ScoreboardDAO() {
        statement = DataBase.getStatement();
    }
    public ArrayList<Scoreboard> readScoreboardsByStationNameAndArrival (String nameStation, String timeArrival) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String request = "SELECT DISTINCT r.id_route, name_train, name_route, arrival, departure, track_number, status_train, day_week FROM schedule " +
                "LEFT JOIN route AS r ON schedule.id_route = r.id_route " +
                "LEFT JOIN train_has_route AS thr ON thr.id_route = r.id_route " +
                "LEFT JOIN train ON train.id_train = thr.id_train " +
                "LEFT JOIN station as st ON st.id_station = schedule.id_station " +
                "LEFT JOIN track ON schedule.id_track= track.id_track " +
                "WHERE st.name_station = '" + nameStation +
                "' AND schedule.arrival >= '" + timeArrival +"'";
        Debuger.printDebug(request);

        ResultSet resultSet = statement.executeQuery(request);

        ArrayList<Scoreboard> scoreboards = new ArrayList<>();
        while (resultSet.next()) {
            Scoreboard scoreboard = new Scoreboard();
            scoreboard.idRoute = resultSet.getInt("id_route");
            scoreboard.nameTrain = resultSet.getString("name_train");
            scoreboard.nameRoute = resultSet.getString("name_route");
            scoreboard.dayWeek = resultSet.getString("day_week");
            scoreboard.timeArrival = resultSet.getString("arrival");
            scoreboard.timeDeparture = resultSet.getString("departure");
            scoreboard.trackNumber = resultSet.getInt("track_number");
            scoreboard.statusTrain = resultSet.getString("status_train");
            scoreboard.nameStation = nameStation;

            scoreboards.add(scoreboard);
        }
        Debuger.printDebug(scoreboards.toString());
        return scoreboards;
    }

    public ArrayList<Scoreboard> readAllScheduleForOperativeTrains() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String request = "SELECT t.id_train, name_train, status_train, arrival, departure, id_station, s.day_week, r.id_route FROM train AS t " +
                    "left JOIN train_has_route AS thr ON thr.id_train = t.id_train " +
                    "LEFT JOIN route AS r ON thr.id_route = r.id_route " +
                    "LEFT JOIN schedule as s ON s.id_route = r.id_route " +
                    "where t.status_train != 'В ремонті' and s.id_schedule IS NOT NULL;";
            Debuger.printDebug(request);
            ResultSet resultSet = statement.executeQuery(request);
            ArrayList<Scoreboard> scoreboards = new ArrayList<>();
            while(resultSet.next()) {
                Scoreboard scoreboard = new Scoreboard();
                scoreboard.idTrain = resultSet.getInt("id_train");
                scoreboard.idRoute = resultSet.getInt("id_route");
                scoreboard.nameTrain = resultSet.getString("name_train");
                scoreboard.timeArrival = resultSet.getString("arrival");
                scoreboard.timeDeparture = resultSet.getString("departure");
                scoreboard.idStation = resultSet.getInt("id_station");
                scoreboard.statusTrain = resultSet.getString("status_train");
                scoreboard.dayWeek = resultSet.getString("day_week");
                scoreboards.add(scoreboard);
            }
            YamlReader.printDebug(scoreboards.toString());
            return scoreboards;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Я зламалась :(", e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Scoreboard> readTimeTableByIdRoute(Integer idRoute) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String request = "SELECT *  FROM route " +
                "LEFT JOIN schedule ON route.id_route = schedule.id_route " +
                "LEFT JOIN train_has_route ON train_has_route.id_route = route.id_route " +
                "LEFT JOIN train ON train.id_train = train_has_route.id_train " +
                "LEFT JOIN station ON schedule.id_station = station.id_station " +
                "LEFT JOIN track ON schedule.id_track = track.id_track " +
                "WHERE route.id_route = '" +
                idRoute + "' " +
                "ORDER by schedule.arrival";
        Debuger.printDebug(request);

        ResultSet resultSet = statement.executeQuery(request);

        ArrayList<Scoreboard> timeTable = new ArrayList<>();
        while (resultSet.next()) {
            Scoreboard table = new Scoreboard();
            table.idSchedule = resultSet.getInt("id_schedule");
            table.idStation = resultSet.getInt("id_station");
            table.timeArrival = resultSet.getString("arrival");
            table.timeDeparture = resultSet.getString("departure");
            table.nameStation = resultSet.getString("name_station");
            table.nameTrain = resultSet.getString("name_train");
            table.idRoute = resultSet.getInt("route.id_route");
            table.typeTrain = resultSet.getString("type_train");
            table.nameRoute = resultSet.getString("name_route");
            table.dayWeek = resultSet.getString("day_week");
            table.trackNumber = resultSet.getInt("id_track");

            timeTable.add(table);
        }

        return timeTable;
    }

    public ArrayList<Scoreboard> readTimeTableByNameRouteAndDayWeek(String nameRoute, String nameDay) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String request = "SELECT *  FROM route " +
                "LEFT JOIN schedule ON route.id_route = schedule.id_route " +
                "LEFT JOIN train_has_route ON train_has_route.id_route = route.id_route " +
                "LEFT JOIN train ON train.id_train = train_has_route.id_train " +
                "LEFT JOIN station ON schedule.id_station = station.id_station " +
                "WHERE day_week = '" +
                nameDay +
                "' AND name_route = '" +
                nameRoute +
                "' "+
                "ORDER by schedule.arrival";
        Debuger.printDebug(request);

        ResultSet resultSet = statement.executeQuery(request);

        if (((ResultSetImpl) resultSet).getRows().hasNext()) {
            resultSet.next();


            Integer trip = resultSet.getInt("trip");
            request =  "SELECT route.id_route, name_train, type_train, name_route, arrival, departure, name_station, day_week, status_train FROM route " +
                    "LEFT JOIN schedule ON route.id_route = schedule.id_route " +
                    "LEFT JOIN train_has_route AS thr ON thr.id_route = route.id_route " +
                    "LEFT JOIN train ON train.id_train = thr.id_train " +
                    "LEFT JOIN station ON schedule.id_station = station.id_station " +
                    "WHERE name_route = '" +
                    nameRoute + "' "+
                    "AND schedule.trip = " + trip + " " +
                    "ORDER BY CASE day_week\n" +
                    "           WHEN 'Пн' THEN 1\n" +
                    "           WHEN 'Вт' THEN 2\n" +
                    "           WHEN 'Ср' THEN 3\n" +
                    "           WHEN 'Чт' THEN 4\n" +
                    "           WHEN 'Пт' THEN 5\n" +
                    "           WHEN 'Сб' THEN 6\n" +
                    "           WHEN 'Нд' THEN 7\n" +
                    "         END,  schedule.arrival";
            Debuger.printDebug(request);
            resultSet = statement.executeQuery(request);


            ArrayList<Scoreboard> timeTable = new ArrayList<>();
            while (resultSet.next()) {
                Scoreboard table= new Scoreboard();
                table.timeArrival = resultSet.getString("arrival");
                table.timeDeparture = resultSet.getString("departure");
                table.nameStation = resultSet.getString("name_station");
                table.nameTrain = resultSet.getString("name_train");
                table.idRoute = resultSet.getInt("route.id_route");
                table.typeTrain = resultSet.getString("type_train");
                table.nameRoute = resultSet.getString("name_route");
                table.dayWeek = resultSet.getString("day_week");
                table.statusTrain = resultSet.getString("status_train");

                timeTable.add(table);
            }
            return timeTable;
        }
        return null;
    }
}
