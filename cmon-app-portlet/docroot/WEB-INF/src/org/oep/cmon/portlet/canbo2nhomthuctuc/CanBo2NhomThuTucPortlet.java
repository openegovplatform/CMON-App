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

package org.oep.cmon.portlet.canbo2nhomthuctuc;

import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.cc.model.impl.CongChuc2NhomThuTucModelImpl;
import org.oep.cmon.portlet.cmon.CanBoPortlet;
import org.oep.egovcore.language.BusinessMessagerUtil;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.Helper;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTucClp;
import org.oep.cmon.dao.cc.service.CongChuc2NhomThuTucLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class CanBo2NhomThuTucPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CanBo2NhomThuTucPortlet extends CanBoPortlet {
	
	/**
	 * This is server DanhSachCanBo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws SystemException
	 */
	public void serveDSCanBo(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		List<CongChuc> list = CongChucLocalServiceUtil.findByCoQuanQuanLyID(
			ParamUtil.getLong(request, CB2NTTFields.coQuanId)
		);
		JSONArray dsCanBoJSON = JSONFactoryUtil.createJSONArray();
		for (CongChuc item : list) {
			dsCanBoJSON.put(
				JSONFactoryUtil.createJSONObject()
				.put(CB2NTTFields.id, item.getId())
				.put(CB2NTTFields.ten, item.getHoVaTen())
			);
		}
		ajaxResponse.send(CB2NTTFields.dsCanBo, dsCanBoJSON);
	}
	
	
	/**
	 * This is  function server DanhSach NhomThuTuc  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse   
	 * @throws SystemException
	 */
	public void serveDSNhomThuTucTheoCanBo(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		List<CongChuc2NhomThuTuc> dsCauHinh = 
			CongChuc2NhomThuTucLocalServiceUtil.findByCongChuc(
				ParamUtil.getLong(request, CB2NTTFields.canBoId)
			);
		
		JSONObject dsCauHinhEditCongDan = JSONFactoryUtil.createJSONObject();
		JSONArray dsNhomThuTucDaChonId = JSONFactoryUtil.createJSONArray();
		for (CongChuc2NhomThuTuc item : dsCauHinh) {
			dsNhomThuTucDaChonId.put(item.getNhomThuTucId());
			dsCauHinhEditCongDan.put(("i" + item.getNhomThuTucId()), (item.getDuocPhepEditCongDan() == 1));
		}
		
		ajaxResponse.send(CB2NTTFields.dsCauHinhEditCongDan, dsCauHinhEditCongDan);
		ajaxResponse.send(CB2NTTFields.dsNhomThuTucDaChonId, dsNhomThuTucDaChonId);
	}
	
	/**
	 * This is  function serveDSNhomThuTucTheoCoQuan  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse   
	 * @throws SystemException
	 */
	public void serveDSNhomThuTucTheoCoQuan(ResourceRequest request, AjaxResponse ajaxResponse) throws SystemException {
		List<NhomThuTucHanhChinh> list = 
			NhomThuTucHanhChinhLocalServiceUtil.getDSNhomThuTucHanhChinhByCoQuan(
				ParamUtil.getLong(request, CB2NTTFields.coQuanId)
			);
		JSONArray out = JSONFactoryUtil.createJSONArray();
		for (NhomThuTucHanhChinh item : list) {
			out.put(
				JSONFactoryUtil.createJSONObject()
				.put(CB2NTTFields.id, item.getId())
				.put(CB2NTTFields.ten, item.getTen())
			);
		}
		ajaxResponse.send(CB2NTTFields.dsNhomThuTuc, out);
	}

	/**
	 * This is  function server processLuuCauHinh  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse   
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void processLuuCauHinh(ResourceRequest request, AjaxResponse ajaxResponse) throws PortalException, SystemException {
		long[] canBoIds = ParamUtil.getLongValues(request, CB2NTTFields.canBoId); 
		long[] nhomThuTucIds = ParamUtil.getLongValues(request, CB2NTTFields.nhomThuTucId);
		long[] duocPhepEditCongDans = ParamUtil.getLongValues(request, CB2NTTFields.duocPhepEditCongDan);
		CongChuc2NhomThuTuc item = null;
		String email = PortalUtil.getUser(request).getEmailAddress();
		Date now = DateTimeUtil.getDateTimeNow();
		for (long canBoId : canBoIds) {
			CongChuc2NhomThuTucLocalServiceUtil.deleteByCongChuc(canBoId);
			for (long nhomThuTucId : nhomThuTucIds) {
				item = new CongChuc2NhomThuTucClp();
				item.setId(CounterLocalServiceUtil.increment(CongChuc2NhomThuTucModelImpl.TABLE_NAME));
				item.setNgayTao(now);
				item.setNgaySua(now);
				item.setNguoiTao(email);
				item.setDaXoa(Constants.ACTIVE);
				item.setCongChucId(canBoId);
				item.setNhomThuTucId(nhomThuTucId);
				item.setDuocPhepEditCongDan(Helper.inArray(duocPhepEditCongDans, nhomThuTucId) ? 1 : 0);
				CongChuc2NhomThuTucLocalServiceUtil.addCongChuc2NhomThuTuc(item);
			}
		}
		
		ajaxResponse.sendSuccessMessage(BusinessMessagerUtil.get(request, "message.luu_cau_hinh_thanh_cong"));
	}
}
