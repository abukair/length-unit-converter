package unit.Converter;
import java.util.*;
import java.io.*;

// Program that converts units of length

public class UnitConverter {
	
	// meter is used as an intermediary conversion
	static Map<String, Double> conversionMap = new HashMap<>();
	static {
		conversionMap.put("miles",0.000621371);
		conversionMap.put("feet",3.28084);
		conversionMap.put("yards",1.09361);
		conversionMap.put("inches",39.3701);
		conversionMap.put("kilometers",0.001);
		conversionMap.put("centimeters",100.0);
		conversionMap.put("millimeters",1000.0);

	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String initialUnit = correctInput(input, "What is your initial unit?");
		String unit = correctInput(input, "What unit do you want to convert to?");
		
		double value = correctValInput(input, "What is your value?");
		double inMeters = toMeters(initialUnit, value);
		double result = convert(inMeters, unit);
        result = Math.round(result * 100.0) / 100.0;
        System.out.println(result + " " + unit);
        
        input.close();
	}
	
	public static double correctValInput(Scanner input, String question) {
		double value;
		while (true) {
			System.out.println(question);
			if (input.hasNextDouble()) {
				value = input.nextDouble();
				input.nextLine();
				break;
			} else {
				System.out.println("Not a number, try again!");
				input.nextLine();
			}
		}
		return value;
	}
	
	public static String correctInput(Scanner input, String question) {
		String unit = "";
		while (true) {
			System.out.println(question);
			unit = input.nextLine().toLowerCase();
			if (conversionMap.containsKey(unit) || unit.equalsIgnoreCase("meters")) {
				break;
			} else {
				System.out.println("Invalid unit. Please use only length units.");
			}
		}
		return unit;
	}
	
	public static double toMeters(String unit, double value) {
		if (unit.equalsIgnoreCase("meters")) {
			return value;
		} else {
			value = value / conversionMap.get(unit);
			return value;
		}
	}
	
	public static double convert(double value, String unit) {
		if (!unit.equalsIgnoreCase("meters")) {
			return value * conversionMap.get(unit);
		}
		return value;
	}
}