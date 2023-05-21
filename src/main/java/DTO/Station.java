package DTO;

import java.util.Scanner;

public class Station {
    public int idStation;
    public String nameStation;
    Scanner scanner = new Scanner(System.in);

    public void readStation() {
        System.out.println("Введіть назву станції");
        nameStation = scanner.nextLine();
        if (nameStation.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readStation();
        }
    }
}
