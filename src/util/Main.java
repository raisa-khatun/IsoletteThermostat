package util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import external.OperatorInterface;

public class Main {

	/**
	 * Driver program to start the OperatorInterface
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		OperatorInterface opInterface = new OperatorInterface();
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				String command = opInterface.round();
				if (command.equals("stop")) {
					System.exit(0);
				}
			}
		}, 0, 2, TimeUnit.SECONDS);
	}

}