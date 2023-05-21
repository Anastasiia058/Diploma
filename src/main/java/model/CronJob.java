package model;

import java.util.Timer;

public class CronJob {
    Timer timer = new Timer();
    StatusChanger statusChanger = new StatusChanger();
    BreakTrain breakTrain = new BreakTrain();

    public void runCroneJobs(){
        timer.scheduleAtFixedRate(statusChanger, 0, 60000);
        timer.scheduleAtFixedRate(breakTrain, 0, 600000);
    }
}
