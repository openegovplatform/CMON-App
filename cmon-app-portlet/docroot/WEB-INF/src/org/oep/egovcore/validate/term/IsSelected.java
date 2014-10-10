package org.oep.egovcore.validate.term;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestString;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * This is class IsSelected  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsSelected extends RequestString {
	
	private String _defaultVal;
	
	public IsSelected() {}
	
	public IsSelected(Object defaultVal) {
		if (defaultVal != null) {
			_defaultVal = defaultVal.toString();
		}
	}
	
	public IsSelected setDefault(Object defaultVal) {
		if (defaultVal != null) {
			_defaultVal = defaultVal.toString();
		}
		return this;
	}
	
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_SELECTED);
	}
	
	protected boolean _isInputed(String value) {
		return _isValid(value);
	}
	
	/**
	 * This is class _isValid  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return boolean
	 */
	@Override
	protected boolean _isValid(String value) {
		if (_defaultVal == null) {
			return GetterUtil.getLong(value) != 0L;
		} else {
			value = value.trim();
			return !value.isEmpty()
				&& !value.equals(_defaultVal.toString().trim());
		}
	}
}
