package org.oep.sharedservice.cmon;

import java.util.List;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

public class SharedserviceUtil {
	
	public static  TaiKhoanNguoiDung getTaiKhoanNguoiDungByLiferayId(Long userLiferayId){
		try {
			
			List<TaiKhoanNguoiDung> tList = TaiKhoanNguoiDungLocalServiceUtil
					.findByTaiKhoanNguoiDung(userLiferayId, Constants.ACTIVATED);
			if(tList != null && tList.size() >0){
				return tList.get(0);
				
				
			}
		} catch (Exception e1) {
			
		}
		return null;
	}

}
