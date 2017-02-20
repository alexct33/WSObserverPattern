import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(33);
        WeatherCustomerA wc1 = new WeatherCustomerA();
        WeatherCustomerB wc2 = new WeatherCustomerB();


        weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);

        weatherStation.setTemperature(34);

        weatherStation.removeObserver(wc1);

        weatherStation.setTemperature(35);

        WeatherStationGUI gui = new WeatherStationGUI();
        gui.init();
    }
}
