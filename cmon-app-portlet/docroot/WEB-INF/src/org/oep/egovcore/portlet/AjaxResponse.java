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

package org.oep.egovcore.portlet;

import java.util.Date;

import javax.portlet.ResourceResponse;

import org.oep.egovcore.validate.Validator;

import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
/**
*
* AjaxResponse  class
*   
* This class is used to declare AjaxResponse 
*
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class AjaxResponse {
	
	private JSONObject _response;
	private ResourceResponse _originalResponse;
	
	public boolean isUsed() {
		return _response.length() > 0;
	}
	
	public AjaxResponse(ResourceResponse oresponse) {
		_response = JSONFactoryUtil.createJSONObject();
		_originalResponse = oresponse;
	}
	
	public ResourceResponse getOriginalResponse() {
		return _originalResponse;
	}
	
	public JSONObject getOutput() {
		return _response;
	}
	
	public AjaxResponse send(String arg0, boolean agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, String agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, int agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, long agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, double agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, JSONArray agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, JSONObject agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public AjaxResponse send(String arg0, Date agr1) {
		_response.put(arg0, agr1);
		return this;
	}
	
	public void setStatus(int status) {
		_response.put(Keys.STATUS, status);
	}
	
	public void reload(String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_MESSAGE)
			.put(Keys.REDIRECT_URL, RELOAD_MARK);
	}
	
	public void reload() {
		_response.put(Keys.REDIRECT_URL, RELOAD_MARK);
	}
	
	public void redirect(String url, String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_MESSAGE)
			.put(Keys.REDIRECT_URL, url);
	}
	
	public void goTo(String url, String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_MESSAGE)
			.put(Keys.GOTO_URL, url);
	}
	
	public void redirect(String url) {
		_response.put(Keys.REDIRECT_URL, url);
	}
	
	public void goTo(String url) {
		_response.put(Keys.GOTO_URL, url);
	}
	
	public void sendSuccessMessage(String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_SUCCESS)
		;
	}
	
	public void sendWarningMessage(String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_WARNING)
		;
	}
	
	public void sendErrorMessage(String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_ERROR)
		;
	}

	public void sendMessage(String message) {
		_response
			.put(Keys.MESSAGE, message)
			.put(Keys.MESSAGE_TYPE, MESSAGE_TYPE_MESSAGE)
		;
	}
	
	public void sendSingleValidateMessage(String messageKey, String message) {
		_response
			.put(Keys.VALIDATE_FLAG, false)
			.put(
				Keys.VALIDATE_MESSAGES,
				JSONFactoryUtil.createJSONObject()
				.put(messageKey, message)
			);
	}
	
	/**
	 * Send validation result metadata to client and return validate result
	 * @param request
	 * @param validator
	 * @return
	 */
	public boolean sendValidateResult(Validator validator) {
		boolean flag = validator.isValid();
		_response
			.put(Keys.VALIDATE_MESSAGES, validator.getMessages())
			.put(Keys.VALIDATE_FLAG, flag);
		return flag;
	}
	
	/**
	 * @param result
	 * @throws Exception
	 */
	public void sendSearchResult(QueryResult<?> queryResult, JSONArray searchResultJSON) {
		
		_response
			.put(Keys.RESULT_COUNT, queryResult.getResultCount())
			.put(Keys.FETCHED_COUNT, queryResult.getFetchedCount())
			.put(Keys.SEARCH_RESULT, searchResultJSON);
	}
	
	
	public static class Keys {
		/**
		 * Search result collection
		 */
		public static final String SEARCH_RESULT = "__searchResult";
		
		/**
		 * Fetched search item count
		 */
		public static final String FETCHED_COUNT = "__fetchedCount";
		
		/**
		 * Search result item count
		 */
		public static final String RESULT_COUNT = "__resultCount";
		
		/**
		 * Validate message
		 */
		public static final String VALIDATE_MESSAGES = "__validateMessages";
		
		/**
		 * Message from server
		 */
		public static final String MESSAGE = "__message";
		public static final String MESSAGE_TYPE = "__messageType";
		
		/**
		 * Validate flag
		 */
		public static final String VALIDATE_FLAG = "__validateFlag";
		
		/**
		 * Trạng thái(ok hoặc exception)
		 */
		public static final String STATUS = "__status";
		
		public static final String REDIRECT_URL = "__redirectURL";
		public static final String GOTO_URL = "__goToURL";
	}
	
	public static final int STATUS_OK = 1;
	public static final int STATUS_EXCEPTION = 2;
	public static final int MESSAGE_TYPE_MESSAGE = 1;
	public static final int MESSAGE_TYPE_SUCCESS = 2;
	public static final int MESSAGE_TYPE_WARNING = 3;
	public static final int MESSAGE_TYPE_ERROR = 4;
	public static final int RELOAD_MARK = 666;
}
