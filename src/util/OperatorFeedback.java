package util;

public class OperatorFeedback {
	private String regulatorStatus;
	private String monitorStatus;
	private String currentTemperature;
	private String alarmStatus;
	
	public OperatorFeedback(String rS, String mS, String cT,String aS) {
		this.regulatorStatus = rS;
		this.monitorStatus = mS;
		this.currentTemperature = cT;
		this.alarmStatus = aS;
	}

	public String getRegulatorStatus() {
		return regulatorStatus;
	}

	public String getMonitorStatus() {
		return monitorStatus;
	}

	public String getCurrentTemperature() {
		return currentTemperature;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}
	
	public String toString() {
		if (currentTemperature.equals("Unspecified")) {
			String toReturn = "Regulator Status: " + regulatorStatus + "\n" +
								"Monitor Status: " + monitorStatus + "\n" + 
								"Current Temperature: " + "Unspecified" + "\n" + 
								"Alarm Status: " + alarmStatus + "\n";
			return toReturn;
		} else {
			String toReturn = "Regulator Status: " + regulatorStatus + "\n" +
								"Monitor Status: " + monitorStatus + "\n" + 
								"Current Temperature: " + String.format("%.1f", Double.parseDouble(currentTemperature)) + "\n" + 
								"Alarm Status: " + alarmStatus + "\n";
			return toReturn;
		}
	}
}
