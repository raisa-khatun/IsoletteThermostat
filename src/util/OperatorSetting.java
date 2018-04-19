package util;

public class OperatorSetting {

	private double lowerDesiredTemperature;
	private double upperDesiredTemperature;
	private double lowerAlarmTemperature;
	private double upperAlarmTemperature;
	
	public OperatorSetting(double lDT, double uDT, double lAT, double uAT) {
		this.lowerDesiredTemperature = lDT;
		this.upperDesiredTemperature = uDT;
		this.lowerAlarmTemperature = lAT;
		this.upperAlarmTemperature = uAT;
	}

	public double getLowerDesiredTemperature() {
		return lowerDesiredTemperature;
	}

	public void setLowerDesiredTemperature(double lowerDesiredTemperature) {
		this.lowerDesiredTemperature = lowerDesiredTemperature;
	}

	public double getUpperDesiredTemperature() {
		return upperDesiredTemperature;
	}

	public void setUpperDesiredTemperature(double upperDesiredTemperature) {
		this.upperDesiredTemperature = upperDesiredTemperature;
	}

	public double getLowerAlarmTemperature() {
		return lowerAlarmTemperature;
	}

	public void setLowerAlarmTemperature(double lowerAlarmTemperature) {
		this.lowerAlarmTemperature = lowerAlarmTemperature;
	}

	public double getUpperAlarmTemperature() {
		return upperAlarmTemperature;
	}

	public void setUpperAlarmTemperature(double upperAlarmTemperature) {
		this.upperAlarmTemperature = upperAlarmTemperature;
	}
	
	
}
