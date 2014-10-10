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

package org.oep.cmon.dao.kios.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.kios.model.DanhSachHoSo;

/**
 * The persistence interface for the danh sach ho so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachHoSoPersistenceImpl
 * @see DanhSachHoSoUtil
 * @generated
 */
public interface DanhSachHoSoPersistence extends BasePersistence<DanhSachHoSo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhSachHoSoUtil} to access the danh sach ho so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the danh sach ho so in the entity cache if it is enabled.
	*
	* @param danhSachHoSo the danh sach ho so
	*/
	public void cacheResult(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo);

	/**
	* Caches the danh sach ho sos in the entity cache if it is enabled.
	*
	* @param danhSachHoSos the danh sach ho sos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> danhSachHoSos);

	/**
	* Creates a new danh sach ho so with the primary key. Does not add the danh sach ho so to the database.
	*
	* @param id the primary key for the new danh sach ho so
	* @return the new danh sach ho so
	*/
	public org.oep.cmon.dao.kios.model.DanhSachHoSo create(long id);

	/**
	* Removes the danh sach ho so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so that was removed
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachHoSo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException;

	public org.oep.cmon.dao.kios.model.DanhSachHoSo updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach ho so with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException} if it could not be found.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachHoSo findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException;

	/**
	* Returns the danh sach ho so with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so, or <code>null</code> if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachHoSo fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the danh sach ho sos.
	*
	* @return the danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh sach ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach ho sos
	* @param end the upper bound of the range of danh sach ho sos (not inclusive)
	* @return the range of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh sach ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach ho sos
	* @param end the upper bound of the range of danh sach ho sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the danh sach ho sos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh sach ho sos.
	*
	* @return the number of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}