package org.oep.egovcore.validate;

/**
 * This is abstract class Term 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class Term<T> {
	public void setRequired(boolean b) {
		_required = b;
	}
	public final MessageTemplate getTemplate() {
		if (_template == null) {
			_template = _useTemplate();
		}
		return _template;
	}
	public final boolean isInputed(T value) {
		if (value == null) {
			return false;
		}
		return _isInputed(value);
	}
	public final boolean isValid(T value) {
		boolean b = isInputed(value);
		if (_required) {
			return b && _isValid(value);
		} else {
			return b ? _isValid(value) : true;
		}
	}
	
	public String message(String target) {
		return getTemplate().sub(target);
	}
	public String messageEN(String target) {
		return getTemplate().subEN(target);
	}
	
	protected abstract boolean _isValid(T value);
	protected abstract boolean _isInputed(T value);
	protected abstract MessageTemplate _useTemplate();
	
	private MessageTemplate _template;
	private boolean _required = true;
}