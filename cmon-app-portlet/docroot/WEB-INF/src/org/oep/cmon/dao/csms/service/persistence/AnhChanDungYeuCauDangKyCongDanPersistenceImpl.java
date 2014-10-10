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

package org.oep.cmon.dao.csms.service.persistence;

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

import org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException;
import org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan;
import org.oep.cmon.dao.csms.model.impl.AnhChanDungYeuCauDangKyCongDanImpl;
import org.oep.cmon.dao.csms.model.impl.AnhChanDungYeuCauDangKyCongDanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the anh chan dung yeu cau dang ky cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see AnhChanDungYeuCauDangKyCongDanPersistence
 * @see AnhChanDungYeuCauDangKyCongDanUtil
 * @generated
 */
public class AnhChanDungYeuCauDangKyCongDanPersistenceImpl
	extends BasePersistenceImpl<AnhChanDungYeuCauDangKyCongDan>
	implements AnhChanDungYeuCauDangKyCongDanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnhChanDungYeuCauDangKyCongDanUtil} to access the anh chan dung yeu cau dang ky cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnhChanDungYeuCauDangKyCongDanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the anh chan dung yeu cau dang ky cong dan in the entity cache if it is enabled.
	 *
	 * @param anhChanDungYeuCauDangKyCongDan the anh chan dung yeu cau dang ky cong dan
	 */
	public void cacheResult(
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan) {
		EntityCacheUtil.putResult(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanImpl.class,
			anhChanDungYeuCauDangKyCongDan.getPrimaryKey(),
			anhChanDungYeuCauDangKyCongDan);

		anhChanDungYeuCauDangKyCongDan.resetOriginalValues();
	}

	/**
	 * Caches the anh chan dung yeu cau dang ky cong dans in the entity cache if it is enabled.
	 *
	 * @param anhChanDungYeuCauDangKyCongDans the anh chan dung yeu cau dang ky cong dans
	 */
	public void cacheResult(
		List<AnhChanDungYeuCauDangKyCongDan> anhChanDungYeuCauDangKyCongDans) {
		for (AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan : anhChanDungYeuCauDangKyCongDans) {
			if (EntityCacheUtil.getResult(
						AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
						AnhChanDungYeuCauDangKyCongDanImpl.class,
						anhChanDungYeuCauDangKyCongDan.getPrimaryKey()) == null) {
				cacheResult(anhChanDungYeuCauDangKyCongDan);
			}
			else {
				anhChanDungYeuCauDangKyCongDan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all anh chan dung yeu cau dang ky cong dans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnhChanDungYeuCauDangKyCongDanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnhChanDungYeuCauDangKyCongDanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the anh chan dung yeu cau dang ky cong dan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan) {
		EntityCacheUtil.removeResult(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanImpl.class,
			anhChanDungYeuCauDangKyCongDan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<AnhChanDungYeuCauDangKyCongDan> anhChanDungYeuCauDangKyCongDans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan : anhChanDungYeuCauDangKyCongDans) {
			EntityCacheUtil.removeResult(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
				AnhChanDungYeuCauDangKyCongDanImpl.class,
				anhChanDungYeuCauDangKyCongDan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new anh chan dung yeu cau dang ky cong dan with the primary key. Does not add the anh chan dung yeu cau dang ky cong dan to the database.
	 *
	 * @param id the primary key for the new anh chan dung yeu cau dang ky cong dan
	 * @return the new anh chan dung yeu cau dang ky cong dan
	 */
	public AnhChanDungYeuCauDangKyCongDan create(long id) {
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan = new AnhChanDungYeuCauDangKyCongDanImpl();

		anhChanDungYeuCauDangKyCongDan.setNew(true);
		anhChanDungYeuCauDangKyCongDan.setPrimaryKey(id);

		return anhChanDungYeuCauDangKyCongDan;
	}

	/**
	 * Removes the anh chan dung yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	 * @return the anh chan dung yeu cau dang ky cong dan that was removed
	 * @throws org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhChanDungYeuCauDangKyCongDan remove(long id)
		throws NoSuchAnhChanDungYeuCauDangKyCongDanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the anh chan dung yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the anh chan dung yeu cau dang ky cong dan
	 * @return the anh chan dung yeu cau dang ky cong dan that was removed
	 * @throws org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhChanDungYeuCauDangKyCongDan remove(Serializable primaryKey)
		throws NoSuchAnhChanDungYeuCauDangKyCongDanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan = (AnhChanDungYeuCauDangKyCongDan)session.get(AnhChanDungYeuCauDangKyCongDanImpl.class,
					primaryKey);

			if (anhChanDungYeuCauDangKyCongDan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnhChanDungYeuCauDangKyCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anhChanDungYeuCauDangKyCongDan);
		}
		catch (NoSuchAnhChanDungYeuCauDangKyCongDanException nsee) {
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
	protected AnhChanDungYeuCauDangKyCongDan removeImpl(
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan)
		throws SystemException {
		anhChanDungYeuCauDangKyCongDan = toUnwrappedModel(anhChanDungYeuCauDangKyCongDan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, anhChanDungYeuCauDangKyCongDan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(anhChanDungYeuCauDangKyCongDan);

		return anhChanDungYeuCauDangKyCongDan;
	}

	@Override
	public AnhChanDungYeuCauDangKyCongDan updateImpl(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan,
		boolean merge) throws SystemException {
		anhChanDungYeuCauDangKyCongDan = toUnwrappedModel(anhChanDungYeuCauDangKyCongDan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, anhChanDungYeuCauDangKyCongDan,
				merge);

			anhChanDungYeuCauDangKyCongDan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			AnhChanDungYeuCauDangKyCongDanImpl.class,
			anhChanDungYeuCauDangKyCongDan.getPrimaryKey(),
			anhChanDungYeuCauDangKyCongDan);

		return anhChanDungYeuCauDangKyCongDan;
	}

	protected AnhChanDungYeuCauDangKyCongDan toUnwrappedModel(
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan) {
		if (anhChanDungYeuCauDangKyCongDan instanceof AnhChanDungYeuCauDangKyCongDanImpl) {
			return anhChanDungYeuCauDangKyCongDan;
		}

		AnhChanDungYeuCauDangKyCongDanImpl anhChanDungYeuCauDangKyCongDanImpl = new AnhChanDungYeuCauDangKyCongDanImpl();

		anhChanDungYeuCauDangKyCongDanImpl.setNew(anhChanDungYeuCauDangKyCongDan.isNew());
		anhChanDungYeuCauDangKyCongDanImpl.setPrimaryKey(anhChanDungYeuCauDangKyCongDan.getPrimaryKey());

		anhChanDungYeuCauDangKyCongDanImpl.setId(anhChanDungYeuCauDangKyCongDan.getId());
		anhChanDungYeuCauDangKyCongDanImpl.setAnhChanDung(anhChanDungYeuCauDangKyCongDan.getAnhChanDung());

		return anhChanDungYeuCauDangKyCongDanImpl;
	}

	/**
	 * Returns the anh chan dung yeu cau dang ky cong dan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the anh chan dung yeu cau dang ky cong dan
	 * @return the anh chan dung yeu cau dang ky cong dan
	 * @throws com.liferay.portal.NoSuchModelException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhChanDungYeuCauDangKyCongDan findByPrimaryKey(
		Serializable primaryKey) throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the anh chan dung yeu cau dang ky cong dan with the primary key or throws a {@link org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException} if it could not be found.
	 *
	 * @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	 * @return the anh chan dung yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchAnhChanDungYeuCauDangKyCongDanException if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhChanDungYeuCauDangKyCongDan findByPrimaryKey(long id)
		throws NoSuchAnhChanDungYeuCauDangKyCongDanException, SystemException {
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan = fetchByPrimaryKey(id);

		if (anhChanDungYeuCauDangKyCongDan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchAnhChanDungYeuCauDangKyCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return anhChanDungYeuCauDangKyCongDan;
	}

	/**
	 * Returns the anh chan dung yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the anh chan dung yeu cau dang ky cong dan
	 * @return the anh chan dung yeu cau dang ky cong dan, or <code>null</code> if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnhChanDungYeuCauDangKyCongDan fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the anh chan dung yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the anh chan dung yeu cau dang ky cong dan
	 * @return the anh chan dung yeu cau dang ky cong dan, or <code>null</code> if a anh chan dung yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnhChanDungYeuCauDangKyCongDan fetchByPrimaryKey(long id)
		throws SystemException {
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan = (AnhChanDungYeuCauDangKyCongDan)EntityCacheUtil.getResult(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
				AnhChanDungYeuCauDangKyCongDanImpl.class, id);

		if (anhChanDungYeuCauDangKyCongDan == _nullAnhChanDungYeuCauDangKyCongDan) {
			return null;
		}

		if (anhChanDungYeuCauDangKyCongDan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				anhChanDungYeuCauDangKyCongDan = (AnhChanDungYeuCauDangKyCongDan)session.get(AnhChanDungYeuCauDangKyCongDanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (anhChanDungYeuCauDangKyCongDan != null) {
					cacheResult(anhChanDungYeuCauDangKyCongDan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnhChanDungYeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
						AnhChanDungYeuCauDangKyCongDanImpl.class, id,
						_nullAnhChanDungYeuCauDangKyCongDan);
				}

				closeSession(session);
			}
		}

		return anhChanDungYeuCauDangKyCongDan;
	}

	/**
	 * Returns all the anh chan dung yeu cau dang ky cong dans.
	 *
	 * @return the anh chan dung yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhChanDungYeuCauDangKyCongDan> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anh chan dung yeu cau dang ky cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of anh chan dung yeu cau dang ky cong dans
	 * @param end the upper bound of the range of anh chan dung yeu cau dang ky cong dans (not inclusive)
	 * @return the range of anh chan dung yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhChanDungYeuCauDangKyCongDan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the anh chan dung yeu cau dang ky cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of anh chan dung yeu cau dang ky cong dans
	 * @param end the upper bound of the range of anh chan dung yeu cau dang ky cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of anh chan dung yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnhChanDungYeuCauDangKyCongDan> findAll(int start, int end,
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

		List<AnhChanDungYeuCauDangKyCongDan> list = (List<AnhChanDungYeuCauDangKyCongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANHCHANDUNGYEUCAUDANGKYCONGDAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANHCHANDUNGYEUCAUDANGKYCONGDAN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AnhChanDungYeuCauDangKyCongDan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AnhChanDungYeuCauDangKyCongDan>)QueryUtil.list(q,
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
	 * Removes all the anh chan dung yeu cau dang ky cong dans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan : findAll()) {
			remove(anhChanDungYeuCauDangKyCongDan);
		}
	}

	/**
	 * Returns the number of anh chan dung yeu cau dang ky cong dans.
	 *
	 * @return the number of anh chan dung yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANHCHANDUNGYEUCAUDANGKYCONGDAN);

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
	 * Initializes the anh chan dung yeu cau dang ky cong dan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnhChanDungYeuCauDangKyCongDan>> listenersList =
					new ArrayList<ModelListener<AnhChanDungYeuCauDangKyCongDan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnhChanDungYeuCauDangKyCongDan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnhChanDungYeuCauDangKyCongDanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnhChanDungYeuCauDangKyCongDanPersistence.class)
	protected AnhChanDungYeuCauDangKyCongDanPersistence anhChanDungYeuCauDangKyCongDanPersistence;
	@BeanReference(type = YeuCauDangKyCongDanPersistence.class)
	protected YeuCauDangKyCongDanPersistence yeuCauDangKyCongDanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ANHCHANDUNGYEUCAUDANGKYCONGDAN = "SELECT anhChanDungYeuCauDangKyCongDan FROM AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan";
	private static final String _SQL_COUNT_ANHCHANDUNGYEUCAUDANGKYCONGDAN = "SELECT COUNT(anhChanDungYeuCauDangKyCongDan) FROM AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anhChanDungYeuCauDangKyCongDan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnhChanDungYeuCauDangKyCongDan exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnhChanDungYeuCauDangKyCongDanPersistenceImpl.class);
	private static AnhChanDungYeuCauDangKyCongDan _nullAnhChanDungYeuCauDangKyCongDan =
		new AnhChanDungYeuCauDangKyCongDanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnhChanDungYeuCauDangKyCongDan> toCacheModel() {
				return _nullAnhChanDungYeuCauDangKyCongDanCacheModel;
			}
		};

	private static CacheModel<AnhChanDungYeuCauDangKyCongDan> _nullAnhChanDungYeuCauDangKyCongDanCacheModel =
		new CacheModel<AnhChanDungYeuCauDangKyCongDan>() {
			public AnhChanDungYeuCauDangKyCongDan toEntityModel() {
				return _nullAnhChanDungYeuCauDangKyCongDan;
			}
		};
}