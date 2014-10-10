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

package org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.business;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import org.oep.cmon.dao.dn.model.impl.DoanhNghiepImpl;
import org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.HoCaTheFormModel;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * This is class DoanhNghiepBusiness
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class DoanhNghiepBusiness {

	/**
	 * This is  function get count DoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchInputText
	 * @param idLoaiDoiTuong
	 * @param daXoa
	 * @throws Exception
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	public static int countDoanhNghiep(
			String searchInputText,long idLoaiDoiTuong, int daXoa) throws Exception {
		List<DoanhNghiep> listDoanhNghiep = new ArrayList<DoanhNghiep>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				DoanhNghiepImpl.class, PortalClassLoaderUtil.getClassLoader());
		if (!searchInputText.equals("")) {
			Criterion creterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + searchInputText + StringPool.PERCENT);
			creterion = RestrictionsFactoryUtil.or(
					creterion,
					RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT
							+ searchInputText + StringPool.PERCENT));
//			creterion = RestrictionsFactoryUtil.or(
//					creterion,
//					RestrictionsFactoryUtil.ilike("masothue", StringPool.PERCENT
//							+ searchInputText + StringPool.PERCENT));
			query.add(creterion);
		}
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(
				daXoa));
		query.add(PropertyFactoryUtil.forName("loaiDoiTuongId").eq(
				idLoaiDoiTuong));
		listDoanhNghiep = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return listDoanhNghiep.size();
	}
	
	/**
	 * This is  function search DoanhNghiep
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchInputText
	 * @param idLoaiDoiTuong
	 * @param daXoa
	 * @param start
	 * @param end
	 * @throws Exception
	 * @return List<DoanhNghiep>
	 */
	@SuppressWarnings("unchecked")
	public static List<DoanhNghiep> searchDoanhNghiep(
			String searchInputText,long idLoaiDoiTuong, int daXoa,int start,int end) throws Exception {
		List<DoanhNghiep> listDoanhNghiep = new ArrayList<DoanhNghiep>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				DoanhNghiepImpl.class, PortalClassLoaderUtil.getClassLoader());
		if (!searchInputText.equals("")) {
			Criterion creterion = RestrictionsFactoryUtil.ilike("ten",
					StringPool.PERCENT + searchInputText + StringPool.PERCENT);
			creterion = RestrictionsFactoryUtil.or(
					creterion,
					RestrictionsFactoryUtil.ilike("ma", StringPool.PERCENT
							+ searchInputText + StringPool.PERCENT));
//			creterion = RestrictionsFactoryUtil.or(
//					creterion,
//					RestrictionsFactoryUtil.ilike("masothue", StringPool.PERCENT
//							+ searchInputText + StringPool.PERCENT));
			query.add(creterion);
		}
		//query.add(PropertyFactoryUtil.forName("abc").isNull());
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(
				daXoa));
		query.add(PropertyFactoryUtil.forName("loaiDoiTuongId").eq(
				idLoaiDoiTuong));
		query.addOrder(OrderFactoryUtil.asc("ten"));
		listDoanhNghiep = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query,
				start, end);
		return listDoanhNghiep;
	}
	
	/**
	 * This is  function get HoCaTheModel from request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param mode
	 * @throws SystemException
	 */
	public static HoCaTheFormModel getHoCaTheModelFromRequest(ActionRequest request, int mode)
			throws SystemException {
		HoCaTheFormModel model=new HoCaTheFormModel();
		
		model.setEmailDangNhap(ParamUtil.getString(request, "emailDN"));
		model.setHoTenNDD(ParamUtil.getString(request, "hoTenNDD"));
		
		model.setNgaySinhNDD(ParamUtil.getString(request, "ngaySinhNDD"));
		
		
		model.setGioiTinhNDD(ParamUtil.getString(request, "gioiTinhNDD"));
		
		model.setQuocTichNDD(ParamUtil.getString(request, "quocTichNDD"));
		
		model.setDanTocNDD(ParamUtil.getString(request, "danTocNDD"));
		
		model.setSoCMNDNDD(ParamUtil.getString(request, "soCMNDNDD"));		
		
		model.setNgayCapCMNDNDD(ParamUtil.getString(request, "ngayCapCMNDNDD"));
		
		model.setNoiCapCMNDNDD(ParamUtil.getString(request, "noiCapCMNDNDD"));
		
		//Thuong tru
		model.setTinhTTNDD(ParamUtil.getString(request, "tinhTTNDD"));
		
		model.setHuyenTTNDD(ParamUtil.getString(request, "huyenTTNDD"));
		
		model.setXaTTNDD(ParamUtil.getString(request, "xaTTNDD"));
		
		model.setMoTaTTNDD(ParamUtil.getString(request, "moTaTTNDD"));
		
		//Hien tai
		model.setTinhHTNDD(ParamUtil.getString(request, "tinhHTNDD"));
		
		model.setHuyenHTNDD(ParamUtil.getString(request, "huyenHTNDD"));
		
		model.setXaHTNDD(ParamUtil.getString(request, "xaHTNDD"));
		
		model.setMoTaHTNDD(ParamUtil.getString(request, "moTaHTNDD"));
		
		//dien thoai
		model.setdTNDD(ParamUtil.getString(request, "dienThoaiNDD"));
		model.setFaxNDD(ParamUtil.getString(request, "faxNDD"));
		model.setEmailTNDD(ParamUtil.getString(request, "emailNDD"));
		model.setWebNDD(ParamUtil.getString(request, "websiteNDD"));
		
		//Thong tin HCT
		model.setTenHCT(ParamUtil.getString(request, "tenHoCaThe"));
		model.setMaGPHCT(ParamUtil.getString(request, "maGiayPhep"));
		//Dia chi kinh doanh
		model.setTinhHCT(ParamUtil.getString(request, "tinhId"));
		model.setHuyenHCT(ParamUtil.getString(request, "huyenId"));
		model.setXaHCT(ParamUtil.getString(request, "xaId"));
		model.setChiTietDCHCT(ParamUtil.getString(request, "chiTietDiaDiem"));
		
		model.setMaThueHCT(ParamUtil.getString(request, "maSoThue"));
		model.setNgayDKHCT(ParamUtil.getString(request, "ngayDangKy"));
		model.setVonKDHCT(ParamUtil.getString(request, "vonKinhDoanh"));

		//dien thoai HCT
		model.setdTHCT(ParamUtil.getString(request, "dienThoai"));
		model.setFaxHCT(ParamUtil.getString(request, "fax"));
		model.setEmailHCT(ParamUtil.getString(request, "email"));
		model.setWebHCT(ParamUtil.getString(request, "website"));
		
		model.setMoTaNganhNghe(ParamUtil.getString(request, "moTaNgheNghiep"));

		String [] arr=ParamUtil.getParameterValues(request,"nganhNgheDuocChon");	
		
		model.setNganhNgheDuocChon(arr);
		
		String check = ParamUtil.getString(request, "loaiHoKinhDoanh");
		if("nhomTapThe".equals(check) ){
			model.setCheck(true);
		}else
			model.setCheck(false);
		
		String[] stt = ParamUtil.getParameterValues(request,"stt");
		String[] idTV = ParamUtil.getParameterValues(request,"idTV");
		String[] tenTV = ParamUtil.getParameterValues(request,"tenTV");
		String[] cmndTV = ParamUtil.getParameterValues(request,"cmndTV");
		String[] diaChiTV = ParamUtil.getParameterValues(request,"diaChiTV");
		String[] giaTriTV = ParamUtil.getParameterValues(request,"giaTriTV");
		String[] tyLeTV = ParamUtil.getParameterValues(request,"tyLeTV");
				
		if(stt.length > 0){
			String[][] result = new String[stt.length ][6]; 
	        for(int i =0; i<stt.length ;i++){
	        	
	        	result[i][0]=idTV[i];
	            result[i][1]=tenTV[i];
	            result[i][2]=cmndTV[i];
	            result[i][3]=diaChiTV[i];
	            result[i][4]=giaTriTV[i];
	            result[i][5]=tyLeTV[i];
	        }
	        model.setDsThanhVien(result);
		}
		
		model.setMode(mode);
		return model;
	}
}
