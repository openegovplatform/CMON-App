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

import org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException;
import org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen;
import org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenImpl;
import org.oep.exch.dao.hoso.model.impl.UpdateHoSoTrucTuyenModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the update ho so truc tuyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see UpdateHoSoTrucTuyenPersistence
 * @see UpdateHoSoTrucTuyenUtil
 * @generated
 */
public class UpdateHoSoTrucTuyenPersistenceImpl extends BasePersistenceImpl<UpdateHoSoTrucTuyen>
	implements UpdateHoSoTrucTuyenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UpdateHoSoTrucTuyenUtil} to access the update ho so truc tuyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UpdateHoSoTrucTuyenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			UpdateHoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			UpdateHoSoTrucTuyenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			UpdateHoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			UpdateHoSoTrucTuyenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			UpdateHoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the update ho so truc tuyen in the entity cache if it is enabled.
	 *
	 * @param updateHoSoTrucTuyen the update ho so truc tuyen
	 */
	public void cacheResult(UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		EntityCacheUtil.putResult(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			UpdateHoSoTrucTuyenImpl.class, updateHoSoTrucTuyen.getPrimaryKey(),
			updateHoSoTrucTuyen);

		updateHoSoTrucTuyen.resetOriginalValues();
	}

	/**
	 * Caches the update ho so truc tuyens in the entity cache if it is enabled.
	 *
	 * @param updateHoSoTrucTuyens the update ho so truc tuyens
	 */
	public void cacheResult(List<UpdateHoSoTrucTuyen> updateHoSoTrucTuyens) {
		for (UpdateHoSoTrucTuyen updateHoSoTrucTuyen : updateHoSoTrucTuyens) {
			if (EntityCacheUtil.getResult(
						UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
						UpdateHoSoTrucTuyenImpl.class,
						updateHoSoTrucTuyen.getPrimaryKey()) == null) {
				cacheResult(updateHoSoTrucTuyen);
			}
			else {
				updateHoSoTrucTuyen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all update ho so truc tuyens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UpdateHoSoTrucTuyenImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UpdateHoSoTrucTuyenImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the update ho so truc tuyen.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		EntityCacheUtil.removeResult(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			UpdateHoSoTrucTuyenImpl.class, updateHoSoTrucTuyen.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UpdateHoSoTrucTuyen> updateHoSoTrucTuyens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UpdateHoSoTrucTuyen updateHoSoTrucTuyen : updateHoSoTrucTuyens) {
			EntityCacheUtil.removeResult(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
				UpdateHoSoTrucTuyenImpl.class,
				updateHoSoTrucTuyen.getPrimaryKey());
		}
	}

	/**
	 * Creates a new update ho so truc tuyen with the primary key. Does not add the update ho so truc tuyen to the database.
	 *
	 * @param id the primary key for the new update ho so truc tuyen
	 * @return the new update ho so truc tuyen
	 */
	public UpdateHoSoTrucTuyen create(long id) {
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen = new UpdateHoSoTrucTuyenImpl();

		updateHoSoTrucTuyen.setNew(true);
		updateHoSoTrucTuyen.setPrimaryKey(id);

		return updateHoSoTrucTuyen;
	}

	/**
	 * Removes the update ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the update ho so truc tuyen
	 * @return the update ho so truc tuyen that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdateHoSoTrucTuyen remove(long id)
		throws NoSuchUpdateHoSoTrucTuyenException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the update ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the update ho so truc tuyen
	 * @return the update ho so truc tuyen that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpdateHoSoTrucTuyen remove(Serializable primaryKey)
		throws NoSuchUpdateHoSoTrucTuyenException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UpdateHoSoTrucTuyen updateHoSoTrucTuyen = (UpdateHoSoTrucTuyen)session.get(UpdateHoSoTrucTuyenImpl.class,
					primaryKey);

			if (updateHoSoTrucTuyen == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpdateHoSoTrucTuyenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(updateHoSoTrucTuyen);
		}
		catch (NoSuchUpdateHoSoTrucTuyenException nsee) {
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
	protected UpdateHoSoTrucTuyen removeImpl(
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen) throws SystemException {
		updateHoSoTrucTuyen = toUnwrappedModel(updateHoSoTrucTuyen);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, updateHoSoTrucTuyen);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(updateHoSoTrucTuyen);

		return updateHoSoTrucTuyen;
	}

	@Override
	public UpdateHoSoTrucTuyen updateImpl(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen,
		boolean merge) throws SystemException {
		updateHoSoTrucTuyen = toUnwrappedModel(updateHoSoTrucTuyen);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, updateHoSoTrucTuyen, merge);

			updateHoSoTrucTuyen.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			UpdateHoSoTrucTuyenImpl.class, updateHoSoTrucTuyen.getPrimaryKey(),
			updateHoSoTrucTuyen);

		return updateHoSoTrucTuyen;
	}

	protected UpdateHoSoTrucTuyen toUnwrappedModel(
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		if (updateHoSoTrucTuyen instanceof UpdateHoSoTrucTuyenImpl) {
			return updateHoSoTrucTuyen;
		}

		UpdateHoSoTrucTuyenImpl updateHoSoTrucTuyenImpl = new UpdateHoSoTrucTuyenImpl();

		updateHoSoTrucTuyenImpl.setNew(updateHoSoTrucTuyen.isNew());
		updateHoSoTrucTuyenImpl.setPrimaryKey(updateHoSoTrucTuyen.getPrimaryKey());

		updateHoSoTrucTuyenImpl.setId(updateHoSoTrucTuyen.getId());
		updateHoSoTrucTuyenImpl.setTrangThaiXuLy(updateHoSoTrucTuyen.getTrangThaiXuLy());
		updateHoSoTrucTuyenImpl.setNgayChuyen(updateHoSoTrucTuyen.getNgayChuyen());

		return updateHoSoTrucTuyenImpl;
	}

	/**
	 * Returns the update ho so truc tuyen with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the update ho so truc tuyen
	 * @return the update ho so truc tuyen
	 * @throws com.liferay.portal.NoSuchModelException if a update ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpdateHoSoTrucTuyen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the update ho so truc tuyen with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException} if it could not be found.
	 *
	 * @param id the primary key of the update ho so truc tuyen
	 * @return the update ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdateHoSoTrucTuyen findByPrimaryKey(long id)
		throws NoSuchUpdateHoSoTrucTuyenException, SystemException {
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen = fetchByPrimaryKey(id);

		if (updateHoSoTrucTuyen == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchUpdateHoSoTrucTuyenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return updateHoSoTrucTuyen;
	}

	/**
	 * Returns the update ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the update ho so truc tuyen
	 * @return the update ho so truc tuyen, or <code>null</code> if a update ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpdateHoSoTrucTuyen fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the update ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the update ho so truc tuyen
	 * @return the update ho so truc tuyen, or <code>null</code> if a update ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdateHoSoTrucTuyen fetchByPrimaryKey(long id)
		throws SystemException {
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen = (UpdateHoSoTrucTuyen)EntityCacheUtil.getResult(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
				UpdateHoSoTrucTuyenImpl.class, id);

		if (updateHoSoTrucTuyen == _nullUpdateHoSoTrucTuyen) {
			return null;
		}

		if (updateHoSoTrucTuyen == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				updateHoSoTrucTuyen = (UpdateHoSoTrucTuyen)session.get(UpdateHoSoTrucTuyenImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (updateHoSoTrucTuyen != null) {
					cacheResult(updateHoSoTrucTuyen);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UpdateHoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
						UpdateHoSoTrucTuyenImpl.class, id,
						_nullUpdateHoSoTrucTuyen);
				}

				closeSession(session);
			}
		}

		return updateHoSoTrucTuyen;
	}

	/**
	 * Returns all the update ho so truc tuyens.
	 *
	 * @return the update ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<UpdateHoSoTrucTuyen> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the update ho so truc tuyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of update ho so truc tuyens
	 * @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	 * @return the range of update ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<UpdateHoSoTrucTuyen> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the update ho so truc tuyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of update ho so truc tuyens
	 * @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of update ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<UpdateHoSoTrucTuyen> findAll(int start, int end,
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

		List<UpdateHoSoTrucTuyen> list = (List<UpdateHoSoTrucTuyen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPDATEHOSOTRUCTUYEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPDATEHOSOTRUCTUYEN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UpdateHoSoTrucTuyen>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UpdateHoSoTrucTuyen>)QueryUtil.list(q,
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
	 * Removes all the update ho so truc tuyens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UpdateHoSoTrucTuyen updateHoSoTrucTuyen : findAll()) {
			remove(updateHoSoTrucTuyen);
		}
	}

	/**
	 * Returns the number of update ho so truc tuyens.
	 *
	 * @return the number of update ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UPDATEHOSOTRUCTUYEN);

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
	 * Initializes the update ho so truc tuyen persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UpdateHoSoTrucTuyen>> listenersList = new ArrayList<ModelListener<UpdateHoSoTrucTuyen>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UpdateHoSoTrucTuyen>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UpdateHoSoTrucTuyenImpl.class.getName());
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
	private static final String _SQL_SELECT_UPDATEHOSOTRUCTUYEN = "SELECT updateHoSoTrucTuyen FROM UpdateHoSoTrucTuyen updateHoSoTrucTuyen";
	private static final String _SQL_COUNT_UPDATEHOSOTRUCTUYEN = "SELECT COUNT(updateHoSoTrucTuyen) FROM UpdateHoSoTrucTuyen updateHoSoTrucTuyen";
	private static final String _ORDER_BY_ENTITY_ALIAS = "updateHoSoTrucTuyen.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpdateHoSoTrucTuyen exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UpdateHoSoTrucTuyenPersistenceImpl.class);
	private static UpdateHoSoTrucTuyen _nullUpdateHoSoTrucTuyen = new UpdateHoSoTrucTuyenImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UpdateHoSoTrucTuyen> toCacheModel() {
				return _nullUpdateHoSoTrucTuyenCacheModel;
			}
		};

	private static CacheModel<UpdateHoSoTrucTuyen> _nullUpdateHoSoTrucTuyenCacheModel =
		new CacheModel<UpdateHoSoTrucTuyen>() {
			public UpdateHoSoTrucTuyen toEntityModel() {
				return _nullUpdateHoSoTrucTuyen;
			}
		};
}