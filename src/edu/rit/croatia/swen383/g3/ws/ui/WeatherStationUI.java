package edu.rit.croatia.swen383.g3.ws.ui;

import java.util.EnumMap;

import edu.rit.croatia.swen383.g3.ws.util.MeasurementUnit;

public interface WeatherStationUI {
    public void update(EnumMap<MeasurementUnit, Double> readingMap);
}
