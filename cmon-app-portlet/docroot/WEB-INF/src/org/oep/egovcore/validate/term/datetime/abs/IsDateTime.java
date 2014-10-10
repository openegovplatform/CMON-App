package org.oep.egovcore.validate.term.datetime.abs;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestString;

import com.liferay.portal.kernel.util.StringPool;

/**
 * This is abstract class IsDateTime  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class IsDateTime extends RequestString {
	
	private String _hint;

	public IsDateTime(String hint) {
		_hint = hint;
	}
	
	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_INVALID_CHOICE);
	}

	@Override
	public String message(String target) {
		return getTemplate().sub(
			target, 
			new StringBuilder(StringPool.OPEN_PARENTHESIS)
				.append(_hint)
				.append(StringPool.CLOSE_PARENTHESIS)
		);
	}
	
	@Override
	public String messageEN(String target) {
		return getTemplate().sub(
			target, 
			new StringBuilder(StringPool.OPEN_PARENTHESIS)
				.append(_hint)
				.append(StringPool.CLOSE_PARENTHESIS)
		);
	}
}
