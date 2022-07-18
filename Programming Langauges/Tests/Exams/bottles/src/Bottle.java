public class Bottle
{
    private float capacity;
    private float quantity;
    private float price;

    public Bottle(float capacity, float price) {
        this.capacity = capacity;
        this.price = price;
        this.quantity = 0;
    }

    public Bottle(float price)
    {
        this.price = price;
        this.capacity = 1;
        this.quantity = 0;
    }

}
