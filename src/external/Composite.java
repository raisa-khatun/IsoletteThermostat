package external;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import isolette.HeatSource;
import isolette.InfantSensor;
import isolette.TemperatureSensor;
import util.OperatorFeedback;

public class Composite {
	InfantSensor infantSensor=new InfantSensor();
	Thermostat t;
	OperatorInterface o;
	HeatSource h;
	TemperatureSensor ts;
	public Composite() {
		t=new Thermostat();
		o=new OperatorInterface();
		h=new HeatSource();
		ts=new TemperatureSensor();		

	}

	public String round() {
		t.run();
		o.run();
		h.run();
		ts.run();
		
		double infantsTemp=infantSensor.getInfantTemperature();
		if (infantsTemp == 0) {
			return "stop";
		}
		ts.getInfantTemp(infantsTemp);
		o.setSettings();
		double ld=o.getLD();
		double ud=o.getUD();
		double ald=o.getALD();
		double aud=o.getAUD();
		double current=ts.sendCurrentTemperature();
		boolean status=true;
		t.regulateTemperature(ld,ud,current,status);
		t.monitorTempertature(ald,aud,current);
		double heatIncrease=h.heatAir();
		ts.changeCurrentTemperature(heatIncrease);
		String regulatorStatus=t.getRegulatorStatus();
		String monitorStatus=t.getMonitorStatus();
		String alarmStatus=t.getAlarmStatus();
		String displayTemp=t.getDisplayTemps();
		
		OperatorFeedback feedback = new OperatorFeedback(regulatorStatus, monitorStatus, displayTemp, alarmStatus);

		System.out.println(feedback.toString());
		return "normal";
	}
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		Composite composite=new Composite();
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				String res = composite.round();
				if(res.equals("stop")) {
					System.exit(0);
				}
			}
		}, 0, 5, TimeUnit.SECONDS);

	}

}
