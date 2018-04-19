package external;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import util.OperatorFeedback;
import util.OperatorSetting;

public class OperatorInterface {
	
	private File inFile;
	private Thermostat thermostat;
	private BufferedReader bufferedReader;
	private OperatorFeedback feedback;
	
	public OperatorInterface() 
	{
		thermostat = new Thermostat();
		inFile = new File("src/nurse.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(inFile));
			
		} catch (IOException ioe) {
			System.out.println("Error reading file");
		}
		
	}
	
	public String round() {
		String command = getCommandFromFile();
		String[] parsedCommand = command.split("/");
		switch(parsedCommand[0]) {
			case "config":
				OperatorSetting setting = new OperatorSetting(
						Double.parseDouble(parsedCommand[1]), 
						Double.parseDouble(parsedCommand[2]), 
						Double.parseDouble(parsedCommand[3]), 
						Double.parseDouble(parsedCommand[4]));
				thermostat.setSetting(setting);
				break;
			default:
				thermostat.regulateTemperature();
				thermostat.monitorTempertature();
		}
		feedback = thermostat.getFeedback();
		System.out.println(feedback.toString());
		return "";
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
	
}
