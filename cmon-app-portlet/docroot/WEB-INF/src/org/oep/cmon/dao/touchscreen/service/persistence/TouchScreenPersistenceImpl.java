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

package org.oep.cmon.dao.touchscreen.service.persistence;

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

import org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException;
import org.oep.cmon.dao.touchscreen.model.TouchScreen;
import org.oep.cmon.dao.touchscreen.model.impl.TouchScreenImpl;
import org.oep.cmon.dao.touchscreen.model.impl.TouchScreenModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the touch screen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TouchScreenPersistence
 * @see TouchScreenUtil
 * @generated
 */
public class TouchScreenPersistenceImpl extends BasePersistenceImpl<TouchScreen>
	implements TouchScreenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TouchScreenUtil} to access the touch screen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TouchScreenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
			TouchScreenModelImpl.FINDER_CACHE_ENABLED, TouchScreenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
			TouchScreenModelImpl.FINDER_CACHE_ENABLED, TouchScreenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
			TouchScreenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the touch screen in the entity cache if it is enabled.
	 *
	 * @param touchScreen the touch screen
	 */
	public void cacheResult(TouchScreen touchScreen) {
		EntityCacheUtil.putResult(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
			TouchScreenImpl.class, touchScreen.getPrimaryKey(), touchScreen);

		touchScreen.resetOriginalValues();
	}

	/**
	 * Caches the touch screens in the entity cache if it is enabled.
	 *
	 * @param touchScreens the touch screens
	 */
	public void cacheResult(List<TouchScreen> touchScreens) {
		for (TouchScreen touchScreen : touchScreens) {
			if (EntityCacheUtil.getResult(
						TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
						TouchScreenImpl.class, touchScreen.getPrimaryKey()) == null) {
				cacheResult(touchScreen);
			}
			else {
				touchScreen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all touch screens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TouchScreenImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TouchScreenImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the touch screen.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TouchScreen touchScreen) {
		EntityCacheUtil.removeResult(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
			TouchScreenImpl.class, touchScreen.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TouchScreen> touchScreens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TouchScreen touchScreen : touchScreens) {
			EntityCacheUtil.removeResult(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
				TouchScreenImpl.class, touchScreen.getPrimaryKey());
		}
	}

	/**
	 * Creates a new touch screen with the primary key. Does not add the touch screen to the database.
	 *
	 * @param ID the primary key for the new touch screen
	 * @return the new touch screen
	 */
	public TouchScreen create(long ID) {
		TouchScreen touchScreen = new TouchScreenImpl();

		touchScreen.setNew(true);
		touchScreen.setPrimaryKey(ID);

		return touchScreen;
	}

	/**
	 * Removes the touch screen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the touch screen
	 * @return the touch screen that was removed
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TouchScreen remove(long ID)
		throws NoSuchTouchScreenException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the touch screen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the touch screen
	 * @return the touch screen that was removed
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TouchScreen remove(Serializable primaryKey)
		throws NoSuchTouchScreenException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TouchScreen touchScreen = (TouchScreen)session.get(TouchScreenImpl.class,
					primaryKey);

			if (touchScreen == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTouchScreenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(touchScreen);
		}
		catch (NoSuchTouchScreenException nsee) {
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
	protected TouchScreen removeImpl(TouchScreen touchScreen)
		throws SystemException {
		touchScreen = toUnwrappedModel(touchScreen);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, touchScreen);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(touchScreen);

		return touchScreen;
	}

	@Override
	public TouchScreen updateImpl(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen,
		boolean merge) throws SystemException {
		touchScreen = toUnwrappedModel(touchScreen);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, touchScreen, merge);

			touchScreen.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
			TouchScreenImpl.class, touchScreen.getPrimaryKey(), touchScreen);

		return touchScreen;
	}

	protected TouchScreen toUnwrappedModel(TouchScreen touchScreen) {
		if (touchScreen instanceof TouchScreenImpl) {
			return touchScreen;
		}

		TouchScreenImpl touchScreenImpl = new TouchScreenImpl();

		touchScreenImpl.setNew(touchScreen.isNew());
		touchScreenImpl.setPrimaryKey(touchScreen.getPrimaryKey());

		touchScreenImpl.setID(touchScreen.getID());
		touchScreenImpl.setNAME(touchScreen.getNAME());

		return touchScreenImpl;
	}

	/**
	 * Returns the touch screen with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the touch screen
	 * @return the touch screen
	 * @throws com.liferay.portal.NoSuchModelException if a touch screen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TouchScreen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the touch screen with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException} if it could not be found.
	 *
	 * @param ID the primary key of the touch screen
	 * @return the touch screen
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TouchScreen findByPrimaryKey(long ID)
		throws NoSuchTouchScreenException, SystemException {
		TouchScreen touchScreen = fetchByPrimaryKey(ID);

		if (touchScreen == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchTouchScreenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return touchScreen;
	}

	/**
	 * Returns the touch screen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the touch screen
	 * @return the touch screen, or <code>null</code> if a touch screen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TouchScreen fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the touch screen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the touch screen
	 * @return the touch screen, or <code>null</code> if a touch screen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TouchScreen fetchByPrimaryKey(long ID) throws SystemException {
		TouchScreen touchScreen = (TouchScreen)EntityCacheUtil.getResult(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
				TouchScreenImpl.class, ID);

		if (touchScreen == _nullTouchScreen) {
			return null;
		}

		if (touchScreen == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				touchScreen = (TouchScreen)session.get(TouchScreenImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (touchScreen != null) {
					cacheResult(touchScreen);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TouchScreenModelImpl.ENTITY_CACHE_ENABLED,
						TouchScreenImpl.class, ID, _nullTouchScreen);
				}

				closeSession(session);
			}
		}

		return touchScreen;
	}

	/**
	 * Returns all the touch screens.
	 *
	 * @return the touch screens
	 * @throws SystemException if a system exception occurred
	 */
	public List<TouchScreen> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the touch screens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of touch screens
	 * @param end the upper bound of the range of touch screens (not inclusive)
	 * @return the range of touch screens
	 * @throws SystemException if a system exception occurred
	 */
	public List<TouchScreen> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the touch screens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of touch screens
	 * @param end the upper bound of the range of touch screens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of touch screens
	 * @throws SystemException if a system exception occurred
	 */
	public List<TouchScreen> findAll(int start, int end,
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

		List<TouchScreen> list = (List<TouchScreen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOUCHSCREEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOUCHSCREEN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TouchScreen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TouchScreen>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the touch screens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TouchScreen touchScreen : findAll()) {
			remove(touchScreen);
		}
	}

	/**
	 * Returns the number of touch screens.
	 *
	 * @return the number of touch screens
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOUCHSCREEN);

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
	 * Initializes the touch screen persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.touchscreen.model.TouchScreen")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TouchScreen>> listenersList = new ArrayList<ModelListener<TouchScreen>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TouchScreen>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TouchScreenImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TouchScreenPersistence.class)
	protected TouchScreenPersistence touchScreenPersistence;
	@BeanReference(type = TraCuuHoSoTTHCCongPersistence.class)
	protected TraCuuHoSoTTHCCongPersistence traCuuHoSoTTHCCongPersistence;
	@BeanReference(type = TraCuuThuTucHanhChinhPersistence.class)
	protected TraCuuThuTucHanhChinhPersistence traCuuThuTucHanhChinhPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TOUCHSCREEN = "SELECT touchScreen FROM TouchScreen touchScreen";
	private static final String _SQL_COUNT_TOUCHSCREEN = "SELECT COUNT(touchScreen) FROM TouchScreen touchScreen";
	private static final String _ORDER_BY_ENTITY_ALIAS = "touchScreen.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TouchScreen exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TouchScreenPersistenceImpl.class);
	private static TouchScreen _nullTouchScreen = new TouchScreenImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TouchScreen> toCacheModel() {
				return _nullTouchScreenCacheModel;
			}
		};

	private static CacheModel<TouchScreen> _nullTouchScreenCacheModel = new CacheModel<TouchScreen>() {
			public TouchScreen toEntityModel() {
				return _nullTouchScreen;
			}
		};
}