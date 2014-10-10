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

package org.oep.cmon.userreg.portlet.ldap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;

/** 
 * This is class LDAP
 * This class is used to create an user in LDAP server
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class LDAP {
	
	/** Ldap connection config file */
	private static final String LDAP_CONFIG_FILE = "vn/dtt/cmon/admin/portlet/business/LDAP_Config.properties";
	
	/** Directory context */
	private DirContext ctx = null;
	
	/** LDAP server name */
	private String lDapServerName = null;
	
	/** Root DN */
	private String rootDn = null;
	
	/** Root password */
	private String rootPass = null;
	
	/** Entry title */
	private String entryTitle = null;
	
	/**
	 * This is Constructor
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws NamingException 
	 * @throws IOException 
	 */
	public LDAP() throws NamingException, IOException{
		// Read ldap config from properties file
		URL resource = this.getClass().getClassLoader().getResource(LDAP_CONFIG_FILE);			
		
		Properties props = new Properties();
		
		BufferedReader file = new BufferedReader(new InputStreamReader(resource.openStream(), "utf-8"));
		props.load(file);
		
		this.lDapServerName = props.getProperty("LDAP_SERVER");
		this.rootDn = props.getProperty("ROOT_DN");
		this.rootPass = props.getProperty("ROOT_PASS");
		this.entryTitle = props.getProperty("ENTRY_TITLE");

		Properties env = new Properties();
        
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
        env.put(Context.SECURITY_PROTOCOL, Context.SECURITY_AUTHENTICATION );
        env.put(Context.PROVIDER_URL, "ldap://" + this.lDapServerName + "/");
        env.put(Context.SECURITY_PRINCIPAL, this.rootDn );
        env.put(Context.SECURITY_CREDENTIALS, this.rootPass );

        this.ctx = new InitialDirContext( env );
	}
	
	/**
	 * This is function add an entry to LDAP server
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param email
	 * @param password
	 * @param fullName
	 * @throws NamingException
	 */
	public void addEntry(String email, String password, String fullName) throws NamingException{
		 Attributes myAttrs = new BasicAttributes(true);
         Attribute oc = new BasicAttribute("objectClass");

         oc.add("inetOrgPerson");
         oc.add("organizationalPerson");
         oc.add("person");
         oc.add("top");
         
         myAttrs.put(oc);
         
         myAttrs.put( "cn","Manager");
         
         myAttrs.put( "givenName", fullName);
         
         myAttrs.put("sn"," "); // 1 blank
         
         myAttrs.put("title", this.entryTitle);
         
         // Remove @
         String uid = email.replace("@", "");
         
         // remove dot
         uid = uid.replace(".", "");
         
         myAttrs.put("uid", uid);
         myAttrs.put("userPassword", password);
                 
         this.ctx.bind("mail=" + email +"," + this.rootDn, "",  myAttrs);
	}	

	/**
	 * This is function check if an user exist or not by email
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param email
	 * @throws NamingException
	 * @return boolean
	 */
	public boolean isExist(String email) throws NamingException{

        String searchFilter = "mail=" + email;

        String searchBase = this.rootDn;

        return this.getSearchResult(ctx, searchFilter, searchBase);
	}        
	
	/**
	 * This is function get search result
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dirContext
	 * @param searchFilter
	 * @param searchBase
	 * @return boolean
	 * @throws NamingException
	 */
	@SuppressWarnings("rawtypes")
	private boolean getSearchResult(final DirContext dirContext, String searchFilter, String searchBase) throws NamingException{        
         
        final SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        
 		NamingEnumeration searchResults = dirContext.search(searchBase,searchFilter,constraints);        
        
        if(searchResults != null && searchResults.hasMore()){
            return true;          
        }
        
        return false;
	}
}
