package utill;

import java.io.IOException;
import java.time.LocalDateTime;

public class Debuger {

    private static Boolean isDebug;

    public static void printDebug(String debugSting){
        if (isDebug == null){
            ConfigurationRider configurationRider = new ConfigurationRider();
            try {
                isDebug = configurationRider.isDebug();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (isDebug){
            System.out.println(LocalDateTime.now() + " debug level: " + debugSting);
        }
    }
}
