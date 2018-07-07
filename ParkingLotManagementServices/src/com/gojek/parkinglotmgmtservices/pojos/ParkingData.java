/**
 * 
 */
package com.gojek.parkinglotmgmtservices.pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajitgadad
 *
 */
public class ParkingData {
	private static ParkingData instance = null;
	private ParkingSlot[] parking_slots;
	private Map<String,Integer[]> reg_no_slots_map = new HashMap<String,Integer[]>();

	/**
	 * @return the parking_slots
	 */
	public ParkingSlot[] getParking_slots() {
		return parking_slots;
	}

	/**
	 * @param parking_slots the parking_slots to set
	 */
	public void setParking_slots(ParkingSlot[] parking_slots) {
		this.parking_slots = parking_slots;
	}
	
	private ParkingData() {}
	/**
	 * allows to create a single instance of class
	 */
	public static ParkingData getInstance() {
		if(instance == null) {
			synchronized(ParkingData.class){
				if(instance == null) {
					instance = new ParkingData();
				}
			}
		}
		return instance;		
	}

}
