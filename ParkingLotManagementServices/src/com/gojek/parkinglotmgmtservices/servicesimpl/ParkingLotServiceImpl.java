package com.gojek.parkinglotmgmtservices.servicesimpl;

import com.gojek.parkinglotmgmtservices.pojos.Car;
import com.gojek.parkinglotmgmtservices.pojos.ParkingData;
import com.gojek.parkinglotmgmtservices.pojos.ParkingSlot;
import com.gojek.parkinglotmgmtservices.services.ParkingLotService;

public class ParkingLotServiceImpl implements ParkingLotService {

	@Override
	public void entry(String reg_no,String colour) {
		ParkingData data = ParkingData.getInstance();
		ParkingSlot available_slot = getNearestAvlSlot(data);
		if(available_slot != null) {
			Car car = new Car();
			car.setRegistration_no(reg_no);
			car.setColour(colour);
			available_slot.setCar(car);
			available_slot.setIsAvailable(false);
			System.out.println("Allocated slot number: "+available_slot.getSlot_id());
		}else {
			System.out.println("Sorry, parking lot is full");
		}
		
	}
	
	private ParkingSlot getNearestAvlSlot(ParkingData data) {
		ParkingSlot[] slots = data.getParking_slots();
		ParkingSlot available_slot = null;;
		for(ParkingSlot slot: slots) {
			if(slot.isAvailable()) {
				available_slot = slot;
			}
		}
		return available_slot;	
	}

	@Override
	public void displayCurrentStatus() {
		ParkingData data = ParkingData.getInstance();
		ParkingSlot[] slots = data.getParking_slots();
		System.out.println("Slot No.  Registration No  Colour");
		for(ParkingSlot slot: slots) {
			System.out.println(slot.getSlot_id()+" "+slot.getCar().getRegistration_no()+" "+slot.getCar().getColour());
		}
		
	}

	@Override
	public void exit(int slot_no) {
		ParkingData data = ParkingData.getInstance();
		ParkingSlot[] slots = data.getParking_slots();
		ParkingSlot slot = slots[slot_no-1];
		slot.setIsAvailable(true);
		slot.setCar(null);
	}

	@Override
	public void createParkingLot(int no_slots) {
		ParkingData data = ParkingData.getInstance();
		ParkingSlot[] parking_slots = new ParkingSlot[no_slots];
		for(int i=0;i<no_slots;i++) {
			parking_slots[i] = new ParkingSlot(i+1,true);
		}
		data.setParking_slots(parking_slots);
		System.out.println("Created a parking lot with "+no_slots+" slots");
	}
}
