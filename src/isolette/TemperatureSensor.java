package isolette;

public class TemperatureSensor {
	
	/**
	 * Returns the current temperature of the Air in the Isolette
	 * @return double value representing current temperature
	 */
	public double sendCurrentTemperatureToIsolette() {
		return Air.sendCurrentTemperatureToSensor();
	}

}