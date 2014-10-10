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

package org.oep.cmon.portlet.ipmslist.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.egovcore.util.LiferayURL;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.KeyedParameter;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class ComUtils
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ComUtils {
	
	private static Log _log = LogFactoryUtil.getLog(ComUtils.class);
	
	public ComUtils() {}

	/**
	 * This is function tiepNhanHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param danhSachHoSo
	 */
	public void tiepNhanHoSo(ActionRequest actionRequest, HoSoTTHCCong danhSachHoSo) {

		long userId = PortalUtil.getUserId(actionRequest);
		ThuTucHanhChinh thuTucHanhChinh = null;
		
		try {
			
			thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(danhSachHoSo.getThuTucHanhChinhId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (thuTucHanhChinh != null) {
				initUengineProcess(thuTucHanhChinh.getMa(),
					PortalUtil.getUserEmailAddress(userId),
					danhSachHoSo.getId(), danhSachHoSo.getMaSoHoSo(),
					danhSachHoSo.getHoTenNguoiNopHoSo(),
					danhSachHoSo.getNgayHenTraKetQua());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is function initUengineProcess
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tthcMa
	 * @param accountCanBo
	 * @param idHoSo
	 * @param maSoHoSo
	 * @param tenDoiTuongHoSo
	 * @param ngayHenTra
	 * @throws SystemException
	 * @return boolean
	 */
	private boolean initUengineProcess(
		String tthcMa,
		String accountCanBo,
		long idHoSo,
		String maSoHoSo,
		String tenDoiTuongHoSo,
		Date ngayHenTra
	) throws SystemException {

		IBrms brms = WebserviceFactory.getUengineService();
		String instid = brms.initInstanceMaTTHC(accountCanBo, tthcMa);

		if (instid != null) {
			List<KeyedParameter> processVariable = new ArrayList<KeyedParameter>();

			KeyedParameter key0 = new KeyedParameter();
			// id ho so
			key0.setKey("id_hoso");
			key0.setValue(idHoSo + "");

			KeyedParameter key1 = new KeyedParameter();
			// ma so ho so
			key1.setKey("maHoSo");
			key1.setValue(maSoHoSo);

			KeyedParameter key2 = new KeyedParameter();
			// ten doi tuong ho so
			key2.setKey("tenDoiTuongHoSo");
			key2.setValue(tenDoiTuongHoSo);

			KeyedParameter key3 = new KeyedParameter();
			// ngay tiep nhan
			key3.setKey("ngayTiepNhan");
			key3.setValue(ConvertUtil.parseDateToTring(new Date()));

			KeyedParameter key4 = new KeyedParameter();
			// ngay hen tra
			key4.setKey("ngayHenTra");
			key4.setValue(ConvertUtil.parseDateToTring(ngayHenTra));

			processVariable.add(key0);
			processVariable.add(key1);
			processVariable.add(key2);
			processVariable.add(key3);
			processVariable.add(key4);
			return brms.registerService(instid, processVariable);
		}
		
		return false;
	}
	
	/**
	 * This is function forward2Uengine
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param uengineProcessName
	 * @param hoSo
	 * @param accountCanBo
	 * @param maCoQuanTiepNhan
	 * @return boolean
	 */
	public static boolean forward2Uengine(
		String uengineProcessName,
		HoSoTTHCCong hoSo,
		String accountCanBo,
		String maCoQuanTiepNhan
	) {
		boolean ok = true;
		
		if (maCoQuanTiepNhan.startsWith("000")) {
			_log.info("______________ Call ComUtils.initUengineProcess() DE CHUYEN HO SO SANG UENGINE ______________");
			ok =  org.oep.cmon.util.ComUtils.initUengineProcess(
				uengineProcessName,
				accountCanBo,
				hoSo.getId(),
				hoSo.getMaSoHoSo(),
				hoSo.getChuSoHuu(),
				hoSo.getNgayTraKetQua()
			);
		} else {
			_log.info("______________ Call ComUtils.initUengineProcess4EWDMS() DE CHUYEN HO SO SANG UENGINE ______________");
			ok = org.oep.cmon.util.ComUtils.initUengineProcess4EWDMS(
				uengineProcessName,
				accountCanBo,
				hoSo.getId(),
				hoSo.getMaSoHoSo(),
				hoSo.getChuSoHuu(),
				hoSo.getNgayTraKetQua(),
				maCoQuanTiepNhan
			);
		}
		
		if (ok) {
			_log.info("______________ DA CHUYEN HO SO SANG UENGINE ______________");
		} else {
			_log.error("______________ LOI KHI CHUYEN HO SO SANG UENGINE ______________");
			_log.info("______________ UengineProcessName:" + uengineProcessName);
			_log.info("______________ AccountCanBo:" + accountCanBo);
			_log.info("______________ HoSoTTHCCongId:" + hoSo.getId());
			_log.info("______________ MaSoHoSo:" + hoSo.getMaSoHoSo());
			_log.info("______________ MaSoBienNhanHoSo:" + hoSo.getMaSoBienNhan());
			_log.info("______________ TenDoiTuongHoSo:" + hoSo.getChuSoHuu());
			_log.info("______________ MaCoQuanTiepNhan:" + maCoQuanTiepNhan);
		}
		
		return ok;
	}
	
	/**
	 * This is function getURLInPhieuLuanChuyen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @return LiferayURL
	 */
	public static LiferayURL getURLInPhieuLuanChuyen(HttpServletRequest request)
		throws Exception
	{
		return LiferayURL
			.createRenderURL(request, Constants.DEFAULT_PORTLET_NAME, "/html/portlet/ipmslistportlet/inPhieuLuuChuyen.jsp")
			.setWindowState(LiferayWindowState.MAXIMIZED);
	}
}
