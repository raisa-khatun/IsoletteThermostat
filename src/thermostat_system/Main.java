package thermostat_system;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Driver program that calls thermostat rounds
 * Runs one round every 2 seconds
 */
public class Main {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		Thermostat thermostat = new Thermostat();
		ses.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				thermostat.round();
				
			}
		}, 0, 2, TimeUnit.SECONDS); // Every 2 seconds a round executes.
	}

}
