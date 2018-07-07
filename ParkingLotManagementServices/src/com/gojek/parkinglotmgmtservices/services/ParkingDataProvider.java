/**
 * 
 */
package com.gojek.parkinglotmgmtservices.services;

/**
 * @author ajitgadad
 *
 */
public interface ParkingDataProvider {
	
	public void showSlotNosByColour(String colour);
	
	public void showSlotNosByRegNo(String reg_no);
	
	public void showRegNosByColour(String colour);
}
