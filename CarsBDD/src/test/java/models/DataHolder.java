package models;

import java.util.ArrayList;
import java.util.LinkedList;

public class DataHolder {

    private static ArrayList<Car> carList = new ArrayList<>();

    public static ArrayList<Car> getListWithCar() {
        return carList;
    }

    public static void addValueInList(Car car){
        carList.add(car);
    }

    public static Car getObjectCar(int indexCar){
        return carList.get(indexCar);
    }
}
