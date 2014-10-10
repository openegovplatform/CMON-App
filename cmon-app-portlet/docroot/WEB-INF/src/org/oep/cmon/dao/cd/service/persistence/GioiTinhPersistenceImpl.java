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

package org.oep.cmon.dao.cd.service.persistence;

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

import org.oep.cmon.dao.cd.NoSuchGioiTinhException;
import org.oep.cmon.dao.cd.model.GioiTinh;
import org.oep.cmon.dao.cd.model.impl.GioiTinhImpl;
import org.oep.cmon.dao.cd.model.impl.GioiTinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the gioi tinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see GioiTinhPersistence
 * @see GioiTinhUtil
 * @generated
 */
public class GioiTinhPersistenceImpl extends BasePersistenceImpl<GioiTinh>
	implements GioiTinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GioiTinhUtil} to access the gioi tinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GioiTinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, GioiTinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, GioiTinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			GioiTinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, GioiTinhImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] { String.class.getName() },
			GioiTinhModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, GioiTinhImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			GioiTinhModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, GioiTinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, GioiTinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the gioi tinh in the entity cache if it is enabled.
	 *
	 * @param gioiTinh the gioi tinh
	 */
	public void cacheResult(GioiTinh gioiTinh) {
		EntityCacheUtil.putResult(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhImpl.class, gioiTinh.getPrimaryKey(), gioiTinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { gioiTinh.getTen() }, gioiTinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { gioiTinh.getMa() }, gioiTinh);

		gioiTinh.resetOriginalValues();
	}

	/**
	 * Caches the gioi tinhs in the entity cache if it is enabled.
	 *
	 * @param gioiTinhs the gioi tinhs
	 */
	public void cacheResult(List<GioiTinh> gioiTinhs) {
		for (GioiTinh gioiTinh : gioiTinhs) {
			if (EntityCacheUtil.getResult(
						GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
						GioiTinhImpl.class, gioiTinh.getPrimaryKey()) == null) {
				cacheResult(gioiTinh);
			}
			else {
				gioiTinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gioi tinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GioiTinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GioiTinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gioi tinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GioiTinh gioiTinh) {
		EntityCacheUtil.removeResult(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhImpl.class, gioiTinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gioiTinh);
	}

	@Override
	public void clearCache(List<GioiTinh> gioiTinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GioiTinh gioiTinh : gioiTinhs) {
			EntityCacheUtil.removeResult(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
				GioiTinhImpl.class, gioiTinh.getPrimaryKey());

			clearUniqueFindersCache(gioiTinh);
		}
	}

	protected void clearUniqueFindersCache(GioiTinh gioiTinh) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { gioiTinh.getTen() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { gioiTinh.getMa() });
	}

	/**
	 * Creates a new gioi tinh with the primary key. Does not add the gioi tinh to the database.
	 *
	 * @param id the primary key for the new gioi tinh
	 * @return the new gioi tinh
	 */
	public GioiTinh create(long id) {
		GioiTinh gioiTinh = new GioiTinhImpl();

		gioiTinh.setNew(true);
		gioiTinh.setPrimaryKey(id);

		return gioiTinh;
	}

	/**
	 * Removes the gioi tinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gioi tinh
	 * @return the gioi tinh that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh remove(long id)
		throws NoSuchGioiTinhException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the gioi tinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gioi tinh
	 * @return the gioi tinh that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GioiTinh remove(Serializable primaryKey)
		throws NoSuchGioiTinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GioiTinh gioiTinh = (GioiTinh)session.get(GioiTinhImpl.class,
					primaryKey);

			if (gioiTinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGioiTinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gioiTinh);
		}
		catch (NoSuchGioiTinhException nsee) {
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
	protected GioiTinh removeImpl(GioiTinh gioiTinh) throws SystemException {
		gioiTinh = toUnwrappedModel(gioiTinh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, gioiTinh);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(gioiTinh);

		return gioiTinh;
	}

	@Override
	public GioiTinh updateImpl(org.oep.cmon.dao.cd.model.GioiTinh gioiTinh,
		boolean merge) throws SystemException {
		gioiTinh = toUnwrappedModel(gioiTinh);

		boolean isNew = gioiTinh.isNew();

		GioiTinhModelImpl gioiTinhModelImpl = (GioiTinhModelImpl)gioiTinh;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, gioiTinh, merge);

			gioiTinh.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GioiTinhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gioiTinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(gioiTinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(gioiTinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
			GioiTinhImpl.class, gioiTinh.getPrimaryKey(), gioiTinh);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] { gioiTinh.getTen() }, gioiTinh);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { gioiTinh.getMa() }, gioiTinh);
		}
		else {
			if ((gioiTinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { gioiTinhModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] { gioiTinh.getTen() }, gioiTinh);
			}

			if ((gioiTinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { gioiTinhModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { gioiTinh.getMa() }, gioiTinh);
			}
		}

		return gioiTinh;
	}

	protected GioiTinh toUnwrappedModel(GioiTinh gioiTinh) {
		if (gioiTinh instanceof GioiTinhImpl) {
			return gioiTinh;
		}

		GioiTinhImpl gioiTinhImpl = new GioiTinhImpl();

		gioiTinhImpl.setNew(gioiTinh.isNew());
		gioiTinhImpl.setPrimaryKey(gioiTinh.getPrimaryKey());

		gioiTinhImpl.setId(gioiTinh.getId());
		gioiTinhImpl.setTen(gioiTinh.getTen());
		gioiTinhImpl.setMa(gioiTinh.getMa());
		gioiTinhImpl.setNgayTao(gioiTinh.getNgayTao());
		gioiTinhImpl.setNguoiTao(gioiTinh.getNguoiTao());
		gioiTinhImpl.setNgaySua(gioiTinh.getNgaySua());
		gioiTinhImpl.setNguoiSua(gioiTinh.getNguoiSua());
		gioiTinhImpl.setDaXoa(gioiTinh.getDaXoa());

		return gioiTinhImpl;
	}

	/**
	 * Returns the gioi tinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gioi tinh
	 * @return the gioi tinh
	 * @throws com.liferay.portal.NoSuchModelException if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GioiTinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the gioi tinh with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchGioiTinhException} if it could not be found.
	 *
	 * @param id the primary key of the gioi tinh
	 * @return the gioi tinh
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh findByPrimaryKey(long id)
		throws NoSuchGioiTinhException, SystemException {
		GioiTinh gioiTinh = fetchByPrimaryKey(id);

		if (gioiTinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchGioiTinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return gioiTinh;
	}

	/**
	 * Returns the gioi tinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gioi tinh
	 * @return the gioi tinh, or <code>null</code> if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GioiTinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the gioi tinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gioi tinh
	 * @return the gioi tinh, or <code>null</code> if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh fetchByPrimaryKey(long id) throws SystemException {
		GioiTinh gioiTinh = (GioiTinh)EntityCacheUtil.getResult(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
				GioiTinhImpl.class, id);

		if (gioiTinh == _nullGioiTinh) {
			return null;
		}

		if (gioiTinh == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				gioiTinh = (GioiTinh)session.get(GioiTinhImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (gioiTinh != null) {
					cacheResult(gioiTinh);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(GioiTinhModelImpl.ENTITY_CACHE_ENABLED,
						GioiTinhImpl.class, id, _nullGioiTinh);
				}

				closeSession(session);
			}
		}

		return gioiTinh;
	}

	/**
	 * Returns all the gioi tinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<GioiTinh> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gioi tinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of gioi tinhs
	 * @param end the upper bound of the range of gioi tinhs (not inclusive)
	 * @return the range of matching gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<GioiTinh> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the gioi tinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of gioi tinhs
	 * @param end the upper bound of the range of gioi tinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<GioiTinh> findByTrangThai(int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<GioiTinh> list = (List<GioiTinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_GIOITINH_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(GioiTinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<GioiTinh>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first gioi tinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gioi tinh
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchGioiTinhException, SystemException {
		List<GioiTinh> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchGioiTinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last gioi tinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gioi tinh
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchGioiTinhException, SystemException {
		int count = countByTrangThai(daXoa);

		List<GioiTinh> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchGioiTinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the gioi tinhs before and after the current gioi tinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current gioi tinh
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gioi tinh
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchGioiTinhException, SystemException {
		GioiTinh gioiTinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			GioiTinh[] array = new GioiTinhImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, gioiTinh, daXoa,
					orderByComparator, true);

			array[1] = gioiTinh;

			array[2] = getByTrangThai_PrevAndNext(session, gioiTinh, daXoa,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GioiTinh getByTrangThai_PrevAndNext(Session session,
		GioiTinh gioiTinh, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GIOITINH_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

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
			query.append(GioiTinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gioiTinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GioiTinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the gioi tinh where ten = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchGioiTinhException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching gioi tinh
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh findByTen(String ten)
		throws NoSuchGioiTinhException, SystemException {
		GioiTinh gioiTinh = fetchByTen(ten);

		if (gioiTinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGioiTinhException(msg.toString());
		}

		return gioiTinh;
	}

	/**
	 * Returns the gioi tinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh fetchByTen(String ten) throws SystemException {
		return fetchByTen(ten, true);
	}

	/**
	 * Returns the gioi tinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh fetchByTen(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GIOITINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			query.append(GioiTinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<GioiTinh> list = q.list();

				result = list;

				GioiTinh gioiTinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					gioiTinh = list.get(0);

					cacheResult(gioiTinh);

					if ((gioiTinh.getTen() == null) ||
							!gioiTinh.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, gioiTinh);
					}
				}

				return gioiTinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (GioiTinh)result;
			}
		}
	}

	/**
	 * Returns the gioi tinh where ma = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchGioiTinhException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching gioi tinh
	 * @throws org.oep.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh findByMa(String ma)
		throws NoSuchGioiTinhException, SystemException {
		GioiTinh gioiTinh = fetchByMa(ma);

		if (gioiTinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGioiTinhException(msg.toString());
		}

		return gioiTinh;
	}

	/**
	 * Returns the gioi tinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the gioi tinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GioiTinh fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GIOITINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			query.append(GioiTinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<GioiTinh> list = q.list();

				result = list;

				GioiTinh gioiTinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					gioiTinh = list.get(0);

					cacheResult(gioiTinh);

					if ((gioiTinh.getMa() == null) ||
							!gioiTinh.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, gioiTinh);
					}
				}

				return gioiTinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (GioiTinh)result;
			}
		}
	}

	/**
	 * Returns all the gioi tinhs.
	 *
	 * @return the gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<GioiTinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gioi tinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of gioi tinhs
	 * @param end the upper bound of the range of gioi tinhs (not inclusive)
	 * @return the range of gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<GioiTinh> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gioi tinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of gioi tinhs
	 * @param end the upper bound of the range of gioi tinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<GioiTinh> findAll(int start, int end,
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

		List<GioiTinh> list = (List<GioiTinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GIOITINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GIOITINH.concat(GioiTinhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<GioiTinh>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<GioiTinh>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the gioi tinhs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (GioiTinh gioiTinh : findByTrangThai(daXoa)) {
			remove(gioiTinh);
		}
	}

	/**
	 * Removes the gioi tinh where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten)
		throws NoSuchGioiTinhException, SystemException {
		GioiTinh gioiTinh = findByTen(ten);

		remove(gioiTinh);
	}

	/**
	 * Removes the gioi tinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchGioiTinhException, SystemException {
		GioiTinh gioiTinh = findByMa(ma);

		remove(gioiTinh);
	}

	/**
	 * Removes all the gioi tinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (GioiTinh gioiTinh : findAll()) {
			remove(gioiTinh);
		}
	}

	/**
	 * Returns the number of gioi tinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GIOITINH_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of gioi tinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GIOITINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of gioi tinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GIOITINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MA, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of gioi tinhs.
	 *
	 * @return the number of gioi tinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GIOITINH);

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
	 * Initializes the gioi tinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.GioiTinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GioiTinh>> listenersList = new ArrayList<ModelListener<GioiTinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GioiTinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GioiTinhImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChuyenMonPersistence.class)
	protected ChuyenMonPersistence chuyenMonPersistence;
	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = HeThongPersistence.class)
	protected HeThongPersistence heThongPersistence;
	@BeanReference(type = HoChieuCMNDPersistence.class)
	protected HoChieuCMNDPersistence hoChieuCMNDPersistence;
	@BeanReference(type = NgheNghiepPersistence.class)
	protected NgheNghiepPersistence ngheNghiepPersistence;
	@BeanReference(type = QuanHeGiaDinhPersistence.class)
	protected QuanHeGiaDinhPersistence quanHeGiaDinhPersistence;
	@BeanReference(type = TinhTrangHonNhanPersistence.class)
	protected TinhTrangHonNhanPersistence tinhTrangHonNhanPersistence;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = TrinhDoChuyenMonPersistence.class)
	protected TrinhDoChuyenMonPersistence trinhDoChuyenMonPersistence;
	@BeanReference(type = TrinhDoHocVanPersistence.class)
	protected TrinhDoHocVanPersistence trinhDoHocVanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_GIOITINH = "SELECT gioiTinh FROM GioiTinh gioiTinh";
	private static final String _SQL_SELECT_GIOITINH_WHERE = "SELECT gioiTinh FROM GioiTinh gioiTinh WHERE ";
	private static final String _SQL_COUNT_GIOITINH = "SELECT COUNT(gioiTinh) FROM GioiTinh gioiTinh";
	private static final String _SQL_COUNT_GIOITINH_WHERE = "SELECT COUNT(gioiTinh) FROM GioiTinh gioiTinh WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "gioiTinh.daXoa = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "gioiTinh.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "gioiTinh.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(gioiTinh.ten IS NULL OR gioiTinh.ten = ?)";
	private static final String _FINDER_COLUMN_MA_MA_1 = "gioiTinh.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "gioiTinh.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(gioiTinh.ma IS NULL OR gioiTinh.ma = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gioiTinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GioiTinh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GioiTinh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GioiTinhPersistenceImpl.class);
	private static GioiTinh _nullGioiTinh = new GioiTinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GioiTinh> toCacheModel() {
				return _nullGioiTinhCacheModel;
			}
		};

	private static CacheModel<GioiTinh> _nullGioiTinhCacheModel = new CacheModel<GioiTinh>() {
			public GioiTinh toEntityModel() {
				return _nullGioiTinh;
			}
		};
}