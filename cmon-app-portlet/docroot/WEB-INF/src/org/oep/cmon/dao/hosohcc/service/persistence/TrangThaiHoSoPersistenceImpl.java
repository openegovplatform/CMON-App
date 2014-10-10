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

package org.oep.cmon.dao.hosohcc.service.persistence;

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

import org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;
import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;
import org.oep.cmon.dao.hosohcc.model.impl.TrangThaiHoSoImpl;
import org.oep.cmon.dao.hosohcc.model.impl.TrangThaiHoSoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the trang thai ho so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see TrangThaiHoSoPersistence
 * @see TrangThaiHoSoUtil
 * @generated
 */
public class TrangThaiHoSoPersistenceImpl extends BasePersistenceImpl<TrangThaiHoSo>
	implements TrangThaiHoSoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrangThaiHoSoUtil} to access the trang thai ho so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrangThaiHoSoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchById",
			new String[] { Long.class.getName() },
			TrangThaiHoSoModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIHOSO =
		new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThaiHoSo",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO =
		new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTrangThaiHoSo", new String[] { Integer.class.getName() },
			TrangThaiHoSoModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAIHOSO = new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThaiHoSo",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the trang thai ho so in the entity cache if it is enabled.
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 */
	public void cacheResult(TrangThaiHoSo trangThaiHoSo) {
		EntityCacheUtil.putResult(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, trangThaiHoSo.getPrimaryKey(),
			trangThaiHoSo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(trangThaiHoSo.getId()) }, trangThaiHoSo);

		trangThaiHoSo.resetOriginalValues();
	}

	/**
	 * Caches the trang thai ho sos in the entity cache if it is enabled.
	 *
	 * @param trangThaiHoSos the trang thai ho sos
	 */
	public void cacheResult(List<TrangThaiHoSo> trangThaiHoSos) {
		for (TrangThaiHoSo trangThaiHoSo : trangThaiHoSos) {
			if (EntityCacheUtil.getResult(
						TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiHoSoImpl.class, trangThaiHoSo.getPrimaryKey()) == null) {
				cacheResult(trangThaiHoSo);
			}
			else {
				trangThaiHoSo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trang thai ho sos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrangThaiHoSoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrangThaiHoSoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trang thai ho so.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrangThaiHoSo trangThaiHoSo) {
		EntityCacheUtil.removeResult(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, trangThaiHoSo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(trangThaiHoSo);
	}

	@Override
	public void clearCache(List<TrangThaiHoSo> trangThaiHoSos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrangThaiHoSo trangThaiHoSo : trangThaiHoSos) {
			EntityCacheUtil.removeResult(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiHoSoImpl.class, trangThaiHoSo.getPrimaryKey());

			clearUniqueFindersCache(trangThaiHoSo);
		}
	}

	protected void clearUniqueFindersCache(TrangThaiHoSo trangThaiHoSo) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { Long.valueOf(trangThaiHoSo.getId()) });
	}

	/**
	 * Creates a new trang thai ho so with the primary key. Does not add the trang thai ho so to the database.
	 *
	 * @param id the primary key for the new trang thai ho so
	 * @return the new trang thai ho so
	 */
	public TrangThaiHoSo create(long id) {
		TrangThaiHoSo trangThaiHoSo = new TrangThaiHoSoImpl();

		trangThaiHoSo.setNew(true);
		trangThaiHoSo.setPrimaryKey(id);

		return trangThaiHoSo;
	}

	/**
	 * Removes the trang thai ho so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trang thai ho so
	 * @return the trang thai ho so that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo remove(long id)
		throws NoSuchTrangThaiHoSoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the trang thai ho so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trang thai ho so
	 * @return the trang thai ho so that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiHoSo remove(Serializable primaryKey)
		throws NoSuchTrangThaiHoSoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrangThaiHoSo trangThaiHoSo = (TrangThaiHoSo)session.get(TrangThaiHoSoImpl.class,
					primaryKey);

			if (trangThaiHoSo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrangThaiHoSoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trangThaiHoSo);
		}
		catch (NoSuchTrangThaiHoSoException nsee) {
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
	protected TrangThaiHoSo removeImpl(TrangThaiHoSo trangThaiHoSo)
		throws SystemException {
		trangThaiHoSo = toUnwrappedModel(trangThaiHoSo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, trangThaiHoSo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(trangThaiHoSo);

		return trangThaiHoSo;
	}

	@Override
	public TrangThaiHoSo updateImpl(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo,
		boolean merge) throws SystemException {
		trangThaiHoSo = toUnwrappedModel(trangThaiHoSo);

		boolean isNew = trangThaiHoSo.isNew();

		TrangThaiHoSoModelImpl trangThaiHoSoModelImpl = (TrangThaiHoSoModelImpl)trangThaiHoSo;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, trangThaiHoSo, merge);

			trangThaiHoSo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrangThaiHoSoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trangThaiHoSoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(trangThaiHoSoModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO,
					args);

				args = new Object[] {
						Integer.valueOf(trangThaiHoSoModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO,
					args);
			}
		}

		EntityCacheUtil.putResult(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHoSoImpl.class, trangThaiHoSo.getPrimaryKey(),
			trangThaiHoSo);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
				new Object[] { Long.valueOf(trangThaiHoSo.getId()) },
				trangThaiHoSo);
		}
		else {
			if ((trangThaiHoSoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(trangThaiHoSoModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
					new Object[] { Long.valueOf(trangThaiHoSo.getId()) },
					trangThaiHoSo);
			}
		}

		return trangThaiHoSo;
	}

	protected TrangThaiHoSo toUnwrappedModel(TrangThaiHoSo trangThaiHoSo) {
		if (trangThaiHoSo instanceof TrangThaiHoSoImpl) {
			return trangThaiHoSo;
		}

		TrangThaiHoSoImpl trangThaiHoSoImpl = new TrangThaiHoSoImpl();

		trangThaiHoSoImpl.setNew(trangThaiHoSo.isNew());
		trangThaiHoSoImpl.setPrimaryKey(trangThaiHoSo.getPrimaryKey());

		trangThaiHoSoImpl.setId(trangThaiHoSo.getId());
		trangThaiHoSoImpl.setTrangThai(trangThaiHoSo.getTrangThai());
		trangThaiHoSoImpl.setNguoiTao(trangThaiHoSo.getNguoiTao());
		trangThaiHoSoImpl.setNgayTao(trangThaiHoSo.getNgayTao());
		trangThaiHoSoImpl.setNguoiSua(trangThaiHoSo.getNguoiSua());
		trangThaiHoSoImpl.setNgaySua(trangThaiHoSo.getNgaySua());
		trangThaiHoSoImpl.setDaXoa(trangThaiHoSo.getDaXoa());

		return trangThaiHoSoImpl;
	}

	/**
	 * Returns the trang thai ho so with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai ho so
	 * @return the trang thai ho so
	 * @throws com.liferay.portal.NoSuchModelException if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiHoSo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai ho so with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException} if it could not be found.
	 *
	 * @param id the primary key of the trang thai ho so
	 * @return the trang thai ho so
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo findByPrimaryKey(long id)
		throws NoSuchTrangThaiHoSoException, SystemException {
		TrangThaiHoSo trangThaiHoSo = fetchByPrimaryKey(id);

		if (trangThaiHoSo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTrangThaiHoSoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return trangThaiHoSo;
	}

	/**
	 * Returns the trang thai ho so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai ho so
	 * @return the trang thai ho so, or <code>null</code> if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiHoSo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai ho so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trang thai ho so
	 * @return the trang thai ho so, or <code>null</code> if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo fetchByPrimaryKey(long id) throws SystemException {
		TrangThaiHoSo trangThaiHoSo = (TrangThaiHoSo)EntityCacheUtil.getResult(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiHoSoImpl.class, id);

		if (trangThaiHoSo == _nullTrangThaiHoSo) {
			return null;
		}

		if (trangThaiHoSo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				trangThaiHoSo = (TrangThaiHoSo)session.get(TrangThaiHoSoImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (trangThaiHoSo != null) {
					cacheResult(trangThaiHoSo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TrangThaiHoSoModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiHoSoImpl.class, id, _nullTrangThaiHoSo);
				}

				closeSession(session);
			}
		}

		return trangThaiHoSo;
	}

	/**
	 * Returns the trang thai ho so where id = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching trang thai ho so
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo findById(long id)
		throws NoSuchTrangThaiHoSoException, SystemException {
		TrangThaiHoSo trangThaiHoSo = fetchById(id);

		if (trangThaiHoSo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrangThaiHoSoException(msg.toString());
		}

		return trangThaiHoSo;
	}

	/**
	 * Returns the trang thai ho so where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching trang thai ho so, or <code>null</code> if a matching trang thai ho so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo fetchById(long id) throws SystemException {
		return fetchById(id, true);
	}

	/**
	 * Returns the trang thai ho so where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trang thai ho so, or <code>null</code> if a matching trang thai ho so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo fetchById(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRANGTHAIHOSO_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			query.append(TrangThaiHoSoModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<TrangThaiHoSo> list = q.list();

				result = list;

				TrangThaiHoSo trangThaiHoSo = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					trangThaiHoSo = list.get(0);

					cacheResult(trangThaiHoSo);

					if ((trangThaiHoSo.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, trangThaiHoSo);
					}
				}

				return trangThaiHoSo;
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
				return (TrangThaiHoSo)result;
			}
		}
	}

	/**
	 * Returns all the trang thai ho sos where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoSo> findByTrangThaiHoSo(int daXoa)
		throws SystemException {
		return findByTrangThaiHoSo(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the trang thai ho sos where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of trang thai ho sos
	 * @param end the upper bound of the range of trang thai ho sos (not inclusive)
	 * @return the range of matching trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoSo> findByTrangThaiHoSo(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThaiHoSo(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai ho sos where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of trang thai ho sos
	 * @param end the upper bound of the range of trang thai ho sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoSo> findByTrangThaiHoSo(int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIHOSO;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<TrangThaiHoSo> list = (List<TrangThaiHoSo>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TRANGTHAIHOSO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrangThaiHoSoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TrangThaiHoSo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trang thai ho so in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai ho so
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo findByTrangThaiHoSo_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiHoSoException, SystemException {
		List<TrangThaiHoSo> list = findByTrangThaiHoSo(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiHoSoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last trang thai ho so in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai ho so
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo findByTrangThaiHoSo_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiHoSoException, SystemException {
		int count = countByTrangThaiHoSo(daXoa);

		List<TrangThaiHoSo> list = findByTrangThaiHoSo(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiHoSoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the trang thai ho sos before and after the current trang thai ho so in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current trang thai ho so
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trang thai ho so
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoSo[] findByTrangThaiHoSo_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiHoSoException, SystemException {
		TrangThaiHoSo trangThaiHoSo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrangThaiHoSo[] array = new TrangThaiHoSoImpl[3];

			array[0] = getByTrangThaiHoSo_PrevAndNext(session, trangThaiHoSo,
					daXoa, orderByComparator, true);

			array[1] = trangThaiHoSo;

			array[2] = getByTrangThaiHoSo_PrevAndNext(session, trangThaiHoSo,
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

	protected TrangThaiHoSo getByTrangThaiHoSo_PrevAndNext(Session session,
		TrangThaiHoSo trangThaiHoSo, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANGTHAIHOSO_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2);

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
			query.append(TrangThaiHoSoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiHoSo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiHoSo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the trang thai ho sos.
	 *
	 * @return the trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoSo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai ho sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai ho sos
	 * @param end the upper bound of the range of trang thai ho sos (not inclusive)
	 * @return the range of trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoSo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai ho sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai ho sos
	 * @param end the upper bound of the range of trang thai ho sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoSo> findAll(int start, int end,
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

		List<TrangThaiHoSo> list = (List<TrangThaiHoSo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANGTHAIHOSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANGTHAIHOSO.concat(TrangThaiHoSoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TrangThaiHoSo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TrangThaiHoSo>)QueryUtil.list(q, getDialect(),
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
	 * Removes the trang thai ho so where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeById(long id)
		throws NoSuchTrangThaiHoSoException, SystemException {
		TrangThaiHoSo trangThaiHoSo = findById(id);

		remove(trangThaiHoSo);
	}

	/**
	 * Removes all the trang thai ho sos where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThaiHoSo(int daXoa) throws SystemException {
		for (TrangThaiHoSo trangThaiHoSo : findByTrangThaiHoSo(daXoa)) {
			remove(trangThaiHoSo);
		}
	}

	/**
	 * Removes all the trang thai ho sos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TrangThaiHoSo trangThaiHoSo : findAll()) {
			remove(trangThaiHoSo);
		}
	}

	/**
	 * Returns the number of trang thai ho sos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countById(long id) throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIHOSO_WHERE);

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
	 * Returns the number of trang thai ho sos where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThaiHoSo(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIHOSO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of trang thai ho sos.
	 *
	 * @return the number of trang thai ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRANGTHAIHOSO);

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
	 * Initializes the trang thai ho so persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrangThaiHoSo>> listenersList = new ArrayList<ModelListener<TrangThaiHoSo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrangThaiHoSo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrangThaiHoSoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FileDinhKemPersistence.class)
	protected FileDinhKemPersistence fileDinhKemPersistence;
	@BeanReference(type = HoSoAnhXaPersistence.class)
	protected HoSoAnhXaPersistence hoSoAnhXaPersistence;
	@BeanReference(type = HoSoTTHCCongPersistence.class)
	protected HoSoTTHCCongPersistence hoSoTTHCCongPersistence;
	@BeanReference(type = TrangThaiHoSoPersistence.class)
	protected TrangThaiHoSoPersistence trangThaiHoSoPersistence;
	@BeanReference(type = YKienTraoDoiPersistence.class)
	protected YKienTraoDoiPersistence yKienTraoDoiPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TRANGTHAIHOSO = "SELECT trangThaiHoSo FROM TrangThaiHoSo trangThaiHoSo";
	private static final String _SQL_SELECT_TRANGTHAIHOSO_WHERE = "SELECT trangThaiHoSo FROM TrangThaiHoSo trangThaiHoSo WHERE ";
	private static final String _SQL_COUNT_TRANGTHAIHOSO = "SELECT COUNT(trangThaiHoSo) FROM TrangThaiHoSo trangThaiHoSo";
	private static final String _SQL_COUNT_TRANGTHAIHOSO_WHERE = "SELECT COUNT(trangThaiHoSo) FROM TrangThaiHoSo trangThaiHoSo WHERE ";
	private static final String _FINDER_COLUMN_ID_ID_2 = "trangThaiHoSo.id = ?";
	private static final String _FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2 = "trangThaiHoSo.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trangThaiHoSo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrangThaiHoSo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrangThaiHoSo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrangThaiHoSoPersistenceImpl.class);
	private static TrangThaiHoSo _nullTrangThaiHoSo = new TrangThaiHoSoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrangThaiHoSo> toCacheModel() {
				return _nullTrangThaiHoSoCacheModel;
			}
		};

	private static CacheModel<TrangThaiHoSo> _nullTrangThaiHoSoCacheModel = new CacheModel<TrangThaiHoSo>() {
			public TrangThaiHoSo toEntityModel() {
				return _nullTrangThaiHoSo;
			}
		};
}