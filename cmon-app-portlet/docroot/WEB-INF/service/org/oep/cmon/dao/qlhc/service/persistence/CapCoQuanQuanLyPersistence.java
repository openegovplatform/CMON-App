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

package org.oep.cmon.dao.qlhc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;

/**
 * The persistence interface for the cap co quan quan ly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CapCoQuanQuanLyPersistenceImpl
 * @see CapCoQuanQuanLyUtil
 * @generated
 */
public interface CapCoQuanQuanLyPersistence extends BasePersistence<CapCoQuanQuanLy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CapCoQuanQuanLyUtil} to access the cap co quan quan ly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cap co quan quan ly in the entity cache if it is enabled.
	*
	* @param capCoQuanQuanLy the cap co quan quan ly
	*/
	public void cacheResult(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy);

	/**
	* Caches the cap co quan quan lies in the entity cache if it is enabled.
	*
	* @param capCoQuanQuanLies the cap co quan quan lies
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> capCoQuanQuanLies);

	/**
	* Creates a new cap co quan quan ly with the primary key. Does not add the cap co quan quan ly to the database.
	*
	* @param id the primary key for the new cap co quan quan ly
	* @return the new cap co quan quan ly
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy create(long id);

	/**
	* Removes the cap co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap co quan quan ly
	* @return the cap co quan quan ly that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy updateImpl(
		org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy capCoQuanQuanLy,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cap co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException} if it could not be found.
	*
	* @param id the primary key of the cap co quan quan ly
	* @return the cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the cap co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cap co quan quan ly
	* @return the cap co quan quan ly, or <code>null</code> if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cap co quan quan lies where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap co quan quan lies where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @return the range of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cap co quan quan lies where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cap co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the last cap co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the cap co quan quan lies before and after the current cap co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap co quan quan ly
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns all the cap co quan quan lies where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap co quan quan lies where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @return the range of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cap co quan quan lies where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cap co quan quan ly in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the last cap co quan quan ly in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the cap co quan quan lies before and after the current cap co quan quan ly in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap co quan quan ly
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns all the cap co quan quan lies where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap co quan quan lies where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @return the range of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cap co quan quan lies where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cap co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the last cap co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a matching cap co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns the cap co quan quan lies before and after the current cap co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap co quan quan ly
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException if a cap co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapCoQuanQuanLyException;

	/**
	* Returns all the cap co quan quan lies.
	*
	* @return the cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @return the range of cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cap co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap co quan quan lies
	* @param end the upper bound of the range of cap co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cap co quan quan lies where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cap co quan quan lies where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cap co quan quan lies where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cap co quan quan lies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap co quan quan lies where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap co quan quan lies where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap co quan quan lies where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap co quan quan lies.
	*
	* @return the number of cap co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}