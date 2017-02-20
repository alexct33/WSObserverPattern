import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Àlex on 20/2/2017.
 */
public class WeatherStationGUI {
    private JButton subscribeWeatherCustomerAButton;
    private JButton subscribeWeatherCustomerBButton;
    private JPanel panel1;
    private JTextArea weatherStationTemperatureTextArea;
    private JTextField textField1;
    private JButton unsubscribeCustomerAButton;
    private JButton unsubscribeCustomerBButton;
    private JTextArea subscriptorsTextArea;
    private JTextArea textArea1, textArea2, textArea3;
    private List<String> WSnames;
    private JFrame jf = new JFrame("WS");
    private DefaultListModel listAux;
    private int listPointer;
    private static boolean subscribeA, subscribeB, unsubscribeA, unsubscribeB;

    WeatherStation weatherStation;
    WeatherCustomerA wc1;
    WeatherCustomerB wc2;


    public WeatherStationGUI() {
        subscribeWeatherCustomerAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // WSnames.add(wc1.getName());
                subscribeA = true;

            }
        });
        unsubscribeCustomerBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unsubscribeB = true;
            }
        });
        unsubscribeCustomerAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unsubscribeA = true;
            }
        });
        subscribeWeatherCustomerBButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                subscribeB = true;
            }
        });
    }

    public void init() {
        weatherStation = new WeatherStation(33);
        wc1 = new WeatherCustomerA();
        wc2 = new WeatherCustomerB();



        listPointer = 0;
        jf.setContentPane(new WeatherStationGUI().panel1 );
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        wc1.setName("WC1");
        wc2.setName("WC2");

        /*weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);

        Set<Observer> listSubscriptors =  weatherStation.getObservers();*/


        listAux = new DefaultListModel();
        subscribeWeatherCustomerAButton = new JButton();
        //listAux.add(0,wc1.getName());
        //weatherStation.addObserver(wc1);
        JList list1 = new JList(listAux);
        //listAux.add(0," ");
        textArea1 = new JTextArea(String.valueOf(0));
        textArea2 = new JTextArea("Customer A not subscrived yet");
        textArea3 = new JTextArea("Customer B not subscrived yet");


        jf.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        jf.add(list1,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;      //make this component tall
        gbc.weightx = 0.0;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;

        jf.add(textArea1,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;

        jf.add(textArea2,gbc);

        gbc.weightx = 2;
        gbc.gridx = 2;
        gbc.gridy = 1;

        jf.add(textArea3,gbc);

        jf.pack();
        jf.setVisible(true);
        jf.setSize(1000,700);

        while (true) {
            Random randomGenerator = new Random();
            int n = randomGenerator.nextInt(50);
            weatherStation.setTemperature(n);
            textArea1.setText("Current Temperature: " + String.valueOf(n));

            textArea2.setText("Temperature of Customer A: " + String.valueOf(wc1.getTemperature()));
            textArea3.setText("Temperature of Customer B: " + String.valueOf(wc2.getTemperature()));

            if (subscribeA && !listAux.contains(wc1.getName())) {
                weatherStation.addObserver(wc1);
                listAux.add(0, wc1.getName());
                subscribeA = false;
            }
            else if (subscribeB && !listAux.contains(wc2.getName())) {
                weatherStation.addObserver(wc2);
                listAux.add(1,wc2.getName());
                subscribeB = false;
            }

            else if (unsubscribeA) {
                weatherStation.removeObserver(wc1);
                listAux.remove(0);
                unsubscribeA = false;
                subscribeA = false;
                wc1.doUpdate(0);

            }

            else if (unsubscribeB) {
                weatherStation.removeObserver(wc2);
                listAux.remove(1);
                unsubscribeB = false;
                subscribeB = false;
                wc2.doUpdate(0);
            }


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        WeatherStationGUI gui = new WeatherStationGUI();
        gui.init();

    }
}
