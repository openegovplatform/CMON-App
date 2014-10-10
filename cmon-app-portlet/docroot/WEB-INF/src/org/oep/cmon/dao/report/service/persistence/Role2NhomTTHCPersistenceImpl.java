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

import org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException;
import org.oep.cmon.dao.report.model.Role2NhomTTHC;
import org.oep.cmon.dao.report.model.impl.Role2NhomTTHCImpl;
import org.oep.cmon.dao.report.model.impl.Role2NhomTTHCModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the role2 nhom t t h c service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2NhomTTHCPersistence
 * @see Role2NhomTTHCUtil
 * @generated
 */
public class Role2NhomTTHCPersistenceImpl extends BasePersistenceImpl<Role2NhomTTHC>
	implements Role2NhomTTHCPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Role2NhomTTHCUtil} to access the role2 nhom t t h c persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Role2NhomTTHCImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2NhomTTHCModelImpl.FINDER_CACHE_ENABLED,
			Role2NhomTTHCImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2NhomTTHCModelImpl.FINDER_CACHE_ENABLED,
			Role2NhomTTHCImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2NhomTTHCModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the role2 nhom t t h c in the entity cache if it is enabled.
	 *
	 * @param role2NhomTTHC the role2 nhom t t h c
	 */
	public void cacheResult(Role2NhomTTHC role2NhomTTHC) {
		EntityCacheUtil.putResult(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2NhomTTHCImpl.class, role2NhomTTHC.getPrimaryKey(),
			role2NhomTTHC);

		role2NhomTTHC.resetOriginalValues();
	}

	/**
	 * Caches the role2 nhom t t h cs in the entity cache if it is enabled.
	 *
	 * @param role2NhomTTHCs the role2 nhom t t h cs
	 */
	public void cacheResult(List<Role2NhomTTHC> role2NhomTTHCs) {
		for (Role2NhomTTHC role2NhomTTHC : role2NhomTTHCs) {
			if (EntityCacheUtil.getResult(
						Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
						Role2NhomTTHCImpl.class, role2NhomTTHC.getPrimaryKey()) == null) {
				cacheResult(role2NhomTTHC);
			}
			else {
				role2NhomTTHC.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all role2 nhom t t h cs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Role2NhomTTHCImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Role2NhomTTHCImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the role2 nhom t t h c.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Role2NhomTTHC role2NhomTTHC) {
		EntityCacheUtil.removeResult(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2NhomTTHCImpl.class, role2NhomTTHC.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Role2NhomTTHC> role2NhomTTHCs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Role2NhomTTHC role2NhomTTHC : role2NhomTTHCs) {
			EntityCacheUtil.removeResult(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
				Role2NhomTTHCImpl.class, role2NhomTTHC.getPrimaryKey());
		}
	}

	/**
	 * Creates a new role2 nhom t t h c with the primary key. Does not add the role2 nhom t t h c to the database.
	 *
	 * @param ID the primary key for the new role2 nhom t t h c
	 * @return the new role2 nhom t t h c
	 */
	public Role2NhomTTHC create(long ID) {
		Role2NhomTTHC role2NhomTTHC = new Role2NhomTTHCImpl();

		role2NhomTTHC.setNew(true);
		role2NhomTTHC.setPrimaryKey(ID);

		return role2NhomTTHC;
	}

	/**
	 * Removes the role2 nhom t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the role2 nhom t t h c
	 * @return the role2 nhom t t h c that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException if a role2 nhom t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2NhomTTHC remove(long ID)
		throws NoSuchRole2NhomTTHCException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the role2 nhom t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role2 nhom t t h c
	 * @return the role2 nhom t t h c that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException if a role2 nhom t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2NhomTTHC remove(Serializable primaryKey)
		throws NoSuchRole2NhomTTHCException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Role2NhomTTHC role2NhomTTHC = (Role2NhomTTHC)session.get(Role2NhomTTHCImpl.class,
					primaryKey);

			if (role2NhomTTHC == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRole2NhomTTHCException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(role2NhomTTHC);
		}
		catch (NoSuchRole2NhomTTHCException nsee) {
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
	protected Role2NhomTTHC removeImpl(Role2NhomTTHC role2NhomTTHC)
		throws SystemException {
		role2NhomTTHC = toUnwrappedModel(role2NhomTTHC);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, role2NhomTTHC);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(role2NhomTTHC);

		return role2NhomTTHC;
	}

	@Override
	public Role2NhomTTHC updateImpl(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC, boolean merge)
		throws SystemException {
		role2NhomTTHC = toUnwrappedModel(role2NhomTTHC);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, role2NhomTTHC, merge);

			role2NhomTTHC.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2NhomTTHCImpl.class, role2NhomTTHC.getPrimaryKey(),
			role2NhomTTHC);

		return role2NhomTTHC;
	}

	protected Role2NhomTTHC toUnwrappedModel(Role2NhomTTHC role2NhomTTHC) {
		if (role2NhomTTHC instanceof Role2NhomTTHCImpl) {
			return role2NhomTTHC;
		}

		Role2NhomTTHCImpl role2NhomTTHCImpl = new Role2NhomTTHCImpl();

		role2NhomTTHCImpl.setNew(role2NhomTTHC.isNew());
		role2NhomTTHCImpl.setPrimaryKey(role2NhomTTHC.getPrimaryKey());

		role2NhomTTHCImpl.setID(role2NhomTTHC.getID());
		role2NhomTTHCImpl.setRPDANHMUCROLEID(role2NhomTTHC.getRPDANHMUCROLEID());
		role2NhomTTHCImpl.setRPDANHMUCBAOCAOID(role2NhomTTHC.getRPDANHMUCBAOCAOID());
		role2NhomTTHCImpl.setNHOMTHUTUCHANHCHINHID(role2NhomTTHC.getNHOMTHUTUCHANHCHINHID());

		return role2NhomTTHCImpl;
	}

	/**
	 * Returns the role2 nhom t t h c with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the role2 nhom t t h c
	 * @return the role2 nhom t t h c
	 * @throws com.liferay.portal.NoSuchModelException if a role2 nhom t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2NhomTTHC findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the role2 nhom t t h c with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException} if it could not be found.
	 *
	 * @param ID the primary key of the role2 nhom t t h c
	 * @return the role2 nhom t t h c
	 * @throws org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException if a role2 nhom t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2NhomTTHC findByPrimaryKey(long ID)
		throws NoSuchRole2NhomTTHCException, SystemException {
		Role2NhomTTHC role2NhomTTHC = fetchByPrimaryKey(ID);

		if (role2NhomTTHC == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchRole2NhomTTHCException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return role2NhomTTHC;
	}

	/**
	 * Returns the role2 nhom t t h c with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role2 nhom t t h c
	 * @return the role2 nhom t t h c, or <code>null</code> if a role2 nhom t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2NhomTTHC fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the role2 nhom t t h c with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the role2 nhom t t h c
	 * @return the role2 nhom t t h c, or <code>null</code> if a role2 nhom t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2NhomTTHC fetchByPrimaryKey(long ID) throws SystemException {
		Role2NhomTTHC role2NhomTTHC = (Role2NhomTTHC)EntityCacheUtil.getResult(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
				Role2NhomTTHCImpl.class, ID);

		if (role2NhomTTHC == _nullRole2NhomTTHC) {
			return null;
		}

		if (role2NhomTTHC == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				role2NhomTTHC = (Role2NhomTTHC)session.get(Role2NhomTTHCImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (role2NhomTTHC != null) {
					cacheResult(role2NhomTTHC);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Role2NhomTTHCModelImpl.ENTITY_CACHE_ENABLED,
						Role2NhomTTHCImpl.class, ID, _nullRole2NhomTTHC);
				}

				closeSession(session);
			}
		}

		return role2NhomTTHC;
	}

	/**
	 * Returns all the role2 nhom t t h cs.
	 *
	 * @return the role2 nhom t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2NhomTTHC> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role2 nhom t t h cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of role2 nhom t t h cs
	 * @param end the upper bound of the range of role2 nhom t t h cs (not inclusive)
	 * @return the range of role2 nhom t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2NhomTTHC> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role2 nhom t t h cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of role2 nhom t t h cs
	 * @param end the upper bound of the range of role2 nhom t t h cs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role2 nhom t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2NhomTTHC> findAll(int start, int end,
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

		List<Role2NhomTTHC> list = (List<Role2NhomTTHC>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROLE2NHOMTTHC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROLE2NHOMTTHC.concat(Role2NhomTTHCModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Role2NhomTTHC>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Role2NhomTTHC>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the role2 nhom t t h cs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Role2NhomTTHC role2NhomTTHC : findAll()) {
			remove(role2NhomTTHC);
		}
	}

	/**
	 * Returns the number of role2 nhom t t h cs.
	 *
	 * @return the number of role2 nhom t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROLE2NHOMTTHC);

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
	 * Initializes the role2 nhom t t h c persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Role2NhomTTHC")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Role2NhomTTHC>> listenersList = new ArrayList<ModelListener<Role2NhomTTHC>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Role2NhomTTHC>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Role2NhomTTHCImpl.class.getName());
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
	private static final String _SQL_SELECT_ROLE2NHOMTTHC = "SELECT role2NhomTTHC FROM Role2NhomTTHC role2NhomTTHC";
	private static final String _SQL_COUNT_ROLE2NHOMTTHC = "SELECT COUNT(role2NhomTTHC) FROM Role2NhomTTHC role2NhomTTHC";
	private static final String _ORDER_BY_ENTITY_ALIAS = "role2NhomTTHC.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Role2NhomTTHC exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Role2NhomTTHCPersistenceImpl.class);
	private static Role2NhomTTHC _nullRole2NhomTTHC = new Role2NhomTTHCImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Role2NhomTTHC> toCacheModel() {
				return _nullRole2NhomTTHCCacheModel;
			}
		};

	private static CacheModel<Role2NhomTTHC> _nullRole2NhomTTHCCacheModel = new CacheModel<Role2NhomTTHC>() {
			public Role2NhomTTHC toEntityModel() {
				return _nullRole2NhomTTHC;
			}
		};
}