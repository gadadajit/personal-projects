package com.gojek.parkinglotmgmtservices.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojek.parkinglotmgmtservices.pojos.ParkingData;
import com.gojek.parkinglotmgmtservices.pojos.ParkingSlot;
import com.gojek.parkinglotmgmtservices.services.ParkingLotService;
import com.gojek.parkinglotmgmtservices.servicesimpl.ParkingLotServiceImpl;

/**
 * @author ajitgadad
 * 
 */
public class ParkingLotServiceTest {

	@Test
	public void testEntryMethod(){
		ParkingLotServiceImpl parkingLotService = new ParkingLotServiceImpl();
		ParkingData parkingData = ParkingData.getInstance();
		ParkingSlot[] parking_slots = new ParkingSlot[4];
		parking_slots[0]= new ParkingSlot(1, true);
		parking_slots[1]= new ParkingSlot(2, true);
		parking_slots[2]= new ParkingSlot(3, true);
		parking_slots[3]= new ParkingSlot(4, true);
		parkingData.setParking_slots(parking_slots );
		String reg_no="KA1234L";
		String colour="Red";
		parkingLotService.entry(reg_no, colour);
		assertEquals(false, parkingData.getParking_slots()[0].isAvailable());		
	}

	@Test
	public void testExitMethod(){
		ParkingLotServiceImpl parkingLotService = new ParkingLotServiceImpl();
		ParkingData parkingData = ParkingData.getInstance();
		ParkingSlot[] parking_slots = new ParkingSlot[4];
		parking_slots[0]= new ParkingSlot(1, true);
		parking_slots[1]= new ParkingSlot(2, true);
		parking_slots[2]= new ParkingSlot(3, true);
		parking_slots[3]= new ParkingSlot(4, true);
		parkingData.setParking_slots(parking_slots );
		int slot_no = 1;
		parkingLotService.exit(slot_no );
		assertNotNull(parking_slots[0]);
		assertEquals(null, parking_slots[0].getCar());	
		assertEquals(true, parking_slots[0].isAvailable());	
			
	}

	@Test
	public void testCreateParkingLot(){
		ParkingLotServiceImpl parkingLotService = new ParkingLotServiceImpl();
		ParkingData parkingData = ParkingData.getInstance();
		int no_slots= 5;
		parkingLotService.createParkingLot(no_slots);
		ParkingSlot[] parking_slots = parkingData.getParking_slots();
		assertNotNull(parking_slots[4]);
		assertEquals(null, parking_slots[4].getCar());	
		assertEquals(true, parking_slots[4].isAvailable());	
			
	}
}
