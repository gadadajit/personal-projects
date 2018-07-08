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
		if(map.containsKey(colour)) {
			HashSet<Integer> slot_nos = map.get(colour);
			int i=0;
			for(int slot_no:slot_nos) {
				if(i == (slot_nos.size()-1)) {
					System.out.print(slot_no);
				}else {
					System.out.print(slot_no+", ");
					i=i+1;
				}
						
			}
			System.out.println();
		}else {
			System.out.println("Not found");
		}
	}

	@Override
	public void showSlotNosByRegNo(String reg_no) {
		ParkingData data = ParkingData.getInstance();
		HashMap<String, HashSet<Integer>> map = (HashMap<String, HashSet<Integer>>) data.getReg_no_slots_map();
		if(map.containsKey(reg_no)) {	
			HashSet<Integer> slot_nos = map.get(reg_no);
			int i=0;
			for(int slot_no:slot_nos) {
				if(i == (slot_nos.size()-1)) {
					System.out.print(slot_no);
				}else {
					System.out.print(slot_no+", ");
					i=i+1;
				}
						
			}
			System.out.println();
		}else {
			System.out.println("Not found");
		}
	}

	@Override
	public void showRegNosByColour(String colour) {
		ParkingData data = ParkingData.getInstance();
		HashMap<String, HashSet<String>> map = (HashMap<String, HashSet<String>>) data.getColour_reg_no_map();
		if(map.containsKey(colour)) {	
			HashSet<String> reg_nos = map.get(colour);
			int i=0;
			for(String reg_no:reg_nos) {
				if(i == (reg_nos.size()-1)) {
					System.out.print(reg_no);
				}else {
					System.out.print(reg_no+", ");
					i=i+1;
				}
						
			}
			System.out.println();
		}else {
			System.out.println("Not found");
		}
	}
	
	

}
