/**
 * 
 */
package com.gojek.parkinglotmgmtservices.pojos;

/**
 * @author ajitgadad
 *
 */
public class ParkingLot {
	private int slot_id;
	private boolean is_available;
	/**
	 * @param slot_id
	 * @param is_available
	 */
	public ParkingLot(int slot_id, boolean is_available) {
		super();
		this.slot_id = slot_id;
		this.is_available = is_available;
	}
	/**
	 * @return the slot_id
	 */
	public int getSlot_id() {
		return slot_id;
	}
	/**
	 * @param slot_id the slot_id to set
	 */
	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}
	/**
	 * @return the is_available
	 */
	public boolean isIs_available() {
		return is_available;
	}
	/**
	 * @param is_available the is_available to set
	 */
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	
}
