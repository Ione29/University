public class CalculatorImpl extends java.rmi.server.UnicastRemoteObject implements Calculator {
    // Implementations must have an explicit constructor
    // in order to declare the RemoteException exception
    public CalculatorImpl() throws java.rmi.RemoteException {
        super();
    }

    public long add(long a, long b) throws java.rmi.RemoteException {
        return a + b;
    }

    public long sub(long a, long b) throws java.rmi.RemoteException {
        return a - b;
    }

    public long multiply(long a, long b) throws java.rmi.RemoteException {
        return a * b;
    }

    public double divide(long a, long b) throws java.rmi.RemoteException {
        if (b == 0) {
            throw new java.rmi.RemoteException("Division by zero");
        }
        return (double) a / b;
    }
}
