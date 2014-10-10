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


package org.oep.cmon.dao.hosohcc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSoImpl;
import org.oep.cmon.dao.hosohcc.model.impl.FileDinhKemImpl;
import org.oep.cmon.dao.hosohcc.service.base.FileDinhKemLocalServiceBaseImpl;
import org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem;
import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.persistence.FileDinhKemFinderUtil;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;


/**
 * The implementation of the file dinh kem local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungVQ
 * @see org.oep.cmon.dao.hosohcc.service.base.FileDinhKemLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil
 */

/**
*
* FileDinhKemLocalServiceImpl class
*   
* This class is used to get FileDinhKem information 
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
public class FileDinhKemLocalServiceImpl extends FileDinhKemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil} to access the file dinh kem local service.
	 */
	
	public static final String FIELD_XOA = "xoa";
	public static final String FIELD_HOSOTTHCCONGID = "hoSoTTHCCongId";
	public static final String FIELD_NOILUUTRUTAILIEUID = "noiLuuTruTaiLieuId";
	public static final String FIELD_THUTUC2GIAYTOID = "thuTuc2GiayToId";
	public static final String FIELD_DANHMUCGIAYTOID = "danhMucGiayToId";
	public static final String FIELD_NGAYUPLOAD = "ngayUpload";
	
	
	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId, giaiDoan request
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int giaiDoan
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(long hoSoTTHCCongId, int giaiDoan) throws SystemException {
		return FileDinhKemFinderUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId, giaiDoan);
	}
	
	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId, giaiDoan response
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int giaiDoan
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(long hoSoTTHCCongId, int giaiDoan) throws SystemException {
		return FileDinhKemFinderUtil.findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(hoSoTTHCCongId, giaiDoan);
	}

	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongId(long hoSoTTHCCongId) throws SystemException {
		return FileDinhKemFinderUtil.findFileDinhKemByHoSoTTHCCongId(hoSoTTHCCongId);
	}
	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId, idThuTuc2GiayTo,idDanhMucGiayTo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId,long idThuTuc2GiayTo,long idDanhMucGiayTo
	  * @return FileDinhKem
	  */
	public FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(long hoSoTTHCCongId,long idThuTuc2GiayTo,long idDanhMucGiayTo) throws SystemException {
		return FileDinhKemFinderUtil.findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(hoSoTTHCCongId, idThuTuc2GiayTo,idDanhMucGiayTo);
	}
	
	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(long hoSoTTHCCongId) throws SystemException {
		return FileDinhKemFinderUtil.findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCongId);
	}
	
	/**
	  * This is fucntion find FileDinhKem-OnlineRequest by hoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(long hoSoTTHCCongId) throws SystemException {
		return FileDinhKemFinderUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCongId);
	}

	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findByHoSoTTHCCongId(long hoSoTTHCCongId) throws SystemException {
		return FileDinhKemFinderUtil.findByHoSoTTHCCongId(hoSoTTHCCongId);
	}
	
	/**
	  * This is fucntion find GiayToDinhKemHoSo by HoSoTTHCCong 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HoSoTTHCCong hoSo
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(HoSoTTHCCong hoSo) throws Exception {
		return fileDinhKemFinder.getDSGiayToKhiBoSungHoSo(hoSo);
	}
	
	/**
	  * This is fucntion get GiayToDinhKemHoSo by thuTucId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucId
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToKhiTiepNhanHoSo(long thuTucId) throws Exception {
		List<GiayToDinhKem> parentList =
			ThuTuc2GiayToLocalServiceUtil.getDSGiayToByThuTucVaGiaiDoan(thuTucId, Constants.GIAIDOAN_GIAYTO_DAUVAO);
		
		List<GiayToDinhKemHoSo> list = Collections.emptyList();
		
		if (!parentList.isEmpty()) {
			list = new ArrayList<GiayToDinhKemHoSo>();
			GiayToDinhKemHoSo item;
			for (GiayToDinhKem parent : parentList) {
				item = new GiayToDinhKemHoSoImpl();
				item.setThuTuc2GiayToId(parent.getThuTuc2GiayToId(false));
				item.setDanhMucGiayToId(parent.getDanhMucGiayToId(false));
				item.setTenGiayTo(parent.getTenGiayTo());
				item.setDinhDangChoPhep(parent.getDinhDangChoPhep());
				item.setGioiHanDungLuong(parent.getGioiHanDungLuong());
				list.add(item);
			}
		}
		
		return list;
	}

	/**
	  * This is fucntion get GiayToDinhKemHoSo by hoSoId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(long hoSoId) throws Exception {
		return fileDinhKemFinder.getDSGiayToPhienBanMoiNhatByHoSo(hoSoId);
	}

	/**
	  * This is fucntion get GiayToDinhKemHoSo by hoSoId, giaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId, int giaiDoan
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(long hoSoId, int giaiDoan) throws Exception {
		return fileDinhKemFinder.getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(hoSoId, giaiDoan);
	}

	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findByHoSoTTHCCongID(long hoSoTTHCCongId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			FileDinhKemImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoTTHCCongId));
		query.add(PropertyFactoryUtil.forName(FIELD_XOA).eq(Constants.ACTIVE));
		query.addOrder(OrderFactoryUtil.asc(FIELD_THUTUC2GIAYTOID));
		query.addOrder(OrderFactoryUtil.desc(FIELD_NGAYUPLOAD));
		List<FileDinhKem> list = (List<FileDinhKem>) FileDinhKemLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<FileDinhKem> out = new ArrayList<FileDinhKem>();
		
		// Lay phien ban moi nhat
		long thuTuc2GiayToId = 0L;
		for (FileDinhKem item : list) {
			if (item.getThuTuc2GiayToId() != thuTuc2GiayToId) {
				thuTuc2GiayToId = item.getThuTuc2GiayToId();
				out.add(item);
			}
		}
		
		return out;
	}

	/**
	  * This is fucntion get FileDinhKem by hoSoId, thuTuc2GiayToId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId, long thuTuc2GiayToId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> getDSGiayToByHoSoAndThuTuc2GiayTo(long hoSoId, long thuTuc2GiayToId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			FileDinhKemImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoId));
		query.add(PropertyFactoryUtil.forName(FIELD_THUTUC2GIAYTOID).eq(thuTuc2GiayToId));
		query.add(PropertyFactoryUtil.forName(FIELD_XOA).eq(Constants.ACTIVE));
		return (List<FileDinhKem>) FileDinhKemLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId, taiLieuChungThucId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, long taiLieuChungThucId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(long hoSoTTHCCongId, long taiLieuChungThucId) throws SystemException {
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			FileDinhKemImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoTTHCCongId));
		query.add(PropertyFactoryUtil.forName(FIELD_NOILUUTRUTAILIEUID).eq(taiLieuChungThucId));
		query.add(PropertyFactoryUtil.forName(FIELD_XOA).eq(Constants.ACTIVE));
		return (List<FileDinhKem>) FileDinhKemLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
//		return fileDinhKemPersistence.findByFindByHoSoTTHCCongIdAndNoiLuuTruTaiLieuId(hoSoTTHCCongId, taiLieuChungThucId);
	}
	
	/**
	  * This is fucntion find FileDinhKem by hoSoTTHCCongId ,giaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int giaiDoan
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileUploadByHoSoTTHCCongIdAndGiaiDoan(long hoSoTTHCCongId, int giaiDoan) throws SystemException {
		return FileDinhKemFinderUtil.findFileUploadByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCongId, giaiDoan);
	}
	
	/**
	  * This is fucntion find FileDinhKem by thutuchanhchinhid, giaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thutuchanhchinhid, int giaiDoan
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(long thutuchanhchinhid, int giaiDoan) throws SystemException {
		return FileDinhKemFinderUtil.findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(thutuchanhchinhid, giaiDoan);
	}
	
	/**
	  * This is fucntion deleteTaiLieuChungThuc  by hosotthcCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosotthcCongId
	  * @return void
	  */
	public void deleteByHoSoThuTucHanhChinhId(long hosotthcCongId) {
		try {
			List<FileDinhKem> listFile = findByHoSoTTHCCongID(hosotthcCongId);
			for (FileDinhKem fileUpload : listFile) {
				try {
					TaiLieuChungThucLocalServiceUtil.deleteTaiLieuChungThuc(fileUpload.getNoiLuuTruTaiLieuId());
				} catch (Exception es) {
				}
				fileDinhKemPersistence.remove(fileUpload.getId());
			}
		} catch (Exception es) {
		}
	}
	
	/**
	  * This is fucntion getFileTraKetQua  by hosoId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long hosoId
	  * @return String
	  */
	
	public String getFileTraKetQua(Long hosoId){		
		IDocumentStorage storage = new DocumentStorageImpl();
		Long id = null;
		try {
			id = FileDinhKemFinderUtil.findNoiLuuTruFileTraKetQua(hosoId);
			if(id != null){
				return storage.getURLById(id);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	  * This is fucntion fetchByHoSoTTHCCongId by hoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> fetchByHoSoTTHCCongId(long hoSoTTHCCongId) throws SystemException {
		return findByHoSoTTHCCongID(hoSoTTHCCongId);
	}
	
	/**
	  * This is fucntion getLoaiFileKhac  by idHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long idHoSo
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> getLoaiFileKhac(long idHoSo) throws com.liferay.portal.kernel.exception.SystemException, NoSuchFileDinhKemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			FileDinhKemImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(idHoSo));
		query.add(PropertyFactoryUtil.forName(FIELD_THUTUC2GIAYTOID).isNull());
		query.add(PropertyFactoryUtil.forName(FIELD_DANHMUCGIAYTOID).isNull());
		query.add(PropertyFactoryUtil.forName(FIELD_XOA).eq(Constants.ACTIVE));
		return (List<FileDinhKem>) FileDinhKemLocalServiceUtil
			.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//		return fileDinhKemPersistence.findByFindLoaiKhacByHoSoId(idHoSo,idthutuc2giayto, iddanhmcgiayto) ;
	}
	
	/**
	  * This is fucntion findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, String maLoaiTaiLieuDuocThayThe
	  * @return List<FileDinhKem>
	  */
	public java.util.List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(long hoSoTTHCCongId, String maLoaiTaiLieuDuocThayThe)
			 {
		try {
			return FileDinhKemFinderUtil.findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(hoSoTTHCCongId, maLoaiTaiLieuDuocThayThe);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findByMaFileDinhKemAndIdDanhSachHoSoS
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, long taiLieuChungThucId
	  * @return List<FileDinhKem>
	  */
	public java.util.List<FileDinhKem> findByMaFileDinhKemAndIdDanhSachHoSoS(
			long hoSoTTHCCongId, long taiLieuChungThucId)
			throws com.liferay.portal.kernel.exception.SystemException {
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			FileDinhKemImpl.class,
			PortalClassLoaderUtil.getClassLoader()
		);
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoTTHCCongId));
		query.add(PropertyFactoryUtil.forName(FIELD_NOILUUTRUTAILIEUID).eq(taiLieuChungThucId));
		query.add(PropertyFactoryUtil.forName(FIELD_XOA).eq(Constants.ACTIVE));
		return (List<FileDinhKem>) fileDinhKemPersistence .findWithDynamicQuery(query);
	}
	
	/**
	  * This is fucntion findByHoSoTTHCCongIdAndThuTuc2GiayToId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, long thuTuc2GiayToId
	  * @return FileDinhKem
	  */
	public FileDinhKem findByHoSoTTHCCongIdAndThuTuc2GiayToId(long hoSoTTHCCongId, long thuTuc2GiayToId) {
			
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			FileDinhKemImpl.class,
			PortalClassLoaderUtil.getClassLoader()
		);
		
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOTTHCCONGID).eq(hoSoTTHCCongId));
		query.add(PropertyFactoryUtil.forName(FIELD_THUTUC2GIAYTOID).eq(thuTuc2GiayToId));
		query.add(PropertyFactoryUtil.forName(FIELD_XOA).eq(Constants.ACTIVE));
		List<FileDinhKem> list = Collections.emptyList();
		
		try {
			list = (List<FileDinhKem>) fileDinhKemPersistence.findWithDynamicQuery(query);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**
	  * This is fucntion findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, long danhMucGiayToId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(long hoSoTTHCCongId, long danhMucGiayToId)
			{
		return FileDinhKemFinderUtil.findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(hoSoTTHCCongId, danhMucGiayToId);
	}
	
	/**
	  * This is fucntion findTaiLieuDinhKemTichHop
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId) {
		return FileDinhKemFinderUtil.findTaiLieuDinhKemTichHop(hoSoTTHCCongId);
	}
	
}