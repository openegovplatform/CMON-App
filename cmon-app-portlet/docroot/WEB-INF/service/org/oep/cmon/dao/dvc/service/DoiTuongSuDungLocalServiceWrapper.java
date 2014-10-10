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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DoiTuongSuDungLocalService}.
 * </p>
 *
 * @author    liemnn
 * @see       DoiTuongSuDungLocalService
 * @generated
 */
public class DoiTuongSuDungLocalServiceWrapper
	implements DoiTuongSuDungLocalService,
		ServiceWrapper<DoiTuongSuDungLocalService> {
	public DoiTuongSuDungLocalServiceWrapper(
		DoiTuongSuDungLocalService doiTuongSuDungLocalService) {
		_doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	/**
	* Adds the doi tuong su dung to the database. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @return the doi tuong su dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung addDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.addDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	* Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	*
	* @param id the primary key for the new doi tuong su dung
	* @return the new doi tuong su dung
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung createDoiTuongSuDung(
		long id) {
		return _doiTuongSuDungLocalService.createDoiTuongSuDung(id);
	}

	/**
	* Deletes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doi tuong su dung
	* @throws PortalException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_doiTuongSuDungLocalService.deleteDoiTuongSuDung(id);
	}

	/**
	* Deletes the doi tuong su dung from the database. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		_doiTuongSuDungLocalService.deleteDoiTuongSuDung(doiTuongSuDung);
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
		return _doiTuongSuDungLocalService.dynamicQuery(dynamicQuery);
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
		return _doiTuongSuDungLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _doiTuongSuDungLocalService.dynamicQuery(dynamicQuery, start,
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
		return _doiTuongSuDungLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchDoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.fetchDoiTuongSuDung(id);
	}

	/**
	* Returns the doi tuong su dung with the primary key.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung
	* @throws PortalException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung getDoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.getDoiTuongSuDung(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @return the range of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getDoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.getDoiTuongSuDungs(start, end);
	}

	/**
	* Returns the number of doi tuong su dungs.
	*
	* @return the number of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int getDoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.getDoiTuongSuDungsCount();
	}

	/**
	* Updates the doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @return the doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung updateDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.updateDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	* Updates the doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param doiTuongSuDung the doi tuong su dung
	* @param merge whether to merge the doi tuong su dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the doi tuong su dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung updateDoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.updateDoiTuongSuDung(doiTuongSuDung,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _doiTuongSuDungLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_doiTuongSuDungLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion find DoiTuongSuDung by Ma
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ma
	* @return DoiTuongSuDung
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.findByMa(ma);
	}

	/**
	* This is fucntion find DoiTuongSuDung by ten
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param String : Value of ten
	* @return DoiTuongSuDung
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _doiTuongSuDungLocalService.findByTen(ten);
	}

	/**
	* This is fucntion find DoiTuongSuDung by trangthai
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int daXoa
	* @return List<DoiTuongSuDung>
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getDSDoiTuongSuDung(
		int daXoa) {
		return _doiTuongSuDungLocalService.getDSDoiTuongSuDung(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DoiTuongSuDungLocalService getWrappedDoiTuongSuDungLocalService() {
		return _doiTuongSuDungLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDoiTuongSuDungLocalService(
		DoiTuongSuDungLocalService doiTuongSuDungLocalService) {
		_doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	public DoiTuongSuDungLocalService getWrappedService() {
		return _doiTuongSuDungLocalService;
	}

	public void setWrappedService(
		DoiTuongSuDungLocalService doiTuongSuDungLocalService) {
		_doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	private DoiTuongSuDungLocalService _doiTuongSuDungLocalService;
}