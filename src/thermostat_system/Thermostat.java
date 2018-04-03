package thermostat_system;

public class Thermostat {
	private TemperatureSensor tSensor;
	private HeatSource heatSource;
	private OperatorInterface opInterface;
	private int count;
	
	public Thermostat() {
		tSensor = new TemperatureSensor();
		heatSource = new HeatSource();
		opInterface = new OperatorInterface();
		count = 0;
	}
	
	public void round() {
		count++;
		System.out.println("Round no: " + count);
		System.out.println(tSensor.toString());	
		System.out.println(heatSource.toString());
		heatSource.increaseTemp(count);
	}
}
