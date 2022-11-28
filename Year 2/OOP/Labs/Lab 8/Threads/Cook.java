package Threads;
import java.util.Random;

public class Cook extends Thread{
    private Kitchen shared;
    public Pizza pizza;

    public Cook(String name, Kitchen vShared){
        super(name);
        this.shared = vShared;
    }

    @Override
    public void run(){
        Random random = new Random();
        
        while(true){
            pizza = new Pizza(random.nextInt(3, 7));
            shared.produce(pizza);
            System.out.println("Pizza " + pizza.getId() + "was added.");
            try{
                sleep(5 + pizza.getNrOfIngredients() * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
}
