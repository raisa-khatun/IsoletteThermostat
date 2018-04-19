package isolette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InfantSensor {
	private static File inFile = new File("src/infant.txt");
	private static BufferedReader bufferedReader = null;
	
	public InfantSensor() {
		try {
			bufferedReader = new BufferedReader(new FileReader(inFile));
			
		} catch (IOException ioe) {
			System.out.println("Error reading file");
		}
	}
	
	/**
	 * Reads one line of the file representing the temperature of the infant
	 * @return Double value representing the infant temperature
	 */
	public static double sendInfantTemperature() {
		double infantTemp = 0.0;
		if (bufferedReader != null) {
			try {
				infantTemp = Double.parseDouble(bufferedReader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect Format");
			} catch (IOException e) {
				System.out.println("Error reading file");
			}
		}
		return infantTemp;
		
	}
}