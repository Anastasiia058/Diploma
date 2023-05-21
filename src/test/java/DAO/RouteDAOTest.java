package DAO;

import DTO.Route;
import DTO.Train;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RouteDAOTest {
    @Spy
    RouteDAO routeDAO = new RouteDAO();
    @Test
    void createRoute() throws SQLException, ClassNotFoundException {
        Route route = new Route();
        route.nameRoute = "Полтава-Одеса";
        routeDAO.createRoute(route);
    }
    @Test
    void readAllRoutes() throws SQLException, ClassNotFoundException {
        ArrayList<Route> routes = routeDAO.readAllRoutes();
        for (Route route: routes) {
            System.out.println(route.idRoute +" "+ route.nameRoute);
        }
    }

    @Test
    void findRouteByID() throws SQLException, ClassNotFoundException {
        int idRoute = 2;
        Route route = routeDAO.findRouteByID(idRoute);
        System.out.println(route.nameRoute);
    }

    @Test
    void updateRoute() throws SQLException, ClassNotFoundException {
        Route route = new Route();
        route.idRoute = 2;
        route.nameRoute = "Київ-Харків";
        Route newRoute = routeDAO.updateRoute(route);
        System.out.println(newRoute.nameRoute);
    }

    @Test
    void deleteRouteByID() throws SQLException, ClassNotFoundException {
        Route route = new Route();
        route.idRoute = 6;
        routeDAO.deleteRouteByID(6);
    }
}