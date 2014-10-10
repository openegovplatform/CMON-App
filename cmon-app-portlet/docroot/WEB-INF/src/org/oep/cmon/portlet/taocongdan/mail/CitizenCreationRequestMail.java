/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.portlet.taocongdan.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import java.util.Properties;

import vn.dtt.cmon.mail.MailContext;
import vn.dtt.cmon.mail.MailTemplateUtil;
import vn.dtt.cmon.mail.SendMailUtil;

/** 
 * Send account request confirmation mail class
 * This class is used to send mail after a request to create account is created in database
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CitizenCreationRequestMail {
	
	/** Mail template */
	private static final String MAIL_TEMPLATE = "vn/dtt/cmon/userreg/portlet/mail/citizen_confirmation_mail.template";
	
	/** Mail config file */
	private static final String MAIL_CONFIG = "vn/dtt/cmon/userreg/portlet/mail/mail_config.properties";
	
	/** Full name */
	private String fullName = null;
	
	/** Url */
	private String url = null;	
	
	/** email */
	private String email = null;
	
	/**
	 * Constructor
	 * 
	 * @param dataProvider
	 */
	public CitizenCreationRequestMail() { 
		// Do nothing
	}
	
	/**
	 * Send mail
	 * @throws IOException 
	 */
	public void send() throws IOException{
		// Get Mail template content
		URL resource = this.getClass().getClassLoader().getResource(MAIL_TEMPLATE);   

		MailContext context = new MailContext();                  

		// Bind value to value place holder

		context.setProperty("citizen_name", this.fullName);
		
		context.setProperty("url", this.url);
		
		try{
            // Create mail content
            String mailContent = MailTemplateUtil.getContent("citizen_confirmation_mail_template", resource.openStream(), context);
            
            // Get the file from class package structure
    		URL configResource = this.getClass().getClassLoader().getResource(MAIL_CONFIG);			
    								
    		Properties props = new Properties();
    		
    		BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
    		props.load(file);
    		
    		String mailSubject = props.getProperty("MAIL_SUBJECT_CITIZEN_CREATION");
    		String fromAddress = props.getProperty("FROM_ADDRESS");
    		String fromPerson = props.getProperty("FROM_PERSON");

            SendMailUtil.send( this.email, fromAddress, fromPerson, mailSubject, mailContent);

		} catch (Exception e) {

            // Sending mail failure should not stop the process flow

            // so this exception is swallowed and stack trace is printed out here

            e.printStackTrace();
		}
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
	
}
