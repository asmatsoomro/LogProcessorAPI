package com.main;

import java.io.IOException;
import java.util.List;

import com.processor.Log;
import com.processor.LogProcessor;
import com.processor.NoInputProvidedException;

/**
 * 
 * @author ASoomro
 * Fetches all the Errors logs from a log file
 */
public class LogErrorsFetcher {

	public static void main(String[] args) throws NoInputProvidedException, IOException {
		long startTime =System.currentTimeMillis();
		
		LogProcessor logProcessor = new LogProcessor();
		
		List<Log> errorLogs = logProcessor.getAllErrorLogs("resources/application_log_data.log");
		
		System.out.println("Error Logs Count::"+errorLogs.size());
		
		errorLogs.forEach(log ->{
			System.out.println(log);
		});
	
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time Taken in milliseconds to process the API::" + (endTime - startTime));
	
	}


}
