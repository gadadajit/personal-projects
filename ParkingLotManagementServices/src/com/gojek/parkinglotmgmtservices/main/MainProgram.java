/**
 * 
 */
package com.gojek.parkinglotmgmtservices.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.parkinglotmgmtservices.services.ParkingDataProvider;
import com.gojek.parkinglotmgmtservices.services.ParkingLotService;
import com.gojek.parkinglotmgmtservices.servicesimpl.ParkingDataProviderImpl;
import com.gojek.parkinglotmgmtservices.servicesimpl.ParkingLotServiceImpl;

/**
 * @author ajitgadad
 *
 */
public class MainProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		boolean exit_flag = false;
		ParkingLotServiceImpl service = new ParkingLotServiceImpl();
		ParkingDataProviderImpl data_provider = new ParkingDataProviderImpl();
		try {
			if(args.length > 0) {
				bufferedReader = new BufferedReader(new FileReader(args[0]));
			}
			while(!exit_flag) {
				if (args.length == 0) {
					bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				}
				String command = bufferedReader.readLine().trim();
				if(command != null && !command.isEmpty()) {
					String[] command_arr = command.split("\\s+");
					if(!command_arr[0].isEmpty()) {	
						String input = command_arr[0];
						switch(input) {
							case "create_parking_lot":{
								service.createParkingLot(Integer.parseInt(command_arr[1]));
								break;
							}
							case "park": {
								service.entry(command_arr[1], command_arr[2]);
								break;
							}
							case "leave": {
								service.exit(Integer.parseInt(command_arr[1]));
								break;
							}
							case "status": {
								service.displayCurrentStatus();
								break;
							}
							case "registration_numbers_for_cars_with_colour": {
								data_provider.showRegNosByColour(command_arr[1]);
								break;
							}
							case "slot_numbers_for_cars_with_colour": {
								data_provider.showSlotNosByColour(command_arr[1]);
								break;
							}
							case "slot_number_for_registration_number": {
								data_provider.showSlotNosByRegNo(command_arr[1]);
								break;
							}
							case "exit": {
								exit_flag = true;
								break;
							}
							default: {
								System.out.println("Please enter a valid command");
								break;
							}
						}
					}
				}
			
			}	
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
