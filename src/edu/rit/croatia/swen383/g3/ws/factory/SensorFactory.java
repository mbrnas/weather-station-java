
package edu.rit.croatia.swen383.g3.ws.factory;

import edu.rit.croatia.swen383.g3.ws.adapter.HumiditySensor;
import edu.rit.croatia.swen383.g3.ws.sensor.PressureSensor;
import edu.rit.croatia.swen383.g3.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g3.ws.sensor.TemperatureSensor;
import edu.rit.croatia.swen383.g3.ws.util.SensorType;

// a public SensorFactory class which is used to "produce" or decide on 
// which sensor type will be returned in the WeatherStation
public class SensorFactory {

    public static Sensor get(SensorType sensorType) {

        switch (sensorType) {

            // a case for pressure sensor
            case PRESSURE:
                return new PressureSensor();
            // a case fo temperature sensor
            case TEMPERATURE:
                return new TemperatureSensor();
            case HUMIDITY:
                return new HumiditySensor();
            // a default case
            default:
                return null;
        }
    }
}
