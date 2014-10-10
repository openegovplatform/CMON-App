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

package org.oep.cmon.userreg.portlet.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;

import vn.dtt.cmon.mail.MailContext;
import vn.dtt.cmon.mail.MailTemplateUtil;
import vn.dtt.cmon.mail.SendMailUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/** 
 * This is class CitizenCreationRequestMail
 * 
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
	
	
	/** email */
	private String uri = null;
	
	

	/**
	 * Constructor
	 * 
	 * @param dataProvider
	 */
	public CitizenCreationRequestMail() { 
		// Do nothing
	}
	
	/**
	 * This is function send email
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws toAddress
	 * @throws request
	 * @throws IOException
	 */
	public void send(String toAddress, ActionRequest request) throws IOException{
		// Get Mail template content
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		URL resource = this.getClass().getClassLoader().getResource(MAIL_TEMPLATE);   

		MailContext context = new MailContext();                  

		// Bind value to value place holder

		context.setProperty("citizen_name", this.fullName);
		
		context.setProperty("url", this.url);
		
		context.setProperty("uri", this.uri);
		
		try{
            // Create mail content
            String mailContent = MailTemplateUtil.getContent("citizen_confirmation_mail_template", resource.openStream(), context);
            // Get the file from class package structure
    		URL configResource = this.getClass().getClassLoader().getResource(MAIL_CONFIG);			
    								
    		Properties props = new Properties();
    		
    		BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
    		props.load(file);
    		
    		String mailSubject = props.getProperty("MAIL_SUBJECT_CITIZEN_CREATION");
    		String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
    		
    		//String fromPerson = props.getProperty("FROM_PERSON");
    		String fromPerson = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_NAME);
    		//sendEmail(fromAddress, toAddress, mailSubject, mailContent, true);
           SendMailUtil.send( this.email, fromAddress, fromPerson, mailSubject, mailContent);

		} catch (Exception e) {

            // Sending mail failure should not stop the process flow

            // so this exception is swallowed and stack trace is printed out here

            e.printStackTrace();
		}
	}

	/**
	 * This is function send email
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws from
	 * @throws to
	 * @throws subject
	 * @throws body
	 * @throws htmlFormat
	 * @throws IOException
	 * @return boolean
	 */
	 public static boolean sendEmail(String from, String to, String subject,
			   String body, boolean htmlFormat) throws IOException {
			  try {
			   if (from.trim().length() > 0 && to.trim().length() > 0) {

			    MailMessage mailMessage = new MailMessage(new InternetAddress(
			      from), new InternetAddress(to), subject, body,
			      htmlFormat);
			    MailServiceUtil.sendEmail(mailMessage);
			    return true;
			   } else {
			   }

			  } catch (Exception e) {
			   e.printStackTrace();
			  }
			  return false;
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
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
