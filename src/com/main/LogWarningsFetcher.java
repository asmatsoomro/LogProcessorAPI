package com.main;

import java.io.IOException;
import java.util.List;

import com.processor.Log;
import com.processor.LogProcessor;
import com.processor.NoInputProvidedException;

/**
 * 
 * @author ASoomro
 * -- Fetches all the warning logs from a log file
 */
public class LogWarningsFetcher {

	public static void main(String[] args) throws NoInputProvidedException, IOException {
		long startTime =System.currentTimeMillis();
		
		LogProcessor logProcessor = new LogProcessor();
		
		List<Log> warningLogs = logProcessor.getAllWarningLogs("resources/application_log_data.log");
		
		System.out.println("Warning Logs::"+warningLogs.size());
		
		warningLogs.forEach(log ->{
			System.out.println(log);
		});
	
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time Taken in milliseconds to process the API::" + (endTime - startTime));
	
	}

}
