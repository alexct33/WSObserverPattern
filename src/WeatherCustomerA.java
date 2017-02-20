/**
 * Created by Oriol on 19/2/2017.
 */
public class WeatherCustomerA implements Observer {
    private String name;
    private int temperature;

    @Override
    public void doUpdate(int temperature) {
        System.out.println("Weather customer A just found out the temperature is:" + temperature);
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

}
