package edu.neu.csye7374;

import edu.neu.csye7374.Builder.EmployeeBuilder;
import edu.neu.csye7374.Builder.VehicleBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Decorator.Insurance;
import edu.neu.csye7374.Decorator.SeatCoverDecorator;
import edu.neu.csye7374.Decorator.VehicleDecorator;
import edu.neu.csye7374.Facade.VehicleDeliveryType;
import edu.neu.csye7374.Facade.VehicleOrderFacade;
import edu.neu.csye7374.Factory.EmployeeFactory;
import edu.neu.csye7374.Factory.VehicleFactory;
import edu.neu.csye7374.Observer.VehicleOrder;
import edu.neu.csye7374.Strategy.*;
import edu.neu.csye7374.FileUtil.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleDealership {
    private String name;
    private List<Vehicle> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static OfferStrategy usingStrategy = OfferStrategy.NONE;
    private static final String FILE_NAME = "src/main/java/edu/neu/csye7374/datastore/VehiclesData.txt";

    private static Map<OfferStrategy, OfferStrategyAPI> strategyMap = new HashMap<>();
    {
        strategyMap.put(OfferStrategy.StudentOfferStrategy, new StudentOfferStrategy());
        strategyMap.put(OfferStrategy.ExchangeOfferStrategy, new ExchangeOfferStrategy());
        strategyMap.put(OfferStrategy.FamilyOfferStrategy, new FamilyOfferStrategy());
        strategyMap.put(OfferStrategy.NewMemberOfferStrategy, new NewMemberOfferStrategy());
    }

    public VehicleDealership(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getItemList() {
        return itemList;
    }

    public void setItemList(List<Vehicle> itemList) {
        this.itemList = itemList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public static OfferStrategy getUsingStrategy() {
        return usingStrategy;
    }

    public static void setUsingStrategy(OfferStrategy usingStrategy) {
        VehicleDealership.usingStrategy = usingStrategy;
    }

    public static Map<OfferStrategy, OfferStrategyAPI> getstrategyMap() {
        return strategyMap;
    }

    public static void setAlgorithmMap(Map<OfferStrategy, OfferStrategyAPI> strategyMap) {
        VehicleDealership.strategyMap = strategyMap;
    }

    public static void demo() {

        FileUtil.getFileData(FILE_NAME);

        List<Vehicle> vehicleList = new ArrayList<>();
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("------------ Builder ------- Eager Singleton ------- Factory Patterns used -------");
        VehicleBuilder vehicleBuilder = new VehicleBuilder(1, "Porsche-811", 115000, VehicleCategory.Sports, "Porsche");
        VehicleAPI vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle) vehicle);
        System.out.println("");
        System.out.println(vehicle);
        FileUtil.appendEntryToFile(FILE_NAME, vehicleBuilder);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));

        System.out.println("\n");
        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Prototype ------------");
        System.out.println("");
        Manufacturer manufact = Manufacturer.getInstance();
        Manufacturer man = manufact.clone();
        man.setManufacturerName("Porsche")
                .setManufacturingYear(2020)
                .setNoOfVehiclesReleased(20);
        System.out.println(man);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Adapter Pattern using Vehicle ------------");
        System.out.println("");
        ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(vehicle, man);

        System.out.println(manufacturerAdapter);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Facade ----------- Decorator ---------- Observer ------------");
        System.out.println("");
        VehicleOrderFacade orderFacade = new VehicleOrderFacade(vehicle);
        VehicleOrder order = orderFacade.vehicleOrder();
        System.out.println("");
        System.out.println(order);
        System.out.println("");
        order.setVehicleDeliveryType(VehicleDeliveryType.Delivery);

        vehicleBuilder = new VehicleBuilder(2, "C-Class", 45000.0, VehicleCategory.Sedan, "Porche");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        VehicleDecorator carWithSeatDecorator = new SeatCoverDecorator(vehicle);
        System.out.println(carWithSeatDecorator);
        order.addVehicle(carWithSeatDecorator);
        System.out.println("");
        System.out.println(order);
        System.out.println("");
        vehicleList.add((Vehicle) vehicle);
        FileUtil.appendEntryToFile(FILE_NAME, vehicleBuilder);

        vehicleBuilder = new VehicleBuilder(3, "D-Class", 49000.0, VehicleCategory.Sports, "Porche");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        VehicleDecorator vehicleWithInsurance = new Insurance(vehicle);
        System.out.println(vehicleWithInsurance);
        order.addVehicle(vehicleWithInsurance);
        System.out.println("");
        System.out.println(order);
        System.out.println("");
        vehicleList.add((Vehicle) vehicle);
        FileUtil.appendEntryToFile(FILE_NAME, vehicleBuilder);

        vehicleBuilder = new VehicleBuilder(4, "M-Class", 60000.0, VehicleCategory.MiniVan, "Porche");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        order.addVehicle(vehicle);
        System.out.println(order);
        vehicleList.add((Vehicle) vehicle);
        FileUtil.appendEntryToFile(FILE_NAME, vehicleBuilder);

        vehicleBuilder = new VehicleBuilder(5, "Z-Class", 145000.0, VehicleCategory.Limo, "Porche");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        order.addVehicle(vehicle);
        System.out.println(order);
        vehicleList.add((Vehicle) vehicle);

        vehicleBuilder = new VehicleBuilder(6, "S-Class", 45000.0, VehicleCategory.SUV, "Porche");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        order.addVehicle(vehicle);
        System.out.println(order);
        vehicleList.add((Vehicle) vehicle);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Command Pattern ------------");
        System.out.println("");
        Invoker invoker = new Invoker();
        System.out.println("######## Sold Cars #########");
        invoker.placeVehicleOrders(vehicleList);
        System.out.println("");
        System.out.println("######## Rented Cars #########");
        invoker.rentVehicleOrders(vehicleList);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Factory ------------ Singleton ---------- EmployeeBuilder ----------");
        System.out.println("");
        VehicleDealership vehicleDealership = new VehicleDealership("Super Cars Store");
        EmployeeBuilder emplBuilder = new EmployeeBuilder(7, 27, "John", "Doe", 18.5);
        Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
        System.out.println(empl);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- State ------------");
        System.out.println("");

        order.confirmOrder();
        System.out.println("Trying to confirm the order after the order is confirmed");
        order.vehicleConfirmed_state();
        System.out.println("Trying to deliver the order after the order is confirmed");
        order.vehicleDelivered_state();
        System.out.println("Trying to dispatch the order after the order is confirmed");
        order.vehicleDeliveryStatus_state();
        System.out.println("Trying to deliver the order after the order is dispatched");
        order.vehicleDelivered_state();
        System.out.println("Trying to deliver the order after the order is delivered");
        order.vehicleDelivered_state();
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Strategy ------------");
        System.out.println("");
        System.out.println("Bike before discount: \n" + vehicle);
        double price = 0;
        for (OfferStrategy strategy : VehicleDealership.getstrategyMap().keySet()) {
            order.setUsingStrategy(strategy);
            price = order.runStrategy();
            System.out.println("Bike price after discount during sale: " + strategy + " Price :" + price);
        }
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");
    }

}
