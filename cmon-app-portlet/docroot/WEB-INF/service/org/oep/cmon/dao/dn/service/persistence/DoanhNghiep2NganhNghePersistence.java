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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe;

/**
 * The persistence interface for the doanh nghiep2 nganh nghe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DoanhNghiep2NganhNghePersistenceImpl
 * @see DoanhNghiep2NganhNgheUtil
 * @generated
 */
public interface DoanhNghiep2NganhNghePersistence extends BasePersistence<DoanhNghiep2NganhNghe> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoanhNghiep2NganhNgheUtil} to access the doanh nghiep2 nganh nghe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the doanh nghiep2 nganh nghe in the entity cache if it is enabled.
	*
	* @param doanhNghiep2NganhNghe the doanh nghiep2 nganh nghe
	*/
	public void cacheResult(
		org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe doanhNghiep2NganhNghe);

	/**
	* Caches the doanh nghiep2 nganh nghes in the entity cache if it is enabled.
	*
	* @param doanhNghiep2NganhNghes the doanh nghiep2 nganh nghes
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> doanhNghiep2NganhNghes);

	/**
	* Creates a new doanh nghiep2 nganh nghe with the primary key. Does not add the doanh nghiep2 nganh nghe to the database.
	*
	* @param id the primary key for the new doanh nghiep2 nganh nghe
	* @return the new doanh nghiep2 nganh nghe
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe create(long id);

	/**
	* Removes the doanh nghiep2 nganh nghe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doanh nghiep2 nganh nghe
	* @return the doanh nghiep2 nganh nghe that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException;

	public org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe updateImpl(
		org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe doanhNghiep2NganhNghe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep2 nganh nghe with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException} if it could not be found.
	*
	* @param id the primary key of the doanh nghiep2 nganh nghe
	* @return the doanh nghiep2 nganh nghe
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException;

	/**
	* Returns the doanh nghiep2 nganh nghe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the doanh nghiep2 nganh nghe
	* @return the doanh nghiep2 nganh nghe, or <code>null</code> if a doanh nghiep2 nganh nghe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the doanh nghiep2 nganh nghes.
	*
	* @return the doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the doanh nghiep2 nganh nghes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghiep2 nganh nghes
	* @param end the upper bound of the range of doanh nghiep2 nganh nghes (not inclusive)
	* @return the range of doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the doanh nghiep2 nganh nghes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghiep2 nganh nghes
	* @param end the upper bound of the range of doanh nghiep2 nganh nghes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the doanh nghiep2 nganh nghes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghiep2 nganh nghes.
	*
	* @return the number of doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}