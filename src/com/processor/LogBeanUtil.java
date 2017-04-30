package com.processor;


/**
 * 
 * @author ASoomro
 * --LogBeanUtil is used to assemble a bean from the tokens extracted from a log file
 *
 */
public class LogBeanUtil {
	
	/**
	 * 
	 * @param logTokens Array Of String containing tokens extracted from a log File
	 * @return Log Bean
	 */
	public static Log assembleBean(String[] logTokens) {
		 
		 Log log = new Log();
		 log.setDate(logTokens[0].split(",")[0]);
		 log.setLogLevel(logTokens[1]);
		 log.setMessage(logTokens[2]  + " - " + logTokens[3]!=null?logTokens[3]:"" );
		 return log;
	}


}
