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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException;
import org.oep.exch.dao.hoso.model.HoSoMotCua;
import org.oep.exch.dao.hoso.model.impl.HoSoMotCuaImpl;
import org.oep.exch.dao.hoso.model.impl.HoSoMotCuaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho so mot cua service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see HoSoMotCuaPersistence
 * @see HoSoMotCuaUtil
 * @generated
 */
public class HoSoMotCuaPersistenceImpl extends BasePersistenceImpl<HoSoMotCua>
	implements HoSoMotCuaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoSoMotCuaUtil} to access the ho so mot cua persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoSoMotCuaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIXULY =
		new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, HoSoMotCuaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThaiXuLy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY =
		new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, HoSoMotCuaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThaiXuLy",
			new String[] { Integer.class.getName() },
			HoSoMotCuaModelImpl.TRANGTHAIXULY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAIXULY = new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThaiXuLy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOHOSO = new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, HoSoMotCuaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaSoHoSo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO =
		new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, HoSoMotCuaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaSoHoSo",
			new String[] { String.class.getName(), Integer.class.getName() },
			HoSoMotCuaModelImpl.MASOHOSO_COLUMN_BITMASK |
			HoSoMotCuaModelImpl.TRANGTHAIXULY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASOHOSO = new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaSoHoSo",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, HoSoMotCuaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, HoSoMotCuaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho so mot cua in the entity cache if it is enabled.
	 *
	 * @param hoSoMotCua the ho so mot cua
	 */
	public void cacheResult(HoSoMotCua hoSoMotCua) {
		EntityCacheUtil.putResult(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaImpl.class, hoSoMotCua.getPrimaryKey(), hoSoMotCua);

		hoSoMotCua.resetOriginalValues();
	}

	/**
	 * Caches the ho so mot cuas in the entity cache if it is enabled.
	 *
	 * @param hoSoMotCuas the ho so mot cuas
	 */
	public void cacheResult(List<HoSoMotCua> hoSoMotCuas) {
		for (HoSoMotCua hoSoMotCua : hoSoMotCuas) {
			if (EntityCacheUtil.getResult(
						HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
						HoSoMotCuaImpl.class, hoSoMotCua.getPrimaryKey()) == null) {
				cacheResult(hoSoMotCua);
			}
			else {
				hoSoMotCua.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho so mot cuas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoSoMotCuaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoSoMotCuaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho so mot cua.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoSoMotCua hoSoMotCua) {
		EntityCacheUtil.removeResult(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaImpl.class, hoSoMotCua.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HoSoMotCua> hoSoMotCuas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoSoMotCua hoSoMotCua : hoSoMotCuas) {
			EntityCacheUtil.removeResult(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
				HoSoMotCuaImpl.class, hoSoMotCua.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ho so mot cua with the primary key. Does not add the ho so mot cua to the database.
	 *
	 * @param id the primary key for the new ho so mot cua
	 * @return the new ho so mot cua
	 */
	public HoSoMotCua create(long id) {
		HoSoMotCua hoSoMotCua = new HoSoMotCuaImpl();

		hoSoMotCua.setNew(true);
		hoSoMotCua.setPrimaryKey(id);

		return hoSoMotCua;
	}

	/**
	 * Removes the ho so mot cua with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ho so mot cua
	 * @return the ho so mot cua that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoMotCua remove(long id)
		throws NoSuchHoSoMotCuaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ho so mot cua with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho so mot cua
	 * @return the ho so mot cua that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoMotCua remove(Serializable primaryKey)
		throws NoSuchHoSoMotCuaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoSoMotCua hoSoMotCua = (HoSoMotCua)session.get(HoSoMotCuaImpl.class,
					primaryKey);

			if (hoSoMotCua == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoSoMotCuaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoSoMotCua);
		}
		catch (NoSuchHoSoMotCuaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected HoSoMotCua removeImpl(HoSoMotCua hoSoMotCua)
		throws SystemException {
		hoSoMotCua = toUnwrappedModel(hoSoMotCua);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoSoMotCua);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoSoMotCua);

		return hoSoMotCua;
	}

	@Override
	public HoSoMotCua updateImpl(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua, boolean merge)
		throws SystemException {
		hoSoMotCua = toUnwrappedModel(hoSoMotCua);

		boolean isNew = hoSoMotCua.isNew();

		HoSoMotCuaModelImpl hoSoMotCuaModelImpl = (HoSoMotCuaModelImpl)hoSoMotCua;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoSoMotCua, merge);

			hoSoMotCua.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HoSoMotCuaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hoSoMotCuaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(hoSoMotCuaModelImpl.getOriginalTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY,
					args);

				args = new Object[] {
						Integer.valueOf(hoSoMotCuaModelImpl.getTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY,
					args);
			}

			if ((hoSoMotCuaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoMotCuaModelImpl.getOriginalMaSoHoSo(),
						Integer.valueOf(hoSoMotCuaModelImpl.getOriginalTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO,
					args);

				args = new Object[] {
						hoSoMotCuaModelImpl.getMaSoHoSo(),
						Integer.valueOf(hoSoMotCuaModelImpl.getTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO,
					args);
			}
		}

		EntityCacheUtil.putResult(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
			HoSoMotCuaImpl.class, hoSoMotCua.getPrimaryKey(), hoSoMotCua);

		return hoSoMotCua;
	}

	protected HoSoMotCua toUnwrappedModel(HoSoMotCua hoSoMotCua) {
		if (hoSoMotCua instanceof HoSoMotCuaImpl) {
			return hoSoMotCua;
		}

		HoSoMotCuaImpl hoSoMotCuaImpl = new HoSoMotCuaImpl();

		hoSoMotCuaImpl.setNew(hoSoMotCua.isNew());
		hoSoMotCuaImpl.setPrimaryKey(hoSoMotCua.getPrimaryKey());

		hoSoMotCuaImpl.setId(hoSoMotCua.getId());
		hoSoMotCuaImpl.setNgayChuyen(hoSoMotCua.getNgayChuyen());
		hoSoMotCuaImpl.setMaSoHoSo(hoSoMotCua.getMaSoHoSo());
		hoSoMotCuaImpl.setMaLoaiHoSo(hoSoMotCua.getMaLoaiHoSo());
		hoSoMotCuaImpl.setMaDonViTiepNhan(hoSoMotCua.getMaDonViTiepNhan());
		hoSoMotCuaImpl.setNgayNopHoSo(hoSoMotCua.getNgayNopHoSo());
		hoSoMotCuaImpl.setNgayHenTra(hoSoMotCua.getNgayHenTra());
		hoSoMotCuaImpl.setHoTenNguoiNop(hoSoMotCua.getHoTenNguoiNop());
		hoSoMotCuaImpl.setSoCmnd(hoSoMotCua.getSoCmnd());
		hoSoMotCuaImpl.setNgaySinh(hoSoMotCua.getNgaySinh());
		hoSoMotCuaImpl.setMaTinhThuongTru(hoSoMotCua.getMaTinhThuongTru());
		hoSoMotCuaImpl.setMoTaDiaChiThuongTru(hoSoMotCua.getMoTaDiaChiThuongTru());
		hoSoMotCuaImpl.setGioiTinh(hoSoMotCua.getGioiTinh());
		hoSoMotCuaImpl.setMaNguoiTiepNhan(hoSoMotCua.getMaNguoiTiepNhan());
		hoSoMotCuaImpl.setTenNguoiTiepNhan(hoSoMotCua.getTenNguoiTiepNhan());
		hoSoMotCuaImpl.setDonViCungCap(hoSoMotCua.getDonViCungCap());
		hoSoMotCuaImpl.setTrangThaiXuLy(hoSoMotCua.getTrangThaiXuLy());
		hoSoMotCuaImpl.setNgayXuLy(hoSoMotCua.getNgayXuLy());
		hoSoMotCuaImpl.setLoiKhiXuLy(hoSoMotCua.getLoiKhiXuLy());

		return hoSoMotCuaImpl;
	}

	/**
	 * Returns the ho so mot cua with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so mot cua
	 * @return the ho so mot cua
	 * @throws com.liferay.portal.NoSuchModelException if a ho so mot cua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoMotCua findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so mot cua with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException} if it could not be found.
	 *
	 * @param id the primary key of the ho so mot cua
	 * @return the ho so mot cua
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoMotCua findByPrimaryKey(long id)
		throws NoSuchHoSoMotCuaException, SystemException {
		HoSoMotCua hoSoMotCua = fetchByPrimaryKey(id);

		if (hoSoMotCua == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHoSoMotCuaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hoSoMotCua;
	}

	/**
	 * Returns the ho so mot cua with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so mot cua
	 * @return the ho so mot cua, or <code>null</code> if a ho so mot cua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoMotCua fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so mot cua with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ho so mot cua
	 * @return the ho so mot cua, or <code>null</code> if a ho so mot cua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoMotCua fetchByPrimaryKey(long id) throws SystemException {
		HoSoMotCua hoSoMotCua = (HoSoMotCua)EntityCacheUtil.getResult(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
				HoSoMotCuaImpl.class, id);

		if (hoSoMotCua == _nullHoSoMotCua) {
			return null;
		}

		if (hoSoMotCua == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoSoMotCua = (HoSoMotCua)session.get(HoSoMotCuaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoSoMotCua != null) {
					cacheResult(hoSoMotCua);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoSoMotCuaModelImpl.ENTITY_CACHE_ENABLED,
						HoSoMotCuaImpl.class, id, _nullHoSoMotCua);
				}

				closeSession(session);
			}
		}

		return hoSoMotCua;
	}

	/**
	 * Returns all the ho so mot cuas where TrangThaiXuLy = &#63;.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the matching ho so mot cuas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoMotCua> findByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		return findByTrangThaiXuLy(TrangThaiXuLy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<HoSoMotCua> findByTrangThaiXuLy(int TrangThaiXuLy, int start,
		int end) throws SystemException {
		return findByTrangThaiXuLy(TrangThaiXuLy, start, end, null);
	}

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
	public List<HoSoMotCua> findByTrangThaiXuLy(int TrangThaiXuLy, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY;
			finderArgs = new Object[] { TrangThaiXuLy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIXULY;
			finderArgs = new Object[] {
					TrangThaiXuLy,
					
					start, end, orderByComparator
				};
		}

		List<HoSoMotCua> list = (List<HoSoMotCua>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_HOSOMOTCUA_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoMotCuaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TrangThaiXuLy);

				list = (List<HoSoMotCua>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public HoSoMotCua findByTrangThaiXuLy_First(int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoMotCuaException, SystemException {
		List<HoSoMotCua> list = findByTrangThaiXuLy(TrangThaiXuLy, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoMotCuaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public HoSoMotCua findByTrangThaiXuLy_Last(int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoMotCuaException, SystemException {
		int count = countByTrangThaiXuLy(TrangThaiXuLy);

		List<HoSoMotCua> list = findByTrangThaiXuLy(TrangThaiXuLy, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoMotCuaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public HoSoMotCua[] findByTrangThaiXuLy_PrevAndNext(long id,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchHoSoMotCuaException, SystemException {
		HoSoMotCua hoSoMotCua = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoMotCua[] array = new HoSoMotCuaImpl[3];

			array[0] = getByTrangThaiXuLy_PrevAndNext(session, hoSoMotCua,
					TrangThaiXuLy, orderByComparator, true);

			array[1] = hoSoMotCua;

			array[2] = getByTrangThaiXuLy_PrevAndNext(session, hoSoMotCua,
					TrangThaiXuLy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoMotCua getByTrangThaiXuLy_PrevAndNext(Session session,
		HoSoMotCua hoSoMotCua, int TrangThaiXuLy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOMOTCUA_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(HoSoMotCuaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(TrangThaiXuLy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoMotCua);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoMotCua> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * @param MaSoHoSo the ma so ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the matching ho so mot cuas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoMotCua> findByMaSoHoSo(String MaSoHoSo, int TrangThaiXuLy)
		throws SystemException {
		return findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<HoSoMotCua> findByMaSoHoSo(String MaSoHoSo, int TrangThaiXuLy,
		int start, int end) throws SystemException {
		return findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy, start, end, null);
	}

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
	public List<HoSoMotCua> findByMaSoHoSo(String MaSoHoSo, int TrangThaiXuLy,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO;
			finderArgs = new Object[] { MaSoHoSo, TrangThaiXuLy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOHOSO;
			finderArgs = new Object[] {
					MaSoHoSo, TrangThaiXuLy,
					
					start, end, orderByComparator
				};
		}

		List<HoSoMotCua> list = (List<HoSoMotCua>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_HOSOMOTCUA_WHERE);

			if (MaSoHoSo == null) {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_1);
			}
			else {
				if (MaSoHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_2);
				}
			}

			query.append(_FINDER_COLUMN_MASOHOSO_TRANGTHAIXULY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoMotCuaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (MaSoHoSo != null) {
					qPos.add(MaSoHoSo);
				}

				qPos.add(TrangThaiXuLy);

				list = (List<HoSoMotCua>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public HoSoMotCua findByMaSoHoSo_First(String MaSoHoSo, int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoMotCuaException, SystemException {
		List<HoSoMotCua> list = findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MaSoHoSo=");
			msg.append(MaSoHoSo);

			msg.append(", TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoMotCuaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public HoSoMotCua findByMaSoHoSo_Last(String MaSoHoSo, int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoMotCuaException, SystemException {
		int count = countByMaSoHoSo(MaSoHoSo, TrangThaiXuLy);

		List<HoSoMotCua> list = findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MaSoHoSo=");
			msg.append(MaSoHoSo);

			msg.append(", TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoMotCuaException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public HoSoMotCua[] findByMaSoHoSo_PrevAndNext(long id, String MaSoHoSo,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchHoSoMotCuaException, SystemException {
		HoSoMotCua hoSoMotCua = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoMotCua[] array = new HoSoMotCuaImpl[3];

			array[0] = getByMaSoHoSo_PrevAndNext(session, hoSoMotCua, MaSoHoSo,
					TrangThaiXuLy, orderByComparator, true);

			array[1] = hoSoMotCua;

			array[2] = getByMaSoHoSo_PrevAndNext(session, hoSoMotCua, MaSoHoSo,
					TrangThaiXuLy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoMotCua getByMaSoHoSo_PrevAndNext(Session session,
		HoSoMotCua hoSoMotCua, String MaSoHoSo, int TrangThaiXuLy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOMOTCUA_WHERE);

		if (MaSoHoSo == null) {
			query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_1);
		}
		else {
			if (MaSoHoSo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_3);
			}
			else {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_2);
			}
		}

		query.append(_FINDER_COLUMN_MASOHOSO_TRANGTHAIXULY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(HoSoMotCuaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (MaSoHoSo != null) {
			qPos.add(MaSoHoSo);
		}

		qPos.add(TrangThaiXuLy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoMotCua);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoMotCua> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so mot cuas.
	 *
	 * @return the ho so mot cuas
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoMotCua> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<HoSoMotCua> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<HoSoMotCua> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<HoSoMotCua> list = (List<HoSoMotCua>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOSOMOTCUA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOSOMOTCUA.concat(HoSoMotCuaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoSoMotCua>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoSoMotCua>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ho so mot cuas where TrangThaiXuLy = &#63; from the database.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		for (HoSoMotCua hoSoMotCua : findByTrangThaiXuLy(TrangThaiXuLy)) {
			remove(hoSoMotCua);
		}
	}

	/**
	 * Removes all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63; from the database.
	 *
	 * @param MaSoHoSo the ma so ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaSoHoSo(String MaSoHoSo, int TrangThaiXuLy)
		throws SystemException {
		for (HoSoMotCua hoSoMotCua : findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy)) {
			remove(hoSoMotCua);
		}
	}

	/**
	 * Removes all the ho so mot cuas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoSoMotCua hoSoMotCua : findAll()) {
			remove(hoSoMotCua);
		}
	}

	/**
	 * Returns the number of ho so mot cuas where TrangThaiXuLy = &#63;.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the number of matching ho so mot cuas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		Object[] finderArgs = new Object[] { TrangThaiXuLy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOMOTCUA_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TrangThaiXuLy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * @param MaSoHoSo the ma so ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the number of matching ho so mot cuas
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaSoHoSo(String MaSoHoSo, int TrangThaiXuLy)
		throws SystemException {
		Object[] finderArgs = new Object[] { MaSoHoSo, TrangThaiXuLy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MASOHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOMOTCUA_WHERE);

			if (MaSoHoSo == null) {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_1);
			}
			else {
				if (MaSoHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_2);
				}
			}

			query.append(_FINDER_COLUMN_MASOHOSO_TRANGTHAIXULY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (MaSoHoSo != null) {
					qPos.add(MaSoHoSo);
				}

				qPos.add(TrangThaiXuLy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASOHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so mot cuas.
	 *
	 * @return the number of ho so mot cuas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOSOMOTCUA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the ho so mot cua persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.exch.dao.hoso.model.HoSoMotCua")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoSoMotCua>> listenersList = new ArrayList<ModelListener<HoSoMotCua>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoSoMotCua>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(HoSoMotCuaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ExchFileDinhKemPersistence.class)
	protected ExchFileDinhKemPersistence exchFileDinhKemPersistence;
	@BeanReference(type = HoSoMotCuaPersistence.class)
	protected HoSoMotCuaPersistence hoSoMotCuaPersistence;
	@BeanReference(type = HoSoTrucTuyenPersistence.class)
	protected HoSoTrucTuyenPersistence hoSoTrucTuyenPersistence;
	@BeanReference(type = KetQuaHosoPersistence.class)
	protected KetQuaHosoPersistence ketQuaHosoPersistence;
	@BeanReference(type = TrangThaiHosoPersistence.class)
	protected TrangThaiHosoPersistence trangThaiHosoPersistence;
	@BeanReference(type = UpdateHoSoTrucTuyenPersistence.class)
	protected UpdateHoSoTrucTuyenPersistence updateHoSoTrucTuyenPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HOSOMOTCUA = "SELECT hoSoMotCua FROM HoSoMotCua hoSoMotCua";
	private static final String _SQL_SELECT_HOSOMOTCUA_WHERE = "SELECT hoSoMotCua FROM HoSoMotCua hoSoMotCua WHERE ";
	private static final String _SQL_COUNT_HOSOMOTCUA = "SELECT COUNT(hoSoMotCua) FROM HoSoMotCua hoSoMotCua";
	private static final String _SQL_COUNT_HOSOMOTCUA_WHERE = "SELECT COUNT(hoSoMotCua) FROM HoSoMotCua hoSoMotCua WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2 = "hoSoMotCua.TrangThaiXuLy = ?";
	private static final String _FINDER_COLUMN_MASOHOSO_MASOHOSO_1 = "hoSoMotCua.MaSoHoSo IS NULL AND ";
	private static final String _FINDER_COLUMN_MASOHOSO_MASOHOSO_2 = "hoSoMotCua.MaSoHoSo = ? AND ";
	private static final String _FINDER_COLUMN_MASOHOSO_MASOHOSO_3 = "(hoSoMotCua.MaSoHoSo IS NULL OR hoSoMotCua.MaSoHoSo = ?) AND ";
	private static final String _FINDER_COLUMN_MASOHOSO_TRANGTHAIXULY_2 = "hoSoMotCua.TrangThaiXuLy = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoSoMotCua.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoSoMotCua exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HoSoMotCua exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoSoMotCuaPersistenceImpl.class);
	private static HoSoMotCua _nullHoSoMotCua = new HoSoMotCuaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoSoMotCua> toCacheModel() {
				return _nullHoSoMotCuaCacheModel;
			}
		};

	private static CacheModel<HoSoMotCua> _nullHoSoMotCuaCacheModel = new CacheModel<HoSoMotCua>() {
			public HoSoMotCua toEntityModel() {
				return _nullHoSoMotCua;
			}
		};
}