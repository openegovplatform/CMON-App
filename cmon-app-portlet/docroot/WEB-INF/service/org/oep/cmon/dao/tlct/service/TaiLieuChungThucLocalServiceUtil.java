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

package org.oep.cmon.dao.tlct.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the tai lieu chung thuc local service. This utility wraps {@link org.oep.cmon.dao.tlct.service.impl.TaiLieuChungThucLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see TaiLieuChungThucLocalService
 * @see org.oep.cmon.dao.tlct.service.base.TaiLieuChungThucLocalServiceBaseImpl
 * @see org.oep.cmon.dao.tlct.service.impl.TaiLieuChungThucLocalServiceImpl
 * @generated
 */
public class TaiLieuChungThucLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.tlct.service.impl.TaiLieuChungThucLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tai lieu chung thuc to the database. Also notifies the appropriate model listeners.
	*
	* @param taiLieuChungThuc the tai lieu chung thuc
	* @return the tai lieu chung thuc that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc addTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTaiLieuChungThuc(taiLieuChungThuc);
	}

	/**
	* Creates a new tai lieu chung thuc with the primary key. Does not add the tai lieu chung thuc to the database.
	*
	* @param id the primary key for the new tai lieu chung thuc
	* @return the new tai lieu chung thuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc createTaiLieuChungThuc(
		long id) {
		return getService().createTaiLieuChungThuc(id);
	}

	/**
	* Deletes the tai lieu chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai lieu chung thuc
	* @throws PortalException if a tai lieu chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTaiLieuChungThuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTaiLieuChungThuc(id);
	}

	/**
	* Deletes the tai lieu chung thuc from the database. Also notifies the appropriate model listeners.
	*
	* @param taiLieuChungThuc the tai lieu chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTaiLieuChungThuc(taiLieuChungThuc);
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

	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc fetchTaiLieuChungThuc(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTaiLieuChungThuc(id);
	}

	/**
	* Returns the tai lieu chung thuc with the primary key.
	*
	* @param id the primary key of the tai lieu chung thuc
	* @return the tai lieu chung thuc
	* @throws PortalException if a tai lieu chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getTaiLieuChungThuc(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiLieuChungThuc(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tai lieu chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai lieu chung thucs
	* @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	* @return the range of tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> getTaiLieuChungThucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiLieuChungThucs(start, end);
	}

	/**
	* Returns the number of tai lieu chung thucs.
	*
	* @return the number of tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int getTaiLieuChungThucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaiLieuChungThucsCount();
	}

	/**
	* Updates the tai lieu chung thuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiLieuChungThuc the tai lieu chung thuc
	* @return the tai lieu chung thuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc updateTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaiLieuChungThuc(taiLieuChungThuc);
	}

	/**
	* Updates the tai lieu chung thuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiLieuChungThuc the tai lieu chung thuc
	* @param merge whether to merge the tai lieu chung thuc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tai lieu chung thuc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc updateTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaiLieuChungThuc(taiLieuChungThuc, merge);
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
	* This is fucntion isUsed
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long id
	* @return boolean
	*/
	public static boolean isUsed(java.lang.Long id) {
		return getService().isUsed(id);
	}

	/**
	* This is fucntion delete
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long id
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc delete(
		java.lang.Long id) {
		return getService().delete(id);
	}

	/**
	* This is fucntion add
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param TaiLieuChungThuc
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc add(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc model) {
		return getService().add(model);
	}

	/**
	* This is fucntion findByDanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long danhmucGiayToId
	* @return List<TaiLieuChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByDanhMucGiayTo(
		java.lang.Long danhmucGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDanhMucGiayTo(danhmucGiayToId);
	}

	/**
	* This is fucntion findByPhienBanMoiNhat
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long danhmucGiayToId, Long chuSohuuId
	* @return List<TaiLieuChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByPhienBanMoiNhat(
		java.lang.Long danhmucGiayToId, java.lang.Long chuSohuuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPhienBanMoiNhat(danhmucGiayToId, chuSohuuId);
	}

	/**
	* This is fucntion findByPhienBan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long danhmucGiayToId, int phienBan, Long nguoiUpLoadId
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByPhienBan(
		java.lang.Long danhmucGiayToId, int phienBan,
		java.lang.Long nguoiUpLoadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByPhienBan(danhmucGiayToId, phienBan, nguoiUpLoadId);
	}

	/**
	* This is fucntion findByHoSoTTHCCongIdAndTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long hoSoTTHCCId, String ten
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByHoSoTTHCCongIdAndTen(
		java.lang.Long hoSoTTHCCId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByHoSoTTHCCongIdAndTen(hoSoTTHCCId, ten);
	}

	/**
	* This is fucntion getCurrentVersion
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long danhmucGiayToId
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getCurrentVersion(
		java.lang.Long danhmucGiayToId) {
		return getService().getCurrentVersion(danhmucGiayToId);
	}

	/**
	* This is fucntion getCurrentVersion
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long danhMucGiayToId,Long userId
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getCurrentVersion(
		java.lang.Long danhMucGiayToId, java.lang.Long userId) {
		return getService().getCurrentVersion(danhMucGiayToId, userId);
	}

	/**
	* This is fucntion getTheoPhienBan
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long danhMucGiayToId,int phienban,Long userId
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getTheoPhienBan(
		java.lang.Long danhMucGiayToId, int phienban, java.lang.Long userId) {
		return getService().getTheoPhienBan(danhMucGiayToId, phienban, userId);
	}

	/**
	* This is fucntion getHoSoId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long hosoId
	* @return List<TaiLieuChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> getHoSoId(
		java.lang.Long hosoId) {
		return getService().getHoSoId(hosoId);
	}

	/**
	* This is fucntion findByNoiLuuTruId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long noiLuuTruId
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByNoiLuuTruId(
		long noiLuuTruId) {
		return getService().findByNoiLuuTruId(noiLuuTruId);
	}

	/**
	* This is fucntion findByHosotthcCongIdAndLoai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hoSoTTHCCId, int loai
	* @return List<TaiLieuChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		long hoSoTTHCCId, int loai) {
		return getService().findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai);
	}

	/**
	* This is fucntion findByHosotthcCongIdAndTen
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long hosotthcCongId, String ten
	* @return TaiLieuChungThuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByHosotthcCongIdAndTen(
		long hosotthcCongId, java.lang.String ten) {
		return getService().findByHosotthcCongIdAndTen(hosotthcCongId, ten);
	}

	/**
	* This is fucntion getMaxVersion
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param Long userId, Long giayToId
	* @return int
	*/
	public static int getMaxVersion(java.lang.Long userId,
		java.lang.Long giayToId) {
		return getService().getMaxVersion(userId, giayToId);
	}

	/**
	* This is fucntion searchCongDanId2DanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group, Long congDanId, Long doiTuongId,int start, int end
	* @return List<TaiLieuChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> searchCongDanId2DanhMucGiayTo(
		java.lang.String group, java.lang.Long congDanId,
		java.lang.Long doiTuongId, int start, int end) {
		return getService()
				   .searchCongDanId2DanhMucGiayTo(group, congDanId, doiTuongId,
			start, end);
	}

	/**
	* This is fucntion findTaiLieuXuLyByHoSoAndLoai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long idHoSo,int loai
	* @return List<TaiLieuChungThuc>
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findTaiLieuXuLyByHoSoAndLoai(
		long idHoSo, int loai) {
		return getService().findTaiLieuXuLyByHoSoAndLoai(idHoSo, loai);
	}

	/**
	* This is fucntion countCongDanId2DanhMucGiayTo
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String group, Long congDanId, Long doiTuongId
	* @return long
	*/
	public static long countCongDanId2DanhMucGiayTo(java.lang.String group,
		java.lang.Long congDanId, java.lang.Long doiTuongId) {
		return getService()
				   .countCongDanId2DanhMucGiayTo(group, congDanId, doiTuongId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TaiLieuChungThucLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TaiLieuChungThucLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TaiLieuChungThucLocalService.class.getName(),
					portletClassLoader);

			_service = new TaiLieuChungThucLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TaiLieuChungThucLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TaiLieuChungThucLocalService.class);
		}

		return _service;
	}

	public void setService(TaiLieuChungThucLocalService service) {
		MethodCache.remove(TaiLieuChungThucLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TaiLieuChungThucLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TaiLieuChungThucLocalService.class);
	}

	private static TaiLieuChungThucLocalService _service;
}