package DTO;

import java.util.Scanner;

public class Train {
    public int idTrain;
    public String nameTrain;
    public String statusTrain;

    public String typeTrain;

    public Integer classTrain;



    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", nameTrain='" + nameTrain + '\'' +
                ", statusTrain='" + typeTrain + '\'' +
                ", statusTrain='" + classTrain + '\'' +
                ", statusTrain='" + statusTrain + '\'' +
                '}';
    }
}
