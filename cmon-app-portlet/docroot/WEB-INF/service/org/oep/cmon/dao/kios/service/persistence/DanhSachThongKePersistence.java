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

import org.oep.cmon.dao.kios.model.DanhSachThongKe;

/**
 * The persistence interface for the danh sach thong ke service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachThongKePersistenceImpl
 * @see DanhSachThongKeUtil
 * @generated
 */
public interface DanhSachThongKePersistence extends BasePersistence<DanhSachThongKe> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhSachThongKeUtil} to access the danh sach thong ke persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the danh sach thong ke in the entity cache if it is enabled.
	*
	* @param danhSachThongKe the danh sach thong ke
	*/
	public void cacheResult(
		org.oep.cmon.dao.kios.model.DanhSachThongKe danhSachThongKe);

	/**
	* Caches the danh sach thong kes in the entity cache if it is enabled.
	*
	* @param danhSachThongKes the danh sach thong kes
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> danhSachThongKes);

	/**
	* Creates a new danh sach thong ke with the primary key. Does not add the danh sach thong ke to the database.
	*
	* @param COQUANQUANLYID the primary key for the new danh sach thong ke
	* @return the new danh sach thong ke
	*/
	public org.oep.cmon.dao.kios.model.DanhSachThongKe create(
		long COQUANQUANLYID);

	/**
	* Removes the danh sach thong ke with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param COQUANQUANLYID the primary key of the danh sach thong ke
	* @return the danh sach thong ke that was removed
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachThongKe remove(
		long COQUANQUANLYID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException;

	public org.oep.cmon.dao.kios.model.DanhSachThongKe updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachThongKe danhSachThongKe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach thong ke with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException} if it could not be found.
	*
	* @param COQUANQUANLYID the primary key of the danh sach thong ke
	* @return the danh sach thong ke
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachThongKe findByPrimaryKey(
		long COQUANQUANLYID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException;

	/**
	* Returns the danh sach thong ke with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param COQUANQUANLYID the primary key of the danh sach thong ke
	* @return the danh sach thong ke, or <code>null</code> if a danh sach thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.kios.model.DanhSachThongKe fetchByPrimaryKey(
		long COQUANQUANLYID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the danh sach thong kes.
	*
	* @return the danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh sach thong kes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach thong kes
	* @param end the upper bound of the range of danh sach thong kes (not inclusive)
	* @return the range of danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh sach thong kes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach thong kes
	* @param end the upper bound of the range of danh sach thong kes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the danh sach thong kes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh sach thong kes.
	*
	* @return the number of danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}