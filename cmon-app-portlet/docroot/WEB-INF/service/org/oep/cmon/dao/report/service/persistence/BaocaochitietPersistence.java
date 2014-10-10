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

import org.oep.cmon.dao.report.model.Baocaochitiet;

/**
 * The persistence interface for the baocaochitiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see BaocaochitietPersistenceImpl
 * @see BaocaochitietUtil
 * @generated
 */
public interface BaocaochitietPersistence extends BasePersistence<Baocaochitiet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BaocaochitietUtil} to access the baocaochitiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the baocaochitiet in the entity cache if it is enabled.
	*
	* @param baocaochitiet the baocaochitiet
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet);

	/**
	* Caches the baocaochitiets in the entity cache if it is enabled.
	*
	* @param baocaochitiets the baocaochitiets
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> baocaochitiets);

	/**
	* Creates a new baocaochitiet with the primary key. Does not add the baocaochitiet to the database.
	*
	* @param MASOHOSO the primary key for the new baocaochitiet
	* @return the new baocaochitiet
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet create(
		java.lang.String MASOHOSO);

	/**
	* Removes the baocaochitiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet that was removed
	* @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet remove(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchBaocaochitietException;

	public org.oep.cmon.dao.report.model.Baocaochitiet updateImpl(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the baocaochitiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchBaocaochitietException} if it could not be found.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet
	* @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet findByPrimaryKey(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchBaocaochitietException;

	/**
	* Returns the baocaochitiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet, or <code>null</code> if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Baocaochitiet fetchByPrimaryKey(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the baocaochitiets.
	*
	* @return the baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the baocaochitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of baocaochitiets
	* @param end the upper bound of the range of baocaochitiets (not inclusive)
	* @return the range of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the baocaochitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of baocaochitiets
	* @param end the upper bound of the range of baocaochitiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the baocaochitiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of baocaochitiets.
	*
	* @return the number of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}