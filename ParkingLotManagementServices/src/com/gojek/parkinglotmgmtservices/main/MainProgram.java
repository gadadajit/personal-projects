/**
 * 
 */
package com.gojek.parkinglotmgmtservices.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		try {
			ParkingLotServiceImpl service = new ParkingLotServiceImpl();
			if(args.length == 0) {
				bufferedReader = new BufferedReader(new FileReader(args[0]));
			}
			String input = bufferedReader.readLine().trim();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
