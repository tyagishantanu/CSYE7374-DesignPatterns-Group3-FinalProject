package edu.neu.csye7374.Command;

import edu.neu.csye7374.Vehicle;

public class BuyVehicleCommand implements CommandAPI {
    private static BuyVehicleCommand instance;
    private Vehicle vehicle;

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
        return vehicle.buyVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public BuyVehicleCommand setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}