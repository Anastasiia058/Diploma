package DTO;

import java.util.Scanner;

public class Train {
    public int idTrain;
    public String nameTrain;
    public String statusTrain;

    public String typeTrain;

    public Integer classTrain;
    Scanner scanner = new Scanner(System.in);

    public void readTrain() {
        System.out.println("Введіть назву поїзда");
        nameTrain = scanner.nextLine();
        if (nameTrain.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readTrain();
        }
    }

    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", nameTrain='" + nameTrain + '\'' +
                ", statusTrain='" + statusTrain + '\'' +
                '}';
    }
}
