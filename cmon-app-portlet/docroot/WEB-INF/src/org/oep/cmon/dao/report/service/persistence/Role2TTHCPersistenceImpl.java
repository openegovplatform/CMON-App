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

import org.oep.cmon.dao.report.NoSuchRole2TTHCException;
import org.oep.cmon.dao.report.model.Role2TTHC;
import org.oep.cmon.dao.report.model.impl.Role2TTHCImpl;
import org.oep.cmon.dao.report.model.impl.Role2TTHCModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the role2 t t h c service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2TTHCPersistence
 * @see Role2TTHCUtil
 * @generated
 */
public class Role2TTHCPersistenceImpl extends BasePersistenceImpl<Role2TTHC>
	implements Role2TTHCPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Role2TTHCUtil} to access the role2 t t h c persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Role2TTHCImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2TTHCModelImpl.FINDER_CACHE_ENABLED, Role2TTHCImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2TTHCModelImpl.FINDER_CACHE_ENABLED, Role2TTHCImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2TTHCModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the role2 t t h c in the entity cache if it is enabled.
	 *
	 * @param role2TTHC the role2 t t h c
	 */
	public void cacheResult(Role2TTHC role2TTHC) {
		EntityCacheUtil.putResult(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2TTHCImpl.class, role2TTHC.getPrimaryKey(), role2TTHC);

		role2TTHC.resetOriginalValues();
	}

	/**
	 * Caches the role2 t t h cs in the entity cache if it is enabled.
	 *
	 * @param role2TTHCs the role2 t t h cs
	 */
	public void cacheResult(List<Role2TTHC> role2TTHCs) {
		for (Role2TTHC role2TTHC : role2TTHCs) {
			if (EntityCacheUtil.getResult(
						Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
						Role2TTHCImpl.class, role2TTHC.getPrimaryKey()) == null) {
				cacheResult(role2TTHC);
			}
			else {
				role2TTHC.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all role2 t t h cs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Role2TTHCImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Role2TTHCImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the role2 t t h c.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Role2TTHC role2TTHC) {
		EntityCacheUtil.removeResult(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2TTHCImpl.class, role2TTHC.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Role2TTHC> role2TTHCs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Role2TTHC role2TTHC : role2TTHCs) {
			EntityCacheUtil.removeResult(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
				Role2TTHCImpl.class, role2TTHC.getPrimaryKey());
		}
	}

	/**
	 * Creates a new role2 t t h c with the primary key. Does not add the role2 t t h c to the database.
	 *
	 * @param ID the primary key for the new role2 t t h c
	 * @return the new role2 t t h c
	 */
	public Role2TTHC create(long ID) {
		Role2TTHC role2TTHC = new Role2TTHCImpl();

		role2TTHC.setNew(true);
		role2TTHC.setPrimaryKey(ID);

		return role2TTHC;
	}

	/**
	 * Removes the role2 t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the role2 t t h c
	 * @return the role2 t t h c that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchRole2TTHCException if a role2 t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2TTHC remove(long ID)
		throws NoSuchRole2TTHCException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the role2 t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role2 t t h c
	 * @return the role2 t t h c that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchRole2TTHCException if a role2 t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2TTHC remove(Serializable primaryKey)
		throws NoSuchRole2TTHCException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Role2TTHC role2TTHC = (Role2TTHC)session.get(Role2TTHCImpl.class,
					primaryKey);

			if (role2TTHC == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRole2TTHCException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(role2TTHC);
		}
		catch (NoSuchRole2TTHCException nsee) {
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
	protected Role2TTHC removeImpl(Role2TTHC role2TTHC)
		throws SystemException {
		role2TTHC = toUnwrappedModel(role2TTHC);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, role2TTHC);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(role2TTHC);

		return role2TTHC;
	}

	@Override
	public Role2TTHC updateImpl(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC, boolean merge)
		throws SystemException {
		role2TTHC = toUnwrappedModel(role2TTHC);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, role2TTHC, merge);

			role2TTHC.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
			Role2TTHCImpl.class, role2TTHC.getPrimaryKey(), role2TTHC);

		return role2TTHC;
	}

	protected Role2TTHC toUnwrappedModel(Role2TTHC role2TTHC) {
		if (role2TTHC instanceof Role2TTHCImpl) {
			return role2TTHC;
		}

		Role2TTHCImpl role2TTHCImpl = new Role2TTHCImpl();

		role2TTHCImpl.setNew(role2TTHC.isNew());
		role2TTHCImpl.setPrimaryKey(role2TTHC.getPrimaryKey());

		role2TTHCImpl.setID(role2TTHC.getID());
		role2TTHCImpl.setRPDANHMUCROLEID(role2TTHC.getRPDANHMUCROLEID());
		role2TTHCImpl.setRPDANHMUCBAOCAOID(role2TTHC.getRPDANHMUCBAOCAOID());
		role2TTHCImpl.setTHUTUCHANHCHINHID(role2TTHC.getTHUTUCHANHCHINHID());

		return role2TTHCImpl;
	}

	/**
	 * Returns the role2 t t h c with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the role2 t t h c
	 * @return the role2 t t h c
	 * @throws com.liferay.portal.NoSuchModelException if a role2 t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2TTHC findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the role2 t t h c with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2TTHCException} if it could not be found.
	 *
	 * @param ID the primary key of the role2 t t h c
	 * @return the role2 t t h c
	 * @throws org.oep.cmon.dao.report.NoSuchRole2TTHCException if a role2 t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2TTHC findByPrimaryKey(long ID)
		throws NoSuchRole2TTHCException, SystemException {
		Role2TTHC role2TTHC = fetchByPrimaryKey(ID);

		if (role2TTHC == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchRole2TTHCException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return role2TTHC;
	}

	/**
	 * Returns the role2 t t h c with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role2 t t h c
	 * @return the role2 t t h c, or <code>null</code> if a role2 t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2TTHC fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the role2 t t h c with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the role2 t t h c
	 * @return the role2 t t h c, or <code>null</code> if a role2 t t h c with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2TTHC fetchByPrimaryKey(long ID) throws SystemException {
		Role2TTHC role2TTHC = (Role2TTHC)EntityCacheUtil.getResult(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
				Role2TTHCImpl.class, ID);

		if (role2TTHC == _nullRole2TTHC) {
			return null;
		}

		if (role2TTHC == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				role2TTHC = (Role2TTHC)session.get(Role2TTHCImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (role2TTHC != null) {
					cacheResult(role2TTHC);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Role2TTHCModelImpl.ENTITY_CACHE_ENABLED,
						Role2TTHCImpl.class, ID, _nullRole2TTHC);
				}

				closeSession(session);
			}
		}

		return role2TTHC;
	}

	/**
	 * Returns all the role2 t t h cs.
	 *
	 * @return the role2 t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2TTHC> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role2 t t h cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of role2 t t h cs
	 * @param end the upper bound of the range of role2 t t h cs (not inclusive)
	 * @return the range of role2 t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2TTHC> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role2 t t h cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of role2 t t h cs
	 * @param end the upper bound of the range of role2 t t h cs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role2 t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2TTHC> findAll(int start, int end,
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

		List<Role2TTHC> list = (List<Role2TTHC>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROLE2TTHC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROLE2TTHC.concat(Role2TTHCModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Role2TTHC>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Role2TTHC>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the role2 t t h cs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Role2TTHC role2TTHC : findAll()) {
			remove(role2TTHC);
		}
	}

	/**
	 * Returns the number of role2 t t h cs.
	 *
	 * @return the number of role2 t t h cs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROLE2TTHC);

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
	 * Initializes the role2 t t h c persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Role2TTHC")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Role2TTHC>> listenersList = new ArrayList<ModelListener<Role2TTHC>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Role2TTHC>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Role2TTHCImpl.class.getName());
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
	private static final String _SQL_SELECT_ROLE2TTHC = "SELECT role2TTHC FROM Role2TTHC role2TTHC";
	private static final String _SQL_COUNT_ROLE2TTHC = "SELECT COUNT(role2TTHC) FROM Role2TTHC role2TTHC";
	private static final String _ORDER_BY_ENTITY_ALIAS = "role2TTHC.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Role2TTHC exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Role2TTHCPersistenceImpl.class);
	private static Role2TTHC _nullRole2TTHC = new Role2TTHCImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Role2TTHC> toCacheModel() {
				return _nullRole2TTHCCacheModel;
			}
		};

	private static CacheModel<Role2TTHC> _nullRole2TTHCCacheModel = new CacheModel<Role2TTHC>() {
			public Role2TTHC toEntityModel() {
				return _nullRole2TTHC;
			}
		};
}