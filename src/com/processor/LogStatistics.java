package com.processor;


/**
 * 
 * @author ASoomro
 * --LogStatistics is used to preserve the quantity of different Log levels
 *
 */
public class LogStatistics {

	private final int infoCount;
	private final int debugCount;
	private final int errorCount;
	private final int warningCount;
	
	public LogStatistics(int warningCount, int infoCount, int debugCount, int errorCount) {
		super();
		this.warningCount = warningCount;
		this.infoCount = infoCount;
		this.debugCount = debugCount;
		this.errorCount = errorCount;
	}
	
	/**
	 * 
	 * @return number of warning Count
	 */
	public int getWarningCount() {
		return warningCount;
	}
	
	/**
	 * 
	 * @return number of Info Count
	 */
	public int getInfoCount() {
		return infoCount;
	}
	/**
	 * 
	 * @return Number of Error Count
	 */
	public int getErrorCount() {
		return errorCount;
	}
	
	/**
	 * 
	 * @return Number of Debug Count
	 */
	public int getDebugCount() {
		return debugCount;
	}

}
