package thermostat_system;

import java.text.DecimalFormat;

public class TemperatureSensor {
	private Air air;
	private DecimalFormat formatter;
	public TemperatureSensor() {
		air = Air.getInstance();
		formatter = new DecimalFormat("0.0");
	}
	
	public double getCurrentTemperature() {
		return air.getCurrentTemperature();
	}
	
	public String toString() {
		
		return "Temperature in Isolette: " + formatter.format(getCurrentTemperature()) + "F";
	}
}
