package com.main.java.bsu.simulationannealing;

public class SimulationAnnealing {

    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        City city1 = new City(60, 200);
        GetTour.addCity(city1);
        City city2 = new City(180, 200);
        GetTour.addCity(city2);
        City city3 = new City(80, 180);
        GetTour.addCity(city3);
        City city4 = new City(140, 180);
        GetTour.addCity(city4);
        City city5 = new City(20, 160);
        GetTour.addCity(city5);
        City city6 = new City(100, 160);
        GetTour.addCity(city6);
        City city7 = new City(200, 160);
        GetTour.addCity(city7);
        City city8 = new City(140, 140);
        GetTour.addCity(city8);
        City city9 = new City(40, 120);
        GetTour.addCity(city9);
        City city10 = new City(100, 120);
        GetTour.addCity(city10);
        City city11 = new City(180, 100);
        GetTour.addCity(city11);
        City city12 = new City(60, 80);
        GetTour.addCity(city12);
        City city13 = new City(120, 80);
        GetTour.addCity(city13);
        City city14 = new City(180, 60);
        GetTour.addCity(city14);
        City city15 = new City(20, 40);
        GetTour.addCity(city15);
        City city16 = new City(100, 40);
        GetTour.addCity(city16);
        City city17 = new City(200, 40);
        GetTour.addCity(city17);
        City city18 = new City(20, 20);
        GetTour.addCity(city18);
        City city19 = new City(60, 20);
        GetTour.addCity(city19);
        City city20 = new City(160, 20);
        GetTour.addCity(city20);

        double temp = 10000;

        double coolingRate = 0.003;

        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();

        System.out.println("Initial solution distance: " + currentSolution.getDistance());

        Tour best = new Tour(currentSolution.getTour());

        while (temp > 1) {
            Tour newSolution = new Tour(currentSolution.getTour());

            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            int currentEnergy = currentSolution.getDistance();
            int neighbourEnergy = newSolution.getDistance();

            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            temp *= 1 - coolingRate;
        }

        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Tour: " + best);
    }
}