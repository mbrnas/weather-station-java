package edu.rit.croatia.swen383.g3.ws.ui;

/*
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributers
 *
 * Acknowledgements
 */

/*
 * Swing UI class used for displaying the information from the
 * associated weather station object.
 * This is an extension of JFrame, the outermost container in
 * a Swing application.
 */

import java.awt.Font;
import java.awt.GridLayout;
import java.util.EnumMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.rit.croatia.swen383.g3.ws.observer.Observer;
import edu.rit.croatia.swen383.g3.ws.util.MeasurementUnit;
import edu.rit.croatia.swen383.g3.ws.WeatherStation;

public class SwingUI extends JFrame implements Observer {

    /*
     * A Font object contains information on the font to be used to
     * render text.
     */
    private final Font labelFont = new Font(Font.SERIF, Font.PLAIN, 52);

    // create a label map as an enum map
    private final EnumMap<MeasurementUnit, JLabel> JLabelMap = new EnumMap<>(MeasurementUnit.class);

    // WeatherStation
    private WeatherStation station;

    /*
     * Create and populate the SwingUI JFrame with panels and labels to
     * show the temperatures.
     */

    public SwingUI(WeatherStation station) {
        super("Weather Station");
        this.station = station;
        this.station.attach(this);

        /*
         * WeatherStation frame is a grid of 1 row by an indefinite
         * number of columns.
         */
        this.setLayout(new GridLayout(1, 0));

        /*
         * There are two panels, one each for Kelvin and Celsius, added to the
         * frame. Each Panel is a 2 row by 1 column grid, with the temperature
         * name in the first row and the temperature itself in the second row.
         */
        JPanel jpanel;

        for (MeasurementUnit unit : MeasurementUnit.values()) {
            jpanel = createJPanel(unit);
            this.add(jpanel);
        }

        /*
         * Set up the frame's default close operation pack its elements,
         * and make the frame visible.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /*
     * Create a Label with the initial value <title>, place it in
     * the specified <panel>, and return a reference to the Label
     * in case the caller wants to remember it.
     */
    private JLabel createJLabel(String title) {
        JLabel jlabel = new JLabel(title);

        jlabel.setHorizontalAlignment(JLabel.CENTER);
        jlabel.setVerticalAlignment(JLabel.TOP);
        jlabel.setFont(labelFont);
        return jlabel;
    }

    private JPanel createJPanel(MeasurementUnit unit) {

        JPanel jpanel = new JPanel(new GridLayout(2, 1));
        jpanel.add(createJLabel(unit.name()));
        // add labels for cel and kelvins to the map
        JLabelMap.put(unit, createJLabel(""));
        jpanel.add(JLabelMap.get(unit));
        return jpanel;
    }

    /// public method to set the labels in weather station
    public void setJLabel(MeasurementUnit unit, double temperature) {
        JLabelMap.get(unit).setText(String.format("%6.2f", temperature));
    }

    @Override
    public void update() {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            setJLabel(unit, station.getReading(unit));
        }
    }
}