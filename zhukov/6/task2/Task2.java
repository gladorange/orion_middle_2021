package task2;


import classes.*;
import enums.PetrolType;

import java.util.*;


public class Task2 {
    public static void main(String[] args) {


        //task.b

        System.out.print("------\ntask.b\n------\n");

        List< Triple<String,PetrolType,Double> > gasStations = new ArrayList<>();

        gasStations.add( new Triple<>("Elm street 14/28", PetrolType.AI92, 48.90) );
        gasStations.add( new Triple<>("Baker street 221b", PetrolType.AI92, 48.50) );
        gasStations.add( new Triple<>("Yewtree street 4", PetrolType.AI92, 49.90) );
        gasStations.add( new Triple<>("Evergreen Terrace 742", PetrolType.AI95, 54.90) );
        gasStations.add( new Triple<>("Lincoln Avenue 671", PetrolType.AI95, 50.45) );
        gasStations.add( new Triple<>("Lincoln Avenue 672", PetrolType.AI95, 53.15) );


        GasStationsReport.findBestPrice(gasStations, PetrolType.AI92);



    }

}
