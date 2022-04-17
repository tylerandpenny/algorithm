package Exam.dahua;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class shootCar {
    private int adrId;
    private String carNum;
    private Date shootTime;

    public float getAvgTravel(int begin, int end, List<shootCar> shootCars){
        float res = (float) 0;
        int count  = 0;
        List<shootCar> beginShoots = new LinkedList<shootCar>();
        List<shootCar> endShoots = new LinkedList<shootCar>();
        for (shootCar item : shootCars) {
           if (item.adrId == begin){
               beginShoots.add(item);
           }else if (item.adrId == end){
               endShoots.add(item);
           }
        }
        return res;
    }

}


