package org.oep.egovcore.jsptag.optionlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringEscapeUtils;
import org.oep.egovcore.util.StringPool;

import org.oep.egovcore.jsptag.optionlist.OptionData;

import com.liferay.portal.kernel.util.GetterUtil;

public class OptionListTag extends SimpleTagSupport {

	public static final String TAG = "<option value=\"%s\"%s>%s</option>";
	public static final String BEGIN_GROUP_TAG = "<optgroup value=\"%s\" label=\"%s\">";
	public static final String END_GROUP_TAG = "</optgroup>";
	public static final String SELECTED_MARK = StringPool.SELECTED;
	
	public void setData(List<? extends OptionData> data) {
		_data = new ArrayList<OptionData>();
		for (OptionData item : data) {
			_data.add(item);
		}
	}
	
	public void setSelectedValue(Object selectedValue) {
		_selectedValue = selectedValue;
	}
	
	public void setIsGroupable(boolean isGroupable) {
		_isGroupable = isGroupable;
	}
	
	public void setIsDataSorted(boolean isDataSorted) {
		_isDataSorted = isDataSorted;
	}
	
	public void doTag() throws IOException {

		StringBuilder out = new StringBuilder();
		if (_isGroupable) {
			
			Object groupValue = null;
			String groupLabel;
			boolean bearkGroup, groupOpened = false;
			int count = _data.size();
			OptionData optionData;
			
			if ( !_isDataSorted ) {
				// Sort by option group
				Collections.sort(_data, new Comparator<OptionData>() {
	
					@Override
					public int compare(OptionData o1, OptionData o2) {
						return GetterUtil.getInteger(
							GetterUtil.getLong(o1.getGroupValue()) - GetterUtil.getLong(o2.getGroupValue())
						);
					}
					
				});
			}
			
			for (int i = 0; i < count; ++ i) {
				optionData = _data.get(i);
				bearkGroup = !_equal(groupValue, optionData.getGroupValue());
				if (bearkGroup) {
					
					groupValue = optionData.getGroupValue();
					
					if (i > 0) {
						out.append(END_GROUP_TAG);
						groupOpened = false;
					}
					
					groupLabel = GetterUtil.getString(optionData.getGroupLabel());
					
					out.append(String.format(
						BEGIN_GROUP_TAG,
						groupValue,
						StringEscapeUtils.escapeHtml(groupLabel)
					));

					groupOpened = true;
				}
				
				out.append(String.format(
					TAG,
					optionData.getValue(),
					_equal(_selectedValue, optionData.getValue()) ? SELECTED_MARK : StringPool.BLANK,
					StringEscapeUtils.escapeHtml(optionData.getText())
				));
			}
			
			if (groupOpened) {
				out.append(END_GROUP_TAG);
			}
		
		} else {
			
			for (OptionData optionData : _data) {
				out.append(String.format(
					TAG,
					optionData.getValue(),
					_equal(_selectedValue, optionData.getValue()) ? SELECTED_MARK : StringPool.BLANK,
					optionData.getText()
				));
			}
		}
		
		getJspContext().getOut().print(out);
	}
	
	private boolean _equal(Object val1, Object val2) {
		return val1 != null
			&& val2 != null
			&& val1.toString().trim().equals(val2.toString().trim())
		;
	}
	
	private List<OptionData> _data;
	private Object _selectedValue;
	private boolean _isGroupable;
	private boolean _isDataSorted = false;
}
