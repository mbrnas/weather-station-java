package edu.rit.croatia.swen383.g3.ws.adapter;

import edu.rit.croatia.swen383.g3.ws.sensor.Sensor;
import edu.rit.marasovic.swen383.thirdparty.sensor.HumidityReader;

/**
 * the sensor class implements the Sensor interface and acts as an adapter in
 * the application
 */
public class HumiditySensor implements Sensor {

    // declaring a private humidity reader variable the adapter will use and call
    // the get() method on
    private HumidityReader humidityReader;

    public HumiditySensor() {

        this.humidityReader = new HumidityReader();
    }

    @Override
    public int read() {

        return humidityReader.get();
    }

}
