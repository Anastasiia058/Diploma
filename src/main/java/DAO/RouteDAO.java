package DAO;

import DTO.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RouteDAO {

    public static Statement statement;

    public RouteDAO() {
        statement = DataBase.getStatement();
    }

    public void createRoute(Route route) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("INSERT INTO route (name_route) values ('" +
                route.nameRoute + "')");
    }

    public ArrayList<Route> readAllRoutes() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM route");
        ArrayList<Route> routes = new ArrayList<>();
        while(resultSet.next()) {
            Route route = new Route();
            route.idRoute = resultSet.getInt("id_route");
            route.nameRoute = resultSet.getString("name_route");
            routes.add(route);
        }
        return routes;
    }

    public Route findRouteByID (int idRoute) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM route where id_route=" + idRoute);
        if (resultSet.next()) {
            Route route = new Route();
            route.idRoute = resultSet.getInt("id_route");
            route.nameRoute = resultSet.getString("name_route");
            return route;
        }
        else throw new SQLException();
    }

    public Route updateRoute (Route route) throws  ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean execute = statement.execute("UPDATE route SET name_route = '" + route.nameRoute + "' WHERE id_route = " + route.idRoute);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM route where id_route=" + route.idRoute);
        if (resultSet.next()) {
            Route newRoute = new Route();
            newRoute.idRoute = resultSet.getInt("id_route");
            newRoute.nameRoute = resultSet.getString("name_route");
            return newRoute;
        }
        else throw new SQLException("Такого маршруту не існує. Оновлення неможливе");
    }

    public void deleteRouteByID (int idRoute) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean result = statement.execute("DELETE FROM route where id_route =" + idRoute);
    }
}
