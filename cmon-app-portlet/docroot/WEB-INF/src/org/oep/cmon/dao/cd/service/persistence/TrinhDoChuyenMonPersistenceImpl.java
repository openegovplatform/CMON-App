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

import org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMon;
import org.oep.cmon.dao.cd.model.impl.TrinhDoChuyenMonImpl;
import org.oep.cmon.dao.cd.model.impl.TrinhDoChuyenMonModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the trinh do chuyen mon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TrinhDoChuyenMonPersistence
 * @see TrinhDoChuyenMonUtil
 * @generated
 */
public class TrinhDoChuyenMonPersistenceImpl extends BasePersistenceImpl<TrinhDoChuyenMon>
	implements TrinhDoChuyenMonPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrinhDoChuyenMonUtil} to access the trinh do chuyen mon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrinhDoChuyenMonImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonModelImpl.FINDER_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonModelImpl.FINDER_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			TrinhDoChuyenMonModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonModelImpl.FINDER_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonModelImpl.FINDER_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the trinh do chuyen mon in the entity cache if it is enabled.
	 *
	 * @param trinhDoChuyenMon the trinh do chuyen mon
	 */
	public void cacheResult(TrinhDoChuyenMon trinhDoChuyenMon) {
		EntityCacheUtil.putResult(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class, trinhDoChuyenMon.getPrimaryKey(),
			trinhDoChuyenMon);

		trinhDoChuyenMon.resetOriginalValues();
	}

	/**
	 * Caches the trinh do chuyen mons in the entity cache if it is enabled.
	 *
	 * @param trinhDoChuyenMons the trinh do chuyen mons
	 */
	public void cacheResult(List<TrinhDoChuyenMon> trinhDoChuyenMons) {
		for (TrinhDoChuyenMon trinhDoChuyenMon : trinhDoChuyenMons) {
			if (EntityCacheUtil.getResult(
						TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
						TrinhDoChuyenMonImpl.class,
						trinhDoChuyenMon.getPrimaryKey()) == null) {
				cacheResult(trinhDoChuyenMon);
			}
			else {
				trinhDoChuyenMon.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trinh do chuyen mons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrinhDoChuyenMonImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrinhDoChuyenMonImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trinh do chuyen mon.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrinhDoChuyenMon trinhDoChuyenMon) {
		EntityCacheUtil.removeResult(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class, trinhDoChuyenMon.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TrinhDoChuyenMon> trinhDoChuyenMons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrinhDoChuyenMon trinhDoChuyenMon : trinhDoChuyenMons) {
			EntityCacheUtil.removeResult(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
				TrinhDoChuyenMonImpl.class, trinhDoChuyenMon.getPrimaryKey());
		}
	}

	/**
	 * Creates a new trinh do chuyen mon with the primary key. Does not add the trinh do chuyen mon to the database.
	 *
	 * @param id the primary key for the new trinh do chuyen mon
	 * @return the new trinh do chuyen mon
	 */
	public TrinhDoChuyenMon create(long id) {
		TrinhDoChuyenMon trinhDoChuyenMon = new TrinhDoChuyenMonImpl();

		trinhDoChuyenMon.setNew(true);
		trinhDoChuyenMon.setPrimaryKey(id);

		return trinhDoChuyenMon;
	}

	/**
	 * Removes the trinh do chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trinh do chuyen mon
	 * @return the trinh do chuyen mon that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrinhDoChuyenMon remove(long id)
		throws NoSuchTrinhDoChuyenMonException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the trinh do chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trinh do chuyen mon
	 * @return the trinh do chuyen mon that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrinhDoChuyenMon remove(Serializable primaryKey)
		throws NoSuchTrinhDoChuyenMonException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrinhDoChuyenMon trinhDoChuyenMon = (TrinhDoChuyenMon)session.get(TrinhDoChuyenMonImpl.class,
					primaryKey);

			if (trinhDoChuyenMon == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrinhDoChuyenMonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trinhDoChuyenMon);
		}
		catch (NoSuchTrinhDoChuyenMonException nsee) {
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
	protected TrinhDoChuyenMon removeImpl(TrinhDoChuyenMon trinhDoChuyenMon)
		throws SystemException {
		trinhDoChuyenMon = toUnwrappedModel(trinhDoChuyenMon);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, trinhDoChuyenMon);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(trinhDoChuyenMon);

		return trinhDoChuyenMon;
	}

	@Override
	public TrinhDoChuyenMon updateImpl(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon,
		boolean merge) throws SystemException {
		trinhDoChuyenMon = toUnwrappedModel(trinhDoChuyenMon);

		boolean isNew = trinhDoChuyenMon.isNew();

		TrinhDoChuyenMonModelImpl trinhDoChuyenMonModelImpl = (TrinhDoChuyenMonModelImpl)trinhDoChuyenMon;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, trinhDoChuyenMon, merge);

			trinhDoChuyenMon.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrinhDoChuyenMonModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trinhDoChuyenMonModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(trinhDoChuyenMonModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(trinhDoChuyenMonModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			TrinhDoChuyenMonImpl.class, trinhDoChuyenMon.getPrimaryKey(),
			trinhDoChuyenMon);

		return trinhDoChuyenMon;
	}

	protected TrinhDoChuyenMon toUnwrappedModel(
		TrinhDoChuyenMon trinhDoChuyenMon) {
		if (trinhDoChuyenMon instanceof TrinhDoChuyenMonImpl) {
			return trinhDoChuyenMon;
		}

		TrinhDoChuyenMonImpl trinhDoChuyenMonImpl = new TrinhDoChuyenMonImpl();

		trinhDoChuyenMonImpl.setNew(trinhDoChuyenMon.isNew());
		trinhDoChuyenMonImpl.setPrimaryKey(trinhDoChuyenMon.getPrimaryKey());

		trinhDoChuyenMonImpl.setId(trinhDoChuyenMon.getId());
		trinhDoChuyenMonImpl.setMa(trinhDoChuyenMon.getMa());
		trinhDoChuyenMonImpl.setTen(trinhDoChuyenMon.getTen());
		trinhDoChuyenMonImpl.setNgayTao(trinhDoChuyenMon.getNgayTao());
		trinhDoChuyenMonImpl.setDaXoa(trinhDoChuyenMon.getDaXoa());
		trinhDoChuyenMonImpl.setChuyenMonId(trinhDoChuyenMon.getChuyenMonId());
		trinhDoChuyenMonImpl.setNguoiTao(trinhDoChuyenMon.getNguoiTao());
		trinhDoChuyenMonImpl.setNguoiSua(trinhDoChuyenMon.getNguoiSua());
		trinhDoChuyenMonImpl.setNgaySua(trinhDoChuyenMon.getNgaySua());
		trinhDoChuyenMonImpl.setPhienBan(trinhDoChuyenMon.getPhienBan());

		return trinhDoChuyenMonImpl;
	}

	/**
	 * Returns the trinh do chuyen mon with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trinh do chuyen mon
	 * @return the trinh do chuyen mon
	 * @throws com.liferay.portal.NoSuchModelException if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrinhDoChuyenMon findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trinh do chuyen mon with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException} if it could not be found.
	 *
	 * @param id the primary key of the trinh do chuyen mon
	 * @return the trinh do chuyen mon
	 * @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrinhDoChuyenMon findByPrimaryKey(long id)
		throws NoSuchTrinhDoChuyenMonException, SystemException {
		TrinhDoChuyenMon trinhDoChuyenMon = fetchByPrimaryKey(id);

		if (trinhDoChuyenMon == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTrinhDoChuyenMonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return trinhDoChuyenMon;
	}

	/**
	 * Returns the trinh do chuyen mon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trinh do chuyen mon
	 * @return the trinh do chuyen mon, or <code>null</code> if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrinhDoChuyenMon fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trinh do chuyen mon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trinh do chuyen mon
	 * @return the trinh do chuyen mon, or <code>null</code> if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrinhDoChuyenMon fetchByPrimaryKey(long id)
		throws SystemException {
		TrinhDoChuyenMon trinhDoChuyenMon = (TrinhDoChuyenMon)EntityCacheUtil.getResult(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
				TrinhDoChuyenMonImpl.class, id);

		if (trinhDoChuyenMon == _nullTrinhDoChuyenMon) {
			return null;
		}

		if (trinhDoChuyenMon == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				trinhDoChuyenMon = (TrinhDoChuyenMon)session.get(TrinhDoChuyenMonImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (trinhDoChuyenMon != null) {
					cacheResult(trinhDoChuyenMon);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TrinhDoChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
						TrinhDoChuyenMonImpl.class, id, _nullTrinhDoChuyenMon);
				}

				closeSession(session);
			}
		}

		return trinhDoChuyenMon;
	}

	/**
	 * Returns all the trinh do chuyen mons where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrinhDoChuyenMon> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trinh do chuyen mons where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of trinh do chuyen mons
	 * @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	 * @return the range of matching trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrinhDoChuyenMon> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trinh do chuyen mons where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of trinh do chuyen mons
	 * @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrinhDoChuyenMon> findByTrangThai(int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TrinhDoChuyenMon> list = (List<TrinhDoChuyenMon>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TRINHDOCHUYENMON_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrinhDoChuyenMonModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TrinhDoChuyenMon>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first trinh do chuyen mon in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trinh do chuyen mon
	 * @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a matching trinh do chuyen mon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrinhDoChuyenMon findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrinhDoChuyenMonException, SystemException {
		List<TrinhDoChuyenMon> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrinhDoChuyenMonException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last trinh do chuyen mon in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trinh do chuyen mon
	 * @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a matching trinh do chuyen mon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrinhDoChuyenMon findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrinhDoChuyenMonException, SystemException {
		int count = countByTrangThai(daXoa);

		List<TrinhDoChuyenMon> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrinhDoChuyenMonException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the trinh do chuyen mons before and after the current trinh do chuyen mon in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current trinh do chuyen mon
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trinh do chuyen mon
	 * @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrinhDoChuyenMon[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrinhDoChuyenMonException, SystemException {
		TrinhDoChuyenMon trinhDoChuyenMon = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrinhDoChuyenMon[] array = new TrinhDoChuyenMonImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, trinhDoChuyenMon,
					daXoa, orderByComparator, true);

			array[1] = trinhDoChuyenMon;

			array[2] = getByTrangThai_PrevAndNext(session, trinhDoChuyenMon,
					daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrinhDoChuyenMon getByTrangThai_PrevAndNext(Session session,
		TrinhDoChuyenMon trinhDoChuyenMon, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRINHDOCHUYENMON_WHERE);

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
			query.append(TrinhDoChuyenMonModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trinhDoChuyenMon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrinhDoChuyenMon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the trinh do chuyen mons.
	 *
	 * @return the trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrinhDoChuyenMon> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trinh do chuyen mons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trinh do chuyen mons
	 * @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	 * @return the range of trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrinhDoChuyenMon> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trinh do chuyen mons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trinh do chuyen mons
	 * @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrinhDoChuyenMon> findAll(int start, int end,
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

		List<TrinhDoChuyenMon> list = (List<TrinhDoChuyenMon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRINHDOCHUYENMON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRINHDOCHUYENMON.concat(TrinhDoChuyenMonModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TrinhDoChuyenMon>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TrinhDoChuyenMon>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the trinh do chuyen mons where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (TrinhDoChuyenMon trinhDoChuyenMon : findByTrangThai(daXoa)) {
			remove(trinhDoChuyenMon);
		}
	}

	/**
	 * Removes all the trinh do chuyen mons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TrinhDoChuyenMon trinhDoChuyenMon : findAll()) {
			remove(trinhDoChuyenMon);
		}
	}

	/**
	 * Returns the number of trinh do chuyen mons where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRINHDOCHUYENMON_WHERE);

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
	 * Returns the number of trinh do chuyen mons.
	 *
	 * @return the number of trinh do chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRINHDOCHUYENMON);

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
	 * Initializes the trinh do chuyen mon persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.TrinhDoChuyenMon")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrinhDoChuyenMon>> listenersList = new ArrayList<ModelListener<TrinhDoChuyenMon>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrinhDoChuyenMon>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrinhDoChuyenMonImpl.class.getName());
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
	private static final String _SQL_SELECT_TRINHDOCHUYENMON = "SELECT trinhDoChuyenMon FROM TrinhDoChuyenMon trinhDoChuyenMon";
	private static final String _SQL_SELECT_TRINHDOCHUYENMON_WHERE = "SELECT trinhDoChuyenMon FROM TrinhDoChuyenMon trinhDoChuyenMon WHERE ";
	private static final String _SQL_COUNT_TRINHDOCHUYENMON = "SELECT COUNT(trinhDoChuyenMon) FROM TrinhDoChuyenMon trinhDoChuyenMon";
	private static final String _SQL_COUNT_TRINHDOCHUYENMON_WHERE = "SELECT COUNT(trinhDoChuyenMon) FROM TrinhDoChuyenMon trinhDoChuyenMon WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "trinhDoChuyenMon.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trinhDoChuyenMon.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrinhDoChuyenMon exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrinhDoChuyenMon exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrinhDoChuyenMonPersistenceImpl.class);
	private static TrinhDoChuyenMon _nullTrinhDoChuyenMon = new TrinhDoChuyenMonImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrinhDoChuyenMon> toCacheModel() {
				return _nullTrinhDoChuyenMonCacheModel;
			}
		};

	private static CacheModel<TrinhDoChuyenMon> _nullTrinhDoChuyenMonCacheModel = new CacheModel<TrinhDoChuyenMon>() {
			public TrinhDoChuyenMon toEntityModel() {
				return _nullTrinhDoChuyenMon;
			}
		};
}