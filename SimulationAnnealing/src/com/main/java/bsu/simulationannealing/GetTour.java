package com.main.java.bsu.simulationannealing;

import java.util.ArrayList;

public class GetTour {

    private static ArrayList destCities = new ArrayList<City>();

    public static void addCity(City city) {
        destCities.add(city);
    }

    public static City getCity(int index){
        return (City)destCities.get(index);
    }

    public static int numberOfCities(){
        return destCities.size();
    }
}
