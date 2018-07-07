/**
 * 
 */
package com.gojek.parkinglotmgmtservices.pojos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ajitgadad
 *
 */
public class ParkingData {
	private static ParkingData instance = null;
	private ParkingSlot[] parking_slots;
	private Map<String,HashSet<Integer>> reg_no_slots_map = new HashMap<String,HashSet<Integer>>();
	private Map<String,HashSet<String>> colour_reg_no_map = new HashMap<String,HashSet<String>>();
	private Map<String,HashSet<Integer>> colour_slots_map = new HashMap<String,HashSet<Integer>>();
	/**
	 * @return the reg_no_slots_map
	 */
	public Map<String, HashSet<Integer>> getReg_no_slots_map() {
		return reg_no_slots_map;
	}

	/**
	 * @return the colour_slots_map
	 */
	public Map<String, HashSet<Integer>> getColour_slots_map() {
		return colour_slots_map;
	}

	/**
	 * @param colour_slots_map the colour_slots_map to set
	 */
	public void setColour_slots_map(Map<String, HashSet<Integer>> colour_slots_map) {
		this.colour_slots_map = colour_slots_map;
	}

	/**
	 * @param reg_no_slots_map the reg_no_slots_map to set
	 */
	public void setReg_no_slots_map(Map<String, HashSet<Integer>> reg_no_slots_map) {
		this.reg_no_slots_map = reg_no_slots_map;
	}

	/**
	 * @return the colour_reg_no_map
	 */
	public Map<String, HashSet<String>> getColour_reg_no_map() {
		return colour_reg_no_map;
	}

	/**
	 * @param colour_reg_no_map the colour_reg_no_map to set
	 */
	public void setColour_reg_no_map(Map<String, HashSet<String>> colour_reg_no_map) {
		this.colour_reg_no_map = colour_reg_no_map;
	}

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
