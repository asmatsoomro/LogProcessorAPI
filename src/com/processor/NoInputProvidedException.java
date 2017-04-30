package com.processor;

/**
 * 
 * @author ASoomro
 * --A Custom Exception thrown when null or empty input is provided
 */
public class NoInputProvidedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoInputProvidedException(String message){
		
		super(message);
	}
	
	

}
