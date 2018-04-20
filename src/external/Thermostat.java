package external;

import isolette.Isolette;
import util.OperatorFeedback;
import util.OperatorSetting;

public class Thermostat {

	private Isolette isolette;
	private OperatorSetting currentSetting;

	private String regulatorStatus;
	private String monitorStatus;
	private String alarmStatus;
	private String displayTemperature;

	public Thermostat() {
		isolette = new Isolette();
		regulatorStatus = "Init";
		monitorStatus = "Init";
		alarmStatus = "Off";
		displayTemperature = "Unspecified";
		currentSetting = null;
	}

	public void regulateTemperature() {
		if (currentSetting != null) {
			double lowerDesiredTemp = currentSetting.getLowerDesiredTemperature();
			double upperDesiredTemp = currentSetting.getUpperDesiredTemperature();
			regulatorStatus = "Normal";
			double currentTemp = isolette.getTemperatureFromSensor();
			if (currentTemp != 0) {
				displayTemperature = String.valueOf(currentTemp);
				isolette.sendHeatSignal();
	
				// Reached low temperature: Turn on
				if (isolette.getTemperatureFromSensor() < lowerDesiredTemp) {
					if (!isolette.heatSourceStatus()) { // If it is off, turn on
						isolette.toggleHeatSource();
					}
				}
				// Reached target temperature: Turn off
				if (isolette.getTemperatureFromSensor() > upperDesiredTemp) {
					if (isolette.heatSourceStatus()) { // If it is on, turn off
						isolette.toggleHeatSource();
					}
				}
			} else {
				regulatorStatus = "Off";
				displayTemperature = "Unspecified";
				monitorStatus = "Off";
				alarmStatus = "Off";
				currentSetting = null;
						
			}
		} else {
			System.out.println("No setting yet");
		}
	}

	public void monitorTempertature() {
		if (currentSetting != null) {
			monitorStatus = "Normal";
			double lowerAlarmTemp = currentSetting.getLowerAlarmTemperature();
			double upperAlarmTemp = currentSetting.getUpperAlarmTemperature();
			if (isolette.getTemperatureFromSensor() < lowerAlarmTemp || isolette.getTemperatureFromSensor() > upperAlarmTemp) {
				alarmStatus = "On";
			}
		} else {
			System.out.println("No setting yet");
		}
	}

	/**
	 * Saves the current setting
	 * @param setting from the operator interface
	 */
	public void setSetting(OperatorSetting setting) {
		this.currentSetting = setting;
	}

	/**
	 * Sends the feedback to OperatorInterface
	 * @return OperatorFeedback
	 */
	public OperatorFeedback getFeedback() {
		return new OperatorFeedback(
				regulatorStatus, 
				monitorStatus, 
				displayTemperature, 
				alarmStatus);
	}

}
