package checkObject;

import java.util.Scanner;

public class CheckRoute {
    private static Scanner scanner = new Scanner(System.in);


    public static int readIdRoute() {
        System.out.println("Введіть id маршруту");
        String idRoute = scanner.nextLine();
        if (idRoute.matches("^\\d+$")) {
            System.out.println("Дані прийнято");
        } else {
            System.out.println("Дані введено не коректно. Спробуйте ще раз");
            readIdRoute();
        }
        return Integer.parseInt(idRoute);
    }

        public static String readNameRoute () {
            System.out.println("Введіть назву маршруту через дефіс, де перше слово - населений пункт відправлення, а друге - населений пункт прибуття");
            String nameRoute = scanner.nextLine();
            if (nameRoute.matches("([А-ЯҐІЇ-]+[А-Яа-яҐІЇґії-]*)")) {
                System.out.println("Дані прийнято");
            } else {
                System.out.println("Дані введено не коректно. Спробуйте ще раз");
                readNameRoute();
            }
            return nameRoute;
        }
    }