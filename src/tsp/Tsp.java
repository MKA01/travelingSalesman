package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math.*;

public class Tsp {

    private List<Point> city = new ArrayList();
    private List<Point> path = new ArrayList();
    private List<Double> cords = new ArrayList();
    private int temp = 0, cityNumber = 1;
    private double lowestCost = 0, tempCost = 0, cost = 0;
    private Point firstPoint;



    public void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("tsp.txt"));
        scanner.useDelimiter("\\s+|\\n");
        scanner.useLocale(Locale.US);

        while(scanner.hasNextDouble()){
            cords.add(scanner.nextDouble());
        }

        while(temp < cords.size()){
            city.add(new Point(cords.get(temp).intValue(),cords.get(temp +1).intValue(), cityNumber));
            cityNumber++;
            temp = temp + 2;
        }
    }

    public void printCords(){
        System.out.println(cords);
    }

    public void printPoints(){
        System.out.println(city);
    }

    public double distance(int first, int second){
        return Math.sqrt((Math.pow(city.get(first).getX() - city.get(second).getX(), 2) + Math.pow(city.get(first).getY() - city.get(second).getY(), 2)));
    }

    public void calculate(int whichCity){
        firstPoint = city.get(whichCity);
        path.add(firstPoint);
        cords.clear();

        while(city.size() != 1) {
            temp = 0;
            if(whichCity == 0)
                lowestCost = distance(1, whichCity);
            else
                lowestCost = distance(0, whichCity);

            for (int i = 0; i < city.size(); i++) {
                if (whichCity != i) {
                    tempCost = distance(i, whichCity);
                    if (lowestCost >= tempCost) {
                        lowestCost = tempCost;
                        temp = i;
                    }
                }
            }
            cost = cost + lowestCost;
            cords.add(lowestCost);
            path.add(city.get(temp));
            city.remove(whichCity);
            if(whichCity < temp)
                whichCity = temp - 1;
            else
                whichCity = temp;
        }

        path.add(firstPoint);
        lowestCost = Math.sqrt((Math.pow(firstPoint.getX() - city.get(0).getX(), 2) + Math.pow(firstPoint.getY() - city.get(0).getY(), 2)));
        cost = cost + lowestCost;
        cords.add(lowestCost);

        for(int i = 0; i < path.size() - 1; i++)
            System.out.println("Traveling from: " + path.get(i).getNumber() + " to: " + path.get(i+1).getNumber() + " at cost: " + cords.get(i));

        System.out.println("Total cost: " + cost);



    }
}
