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

package org.oep.cmon.user.portlet.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import java.util.Properties;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import vn.dtt.cmon.mail.MailContext;
import vn.dtt.cmon.mail.MailTemplateUtil;
import vn.dtt.cmon.mail.SendMailUtil;

/**
 * This is class UserCreationMail
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class UserCreationMail {
	
	/** Mail template */
	private static final String MAIL_TEMPLATE = "vn/dtt/cmon/user/portlet/mail/user_creation_mail.template";
	
	/** Mail config file */
	private static final String MAIL_CONFIG = "vn/dtt/cmon/user/portlet/mail/mail_config.properties";
	
	/** Full name */
	private String fullName = null;
	
	private String url = null;
	
	/** User name */
	private String userName = null;
	
	/** Password */
	private String password = null;
	
	/** Email */
	private String email = null;	
	
	/**
	 * Constructor
	 * 
	 * @param dataProvider
	 */
	public UserCreationMail() { 
		// Do nothing
	}
	
	/**
	 * Send mail
	 * @throws IOException 
	 */
	public void send(ActionRequest actionRequest) throws IOException{
		// Get Mail template content
		URL resource = this.getClass().getClassLoader().getResource(MAIL_TEMPLATE);   

		MailContext context = new MailContext();                  

		// Bind value to value place holder

		context.setProperty("citizen_name", this.fullName);
		
		context.setProperty("user_name", this.userName);
		
		context.setProperty("user_password", this.password);
		context.setProperty("url", this.url);
		
		try{
            // Create mail content
            String mailContent = MailTemplateUtil.getContent("user_creation_mail_template", resource.openStream(), context);
            
            // Get the file from class package structure
    		URL configResource = this.getClass().getClassLoader().getResource(MAIL_CONFIG);			
    								
    		Properties props = new Properties();
    		
    		BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
    		props.load(file);
    		
    		String mailSubject = props.getProperty("MAIL_SUBJECT_USER_CREATION");
    		//String fromAddress = props.getProperty("FROM_ADDRESS");
    		//String fromPerson = props.getProperty("FROM_PERSON");

    		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
    		//String fromPerson = props.getProperty("FROM_PERSON");
    		String fromPerson = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_NAME);
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
	
	public String getUrl() {
		return url;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
