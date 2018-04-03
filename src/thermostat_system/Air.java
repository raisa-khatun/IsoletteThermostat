package thermostat_system;

/**
 * Singleton class to only have one instance of Air
 */
public final class Air {
	private static double currentTemperature;
	private static volatile Air instance = null;
	
	private Air() {
		// Default value of 70F
		currentTemperature = 70.0;
	}
	
	public static Air getInstance() {
		if (instance == null) {
			synchronized (Air.class) {
				if (instance == null) {
					instance = new Air();
				}
			}
		}
		return instance;
	}
	
	public double getCurrentTemperature() {
		return currentTemperature;
	}
	
	public void setCurrentTemperature(double newTemperature) {
		currentTemperature = newTemperature;
	}
}
