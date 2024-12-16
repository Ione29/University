package ex_02;

public class Car {

    public enum Sound{
        RadioCD,
        RadioCassette,
        MP3
    }

    public enum Navigation{
        None,
        Small,
        Medium,
        Large
    }

    public enum Air{
        None,
        Manual,
        Automatic
    }

    private final String brand;
    private final int year;
    private final int power;
    private final String fuel;
    private final String vin;

    private Sound sound;
    private Navigation navigation;
    private Air air;

    public Car(String brand, int year, int power, String fuel, String vin, Sound sound, Navigation navigation, Air air) {
        this.brand = brand;
        this.year = year;
        this.power = power;
        this.fuel = fuel;
        this.vin = vin;
        this.sound = sound;
        this.navigation = navigation;
        this.air = air;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", power=" + power +
                ", fuel='" + fuel + '\'' +
                ", chassis number='" + vin + '\'' +
                ", sound=" + sound +
                ", navigation=" + navigation +
                ", air=" + air +
                '}';
    }

    public String getBrand() {

        return brand;
    }

    public int getYear() {

        return year;
    }

    public int getPower() {

        return power;
    }

    public String getFuel() {

        return fuel;
    }

    public String getVin() {

        return vin;
    }

    public Sound getSound() {

        return sound;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public Air getAir() {
        return air;
    }

    static class Builder{
        private String brand;
        private int year;
        private int power;
        private String fuel;
        private String vin;
        private Sound sound;
        private Navigation navigation;
        private Air air;

        public Builder(String brand, int year, int power, String fuel, String vin) {
            this.brand = brand;
            this.year = year;
            this.power = power;
            this.fuel = fuel;
            this.vin = vin;
            this.sound = Sound.RadioCD;
            this.navigation = Navigation.None;
            this.air = Air.Manual;
        }

        public Builder sound(Sound sound) {
            this.sound = sound;
            return this;
        }

        public Builder navigation(Navigation navigation) {
            this.navigation = navigation;
            return this;
        }

        public Builder air(Air air) {
            this.air = air;
            return this;
        }

        public Car build() {
            return new Car(brand, year, power, fuel, vin, sound, navigation, air);
        }
    }

    public static void main(String[] args) {
        Car fordTrend=new Car.Builder("Ford",2009,87,"diesel","XYZ").build();
        Car fordTitanium=new Car.Builder("Ford",2018,125,"diesel","WWW").sound(Sound.MP3).navigation(Navigation.Small).build();
        Car fordEco = new Car.Builder("Ford",2019,100,"gas","YHD").air(Air.Automatic).build();
        System.out.println(fordTrend.toString() + '\n' + fordTitanium.toString() + '\n' + fordEco.toString());
    }


}