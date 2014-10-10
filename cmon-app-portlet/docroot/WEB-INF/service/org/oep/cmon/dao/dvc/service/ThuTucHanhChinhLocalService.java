/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.oep.cmon.dao.dvc.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the thu tuc hanh chinh local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see ThuTucHanhChinhLocalServiceUtil
 * @see org.oep.cmon.dao.dvc.service.base.ThuTucHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.ThuTucHanhChinhLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ThuTucHanhChinhLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThuTucHanhChinhLocalServiceUtil} to access the thu tuc hanh chinh local service. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.ThuTucHanhChinhLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the thu tuc hanh chinh to the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @return the thu tuc hanh chinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh addThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new thu tuc hanh chinh with the primary key. Does not add the thu tuc hanh chinh to the database.
	*
	* @param id the primary key for the new thu tuc hanh chinh
	* @return the new thu tuc hanh chinh
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh createThuTucHanhChinh(
		long id);

	/**
	* Deletes the thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @throws PortalException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThuTucHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the thu tuc hanh chinh from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @throws SystemException if a system exception occurred
	*/
	public void deleteThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchThuTucHanhChinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the thu tuc hanh chinh with the primary key.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh
	* @throws PortalException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh getThuTucHanhChinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThuTucHanhChinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc hanh chinhs.
	*
	* @return the number of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getThuTucHanhChinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the thu tuc hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @return the thu tuc hanh chinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the thu tuc hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @param merge whether to merge the thu tuc hanh chinh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the thu tuc hanh chinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	/**
	* This is fucntion get ThongTinThuTuc by ungDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long ungDungId
	* @return List<ThongTinThuTuc>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucByUngDung(
		long ungDungId) throws java.lang.Exception;

	/**
	* This is fucntion count ThuTucHanhChinh by thuTucLienThongId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucLienThongId
	* @return long
	*/
	public long countByThuTucLienThongId(long thuTucLienThongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion fetch ThongTinThuTuc2CoQuan by thuTucId, coQuanId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucId, long coQuanId
	* @return ThongTinThuTuc2CoQuan
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(
		long thuTucId, long coQuanId) throws java.lang.Exception;

	/**
	* This is fucntion get ThongTinThuTuc by canBo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param CongChuc canBo
	* @return List<ThongTinThuTuc>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTuc2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception;

	/**
	* This is fucntion get ThongTinThuTuc send by CongChuc
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param CongChuc canBo
	* @return List<ThongTinThuTuc>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception;

	/**
	* This is fucntion get ThongTinThuTuc receive by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param CongChuc canBo
	* @return List<ThongTinThuTuc>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception;

	/**
	* This is fucntion count QuanQuanLyId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId
	* @return long
	*/
	public long countByCQQL(long coQuanQuanLyId);

	/**
	* This is fucntion get ThuTucHanhChinh by coQuanQuanLyId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId
	* @return List<ThuTucHanhChinh>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQL(
		long coQuanQuanLyId);

	/**
	* This is fucntion get ThuTucHanhChinh by nhomId, status
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long nhomId,int status
	* @return List<ThuTucHanhChinh>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getDSThuTucHanhChinh(
		java.lang.Long nhomId, int status);

	/**
	* This is fucntion find ThuTucHanhChinh by code
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String code
	* @return ThuTucHanhChinh
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh getThuTucHanhChinhBoiMa(
		java.lang.String code);

	/**
	* This is fucntion findAll ThuTucHanhChinh by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param
	* @return List<ThuTucHanhChinh>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find ThuTucHanhChinh by TrangThai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<ThuTucHanhChinh>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion get ThuTucHanhChinh by coQuanQuanLyId ,ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long coQuanQuanLyId, String ma
	* @return List<ThuTucHanhChinh>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQLAndMa(
		long coQuanQuanLyId, java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This is fucntion find ThuTucHanhChinh by ungDungId, nhomId, param paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long ungDungId,Long nhomId,int start,int end
	* @return List<ThuTucHanhChinh>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> searchByUngDungOrNhom(
		java.lang.Long ungDungId, java.lang.Long nhomId, int start, int end);

	/**
	* This is fucntion count ThuTucHanhChinh by ungDungId, nhomId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long ungDungId,Long nhomId
	* @return long
	*/
	public long countByUngDungOrNhom(java.lang.Long ungDungId,
		java.lang.Long nhomId);

	/**
	* This is fucntion find ThuTuc2GiayTo by tthcid, dgId,daXoa, param paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long tthcid,Long dgId, Integer daXoa, int start,int end
	* @return List<ThuTuc2GiayTo>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> searchByTTHCIdOrGDId(
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end);

	/**
	* This is fucntion count ThuTucHanhChinh by ChucVu by tthcid, dgId,trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long tthcid,Long dgId, Integer daXoa
	* @return long
	*/
	public long countByTTHCIdOrGDId(java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa);

	/**
	* This is fucntion search VanBanHuongDan by tthcid, loaiTL,daXoa, param paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long tthcid,Long loaiTL, Integer daXoa, int start,int end
	* @return List<VanBanHuongDan>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> searchByTTHC2HDBM(
		java.lang.Long tthcid, java.lang.Long loaiTL, java.lang.Integer daXoa,
		int start, int end);

	/**
	* This is fucntion count ThuTucHanhChinh by  tthcid,loaiTL, daXoa
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long tthcid,Long loaiTL, Integer daXoa
	* @return long
	*/
	public long countByTTHC2HDBM(java.lang.Long tthcid, java.lang.Long loaiTL,
		java.lang.Integer daXoa);

	/**
	* This is fucntion get Name of CapCoQuanQuanLy by thuTucHanhChinhId,param paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucHanhChinhId,  int start, int end
	* @return List<CapCoQuanQuanLy>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(
		long thuTucHanhChinhId, int start, int end);

	/**
	* This is fucntion get Name DoiTuongSuDung by thuTucHanhChinhId,param paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucHanhChinhId,  int start, int end
	* @return List<DoiTuongSuDung>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(
		long thuTucHanhChinhId, int start, int end);

	/**
	* This is fucntion get Name DanhMucGiayTo by thuTucHanhChinhId,param paging
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long thuTucHanhChinhId,  int start, int end
	* @return List<DanhMucGiayTo>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(
		long thuTucHanhChinhId, int start, int end);
}