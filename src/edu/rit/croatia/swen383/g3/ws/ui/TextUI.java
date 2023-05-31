package edu.rit.croatia.swen383.g3.ws.ui;

import edu.rit.croatia.swen383.g3.ws.observer.Observer;
import edu.rit.croatia.swen383.g3.ws.util.MeasurementUnit;
import edu.rit.croatia.swen383.g3.ws.WeatherStation;

public class TextUI implements Observer {

    private WeatherStation station;

    // constructor
    public TextUI(WeatherStation station) {
        this.station = station;
        this.station.attach(this);
    }

    @Override
    public void update() {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            System.out.printf("Reading in %10s: %7.2f %n", unit, station.getReading(unit));
        }
        System.out.println("");
    }
}
