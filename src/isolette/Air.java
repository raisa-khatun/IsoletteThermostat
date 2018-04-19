package isolette;

public class Air {
	private static double currentTemperature = 100.0;
	
	/**
	 * Returns the current temperature to the calling class
	 * @return current air temperature
	 */
	public static double sendCurrentTemperatureToSensor() {
		return currentTemperature;
	}
	
	/**
	 * Changes the current temperature by averaging the current temperature, heat increase and infant temperature
	 * @param heatIncrease Amount to increase or decrease current temperature by
	 */
	public static void changeCurrentTemperature(double heatIncrease) {
		double sum = (currentTemperature + heatIncrease + InfantSensor.sendInfantTemperature());
		double avg = sum/2.0;
		currentTemperature = avg;
	}
	
}