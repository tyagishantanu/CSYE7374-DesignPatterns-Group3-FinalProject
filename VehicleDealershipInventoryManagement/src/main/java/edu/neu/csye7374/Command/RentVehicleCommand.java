package edu.neu.csye7374.Command;

import edu.neu.csye7374.Car;

public class RentVehicleCommand implements CommandAPI {
    private static RentVehicleCommand instance;
    private Car car;

    private RentVehicleCommand() {
        super();
    }

    public static synchronized RentVehicleCommand getInstance() {
        if (instance == null) {
            instance = new RentVehicleCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return car.rentCar();
    }

    public Car getCar() {
        return car;
    }

    public RentVehicleCommand setCar(Car car) {
        this.car = car;
        return this;
    }

}
