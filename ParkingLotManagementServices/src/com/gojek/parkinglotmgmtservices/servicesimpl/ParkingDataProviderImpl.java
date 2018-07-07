/**
 * 
 */
package com.gojek.parkinglotmgmtservices.servicesimpl;

import java.util.HashMap;
import java.util.HashSet;

import com.gojek.parkinglotmgmtservices.pojos.ParkingData;
import com.gojek.parkinglotmgmtservices.services.ParkingDataProvider;

/**
 * @author ajitgadad
 *
 */
public class ParkingDataProviderImpl implements ParkingDataProvider {

	@Override
	public void showSlotNosByColour(String colour) {
		ParkingData data = ParkingData.getInstance();
		HashMap<String, HashSet<Integer>> map = (HashMap<String, HashSet<Integer>>) data.getColour_slots_map();
		HashSet<Integer> slot_nos = map.get(colour);
		for(int slot_no:slot_nos) {
			System.out.print(slot_no+" ");		
		}
		System.out.println();
	}

	@Override
	public void showSlotNosByRegNo(String reg_no) {
		ParkingData data = ParkingData.getInstance();
		HashMap<String, HashSet<Integer>> map = (HashMap<String, HashSet<Integer>>) data.getReg_no_slots_map();
		HashSet<Integer> slot_nos = map.get(reg_no);
		for(int slot_no:slot_nos) {
			System.out.print(slot_no+" ");		
		}
		System.out.println();
		
	}

	@Override
	public void showRegNosByColour(String colour) {
		ParkingData data = ParkingData.getInstance();
		HashMap<String, HashSet<String>> map = (HashMap<String, HashSet<String>>) data.getColour_reg_no_map();
		HashSet<String> reg_nos = map.get(colour);
		for(String reg_no:reg_nos) {
			System.out.print(reg_no+" ");		
		}
		System.out.println();
		
	}
	
	

}
