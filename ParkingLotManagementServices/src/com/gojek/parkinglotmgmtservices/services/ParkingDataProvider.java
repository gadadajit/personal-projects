/**
 * 
 */
package com.gojek.parkinglotmgmtservices.services;

/**
 * @author ajitgadad
 *
 */
public interface ParkingDataProvider {
	//This method is used to show all parking slot numbers of a particular car's colour
	public void showSlotNosByColour(String colour);
	//This method is used to show all parking slot numbers used by a car, using it's registration number
	public void showSlotNosByRegNo(String reg_no);
	//This method is used to show all cars' registration number of a particular car's colour
	public void showRegNosByColour(String colour);
}
