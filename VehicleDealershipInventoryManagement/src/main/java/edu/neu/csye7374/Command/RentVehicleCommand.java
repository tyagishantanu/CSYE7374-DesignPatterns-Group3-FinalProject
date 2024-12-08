package edu.neu.csye7374.Command;

import edu.neu.csye7374.Vehicle;

public class RentVehicleCommand implements CommandAPI {
    private static RentVehicleCommand instance;
    private Vehicle vehicle;

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
        return vehicle.rentVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public RentVehicleCommand setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

}
