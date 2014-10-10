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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc;

/**
 * The persistence interface for the cau hinh portlet2 thu tuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see CauHinhPortlet2ThuTucPersistenceImpl
 * @see CauHinhPortlet2ThuTucUtil
 * @generated
 */
public interface CauHinhPortlet2ThuTucPersistence extends BasePersistence<CauHinhPortlet2ThuTuc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CauHinhPortlet2ThuTucUtil} to access the cau hinh portlet2 thu tuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cau hinh portlet2 thu tuc in the entity cache if it is enabled.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc);

	/**
	* Caches the cau hinh portlet2 thu tucs in the entity cache if it is enabled.
	*
	* @param cauHinhPortlet2ThuTucs the cau hinh portlet2 thu tucs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> cauHinhPortlet2ThuTucs);

	/**
	* Creates a new cau hinh portlet2 thu tuc with the primary key. Does not add the cau hinh portlet2 thu tuc to the database.
	*
	* @param thuTucHanhChinhId the primary key for the new cau hinh portlet2 thu tuc
	* @return the new cau hinh portlet2 thu tuc
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc create(
		long thuTucHanhChinhId);

	/**
	* Removes the cau hinh portlet2 thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc remove(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException;

	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc updateImpl(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cau hinh portlet2 thu tuc with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException} if it could not be found.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc
	* @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc findByPrimaryKey(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException;

	/**
	* Returns the cau hinh portlet2 thu tuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc, or <code>null</code> if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchByPrimaryKey(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException} if it could not be found.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching cau hinh portlet2 thu tuc
	* @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a matching cau hinh portlet2 thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException;

	/**
	* Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching cau hinh portlet2 thu tuc, or <code>null</code> if a matching cau hinh portlet2 thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cau hinh portlet2 thu tuc, or <code>null</code> if a matching cau hinh portlet2 thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchByThuTucHanhChinhId(
		long thuTucHanhChinhId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cau hinh portlet2 thu tucs.
	*
	* @return the cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cau hinh portlet2 thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cau hinh portlet2 thu tucs
	* @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	* @return the range of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cau hinh portlet2 thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cau hinh portlet2 thu tucs
	* @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException;

	/**
	* Removes all the cau hinh portlet2 thu tucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cau hinh portlet2 thu tucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cau hinh portlet2 thu tucs.
	*
	* @return the number of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}