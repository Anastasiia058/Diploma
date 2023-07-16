package DTO;

import java.util.Scanner;

public class Train {
    public Integer idTrain;
    public String nameTrain;
    public String typeTrain;
    public Integer classTrain;
    public String statusTrain;

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
