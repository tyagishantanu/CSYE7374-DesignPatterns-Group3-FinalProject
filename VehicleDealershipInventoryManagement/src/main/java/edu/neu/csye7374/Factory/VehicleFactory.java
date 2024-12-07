package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Builder.BuilderAPI;
import edu.neu.csye7374.Builder.VehicleBuilder;
import edu.neu.csye7374.Vehicle;

public class VehicleFactory implements VehicleFactoryAPI<Vehicle> {
    private static VehicleFactory instance = new VehicleFactory(); // Eager Singleton Factory Class
    
    private VehicleFactory() {
            super();
            }
    
    public synchronized static VehicleFactory getInstance() {
            return instance;
            }
    
    @Override
    public Vehicle getObject(BuilderAPI<Vehicle> builder) {
            // TODO Auto-generated method stub
            VehicleBuilder vehicleBuilder = (VehicleBuilder) builder;
            return new Vehicle(vehicleBuilder);
            }
}
