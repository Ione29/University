package Threads;
import java.util.concurrent.atomic.AtomicInteger;

public class Pizza{
    private int id;
    private static AtomicInteger count = new AtomicInteger(1);
    private Integer nrOfIngredients;

    public Pizza(Integer vNrOfIngredients){
        this.id = count.incrementAndGet();
        this.nrOfIngredients = vNrOfIngredients;
    }

    public Integer getId(){
        return this.id;
    }

    public Integer getNrOfIngredients(){
        return this.nrOfIngredients;
    }
}