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

package org.oep.cmon.dao.report.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.report.model.DanhMucBaoCao;

/**
 * The persistence interface for the danh muc bao cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhMucBaoCaoPersistenceImpl
 * @see DanhMucBaoCaoUtil
 * @generated
 */
public interface DanhMucBaoCaoPersistence extends BasePersistence<DanhMucBaoCao> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhMucBaoCaoUtil} to access the danh muc bao cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the danh muc bao cao in the entity cache if it is enabled.
	*
	* @param danhMucBaoCao the danh muc bao cao
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao);

	/**
	* Caches the danh muc bao caos in the entity cache if it is enabled.
	*
	* @param danhMucBaoCaos the danh muc bao caos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> danhMucBaoCaos);

	/**
	* Creates a new danh muc bao cao with the primary key. Does not add the danh muc bao cao to the database.
	*
	* @param ID the primary key for the new danh muc bao cao
	* @return the new danh muc bao cao
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao create(long ID);

	/**
	* Removes the danh muc bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc bao cao
	* @return the danh muc bao cao that was removed
	* @throws org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException;

	public org.oep.cmon.dao.report.model.DanhMucBaoCao updateImpl(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc bao cao with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException} if it could not be found.
	*
	* @param ID the primary key of the danh muc bao cao
	* @return the danh muc bao cao
	* @throws org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException;

	/**
	* Returns the danh muc bao cao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the danh muc bao cao
	* @return the danh muc bao cao, or <code>null</code> if a danh muc bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucBaoCao fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the danh muc bao caos.
	*
	* @return the danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh muc bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc bao caos
	* @param end the upper bound of the range of danh muc bao caos (not inclusive)
	* @return the range of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh muc bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc bao caos
	* @param end the upper bound of the range of danh muc bao caos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the danh muc bao caos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh muc bao caos.
	*
	* @return the number of danh muc bao caos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}