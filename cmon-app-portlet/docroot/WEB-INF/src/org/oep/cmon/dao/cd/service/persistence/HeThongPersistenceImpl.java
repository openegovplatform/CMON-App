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

import org.oep.cmon.dao.cd.NoSuchHeThongException;
import org.oep.cmon.dao.cd.model.HeThong;
import org.oep.cmon.dao.cd.model.impl.HeThongImpl;
import org.oep.cmon.dao.cd.model.impl.HeThongModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the he thong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see HeThongPersistence
 * @see HeThongUtil
 * @generated
 */
public class HeThongPersistenceImpl extends BasePersistenceImpl<HeThong>
	implements HeThongPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HeThongUtil} to access the he thong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HeThongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, HeThongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, HeThongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			HeThongModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, HeThongImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			HeThongModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, HeThongImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] { String.class.getName() },
			HeThongModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, HeThongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, HeThongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the he thong in the entity cache if it is enabled.
	 *
	 * @param heThong the he thong
	 */
	public void cacheResult(HeThong heThong) {
		EntityCacheUtil.putResult(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongImpl.class, heThong.getPrimaryKey(), heThong);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { heThong.getMa() }, heThong);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { heThong.getTen() }, heThong);

		heThong.resetOriginalValues();
	}

	/**
	 * Caches the he thongs in the entity cache if it is enabled.
	 *
	 * @param heThongs the he thongs
	 */
	public void cacheResult(List<HeThong> heThongs) {
		for (HeThong heThong : heThongs) {
			if (EntityCacheUtil.getResult(
						HeThongModelImpl.ENTITY_CACHE_ENABLED,
						HeThongImpl.class, heThong.getPrimaryKey()) == null) {
				cacheResult(heThong);
			}
			else {
				heThong.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all he thongs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HeThongImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HeThongImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the he thong.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HeThong heThong) {
		EntityCacheUtil.removeResult(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongImpl.class, heThong.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(heThong);
	}

	@Override
	public void clearCache(List<HeThong> heThongs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HeThong heThong : heThongs) {
			EntityCacheUtil.removeResult(HeThongModelImpl.ENTITY_CACHE_ENABLED,
				HeThongImpl.class, heThong.getPrimaryKey());

			clearUniqueFindersCache(heThong);
		}
	}

	protected void clearUniqueFindersCache(HeThong heThong) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { heThong.getMa() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { heThong.getTen() });
	}

	/**
	 * Creates a new he thong with the primary key. Does not add the he thong to the database.
	 *
	 * @param id the primary key for the new he thong
	 * @return the new he thong
	 */
	public HeThong create(long id) {
		HeThong heThong = new HeThongImpl();

		heThong.setNew(true);
		heThong.setPrimaryKey(id);

		return heThong;
	}

	/**
	 * Removes the he thong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he thong
	 * @return the he thong that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong remove(long id)
		throws NoSuchHeThongException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the he thong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the he thong
	 * @return the he thong that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HeThong remove(Serializable primaryKey)
		throws NoSuchHeThongException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HeThong heThong = (HeThong)session.get(HeThongImpl.class, primaryKey);

			if (heThong == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHeThongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(heThong);
		}
		catch (NoSuchHeThongException nsee) {
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
	protected HeThong removeImpl(HeThong heThong) throws SystemException {
		heThong = toUnwrappedModel(heThong);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, heThong);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(heThong);

		return heThong;
	}

	@Override
	public HeThong updateImpl(org.oep.cmon.dao.cd.model.HeThong heThong,
		boolean merge) throws SystemException {
		heThong = toUnwrappedModel(heThong);

		boolean isNew = heThong.isNew();

		HeThongModelImpl heThongModelImpl = (HeThongModelImpl)heThong;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, heThong, merge);

			heThong.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HeThongModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((heThongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(heThongModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(heThongModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(HeThongModelImpl.ENTITY_CACHE_ENABLED,
			HeThongImpl.class, heThong.getPrimaryKey(), heThong);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { heThong.getMa() }, heThong);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] { heThong.getTen() }, heThong);
		}
		else {
			if ((heThongModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { heThongModelImpl.getOriginalMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { heThong.getMa() }, heThong);
			}

			if ((heThongModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { heThongModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] { heThong.getTen() }, heThong);
			}
		}

		return heThong;
	}

	protected HeThong toUnwrappedModel(HeThong heThong) {
		if (heThong instanceof HeThongImpl) {
			return heThong;
		}

		HeThongImpl heThongImpl = new HeThongImpl();

		heThongImpl.setNew(heThong.isNew());
		heThongImpl.setPrimaryKey(heThong.getPrimaryKey());

		heThongImpl.setId(heThong.getId());
		heThongImpl.setMa(heThong.getMa());
		heThongImpl.setTen(heThong.getTen());
		heThongImpl.setMoTa(heThong.getMoTa());
		heThongImpl.setNgayTao(heThong.getNgayTao());
		heThongImpl.setDaXoa(heThong.getDaXoa());
		heThongImpl.setNguoiTao(heThong.getNguoiTao());
		heThongImpl.setNguoiSua(heThong.getNguoiSua());
		heThongImpl.setNgaySua(heThong.getNgaySua());
		heThongImpl.setTrangThai(heThong.getTrangThai());

		return heThongImpl;
	}

	/**
	 * Returns the he thong with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the he thong
	 * @return the he thong
	 * @throws com.liferay.portal.NoSuchModelException if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HeThong findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the he thong with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchHeThongException} if it could not be found.
	 *
	 * @param id the primary key of the he thong
	 * @return the he thong
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong findByPrimaryKey(long id)
		throws NoSuchHeThongException, SystemException {
		HeThong heThong = fetchByPrimaryKey(id);

		if (heThong == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHeThongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return heThong;
	}

	/**
	 * Returns the he thong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the he thong
	 * @return the he thong, or <code>null</code> if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HeThong fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the he thong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he thong
	 * @return the he thong, or <code>null</code> if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong fetchByPrimaryKey(long id) throws SystemException {
		HeThong heThong = (HeThong)EntityCacheUtil.getResult(HeThongModelImpl.ENTITY_CACHE_ENABLED,
				HeThongImpl.class, id);

		if (heThong == _nullHeThong) {
			return null;
		}

		if (heThong == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				heThong = (HeThong)session.get(HeThongImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (heThong != null) {
					cacheResult(heThong);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HeThongModelImpl.ENTITY_CACHE_ENABLED,
						HeThongImpl.class, id, _nullHeThong);
				}

				closeSession(session);
			}
		}

		return heThong;
	}

	/**
	 * Returns all the he thongs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeThong> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the he thongs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of he thongs
	 * @param end the upper bound of the range of he thongs (not inclusive)
	 * @return the range of matching he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeThong> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the he thongs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of he thongs
	 * @param end the upper bound of the range of he thongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeThong> findByTrangThai(int daXoa, int start, int end,
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

		List<HeThong> list = (List<HeThong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HETHONG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HeThongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<HeThong>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first he thong in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching he thong
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchHeThongException, SystemException {
		List<HeThong> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHeThongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last he thong in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching he thong
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchHeThongException, SystemException {
		int count = countByTrangThai(daXoa);

		List<HeThong> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHeThongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the he thongs before and after the current he thong in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current he thong
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next he thong
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a he thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchHeThongException, SystemException {
		HeThong heThong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HeThong[] array = new HeThongImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, heThong, daXoa,
					orderByComparator, true);

			array[1] = heThong;

			array[2] = getByTrangThai_PrevAndNext(session, heThong, daXoa,
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

	protected HeThong getByTrangThai_PrevAndNext(Session session,
		HeThong heThong, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HETHONG_WHERE);

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
			query.append(HeThongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(heThong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HeThong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the he thong where ma = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchHeThongException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching he thong
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong findByMa(String ma)
		throws NoSuchHeThongException, SystemException {
		HeThong heThong = fetchByMa(ma);

		if (heThong == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHeThongException(msg.toString());
		}

		return heThong;
	}

	/**
	 * Returns the he thong where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching he thong, or <code>null</code> if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the he thong where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching he thong, or <code>null</code> if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HETHONG_WHERE);

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

			query.append(HeThongModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<HeThong> list = q.list();

				result = list;

				HeThong heThong = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					heThong = list.get(0);

					cacheResult(heThong);

					if ((heThong.getMa() == null) ||
							!heThong.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, heThong);
					}
				}

				return heThong;
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
				return (HeThong)result;
			}
		}
	}

	/**
	 * Returns the he thong where ten = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchHeThongException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching he thong
	 * @throws org.oep.cmon.dao.cd.NoSuchHeThongException if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong findByTen(String ten)
		throws NoSuchHeThongException, SystemException {
		HeThong heThong = fetchByTen(ten);

		if (heThong == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHeThongException(msg.toString());
		}

		return heThong;
	}

	/**
	 * Returns the he thong where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching he thong, or <code>null</code> if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong fetchByTen(String ten) throws SystemException {
		return fetchByTen(ten, true);
	}

	/**
	 * Returns the he thong where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching he thong, or <code>null</code> if a matching he thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeThong fetchByTen(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HETHONG_WHERE);

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

			query.append(HeThongModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<HeThong> list = q.list();

				result = list;

				HeThong heThong = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					heThong = list.get(0);

					cacheResult(heThong);

					if ((heThong.getTen() == null) ||
							!heThong.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, heThong);
					}
				}

				return heThong;
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
				return (HeThong)result;
			}
		}
	}

	/**
	 * Returns all the he thongs.
	 *
	 * @return the he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeThong> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the he thongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of he thongs
	 * @param end the upper bound of the range of he thongs (not inclusive)
	 * @return the range of he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeThong> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the he thongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of he thongs
	 * @param end the upper bound of the range of he thongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeThong> findAll(int start, int end,
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

		List<HeThong> list = (List<HeThong>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HETHONG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HETHONG.concat(HeThongModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HeThong>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HeThong>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the he thongs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (HeThong heThong : findByTrangThai(daXoa)) {
			remove(heThong);
		}
	}

	/**
	 * Removes the he thong where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchHeThongException, SystemException {
		HeThong heThong = findByMa(ma);

		remove(heThong);
	}

	/**
	 * Removes the he thong where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten)
		throws NoSuchHeThongException, SystemException {
		HeThong heThong = findByTen(ten);

		remove(heThong);
	}

	/**
	 * Removes all the he thongs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HeThong heThong : findAll()) {
			remove(heThong);
		}
	}

	/**
	 * Returns the number of he thongs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HETHONG_WHERE);

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
	 * Returns the number of he thongs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HETHONG_WHERE);

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
	 * Returns the number of he thongs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HETHONG_WHERE);

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
	 * Returns the number of he thongs.
	 *
	 * @return the number of he thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HETHONG);

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
	 * Initializes the he thong persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.HeThong")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HeThong>> listenersList = new ArrayList<ModelListener<HeThong>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HeThong>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HeThongImpl.class.getName());
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
	private static final String _SQL_SELECT_HETHONG = "SELECT heThong FROM HeThong heThong";
	private static final String _SQL_SELECT_HETHONG_WHERE = "SELECT heThong FROM HeThong heThong WHERE ";
	private static final String _SQL_COUNT_HETHONG = "SELECT COUNT(heThong) FROM HeThong heThong";
	private static final String _SQL_COUNT_HETHONG_WHERE = "SELECT COUNT(heThong) FROM HeThong heThong WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "heThong.daXoa = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "heThong.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "heThong.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(heThong.ma IS NULL OR heThong.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "heThong.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "heThong.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(heThong.ten IS NULL OR heThong.ten = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "heThong.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HeThong exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HeThong exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HeThongPersistenceImpl.class);
	private static HeThong _nullHeThong = new HeThongImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HeThong> toCacheModel() {
				return _nullHeThongCacheModel;
			}
		};

	private static CacheModel<HeThong> _nullHeThongCacheModel = new CacheModel<HeThong>() {
			public HeThong toEntityModel() {
				return _nullHeThong;
			}
		};
}