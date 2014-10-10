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

import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;

/**
 * The persistence interface for the doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see DoiTuongSuDungPersistenceImpl
 * @see DoiTuongSuDungUtil
 * @generated
 */
public interface DoiTuongSuDungPersistence extends BasePersistence<DoiTuongSuDung> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoiTuongSuDungUtil} to access the doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the doi tuong su dung in the entity cache if it is enabled.
	*
	* @param doiTuongSuDung the doi tuong su dung
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung);

	/**
	* Caches the doi tuong su dungs in the entity cache if it is enabled.
	*
	* @param doiTuongSuDungs the doi tuong su dungs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> doiTuongSuDungs);

	/**
	* Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	*
	* @param id the primary key for the new doi tuong su dung
	* @return the new doi tuong su dung
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung create(long id);

	/**
	* Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException} if it could not be found.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @return the range of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Returns the last doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Returns the doi tuong su dungs before and after the current doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current doi tuong su dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Returns the doi tuong su dung where ten = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Returns the doi tuong su dung where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doi tuong su dung where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doi tuong su dung where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the doi tuong su dungs.
	*
	* @return the doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @return the range of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the doi tuong su dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the doi tuong su dung where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Removes the doi tuong su dung where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException;

	/**
	* Removes all the doi tuong su dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doi tuong su dungs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doi tuong su dungs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doi tuong su dungs.
	*
	* @return the number of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}