package external;

import util.OperatorFeedback;

public class Thermostat implements Runnable {

	private String regulatorStatus;
	private String monitorStatus;
	private String alarmStatus;
	private String displayTemperature;

	public Thermostat() {
		regulatorStatus = "Init";
		monitorStatus = "Init";
		alarmStatus = "Off";
		displayTemperature = "Unspecified";
	}

	public void regulateTemperature(double lowerDesiredTemp,double upperDesiredTemp,double  currentTemp,boolean hStatus) {

		displayTemperature = String.valueOf(currentTemp);

		// Reached low temperature: Turn on
		if (currentTemp < lowerDesiredTemp) {
			if (hStatus) { // If it is off, turn on
				hStatus=!hStatus;
			}
			regulatorStatus = "Normal";
		}
		// Reached target temperature: Turn off
		if (currentTemp > upperDesiredTemp) {
			if (!hStatus) { // If it is off, turn on
				hStatus=!hStatus;
			}
			regulatorStatus = "Normal";
		}

	}

	public void monitorTempertature(double lowerAlarmTemp,double upperAlarmTemp,double currentTemp) {
		monitorStatus = "Normal";
		if (currentTemp< lowerAlarmTemp || currentTemp > upperAlarmTemp) {
			alarmStatus = "On";
			monitorStatus = "Normal";
		}

	}

	public String getRegulatorStatus() {
		return regulatorStatus;
	}
	public String getMonitorStatus() {
		return monitorStatus;
	}
	public String getDisplayTemps() {
		return displayTemperature;
	}
	public String getAlarmStatus() {
		return alarmStatus;
	}

	public OperatorFeedback getFeedback() {
		return new OperatorFeedback(
				regulatorStatus, 
				monitorStatus, 
				displayTemperature, 
				alarmStatus);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.print("Hi");
	}

}
