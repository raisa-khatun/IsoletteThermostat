package isolette;

public class HeatSource implements Runnable{
	private boolean enabled;
	private int counter;
	private double heatIncreaseOrDecrease;


	public HeatSource() {
		counter = 0;
		enabled = false;
	}

	/**
	 * If the heat source is on, it is turned off
	 * If the heat source is off, it is turned on
	 */
	public void toggleStatus() {
		if (!enabled) {
			enabled = true;
			counter = 0;
		} else {
			enabled = false;
			counter = 0;
		}
	}

	/**
	 * Gets the current status of the heat source, whether it is turned on or off
	 * @return true if enabled, false if disabled
	 */
	public boolean getStatus() {
		return enabled;
	}

	/**
	 * Every 30 rounds (1 minute) the temperature increases or decreases depending on if the heat source is on or off 
	 * @param counter Tracks which round this is
	 */
	public double heatAir() {
		counter++;
		if (enabled && counter % 2 == 0) { 
			heatIncreaseOrDecrease=1;
		}
		else if (!enabled && counter % 2 == 0) {
			heatIncreaseOrDecrease=-1;
		}
		return heatIncreaseOrDecrease;
	}

	/**
	 * Returns a string representation if the heat source is on or off
	 */
	public String toString() {
		String onoff = "";
		if (enabled) {
			onoff = "On";
		} else {
			onoff = "Off";
		}
		return "Heat Source Status: " + onoff;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
