import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;

    public CalculatorImplementation() throws RemoteException {
        super();
        stack = new Stack<>();
    }

    public void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    public void pushOperation(String operator) throws RemoteException {
        if (!stack.isEmpty()) {
            int result;
            switch (operator) {
                case "min":
                    result = stack.stream().min(Integer::compare).get();
                    break;
                case "max":
                    result = stack.stream().max(Integer::compare).get();
                    break;
                case "lcm":
                    result = calculateLCM();
                    break;
                case "gcd":
                    result = calculateGCD();
                    break;
                default:
                    throw new RemoteException("Invalid operator: " + operator);
            }
            stack.clear();
            stack.push(result);
        }
    }

    private int calculateLCM() {
        int result = 1;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            result = lcm(result, value);
        }
        return result;
    }

    private int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private int calculateGCD() {
        int result = 0;
        if (!stack.isEmpty()) {
            result = stack.pop();
        }
        while (!stack.isEmpty()) {
            int value = stack.pop();
            result = gcd(result, value);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public int pop() throws RemoteException {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new RemoteException("Stack is empty");
        }
    }

    public boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    public int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
            return pop();
        } catch (InterruptedException e) {
            throw new RemoteException("Delay pop interrupted");
        }
    }
}
