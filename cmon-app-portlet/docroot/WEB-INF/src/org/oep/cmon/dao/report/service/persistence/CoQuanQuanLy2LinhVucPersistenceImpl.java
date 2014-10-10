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

package org.oep.cmon.dao.report.service.persistence;

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

import org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;
import org.oep.cmon.dao.report.model.impl.CoQuanQuanLy2LinhVucImpl;
import org.oep.cmon.dao.report.model.impl.CoQuanQuanLy2LinhVucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the co quan quan ly2 linh vuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see CoQuanQuanLy2LinhVucPersistence
 * @see CoQuanQuanLy2LinhVucUtil
 * @generated
 */
public class CoQuanQuanLy2LinhVucPersistenceImpl extends BasePersistenceImpl<CoQuanQuanLy2LinhVuc>
	implements CoQuanQuanLy2LinhVucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoQuanQuanLy2LinhVucUtil} to access the co quan quan ly2 linh vuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoQuanQuanLy2LinhVucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucModelImpl.FINDER_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucModelImpl.FINDER_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the co quan quan ly2 linh vuc in the entity cache if it is enabled.
	 *
	 * @param coQuanQuanLy2LinhVuc the co quan quan ly2 linh vuc
	 */
	public void cacheResult(CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		EntityCacheUtil.putResult(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucImpl.class,
			coQuanQuanLy2LinhVuc.getPrimaryKey(), coQuanQuanLy2LinhVuc);

		coQuanQuanLy2LinhVuc.resetOriginalValues();
	}

	/**
	 * Caches the co quan quan ly2 linh vucs in the entity cache if it is enabled.
	 *
	 * @param coQuanQuanLy2LinhVucs the co quan quan ly2 linh vucs
	 */
	public void cacheResult(List<CoQuanQuanLy2LinhVuc> coQuanQuanLy2LinhVucs) {
		for (CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc : coQuanQuanLy2LinhVucs) {
			if (EntityCacheUtil.getResult(
						CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanQuanLy2LinhVucImpl.class,
						coQuanQuanLy2LinhVuc.getPrimaryKey()) == null) {
				cacheResult(coQuanQuanLy2LinhVuc);
			}
			else {
				coQuanQuanLy2LinhVuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all co quan quan ly2 linh vucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoQuanQuanLy2LinhVucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoQuanQuanLy2LinhVucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the co quan quan ly2 linh vuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		EntityCacheUtil.removeResult(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucImpl.class, coQuanQuanLy2LinhVuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CoQuanQuanLy2LinhVuc> coQuanQuanLy2LinhVucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc : coQuanQuanLy2LinhVucs) {
			EntityCacheUtil.removeResult(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanQuanLy2LinhVucImpl.class,
				coQuanQuanLy2LinhVuc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new co quan quan ly2 linh vuc with the primary key. Does not add the co quan quan ly2 linh vuc to the database.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key for the new co quan quan ly2 linh vuc
	 * @return the new co quan quan ly2 linh vuc
	 */
	public CoQuanQuanLy2LinhVuc create(long NHOMTHUTUCHANHCHINHID) {
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc = new CoQuanQuanLy2LinhVucImpl();

		coQuanQuanLy2LinhVuc.setNew(true);
		coQuanQuanLy2LinhVuc.setPrimaryKey(NHOMTHUTUCHANHCHINHID);

		return coQuanQuanLy2LinhVuc;
	}

	/**
	 * Removes the co quan quan ly2 linh vuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	 * @return the co quan quan ly2 linh vuc that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException if a co quan quan ly2 linh vuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy2LinhVuc remove(long NHOMTHUTUCHANHCHINHID)
		throws NoSuchCoQuanQuanLy2LinhVucException, SystemException {
		return remove(Long.valueOf(NHOMTHUTUCHANHCHINHID));
	}

	/**
	 * Removes the co quan quan ly2 linh vuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the co quan quan ly2 linh vuc
	 * @return the co quan quan ly2 linh vuc that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException if a co quan quan ly2 linh vuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanQuanLy2LinhVuc remove(Serializable primaryKey)
		throws NoSuchCoQuanQuanLy2LinhVucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc = (CoQuanQuanLy2LinhVuc)session.get(CoQuanQuanLy2LinhVucImpl.class,
					primaryKey);

			if (coQuanQuanLy2LinhVuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoQuanQuanLy2LinhVucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coQuanQuanLy2LinhVuc);
		}
		catch (NoSuchCoQuanQuanLy2LinhVucException nsee) {
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
	protected CoQuanQuanLy2LinhVuc removeImpl(
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) throws SystemException {
		coQuanQuanLy2LinhVuc = toUnwrappedModel(coQuanQuanLy2LinhVuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, coQuanQuanLy2LinhVuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(coQuanQuanLy2LinhVuc);

		return coQuanQuanLy2LinhVuc;
	}

	@Override
	public CoQuanQuanLy2LinhVuc updateImpl(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc,
		boolean merge) throws SystemException {
		coQuanQuanLy2LinhVuc = toUnwrappedModel(coQuanQuanLy2LinhVuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, coQuanQuanLy2LinhVuc, merge);

			coQuanQuanLy2LinhVuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanQuanLy2LinhVucImpl.class,
			coQuanQuanLy2LinhVuc.getPrimaryKey(), coQuanQuanLy2LinhVuc);

		return coQuanQuanLy2LinhVuc;
	}

	protected CoQuanQuanLy2LinhVuc toUnwrappedModel(
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		if (coQuanQuanLy2LinhVuc instanceof CoQuanQuanLy2LinhVucImpl) {
			return coQuanQuanLy2LinhVuc;
		}

		CoQuanQuanLy2LinhVucImpl coQuanQuanLy2LinhVucImpl = new CoQuanQuanLy2LinhVucImpl();

		coQuanQuanLy2LinhVucImpl.setNew(coQuanQuanLy2LinhVuc.isNew());
		coQuanQuanLy2LinhVucImpl.setPrimaryKey(coQuanQuanLy2LinhVuc.getPrimaryKey());

		coQuanQuanLy2LinhVucImpl.setNHOMTHUTUCHANHCHINHID(coQuanQuanLy2LinhVuc.getNHOMTHUTUCHANHCHINHID());
		coQuanQuanLy2LinhVucImpl.setTENNHOMTTHC(coQuanQuanLy2LinhVuc.getTENNHOMTTHC());

		return coQuanQuanLy2LinhVucImpl;
	}

	/**
	 * Returns the co quan quan ly2 linh vuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan quan ly2 linh vuc
	 * @return the co quan quan ly2 linh vuc
	 * @throws com.liferay.portal.NoSuchModelException if a co quan quan ly2 linh vuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanQuanLy2LinhVuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the co quan quan ly2 linh vuc with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException} if it could not be found.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	 * @return the co quan quan ly2 linh vuc
	 * @throws org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException if a co quan quan ly2 linh vuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy2LinhVuc findByPrimaryKey(long NHOMTHUTUCHANHCHINHID)
		throws NoSuchCoQuanQuanLy2LinhVucException, SystemException {
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc = fetchByPrimaryKey(NHOMTHUTUCHANHCHINHID);

		if (coQuanQuanLy2LinhVuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					NHOMTHUTUCHANHCHINHID);
			}

			throw new NoSuchCoQuanQuanLy2LinhVucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				NHOMTHUTUCHANHCHINHID);
		}

		return coQuanQuanLy2LinhVuc;
	}

	/**
	 * Returns the co quan quan ly2 linh vuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan quan ly2 linh vuc
	 * @return the co quan quan ly2 linh vuc, or <code>null</code> if a co quan quan ly2 linh vuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanQuanLy2LinhVuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the co quan quan ly2 linh vuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	 * @return the co quan quan ly2 linh vuc, or <code>null</code> if a co quan quan ly2 linh vuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanQuanLy2LinhVuc fetchByPrimaryKey(long NHOMTHUTUCHANHCHINHID)
		throws SystemException {
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc = (CoQuanQuanLy2LinhVuc)EntityCacheUtil.getResult(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanQuanLy2LinhVucImpl.class, NHOMTHUTUCHANHCHINHID);

		if (coQuanQuanLy2LinhVuc == _nullCoQuanQuanLy2LinhVuc) {
			return null;
		}

		if (coQuanQuanLy2LinhVuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				coQuanQuanLy2LinhVuc = (CoQuanQuanLy2LinhVuc)session.get(CoQuanQuanLy2LinhVucImpl.class,
						Long.valueOf(NHOMTHUTUCHANHCHINHID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (coQuanQuanLy2LinhVuc != null) {
					cacheResult(coQuanQuanLy2LinhVuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CoQuanQuanLy2LinhVucModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanQuanLy2LinhVucImpl.class, NHOMTHUTUCHANHCHINHID,
						_nullCoQuanQuanLy2LinhVuc);
				}

				closeSession(session);
			}
		}

		return coQuanQuanLy2LinhVuc;
	}

	/**
	 * Returns all the co quan quan ly2 linh vucs.
	 *
	 * @return the co quan quan ly2 linh vucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy2LinhVuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan quan ly2 linh vucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan quan ly2 linh vucs
	 * @param end the upper bound of the range of co quan quan ly2 linh vucs (not inclusive)
	 * @return the range of co quan quan ly2 linh vucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy2LinhVuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan quan ly2 linh vucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan quan ly2 linh vucs
	 * @param end the upper bound of the range of co quan quan ly2 linh vucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of co quan quan ly2 linh vucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanQuanLy2LinhVuc> findAll(int start, int end,
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

		List<CoQuanQuanLy2LinhVuc> list = (List<CoQuanQuanLy2LinhVuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COQUANQUANLY2LINHVUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COQUANQUANLY2LINHVUC.concat(CoQuanQuanLy2LinhVucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CoQuanQuanLy2LinhVuc>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CoQuanQuanLy2LinhVuc>)QueryUtil.list(q,
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
	 * Removes all the co quan quan ly2 linh vucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc : findAll()) {
			remove(coQuanQuanLy2LinhVuc);
		}
	}

	/**
	 * Returns the number of co quan quan ly2 linh vucs.
	 *
	 * @return the number of co quan quan ly2 linh vucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COQUANQUANLY2LINHVUC);

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
	 * Initializes the co quan quan ly2 linh vuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CoQuanQuanLy2LinhVuc>> listenersList = new ArrayList<ModelListener<CoQuanQuanLy2LinhVuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CoQuanQuanLy2LinhVuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CoQuanQuanLy2LinhVucImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BaocaochitietPersistence.class)
	protected BaocaochitietPersistence baocaochitietPersistence;
	@BeanReference(type = CongChuc2RolePersistence.class)
	protected CongChuc2RolePersistence congChuc2RolePersistence;
	@BeanReference(type = CoQuanQuanLy2LinhVucPersistence.class)
	protected CoQuanQuanLy2LinhVucPersistence coQuanQuanLy2LinhVucPersistence;
	@BeanReference(type = DanhMucBaoCaoPersistence.class)
	protected DanhMucBaoCaoPersistence danhMucBaoCaoPersistence;
	@BeanReference(type = DanhMucRolePersistence.class)
	protected DanhMucRolePersistence danhMucRolePersistence;
	@BeanReference(type = Lephi_chitietPersistence.class)
	protected Lephi_chitietPersistence lephi_chitietPersistence;
	@BeanReference(type = Lephi_linhvucPersistence.class)
	protected Lephi_linhvucPersistence lephi_linhvucPersistence;
	@BeanReference(type = Lephi_tonghopPersistence.class)
	protected Lephi_tonghopPersistence lephi_tonghopPersistence;
	@BeanReference(type = ReportThongKePersistence.class)
	protected ReportThongKePersistence reportThongKePersistence;
	@BeanReference(type = ReportTongHopPersistence.class)
	protected ReportTongHopPersistence reportTongHopPersistence;
	@BeanReference(type = ReportTongHopChiTietPersistence.class)
	protected ReportTongHopChiTietPersistence reportTongHopChiTietPersistence;
	@BeanReference(type = Role2BaoCaoPersistence.class)
	protected Role2BaoCaoPersistence role2BaoCaoPersistence;
	@BeanReference(type = Role2DonViBaoCaoPersistence.class)
	protected Role2DonViBaoCaoPersistence role2DonViBaoCaoPersistence;
	@BeanReference(type = Role2NhomTTHCPersistence.class)
	protected Role2NhomTTHCPersistence role2NhomTTHCPersistence;
	@BeanReference(type = Role2TTHCPersistence.class)
	protected Role2TTHCPersistence role2TTHCPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COQUANQUANLY2LINHVUC = "SELECT coQuanQuanLy2LinhVuc FROM CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc";
	private static final String _SQL_COUNT_COQUANQUANLY2LINHVUC = "SELECT COUNT(coQuanQuanLy2LinhVuc) FROM CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coQuanQuanLy2LinhVuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CoQuanQuanLy2LinhVuc exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoQuanQuanLy2LinhVucPersistenceImpl.class);
	private static CoQuanQuanLy2LinhVuc _nullCoQuanQuanLy2LinhVuc = new CoQuanQuanLy2LinhVucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CoQuanQuanLy2LinhVuc> toCacheModel() {
				return _nullCoQuanQuanLy2LinhVucCacheModel;
			}
		};

	private static CacheModel<CoQuanQuanLy2LinhVuc> _nullCoQuanQuanLy2LinhVucCacheModel =
		new CacheModel<CoQuanQuanLy2LinhVuc>() {
			public CoQuanQuanLy2LinhVuc toEntityModel() {
				return _nullCoQuanQuanLy2LinhVuc;
			}
		};
}