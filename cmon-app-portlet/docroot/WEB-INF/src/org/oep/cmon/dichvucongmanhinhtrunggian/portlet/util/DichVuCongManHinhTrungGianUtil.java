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

package org.oep.cmon.dichvucongmanhinhtrunggian.portlet.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;
import org.oep.cmon.portlet.menu.util.MenuConstraint;
import org.oep.cmon.util.ComUtils;
import org.oep.cmon.util.EgovUtil;
import org.oep.cmon.util.UengineUtil;
import org.oep.egovcore.util.Helper;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class DichVuCongManHinhTrungGianUtil {
	// check input param
	public static String validInputAndInvokeMethod(String layoutId,
			String idUser, String type, String configParam, PortletRequest request) throws Exception {
	
		String result = "error";
		String[] arrConfigParam = configParam.split("&");
		if (arrConfigParam.length == 4 || 
				arrConfigParam.length == 2 ||  
				arrConfigParam.length == 3) {
			
			String clazz = arrConfigParam[0];
			String method = type + arrConfigParam[1];
			// add param iduser
			String strParamType = "";
			String strParam = "";
			
			if (arrConfigParam.length == 4) {
				strParamType = "java.lang.String;java.lang.String;"
						+ arrConfigParam[2];
				strParam = layoutId + ";" + idUser + ";" + arrConfigParam[3];
				
			// currently config for ho so lien thong
			} else if (arrConfigParam.length == 3) {
/*				strParamType = "java.lang.String;"
				+ arrConfigParam[2];
				
				strParam = idUser + ";" + request;*/
				return countLienThongHoSoTTHCCong(idUser, request);
				
			} else {
				strParamType = "java.lang.String;java.lang.String";
				strParam = layoutId + ";" + idUser;
			}

			
			String[] arrParamType = strParamType.split(";");
			Object[] arrParam = strParam.split(";");
			
			if (arrParamType.length == arrParam.length) {
				if (arrParamType.length != 0) {
					Class[] paramTypes = new Class[arrParamType.length];
					
					for (int i = 0; i < arrParamType.length; i++) {
						Class<?> paramClass = Class.forName(arrParamType[i]);
						Object o = paramClass.newInstance();
						paramTypes[i] = o.getClass();
					}
					
					result = invoke(clazz, method, paramTypes, arrParam);
					
				} else {
					arrParamType = null;
					arrParam = null;
				}
			}
		}
		return result;
	}

	// invoke mothod
	public static String invoke(String aClass, String aMethod,
			Class[] paramsType, Object[] args) throws Exception {
		Class clazz = Class.forName(aClass);
		Method method = clazz.getDeclaredMethod(aMethod, paramsType);
		Object obj = clazz.newInstance();
		return method.invoke(obj, args).toString();
	}

	// list ho so TTHC
	public static String listHoSoTTHCCong(String layoutId, String id_user,
			String status, String type, String yeuCauRut) throws Exception {
		String result = "";
		List<HoSoTTHCCong> listhoso = new ArrayList<HoSoTTHCCong>();
		CongChuc congchuc = EgovUtil.getCongChucDaDangNhap(Long
				.valueOf(id_user));
		if (congchuc != null) {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");
			Date date = now.getTime();
			String tungay = "01/01/" + dfyear.format(date);
			now.add(Calendar.DATE, 1);
			date = now.getTime();
			String denngay = df.format(date);
			String tthcKeys = null;
			List<ThongTinThuTuc> dsThuTuc2CanBo = HoSoBusinessUtil.getDSThuTuc2CanBo(congchuc); 
			tthcKeys = ComUtils.getListTTHCID(dsThuTuc2CanBo);
			
			if (type.equals("1")) {
				// Can bo mot cua
				listhoso = HoSoTTHCCongLocalServiceUtil
						.findByMutilStatusAndTTHC(tthcKeys, null, congchuc.getId(), null,
								congchuc.getCoQuanQuanLyId(), status,
								Integer.valueOf(yeuCauRut), tungay, denngay, 0,
								5);
			} else {
				List<String> lsMail = new ArrayList<String>();
				
				// Can bo xu ly nhan vien
				if (type.equals("2")) {
					lsMail.add(TaiKhoanNguoiDungLocalServiceUtil
							.getTaiKhoanNguoiDung(
									congchuc.getTaiKhoanNguoiDungId())
							.getEmail());
					// Can bo xu ly lanh dao
				} else if (type.equals("3")) {
					List<CongChuc> ccAll = CongChucLocalServiceUtil
							.findByCoQuanQuanLyID(congchuc.getCoQuanQuanLyId());
					if (ccAll != null && ccAll.size() > 0) {
						for (int i = 0; i < ccAll.size(); i++) {
							CongChuc item = ccAll.get(i);
							if (item.getTaiKhoanNguoiDungId() != null) {
								TaiKhoanNguoiDung accAllMember = null;
								accAllMember = TaiKhoanNguoiDungLocalServiceUtil
										.fetchTaiKhoanNguoiDung(item
												.getTaiKhoanNguoiDungId());
								if (accAllMember != null
										&& (accAllMember.getEmail() != null || !""
												.equals(accAllMember.getEmail()))) {
									lsMail.add(accAllMember.getEmail());

								}
							}
						}
					}
				}
				List<String> lsMaHoSo = UengineUtil.getAllMaHoSoByCanBo(
						lsMail.toArray(new String[lsMail.size()]), tungay,
						denngay, Helper.parseArrayInt(status));
				listhoso = HoSoTTHCCongLocalServiceUtil
						.searchAllHSDangXuLyMutilStatusAndTTHC(null, tthcKeys,
								status, lsMaHoSo, tungay, denngay, 0, 5);
			}
			result = showListHoSo(layoutId, listhoso);
		}
		return result;
	}

	// count ho so TTHC cong
	public static String countHoSoTTHCCong(String url, String id_user,
			String status, String type, String yeuCauRut) throws Exception {
		int sohoso = 0;
		CongChuc congchuc = EgovUtil.getCongChucDaDangNhap(Long
				.valueOf(id_user));

		//can bo tiep nhan
		if (congchuc != null) {
			List<ThongTinThuTuc> dsThuTuc2CanBo = HoSoBusinessUtil.getDSThuTuc2CanBo(congchuc); 
			String tthcKeys = ComUtils.getListTTHCID(dsThuTuc2CanBo);
			
			Calendar now = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");
			Date date = now.getTime();
			String tungay = "01/01/" + dfyear.format(date);
			now.add(Calendar.DATE, 1);
			date = now.getTime();
			String denngay = df.format(date);
			if (type.equals("1")) {
				// Can bo mot cua
				sohoso = HoSoTTHCCongLocalServiceUtil
						.countByMutilStatusAndTTHC(tthcKeys, null, congchuc.getId(),
								null, congchuc.getCoQuanQuanLyId(), status,
								Integer.valueOf(yeuCauRut), tungay, denngay, 0,
								5);
			} else {
				List<String> lsMail = new ArrayList<String>();

				// Can bo xu ly nhan vien
				if (type.equals("2")) {
					lsMail.add(TaiKhoanNguoiDungLocalServiceUtil
							.getTaiKhoanNguoiDung(
									congchuc.getTaiKhoanNguoiDungId())
							.getEmail());
				// Can bo xu ly lanh dao
				} else if (type.equals("3")) {
					List<CongChuc> ccAll = CongChucLocalServiceUtil
							.findByCoQuanQuanLyID(congchuc.getCoQuanQuanLyId());
					if (ccAll != null && ccAll.size() > 0) {
						for (int i = 0; i < ccAll.size(); i++) {
							CongChuc item = ccAll.get(i);
							if (item.getTaiKhoanNguoiDungId() != null) {
								TaiKhoanNguoiDung accAllMember = null;
								accAllMember = TaiKhoanNguoiDungLocalServiceUtil
										.fetchTaiKhoanNguoiDung(item
												.getTaiKhoanNguoiDungId());
								if (accAllMember != null
										&& (accAllMember.getEmail() != null || !""
												.equals(accAllMember.getEmail()))) {
									lsMail.add(accAllMember.getEmail());

								}
							}
						}
					}
				}
				List<String> lsMaHoSo = UengineUtil.getAllMaHoSoByCanBo(
						lsMail.toArray(new String[lsMail.size()]), tungay,
						denngay, Helper.parseArrayInt(status));
				sohoso = HoSoTTHCCongLocalServiceUtil
						.countAllHSDangXuLyMutilStatusAndTTHC(null, tthcKeys,
								status, lsMaHoSo, tungay, denngay, 0, 5);
			}
		}
		return String.valueOf(sohoso);
	}

	public static String showListHoSo(String layoutId,
			List<HoSoTTHCCong> listHoSo) throws PortalException,
			SystemException {
		Layout layout = LayoutLocalServiceUtil
				.getLayout(Long.valueOf(layoutId));
		String url = MenuConstraint.getURL(layout);
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String result = "<div id='side-tab"
				+ layoutId
				+ "' class='side-content'>"
				+ "<div class='wd-heading'>"
				+ "<h3 class='wd-title'>"
				+ layout.getNameCurrentValue()
				+ "</h3>"
				+ "<a href='"
				+ url
				+ "' class='wd-btn'>Xem t&#x1EA5;t c&#x1EA3;<i class='icon-ib ico_arrow-right'></i></a></div>"
				+ "<table class='wd-table'>"
				+ "<thead><tr><th>STT</th><th width='50%' class='tbl_dvc_header_thutuc'></th><th class='tbl_dvc_header_nguoinop'></th><th class='tbl_dvc_header_ngaynop'></th><th class='tbl_dvc_header_thaotac'></th></tr></thead>"
				+ "<tbody>";
		for (int i = 0; i < listHoSo.size(); i++) {
			result += "<tr>"
					+ "<td>"
					+ (i + 1)
					+ "</td>"
					+ "<td class='text-left'><a href='"
					+ url
					+ "' class='wd-label-color-blue'>"
					+ ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(
							listHoSo.get(i).getThuTucHanhChinhId()).getTen()
					+ "</a></td>" + "<td>"
					+ listHoSo.get(i).getHoTenNguoiNopHoSo() + "</td>" + "<td>"
					+ sf.format(listHoSo.get(i).getNgayNopHoSo()) + "</td>"
					+ "<td><a href='" + url
					+ "' class='icon-ib ico_icon-edit'></a>" + "<a href='"
					+ url + "' class='icon-ib ico_icon-delete'></a></td>"
					+ "</tr>";
		}
		result += "</tbody></table></div>";
		return result;
	}

	public static boolean isDisplayInDashboard(Layout layout)
			throws SystemException {
		boolean isDisplay = false;
		String result = getArgsOfLayout(layout.getPlid(), "isDisplay");
		if (result.equals("true")) {
			isDisplay = true;
		}
		if (layout.getChildren() != null && layout.getChildren().size() > 0) {
			// check if permission child view . view parent
			List<Layout> lList = layout.getAllChildren();
			for (Layout child : lList) {
				result = getArgsOfLayout(child.getPlid(), "isDisplay");
				if (result.equals("true")) {
					isDisplay = true;
					break;
				}
			}
		}
		return isDisplay;
	}

	// get custom param of layout
	public static String getArgsOfLayout(long idLayout, String paramType)
			throws SystemException {
		String result = "";
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				ExpandoValue.class, PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName("classPK").eq(idLayout));
		query.add(PropertyFactoryUtil.forName("columnId").in(
				DynamicQueryFactoryUtil
						.forClass(ExpandoColumn.class,
								PortalClassLoaderUtil.getClassLoader())
						.add(PropertyFactoryUtil.forName("name").like(
								"%" + paramType + "%"))
						.setProjection(
								ProjectionFactoryUtil.property("columnId"))));
		List<ExpandoValue> listArgs = (List<ExpandoValue>) ExpandoValueLocalServiceUtil
				.dynamicQuery(query);
		if (listArgs != null && listArgs.size() > 0) {
			result = listArgs.get(0).getData();
		}
		return result;
	}
	

	public static String countLienThongHoSoTTHCCong(String id_user, PortletRequest request) throws Exception {
		long[] thuTucNhanIds;
		CongChuc canBoNoiNhan = EgovUtil.getCongChucDaDangNhap(Long
				.valueOf(id_user));
		
		List<ThongTinThuTuc> thuTucs = HSLTBusinessUtil.getDSThuTucLienThongNoiNhan2CanBo(canBoNoiNhan);
		int size = thuTucs.size();
		thuTucNhanIds = new long[size];
		for (int i = 0; i < size; ++ i) {
			thuTucNhanIds[i] = thuTucs.get(i).getThuTucId();
		}
		
		QueryResult<HoSoLienThong> queryResult =
			HoSoLienThongLocalServiceUtil.searchHoSoNoiNhan(request, canBoNoiNhan, thuTucNhanIds);
		
		long count = queryResult.getResultCount();
		
		return String.valueOf(count);
	}
}
