package edu.rit.croatia.swen383.g3.ws.factory;

import edu.rit.croatia.swen383.g3.ws.WeatherStation;
import edu.rit.croatia.swen383.g3.ws.observer.Observer;
import edu.rit.croatia.swen383.g3.ws.ui.SwingUI;
import edu.rit.croatia.swen383.g3.ws.ui.TextUI;
import edu.rit.croatia.swen383.g3.ws.util.UIType;

public class UIFactory {
    public static Observer get(UIType uiType, WeatherStation station) {

        switch (uiType) {

            // a case for pressure sensor
            case TEXT:
                return new TextUI(station);
            // a case fo temperature sensor
            case SWING:
                return new SwingUI(station);
            // a default case
            default:
                return null;
        }
    }
}