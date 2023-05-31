package edu.rit.croatia.swen383.g3.ws;

import java.util.EnumMap;

import edu.rit.croatia.swen383.g3.ws.factory.UIFactory;
import edu.rit.croatia.swen383.g3.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g3.ws.util.SensorType;
import edu.rit.croatia.swen383.g3.ws.util.UIType;

public class WeatherStationRunner {

    private static EnumMap<SensorType, Sensor> sensorMap = new EnumMap<>(SensorType.class);

    public static void main(String[] args) {

        WeatherStation ws = new WeatherStation(sensorMap);
        for (UIType type : UIType.values()) {
            UIFactory.get(type, ws);
        }
        Thread thread = new Thread(ws);
        thread.start();
    }
}
