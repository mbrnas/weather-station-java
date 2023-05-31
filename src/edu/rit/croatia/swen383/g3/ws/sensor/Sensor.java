package edu.rit.croatia.swen383.g3.ws.sensor;



// interface that holds an instance of Random 
// and the read() method that is implemented in TemperatureSensor and PressureSensor classes
public interface Sensor {

    // method that returns the current reading
    // aka temperature change value
    public int read();
}