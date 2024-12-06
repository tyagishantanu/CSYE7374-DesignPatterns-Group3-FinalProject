package edu.neu.csye7374.Command;

public class BuyVehicleCommand implements CommandAPI {
    private static BuyVehicleCommand instance;
    private Car car;

    private BuyVehicleCommand() {
        super();
    }

    public static synchronized BuyVehicleCommand getInstance() {
        if (instance == null) {
            instance = new BuyVehicleCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return car.buyCar();
    }

    public Car getCar() {
        return car;
    }

    public BuyVehicleCommand setCar(Car car) {
        this.car = car;
        return this;
    }
}