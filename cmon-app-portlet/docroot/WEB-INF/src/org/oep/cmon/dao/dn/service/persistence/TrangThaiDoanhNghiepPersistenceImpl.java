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

package org.oep.cmon.dao.dn.service.persistence;

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

import org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException;
import org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep;
import org.oep.cmon.dao.dn.model.impl.TrangThaiDoanhNghiepImpl;
import org.oep.cmon.dao.dn.model.impl.TrangThaiDoanhNghiepModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the trang thai doanh nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TrangThaiDoanhNghiepPersistence
 * @see TrangThaiDoanhNghiepUtil
 * @generated
 */
public class TrangThaiDoanhNghiepPersistenceImpl extends BasePersistenceImpl<TrangThaiDoanhNghiep>
	implements TrangThaiDoanhNghiepPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrangThaiDoanhNghiepUtil} to access the trang thai doanh nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrangThaiDoanhNghiepImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchById", new String[] { Long.class.getName() },
			TrangThaiDoanhNghiepModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DAXOA = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDaXoa",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDaXoa",
			new String[] { Integer.class.getName() },
			TrangThaiDoanhNghiepModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DAXOA = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDaXoa",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the trang thai doanh nghiep in the entity cache if it is enabled.
	 *
	 * @param trangThaiDoanhNghiep the trang thai doanh nghiep
	 */
	public void cacheResult(TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		EntityCacheUtil.putResult(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class,
			trangThaiDoanhNghiep.getPrimaryKey(), trangThaiDoanhNghiep);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(trangThaiDoanhNghiep.getId()) },
			trangThaiDoanhNghiep);

		trangThaiDoanhNghiep.resetOriginalValues();
	}

	/**
	 * Caches the trang thai doanh nghieps in the entity cache if it is enabled.
	 *
	 * @param trangThaiDoanhNghieps the trang thai doanh nghieps
	 */
	public void cacheResult(List<TrangThaiDoanhNghiep> trangThaiDoanhNghieps) {
		for (TrangThaiDoanhNghiep trangThaiDoanhNghiep : trangThaiDoanhNghieps) {
			if (EntityCacheUtil.getResult(
						TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiDoanhNghiepImpl.class,
						trangThaiDoanhNghiep.getPrimaryKey()) == null) {
				cacheResult(trangThaiDoanhNghiep);
			}
			else {
				trangThaiDoanhNghiep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trang thai doanh nghieps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrangThaiDoanhNghiepImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrangThaiDoanhNghiepImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trang thai doanh nghiep.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		EntityCacheUtil.removeResult(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class, trangThaiDoanhNghiep.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(trangThaiDoanhNghiep);
	}

	@Override
	public void clearCache(List<TrangThaiDoanhNghiep> trangThaiDoanhNghieps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrangThaiDoanhNghiep trangThaiDoanhNghiep : trangThaiDoanhNghieps) {
			EntityCacheUtil.removeResult(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiDoanhNghiepImpl.class,
				trangThaiDoanhNghiep.getPrimaryKey());

			clearUniqueFindersCache(trangThaiDoanhNghiep);
		}
	}

	protected void clearUniqueFindersCache(
		TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(trangThaiDoanhNghiep.getId()) });
	}

	/**
	 * Creates a new trang thai doanh nghiep with the primary key. Does not add the trang thai doanh nghiep to the database.
	 *
	 * @param id the primary key for the new trang thai doanh nghiep
	 * @return the new trang thai doanh nghiep
	 */
	public TrangThaiDoanhNghiep create(long id) {
		TrangThaiDoanhNghiep trangThaiDoanhNghiep = new TrangThaiDoanhNghiepImpl();

		trangThaiDoanhNghiep.setNew(true);
		trangThaiDoanhNghiep.setPrimaryKey(id);

		return trangThaiDoanhNghiep;
	}

	/**
	 * Removes the trang thai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trang thai doanh nghiep
	 * @return the trang thai doanh nghiep that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep remove(long id)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the trang thai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trang thai doanh nghiep
	 * @return the trang thai doanh nghiep that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiDoanhNghiep remove(Serializable primaryKey)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrangThaiDoanhNghiep trangThaiDoanhNghiep = (TrangThaiDoanhNghiep)session.get(TrangThaiDoanhNghiepImpl.class,
					primaryKey);

			if (trangThaiDoanhNghiep == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrangThaiDoanhNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trangThaiDoanhNghiep);
		}
		catch (NoSuchTrangThaiDoanhNghiepException nsee) {
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
	protected TrangThaiDoanhNghiep removeImpl(
		TrangThaiDoanhNghiep trangThaiDoanhNghiep) throws SystemException {
		trangThaiDoanhNghiep = toUnwrappedModel(trangThaiDoanhNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, trangThaiDoanhNghiep);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(trangThaiDoanhNghiep);

		return trangThaiDoanhNghiep;
	}

	@Override
	public TrangThaiDoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep,
		boolean merge) throws SystemException {
		trangThaiDoanhNghiep = toUnwrappedModel(trangThaiDoanhNghiep);

		boolean isNew = trangThaiDoanhNghiep.isNew();

		TrangThaiDoanhNghiepModelImpl trangThaiDoanhNghiepModelImpl = (TrangThaiDoanhNghiepModelImpl)trangThaiDoanhNghiep;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, trangThaiDoanhNghiep, merge);

			trangThaiDoanhNghiep.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrangThaiDoanhNghiepModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trangThaiDoanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(trangThaiDoanhNghiepModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAXOA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA,
					args);

				args = new Object[] {
						Integer.valueOf(trangThaiDoanhNghiepModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAXOA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA,
					args);
			}
		}

		EntityCacheUtil.putResult(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiDoanhNghiepImpl.class,
			trangThaiDoanhNghiep.getPrimaryKey(), trangThaiDoanhNghiep);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
				new Object[] { Long.valueOf(trangThaiDoanhNghiep.getId()) },
				trangThaiDoanhNghiep);
		}
		else {
			if ((trangThaiDoanhNghiepModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(trangThaiDoanhNghiepModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
					new Object[] { Long.valueOf(trangThaiDoanhNghiep.getId()) },
					trangThaiDoanhNghiep);
			}
		}

		return trangThaiDoanhNghiep;
	}

	protected TrangThaiDoanhNghiep toUnwrappedModel(
		TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		if (trangThaiDoanhNghiep instanceof TrangThaiDoanhNghiepImpl) {
			return trangThaiDoanhNghiep;
		}

		TrangThaiDoanhNghiepImpl trangThaiDoanhNghiepImpl = new TrangThaiDoanhNghiepImpl();

		trangThaiDoanhNghiepImpl.setNew(trangThaiDoanhNghiep.isNew());
		trangThaiDoanhNghiepImpl.setPrimaryKey(trangThaiDoanhNghiep.getPrimaryKey());

		trangThaiDoanhNghiepImpl.setId(trangThaiDoanhNghiep.getId());
		trangThaiDoanhNghiepImpl.setTen(trangThaiDoanhNghiep.getTen());
		trangThaiDoanhNghiepImpl.setMoTa(trangThaiDoanhNghiep.getMoTa());
		trangThaiDoanhNghiepImpl.setNguoiTao(trangThaiDoanhNghiep.getNguoiTao());
		trangThaiDoanhNghiepImpl.setNgayTao(trangThaiDoanhNghiep.getNgayTao());
		trangThaiDoanhNghiepImpl.setNguoiSua(trangThaiDoanhNghiep.getNguoiSua());
		trangThaiDoanhNghiepImpl.setNgaySua(trangThaiDoanhNghiep.getNgaySua());
		trangThaiDoanhNghiepImpl.setDaXoa(trangThaiDoanhNghiep.getDaXoa());

		return trangThaiDoanhNghiepImpl;
	}

	/**
	 * Returns the trang thai doanh nghiep with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai doanh nghiep
	 * @return the trang thai doanh nghiep
	 * @throws com.liferay.portal.NoSuchModelException if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiDoanhNghiep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException} if it could not be found.
	 *
	 * @param id the primary key of the trang thai doanh nghiep
	 * @return the trang thai doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep findByPrimaryKey(long id)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		TrangThaiDoanhNghiep trangThaiDoanhNghiep = fetchByPrimaryKey(id);

		if (trangThaiDoanhNghiep == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTrangThaiDoanhNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return trangThaiDoanhNghiep;
	}

	/**
	 * Returns the trang thai doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai doanh nghiep
	 * @return the trang thai doanh nghiep, or <code>null</code> if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiDoanhNghiep fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trang thai doanh nghiep
	 * @return the trang thai doanh nghiep, or <code>null</code> if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep fetchByPrimaryKey(long id)
		throws SystemException {
		TrangThaiDoanhNghiep trangThaiDoanhNghiep = (TrangThaiDoanhNghiep)EntityCacheUtil.getResult(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiDoanhNghiepImpl.class, id);

		if (trangThaiDoanhNghiep == _nullTrangThaiDoanhNghiep) {
			return null;
		}

		if (trangThaiDoanhNghiep == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				trangThaiDoanhNghiep = (TrangThaiDoanhNghiep)session.get(TrangThaiDoanhNghiepImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (trangThaiDoanhNghiep != null) {
					cacheResult(trangThaiDoanhNghiep);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TrangThaiDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiDoanhNghiepImpl.class, id,
						_nullTrangThaiDoanhNghiep);
				}

				closeSession(session);
			}
		}

		return trangThaiDoanhNghiep;
	}

	/**
	 * Returns the trang thai doanh nghiep where id = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching trang thai doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a matching trang thai doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep findById(long id)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		TrangThaiDoanhNghiep trangThaiDoanhNghiep = fetchById(id);

		if (trangThaiDoanhNghiep == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrangThaiDoanhNghiepException(msg.toString());
		}

		return trangThaiDoanhNghiep;
	}

	/**
	 * Returns the trang thai doanh nghiep where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching trang thai doanh nghiep, or <code>null</code> if a matching trang thai doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep fetchById(long id) throws SystemException {
		return fetchById(id, true);
	}

	/**
	 * Returns the trang thai doanh nghiep where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trang thai doanh nghiep, or <code>null</code> if a matching trang thai doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep fetchById(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRANGTHAIDOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			query.append(TrangThaiDoanhNghiepModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<TrangThaiDoanhNghiep> list = q.list();

				result = list;

				TrangThaiDoanhNghiep trangThaiDoanhNghiep = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					trangThaiDoanhNghiep = list.get(0);

					cacheResult(trangThaiDoanhNghiep);

					if ((trangThaiDoanhNghiep.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, trangThaiDoanhNghiep);
					}
				}

				return trangThaiDoanhNghiep;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
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
				return (TrangThaiDoanhNghiep)result;
			}
		}
	}

	/**
	 * Returns all the trang thai doanh nghieps where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiDoanhNghiep> findByDaXoa(int daXoa)
		throws SystemException {
		return findByDaXoa(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai doanh nghieps where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of trang thai doanh nghieps
	 * @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	 * @return the range of matching trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiDoanhNghiep> findByDaXoa(int daXoa, int start, int end)
		throws SystemException {
		return findByDaXoa(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai doanh nghieps where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of trang thai doanh nghieps
	 * @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiDoanhNghiep> findByDaXoa(int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DAXOA;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DAXOA;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<TrangThaiDoanhNghiep> list = (List<TrangThaiDoanhNghiep>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TRANGTHAIDOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrangThaiDoanhNghiepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TrangThaiDoanhNghiep>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first trang thai doanh nghiep in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a matching trang thai doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep findByDaXoa_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		List<TrangThaiDoanhNghiep> list = findByDaXoa(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiDoanhNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last trang thai doanh nghiep in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a matching trang thai doanh nghiep could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep findByDaXoa_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		int count = countByDaXoa(daXoa);

		List<TrangThaiDoanhNghiep> list = findByDaXoa(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiDoanhNghiepException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the trang thai doanh nghieps before and after the current trang thai doanh nghiep in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current trang thai doanh nghiep
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trang thai doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiDoanhNghiep[] findByDaXoa_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		TrangThaiDoanhNghiep trangThaiDoanhNghiep = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrangThaiDoanhNghiep[] array = new TrangThaiDoanhNghiepImpl[3];

			array[0] = getByDaXoa_PrevAndNext(session, trangThaiDoanhNghiep,
					daXoa, orderByComparator, true);

			array[1] = trangThaiDoanhNghiep;

			array[2] = getByDaXoa_PrevAndNext(session, trangThaiDoanhNghiep,
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

	protected TrangThaiDoanhNghiep getByDaXoa_PrevAndNext(Session session,
		TrangThaiDoanhNghiep trangThaiDoanhNghiep, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANGTHAIDOANHNGHIEP_WHERE);

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
			query.append(TrangThaiDoanhNghiepModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiDoanhNghiep);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiDoanhNghiep> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the trang thai doanh nghieps.
	 *
	 * @return the trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiDoanhNghiep> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai doanh nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai doanh nghieps
	 * @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	 * @return the range of trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiDoanhNghiep> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai doanh nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai doanh nghieps
	 * @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiDoanhNghiep> findAll(int start, int end,
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

		List<TrangThaiDoanhNghiep> list = (List<TrangThaiDoanhNghiep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANGTHAIDOANHNGHIEP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANGTHAIDOANHNGHIEP.concat(TrangThaiDoanhNghiepModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TrangThaiDoanhNghiep>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TrangThaiDoanhNghiep>)QueryUtil.list(q,
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
	 * Removes the trang thai doanh nghiep where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeById(long id)
		throws NoSuchTrangThaiDoanhNghiepException, SystemException {
		TrangThaiDoanhNghiep trangThaiDoanhNghiep = findById(id);

		remove(trangThaiDoanhNghiep);
	}

	/**
	 * Removes all the trang thai doanh nghieps where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDaXoa(int daXoa) throws SystemException {
		for (TrangThaiDoanhNghiep trangThaiDoanhNghiep : findByDaXoa(daXoa)) {
			remove(trangThaiDoanhNghiep);
		}
	}

	/**
	 * Removes all the trang thai doanh nghieps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TrangThaiDoanhNghiep trangThaiDoanhNghiep : findAll()) {
			remove(trangThaiDoanhNghiep);
		}
	}

	/**
	 * Returns the number of trang thai doanh nghieps where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countById(long id) throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIDOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of trang thai doanh nghieps where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDaXoa(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIDOANHNGHIEP_WHERE);

			query.append(_FINDER_COLUMN_DAXOA_DAXOA_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of trang thai doanh nghieps.
	 *
	 * @return the number of trang thai doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRANGTHAIDOANHNGHIEP);

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
	 * Initializes the trang thai doanh nghiep persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrangThaiDoanhNghiep>> listenersList = new ArrayList<ModelListener<TrangThaiDoanhNghiep>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrangThaiDoanhNghiep>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrangThaiDoanhNghiepImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DoanhNghiepPersistence.class)
	protected DoanhNghiepPersistence doanhNghiepPersistence;
	@BeanReference(type = DoanhNghiep2NganhNghePersistence.class)
	protected DoanhNghiep2NganhNghePersistence doanhNghiep2NganhNghePersistence;
	@BeanReference(type = LoaiDoanhNghiepPersistence.class)
	protected LoaiDoanhNghiepPersistence loaiDoanhNghiepPersistence;
	@BeanReference(type = NganhNgheKinhDoanhPersistence.class)
	protected NganhNgheKinhDoanhPersistence nganhNgheKinhDoanhPersistence;
	@BeanReference(type = TrangThaiDoanhNghiepPersistence.class)
	protected TrangThaiDoanhNghiepPersistence trangThaiDoanhNghiepPersistence;
	@BeanReference(type = YeuCauDangKyDNPersistence.class)
	protected YeuCauDangKyDNPersistence yeuCauDangKyDNPersistence;
	@BeanReference(type = YeuCauDangKyDoanhNghiepPersistence.class)
	protected YeuCauDangKyDoanhNghiepPersistence yeuCauDangKyDoanhNghiepPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TRANGTHAIDOANHNGHIEP = "SELECT trangThaiDoanhNghiep FROM TrangThaiDoanhNghiep trangThaiDoanhNghiep";
	private static final String _SQL_SELECT_TRANGTHAIDOANHNGHIEP_WHERE = "SELECT trangThaiDoanhNghiep FROM TrangThaiDoanhNghiep trangThaiDoanhNghiep WHERE ";
	private static final String _SQL_COUNT_TRANGTHAIDOANHNGHIEP = "SELECT COUNT(trangThaiDoanhNghiep) FROM TrangThaiDoanhNghiep trangThaiDoanhNghiep";
	private static final String _SQL_COUNT_TRANGTHAIDOANHNGHIEP_WHERE = "SELECT COUNT(trangThaiDoanhNghiep) FROM TrangThaiDoanhNghiep trangThaiDoanhNghiep WHERE ";
	private static final String _FINDER_COLUMN_ID_ID_2 = "trangThaiDoanhNghiep.id = ?";
	private static final String _FINDER_COLUMN_DAXOA_DAXOA_2 = "trangThaiDoanhNghiep.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trangThaiDoanhNghiep.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrangThaiDoanhNghiep exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrangThaiDoanhNghiep exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrangThaiDoanhNghiepPersistenceImpl.class);
	private static TrangThaiDoanhNghiep _nullTrangThaiDoanhNghiep = new TrangThaiDoanhNghiepImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrangThaiDoanhNghiep> toCacheModel() {
				return _nullTrangThaiDoanhNghiepCacheModel;
			}
		};

	private static CacheModel<TrangThaiDoanhNghiep> _nullTrangThaiDoanhNghiepCacheModel =
		new CacheModel<TrangThaiDoanhNghiep>() {
			public TrangThaiDoanhNghiep toEntityModel() {
				return _nullTrangThaiDoanhNghiep;
			}
		};
}