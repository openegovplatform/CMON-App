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

package org.oep.cmon.dao.thamso.service.persistence;

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

import org.oep.cmon.dao.thamso.NoSuchThamSoException;
import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.model.impl.ThamSoImpl;
import org.oep.cmon.dao.thamso.model.impl.ThamSoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tham so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ThamSoPersistence
 * @see ThamSoUtil
 * @generated
 */
public class ThamSoPersistenceImpl extends BasePersistenceImpl<ThamSo>
	implements ThamSoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThamSoUtil} to access the tham so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThamSoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] { String.class.getName() },
			ThamSoModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DAXOA = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDaXoa",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDaXoa",
			new String[] { Integer.class.getName() },
			ThamSoModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DAXOA = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDaXoa",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_GIATRI = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGiaTri",
			new String[] { String.class.getName() },
			ThamSoModelImpl.GIATRI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GIATRI = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiaTri",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tham so in the entity cache if it is enabled.
	 *
	 * @param thamSo the tham so
	 */
	public void cacheResult(ThamSo thamSo) {
		EntityCacheUtil.putResult(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoImpl.class, thamSo.getPrimaryKey(), thamSo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { thamSo.getTen() }, thamSo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GIATRI,
			new Object[] { thamSo.getGiaTri() }, thamSo);

		thamSo.resetOriginalValues();
	}

	/**
	 * Caches the tham sos in the entity cache if it is enabled.
	 *
	 * @param thamSos the tham sos
	 */
	public void cacheResult(List<ThamSo> thamSos) {
		for (ThamSo thamSo : thamSos) {
			if (EntityCacheUtil.getResult(
						ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
						thamSo.getPrimaryKey()) == null) {
				cacheResult(thamSo);
			}
			else {
				thamSo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tham sos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThamSoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThamSoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tham so.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThamSo thamSo) {
		EntityCacheUtil.removeResult(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoImpl.class, thamSo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(thamSo);
	}

	@Override
	public void clearCache(List<ThamSo> thamSos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThamSo thamSo : thamSos) {
			EntityCacheUtil.removeResult(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
				ThamSoImpl.class, thamSo.getPrimaryKey());

			clearUniqueFindersCache(thamSo);
		}
	}

	protected void clearUniqueFindersCache(ThamSo thamSo) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { thamSo.getTen() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GIATRI,
			new Object[] { thamSo.getGiaTri() });
	}

	/**
	 * Creates a new tham so with the primary key. Does not add the tham so to the database.
	 *
	 * @param Id the primary key for the new tham so
	 * @return the new tham so
	 */
	public ThamSo create(long Id) {
		ThamSo thamSo = new ThamSoImpl();

		thamSo.setNew(true);
		thamSo.setPrimaryKey(Id);

		return thamSo;
	}

	/**
	 * Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo remove(long Id) throws NoSuchThamSoException, SystemException {
		return remove(Long.valueOf(Id));
	}

	/**
	 * Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThamSo remove(Serializable primaryKey)
		throws NoSuchThamSoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThamSo thamSo = (ThamSo)session.get(ThamSoImpl.class, primaryKey);

			if (thamSo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThamSoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thamSo);
		}
		catch (NoSuchThamSoException nsee) {
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
	protected ThamSo removeImpl(ThamSo thamSo) throws SystemException {
		thamSo = toUnwrappedModel(thamSo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, thamSo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(thamSo);

		return thamSo;
	}

	@Override
	public ThamSo updateImpl(org.oep.cmon.dao.thamso.model.ThamSo thamSo,
		boolean merge) throws SystemException {
		thamSo = toUnwrappedModel(thamSo);

		boolean isNew = thamSo.isNew();

		ThamSoModelImpl thamSoModelImpl = (ThamSoModelImpl)thamSo;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, thamSo, merge);

			thamSo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThamSoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thamSoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(thamSoModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAXOA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA,
					args);

				args = new Object[] { Integer.valueOf(thamSoModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAXOA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA,
					args);
			}
		}

		EntityCacheUtil.putResult(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoImpl.class, thamSo.getPrimaryKey(), thamSo);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] { thamSo.getTen() }, thamSo);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GIATRI,
				new Object[] { thamSo.getGiaTri() }, thamSo);
		}
		else {
			if ((thamSoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { thamSoModelImpl.getOriginalTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] { thamSo.getTen() }, thamSo);
			}

			if ((thamSoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GIATRI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { thamSoModelImpl.getOriginalGiaTri() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GIATRI, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GIATRI, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GIATRI,
					new Object[] { thamSo.getGiaTri() }, thamSo);
			}
		}

		return thamSo;
	}

	protected ThamSo toUnwrappedModel(ThamSo thamSo) {
		if (thamSo instanceof ThamSoImpl) {
			return thamSo;
		}

		ThamSoImpl thamSoImpl = new ThamSoImpl();

		thamSoImpl.setNew(thamSo.isNew());
		thamSoImpl.setPrimaryKey(thamSo.getPrimaryKey());

		thamSoImpl.setId(thamSo.getId());
		thamSoImpl.setTen(thamSo.getTen());
		thamSoImpl.setGiaTri(thamSo.getGiaTri());
		thamSoImpl.setKieuDuLieu(thamSo.getKieuDuLieu());
		thamSoImpl.setMota(thamSo.getMota());
		thamSoImpl.setUngDungId(thamSo.getUngDungId());
		thamSoImpl.setHeThongId(thamSo.getHeThongId());
		thamSoImpl.setNgayTao(thamSo.getNgayTao());
		thamSoImpl.setNguoiTao(thamSo.getNguoiTao());
		thamSoImpl.setNgaySua(thamSo.getNgaySua());
		thamSoImpl.setNguoiSua(thamSo.getNguoiSua());
		thamSoImpl.setDaXoa(thamSo.getDaXoa());

		return thamSoImpl;
	}

	/**
	 * Returns the tham so with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tham so
	 * @return the tham so
	 * @throws com.liferay.portal.NoSuchModelException if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThamSo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tham so with the primary key or throws a {@link org.oep.cmon.dao.thamso.NoSuchThamSoException} if it could not be found.
	 *
	 * @param Id the primary key of the tham so
	 * @return the tham so
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo findByPrimaryKey(long Id)
		throws NoSuchThamSoException, SystemException {
		ThamSo thamSo = fetchByPrimaryKey(Id);

		if (thamSo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + Id);
			}

			throw new NoSuchThamSoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				Id);
		}

		return thamSo;
	}

	/**
	 * Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tham so
	 * @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThamSo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the tham so
	 * @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo fetchByPrimaryKey(long Id) throws SystemException {
		ThamSo thamSo = (ThamSo)EntityCacheUtil.getResult(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
				ThamSoImpl.class, Id);

		if (thamSo == _nullThamSo) {
			return null;
		}

		if (thamSo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				thamSo = (ThamSo)session.get(ThamSoImpl.class, Long.valueOf(Id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (thamSo != null) {
					cacheResult(thamSo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ThamSoModelImpl.ENTITY_CACHE_ENABLED,
						ThamSoImpl.class, Id, _nullThamSo);
				}

				closeSession(session);
			}
		}

		return thamSo;
	}

	/**
	 * Returns the tham so where Ten = &#63; or throws a {@link org.oep.cmon.dao.thamso.NoSuchThamSoException} if it could not be found.
	 *
	 * @param Ten the ten
	 * @return the matching tham so
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo findByTen(String Ten)
		throws NoSuchThamSoException, SystemException {
		ThamSo thamSo = fetchByTen(Ten);

		if (thamSo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Ten=");
			msg.append(Ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchThamSoException(msg.toString());
		}

		return thamSo;
	}

	/**
	 * Returns the tham so where Ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Ten the ten
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo fetchByTen(String Ten) throws SystemException {
		return fetchByTen(Ten, true);
	}

	/**
	 * Returns the tham so where Ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo fetchByTen(String Ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { Ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THAMSO_WHERE);

			if (Ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (Ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			query.append(ThamSoModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Ten != null) {
					qPos.add(Ten);
				}

				List<ThamSo> list = q.list();

				result = list;

				ThamSo thamSo = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					thamSo = list.get(0);

					cacheResult(thamSo);

					if ((thamSo.getTen() == null) ||
							!thamSo.getTen().equals(Ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, thamSo);
					}
				}

				return thamSo;
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
				return (ThamSo)result;
			}
		}
	}

	/**
	 * Returns all the tham sos where DaXoa = &#63;.
	 *
	 * @param DaXoa the da xoa
	 * @return the matching tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThamSo> findByDaXoa(int DaXoa) throws SystemException {
		return findByDaXoa(DaXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham sos where DaXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param DaXoa the da xoa
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThamSo> findByDaXoa(int DaXoa, int start, int end)
		throws SystemException {
		return findByDaXoa(DaXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham sos where DaXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param DaXoa the da xoa
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThamSo> findByDaXoa(int DaXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA;
			finderArgs = new Object[] { DaXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DAXOA;
			finderArgs = new Object[] { DaXoa, start, end, orderByComparator };
		}

		List<ThamSo> list = (List<ThamSo>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_THAMSO_WHERE);

			query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThamSoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DaXoa);

				list = (List<ThamSo>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first tham so in the ordered set where DaXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param DaXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo findByDaXoa_First(int DaXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThamSoException, SystemException {
		List<ThamSo> list = findByDaXoa(DaXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("DaXoa=");
			msg.append(DaXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThamSoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tham so in the ordered set where DaXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param DaXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo findByDaXoa_Last(int DaXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThamSoException, SystemException {
		int count = countByDaXoa(DaXoa);

		List<ThamSo> list = findByDaXoa(DaXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("DaXoa=");
			msg.append(DaXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThamSoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where DaXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Id the primary key of the current tham so
	 * @param DaXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo[] findByDaXoa_PrevAndNext(long Id, int DaXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThamSoException, SystemException {
		ThamSo thamSo = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			ThamSo[] array = new ThamSoImpl[3];

			array[0] = getByDaXoa_PrevAndNext(session, thamSo, DaXoa,
					orderByComparator, true);

			array[1] = thamSo;

			array[2] = getByDaXoa_PrevAndNext(session, thamSo, DaXoa,
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

	protected ThamSo getByDaXoa_PrevAndNext(Session session, ThamSo thamSo,
		int DaXoa, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THAMSO_WHERE);

		query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

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
			query.append(ThamSoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(DaXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thamSo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThamSo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the tham so where giaTri = &#63; or throws a {@link org.oep.cmon.dao.thamso.NoSuchThamSoException} if it could not be found.
	 *
	 * @param giaTri the gia tri
	 * @return the matching tham so
	 * @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo findByGiaTri(String giaTri)
		throws NoSuchThamSoException, SystemException {
		ThamSo thamSo = fetchByGiaTri(giaTri);

		if (thamSo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("giaTri=");
			msg.append(giaTri);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchThamSoException(msg.toString());
		}

		return thamSo;
	}

	/**
	 * Returns the tham so where giaTri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param giaTri the gia tri
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo fetchByGiaTri(String giaTri) throws SystemException {
		return fetchByGiaTri(giaTri, true);
	}

	/**
	 * Returns the tham so where giaTri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param giaTri the gia tri
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThamSo fetchByGiaTri(String giaTri, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { giaTri };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GIATRI,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THAMSO_WHERE);

			if (giaTri == null) {
				query.append(_FINDER_COLUMN_GIATRI_GIATRI_1);
			}
			else {
				if (giaTri.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GIATRI_GIATRI_3);
				}
				else {
					query.append(_FINDER_COLUMN_GIATRI_GIATRI_2);
				}
			}

			query.append(ThamSoModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (giaTri != null) {
					qPos.add(giaTri);
				}

				List<ThamSo> list = q.list();

				result = list;

				ThamSo thamSo = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GIATRI,
						finderArgs, list);
				}
				else {
					thamSo = list.get(0);

					cacheResult(thamSo);

					if ((thamSo.getGiaTri() == null) ||
							!thamSo.getGiaTri().equals(giaTri)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GIATRI,
							finderArgs, thamSo);
					}
				}

				return thamSo;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GIATRI,
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
				return (ThamSo)result;
			}
		}
	}

	/**
	 * Returns all the tham sos.
	 *
	 * @return the tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThamSo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThamSo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThamSo> findAll(int start, int end,
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

		List<ThamSo> list = (List<ThamSo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THAMSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THAMSO.concat(ThamSoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ThamSo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ThamSo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes the tham so where Ten = &#63; from the database.
	 *
	 * @param Ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String Ten)
		throws NoSuchThamSoException, SystemException {
		ThamSo thamSo = findByTen(Ten);

		remove(thamSo);
	}

	/**
	 * Removes all the tham sos where DaXoa = &#63; from the database.
	 *
	 * @param DaXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDaXoa(int DaXoa) throws SystemException {
		for (ThamSo thamSo : findByDaXoa(DaXoa)) {
			remove(thamSo);
		}
	}

	/**
	 * Removes the tham so where giaTri = &#63; from the database.
	 *
	 * @param giaTri the gia tri
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGiaTri(String giaTri)
		throws NoSuchThamSoException, SystemException {
		ThamSo thamSo = findByGiaTri(giaTri);

		remove(thamSo);
	}

	/**
	 * Removes all the tham sos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ThamSo thamSo : findAll()) {
			remove(thamSo);
		}
	}

	/**
	 * Returns the number of tham sos where Ten = &#63;.
	 *
	 * @param Ten the ten
	 * @return the number of matching tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String Ten) throws SystemException {
		Object[] finderArgs = new Object[] { Ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			if (Ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (Ten.equals(StringPool.BLANK)) {
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

				if (Ten != null) {
					qPos.add(Ten);
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
	 * Returns the number of tham sos where DaXoa = &#63;.
	 *
	 * @param DaXoa the da xoa
	 * @return the number of matching tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDaXoa(int DaXoa) throws SystemException {
		Object[] finderArgs = new Object[] { DaXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DaXoa);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the number of matching tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGiaTri(String giaTri) throws SystemException {
		Object[] finderArgs = new Object[] { giaTri };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GIATRI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			if (giaTri == null) {
				query.append(_FINDER_COLUMN_GIATRI_GIATRI_1);
			}
			else {
				if (giaTri.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GIATRI_GIATRI_3);
				}
				else {
					query.append(_FINDER_COLUMN_GIATRI_GIATRI_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (giaTri != null) {
					qPos.add(giaTri);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GIATRI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tham sos.
	 *
	 * @return the number of tham sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THAMSO);

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
	 * Initializes the tham so persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.thamso.model.ThamSo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThamSo>> listenersList = new ArrayList<ModelListener<ThamSo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThamSo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ThamSoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnhXaPersistence.class)
	protected AnhXaPersistence anhXaPersistence;
	@BeanReference(type = ThamSoPersistence.class)
	protected ThamSoPersistence thamSoPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_THAMSO = "SELECT thamSo FROM ThamSo thamSo";
	private static final String _SQL_SELECT_THAMSO_WHERE = "SELECT thamSo FROM ThamSo thamSo WHERE ";
	private static final String _SQL_COUNT_THAMSO = "SELECT COUNT(thamSo) FROM ThamSo thamSo";
	private static final String _SQL_COUNT_THAMSO_WHERE = "SELECT COUNT(thamSo) FROM ThamSo thamSo WHERE ";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "thamSo.Ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "thamSo.Ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(thamSo.Ten IS NULL OR thamSo.Ten = ?)";
	private static final String _FINDER_COLUMN_DAXOA_DAXOA_2 = "thamSo.DaXoa = ?";
	private static final String _FINDER_COLUMN_GIATRI_GIATRI_1 = "thamSo.giaTri IS NULL AND daXoa = 0";
	private static final String _FINDER_COLUMN_GIATRI_GIATRI_2 = "thamSo.giaTri = ? AND daXoa = 0";
	private static final String _FINDER_COLUMN_GIATRI_GIATRI_3 = "(thamSo.giaTri IS NULL OR thamSo.giaTri = ?) AND daXoa = 0";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thamSo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThamSo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThamSo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThamSoPersistenceImpl.class);
	private static ThamSo _nullThamSo = new ThamSoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ThamSo> toCacheModel() {
				return _nullThamSoCacheModel;
			}
		};

	private static CacheModel<ThamSo> _nullThamSoCacheModel = new CacheModel<ThamSo>() {
			public ThamSo toEntityModel() {
				return _nullThamSo;
			}
		};
}