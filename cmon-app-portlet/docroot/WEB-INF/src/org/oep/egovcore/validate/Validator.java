package org.oep.egovcore.validate;

import javax.portlet.PortletRequest;

import org.oep.egovcore.language.Messager;
import org.oep.egovcore.validate.datasource.PortletRequestSource;
import org.oep.egovcore.validate.datasource.UploadRequestSource;


import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

/**
 * This is class Validator  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class Validator {
	
	public Validator(PortletRequest request, Messager msger) {
		_pRequest = request;
		_msger = msger;
		_messages = JSONFactoryUtil.createJSONObject();
	}
	
	public Validator(UploadPortletRequest request, Messager msger) {
		_uRequest = request;
		_msger = msger;
		_messages = JSONFactoryUtil.createJSONObject();
	}
	
	public void enterMultiMode() {
		_isMultiMode = true;
		_mutilCheckFlag = true;
	}
	
	public boolean isMultiModeResultFail() {
		_isMultiMode = false;
		return !_mutilCheckFlag;
	}
	
	public <T> boolean orCheck(Term<T> term, String param) {
		if (_isMultiMode) {
			_mutilCheckFlag = _mutilCheckFlag || term.isValid(getRequestValue(term, param));
			return _mutilCheckFlag;
		} else {
			return _mutilCheckFlag;
		}
	}
	
	public <T> boolean check(Term<T> term, String key) {
		if (_isMultiMode) {
			_mutilCheckFlag = _mutilCheckFlag && term.isValid(getRequestValue(term, key));
			return _mutilCheckFlag;
		} else {
			return check(term, key, _msger.get(key), _msger.getEN(key), key);
		}
	}
	
	public <T> boolean check(Term<T> term, String key, String messageKey) {
		return check(term, key, _msger.get(key), _msger.getEN(key), messageKey);
	}
	
	public <T> boolean check(
		Term<T> term,
		String param,
		String viSubTarget,
		String enSubTarget,
		String messageKey
	) {
		boolean b;
		b = term.isValid(getRequestValue(term, param));
		if (!b) {
			putMessage(
				messageKey, 
				term.message(viSubTarget), 
				term.messageEN(enSubTarget)
			);
		}
		return b;
	}
	
	public <T> boolean check(
		Term<T> term,
		T[] arr,
		int index,
		String key,
		String messageKey
	) {
		boolean b;
		if (arr.length <= index) {
			b = false;
		} else {
			b = term.isValid(arr[index]);
		}
		if (!b) {
			putMessage(
				messageKey, 
				term.message(_msger.get(key)), 
				term.messageEN(_msger.getEN(key))
			);
		}
		return b;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getRequestValue(Term<T> term, String param) {
		T value;
		if (_pRequest != null) {
			value = ((PortletRequestSource<T>) term).getValue(_pRequest, param);
		} else {
			value = ((UploadRequestSource<T>) term).getValue(_uRequest, param);
		}
		return value;
	}
	
	public Validator putMessage(
		String messageKey,
		MessageTemplate template,
		String key
	) {
		return putMessage(
			messageKey,
			template.sub(_msger.get(key)),
			template.subEN(_msger.getEN(key))
		);
	}
	
	public Validator putMessage(
		String messageKey,
		MessageTemplate template,
		String key,
		String... replaceKeys
	) {
		Object[] viAgrs, enAgrs;
		viAgrs = new Object[replaceKeys.length];
		enAgrs = new Object[replaceKeys.length];
		for (int i = 0; i < replaceKeys.length; ++ i) {
			viAgrs[0] = MessageTemplate.format(_msger.get(replaceKeys[i]));
			enAgrs[0] = MessageTemplate.format(_msger.getEN(replaceKeys[i]));
		}
		
		return putMessage(
			messageKey,
			template.sub(_msger.get(key), viAgrs),
			template.subEN(_msger.getEN(key), enAgrs)
		);
	}

	public Validator putMessage(String messageKey, String viMessage, String enMessage) {
		String msg;
		if (_is2Lang && enMessage != null && !enMessage.trim().isEmpty()) {
			msg = _messageFormat.replace(VI_HOLDER, viMessage);
			msg = msg.replace(EN_HOLDER, enMessage);
		} else {
			msg = viMessage;
		}
		
		if (_allowMultiMessage) {
			_messages.put(messageKey,
				new StringBuilder(_messages.getString(messageKey))
					.append(_multiMessageSep)
					.append(msg)
					.toString()
			);
		} else if (!hasMessage(messageKey)) {
			_messages.put(messageKey, msg);
		}
		
		return this;
	}
	
	public boolean isValid() {
		return _messages.length() == 0;
	}
	
	public Validator setMessager(Messager m) {
		_msger = m;
		return this;
	}
	
	public Validator setMessageFormat(String s) {
		_messageFormat = s;
		return this;
	}
	
	public Validator setAllowMultiMessage(boolean b) {
		_allowMultiMessage = b;
		return this;
	}
	
	public Validator setIs2Lang(boolean b) {
		_is2Lang = b;
		return this;
	}
	
	public Validator setMultiMessageSeparator(String s) {
		_multiMessageSep = s;
		return this;
	}
	
	public JSONObject getMessages() {
		return _messages;
	}
	
	public Messager getMessager() {
		return _msger;
	}
	
	public static final String VI_HOLDER = "{vi}";
	public static final String EN_HOLDER = "{en}";
	public static final String LAN_SEP = "/";
	public static final String MULTI_MESSAGE_SEP = "<br> - ";
	
	private boolean hasMessage(String messageKey) {
		return _messages.has(messageKey);
	}
	
	private PortletRequest _pRequest;
	private UploadPortletRequest _uRequest;
	private Messager _msger;
	private JSONObject _messages;
	private boolean _mutilCheckFlag;
	private boolean _isMultiMode = false;
	private boolean _allowMultiMessage = false;
	private boolean _is2Lang = false;
	private String _multiMessageSep = MULTI_MESSAGE_SEP;
	private String _messageFormat = 
		new StringBuilder(VI_HOLDER)
		.append(LAN_SEP)
		.append("<em>")
		.append(EN_HOLDER)
		.append("</em>")
		.toString();
}
