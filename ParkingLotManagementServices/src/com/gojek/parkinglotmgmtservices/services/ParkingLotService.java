package com.gojek.parkinglotmgmtservices.services;

import com.gojek.parkinglotmgmtservices.pojos.ParkingData;

public interface ParkingLotService {
	//This method is used to create parking slots
	public void createParkingLot(int no_slots);
	//This method is used to allot an available parking slot and enter car's data when it is parked
	public void entry(String reg_no,String colour);
	//This method is used to display the current status of parkinglot
	public void displayCurrentStatus();
	//This method is used to make slot free when car leaves
	public void exit(int slot_no);

}
