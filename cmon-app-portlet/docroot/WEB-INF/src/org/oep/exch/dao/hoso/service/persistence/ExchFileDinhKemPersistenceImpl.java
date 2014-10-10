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

import org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException;
import org.oep.exch.dao.hoso.model.ExchFileDinhKem;
import org.oep.exch.dao.hoso.model.impl.ExchFileDinhKemImpl;
import org.oep.exch.dao.hoso.model.impl.ExchFileDinhKemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the exch file dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see ExchFileDinhKemPersistence
 * @see ExchFileDinhKemUtil
 * @generated
 */
public class ExchFileDinhKemPersistenceImpl extends BasePersistenceImpl<ExchFileDinhKem>
	implements ExchFileDinhKemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExchFileDinhKemUtil} to access the exch file dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExchFileDinhKemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ONLINEID = new FinderPath(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemModelImpl.FINDER_CACHE_ENABLED,
			ExchFileDinhKemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOnlineId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ONLINEID =
		new FinderPath(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemModelImpl.FINDER_CACHE_ENABLED,
			ExchFileDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOnlineId",
			new String[] { Long.class.getName() },
			ExchFileDinhKemModelImpl.ONLINEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ONLINEID = new FinderPath(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOnlineId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemModelImpl.FINDER_CACHE_ENABLED,
			ExchFileDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemModelImpl.FINDER_CACHE_ENABLED,
			ExchFileDinhKemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the exch file dinh kem in the entity cache if it is enabled.
	 *
	 * @param exchFileDinhKem the exch file dinh kem
	 */
	public void cacheResult(ExchFileDinhKem exchFileDinhKem) {
		EntityCacheUtil.putResult(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemImpl.class, exchFileDinhKem.getPrimaryKey(),
			exchFileDinhKem);

		exchFileDinhKem.resetOriginalValues();
	}

	/**
	 * Caches the exch file dinh kems in the entity cache if it is enabled.
	 *
	 * @param exchFileDinhKems the exch file dinh kems
	 */
	public void cacheResult(List<ExchFileDinhKem> exchFileDinhKems) {
		for (ExchFileDinhKem exchFileDinhKem : exchFileDinhKems) {
			if (EntityCacheUtil.getResult(
						ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
						ExchFileDinhKemImpl.class,
						exchFileDinhKem.getPrimaryKey()) == null) {
				cacheResult(exchFileDinhKem);
			}
			else {
				exchFileDinhKem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all exch file dinh kems.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExchFileDinhKemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExchFileDinhKemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the exch file dinh kem.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExchFileDinhKem exchFileDinhKem) {
		EntityCacheUtil.removeResult(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemImpl.class, exchFileDinhKem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExchFileDinhKem> exchFileDinhKems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExchFileDinhKem exchFileDinhKem : exchFileDinhKems) {
			EntityCacheUtil.removeResult(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
				ExchFileDinhKemImpl.class, exchFileDinhKem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new exch file dinh kem with the primary key. Does not add the exch file dinh kem to the database.
	 *
	 * @param id the primary key for the new exch file dinh kem
	 * @return the new exch file dinh kem
	 */
	public ExchFileDinhKem create(long id) {
		ExchFileDinhKem exchFileDinhKem = new ExchFileDinhKemImpl();

		exchFileDinhKem.setNew(true);
		exchFileDinhKem.setPrimaryKey(id);

		return exchFileDinhKem;
	}

	/**
	 * Removes the exch file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the exch file dinh kem
	 * @return the exch file dinh kem that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExchFileDinhKem remove(long id)
		throws NoSuchExchFileDinhKemException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the exch file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exch file dinh kem
	 * @return the exch file dinh kem that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExchFileDinhKem remove(Serializable primaryKey)
		throws NoSuchExchFileDinhKemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExchFileDinhKem exchFileDinhKem = (ExchFileDinhKem)session.get(ExchFileDinhKemImpl.class,
					primaryKey);

			if (exchFileDinhKem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExchFileDinhKemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(exchFileDinhKem);
		}
		catch (NoSuchExchFileDinhKemException nsee) {
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
	protected ExchFileDinhKem removeImpl(ExchFileDinhKem exchFileDinhKem)
		throws SystemException {
		exchFileDinhKem = toUnwrappedModel(exchFileDinhKem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, exchFileDinhKem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(exchFileDinhKem);

		return exchFileDinhKem;
	}

	@Override
	public ExchFileDinhKem updateImpl(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem,
		boolean merge) throws SystemException {
		exchFileDinhKem = toUnwrappedModel(exchFileDinhKem);

		boolean isNew = exchFileDinhKem.isNew();

		ExchFileDinhKemModelImpl exchFileDinhKemModelImpl = (ExchFileDinhKemModelImpl)exchFileDinhKem;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, exchFileDinhKem, merge);

			exchFileDinhKem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExchFileDinhKemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((exchFileDinhKemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ONLINEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(exchFileDinhKemModelImpl.getOriginalOnlineId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ONLINEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ONLINEID,
					args);

				args = new Object[] {
						Long.valueOf(exchFileDinhKemModelImpl.getOnlineId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ONLINEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ONLINEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			ExchFileDinhKemImpl.class, exchFileDinhKem.getPrimaryKey(),
			exchFileDinhKem);

		return exchFileDinhKem;
	}

	protected ExchFileDinhKem toUnwrappedModel(ExchFileDinhKem exchFileDinhKem) {
		if (exchFileDinhKem instanceof ExchFileDinhKemImpl) {
			return exchFileDinhKem;
		}

		ExchFileDinhKemImpl exchFileDinhKemImpl = new ExchFileDinhKemImpl();

		exchFileDinhKemImpl.setNew(exchFileDinhKem.isNew());
		exchFileDinhKemImpl.setPrimaryKey(exchFileDinhKem.getPrimaryKey());

		exchFileDinhKemImpl.setId(exchFileDinhKem.getId());
		exchFileDinhKemImpl.setOnlineId(exchFileDinhKem.getOnlineId());
		exchFileDinhKemImpl.setTenTaiLieuDinhKem(exchFileDinhKem.getTenTaiLieuDinhKem());
		exchFileDinhKemImpl.setUrlTaiLieuDinhKem(exchFileDinhKem.getUrlTaiLieuDinhKem());
		exchFileDinhKemImpl.setTenFile(exchFileDinhKem.getTenFile());

		return exchFileDinhKemImpl;
	}

	/**
	 * Returns the exch file dinh kem with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the exch file dinh kem
	 * @return the exch file dinh kem
	 * @throws com.liferay.portal.NoSuchModelException if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExchFileDinhKem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the exch file dinh kem with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException} if it could not be found.
	 *
	 * @param id the primary key of the exch file dinh kem
	 * @return the exch file dinh kem
	 * @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExchFileDinhKem findByPrimaryKey(long id)
		throws NoSuchExchFileDinhKemException, SystemException {
		ExchFileDinhKem exchFileDinhKem = fetchByPrimaryKey(id);

		if (exchFileDinhKem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchExchFileDinhKemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return exchFileDinhKem;
	}

	/**
	 * Returns the exch file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exch file dinh kem
	 * @return the exch file dinh kem, or <code>null</code> if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExchFileDinhKem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the exch file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the exch file dinh kem
	 * @return the exch file dinh kem, or <code>null</code> if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExchFileDinhKem fetchByPrimaryKey(long id) throws SystemException {
		ExchFileDinhKem exchFileDinhKem = (ExchFileDinhKem)EntityCacheUtil.getResult(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
				ExchFileDinhKemImpl.class, id);

		if (exchFileDinhKem == _nullExchFileDinhKem) {
			return null;
		}

		if (exchFileDinhKem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				exchFileDinhKem = (ExchFileDinhKem)session.get(ExchFileDinhKemImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (exchFileDinhKem != null) {
					cacheResult(exchFileDinhKem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ExchFileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
						ExchFileDinhKemImpl.class, id, _nullExchFileDinhKem);
				}

				closeSession(session);
			}
		}

		return exchFileDinhKem;
	}

	/**
	 * Returns all the exch file dinh kems where OnlineId = &#63;.
	 *
	 * @param OnlineId the online ID
	 * @return the matching exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExchFileDinhKem> findByOnlineId(long OnlineId)
		throws SystemException {
		return findByOnlineId(OnlineId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the exch file dinh kems where OnlineId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param OnlineId the online ID
	 * @param start the lower bound of the range of exch file dinh kems
	 * @param end the upper bound of the range of exch file dinh kems (not inclusive)
	 * @return the range of matching exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExchFileDinhKem> findByOnlineId(long OnlineId, int start,
		int end) throws SystemException {
		return findByOnlineId(OnlineId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the exch file dinh kems where OnlineId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param OnlineId the online ID
	 * @param start the lower bound of the range of exch file dinh kems
	 * @param end the upper bound of the range of exch file dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExchFileDinhKem> findByOnlineId(long OnlineId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ONLINEID;
			finderArgs = new Object[] { OnlineId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ONLINEID;
			finderArgs = new Object[] { OnlineId, start, end, orderByComparator };
		}

		List<ExchFileDinhKem> list = (List<ExchFileDinhKem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_EXCHFILEDINHKEM_WHERE);

			query.append(_FINDER_COLUMN_ONLINEID_ONLINEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(OnlineId);

				list = (List<ExchFileDinhKem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first exch file dinh kem in the ordered set where OnlineId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param OnlineId the online ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exch file dinh kem
	 * @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a matching exch file dinh kem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExchFileDinhKem findByOnlineId_First(long OnlineId,
		OrderByComparator orderByComparator)
		throws NoSuchExchFileDinhKemException, SystemException {
		List<ExchFileDinhKem> list = findByOnlineId(OnlineId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("OnlineId=");
			msg.append(OnlineId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchExchFileDinhKemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last exch file dinh kem in the ordered set where OnlineId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param OnlineId the online ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exch file dinh kem
	 * @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a matching exch file dinh kem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExchFileDinhKem findByOnlineId_Last(long OnlineId,
		OrderByComparator orderByComparator)
		throws NoSuchExchFileDinhKemException, SystemException {
		int count = countByOnlineId(OnlineId);

		List<ExchFileDinhKem> list = findByOnlineId(OnlineId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("OnlineId=");
			msg.append(OnlineId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchExchFileDinhKemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the exch file dinh kems before and after the current exch file dinh kem in the ordered set where OnlineId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current exch file dinh kem
	 * @param OnlineId the online ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exch file dinh kem
	 * @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExchFileDinhKem[] findByOnlineId_PrevAndNext(long id, long OnlineId,
		OrderByComparator orderByComparator)
		throws NoSuchExchFileDinhKemException, SystemException {
		ExchFileDinhKem exchFileDinhKem = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ExchFileDinhKem[] array = new ExchFileDinhKemImpl[3];

			array[0] = getByOnlineId_PrevAndNext(session, exchFileDinhKem,
					OnlineId, orderByComparator, true);

			array[1] = exchFileDinhKem;

			array[2] = getByOnlineId_PrevAndNext(session, exchFileDinhKem,
					OnlineId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExchFileDinhKem getByOnlineId_PrevAndNext(Session session,
		ExchFileDinhKem exchFileDinhKem, long OnlineId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXCHFILEDINHKEM_WHERE);

		query.append(_FINDER_COLUMN_ONLINEID_ONLINEID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(OnlineId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(exchFileDinhKem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExchFileDinhKem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the exch file dinh kems.
	 *
	 * @return the exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExchFileDinhKem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the exch file dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of exch file dinh kems
	 * @param end the upper bound of the range of exch file dinh kems (not inclusive)
	 * @return the range of exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExchFileDinhKem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the exch file dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of exch file dinh kems
	 * @param end the upper bound of the range of exch file dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExchFileDinhKem> findAll(int start, int end,
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

		List<ExchFileDinhKem> list = (List<ExchFileDinhKem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXCHFILEDINHKEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXCHFILEDINHKEM;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ExchFileDinhKem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ExchFileDinhKem>)QueryUtil.list(q,
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
	 * Removes all the exch file dinh kems where OnlineId = &#63; from the database.
	 *
	 * @param OnlineId the online ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOnlineId(long OnlineId) throws SystemException {
		for (ExchFileDinhKem exchFileDinhKem : findByOnlineId(OnlineId)) {
			remove(exchFileDinhKem);
		}
	}

	/**
	 * Removes all the exch file dinh kems from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ExchFileDinhKem exchFileDinhKem : findAll()) {
			remove(exchFileDinhKem);
		}
	}

	/**
	 * Returns the number of exch file dinh kems where OnlineId = &#63;.
	 *
	 * @param OnlineId the online ID
	 * @return the number of matching exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOnlineId(long OnlineId) throws SystemException {
		Object[] finderArgs = new Object[] { OnlineId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ONLINEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXCHFILEDINHKEM_WHERE);

			query.append(_FINDER_COLUMN_ONLINEID_ONLINEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(OnlineId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ONLINEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of exch file dinh kems.
	 *
	 * @return the number of exch file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXCHFILEDINHKEM);

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
	 * Initializes the exch file dinh kem persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.exch.dao.hoso.model.ExchFileDinhKem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExchFileDinhKem>> listenersList = new ArrayList<ModelListener<ExchFileDinhKem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExchFileDinhKem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExchFileDinhKemImpl.class.getName());
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
	private static final String _SQL_SELECT_EXCHFILEDINHKEM = "SELECT exchFileDinhKem FROM ExchFileDinhKem exchFileDinhKem";
	private static final String _SQL_SELECT_EXCHFILEDINHKEM_WHERE = "SELECT exchFileDinhKem FROM ExchFileDinhKem exchFileDinhKem WHERE ";
	private static final String _SQL_COUNT_EXCHFILEDINHKEM = "SELECT COUNT(exchFileDinhKem) FROM ExchFileDinhKem exchFileDinhKem";
	private static final String _SQL_COUNT_EXCHFILEDINHKEM_WHERE = "SELECT COUNT(exchFileDinhKem) FROM ExchFileDinhKem exchFileDinhKem WHERE ";
	private static final String _FINDER_COLUMN_ONLINEID_ONLINEID_2 = "exchFileDinhKem.OnlineId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "exchFileDinhKem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExchFileDinhKem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExchFileDinhKem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExchFileDinhKemPersistenceImpl.class);
	private static ExchFileDinhKem _nullExchFileDinhKem = new ExchFileDinhKemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExchFileDinhKem> toCacheModel() {
				return _nullExchFileDinhKemCacheModel;
			}
		};

	private static CacheModel<ExchFileDinhKem> _nullExchFileDinhKemCacheModel = new CacheModel<ExchFileDinhKem>() {
			public ExchFileDinhKem toEntityModel() {
				return _nullExchFileDinhKem;
			}
		};
}