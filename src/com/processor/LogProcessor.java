package com.processor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author ASoomro
 * --LogProcessor processes the log files and returns the useful statistics about a log file
 */
public class LogProcessor {
	
	
	private static final String LOG_LEVEL_INFO = "[INFO]";
	private static final String LOG_LEVEL_DEBUG = "[DEBUG]";
	private static final String LOG_LEVEL_WARN = "[WARN]";
	private static final String LOG_LEVEL_ERROR = "[ERROR]";

	/**
	 * @param fileName
	 * @return LogStatistics which contains the amount Log Info, Log warnings, log errors and log debugs 
	 * @throws NoInputProvidedException if empty or null value is provided as an Input
	 * @throws IOException when the reading of file is interrupted 
	 * @throws FileNotFoundException If the provided input file is not found
	 */
	public LogStatistics getLogStatistics(String fileName) throws NoInputProvidedException, IOException, FileNotFoundException{

		int warningCount = 0;
		int infoCount = 0;
		int errorCount = 0;
		int debugCount = 0;

		if (fileName == null || "".equals(fileName)){
			throw new NoInputProvidedException("No Input provided. Please re-run the program with a valid filename and location");
		}

		String[] logTokens;
		Log log = null;

		FileInputStream fstream = null ;
		BufferedReader br = null;

		try{
			fstream = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			/* read log line by line */
			while ((strLine = br.readLine()) != null)   {
				if (!strLine.trim().equals("") ){

					if (Character.isDigit(strLine.charAt(0))){

						logTokens = getLogTokens(strLine);

						switch (logTokens[1]){
						case LOG_LEVEL_INFO:
							infoCount++;
							break;
						case LOG_LEVEL_WARN:
							warningCount++;
							break;
						case LOG_LEVEL_ERROR:
							errorCount++;
							break;
						case LOG_LEVEL_DEBUG:
							debugCount++;
							break;
						}

						log = LogBeanUtil.assembleBean(logTokens);
					}
				}
			}
		} catch(FileNotFoundException e){
			throw new FileNotFoundException(e.getMessage());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br!=null) br.close();
			if (fstream!=null) fstream.close(); 
		}

		LogStatistics logStats = new LogStatistics(warningCount, infoCount, debugCount, errorCount);
		return logStats;

	}
	
	/**
	 * Takes a log file as an input returns the list of all the warning logs in the file
	 * @param fileName
	 * @return List<Log> The list of all the warning logs in the file
	 * @throws NoInputProvidedException
	 * @throws IOException
	 */
	public List<Log> getAllWarningLogs(String fileName) throws NoInputProvidedException, IOException{
		List<Log> warningLogs = new ArrayList();
		if (fileName == null || "".equals(fileName)){
			throw new NoInputProvidedException("No Input provided. Please re-run the program with a valid filename and location");
		}

		String[] logTokens;
		Log log = null;

		FileInputStream fstream = null ;
		BufferedReader br = null;

		try{
			fstream = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			/* read log line by line */
			while ((strLine = br.readLine()) != null)   {
				if (!strLine.trim().equals("") ){

					if (Character.isDigit(strLine.charAt(0))){

						logTokens = getLogTokens(strLine);

						if (logTokens[1].equals(LOG_LEVEL_WARN)){
							log = LogBeanUtil.assembleBean(logTokens);
							warningLogs.add(log);
						}
						
					}
				}
			}
		} catch(FileNotFoundException e){
			throw new FileNotFoundException(e.getMessage());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br!=null) br.close();
			if (fstream!=null) fstream.close(); 
		}

		return warningLogs;
		
	}

	/**
	 * Takes a log file as an input and returns the list of All Error logs in the file
	 * @param fileName
	 * @return
	 * @throws NoInputProvidedException
	 * @throws IOException
	 */
	public List<Log> getAllErrorLogs(String fileName) throws NoInputProvidedException, IOException{
		List<Log> errorLogs = new ArrayList();
		if (fileName == null || "".equals(fileName)){
			throw new NoInputProvidedException("No Input provided. Please re-run the program with a valid filename and location");
		}

		String[] logTokens;
		Log log = null;

		FileInputStream fstream = null ;
		BufferedReader br = null;

		try{
			fstream = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			/* read log line by line */
			while ((strLine = br.readLine()) != null)   {
				if (!strLine.trim().equals("") ){

					if (Character.isDigit(strLine.charAt(0))){

						logTokens = getLogTokens(strLine);

						if (logTokens[1].equals(LOG_LEVEL_ERROR)){
							log = LogBeanUtil.assembleBean(logTokens);
							errorLogs.add(log);
						}
						
					}
				}
			}
		} catch(FileNotFoundException e){
			throw new FileNotFoundException(e.getMessage());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br!=null) br.close();
			if (fstream!=null) fstream.close(); 
		}

		return errorLogs;
		
	}


	
	
	
	
	/**
	 * 
	 * @param log i.e. A line from a log file
	 * @return Array of String containing the tokens extracted from a line of Log
	 */
	private String[] getLogTokens(String log){
		return log.split(" - ");
	}


}
