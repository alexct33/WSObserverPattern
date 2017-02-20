import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

/**
 * Created by Àlex on 20/2/2017.
 */
public class WeatherStationGUI {
    private JList list1;
    private JButton subscribeWeatherCustomerAButton;
    private JButton subscribeWeatherCustomerBButton;
    private JPanel panel1;
    private JTextArea sdgTextArea;

    WeatherStation weatherStation = new WeatherStation(33);
    WeatherCustomerA wc1 = new WeatherCustomerA();
    WeatherCustomerB wc2 = new WeatherCustomerB();


    public WeatherStationGUI() {
        subscribeWeatherCustomerAButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                weatherStation.addObserver(wc1);
            }
        });
        subscribeWeatherCustomerBButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                weatherStation.addObserver(wc2);
            }
        });
    }

    public void init() {
        JFrame jf = new JFrame("WS");
        jf.setContentPane(new WeatherStationGUI().panel1 );
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        weatherStation.addObserver(wc1);
        Set<Observer> listSubscriptors =  weatherStation.getObservers();

        java.util.List<Observer> listAux = null;
        listAux.addAll(listSubscriptors);

        while (true) {

            list1.setModel((ListModel) listAux);


        }


    }
}
