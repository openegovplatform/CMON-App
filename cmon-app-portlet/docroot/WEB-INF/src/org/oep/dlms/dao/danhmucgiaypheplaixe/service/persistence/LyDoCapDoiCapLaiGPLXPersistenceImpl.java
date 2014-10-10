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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.LyDoCapDoiCapLaiGPLXImpl;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.LyDoCapDoiCapLaiGPLXModelImpl;

/**
 * The persistence implementation for the ly do cap doi cap lai g p l x service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see LyDoCapDoiCapLaiGPLXPersistence
 * @see LyDoCapDoiCapLaiGPLXUtil
 * @generated
 */
public class LyDoCapDoiCapLaiGPLXPersistenceImpl extends BasePersistenceImpl<LyDoCapDoiCapLaiGPLX>
	implements LyDoCapDoiCapLaiGPLXPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LyDoCapDoiCapLaiGPLXUtil} to access the ly do cap doi cap lai g p l x persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LyDoCapDoiCapLaiGPLXImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXModelImpl.FINDER_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXModelImpl.FINDER_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ly do cap doi cap lai g p l x in the entity cache if it is enabled.
	 *
	 * @param lyDoCapDoiCapLaiGPLX the ly do cap doi cap lai g p l x
	 */
	public void cacheResult(LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) {
		EntityCacheUtil.putResult(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXImpl.class,
			lyDoCapDoiCapLaiGPLX.getPrimaryKey(), lyDoCapDoiCapLaiGPLX);

		lyDoCapDoiCapLaiGPLX.resetOriginalValues();
	}

	/**
	 * Caches the ly do cap doi cap lai g p l xs in the entity cache if it is enabled.
	 *
	 * @param lyDoCapDoiCapLaiGPLXs the ly do cap doi cap lai g p l xs
	 */
	public void cacheResult(List<LyDoCapDoiCapLaiGPLX> lyDoCapDoiCapLaiGPLXs) {
		for (LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX : lyDoCapDoiCapLaiGPLXs) {
			if (EntityCacheUtil.getResult(
						LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
						LyDoCapDoiCapLaiGPLXImpl.class,
						lyDoCapDoiCapLaiGPLX.getPrimaryKey()) == null) {
				cacheResult(lyDoCapDoiCapLaiGPLX);
			}
			else {
				lyDoCapDoiCapLaiGPLX.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ly do cap doi cap lai g p l xs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LyDoCapDoiCapLaiGPLXImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LyDoCapDoiCapLaiGPLXImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ly do cap doi cap lai g p l x.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) {
		EntityCacheUtil.removeResult(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXImpl.class, lyDoCapDoiCapLaiGPLX.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LyDoCapDoiCapLaiGPLX> lyDoCapDoiCapLaiGPLXs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX : lyDoCapDoiCapLaiGPLXs) {
			EntityCacheUtil.removeResult(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
				LyDoCapDoiCapLaiGPLXImpl.class,
				lyDoCapDoiCapLaiGPLX.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ly do cap doi cap lai g p l x with the primary key. Does not add the ly do cap doi cap lai g p l x to the database.
	 *
	 * @param id the primary key for the new ly do cap doi cap lai g p l x
	 * @return the new ly do cap doi cap lai g p l x
	 */
	public LyDoCapDoiCapLaiGPLX create(long id) {
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX = new LyDoCapDoiCapLaiGPLXImpl();

		lyDoCapDoiCapLaiGPLX.setNew(true);
		lyDoCapDoiCapLaiGPLX.setPrimaryKey(id);

		return lyDoCapDoiCapLaiGPLX;
	}

	/**
	 * Removes the ly do cap doi cap lai g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ly do cap doi cap lai g p l x
	 * @return the ly do cap doi cap lai g p l x that was removed
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LyDoCapDoiCapLaiGPLX remove(long id)
		throws NoSuchLyDoCapDoiCapLaiGPLXException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ly do cap doi cap lai g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ly do cap doi cap lai g p l x
	 * @return the ly do cap doi cap lai g p l x that was removed
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LyDoCapDoiCapLaiGPLX remove(Serializable primaryKey)
		throws NoSuchLyDoCapDoiCapLaiGPLXException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX = (LyDoCapDoiCapLaiGPLX)session.get(LyDoCapDoiCapLaiGPLXImpl.class,
					primaryKey);

			if (lyDoCapDoiCapLaiGPLX == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLyDoCapDoiCapLaiGPLXException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lyDoCapDoiCapLaiGPLX);
		}
		catch (NoSuchLyDoCapDoiCapLaiGPLXException nsee) {
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
	protected LyDoCapDoiCapLaiGPLX removeImpl(
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) throws SystemException {
		lyDoCapDoiCapLaiGPLX = toUnwrappedModel(lyDoCapDoiCapLaiGPLX);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lyDoCapDoiCapLaiGPLX);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lyDoCapDoiCapLaiGPLX);

		return lyDoCapDoiCapLaiGPLX;
	}

	@Override
	public LyDoCapDoiCapLaiGPLX updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX,
		boolean merge) throws SystemException {
		lyDoCapDoiCapLaiGPLX = toUnwrappedModel(lyDoCapDoiCapLaiGPLX);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lyDoCapDoiCapLaiGPLX, merge);

			lyDoCapDoiCapLaiGPLX.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
			LyDoCapDoiCapLaiGPLXImpl.class,
			lyDoCapDoiCapLaiGPLX.getPrimaryKey(), lyDoCapDoiCapLaiGPLX);

		return lyDoCapDoiCapLaiGPLX;
	}

	protected LyDoCapDoiCapLaiGPLX toUnwrappedModel(
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) {
		if (lyDoCapDoiCapLaiGPLX instanceof LyDoCapDoiCapLaiGPLXImpl) {
			return lyDoCapDoiCapLaiGPLX;
		}

		LyDoCapDoiCapLaiGPLXImpl lyDoCapDoiCapLaiGPLXImpl = new LyDoCapDoiCapLaiGPLXImpl();

		lyDoCapDoiCapLaiGPLXImpl.setNew(lyDoCapDoiCapLaiGPLX.isNew());
		lyDoCapDoiCapLaiGPLXImpl.setPrimaryKey(lyDoCapDoiCapLaiGPLX.getPrimaryKey());

		lyDoCapDoiCapLaiGPLXImpl.setId(lyDoCapDoiCapLaiGPLX.getId());
		lyDoCapDoiCapLaiGPLXImpl.setLyDo(lyDoCapDoiCapLaiGPLX.getLyDo());
		lyDoCapDoiCapLaiGPLXImpl.setNgayTao(lyDoCapDoiCapLaiGPLX.getNgayTao());
		lyDoCapDoiCapLaiGPLXImpl.setNgaySua(lyDoCapDoiCapLaiGPLX.getNgaySua());
		lyDoCapDoiCapLaiGPLXImpl.setNguoiTao(lyDoCapDoiCapLaiGPLX.getNguoiTao());
		lyDoCapDoiCapLaiGPLXImpl.setNguoiSua(lyDoCapDoiCapLaiGPLX.getNguoiSua());
		lyDoCapDoiCapLaiGPLXImpl.setXoa(lyDoCapDoiCapLaiGPLX.getXoa());

		return lyDoCapDoiCapLaiGPLXImpl;
	}

	/**
	 * Returns the ly do cap doi cap lai g p l x with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ly do cap doi cap lai g p l x
	 * @return the ly do cap doi cap lai g p l x
	 * @throws com.liferay.portal.NoSuchModelException if a ly do cap doi cap lai g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LyDoCapDoiCapLaiGPLX findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ly do cap doi cap lai g p l x with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException} if it could not be found.
	 *
	 * @param id the primary key of the ly do cap doi cap lai g p l x
	 * @return the ly do cap doi cap lai g p l x
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LyDoCapDoiCapLaiGPLX findByPrimaryKey(long id)
		throws NoSuchLyDoCapDoiCapLaiGPLXException, SystemException {
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX = fetchByPrimaryKey(id);

		if (lyDoCapDoiCapLaiGPLX == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchLyDoCapDoiCapLaiGPLXException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return lyDoCapDoiCapLaiGPLX;
	}

	/**
	 * Returns the ly do cap doi cap lai g p l x with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ly do cap doi cap lai g p l x
	 * @return the ly do cap doi cap lai g p l x, or <code>null</code> if a ly do cap doi cap lai g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LyDoCapDoiCapLaiGPLX fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ly do cap doi cap lai g p l x with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ly do cap doi cap lai g p l x
	 * @return the ly do cap doi cap lai g p l x, or <code>null</code> if a ly do cap doi cap lai g p l x with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LyDoCapDoiCapLaiGPLX fetchByPrimaryKey(long id)
		throws SystemException {
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX = (LyDoCapDoiCapLaiGPLX)EntityCacheUtil.getResult(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
				LyDoCapDoiCapLaiGPLXImpl.class, id);

		if (lyDoCapDoiCapLaiGPLX == _nullLyDoCapDoiCapLaiGPLX) {
			return null;
		}

		if (lyDoCapDoiCapLaiGPLX == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lyDoCapDoiCapLaiGPLX = (LyDoCapDoiCapLaiGPLX)session.get(LyDoCapDoiCapLaiGPLXImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lyDoCapDoiCapLaiGPLX != null) {
					cacheResult(lyDoCapDoiCapLaiGPLX);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LyDoCapDoiCapLaiGPLXModelImpl.ENTITY_CACHE_ENABLED,
						LyDoCapDoiCapLaiGPLXImpl.class, id,
						_nullLyDoCapDoiCapLaiGPLX);
				}

				closeSession(session);
			}
		}

		return lyDoCapDoiCapLaiGPLX;
	}

	/**
	 * Returns all the ly do cap doi cap lai g p l xs.
	 *
	 * @return the ly do cap doi cap lai g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LyDoCapDoiCapLaiGPLX> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ly do cap doi cap lai g p l xs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ly do cap doi cap lai g p l xs
	 * @param end the upper bound of the range of ly do cap doi cap lai g p l xs (not inclusive)
	 * @return the range of ly do cap doi cap lai g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LyDoCapDoiCapLaiGPLX> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ly do cap doi cap lai g p l xs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ly do cap doi cap lai g p l xs
	 * @param end the upper bound of the range of ly do cap doi cap lai g p l xs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ly do cap doi cap lai g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LyDoCapDoiCapLaiGPLX> findAll(int start, int end,
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

		List<LyDoCapDoiCapLaiGPLX> list = (List<LyDoCapDoiCapLaiGPLX>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LYDOCAPDOICAPLAIGPLX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LYDOCAPDOICAPLAIGPLX.concat(LyDoCapDoiCapLaiGPLXModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LyDoCapDoiCapLaiGPLX>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LyDoCapDoiCapLaiGPLX>)QueryUtil.list(q,
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
	 * Removes all the ly do cap doi cap lai g p l xs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX : findAll()) {
			remove(lyDoCapDoiCapLaiGPLX);
		}
	}

	/**
	 * Returns the number of ly do cap doi cap lai g p l xs.
	 *
	 * @return the number of ly do cap doi cap lai g p l xs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LYDOCAPDOICAPLAIGPLX);

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
	 * Initializes the ly do cap doi cap lai g p l x persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LyDoCapDoiCapLaiGPLX>> listenersList = new ArrayList<ModelListener<LyDoCapDoiCapLaiGPLX>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LyDoCapDoiCapLaiGPLX>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LyDoCapDoiCapLaiGPLXImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DonViGtvtPersistence.class)
	protected DonViGtvtPersistence donViGtvtPersistence;
	@BeanReference(type = HangGiayPhepLaiXePersistence.class)
	protected HangGiayPhepLaiXePersistence hangGiayPhepLaiXePersistence;
	@BeanReference(type = LyDoCapDoiCapLaiGPLXPersistence.class)
	protected LyDoCapDoiCapLaiGPLXPersistence lyDoCapDoiCapLaiGPLXPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LYDOCAPDOICAPLAIGPLX = "SELECT lyDoCapDoiCapLaiGPLX FROM LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX";
	private static final String _SQL_COUNT_LYDOCAPDOICAPLAIGPLX = "SELECT COUNT(lyDoCapDoiCapLaiGPLX) FROM LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lyDoCapDoiCapLaiGPLX.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LyDoCapDoiCapLaiGPLX exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LyDoCapDoiCapLaiGPLXPersistenceImpl.class);
	private static LyDoCapDoiCapLaiGPLX _nullLyDoCapDoiCapLaiGPLX = new LyDoCapDoiCapLaiGPLXImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LyDoCapDoiCapLaiGPLX> toCacheModel() {
				return _nullLyDoCapDoiCapLaiGPLXCacheModel;
			}
		};

	private static CacheModel<LyDoCapDoiCapLaiGPLX> _nullLyDoCapDoiCapLaiGPLXCacheModel =
		new CacheModel<LyDoCapDoiCapLaiGPLX>() {
			public LyDoCapDoiCapLaiGPLX toEntityModel() {
				return _nullLyDoCapDoiCapLaiGPLX;
			}
		};
}