package com.gojek.parkinglotmgmtservices.services;

import com.gojek.parkinglotmgmtservices.pojos.ParkingData;

public interface ParkingLotService {
	
	public void createParkingLot(int no_slots);
	
	public void entry(String reg_no,String colour);
	
	public void displayCurrentStatus();
	
	public void exit(int slot_no);

}
