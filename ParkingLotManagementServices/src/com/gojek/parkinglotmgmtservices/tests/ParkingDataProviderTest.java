/**
 * 
 */
package com.gojek.parkinglotmgmtservices.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import com.gojek.parkinglotmgmtservices.pojos.ParkingData;
import com.gojek.parkinglotmgmtservices.servicesimpl.ParkingDataProviderImpl;

/**
 * @author ajitgadad
 * 
 */
public class ParkingDataProviderTest {
	@Test
	public void testShowSlotNosByColour() {
		// key should not be dependent on lower or upper case
		ParkingDataProviderImpl parkingDataProviderImpl = new ParkingDataProviderImpl();
		ParkingData parkingData = ParkingData.getInstance();
		Map<String, HashSet<Integer>> colour_reg_no_map = new HashMap<>();
		HashSet<Integer> slotsSet = new HashSet<Integer>();
		slotsSet.add(1);
		colour_reg_no_map.put("White", slotsSet);
		parkingData.setColour_slots_map(colour_reg_no_map);
		String colour = "White";
		parkingDataProviderImpl.showSlotNosByColour(colour);
		assertNotNull(colour_reg_no_map.get(colour));

	}
	@Test
	public void testShowSlotNosByRegNo() {
		// key should not be dependent on lower or upper case
		ParkingDataProviderImpl parkingDataProviderImpl = new ParkingDataProviderImpl();
		ParkingData parkingData = ParkingData.getInstance();
		Map<String, HashSet<Integer>> reg_no_slots_map = new HashMap<>();
		HashSet<Integer> slotsSet1 = new HashSet<Integer>();
		slotsSet1.add(1);
		HashSet<Integer> slotsSet2= new HashSet<Integer>();
		slotsSet2.add(3);
		slotsSet2.add(4);
		reg_no_slots_map.put("KA441P", slotsSet1);
		reg_no_slots_map.put("KA1234L", slotsSet2);
		parkingData.setReg_no_slots_map(reg_no_slots_map);
		String reg_no = "KA1234L";
		parkingDataProviderImpl.showSlotNosByRegNo(reg_no );
		assertNotNull(reg_no_slots_map.get(reg_no));
		assertEquals(slotsSet2, reg_no_slots_map.get(reg_no));

	}
	@Test
	public void testShowRegNosByColour(){
		ParkingDataProviderImpl parkingDataProviderImpl = new ParkingDataProviderImpl();
		ParkingData parkingData = ParkingData.getInstance();
		Map<String, HashSet<String>> colour_reg_no_map = new HashMap<>();
		HashSet<String> registrationSet = new HashSet<>();
		 registrationSet.add("KA441P");
		 registrationSet.add("KA1234L");
		colour_reg_no_map.put("Red", registrationSet);
		parkingData.setColour_reg_no_map(colour_reg_no_map);
		String colour ="Red";
		parkingDataProviderImpl.showRegNosByColour(colour );
		assertNotNull(colour_reg_no_map.get(colour));
		assertEquals(registrationSet, colour_reg_no_map.get(colour));

	}
}
