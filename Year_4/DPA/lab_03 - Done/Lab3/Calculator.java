public interface Calculator extends java.rmi.Remote {
    public long add(long a, long b) throws java.rmi.RemoteException;
    public long sub(long a, long b) throws java.rmi.RemoteException;
    public long multiply(long a, long b) throws java.rmi.RemoteException;
    public double divide(long a, long b) throws java.rmi.RemoteException;
}