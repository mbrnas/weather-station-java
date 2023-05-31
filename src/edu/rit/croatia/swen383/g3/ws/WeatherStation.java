package edu.rit.croatia.swen383.g3.ws;

import java.util.*;

import edu.rit.croatia.swen383.g3.ws.util.MeasurementUnit;
import edu.rit.croatia.swen383.g3.ws.factory.SensorFactory;
import edu.rit.croatia.swen383.g3.ws.observer.Subject;
import edu.rit.croatia.swen383.g3.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g3.ws.util.SensorType;

/**
 *
 * Class for a simple computer based weather station that reports the current
 * temperature (in Celsius) every second. The station is attached to a sensor
 * that reports the temperature as a 16-bit number (0 to 65535) representing the
 * Kelvin temperature to the nearest 1/100th of a degree.
 *
 * This class is implements Runnable so that it can be embedded in a Thread
 * which runs the periodic sensing.
 *
 * @author Michael J. Lutz
 * @author Kristina Marasovic
 * @version 1
 */
public class WeatherStation extends Subject implements Runnable {

    private final EnumMap<SensorType, Sensor> sensorMap = new EnumMap<>(SensorType.class);

    private EnumMap<MeasurementUnit, Double> readingMap = new EnumMap<>(MeasurementUnit.class);

    private final long PERIOD = 1000; // 1 sec = 1000 ms.

    /*
     * When a WeatherStation object is created, it in turn creates the sensor
     * object it will use. After the object is created, user needs to enter a number
     * between 1 and 3,
     * to decide which type of formatting should be used by the program
     */
    public WeatherStation(EnumMap<SensorType, Sensor> sensorMap) {

        // initialises sensor based on sensor type
        for (SensorType type : SensorType.values()) {
            this.sensorMap.put(type, SensorFactory.get(type));   
        }

    }

    /*
     * The "run" method called by the enclosing Thread object when started.
     * Repeatedly sleeps a second, acquires the current temperature from
     * its sensor, and reports this as a formatted output string.
     */
    public void run() {

        // double celsius; // sensor reading transformed to celsius
        // final int KTOC = -27315; // Convert raw Kelvin reading to Celsius
        while (true) {
            getSensorReadings();

            notifyObservers();
            try {
                Thread.sleep(PERIOD);
            } catch (Exception e) {
            } // ignore exceptions
        }
    }

    // getting the reading from the readingMap
    public double getReading(MeasurementUnit unit) {

        // return the value from the reading map based on the unit passed in
        return readingMap.get(unit);
    }

    private void getSensorReadings() {

        Sensor sensor = null;
        for (SensorType type : SensorType.values()) {

            sensor = sensorMap.get(type);

            int reading = sensor.read();

            for (MeasurementUnit unit : MeasurementUnit.valueOf(type)) {

                readingMap.put(unit, unit.get(reading));
            }
        }
    }

    /*
     * Initial main method.
     * Create the WeatherStation (Runnable).
     * Embed the WeatherStation in a Thread.
     * Start the Thread.
     */
}
