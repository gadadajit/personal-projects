package com.gojek.parkinglotmgmtservices.servicesimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
			Map<String,HashSet<Integer>> reg_no_map = data.getReg_no_slots_map();
			if(reg_no_map.containsKey(car.getRegistration_no())) {
				HashSet<Integer> slots_list = (HashSet<Integer>) reg_no_map.get(reg_no);
				slots_list.add(available_slot.getSlot_id());
				reg_no_map.put(car.getRegistration_no(), slots_list);
				data.setReg_no_slots_map(reg_no_map);
			}else {
				HashSet<Integer> slots_list = new HashSet<Integer>();
				slots_list.add(available_slot.getSlot_id());
				reg_no_map.put(car.getRegistration_no(), slots_list);
				data.setReg_no_slots_map(reg_no_map);
			}
			Map<String,HashSet<String>> colour_map = data.getColour_reg_no_map();
			if(colour_map.containsKey(car.getColour())) {
				HashSet<String> reg_nos = (HashSet<String>) colour_map.get(reg_no);
				reg_nos.add(car.getRegistration_no());
				colour_map.put(car.getColour(),reg_nos);
				data.setColour_reg_no_map(colour_map);
			}else {
				HashSet<String> reg_nos = new HashSet<String>();
				reg_nos.add(car.getRegistration_no());
				colour_map.put(car.getColour(), reg_nos);
				data.setColour_reg_no_map(colour_map);
			}
			Map<String,HashSet<Integer>> colour_slots_map = data.getColour_slots_map();
			if(colour_slots_map.containsKey(car.getColour())) {
				HashSet<Integer> slots = (HashSet<Integer>) colour_slots_map.get(reg_no);
				slots.add(available_slot.getSlot_id());
				colour_slots_map.put(car.getColour(),slots);
				data.setColour_slots_map(colour_slots_map);
			}else {
				HashSet<Integer> slots = new HashSet<Integer>();
				slots.add(available_slot.getSlot_id());
				colour_slots_map.put(car.getColour(), slots);
				data.setColour_slots_map(colour_slots_map);
			}
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
		data.setParking_slots(slots);
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
