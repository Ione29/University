import java.time.LocalDate;

public class dailyStats
{
    private LocalDate date;
    private double hTemp;
    private double lTemp;
    private int precipitations;
    private int snow;

    static double farenheitToCelsius(int degFarenheit)
    {
        return (degFarenheit - 32) / 1.8;
    }

    public dailyStats(LocalDate date, int hTemp, int lTemp, int precipitations, int snow)
    {
        this.date = date;
        this.hTemp = farenheitToCelsius(hTemp);
        this.lTemp = farenheitToCelsius(lTemp);
        this.precipitations = precipitations;
        this.snow = snow;
    }

    public LocalDate getDate()
    {
        return this.date;
    }

    public double getHighTemp()
    {
        return this.hTemp;
    }

    public double getLowTemp()
    {
        return this.lTemp;
    }

    public int getPrecipitations()
    {
        return this.precipitations;
    }

    public int getSnow()
    {
        return this.snow;
    }

    public String toString()
    {
        return this.date + " " + this.hTemp + " " + this.lTemp + " " + this.precipitations + " " + this.snow;
    }
}