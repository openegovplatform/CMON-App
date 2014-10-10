package org.oep.cmon.job.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;

/** 
 * This is class MessageUtil
 *  
 * This class will read message defined in properties file and return the message
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  30-May-2013  Nam Dinh    Create new
 */
public class MessageUtil {
	
	/** Message file */
	private static final String MESSAGE_FILE = "vn/dtt/cmon/job/activity/message.properties";
	
	/** Properties */
	private Properties props = null;
	
	/**
	 * This is  Constructor
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */  
	public MessageUtil() throws UnsupportedEncodingException, IOException{
		// Read data from properties file
		URL configResource = this.getClass().getClassLoader().getResource(MESSAGE_FILE);			
		
		this.props = new Properties();
		
		BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
		props.load(file);
	}
	
	/**
	 * This is  function getMessage
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param key
	 * @param actionResponse
	 * @return String
	 */  
	public String getMessage(String key) {
		return this.props.getProperty(key);
	}
}
