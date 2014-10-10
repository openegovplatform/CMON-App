package org.oep.cmon.dao.chungthuc.utils;

import javax.portlet.ActionRequest;

import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.portlet.hosotructiep.HoSoFields;
import org.oep.egovcore.util.VNNumberUtil;


import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;

public class ChungThucValidator {

	public static boolean hoSoChungThucValidate(UploadPortletRequest  uploadRequest, ActionRequest actionRequest) {
		boolean ok = true;
		if (ParamUtil.getLong(uploadRequest, HoSoFields.thuTucHanhChinhId) == 0) {
			SessionErrors.add(actionRequest, HoSoFields.thuTucHanhChinhId);
			ok = false;
		}
		
		if (ParamUtil.getLong(uploadRequest, "soDanhMucId") == 0) {
			SessionErrors.add(actionRequest, "soDanhMucId");
			ok = false;
		}
		
		if (ParamUtil.getString(uploadRequest, HoSoFields.hoTenNguoiNopHoSo).equals("")) {
			SessionErrors.add(actionRequest, HoSoFields.hoTenNguoiNopHoSo);
			ok = false;
		}
		
		if (ParamUtil.getString(uploadRequest, HoSoFields.chuSoHuu).equals("")) {
			SessionErrors.add(actionRequest, HoSoFields.chuSoHuu);
			ok = false;
		}
		
		if (ParamUtil.getString(uploadRequest, HoSoFields.ngayNhanHoSo).equals("")) {
			SessionErrors.add(actionRequest, HoSoFields.ngayNhanHoSo);
			ok = false;
		}
		if (ParamUtil.getString(uploadRequest, HoSoFields.ngayHenTraHoSo).equals("")) {
			SessionErrors.add(actionRequest, HoSoFields.ngayHenTraHoSo);
			ok = false;
		}
//		if (ParamUtil.getLong(uploadRequest, HoSoFields.soBoHoSo) == 0) {
//			SessionErrors.add(actionRequest, HoSoFields.soBoHoSo);
//			ok = false;
//		}
//		if (ParamUtil.getLong(actionRequest, Fields.phiHoSo) == 0) {
//			SessionErrors.add(actionRequest, Fields.phiHoSo);
//			ok = false;
//		}
		
/*		int lePhi = (int) VNNumberUtil.toNum(ParamUtil.getString(uploadRequest, HoSoFields.lePhiHoSo));
		
		if (lePhi <= 0) {
			SessionErrors.add(actionRequest, HoSoFields.lePhiHoSo);
			ok = false;
		}*/
		
		return ok;
	}
	
	public static boolean soDanhMucValidator(ActionRequest actionRequest) {
		boolean ok = true;
		
		if (ParamUtil.getLong(actionRequest, "thuTucHanhChinhId") == 0) {
			SessionErrors.add(actionRequest,"thuTucHanhChinhId");
			ok = false;
		}
		
/*		if (ParamUtil.getString(actionRequest,"tenSo").equals("")) {
			SessionErrors.add(actionRequest, "tenSo");
			ok = false;
		}*/
		
		if (ParamUtil.getString(actionRequest,"soChungThuc").equals("")) {
			SessionErrors.add(actionRequest, "soChungThuc");
			ok = false;
		}
		
		if (ParamUtil.getLong(actionRequest, "nam") == 0) {
			SessionErrors.add(actionRequest, "nam");
			ok = false;
		}
		
/*		if (ParamUtil.getString(actionRequest,"theoQuyetDinh").equals("")) {
			SessionErrors.add(actionRequest, "theoQuyetDinh");
			ok = false;
		}*/
		
		if (!ok) {
			FormatUtil.setParams(actionRequest);
		}
		
		return ok;
	}
	
}
