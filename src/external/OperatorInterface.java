package external;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class OperatorInterface implements Runnable {

	private File inFile;
	private BufferedReader bufferedReader;
	private double lowerDesiredTemperature=98;
	private double upperDesiredTemperature=100;
	private double lowerAlarmTemperature=97;
	private double upperAlarmTemperature=103;

	public OperatorInterface() 
	{
		//thermostat = new Thermostat();
		inFile = new File("src/nurse.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(inFile));

		} catch (IOException ioe) {
			System.out.println("Error reading file");
		}

	}

	public void setSettings() {
		String command = getCommandFromFile();
		String[] parsedCommand = command.split("/");
		switch(parsedCommand[0]) {
		case "config":				
			lowerDesiredTemperature=Double.parseDouble(parsedCommand[1]); 
			upperDesiredTemperature=Double.parseDouble(parsedCommand[2]);
			lowerAlarmTemperature=Double.parseDouble(parsedCommand[3]); 
			upperAlarmTemperature=Double.parseDouble(parsedCommand[4]);
			break; 
		}
	}

	public double getLD() {
		return lowerDesiredTemperature;
	}
	public double getUD() {
		return upperDesiredTemperature;
	}
	public double getALD() {
		return lowerAlarmTemperature;
	}
	public double getAUD() {
		return upperAlarmTemperature;
	}

	public void closeInterface() {
		if (bufferedReader != null) {
			try {
				bufferedReader.close();
				bufferedReader = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sets the current temperature from the isolette by reading from a file 
	 * Simulates the nurse's operations
	 * @return 
	 */
	public String getCommandFromFile() {
		String temp;
		if (bufferedReader != null)
		{
			try {
				temp = bufferedReader.readLine();
				if (temp == null) {
					closeInterface();
				} else {
					return temp;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "stop";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub


	}

}
