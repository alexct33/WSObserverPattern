
/**
 * Created by Oriol on 19/2/2017.
 */
public interface Subject {
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void doNotify();
}
