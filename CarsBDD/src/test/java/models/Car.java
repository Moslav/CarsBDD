package models;

public class Car {
    private String carMake;
    private String model;
    private String year;
    private String availableEngines;
    private String transmissions;

    public Car(String carMake, String model, String year, String availableEngines, String transmissions){
        this.carMake = carMake;
        this.model = model;
        this.year = year;
        this.availableEngines = availableEngines;
        this.transmissions = transmissions;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getAvailableEngines() {
        return availableEngines;
    }

    public String getTransmissions() {
        return transmissions;
    }

    public String getCarMake() {
        return carMake;
    }
}
