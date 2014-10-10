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

import org.oep.cmon.dao.report.NoSuchCongChuc2RoleException;
import org.oep.cmon.dao.report.model.CongChuc2Role;
import org.oep.cmon.dao.report.model.impl.CongChuc2RoleImpl;
import org.oep.cmon.dao.report.model.impl.CongChuc2RoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cong chuc2 role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see CongChuc2RolePersistence
 * @see CongChuc2RoleUtil
 * @generated
 */
public class CongChuc2RolePersistenceImpl extends BasePersistenceImpl<CongChuc2Role>
	implements CongChuc2RolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CongChuc2RoleUtil} to access the cong chuc2 role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CongChuc2RoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2RoleModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2RoleImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2RoleModelImpl.FINDER_CACHE_ENABLED,
			CongChuc2RoleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2RoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cong chuc2 role in the entity cache if it is enabled.
	 *
	 * @param congChuc2Role the cong chuc2 role
	 */
	public void cacheResult(CongChuc2Role congChuc2Role) {
		EntityCacheUtil.putResult(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2RoleImpl.class, congChuc2Role.getPrimaryKey(),
			congChuc2Role);

		congChuc2Role.resetOriginalValues();
	}

	/**
	 * Caches the cong chuc2 roles in the entity cache if it is enabled.
	 *
	 * @param congChuc2Roles the cong chuc2 roles
	 */
	public void cacheResult(List<CongChuc2Role> congChuc2Roles) {
		for (CongChuc2Role congChuc2Role : congChuc2Roles) {
			if (EntityCacheUtil.getResult(
						CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
						CongChuc2RoleImpl.class, congChuc2Role.getPrimaryKey()) == null) {
				cacheResult(congChuc2Role);
			}
			else {
				congChuc2Role.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cong chuc2 roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CongChuc2RoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CongChuc2RoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cong chuc2 role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CongChuc2Role congChuc2Role) {
		EntityCacheUtil.removeResult(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2RoleImpl.class, congChuc2Role.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CongChuc2Role> congChuc2Roles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CongChuc2Role congChuc2Role : congChuc2Roles) {
			EntityCacheUtil.removeResult(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
				CongChuc2RoleImpl.class, congChuc2Role.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cong chuc2 role with the primary key. Does not add the cong chuc2 role to the database.
	 *
	 * @param ID the primary key for the new cong chuc2 role
	 * @return the new cong chuc2 role
	 */
	public CongChuc2Role create(long ID) {
		CongChuc2Role congChuc2Role = new CongChuc2RoleImpl();

		congChuc2Role.setNew(true);
		congChuc2Role.setPrimaryKey(ID);

		return congChuc2Role;
	}

	/**
	 * Removes the cong chuc2 role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cong chuc2 role
	 * @return the cong chuc2 role that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2Role remove(long ID)
		throws NoSuchCongChuc2RoleException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the cong chuc2 role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cong chuc2 role
	 * @return the cong chuc2 role that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc2Role remove(Serializable primaryKey)
		throws NoSuchCongChuc2RoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CongChuc2Role congChuc2Role = (CongChuc2Role)session.get(CongChuc2RoleImpl.class,
					primaryKey);

			if (congChuc2Role == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCongChuc2RoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(congChuc2Role);
		}
		catch (NoSuchCongChuc2RoleException nsee) {
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
	protected CongChuc2Role removeImpl(CongChuc2Role congChuc2Role)
		throws SystemException {
		congChuc2Role = toUnwrappedModel(congChuc2Role);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, congChuc2Role);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(congChuc2Role);

		return congChuc2Role;
	}

	@Override
	public CongChuc2Role updateImpl(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role, boolean merge)
		throws SystemException {
		congChuc2Role = toUnwrappedModel(congChuc2Role);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, congChuc2Role, merge);

			congChuc2Role.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
			CongChuc2RoleImpl.class, congChuc2Role.getPrimaryKey(),
			congChuc2Role);

		return congChuc2Role;
	}

	protected CongChuc2Role toUnwrappedModel(CongChuc2Role congChuc2Role) {
		if (congChuc2Role instanceof CongChuc2RoleImpl) {
			return congChuc2Role;
		}

		CongChuc2RoleImpl congChuc2RoleImpl = new CongChuc2RoleImpl();

		congChuc2RoleImpl.setNew(congChuc2Role.isNew());
		congChuc2RoleImpl.setPrimaryKey(congChuc2Role.getPrimaryKey());

		congChuc2RoleImpl.setID(congChuc2Role.getID());
		congChuc2RoleImpl.setCONGCHUCID(congChuc2Role.getCONGCHUCID());
		congChuc2RoleImpl.setRPDANHMUCROLEID(congChuc2Role.getRPDANHMUCROLEID());

		return congChuc2RoleImpl;
	}

	/**
	 * Returns the cong chuc2 role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong chuc2 role
	 * @return the cong chuc2 role
	 * @throws com.liferay.portal.NoSuchModelException if a cong chuc2 role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc2Role findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong chuc2 role with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchCongChuc2RoleException} if it could not be found.
	 *
	 * @param ID the primary key of the cong chuc2 role
	 * @return the cong chuc2 role
	 * @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2Role findByPrimaryKey(long ID)
		throws NoSuchCongChuc2RoleException, SystemException {
		CongChuc2Role congChuc2Role = fetchByPrimaryKey(ID);

		if (congChuc2Role == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchCongChuc2RoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return congChuc2Role;
	}

	/**
	 * Returns the cong chuc2 role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong chuc2 role
	 * @return the cong chuc2 role, or <code>null</code> if a cong chuc2 role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CongChuc2Role fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cong chuc2 role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the cong chuc2 role
	 * @return the cong chuc2 role, or <code>null</code> if a cong chuc2 role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CongChuc2Role fetchByPrimaryKey(long ID) throws SystemException {
		CongChuc2Role congChuc2Role = (CongChuc2Role)EntityCacheUtil.getResult(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
				CongChuc2RoleImpl.class, ID);

		if (congChuc2Role == _nullCongChuc2Role) {
			return null;
		}

		if (congChuc2Role == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				congChuc2Role = (CongChuc2Role)session.get(CongChuc2RoleImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (congChuc2Role != null) {
					cacheResult(congChuc2Role);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CongChuc2RoleModelImpl.ENTITY_CACHE_ENABLED,
						CongChuc2RoleImpl.class, ID, _nullCongChuc2Role);
				}

				closeSession(session);
			}
		}

		return congChuc2Role;
	}

	/**
	 * Returns all the cong chuc2 roles.
	 *
	 * @return the cong chuc2 roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2Role> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong chuc2 roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong chuc2 roles
	 * @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	 * @return the range of cong chuc2 roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2Role> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong chuc2 roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong chuc2 roles
	 * @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong chuc2 roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<CongChuc2Role> findAll(int start, int end,
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

		List<CongChuc2Role> list = (List<CongChuc2Role>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONGCHUC2ROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONGCHUC2ROLE.concat(CongChuc2RoleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CongChuc2Role>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CongChuc2Role>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cong chuc2 roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CongChuc2Role congChuc2Role : findAll()) {
			remove(congChuc2Role);
		}
	}

	/**
	 * Returns the number of cong chuc2 roles.
	 *
	 * @return the number of cong chuc2 roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONGCHUC2ROLE);

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
	 * Initializes the cong chuc2 role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.CongChuc2Role")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CongChuc2Role>> listenersList = new ArrayList<ModelListener<CongChuc2Role>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CongChuc2Role>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CongChuc2RoleImpl.class.getName());
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
	private static final String _SQL_SELECT_CONGCHUC2ROLE = "SELECT congChuc2Role FROM CongChuc2Role congChuc2Role";
	private static final String _SQL_COUNT_CONGCHUC2ROLE = "SELECT COUNT(congChuc2Role) FROM CongChuc2Role congChuc2Role";
	private static final String _ORDER_BY_ENTITY_ALIAS = "congChuc2Role.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CongChuc2Role exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CongChuc2RolePersistenceImpl.class);
	private static CongChuc2Role _nullCongChuc2Role = new CongChuc2RoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CongChuc2Role> toCacheModel() {
				return _nullCongChuc2RoleCacheModel;
			}
		};

	private static CacheModel<CongChuc2Role> _nullCongChuc2RoleCacheModel = new CacheModel<CongChuc2Role>() {
			public CongChuc2Role toEntityModel() {
				return _nullCongChuc2Role;
			}
		};
}