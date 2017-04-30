package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.processor.Log;
import com.processor.LogProcessor;
import com.processor.LogStatistics;
import com.processor.NoInputProvidedException;

import static org.junit.Assert.assertEquals;


/**
 * 
 * @author ASoomro
 * --TestCases written to ensure the expected behavior of LogProcessor
 */
public class LogProcessorTest {
	
	LogProcessor logProcessor;
	
	/**
	 * Creates the LogProcessor instance before running any test
	 */
	@Before
	public void createInstanceBeforeRunningATest(){
		logProcessor = new LogProcessor();
		
	}
	
	/**
	 * The test verifies that FileNotFoundException is thrown if invalid file name is provided
	 * @throws NoInputProvidedException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test (expected = FileNotFoundException.class)
	public void verifyThatLogProcessorThrowsAnExceptionWhenInvalidFileIsProvided() throws NoInputProvidedException, 
											IOException, FileNotFoundException{
		logProcessor.getLogStatistics("InvalidFileName");
		
	}
	
	/**
	 * The test verifies that NoInputProvidedException is thrown if Null is given as an input
	 * @throws NoInputProvidedException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test (expected = NoInputProvidedException.class)
	public void verifyThatLogProcessorThrowsAnExceptionWhenNullValudIsProvided() throws NoInputProvidedException, IOException{
		logProcessor.getLogStatistics(null);
		
	}
	
	/**
	 * The test verifies that All the logs are processed successfully 
	 * and the accurate log statistics are returned
	 * @throws NoInputProvidedException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void verifyThatLogProcessorParsesAllTheLogsFromLogFilesSuccessfully() throws NoInputProvidedException, IOException, FileNotFoundException{
		
			LogStatistics logStats = logProcessor.getLogStatistics("resources/application_log_data.log");
	
			assertEquals(1734, logStats.getWarningCount());

			assertEquals(0, logStats.getDebugCount());

			assertEquals(1, logStats.getErrorCount());

			assertEquals(19108, logStats.getInfoCount());

			
	}
	
	/**
	 * The test verifies the LogProcessor returns the list of All Warning Logs in the log file
	 * @throws NoInputProvidedException
	 * @throws IOException
	 */
	@Test
	public void verifyThatGetAllWarningLogsReturnTheListOfAllWarningLogs() throws NoInputProvidedException, IOException{
		List<Log> warningLogs = logProcessor.getAllWarningLogs("resources/application_log_data.log");
		
		assertEquals(1734, warningLogs.size());
	}
	
	/**
	 * The test verifies the LogProcessor returns the list of All Error Logs in the log file
	 * @throws NoInputProvidedException
	 * @throws IOException
	 */
	@Test
	public void verifyThatGetAllErrorLogsReturnTheListOfAllErrorLogs() throws NoInputProvidedException, IOException{
		List<Log> errorLogs = logProcessor.getAllErrorLogs("resources/application_log_data.log");
		
		assertEquals(1, errorLogs.size());
	}
	
	
	/**
	 * The test verifies that the private method getLogTokens in LogProcessor class returns the
	 * valid StringArray of log tokens.
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void verifyThatGetLogTokensReturnTheValidStringOfTokens() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		
		 String log = "2016-09-06 08:29:13,662 - [INFO] - from application in ForkJoinPool-1-worker-15 - [WS] GET https://ch.development.douglas.de/douglas/json/userSessionV2.json took 19 ms correlationId: 0ea6b06c-8b56-4519-b525-a17a4f8ac73d";
		//String parameter
		Class[] paramString = new Class[1];
		paramString[0] = String.class;
		
		Class c = Class.forName("com.processor.LogProcessor");
		LogProcessor o = (LogProcessor) c.newInstance();
		Method m = c.getDeclaredMethod("getLogTokens", paramString);
		m.setAccessible(true);
		String[] logTokens = (String[]) m.invoke(o, new String(log));
		
		assertEquals("2016-09-06 08:29:13,662" , logTokens[0]);
		assertEquals("[INFO]" , logTokens[1]);
		assertEquals("from application in ForkJoinPool-1-worker-15" , logTokens[2]);
		assertEquals("[WS] GET https://ch.development.douglas.de/douglas/json/userSessionV2.json took 19 ms correlationId: 0ea6b06c-8b56-4519-b525-a17a4f8ac73d" , logTokens[3]);
		
		
	}

}
