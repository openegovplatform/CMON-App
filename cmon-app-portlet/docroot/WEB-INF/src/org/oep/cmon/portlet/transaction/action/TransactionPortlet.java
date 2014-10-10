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

package org.oep.cmon.portlet.transaction.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.Constants;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.portlet.cmon.EgovPortlet;
import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.portlet.transaction.TransactionUtils;
import org.oep.cmon.portlet.transaction.util.TransactionValidator;
import org.oep.cmon.util.ComUtils;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToanClp;
import org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;
import vn.dtt.sharedservice.bpm.consumer.uengine.Exception_Exception;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrmsService;
import vn.dtt.sharedservice.bpm.consumer.uengine.WorkList;
import vn.dtt.sharedservice.cmon.consumer.officer.GiayToDinhKem;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class TransactionPortlet
 */

/**
*
* TransactionPortlet class
*   
* This class is used to get information 
* from database
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class TransactionPortlet extends EgovPortlet {
	
	/**
	  * This is fucntion getProcessingProcess
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request, ResourceResponse response
	  * @return void
	  */
	public void getProcessingProcess(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String profileCode = ParamUtil.getString(request, "profileCode");
		IBrms service = new IBrmsService().getIBrmsPort();
		List<WorkList> workLists;
		try {
			workLists = service.getWorkListByMaHoSo(profileCode);
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			throw new PortletException(e);
		}
		JSONArray workListJSONList = JSONFactoryUtil.createJSONArray();
		for (WorkList workList : workLists) {
			workListJSONList.put(JSONFactoryUtil
				.createJSONObject()
				.put("endDate", workList.getEndDate())
				.put("endPoint", workList.getEndpoint())
				.put("info", workList.getInfo())
				.put("instId", workList.getInstid())
				.put("taskId", workList.getTaskid())
				.put("startDate", workList.getStartDate())
				.put("taskId", workList.getTaskid())
				.put("title", workList.getTitle())
				.put("trcTag", workList.getTrctag())
				.put("canBoXuLy",
						TransactionUtils.getNguoiDungbyEmail(workList
								.getEndpoint()))
				.put("phongBanThucHien",
						TransactionUtils.getPhongbanEmail(workList
								.getEndpoint())));
		}

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("workLists", workListJSONList);
		HttpServletResponse servletResponse = PortalUtil
				.getHttpServletResponse(response);
		servletResponse.setContentType("application/json");
		servletResponse.setCharacterEncoding("UTF-8");
		servletResponse.getWriter().write(json.toString());
		servletResponse.getWriter().close();
	}
	
	/**
	  * This is fucntion huyHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest,	ActionResponse actionResponse
	  * @return void
	  */
	public void huyHoSo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
        YKienTraoDoi traoDoi = TransactionUtils.yKienTraoDoiFromRequest(actionRequest);
        ArrayList<String> errors = new ArrayList<String>();   
        if (TransactionValidator.validateYcHuyHoSo(traoDoi, errors)) {
            if (traoDoi.getId() > 0) {
                // Updating
            }
            else {
                // Adding

                try {
                	
					YKienTraoDoiLocalServiceUtil.addYkien_Traodoi(traoDoi);
					actionRequest.setAttribute("huy_success", "success");
                }
                catch (SystemException e) {
                    errors.add("failed-to-add");
                }
            }
        }
        else {
            for (String error : errors) {
                SessionErrors.add(actionRequest, error);
            }
        } 		
        actionRequest.setAttribute("reload-page", true);
        actionRequest.setAttribute("transactionId", ParamUtil.getString(actionRequest, "idPhanHoi"));
		actionRequest.setAttribute(TransactionUtils.PARAM_VIEW_TYPE, TransactionUtils.VIEW_TRANSACTION_DETAILS);
		actionRequest.setAttribute("transType", ParamUtil.getString(actionRequest, "transType"));
		actionRequest.setAttribute("currentTransPage", ParamUtil.getString(actionRequest, "currentTransPage"));
		actionRequest.setAttribute("transactionKeyword", ParamUtil.getString(actionRequest, "transactionKeyword"));
		actionRequest.setAttribute("CanBoXuLyHienThoiId", ParamUtil.getString(actionRequest, "CanBoXuLyHienThoiId"));
		actionRequest.setAttribute("status", ParamUtil.getString(actionRequest, "status"));
	}
	
	/**
	  * This is fucntion getPhanHoiDetails
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest,ActionResponse actionResponse
	  * @return void
	  */
	public void getPhanHoiDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
        String idPhanHoi = ParamUtil.getString(actionRequest, "idPhanHoi");
        ArrayList<String> errors = new ArrayList<String>();
        Long ykienTraodoiId = Long.parseLong(idPhanHoi);
        if (ykienTraodoiId > 0) {


            try {
                YKienTraoDoi fromDB =
                		YKienTraoDoiLocalServiceUtil.getYkienTraoDoi(ykienTraodoiId);

                if (fromDB != null) {

                    fromDB =   YKienTraoDoiLocalServiceUtil.updateStatus(ykienTraodoiId, 0);
            		HttpServletResponse httpResp = PortalUtil.getHttpServletResponse(actionResponse);
                    httpResp.setContentType("application/json");
				    JSONObject obj = JSONFactoryUtil.createJSONObject();
				    obj.put("tieuDe", fromDB.getTieuDe());
				    obj.put("noiDung", fromDB.getNoiDungYKien());
				    httpResp.getWriter().print(obj.toString());
                    httpResp.flushBuffer();
                }
            }
            catch (PortalException e) {
                errors.add("failed-to-update");
            }
            catch (SystemException e) {
                errors.add("failed-to-update");
            }
        }        
	}
	
	/**
	  * This is fucntion search
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest, ActionResponse actionResponse
	  * @return void
	  */
	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String keyword = ParamUtil.getString(actionRequest, "keyword");
		String type = ParamUtil.getString(actionRequest, "type");
		String hoSoTTHCCongId = ParamUtil.getString(actionRequest, "hoSoTTHCCongId");
		FormatUtil.setParams(actionRequest);
		actionRequest.getPortletSession().setAttribute("keyword", keyword);
		actionRequest.getPortletSession().setAttribute("hoSoTTHCCongId", hoSoTTHCCongId);
		actionRequest.getPortletSession().setAttribute("type", type);
		actionResponse.setRenderParameter("jspPage", "/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");
	}
	

	/**
	  * This is fucntion saveTraoDoiCanBo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest resourceRequest,ActionResponse httpReq
	  * @return void
	  */
	public void saveTraoDoiCanBo(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		ComUtils.saveTraoDoi(resourceRequest, httpReq);
	}	
		
	/**
	  * This is fucntion rutHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest resourceRequest,ActionResponse httpReq
	  * @return void
	  */
	public void rutHoSo(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		ComUtils.rutHoSo(resourceRequest, httpReq);
	}	
	
	/**
	  * This is fucntion delYKienTraoDoi
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest resourceRequest,ActionResponse httpReq
	  * @return void
	  */
	public void delYKienTraoDoi(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		long yKienTraoDoiId = ParamUtil.getLong(resourceRequest, "yKienTraoDoiId");
		long hoSoTTHCCongId = ParamUtil.getLong(resourceRequest, "hoSoTTHCCongId");
		String type = ParamUtil.getString(resourceRequest, "type");

		try {
			YKienTraoDoiLocalServiceUtil.deleteYKienTraoDoi(yKienTraoDoiId);
			resourceRequest.setAttribute("delete", "successed");
			
		} catch (Exception e) {
			resourceRequest.setAttribute("delete", "failed");
			e.printStackTrace();
		}
		
		
		httpReq.setRenderParameter("hoSoTTHCCongId",
				String.valueOf(hoSoTTHCCongId));
		httpReq.setRenderParameter("type", String.valueOf(type));
		httpReq.setRenderParameter("jspPage",
				"/html/cmon/ykientraodoi/danh_sach_y_kien.jsp");
		
	}
	/**
	  * This is fucntion render
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param RenderRequest request, RenderResponse response
	  * @return void
	  */
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		super.render(request, response);
	}
	
	/**
	  * This is fucntion doView
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param RenderRequest renderRequest,	RenderResponse renderResponse
	  * @return void
	  */
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String pagingYkXl = ParamUtil.getString(renderRequest, "pagingYkXl");
		if ("YES".equals(pagingYkXl)) {
			renderRequest.setAttribute("pagingYkXl", "YES");
			
		}
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	  * This is fucntion uploadPhieu
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest, ActionResponse actionResponse
	  * @return void
	  */
	public void uploadPhieu(ActionRequest actionRequest, ActionResponse actionResponse)  {
		try  {
			Long hoSoId = ParamUtil.getLong(actionRequest, "hoSoId");
			Long thongTinThanhToanId = ParamUtil.getLong(actionRequest, "thongtinthanhtoanid");
			String name =  ParamUtil.getString(actionRequest, "title");
			Long typePhi =  ParamUtil.getLong(actionRequest, "typePhi");
			HoSoTTHCCong hoSoTTHCC =   HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoId);
						
			// get binary data
			String contentType = actionRequest.getContentType();
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				byte dataBytes[] = FileUtil.getBytes(PortalUtil.getUploadPortletRequest(actionRequest).getFileAsStream("uploadphieu"));
				
				GiayToDinhKem resulUpload = WebserviceFactory.getOfficerService().upload(
						getMaUngDung(hoSoTTHCC.getThuTucHanhChinhId()), 1, null, PortalUtil.getUserId(actionRequest),
								name, "upload phieu thu phi, le phi", dataBytes, "png");
				
				if (thongTinThanhToanId > 0) {
					ThongTinThanhToan thongTinThanhToan = ThongTinThanhToanLocalServiceUtil.getThongTinThanhToan(thongTinThanhToanId);
					thongTinThanhToan.setNgaySua(new Date());
					thongTinThanhToan.setNoiLuuTruId(resulUpload.getNoiLuuTruId());
					
					ThongTinThanhToanLocalServiceUtil.updateThongTinThanhToan(thongTinThanhToan, true);
					
				} else {
					ThongTinThanhToan thongTinThanhToan = new ThongTinThanhToanClp();
					long ttttId = CounterLocalServiceUtil.increment(ThongTinThanhToan.class.getName());
					thongTinThanhToan.setId(ttttId);
					thongTinThanhToan.setHoSoTTHCCongId(hoSoId);
					thongTinThanhToan.setNgayTao(new Date());
					thongTinThanhToan.setTenNguoiNopTien(hoSoTTHCC.getHoTenNguoiNopHoSo());
					thongTinThanhToan.setNoiLuuTruId(resulUpload.getNoiLuuTruId());
					thongTinThanhToan.setNguoiTao(PortalUtil.getUser(actionRequest).getFullName());
					thongTinThanhToan.setLoaiPhi(typePhi);
					thongTinThanhToan.setLoaiThanhToan(2);
					
					ThongTinThanhToanLocalServiceUtil.addThongTinThanhToan(thongTinThanhToan);					
				}

				SessionMessages.add(actionRequest, "successUpdateTTTK");	
				actionResponse.setRenderParameter("hoSoId",  hoSoId.toString());
				actionResponse.setRenderParameter("title", name);
				actionResponse.setRenderParameter("typephi", typePhi.toString());
				actionResponse.setRenderParameter("parentUrl", ParamUtil.getString(actionRequest, "parentUrl"));
				actionResponse.setRenderParameter("jspPage", "/html/portlet/transaction/nopphi.jsp");
		    	} else {
		    		SessionErrors.add(actionRequest, "errorUpdateTTTK");
		    	}
			} catch (Exception e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "errorUpdateTTTK");
			}
	    }
	
	/**
	  * This is fucntion getMaUngDung
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId
	  * @return String
	  */
	private String getMaUngDung(long thuTucHanhChinhId) throws PortalException, SystemException  {
		ThuTucHanhChinh thuTucHanhChinh =  ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(thuTucHanhChinhId);
		
		if (thuTucHanhChinh != null ) {
			long nhomThuTucHanhChinhId = thuTucHanhChinh.getNhomThuTucHanhChinhId();
			NhomThuTucHanhChinh nhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.
								getNhomThuTucHanhChinh(nhomThuTucHanhChinhId);
			
			if (nhomThuTucHanhChinh != null) {
				long danhMucUngDungId = nhomThuTucHanhChinh.getDanhMucUngDungId();
				DanhMucUngDung danhMucUngDung =  DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(danhMucUngDungId);
				
				if (danhMucUngDung != null) {
					return danhMucUngDung.getMa();
				}
			}
		}
		return  null;
	}
	
	/**
	  * This is fucntion boSungHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest resourceRequest, ActionResponse httpReq
	  * @return void
	  */
	public void boSungHoSo(ActionRequest resourceRequest, ActionResponse httpReq)
			throws NumberFormatException, Exception {

		long hoSoTTHCCongId = ConvertUtil.convertToLong(ParamUtil.getString(
				resourceRequest, "hoSoTTHCCongId"));

		boSungHoSoSaveToDB(resourceRequest, httpReq);

		HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil
				.fetchHoSoTTHCCong(hoSoTTHCCongId);
		hoSoTTHCCong
				.setTrangThaiHoSo(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG);
		hoSoTTHCCong.setNgaySua(new Date());
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);

		httpReq.setRenderParameter("id", String.valueOf(hoSoTTHCCongId));
		httpReq.setRenderParameter("jspPage",
				"/html/portlet/transaction/viewTransactionDetails.jsp");
	}
	
	/**
	  * This is fucntion boSungHoSoSaveToDB
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest,	ActionResponse actionResponse
	  * @return void
	  */
	public void boSungHoSoSaveToDB(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			long hoSoTTHCCongId = ConvertUtil.convertToLong(ParamUtil
					.getString(actionRequest, "hoSoTTHCCongId"));
			String yKien = ParamUtil.getString(uploadRequest, "yKien1");
			String filename = uploadRequest.getFileName("vanbanbosung");
			HoSoTTHCCong hoSoTTHCC = HoSoTTHCCongLocalServiceUtil
					.getHoSoTTHCCong(hoSoTTHCCongId);
			// get binary data
			String contentType = actionRequest.getContentType();
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				byte dataBytes[] = FileUtil.getBytes(uploadRequest
						.getFileAsStream("vanbanbosung"));

				GiayToDinhKem resulUpload = WebserviceFactory
						.getOfficerService().upload(
								getMaUngDung(hoSoTTHCC.getThuTucHanhChinhId()),
								1, null, PortalUtil.getUserId(uploadRequest),
								filename, "upload van ban yeu cau bo sung",
								dataBytes, filename);

				
				YKienTraoDoi yKienTraoDoi = new YKienTraoDoiClp();
				yKienTraoDoi
						.setId(CounterLocalServiceUtil
								.increment("org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"));
				yKienTraoDoi.setHoSoTTHCCongId(hoSoTTHCCongId);
				yKienTraoDoi.setTieuDe("Yeu cau bo sung");
				yKienTraoDoi.setNoiDungYKien(yKien);
				yKienTraoDoi.setThoiGianGuiYKien(new Date());
				yKienTraoDoi.setNoiLuuTruId(resulUpload.getNoiLuuTruId());
				yKienTraoDoi.setLoai(3);
				yKienTraoDoi.setNguoiGuiId(hoSoTTHCC.getCongDanNopId());
				yKienTraoDoi.setNguoiNhanId(hoSoTTHCC.getCongDanNopId());
				yKienTraoDoi.setChaiId(null);
				yKienTraoDoi.setTrangThai(1);
				YKienTraoDoiLocalServiceUtil.addYKienTraoDoi(yKienTraoDoi);
				// response data

			} else {
				SessionErrors.add(actionRequest, "errorUpdateTTTK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorUpdateTTTK");
		}
	}
	
}
