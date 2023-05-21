package DTO;

import java.util.Scanner;

public class Track {
        public Integer idTrack;
        public Integer trackNumber;
        public String trackStatus;
        public Integer idStation;
        public Integer idTrain;
        Scanner scanner = new Scanner(System.in);

        public void readTrack() {
            System.out.println("Оберіть та введіть один із станів колії з нижченаведених: працює/ремонтується");
            trackStatus = scanner.nextLine();
            if (trackStatus.matches("([А-ЯҐІЇ{1}][а-яґії{30}]*)")) {
                System.out.println("Дані прийнято");
            } else {
                System.out.println("Дані введено не коректно. Спробуйте ще раз");
                readTrack();
            }
        }
    }
