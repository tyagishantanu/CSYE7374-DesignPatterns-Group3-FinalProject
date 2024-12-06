package edu.neu.csye7374.Command;

import edu.neu.csye7374.Car;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Car> orderList = new ArrayList<>();

    public void takeCarOrder(Car order) {
        orderList.add(order);
    }

    public void placeCarOrders() {
        BuyVehicleCommand buyCarCommand = BuyVehicleCommand.getInstance();
        for (Car order : orderList) {
            System.out.println(buyCarCommand.setCar(order).execute());
        }
        orderList.clear();
    }

    public void placeCarOrders(List<Car> carList) {
        for (Car b : carList) {
            orderList.add(b);
        }
        placeCarOrders();
    }

    public void rentCarOrders() {
        RentVehicleCommand rentCarCommand = RentVehicleCommand.getInstance();
        for (Car order : orderList) {
            System.out.println(rentCarCommand.setCar(order)
                    .execute());
        }
        orderList.clear();
    }

    public void rentCarOrders(List<Car> carList) {
        for (Car b : carList) {
            orderList.add(b);
        }
        rentCarOrders();
    }

    public List<Car> getCarOrderList() {
        return orderList;
    }

    public void setCarOrderList(List<Car> orderList) {
        this.orderList = orderList;
    }

}
