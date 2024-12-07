package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Builder.BuilderAPI;
import edu.neu.csye7374.Builder.EmployeeBuilder;
import edu.neu.csye7374.Employee;

public class EmployeeFactory implements VehicleFactoryAPI<Employee> {
    private static EmployeeFactory instance; // Lazy Singleton Factory Class

    private EmployeeFactory() {
        super();
        instance = null;
    }

    public static synchronized EmployeeFactory getInstance() {
        if (instance == null) {
            instance = new EmployeeFactory();
        }
        return instance;
    }

    @Override
    public Employee getObject(BuilderAPI<Employee> builder) {
        // TODO Auto-generated method stub
        EmployeeBuilder employeeBuilder = (EmployeeBuilder) builder;
        return new Employee(employeeBuilder);
    }
}
