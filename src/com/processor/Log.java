package com.processor;

/**
 * 
 * @author ASoomro
 * --A Log entity
 */
public class Log {

	private String date;
	private String logLevel;
	private String message;
	
	/**
	 * 
	 * @return String Date of a log
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date sets the date extracted from the log
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @return String LogLevel taken from the log
	 */
	public String getLogLevel() {
		return logLevel;
	}
	
	/**
	 * 
	 * @param logLevel sets the logLevel
	 */
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	
	/**
	 * 
	 * @return Message extracted from the log
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 * @param message sets the message from log
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		
		return "[ Date::"+date + " LogLevel::" + logLevel + " Message::"  + message + "]";
		
	}
	
}
