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

package org.oep.cmon.dao.csms.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan;

/**
 * The persistence interface for the anh chan dung yeu cau dang ky cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see AnhChanDungYeuCauDangKyCongDanPersistenceImpl
 * @see AnhChanDungYeuCauDangKyCongDanUtil
 * @generated
 */
public interface AnhChanDungYeuCauDangKyCongDanPersistence
	extends BasePersistence<AnhChanDungYeuCauDangKyCongDan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnhChanDungYeuCauDangKyCongDanUtil} to access the anh chan dung yeu cau dang ky cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the anh chan dung yeu cau dang ky cong dan in the entity cache if it is enabled.
	*
	* @param anhChanDungYeuCauDangKyCongDan the anh chan dung yeu cau dang ky cong dan
	*/
	public void cacheResult(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan);

	/**
	* Caches the anh chan dung yeu cau dang ky cong dans in the entity cache if it is enabled.
	*
	* @param anhChanDungYeuCauDangKyCongDans the anh chan dung yeu cau dang ky cong dans
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan> anhChanDungYeuCauDangKyCongDans);

	/**
	* Creates a new anh chan dung yeu cau dang ky cong dan with the primary key. Does not add the anh chan dung yeu cau dang ky cong dan to the database.
	*
	* @param id the primary key for the new anh chan dung yeu cau dang ky cong dan
	* @return the new anh chan dung yeu cau dang ky cong dan
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan create(
		long id);

	/**
	* Removes the anh chan dung yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	* @return the anh chan dung yeu cau dang ky cong dan that was removed
	* @throws org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException;

	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan updateImpl(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anh chan dung yeu cau dang ky cong dan with the primary key or throws a {@link org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException} if it could not be found.
	*
	* @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	* @return the anh chan dung yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException;

	/**
	* Returns the anh chan dung yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	* @return the anh chan dung yeu cau dang ky cong dan, or <code>null</code> if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anh chan dung yeu cau dang ky cong dans.
	*
	* @return the anh chan dung yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anh chan dung yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh chan dung yeu cau dang ky cong dans
	* @param end the upper bound of the range of anh chan dung yeu cau dang ky cong dans (not inclusive)
	* @return the range of anh chan dung yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anh chan dung yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh chan dung yeu cau dang ky cong dans
	* @param end the upper bound of the range of anh chan dung yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anh chan dung yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anh chan dung yeu cau dang ky cong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh chan dung yeu cau dang ky cong dans.
	*
	* @return the number of anh chan dung yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}