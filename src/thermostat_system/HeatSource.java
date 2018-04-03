package thermostat_system;

public class HeatSource {
	private boolean enabled;
	private Air air;
	
	public HeatSource() {
		enabled = false;
		air = Air.getInstance();
	}
	
	public void toggleStatus() {
		if (!enabled) {
			enabled = true;
		} else {
			enabled = false;
		}
	}
	
	public boolean getStatus() {
		return enabled;
	}
	
	/**
	 * If the unit is enabled and the counter hits some multiple of 3, increase the air temperature by 0.2
	 * @param counter Tracks which round this is
	 */
	public void increaseTemp(int counter) {
		if (enabled && counter % 3 == 0) { 
			air.setCurrentTemperature(air.getCurrentTemperature() + 0.2);
		}
	}
	
	public String toString() {
		String onoff = "";
		if (enabled) {
			onoff = "On";
		} else {
			onoff = "Off";
		}
		return "Heat Source Status: " + onoff;
	}
}
