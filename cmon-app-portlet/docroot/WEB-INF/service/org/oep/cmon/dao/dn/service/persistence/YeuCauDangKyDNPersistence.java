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

import org.oep.cmon.dao.dn.model.YeuCauDangKyDN;

/**
 * The persistence interface for the yeu cau dang ky d n service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see YeuCauDangKyDNPersistenceImpl
 * @see YeuCauDangKyDNUtil
 * @generated
 */
public interface YeuCauDangKyDNPersistence extends BasePersistence<YeuCauDangKyDN> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YeuCauDangKyDNUtil} to access the yeu cau dang ky d n persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the yeu cau dang ky d n in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyDN the yeu cau dang ky d n
	*/
	public void cacheResult(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDN yeuCauDangKyDN);

	/**
	* Caches the yeu cau dang ky d ns in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyDNs the yeu cau dang ky d ns
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDN> yeuCauDangKyDNs);

	/**
	* Creates a new yeu cau dang ky d n with the primary key. Does not add the yeu cau dang ky d n to the database.
	*
	* @param id the primary key for the new yeu cau dang ky d n
	* @return the new yeu cau dang ky d n
	*/
	public org.oep.cmon.dao.dn.model.YeuCauDangKyDN create(long id);

	/**
	* Removes the yeu cau dang ky d n with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau dang ky d n
	* @return the yeu cau dang ky d n that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException if a yeu cau dang ky d n with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.YeuCauDangKyDN remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException;

	public org.oep.cmon.dao.dn.model.YeuCauDangKyDN updateImpl(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDN yeuCauDangKyDN, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the yeu cau dang ky d n with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException} if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky d n
	* @return the yeu cau dang ky d n
	* @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException if a yeu cau dang ky d n with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.YeuCauDangKyDN findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException;

	/**
	* Returns the yeu cau dang ky d n with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky d n
	* @return the yeu cau dang ky d n, or <code>null</code> if a yeu cau dang ky d n with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.YeuCauDangKyDN fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the yeu cau dang ky d ns.
	*
	* @return the yeu cau dang ky d ns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDN> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the yeu cau dang ky d ns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky d ns
	* @param end the upper bound of the range of yeu cau dang ky d ns (not inclusive)
	* @return the range of yeu cau dang ky d ns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDN> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the yeu cau dang ky d ns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky d ns
	* @param end the upper bound of the range of yeu cau dang ky d ns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of yeu cau dang ky d ns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDN> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the yeu cau dang ky d ns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of yeu cau dang ky d ns.
	*
	* @return the number of yeu cau dang ky d ns
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}