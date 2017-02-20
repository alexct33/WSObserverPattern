/**
 * Created by Oriol on 19/2/2017.
 */
public class WeatherCustomerB implements Observer {

    @Override
    public void doUpdate(int temperature) {
        System.out.println("Weather customer B just found out the temperature is:" + temperature);
    }

}
