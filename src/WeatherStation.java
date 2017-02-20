import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Oriol on 19/2/2017.
 */
public class WeatherStation implements Subject {

    Set<Observer> Observers;
    int temperature;

    public WeatherStation(int temperature) {
        Observers = new HashSet<Observer>();
        this.temperature = temperature;
    }

    @Override
    public void addObserver(Observer Observer) {
        Observers.add(Observer);
    }

    @Override
    public void removeObserver(Observer Observer) {
        Observers.remove(Observer);
    }

    @Override
    public void doNotify() {
        Iterator<Observer> it = Observers.iterator();
        while (it.hasNext()) {
            Observer Observer = it.next();
            Observer.doUpdate(temperature);
        }
    }

    public void setTemperature(int newTemperature) {
        System.out.println("\nWeather station setting temperature to " + newTemperature);
        temperature = newTemperature;
        doNotify();
    }

    public Set<Observer> getObservers() {
        return Observers;
    }

}
