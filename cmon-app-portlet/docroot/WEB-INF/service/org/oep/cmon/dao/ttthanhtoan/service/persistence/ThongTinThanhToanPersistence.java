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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;

/**
 * The persistence interface for the thong tin thanh toan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thanhdd
 * @see ThongTinThanhToanPersistenceImpl
 * @see ThongTinThanhToanUtil
 * @generated
 */
public interface ThongTinThanhToanPersistence extends BasePersistence<ThongTinThanhToan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThongTinThanhToanUtil} to access the thong tin thanh toan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the thong tin thanh toan in the entity cache if it is enabled.
	*
	* @param thongTinThanhToan the thong tin thanh toan
	*/
	public void cacheResult(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan);

	/**
	* Caches the thong tin thanh toans in the entity cache if it is enabled.
	*
	* @param thongTinThanhToans the thong tin thanh toans
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> thongTinThanhToans);

	/**
	* Creates a new thong tin thanh toan with the primary key. Does not add the thong tin thanh toan to the database.
	*
	* @param id the primary key for the new thong tin thanh toan
	* @return the new thong tin thanh toan
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan create(long id);

	/**
	* Removes the thong tin thanh toan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan that was removed
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException;

	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan updateImpl(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the thong tin thanh toan with the primary key or throws a {@link org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException} if it could not be found.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException;

	/**
	* Returns the thong tin thanh toan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan, or <code>null</code> if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @return the range of matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a matching thong tin thanh toan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan findByHoSoTTHCCongId_First(
		long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException;

	/**
	* Returns the last thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a matching thong tin thanh toan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan findByHoSoTTHCCongId_Last(
		long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException;

	/**
	* Returns the thong tin thanh toans before and after the current thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thong tin thanh toan
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan[] findByHoSoTTHCCongId_PrevAndNext(
		long id, long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException;

	/**
	* Returns all the thong tin thanh toans.
	*
	* @return the thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thong tin thanh toans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @return the range of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thong tin thanh toans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thong tin thanh toans where hoSoTTHCCongId = &#63; from the database.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thong tin thanh toans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the number of matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thong tin thanh toans.
	*
	* @return the number of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}