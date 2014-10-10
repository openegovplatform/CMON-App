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

package org.oep.cmon.dao.csms.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;

/**
 * The persistence interface for the yeu cau dang ky cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see YeuCauDangKyCongDanPersistenceImpl
 * @see YeuCauDangKyCongDanUtil
 * @generated
 */
public interface YeuCauDangKyCongDanPersistence extends BasePersistence<YeuCauDangKyCongDan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YeuCauDangKyCongDanUtil} to access the yeu cau dang ky cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the yeu cau dang ky cong dan in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyCongDan the yeu cau dang ky cong dan
	*/
	public void cacheResult(
		org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan yeuCauDangKyCongDan);

	/**
	* Caches the yeu cau dang ky cong dans in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyCongDans the yeu cau dang ky cong dans
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> yeuCauDangKyCongDans);

	/**
	* Creates a new yeu cau dang ky cong dan with the primary key. Does not add the yeu cau dang ky cong dan to the database.
	*
	* @param id the primary key for the new yeu cau dang ky cong dan
	* @return the new yeu cau dang ky cong dan
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan create(long id);

	/**
	* Removes the yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau dang ky cong dan
	* @return the yeu cau dang ky cong dan that was removed
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan updateImpl(
		org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan yeuCauDangKyCongDan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the yeu cau dang ky cong dan with the primary key or throws a {@link org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException} if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky cong dan
	* @return the yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns the yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky cong dan
	* @return the yeu cau dang ky cong dan, or <code>null</code> if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* @param MaXacNhan the ma xac nhan
	* @return the matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @return the range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findByMaXacNhan_First(
		java.lang.String MaXacNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns the last yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findByMaXacNhan_Last(
		java.lang.String MaXacNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns the yeu cau dang ky cong dans before and after the current yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current yeu cau dang ky cong dan
	* @param MaXacNhan the ma xac nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan[] findByMaXacNhan_PrevAndNext(
		long id, java.lang.String MaXacNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* @param SoCmnd the so cmnd
	* @return the matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findBySoCmnd(
		java.lang.String SoCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @return the range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findBySoCmnd(
		java.lang.String SoCmnd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findBySoCmnd(
		java.lang.String SoCmnd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findBySoCmnd_First(
		java.lang.String SoCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns the last yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findBySoCmnd_Last(
		java.lang.String SoCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns the yeu cau dang ky cong dans before and after the current yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current yeu cau dang ky cong dan
	* @param SoCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan[] findBySoCmnd_PrevAndNext(
		long id, java.lang.String SoCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;

	/**
	* Returns all the yeu cau dang ky cong dans.
	*
	* @return the yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @return the range of yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the yeu cau dang ky cong dans where MaXacNhan = &#63; from the database.
	*
	* @param MaXacNhan the ma xac nhan
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaXacNhan(java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the yeu cau dang ky cong dans where SoCmnd = &#63; from the database.
	*
	* @param SoCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySoCmnd(java.lang.String SoCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the yeu cau dang ky cong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* @param MaXacNhan the ma xac nhan
	* @return the number of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaXacNhan(java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* @param SoCmnd the so cmnd
	* @return the number of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countBySoCmnd(java.lang.String SoCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of yeu cau dang ky cong dans.
	*
	* @return the number of yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}