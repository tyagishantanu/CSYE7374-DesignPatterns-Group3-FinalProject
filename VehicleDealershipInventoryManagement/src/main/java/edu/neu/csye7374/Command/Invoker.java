package edu.neu.csye7374.Command;

import edu.neu.csye7374.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Vehicle> orderList = new ArrayList<>();

    public void takeVehicleOrder(Vehicle order) {
        orderList.add(order);
    }

    public void placeVehicleOrders() {
        BuyVehicleCommand buyVehicleCommand = BuyVehicleCommand.getInstance();
        for (Vehicle order : orderList) {
            System.out.println(buyVehicleCommand.setVehicle(order).execute());
        }
        orderList.clear();
    }

    public void placeVehicleOrders(List<Vehicle> vehicleList) {
        for (Vehicle b : vehicleList) {
            orderList.add(b);
        }
        placeVehicleOrders();
    }

    public void rentVehicleOrders() {
        RentVehicleCommand rentVehicleCommand = RentVehicleCommand.getInstance();
        for (Vehicle order : orderList) {
            System.out.println(rentVehicleCommand.setVehicle(order)
                    .execute());
        }
        orderList.clear();
    }

    public void rentVehicleOrders(List<Vehicle> vehicleList) {
        for (Vehicle b : vehicleList) {
            orderList.add(b);
        }
        rentVehicleOrders();
    }

    public List<Vehicle> getVehicleOrderList() {
        return orderList;
    }

    public void setVehicleOrderList(List<Vehicle> orderList) {
        this.orderList = orderList;
    }

}
