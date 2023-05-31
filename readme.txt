WEATHER STATION APPLICATION

Modified by:
    Group 3 {SWEN.383, Section 800}


Weather Station is a simple computer-based application written in Java programming language that consist of five separate classes:

- TemperatureSensor.java ; contains a Random and acts as a simulated sensor of random temperature changes (in kelvin) which are 
    evaluated inside the public read() method that returns an int "currentReading"
- SwingUI.java ; extends JFrame and displays information from the associated weather station object
- MeasurementUnit.java ; an enum class that handles all the possible forms of value (celsius, kelvin, mbar, Fahrenheit, inches)
- PressureSensor.java ; class for a (simulated) barometer wjhich simulates a new reading based on the last reading and whether the trend * is up or down
- Sensor.java ; interface that holds an instance of Random and the read() method that is implemented in TemperatureSensor and PressureSensor classes
- SensorFactory.java ; a public SesorFactory class which is used to "produce" or decide on which sensor type will be returned in the WeatherStation
- SensorType.java ; an enum class that contains a default constructor and holds two values: TEMPERATURE & PRESSURE
- TextUI.java ; a class used for updating the readings on the map and formatting the output
- WeatherStationUI.java ; an interface which contains the update() method that takes an EnumMap
- WeatherStation.java ; contains the run() & getSensorReadings() methods and a constructor that takes in an instance of WeatherStationUI to instatiate the UI
==> WeatherStationRunner.java ; main class which contain teh main() metjod and runs the application, constains the switch case for text or UI display

In addition to the GUI display (SwingUI), the program has been constructed in a way that enables the same 
functionality in the terminal upon it being run.
Once the application has been started, the program will issue a prompt inside the terminal that will offer the three options to the user:

    1 - SwingUI ; temperature display inside a JPanel
    2 - Text format ; temperature display in text format inside the terminal.

The displays provide the same functionality of displaying the temperature changes each second that have been read from the sensor.
And all three display the temperature changes in both Celsius and Kelvin.

In case the input does not belong to the set of numbers ranging from 1 to 3 (inclusive), is not a number, or there was no input given, the 
program will automatically initiate the option to display the readings in text format inside the terminal after displaying the following 
message: "Wrong selection, moved to text format".