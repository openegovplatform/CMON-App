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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the thu tuc hanh chinh local service. This utility wraps {@link org.oep.cmon.dao.dvc.service.impl.ThuTucHanhChinhLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liemnn
 * @see ThuTucHanhChinhLocalService
 * @see org.oep.cmon.dao.dvc.service.base.ThuTucHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.impl.ThuTucHanhChinhLocalServiceImpl
 * @generated
 */
public class ThuTucHanhChinhLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.dvc.service.impl.ThuTucHanhChinhLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the thu tuc hanh chinh to the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @return the thu tuc hanh chinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh addThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThuTucHanhChinh(thuTucHanhChinh);
	}

	/**
	* Creates a new thu tuc hanh chinh with the primary key. Does not add the thu tuc hanh chinh to the database.
	*
	* @param id the primary key for the new thu tuc hanh chinh
	* @return the new thu tuc hanh chinh
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh createThuTucHanhChinh(
		long id) {
		return getService().createThuTucHanhChinh(id);
	}

	/**
	* Deletes the thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @throws PortalException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThuTucHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThuTucHanhChinh(id);
	}

	/**
	* Deletes the thu tuc hanh chinh from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThuTucHanhChinh(thuTucHanhChinh);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchThuTucHanhChinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchThuTucHanhChinh(id);
	}

	/**
	* Returns the thu tuc hanh chinh with the primary key.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh
	* @throws PortalException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh getThuTucHanhChinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThuTucHanhChinh(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThuTucHanhChinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThuTucHanhChinhs(start, end);
	}

	/**
	* Returns the number of thu tuc hanh chinhs.
	*
	* @return the number of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int getThuTucHanhChinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThuTucHanhChinhsCount();
	}

	/**
	* Updates the thu tuc hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @return the thu tuc hanh chinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThuTucHanhChinh(thuTucHanhChinh);
	}

	/**
	* Updates the thu tuc hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	* @param merge whether to merge the thu tuc hanh chinh with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the thu tuc hanh chinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThuTucHanhChinh(thuTucHanhChinh, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

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
	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucByUngDung(
		long ungDungId) throws java.lang.Exception {
		return getService().getDSThongTinThuTucByUngDung(ungDungId);
	}

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
	public static long countByThuTucLienThongId(long thuTucLienThongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByThuTucLienThongId(thuTucLienThongId);
	}

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
	public static org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(
		long thuTucId, long coQuanId) throws java.lang.Exception {
		return getService().fetchThongTinThuTuc2CoQuan(thuTucId, coQuanId);
	}

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
	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTuc2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		return getService().getDSThongTinThuTuc2CanBo(canBo);
	}

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
	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		return getService().getDSThongTinThuTucLienThongNoiGui2CanBo(canBo);
	}

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
	public static java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		return getService().getDSThongTinThuTucLienThongNoiNhan2CanBo(canBo);
	}

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
	public static long countByCQQL(long coQuanQuanLyId) {
		return getService().countByCQQL(coQuanQuanLyId);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQL(
		long coQuanQuanLyId) {
		return getService().getListTTHCByCQQL(coQuanQuanLyId);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getDSThuTucHanhChinh(
		java.lang.Long nhomId, int status) {
		return getService().getDSThuTucHanhChinh(nhomId, status);
	}

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
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh getThuTucHanhChinhBoiMa(
		java.lang.String code) {
		return getService().getThuTucHanhChinhBoiMa(code);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTrangThai(daXoa);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQLAndMa(
		long coQuanQuanLyId, java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListTTHCByCQQLAndMa(coQuanQuanLyId, ma);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> searchByUngDungOrNhom(
		java.lang.Long ungDungId, java.lang.Long nhomId, int start, int end) {
		return getService().searchByUngDungOrNhom(ungDungId, nhomId, start, end);
	}

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
	public static long countByUngDungOrNhom(java.lang.Long ungDungId,
		java.lang.Long nhomId) {
		return getService().countByUngDungOrNhom(ungDungId, nhomId);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> searchByTTHCIdOrGDId(
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end) {
		return getService().searchByTTHCIdOrGDId(tthcid, dgId, daXoa, start, end);
	}

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
	public static long countByTTHCIdOrGDId(java.lang.Long tthcid,
		java.lang.Long dgId, java.lang.Integer daXoa) {
		return getService().countByTTHCIdOrGDId(tthcid, dgId, daXoa);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> searchByTTHC2HDBM(
		java.lang.Long tthcid, java.lang.Long loaiTL, java.lang.Integer daXoa,
		int start, int end) {
		return getService().searchByTTHC2HDBM(tthcid, loaiTL, daXoa, start, end);
	}

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
	public static long countByTTHC2HDBM(java.lang.Long tthcid,
		java.lang.Long loaiTL, java.lang.Integer daXoa) {
		return getService().countByTTHC2HDBM(tthcid, loaiTL, daXoa);
	}

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
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(
		long thuTucHanhChinhId, int start, int end) {
		return getService().getTenCQQL(thuTucHanhChinhId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(
		long thuTucHanhChinhId, int start, int end) {
		return getService().getTenDTSD(thuTucHanhChinhId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(
		long thuTucHanhChinhId, int start, int end) {
		return getService().getTenDMGT(thuTucHanhChinhId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static ThuTucHanhChinhLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ThuTucHanhChinhLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ThuTucHanhChinhLocalService.class.getName(),
					portletClassLoader);

			_service = new ThuTucHanhChinhLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ThuTucHanhChinhLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ThuTucHanhChinhLocalService.class);
		}

		return _service;
	}

	public void setService(ThuTucHanhChinhLocalService service) {
		MethodCache.remove(ThuTucHanhChinhLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ThuTucHanhChinhLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ThuTucHanhChinhLocalService.class);
	}

	private static ThuTucHanhChinhLocalService _service;
}