package isolette;

public class TemperatureSensor implements Runnable{

	/**
	 * Returns the current temperature of the Air in the Isolette
	 * @return double value representing current temperature
	 */
	private double currentTemperature = 100.0;
	private double infantsTemp=100.0;
	public double sendCurrentTemperature() {
		return currentTemperature;
	}
	public void changeCurrentTemperature(double heatIncrease) {
		double sum = (currentTemperature + heatIncrease + infantsTemp);
		double avg = sum/2.0;
		currentTemperature = avg;
	}

	public double getInfantTemp(double infantstemp) {
		infantsTemp=infantstemp;
		return infantsTemp;	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}