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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NguoiDung2VaiTroLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       NguoiDung2VaiTroLocalService
 * @generated
 */
public class NguoiDung2VaiTroLocalServiceWrapper
	implements NguoiDung2VaiTroLocalService,
		ServiceWrapper<NguoiDung2VaiTroLocalService> {
	public NguoiDung2VaiTroLocalServiceWrapper(
		NguoiDung2VaiTroLocalService nguoiDung2VaiTroLocalService) {
		_nguoiDung2VaiTroLocalService = nguoiDung2VaiTroLocalService;
	}

	/**
	* Adds the nguoi dung2 vai tro to the database. Also notifies the appropriate model listeners.
	*
	* @param nguoiDung2VaiTro the nguoi dung2 vai tro
	* @return the nguoi dung2 vai tro that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro addNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.addNguoiDung2VaiTro(nguoiDung2VaiTro);
	}

	/**
	* Creates a new nguoi dung2 vai tro with the primary key. Does not add the nguoi dung2 vai tro to the database.
	*
	* @param id the primary key for the new nguoi dung2 vai tro
	* @return the new nguoi dung2 vai tro
	*/
	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro createNguoiDung2VaiTro(
		long id) {
		return _nguoiDung2VaiTroLocalService.createNguoiDung2VaiTro(id);
	}

	/**
	* Deletes the nguoi dung2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nguoi dung2 vai tro
	* @throws PortalException if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNguoiDung2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_nguoiDung2VaiTroLocalService.deleteNguoiDung2VaiTro(id);
	}

	/**
	* Deletes the nguoi dung2 vai tro from the database. Also notifies the appropriate model listeners.
	*
	* @param nguoiDung2VaiTro the nguoi dung2 vai tro
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		_nguoiDung2VaiTroLocalService.deleteNguoiDung2VaiTro(nguoiDung2VaiTro);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro fetchNguoiDung2VaiTro(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.fetchNguoiDung2VaiTro(id);
	}

	/**
	* Returns the nguoi dung2 vai tro with the primary key.
	*
	* @param id the primary key of the nguoi dung2 vai tro
	* @return the nguoi dung2 vai tro
	* @throws PortalException if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro getNguoiDung2VaiTro(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.getNguoiDung2VaiTro(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the nguoi dung2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @return the range of nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> getNguoiDung2VaiTros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.getNguoiDung2VaiTros(start, end);
	}

	/**
	* Returns the number of nguoi dung2 vai tros.
	*
	* @return the number of nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int getNguoiDung2VaiTrosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.getNguoiDung2VaiTrosCount();
	}

	/**
	* Updates the nguoi dung2 vai tro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nguoiDung2VaiTro the nguoi dung2 vai tro
	* @return the nguoi dung2 vai tro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro updateNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.updateNguoiDung2VaiTro(nguoiDung2VaiTro);
	}

	/**
	* Updates the nguoi dung2 vai tro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nguoiDung2VaiTro the nguoi dung2 vai tro
	* @param merge whether to merge the nguoi dung2 vai tro with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the nguoi dung2 vai tro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro updateNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nguoiDung2VaiTroLocalService.updateNguoiDung2VaiTro(nguoiDung2VaiTro,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _nguoiDung2VaiTroLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nguoiDung2VaiTroLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findByVaiTroID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long vaiTroId, int daXoa
	* @return List<NguoiDung2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByVaiTroID(
		long vaiTroId, int daXoa) {
		return _nguoiDung2VaiTroLocalService.findByVaiTroID(vaiTroId, daXoa);
	}

	/**
	* This is fucntion findByVaiTroIDAndTaiKhoanNguoiDungId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long vaiTroId, long taiKhoanNguoiDungId, int daXoa
	* @return NguoiDung2VaiTro
	*/
	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByVaiTroIDAndTaiKhoanNguoiDungId(
		long vaiTroId, long taiKhoanNguoiDungId, int daXoa) {
		return _nguoiDung2VaiTroLocalService.findByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa);
	}

	/**
	* This is fucntion findByTaiKhoanNguoiDungID
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param long taiKhoanNguoiDungId, int daXoa
	* @return List<NguoiDung2VaiTro>
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByTaiKhoanNguoiDungID(
		long taiKhoanNguoiDungId, int daXoa) {
		return _nguoiDung2VaiTroLocalService.findByTaiKhoanNguoiDungID(taiKhoanNguoiDungId,
			daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NguoiDung2VaiTroLocalService getWrappedNguoiDung2VaiTroLocalService() {
		return _nguoiDung2VaiTroLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNguoiDung2VaiTroLocalService(
		NguoiDung2VaiTroLocalService nguoiDung2VaiTroLocalService) {
		_nguoiDung2VaiTroLocalService = nguoiDung2VaiTroLocalService;
	}

	public NguoiDung2VaiTroLocalService getWrappedService() {
		return _nguoiDung2VaiTroLocalService;
	}

	public void setWrappedService(
		NguoiDung2VaiTroLocalService nguoiDung2VaiTroLocalService) {
		_nguoiDung2VaiTroLocalService = nguoiDung2VaiTroLocalService;
	}

	private NguoiDung2VaiTroLocalService _nguoiDung2VaiTroLocalService;
}