/****************************************************************
 * Purpose : To read Inventory.Json file and find total price.
 * @author Samarth BM

***************************************************************/

package com.inventorymanagement;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryMain {

	/* Purpose: Method to read Inventory.json file and find the total price. */
	public void readInventoryJsonFile() throws IOException, ParseException {

		// Providing read-only access to JSON data.
		JSONParser parser = new JSONParser();

		// Reading the external JSON file.
		FileReader reader = new FileReader(".\\data\\Inventory.json");

		// Creating main object to store JSONParser, JSONObject and JSONArray.
		Object inventoryMain = parser.parse(reader);

		// Parsing object to JSONObject from Inventory.json file.
		JSONObject inventoryObj = (JSONObject) inventoryMain;

		// Getting the arrays of JSON file.
		JSONArray riceArray = (JSONArray) inventoryObj.get("Rice");
		JSONArray pulseArray = (JSONArray) inventoryObj.get("Pulses");
		JSONArray wheatArray = (JSONArray) inventoryObj.get("Wheat");

		// Getting details of rice.
		System.out.println("Details of Rice are: ");
		for (int i = 0; i < riceArray.size(); i++) {
			JSONObject riceDetails = (JSONObject) riceArray.get(i);

			String name = (String) riceDetails.get("Name");
			long weight = (long) riceDetails.get("Weight");
			long price = (long) riceDetails.get("PriceperKG");

			System.out.println("\nName: " + name);
			System.out.println("Weight: " + weight);
			System.out.println("Price per KG is: " + price);

			// Calculating price of different types of rice.
			long ricePrice = weight * price;
			System.out.println("\nTotal price of " + riceDetails.get("Name") + " is " + ricePrice);

		}
		// Getting details of Pulse.
		System.out.println("\nDetails of Pulse are: ");
		for (int j = 0; j < pulseArray.size(); j++) {
			JSONObject pulseDetails = (JSONObject) pulseArray.get(j);

			String name = (String) pulseDetails.get("Name");
			long weight = (long) pulseDetails.get("Weight");
			long price = (long) pulseDetails.get("PriceperKG");

			System.out.println("\nName: " + name);
			System.out.println("Weight: " + weight);
			System.out.println("Price per KG is: " + price);

			// Calculating price of different types of Pulses.
			long pulsePrice = weight * price;
			System.out.println("\nTotal price of " + pulseDetails.get("Name") + " is " + pulsePrice);

		}
		// Getting details of Wheat.
		System.out.println("\nDetails of Wheat are: ");
		for (int i = 0; i < wheatArray.size(); i++) {
			JSONObject wheatDetails = (JSONObject) wheatArray.get(i);

			String name = (String) wheatDetails.get("Name");
			long weight = (long) wheatDetails.get("Weight");
			long price = (long) wheatDetails.get("PriceperKG");

			System.out.println("\nName: " + name);
			System.out.println("Weight: " + weight);
			System.out.println("Price per KG is: " + price);
			// Calculating price of different types of Wheat.
			long wheatPrice = weight * price;
			System.out.println("\nTotal price of " + wheatDetails.get("Name") + " is " + wheatPrice);

		}

	}

	public static void main(String[] args) throws IOException, ParseException {
		InventoryMain inventoryDetails = new InventoryMain();
		inventoryDetails.readInventoryJsonFile();

	}

}
