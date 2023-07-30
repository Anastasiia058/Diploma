import DAO.YamlReader;
import model.Controller;
import model.CronJob;
import model.Logic;

import java.sql.SQLException;

public class Main {
            public static void main(String[] args) throws SQLException, ClassNotFoundException {
                //System.out.println(YamlReader.getReadConfig());

                CronJob cronJob = new CronJob();
                cronJob.runCroneJobs();

                Logic.chooseCommand();






    }
}
