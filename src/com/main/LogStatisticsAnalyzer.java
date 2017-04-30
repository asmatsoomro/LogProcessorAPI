package com.main;

import java.io.IOException;
import java.util.List;

import com.processor.Log;
import com.processor.LogProcessor;
import com.processor.LogStatistics;
import com.processor.NoInputProvidedException;
/**
 * 
 * @author ASoomro
 * -- Main Class used to test the processing of API under valid input
 */
public class LogStatisticsAnalyzer {

	public static void main(String[] args) throws NoInputProvidedException, IOException {
		
		long startTime =System.currentTimeMillis();
		
		LogProcessor logProcessor = new LogProcessor();
	
		LogStatistics logStats = logProcessor.getLogStatistics("resources/application_log_data.log");
		
		System.out.println("--------------------- LOG LEVEL STATISTICS----------------------");
		System.out.println("Warning:: " +logStats.getWarningCount());
		System.out.println("Info:: "+logStats.getInfoCount());
		System.out.println("Error:: " +logStats.getErrorCount());
		System.out.println("Debug:: " +logStats.getDebugCount());
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time Taken in milliseconds to process the API::" + (endTime - startTime));
			
		
	}
	
	

}
