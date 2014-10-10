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


package org.oep.cmon.dao.cd.service.impl;

import java.sql.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.cd.model.impl.CongDanImpl;
import org.oep.cmon.dao.cd.service.base.CongDanLocalServiceBaseImpl;

import org.oep.cmon.dao.cd.NoSuchCongDanException;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * The implementation of the cong dan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.cd.service.CongDanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BinhNT
 * @see org.oep.cmon.dao.cd.service.base.CongDanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil
 */
/**
*
* CongDanLocalServiceImpl class
*   
* This class is used to get CongDan information 
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
@SuppressWarnings("unchecked")
public class CongDanLocalServiceImpl extends CongDanLocalServiceBaseImpl {
	
	/**
	  * This is fucntion get CongDan by liferayUserId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long : Value of liferayUserId
	  * @return CongDan
	  */
	public CongDan getCongDanByLiferayUserId(Long liferayUserId){
		return congDanFinder.getCongDanByLiferayUserId(liferayUserId);
	}

	/**
	  * This is fucntion search CongDan by request 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest : request
	  * @return List<CongDan>
	  */
	public QueryResult<org.oep.cmon.dao.beans.congdan.CongDan> search(PortletRequest request) throws Exception {
		return congDanFinder.search(request);
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil} to access the cong dan local service.
	 */
	
	public static final String FIELD_TAIKHOANNGUOIDUNGID = "taiKhoanNguoiDungId";
	public static final String FIELD_NGAYSINH = "ngaySinh";
	public static final String FIELD_TINHTHUONGTRUID = "diaChiThuongTruTinhId";
	public static final String FIELD_DAXOA = "daXoa";
	
	/**
	  * This is fucntion find CongDan by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return List<CongDan>
	  */
	public CongDan findByMa(String ma){
		try {
			return congDanPersistence.fetchByMa(ma);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}

	/**
	  * This is fucntion find CongDan by taiKhoanNguoiDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of taiKhoanNguoiDungId
	  * @return CongDan
	  */
	@Override
	public CongDan findByTaiKhoanNguoiDungId(long taiKhoanNguoiDungId)
			{
		try{
		
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				CongDanImpl.class,
				PortalClassLoaderUtil.getClassLoader());
			query.add(PropertyFactoryUtil.forName(FIELD_TAIKHOANNGUOIDUNGID).eq(taiKhoanNguoiDungId));
			query.add(PropertyFactoryUtil.forName(FIELD_DAXOA).eq(Constants.ACTIVE));
			
			List<CongDan> list = (List<CongDan>) CongDanLocalServiceUtil
				.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	/**
	  * This is fucntion find CongDan by soCmnd 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of soCmnd
	  * @return List<CongDan>
	  */
	public List<CongDan> findByCMND(String soCmnd) throws SystemException
	{
		return congDanPersistence.findBySoCmnd(soCmnd);
		
	}
	/**
	  * This is fucntion find CongDan by email 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of email
	  * @return List<CongDan>
	  */
	public List<CongDan> findByEmail(String email) throws SystemException
	{
		return congDanPersistence.findByEmail(email);
		
	}
	/**
	  * This is fucntion find CongDan by soCmnd 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of soCmnd
	  * @return List<CongDan>
	  */
	public List<CongDan> findBySoCmnd(String soCmnd) throws SystemException
	{
		return congDanPersistence.findBySoCmnd(soCmnd);
		
	}
	/**
	  * This is fucntion save CongDan infomation
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongDan : CongDan object
	  * @return CongDan
	  */
	public CongDan  saveCongDan(CongDan congDan) throws SystemException
	{
		CongDan cdvar;
		try {
			cdvar = congDanPersistence.create(counterLocalService.increment(CongDan.class.toString()));
			 } catch (SystemException e) {
			  e.printStackTrace();
			  return cdvar = null;
			 }
			
		
		cdvar.setDanTocId(congDan.getDanTocId());
		cdvar.setDiaChiHienNay(congDan.getDiaChiHienNay());
		cdvar.setDiaChiHienNayHuyenId(congDan.getDiaChiHienNayHuyenId());
		cdvar.setDiaChiHienNayTinhId(congDan.getDiaChiHienNayTinhId());
		cdvar.setDiaChiHienNayXaId(congDan.getDiaChiHienNayXaId());
		cdvar.setDiaChiThuongTru(congDan.getDiaChiThuongTru());
		cdvar.setDienThoaiCoDinh(congDan.getDienThoaiCoDinh());
		cdvar.setDienThoaiDiDong(congDan.getDienThoaiDiDong());
		cdvar.setGhiChuCmnd(congDan.getGhiChuCmnd());
		cdvar.setGhiChuHoChieu(congDan.getGhiChuHoChieu());
		cdvar.setGioiTinh(congDan.getGioiTinh());
		cdvar.setHoTenCha(congDan.getHoTenCha());
		cdvar.setHoTenMe(congDan.getHoTenMe());
		cdvar.setHoTenVoHoacChong(congDan.getHoTenVoHoacChong());
		cdvar.setLaChuHo(congDan.getLaChuHo());
		cdvar.setMa(congDan.getMa());
		cdvar.setMaSoThueCaNhan(congDan.getMaSoThueCaNhan());
		cdvar.setNgayCapCmnd(congDan.getNgayCapCmnd());
		cdvar.setNgayCapHoChieu(congDan.getNgayCapHoChieu());
		cdvar.setNgayHetHanHoChieu(congDan.getNgayHetHanHoChieu());
		cdvar.setNgaySinh(congDan.getNgaySinh());
		
		cdvar.setTrinhDoHocVanId(congDan.getTrinhDoHocVanId());
		cdvar.setTrinhDoChuyenMonId(congDan.getTrinhDoChuyenMonId());
		cdvar.setTonGiaoId(congDan.getTonGiaoId());
		cdvar.setTaiKhoanNguoiDungId(congDan.getTaiKhoanNguoiDungId());
		cdvar.setSoDinhDanhMeId(congDan.getSoDinhDanhMeId());
		cdvar.setSoDinhDanhChaId(congDan.getSoDinhDanhChaId());
		cdvar.setSoBaoHiemYTe(congDan.getSoBaoHiemYTe());
		cdvar.setNgheNghiepId(congDan.getNgheNghiepId());
		cdvar.setSoHoKhau(congDan.getSoHoKhau());
		//cdvar.setTinhTrangHonNhan(congDan.getTinhTrangHonNhan());
		
		return congDanPersistence.update(cdvar, true);
		 
		
	}
	/**
	  * This is fucntion find ChucVu by email and soCmnd 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of email ; String soCmnd;
	  * @return CongDan
	  */
	public CongDan findByEmailAndCMND(String email, String soCmnd)
			throws SystemException, NoSuchCongDanException {
		
		return congDanPersistence.findByEmailAndCMND(email, soCmnd);
	}
	/**
	  * This is fucntion find CongDan by NgaySinh And CMND 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of soCmnd ;Date ngaySinh
	  * @return CongDan
	  */
	public CongDan findByNgaySinhAndCMND(Date ngaySinh, String soCmnd)
			throws SystemException, NoSuchCongDanException {
		
		return congDanPersistence.findByNgaySinhAndCMND(ngaySinh, soCmnd);
	}
	/**
	  * This is fucntion find CongDan by NgaySinh And SoCMND 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of soCmnd ;Date: ngaysinh
	  * @return CongDan
	  */
	public CongDan findByNgaySinhAndSoCMND(java.util.Date ngaySinh, String soCmnd)
			throws SystemException, NoSuchCongDanException {
		
		return congDanPersistence.findByNgaySinh(ngaySinh, soCmnd);
	}
	/**
	  * This is fucntion find CongDan by NgaySinh And TinhThuongTruId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of tinhThuongTruId ; Date : ngaysinh
	  * @return CongDan
	  */
	public CongDan findByNgaySinhAndTinhThuongTruId(java.util.Date ngaySinh, long tinhThuongTruId) throws SystemException {
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			CongDanImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_NGAYSINH).eq(ngaySinh));
		query.add(PropertyFactoryUtil.forName(FIELD_TINHTHUONGTRUID).eq(tinhThuongTruId));
		query.add(PropertyFactoryUtil.forName(FIELD_DAXOA).eq(Constants.ACTIVE));
		List<CongDan> list = (List<CongDan>) CongDanLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		return (!list.isEmpty()) ? list.get(0) : null;
	}
}