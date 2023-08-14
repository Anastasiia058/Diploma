import model.Controller;
import model.CronJob;
import model.Logic;

import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
            public static void main(String[] args) throws SQLException, ClassNotFoundException {


              /*  byte[] fromString = new byte[1024];
                try {
                    int c = System.in.read(fromString);
                    for (int i =0;i < c-1; i++){
                        System.out.println(fromString[i]);
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
*/
              /*  Scanner scanner = new Scanner(System.in);
                String in = scanner.nextLine();
                System.out.println("Тест:" + in);*/


                CronJob cronJob = new CronJob();

                Controller.welcomeMessage();
                Logic.chooseCommand();

    }
}
