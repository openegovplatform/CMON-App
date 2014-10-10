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

import org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException;
import org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe;
import org.oep.cmon.dao.dn.model.impl.DoanhNghiep2NganhNgheImpl;
import org.oep.cmon.dao.dn.model.impl.DoanhNghiep2NganhNgheModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the doanh nghiep2 nganh nghe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DoanhNghiep2NganhNghePersistence
 * @see DoanhNghiep2NganhNgheUtil
 * @generated
 */
public class DoanhNghiep2NganhNghePersistenceImpl extends BasePersistenceImpl<DoanhNghiep2NganhNghe>
	implements DoanhNghiep2NganhNghePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DoanhNghiep2NganhNgheUtil} to access the doanh nghiep2 nganh nghe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DoanhNghiep2NganhNgheImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiep2NganhNgheModelImpl.FINDER_CACHE_ENABLED,
			DoanhNghiep2NganhNgheImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiep2NganhNgheModelImpl.FINDER_CACHE_ENABLED,
			DoanhNghiep2NganhNgheImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiep2NganhNgheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the doanh nghiep2 nganh nghe in the entity cache if it is enabled.
	 *
	 * @param doanhNghiep2NganhNghe the doanh nghiep2 nganh nghe
	 */
	public void cacheResult(DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		EntityCacheUtil.putResult(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiep2NganhNgheImpl.class,
			doanhNghiep2NganhNghe.getPrimaryKey(), doanhNghiep2NganhNghe);

		doanhNghiep2NganhNghe.resetOriginalValues();
	}

	/**
	 * Caches the doanh nghiep2 nganh nghes in the entity cache if it is enabled.
	 *
	 * @param doanhNghiep2NganhNghes the doanh nghiep2 nganh nghes
	 */
	public void cacheResult(List<DoanhNghiep2NganhNghe> doanhNghiep2NganhNghes) {
		for (DoanhNghiep2NganhNghe doanhNghiep2NganhNghe : doanhNghiep2NganhNghes) {
			if (EntityCacheUtil.getResult(
						DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
						DoanhNghiep2NganhNgheImpl.class,
						doanhNghiep2NganhNghe.getPrimaryKey()) == null) {
				cacheResult(doanhNghiep2NganhNghe);
			}
			else {
				doanhNghiep2NganhNghe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all doanh nghiep2 nganh nghes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DoanhNghiep2NganhNgheImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DoanhNghiep2NganhNgheImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the doanh nghiep2 nganh nghe.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		EntityCacheUtil.removeResult(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiep2NganhNgheImpl.class,
			doanhNghiep2NganhNghe.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DoanhNghiep2NganhNghe> doanhNghiep2NganhNghes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DoanhNghiep2NganhNghe doanhNghiep2NganhNghe : doanhNghiep2NganhNghes) {
			EntityCacheUtil.removeResult(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
				DoanhNghiep2NganhNgheImpl.class,
				doanhNghiep2NganhNghe.getPrimaryKey());
		}
	}

	/**
	 * Creates a new doanh nghiep2 nganh nghe with the primary key. Does not add the doanh nghiep2 nganh nghe to the database.
	 *
	 * @param id the primary key for the new doanh nghiep2 nganh nghe
	 * @return the new doanh nghiep2 nganh nghe
	 */
	public DoanhNghiep2NganhNghe create(long id) {
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe = new DoanhNghiep2NganhNgheImpl();

		doanhNghiep2NganhNghe.setNew(true);
		doanhNghiep2NganhNghe.setPrimaryKey(id);

		return doanhNghiep2NganhNghe;
	}

	/**
	 * Removes the doanh nghiep2 nganh nghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doanh nghiep2 nganh nghe
	 * @return the doanh nghiep2 nganh nghe that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep2NganhNghe remove(long id)
		throws NoSuchDoanhNghiep2NganhNgheException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the doanh nghiep2 nganh nghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doanh nghiep2 nganh nghe
	 * @return the doanh nghiep2 nganh nghe that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoanhNghiep2NganhNghe remove(Serializable primaryKey)
		throws NoSuchDoanhNghiep2NganhNgheException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DoanhNghiep2NganhNghe doanhNghiep2NganhNghe = (DoanhNghiep2NganhNghe)session.get(DoanhNghiep2NganhNgheImpl.class,
					primaryKey);

			if (doanhNghiep2NganhNghe == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDoanhNghiep2NganhNgheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(doanhNghiep2NganhNghe);
		}
		catch (NoSuchDoanhNghiep2NganhNgheException nsee) {
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
	protected DoanhNghiep2NganhNghe removeImpl(
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) throws SystemException {
		doanhNghiep2NganhNghe = toUnwrappedModel(doanhNghiep2NganhNghe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, doanhNghiep2NganhNghe);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(doanhNghiep2NganhNghe);

		return doanhNghiep2NganhNghe;
	}

	@Override
	public DoanhNghiep2NganhNghe updateImpl(
		org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe doanhNghiep2NganhNghe,
		boolean merge) throws SystemException {
		doanhNghiep2NganhNghe = toUnwrappedModel(doanhNghiep2NganhNghe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, doanhNghiep2NganhNghe, merge);

			doanhNghiep2NganhNghe.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
			DoanhNghiep2NganhNgheImpl.class,
			doanhNghiep2NganhNghe.getPrimaryKey(), doanhNghiep2NganhNghe);

		return doanhNghiep2NganhNghe;
	}

	protected DoanhNghiep2NganhNghe toUnwrappedModel(
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		if (doanhNghiep2NganhNghe instanceof DoanhNghiep2NganhNgheImpl) {
			return doanhNghiep2NganhNghe;
		}

		DoanhNghiep2NganhNgheImpl doanhNghiep2NganhNgheImpl = new DoanhNghiep2NganhNgheImpl();

		doanhNghiep2NganhNgheImpl.setNew(doanhNghiep2NganhNghe.isNew());
		doanhNghiep2NganhNgheImpl.setPrimaryKey(doanhNghiep2NganhNghe.getPrimaryKey());

		doanhNghiep2NganhNgheImpl.setId(doanhNghiep2NganhNghe.getId());
		doanhNghiep2NganhNgheImpl.setLaNganhChinh(doanhNghiep2NganhNghe.getLaNganhChinh());
		doanhNghiep2NganhNgheImpl.setNgayTao(doanhNghiep2NganhNghe.getNgayTao());
		doanhNghiep2NganhNgheImpl.setNgaySua(doanhNghiep2NganhNghe.getNgaySua());
		doanhNghiep2NganhNgheImpl.setNguoiTao(doanhNghiep2NganhNghe.getNguoiTao());
		doanhNghiep2NganhNgheImpl.setNguoiSua(doanhNghiep2NganhNghe.getNguoiSua());
		doanhNghiep2NganhNgheImpl.setDaXoa(doanhNghiep2NganhNghe.getDaXoa());
		doanhNghiep2NganhNgheImpl.setDoanhNghiepId(doanhNghiep2NganhNghe.getDoanhNghiepId());
		doanhNghiep2NganhNgheImpl.setNganhNgheId(doanhNghiep2NganhNghe.getNganhNgheId());

		return doanhNghiep2NganhNgheImpl;
	}

	/**
	 * Returns the doanh nghiep2 nganh nghe with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the doanh nghiep2 nganh nghe
	 * @return the doanh nghiep2 nganh nghe
	 * @throws com.liferay.portal.NoSuchModelException if a doanh nghiep2 nganh nghe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoanhNghiep2NganhNghe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the doanh nghiep2 nganh nghe with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException} if it could not be found.
	 *
	 * @param id the primary key of the doanh nghiep2 nganh nghe
	 * @return the doanh nghiep2 nganh nghe
	 * @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep2NganhNghe findByPrimaryKey(long id)
		throws NoSuchDoanhNghiep2NganhNgheException, SystemException {
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe = fetchByPrimaryKey(id);

		if (doanhNghiep2NganhNghe == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDoanhNghiep2NganhNgheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return doanhNghiep2NganhNghe;
	}

	/**
	 * Returns the doanh nghiep2 nganh nghe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doanh nghiep2 nganh nghe
	 * @return the doanh nghiep2 nganh nghe, or <code>null</code> if a doanh nghiep2 nganh nghe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoanhNghiep2NganhNghe fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the doanh nghiep2 nganh nghe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the doanh nghiep2 nganh nghe
	 * @return the doanh nghiep2 nganh nghe, or <code>null</code> if a doanh nghiep2 nganh nghe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoanhNghiep2NganhNghe fetchByPrimaryKey(long id)
		throws SystemException {
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe = (DoanhNghiep2NganhNghe)EntityCacheUtil.getResult(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
				DoanhNghiep2NganhNgheImpl.class, id);

		if (doanhNghiep2NganhNghe == _nullDoanhNghiep2NganhNghe) {
			return null;
		}

		if (doanhNghiep2NganhNghe == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				doanhNghiep2NganhNghe = (DoanhNghiep2NganhNghe)session.get(DoanhNghiep2NganhNgheImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (doanhNghiep2NganhNghe != null) {
					cacheResult(doanhNghiep2NganhNghe);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DoanhNghiep2NganhNgheModelImpl.ENTITY_CACHE_ENABLED,
						DoanhNghiep2NganhNgheImpl.class, id,
						_nullDoanhNghiep2NganhNghe);
				}

				closeSession(session);
			}
		}

		return doanhNghiep2NganhNghe;
	}

	/**
	 * Returns all the doanh nghiep2 nganh nghes.
	 *
	 * @return the doanh nghiep2 nganh nghes
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep2NganhNghe> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doanh nghiep2 nganh nghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of doanh nghiep2 nganh nghes
	 * @param end the upper bound of the range of doanh nghiep2 nganh nghes (not inclusive)
	 * @return the range of doanh nghiep2 nganh nghes
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep2NganhNghe> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doanh nghiep2 nganh nghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of doanh nghiep2 nganh nghes
	 * @param end the upper bound of the range of doanh nghiep2 nganh nghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doanh nghiep2 nganh nghes
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoanhNghiep2NganhNghe> findAll(int start, int end,
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

		List<DoanhNghiep2NganhNghe> list = (List<DoanhNghiep2NganhNghe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOANHNGHIEP2NGANHNGHE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOANHNGHIEP2NGANHNGHE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DoanhNghiep2NganhNghe>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DoanhNghiep2NganhNghe>)QueryUtil.list(q,
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
	 * Removes all the doanh nghiep2 nganh nghes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DoanhNghiep2NganhNghe doanhNghiep2NganhNghe : findAll()) {
			remove(doanhNghiep2NganhNghe);
		}
	}

	/**
	 * Returns the number of doanh nghiep2 nganh nghes.
	 *
	 * @return the number of doanh nghiep2 nganh nghes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOANHNGHIEP2NGANHNGHE);

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
	 * Initializes the doanh nghiep2 nganh nghe persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DoanhNghiep2NganhNghe>> listenersList = new ArrayList<ModelListener<DoanhNghiep2NganhNghe>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DoanhNghiep2NganhNghe>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DoanhNghiep2NganhNgheImpl.class.getName());
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
	private static final String _SQL_SELECT_DOANHNGHIEP2NGANHNGHE = "SELECT doanhNghiep2NganhNghe FROM DoanhNghiep2NganhNghe doanhNghiep2NganhNghe";
	private static final String _SQL_COUNT_DOANHNGHIEP2NGANHNGHE = "SELECT COUNT(doanhNghiep2NganhNghe) FROM DoanhNghiep2NganhNghe doanhNghiep2NganhNghe";
	private static final String _ORDER_BY_ENTITY_ALIAS = "doanhNghiep2NganhNghe.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DoanhNghiep2NganhNghe exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DoanhNghiep2NganhNghePersistenceImpl.class);
	private static DoanhNghiep2NganhNghe _nullDoanhNghiep2NganhNghe = new DoanhNghiep2NganhNgheImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DoanhNghiep2NganhNghe> toCacheModel() {
				return _nullDoanhNghiep2NganhNgheCacheModel;
			}
		};

	private static CacheModel<DoanhNghiep2NganhNghe> _nullDoanhNghiep2NganhNgheCacheModel =
		new CacheModel<DoanhNghiep2NganhNghe>() {
			public DoanhNghiep2NganhNghe toEntityModel() {
				return _nullDoanhNghiep2NganhNghe;
			}
		};
}