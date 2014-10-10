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

package org.oep.exch.dao.hoso.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.exch.dao.hoso.model.HoSoMotCua;

/**
 * The persistence interface for the ho so mot cua service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see HoSoMotCuaPersistenceImpl
 * @see HoSoMotCuaUtil
 * @generated
 */
public interface HoSoMotCuaPersistence extends BasePersistence<HoSoMotCua> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoMotCuaUtil} to access the ho so mot cua persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ho so mot cua in the entity cache if it is enabled.
	*
	* @param hoSoMotCua the ho so mot cua
	*/
	public void cacheResult(org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua);

	/**
	* Caches the ho so mot cuas in the entity cache if it is enabled.
	*
	* @param hoSoMotCuas the ho so mot cuas
	*/
	public void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> hoSoMotCuas);

	/**
	* Creates a new ho so mot cua with the primary key. Does not add the ho so mot cua to the database.
	*
	* @param id the primary key for the new ho so mot cua
	* @return the new ho so mot cua
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua create(long id);

	/**
	* Removes the ho so mot cua with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	public org.oep.exch.dao.hoso.model.HoSoMotCua updateImpl(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so mot cua with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException} if it could not be found.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns the ho so mot cua with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua, or <code>null</code> if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so mot cua in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua findByTrangThaiXuLy_First(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns the last ho so mot cua in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua findByTrangThaiXuLy_Last(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns the ho so mot cuas before and after the current ho so mot cua in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so mot cua
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua[] findByTrangThaiXuLy_PrevAndNext(
		long id, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String MaSoHoSo, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String MaSoHoSo, int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String MaSoHoSo, int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so mot cua in the ordered set where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua findByMaSoHoSo_First(
		java.lang.String MaSoHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns the last ho so mot cua in the ordered set where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua findByMaSoHoSo_Last(
		java.lang.String MaSoHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns the ho so mot cuas before and after the current ho so mot cua in the ordered set where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so mot cua
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoMotCua[] findByMaSoHoSo_PrevAndNext(
		long id, java.lang.String MaSoHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;

	/**
	* Returns all the ho so mot cuas.
	*
	* @return the ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so mot cuas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so mot cuas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so mot cuas where TrangThaiXuLy = &#63; from the database.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63; from the database.
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaSoHoSo(java.lang.String MaSoHoSo, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so mot cuas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaSoHoSo(java.lang.String MaSoHoSo, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so mot cuas.
	*
	* @return the number of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}