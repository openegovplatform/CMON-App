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

package org.oep.cmon.dao.dvc.service.persistence;

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

import org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException;
import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc;
import org.oep.cmon.dao.dvc.model.impl.CauHinhPortlet2ThuTucImpl;
import org.oep.cmon.dao.dvc.model.impl.CauHinhPortlet2ThuTucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cau hinh portlet2 thu tuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see CauHinhPortlet2ThuTucPersistence
 * @see CauHinhPortlet2ThuTucUtil
 * @generated
 */
public class CauHinhPortlet2ThuTucPersistenceImpl extends BasePersistenceImpl<CauHinhPortlet2ThuTuc>
	implements CauHinhPortlet2ThuTucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CauHinhPortlet2ThuTucUtil} to access the cau hinh portlet2 thu tuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CauHinhPortlet2ThuTucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID = new FinderPath(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucModelImpl.FINDER_CACHE_ENABLED,
			CauHinhPortlet2ThuTucImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByThuTucHanhChinhId", new String[] { Long.class.getName() },
			CauHinhPortlet2ThuTucModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID = new FinderPath(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTucHanhChinhId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucModelImpl.FINDER_CACHE_ENABLED,
			CauHinhPortlet2ThuTucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucModelImpl.FINDER_CACHE_ENABLED,
			CauHinhPortlet2ThuTucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cau hinh portlet2 thu tuc in the entity cache if it is enabled.
	 *
	 * @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	 */
	public void cacheResult(CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		EntityCacheUtil.putResult(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucImpl.class,
			cauHinhPortlet2ThuTuc.getPrimaryKey(), cauHinhPortlet2ThuTuc);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
			new Object[] {
				Long.valueOf(cauHinhPortlet2ThuTuc.getThuTucHanhChinhId())
			}, cauHinhPortlet2ThuTuc);

		cauHinhPortlet2ThuTuc.resetOriginalValues();
	}

	/**
	 * Caches the cau hinh portlet2 thu tucs in the entity cache if it is enabled.
	 *
	 * @param cauHinhPortlet2ThuTucs the cau hinh portlet2 thu tucs
	 */
	public void cacheResult(List<CauHinhPortlet2ThuTuc> cauHinhPortlet2ThuTucs) {
		for (CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc : cauHinhPortlet2ThuTucs) {
			if (EntityCacheUtil.getResult(
						CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
						CauHinhPortlet2ThuTucImpl.class,
						cauHinhPortlet2ThuTuc.getPrimaryKey()) == null) {
				cacheResult(cauHinhPortlet2ThuTuc);
			}
			else {
				cauHinhPortlet2ThuTuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cau hinh portlet2 thu tucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CauHinhPortlet2ThuTucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CauHinhPortlet2ThuTucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cau hinh portlet2 thu tuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		EntityCacheUtil.removeResult(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucImpl.class,
			cauHinhPortlet2ThuTuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cauHinhPortlet2ThuTuc);
	}

	@Override
	public void clearCache(List<CauHinhPortlet2ThuTuc> cauHinhPortlet2ThuTucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc : cauHinhPortlet2ThuTucs) {
			EntityCacheUtil.removeResult(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
				CauHinhPortlet2ThuTucImpl.class,
				cauHinhPortlet2ThuTuc.getPrimaryKey());

			clearUniqueFindersCache(cauHinhPortlet2ThuTuc);
		}
	}

	protected void clearUniqueFindersCache(
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
			new Object[] {
				Long.valueOf(cauHinhPortlet2ThuTuc.getThuTucHanhChinhId())
			});
	}

	/**
	 * Creates a new cau hinh portlet2 thu tuc with the primary key. Does not add the cau hinh portlet2 thu tuc to the database.
	 *
	 * @param thuTucHanhChinhId the primary key for the new cau hinh portlet2 thu tuc
	 * @return the new cau hinh portlet2 thu tuc
	 */
	public CauHinhPortlet2ThuTuc create(long thuTucHanhChinhId) {
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = new CauHinhPortlet2ThuTucImpl();

		cauHinhPortlet2ThuTuc.setNew(true);
		cauHinhPortlet2ThuTuc.setPrimaryKey(thuTucHanhChinhId);

		return cauHinhPortlet2ThuTuc;
	}

	/**
	 * Removes the cau hinh portlet2 thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	 * @return the cau hinh portlet2 thu tuc that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CauHinhPortlet2ThuTuc remove(long thuTucHanhChinhId)
		throws NoSuchCauHinhPortlet2ThuTucException, SystemException {
		return remove(Long.valueOf(thuTucHanhChinhId));
	}

	/**
	 * Removes the cau hinh portlet2 thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cau hinh portlet2 thu tuc
	 * @return the cau hinh portlet2 thu tuc that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CauHinhPortlet2ThuTuc remove(Serializable primaryKey)
		throws NoSuchCauHinhPortlet2ThuTucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = (CauHinhPortlet2ThuTuc)session.get(CauHinhPortlet2ThuTucImpl.class,
					primaryKey);

			if (cauHinhPortlet2ThuTuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCauHinhPortlet2ThuTucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cauHinhPortlet2ThuTuc);
		}
		catch (NoSuchCauHinhPortlet2ThuTucException nsee) {
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
	protected CauHinhPortlet2ThuTuc removeImpl(
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) throws SystemException {
		cauHinhPortlet2ThuTuc = toUnwrappedModel(cauHinhPortlet2ThuTuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cauHinhPortlet2ThuTuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cauHinhPortlet2ThuTuc);

		return cauHinhPortlet2ThuTuc;
	}

	@Override
	public CauHinhPortlet2ThuTuc updateImpl(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc,
		boolean merge) throws SystemException {
		cauHinhPortlet2ThuTuc = toUnwrappedModel(cauHinhPortlet2ThuTuc);

		boolean isNew = cauHinhPortlet2ThuTuc.isNew();

		CauHinhPortlet2ThuTucModelImpl cauHinhPortlet2ThuTucModelImpl = (CauHinhPortlet2ThuTucModelImpl)cauHinhPortlet2ThuTuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cauHinhPortlet2ThuTuc, merge);

			cauHinhPortlet2ThuTuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CauHinhPortlet2ThuTucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhPortlet2ThuTucImpl.class,
			cauHinhPortlet2ThuTuc.getPrimaryKey(), cauHinhPortlet2ThuTuc);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
				new Object[] {
					Long.valueOf(cauHinhPortlet2ThuTuc.getThuTucHanhChinhId())
				}, cauHinhPortlet2ThuTuc);
		}
		else {
			if ((cauHinhPortlet2ThuTucModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(cauHinhPortlet2ThuTucModelImpl.getOriginalThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
					new Object[] {
						Long.valueOf(
							cauHinhPortlet2ThuTuc.getThuTucHanhChinhId())
					}, cauHinhPortlet2ThuTuc);
			}
		}

		return cauHinhPortlet2ThuTuc;
	}

	protected CauHinhPortlet2ThuTuc toUnwrappedModel(
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		if (cauHinhPortlet2ThuTuc instanceof CauHinhPortlet2ThuTucImpl) {
			return cauHinhPortlet2ThuTuc;
		}

		CauHinhPortlet2ThuTucImpl cauHinhPortlet2ThuTucImpl = new CauHinhPortlet2ThuTucImpl();

		cauHinhPortlet2ThuTucImpl.setNew(cauHinhPortlet2ThuTuc.isNew());
		cauHinhPortlet2ThuTucImpl.setPrimaryKey(cauHinhPortlet2ThuTuc.getPrimaryKey());

		cauHinhPortlet2ThuTucImpl.setThuTucHanhChinhId(cauHinhPortlet2ThuTuc.getThuTucHanhChinhId());
		cauHinhPortlet2ThuTucImpl.setPortletId(cauHinhPortlet2ThuTuc.getPortletId());
		cauHinhPortlet2ThuTucImpl.setPortletName(cauHinhPortlet2ThuTuc.getPortletName());

		return cauHinhPortlet2ThuTucImpl;
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cau hinh portlet2 thu tuc
	 * @return the cau hinh portlet2 thu tuc
	 * @throws com.liferay.portal.NoSuchModelException if a cau hinh portlet2 thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CauHinhPortlet2ThuTuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException} if it could not be found.
	 *
	 * @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	 * @return the cau hinh portlet2 thu tuc
	 * @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CauHinhPortlet2ThuTuc findByPrimaryKey(long thuTucHanhChinhId)
		throws NoSuchCauHinhPortlet2ThuTucException, SystemException {
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = fetchByPrimaryKey(thuTucHanhChinhId);

		if (cauHinhPortlet2ThuTuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + thuTucHanhChinhId);
			}

			throw new NoSuchCauHinhPortlet2ThuTucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				thuTucHanhChinhId);
		}

		return cauHinhPortlet2ThuTuc;
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cau hinh portlet2 thu tuc
	 * @return the cau hinh portlet2 thu tuc, or <code>null</code> if a cau hinh portlet2 thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CauHinhPortlet2ThuTuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	 * @return the cau hinh portlet2 thu tuc, or <code>null</code> if a cau hinh portlet2 thu tuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CauHinhPortlet2ThuTuc fetchByPrimaryKey(long thuTucHanhChinhId)
		throws SystemException {
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = (CauHinhPortlet2ThuTuc)EntityCacheUtil.getResult(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
				CauHinhPortlet2ThuTucImpl.class, thuTucHanhChinhId);

		if (cauHinhPortlet2ThuTuc == _nullCauHinhPortlet2ThuTuc) {
			return null;
		}

		if (cauHinhPortlet2ThuTuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cauHinhPortlet2ThuTuc = (CauHinhPortlet2ThuTuc)session.get(CauHinhPortlet2ThuTucImpl.class,
						Long.valueOf(thuTucHanhChinhId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cauHinhPortlet2ThuTuc != null) {
					cacheResult(cauHinhPortlet2ThuTuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CauHinhPortlet2ThuTucModelImpl.ENTITY_CACHE_ENABLED,
						CauHinhPortlet2ThuTucImpl.class, thuTucHanhChinhId,
						_nullCauHinhPortlet2ThuTuc);
				}

				closeSession(session);
			}
		}

		return cauHinhPortlet2ThuTuc;
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException} if it could not be found.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching cau hinh portlet2 thu tuc
	 * @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a matching cau hinh portlet2 thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CauHinhPortlet2ThuTuc findByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws NoSuchCauHinhPortlet2ThuTucException, SystemException {
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = fetchByThuTucHanhChinhId(thuTucHanhChinhId);

		if (cauHinhPortlet2ThuTuc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCauHinhPortlet2ThuTucException(msg.toString());
		}

		return cauHinhPortlet2ThuTuc;
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching cau hinh portlet2 thu tuc, or <code>null</code> if a matching cau hinh portlet2 thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CauHinhPortlet2ThuTuc fetchByThuTucHanhChinhId(
		long thuTucHanhChinhId) throws SystemException {
		return fetchByThuTucHanhChinhId(thuTucHanhChinhId, true);
	}

	/**
	 * Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cau hinh portlet2 thu tuc, or <code>null</code> if a matching cau hinh portlet2 thu tuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CauHinhPortlet2ThuTuc fetchByThuTucHanhChinhId(
		long thuTucHanhChinhId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAUHINHPORTLET2THUTUC_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			query.append(CauHinhPortlet2ThuTucModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				List<CauHinhPortlet2ThuTuc> list = q.list();

				result = list;

				CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
						finderArgs, list);
				}
				else {
					cauHinhPortlet2ThuTuc = list.get(0);

					cacheResult(cauHinhPortlet2ThuTuc);

					if ((cauHinhPortlet2ThuTuc.getThuTucHanhChinhId() != thuTucHanhChinhId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
							finderArgs, cauHinhPortlet2ThuTuc);
					}
				}

				return cauHinhPortlet2ThuTuc;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THUTUCHANHCHINHID,
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
				return (CauHinhPortlet2ThuTuc)result;
			}
		}
	}

	/**
	 * Returns all the cau hinh portlet2 thu tucs.
	 *
	 * @return the cau hinh portlet2 thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CauHinhPortlet2ThuTuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cau hinh portlet2 thu tucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh portlet2 thu tucs
	 * @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	 * @return the range of cau hinh portlet2 thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CauHinhPortlet2ThuTuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cau hinh portlet2 thu tucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh portlet2 thu tucs
	 * @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cau hinh portlet2 thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CauHinhPortlet2ThuTuc> findAll(int start, int end,
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

		List<CauHinhPortlet2ThuTuc> list = (List<CauHinhPortlet2ThuTuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAUHINHPORTLET2THUTUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAUHINHPORTLET2THUTUC.concat(CauHinhPortlet2ThuTucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CauHinhPortlet2ThuTuc>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CauHinhPortlet2ThuTuc>)QueryUtil.list(q,
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
	 * Removes the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws NoSuchCauHinhPortlet2ThuTucException, SystemException {
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc = findByThuTucHanhChinhId(thuTucHanhChinhId);

		remove(cauHinhPortlet2ThuTuc);
	}

	/**
	 * Removes all the cau hinh portlet2 thu tucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc : findAll()) {
			remove(cauHinhPortlet2ThuTuc);
		}
	}

	/**
	 * Returns the number of cau hinh portlet2 thu tucs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the number of matching cau hinh portlet2 thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAUHINHPORTLET2THUTUC_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cau hinh portlet2 thu tucs.
	 *
	 * @return the number of cau hinh portlet2 thu tucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAUHINHPORTLET2THUTUC);

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
	 * Initializes the cau hinh portlet2 thu tuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CauHinhPortlet2ThuTuc>> listenersList = new ArrayList<ModelListener<CauHinhPortlet2ThuTuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CauHinhPortlet2ThuTuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CauHinhPortlet2ThuTucImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapNhatKetQuaPersistence.class)
	protected CapNhatKetQuaPersistence capNhatKetQuaPersistence;
	@BeanReference(type = CauHinhPortlet2ThuTucPersistence.class)
	protected CauHinhPortlet2ThuTucPersistence cauHinhPortlet2ThuTucPersistence;
	@BeanReference(type = DanhMucGiayTo2DoiTuongSuDungPersistence.class)
	protected DanhMucGiayTo2DoiTuongSuDungPersistence danhMucGiayTo2DoiTuongSuDungPersistence;
	@BeanReference(type = DanhMucUngDungPersistence.class)
	protected DanhMucUngDungPersistence danhMucUngDungPersistence;
	@BeanReference(type = DoiTuongSuDungPersistence.class)
	protected DoiTuongSuDungPersistence doiTuongSuDungPersistence;
	@BeanReference(type = NhomThuTucHanhChinhPersistence.class)
	protected NhomThuTucHanhChinhPersistence nhomThuTucHanhChinhPersistence;
	@BeanReference(type = ThuTuc2GiayToPersistence.class)
	protected ThuTuc2GiayToPersistence thuTuc2GiayToPersistence;
	@BeanReference(type = ThuTucHanhChinhPersistence.class)
	protected ThuTucHanhChinhPersistence thuTucHanhChinhPersistence;
	@BeanReference(type = TTHC2CoQuanQuanLyPersistence.class)
	protected TTHC2CoQuanQuanLyPersistence tthc2CoQuanQuanLyPersistence;
	@BeanReference(type = TTHC2DoiTuongSuDungPersistence.class)
	protected TTHC2DoiTuongSuDungPersistence tthc2DoiTuongSuDungPersistence;
	@BeanReference(type = VanBanHuongDanPersistence.class)
	protected VanBanHuongDanPersistence vanBanHuongDanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CAUHINHPORTLET2THUTUC = "SELECT cauHinhPortlet2ThuTuc FROM CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc";
	private static final String _SQL_SELECT_CAUHINHPORTLET2THUTUC_WHERE = "SELECT cauHinhPortlet2ThuTuc FROM CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc WHERE ";
	private static final String _SQL_COUNT_CAUHINHPORTLET2THUTUC = "SELECT COUNT(cauHinhPortlet2ThuTuc) FROM CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc";
	private static final String _SQL_COUNT_CAUHINHPORTLET2THUTUC_WHERE = "SELECT COUNT(cauHinhPortlet2ThuTuc) FROM CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc WHERE ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2 =
		"cauHinhPortlet2ThuTuc.thuTucHanhChinhId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cauHinhPortlet2ThuTuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CauHinhPortlet2ThuTuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CauHinhPortlet2ThuTuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CauHinhPortlet2ThuTucPersistenceImpl.class);
	private static CauHinhPortlet2ThuTuc _nullCauHinhPortlet2ThuTuc = new CauHinhPortlet2ThuTucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CauHinhPortlet2ThuTuc> toCacheModel() {
				return _nullCauHinhPortlet2ThuTucCacheModel;
			}
		};

	private static CacheModel<CauHinhPortlet2ThuTuc> _nullCauHinhPortlet2ThuTucCacheModel =
		new CacheModel<CauHinhPortlet2ThuTuc>() {
			public CauHinhPortlet2ThuTuc toEntityModel() {
				return _nullCauHinhPortlet2ThuTuc;
			}
		};
}