package org.oep.sharedservice.cmon.provider.thamso;

import java.util.HashMap;
import java.util.List;

import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

public class ThamSoUtils {
	
	public static HashMap<String, String> parameters = null;
	
	public static  void loading(){
		List<ThamSo> tList = ThamSoLocalServiceUtil.getAll();
		if(tList != null){
			parameters = new HashMap<String, String>();
			for (ThamSo thamSo : tList) {
				parameters.put(thamSo.getTen(), thamSo.getGiaTri());
			}
		}
	}
}
