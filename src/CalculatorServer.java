package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImplementation calculator = new CalculatorImplementation();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculator", calculator);
            System.out.println("Calculator server is running on port 1099...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
