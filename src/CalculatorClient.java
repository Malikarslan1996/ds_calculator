package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("Calculator");

            // Push values onto the server's stack
            calculator.pushValue(10);
            calculator.pushValue(5);
            calculator.pushValue(15);
            calculator.pushValue(20);
            calculator.pushValue(25);


            // Push operations to perform on the stack
            calculator.pushOperation("min");
            // calculator.pushOperation("max");
            // calculator.pushOperation("lcm");
            // calculator.pushOperation("gcd");


            // Pop the results and display them
            System.out.println("Minimum value: " + calculator.pop());
            // System.out.println("Maximum value: " + calculator.pop());

            calculator.pushValue(10);
            calculator.pushValue(5);
            calculator.pushValue(15);
            calculator.pushValue(20);
            calculator.pushValue(25);
            calculator.pushOperation("max");
            System.out.println("Maximum value: " + calculator.pop());



            calculator.pushValue(10);
            calculator.pushValue(5);
            calculator.pushValue(15);
            calculator.pushValue(20);
            calculator.pushValue(25);
            calculator.pushOperation("lcm");

            System.out.println("Least Common Multiple: " + calculator.pop());



            calculator.pushValue(10);
            calculator.pushValue(5);
            calculator.pushValue(15);
            calculator.pushValue(20);
            calculator.pushValue(25);
            calculator.pushOperation("gcd");

            System.out.println("Greatest Common Divisor: " + calculator.pop());

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
