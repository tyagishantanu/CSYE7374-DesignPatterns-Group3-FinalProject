package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Car;
import edu.neu.csye7374.CarCategory;
import edu.neu.csye7374.Factory.*;

public class VehicleBuilder implements BuilderAPI {

    private int carId;
    private String carName;
    private double carPrice;
    private CarCategory carCategory;
    private String carManufacturer;

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }

    public VehicleBuilder(int carId, String carName, double carPrice, CarCategory carCategory,
                          String carManufacturer) {
        super();
        this.carId = carId;
        this.carName = carName;
        this.carPrice = carPrice;
        this.carCategory = carCategory;
        this.carManufacturer = carManufacturer;
    }

    public VehicleBuilder(String s) {
        String[] tokens = s.split(",");
        this.carId = Integer.parseInt(tokens[0]);
        this.carName = tokens[1];
        this.carPrice = Double.parseDouble(tokens[4]);
        this.carCategory = CarCategory.getCarCategory(tokens[2]);
        this.carManufacturer = tokens[3];
    }

    @Override
    public Car build() {
        // TODO Auto-generated method stub
        return CarFactory.getInstance().getObject(this);
    }
}
