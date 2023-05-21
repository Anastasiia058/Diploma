package DTO;

import java.util.Scanner;

public class Route {
    public int idRoute;
    public String nameRoute;
    Scanner scanner = new Scanner(System.in);

    public void readRoute() {
        System.out.println("Введіть усі станції маршруту, починаючи зі станції відправлення");
        nameRoute = scanner.nextLine();
        if (nameRoute.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readRoute();
        }
    }
}
