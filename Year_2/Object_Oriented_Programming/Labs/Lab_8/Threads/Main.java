package Threads;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen(5);
        Waiter w1 = new Waiter("Miruna", kitchen);  w1.start();
        Waiter w2 = new Waiter("Mihai", kitchen);   w2.start();
        Waiter w3 = new Waiter("Radu", kitchen);    w3.start();
        Waiter w4 = new Waiter("Alina", kitchen);   w4.start();        
        Cook c1 = new Cook("Andrei", kitchen);  c1.start();
        Cook c2 = new Cook("Tiberiu", kitchen); c2.start();
        Cook c3 = new Cook("Ioan", kitchen);    c3.start();
       
    /* 
     * 
     Cook c1 = new Cook("Andrei", kitchen);  c1.start();
     Cook c2 = new Cook("Tiberiu", kitchen); c2.start();
     Cook c3 = new Cook("Ioan", kitchen);    c3.start();
     
     Waiter w1 = new Waiter("Miruna", kitchen);  w1.start();
     Waiter w2 = new Waiter("Mihai", kitchen);   w2.start();
     Waiter w3 = new Waiter("Radu", kitchen);    w3.start();
     Waiter w4 = new Waiter("Alina", kitchen);   w4.start();
     
     */
        
        
        
    }
}
