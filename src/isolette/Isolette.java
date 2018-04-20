package isolette;

public class Isolette {
	private HeatSource heatSource;
	private TemperatureSensor tempSensor;
	private static InfantSensor infantSensor;
	
	public Isolette() {
		heatSource = new HeatSource();
		tempSensor = new TemperatureSensor();
		infantSensor = new InfantSensor();
	}
	
	public double getTemperatureFromSensor() {
		return tempSensor.sendCurrentTemperatureToIsolette();
	}
	
	public boolean heatSourceStatus() {
		return heatSource.getStatus();
	}
	
	public void sendHeatSignal() {
		heatSource.heatAir();
	}
	
	public void toggleHeatSource() {
		heatSource.toggleStatus();
	}
	
}
