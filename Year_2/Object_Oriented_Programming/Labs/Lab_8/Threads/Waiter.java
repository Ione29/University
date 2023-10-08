package Threads;

public class Waiter extends Thread{
    private Kitchen shared;
    
    public Waiter(String name, Kitchen vShared){
        super(name);
        this.shared = vShared;
    }

    @Override
    public void run(){
        while(true){
            Pizza pizza = shared.remove();
            System.out.println("Pizza " + pizza.getId() + " was removed.");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
