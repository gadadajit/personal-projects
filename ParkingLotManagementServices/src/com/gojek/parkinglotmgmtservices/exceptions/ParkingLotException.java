/**
 * 
 */
package com.gojek.parkinglotmgmtservices.exceptions;

/**
 * @author ajitgadad
 *
 */
public class ParkingLotException extends RuntimeException{
	private String error_message = "Something went wrong at runtime";

	/**
	 * @return the error_message
	 */
	public String getError_message() {
		return error_message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingLotException [error_message=" + error_message + "]";
	}
	
	
	
	
}
