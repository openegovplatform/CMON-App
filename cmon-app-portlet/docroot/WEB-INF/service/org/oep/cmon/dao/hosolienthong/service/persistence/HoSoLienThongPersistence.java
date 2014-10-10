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

package org.oep.cmon.dao.hosolienthong.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;

/**
 * The persistence interface for the ho so lien thong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hoangtrung.nguyen
 * @see HoSoLienThongPersistenceImpl
 * @see HoSoLienThongUtil
 * @generated
 */
public interface HoSoLienThongPersistence extends BasePersistence<HoSoLienThong> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoLienThongUtil} to access the ho so lien thong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ho so lien thong in the entity cache if it is enabled.
	*
	* @param hoSoLienThong the ho so lien thong
	*/
	public void cacheResult(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong);

	/**
	* Caches the ho so lien thongs in the entity cache if it is enabled.
	*
	* @param hoSoLienThongs the ho so lien thongs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> hoSoLienThongs);

	/**
	* Creates a new ho so lien thong with the primary key. Does not add the ho so lien thong to the database.
	*
	* @param id the primary key for the new ho so lien thong
	* @return the new ho so lien thong
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong create(long id);

	/**
	* Removes the ho so lien thong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong that was removed
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateImpl(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so lien thong with the primary key or throws a {@link org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException} if it could not be found.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	/**
	* Returns the ho so lien thong with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong, or <code>null</code> if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so lien thongs where hoSoId = &#63;.
	*
	* @param hoSoId the ho so ID
	* @return the matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so lien thongs where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @return the range of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so lien thongs where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so lien thong in the ordered set where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByHoSoId_First(
		long hoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	/**
	* Returns the last ho so lien thong in the ordered set where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByHoSoId_Last(
		long hoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	/**
	* Returns the ho so lien thongs before and after the current ho so lien thong in the ordered set where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so lien thong
	* @param hoSoId the ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong[] findByHoSoId_PrevAndNext(
		long id, long hoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	/**
	* Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or throws a {@link org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException} if it could not be found.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @return the matching ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	/**
	* Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @return the matching ho so lien thong, or <code>null</code> if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ho so lien thong, or <code>null</code> if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so lien thongs.
	*
	* @return the ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so lien thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @return the range of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so lien thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so lien thongs where hoSoId = &#63; from the database.
	*
	* @param hoSoId the ho so ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the ho so lien thong where maSoBienNhanLucGui = &#63; from the database.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaSoBienNhanLucGui(java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;

	/**
	* Removes all the ho so lien thongs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so lien thongs where hoSoId = &#63;.
	*
	* @param hoSoId the ho so ID
	* @return the number of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public int countByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so lien thongs where maSoBienNhanLucGui = &#63;.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @return the number of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaSoBienNhanLucGui(java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so lien thongs.
	*
	* @return the number of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}