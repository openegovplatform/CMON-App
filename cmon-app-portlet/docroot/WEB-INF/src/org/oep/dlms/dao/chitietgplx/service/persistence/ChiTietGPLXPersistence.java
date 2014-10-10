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

package org.oep.dlms.dao.chitietgplx.service.persistence;

import org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX;

import com.liferay.portal.service.persistence.BasePersistence;


/**
 * The persistence interface for the chi tiet g p l x service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hunghq
 * @see ChiTietGPLXPersistenceImpl
 * @see ChiTietGPLXUtil
 * @generated
 */
public interface ChiTietGPLXPersistence extends BasePersistence<ChiTietGPLX> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChiTietGPLXUtil} to access the chi tiet g p l x persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the chi tiet g p l x in the entity cache if it is enabled.
	*
	* @param chiTietGPLX the chi tiet g p l x
	*/
	public void cacheResult(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX);

	/**
	* Caches the chi tiet g p l xs in the entity cache if it is enabled.
	*
	* @param chiTietGPLXs the chi tiet g p l xs
	*/
	public void cacheResult(
		java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> chiTietGPLXs);

	/**
	* Creates a new chi tiet g p l x with the primary key. Does not add the chi tiet g p l x to the database.
	*
	* @param id the primary key for the new chi tiet g p l x
	* @return the new chi tiet g p l x
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX create(long id);

	/**
	* Removes the chi tiet g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x that was removed
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException;

	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX updateImpl(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chi tiet g p l x with the primary key or throws a {@link org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException} if it could not be found.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException;

	/**
	* Returns the chi tiet g p l x with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x, or <code>null</code> if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chi tiet g p l xs where idGPLX = &#63;.
	*
	* @param idGPLX the id g p l x
	* @return the matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chi tiet g p l xs where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @return the range of matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chi tiet g p l xs where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first chi tiet g p l x in the ordered set where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a matching chi tiet g p l x could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX findByGPLX_First(
		long idGPLX,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException;

	/**
	* Returns the last chi tiet g p l x in the ordered set where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a matching chi tiet g p l x could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX findByGPLX_Last(
		long idGPLX,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException;

	/**
	* Returns the chi tiet g p l xs before and after the current chi tiet g p l x in the ordered set where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chi tiet g p l x
	* @param idGPLX the id g p l x
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX[] findByGPLX_PrevAndNext(
		long id, long idGPLX,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException;

	/**
	* Returns all the chi tiet g p l xs.
	*
	* @return the chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chi tiet g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @return the range of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chi tiet g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chi tiet g p l xs where idGPLX = &#63; from the database.
	*
	* @param idGPLX the id g p l x
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGPLX(long idGPLX)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chi tiet g p l xs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chi tiet g p l xs where idGPLX = &#63;.
	*
	* @param idGPLX the id g p l x
	* @return the number of matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGPLX(long idGPLX)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chi tiet g p l xs.
	*
	* @return the number of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}