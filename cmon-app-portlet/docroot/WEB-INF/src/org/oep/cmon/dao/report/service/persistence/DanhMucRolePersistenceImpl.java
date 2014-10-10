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

import org.oep.cmon.dao.report.NoSuchDanhMucRoleException;
import org.oep.cmon.dao.report.model.DanhMucRole;
import org.oep.cmon.dao.report.model.impl.DanhMucRoleImpl;
import org.oep.cmon.dao.report.model.impl.DanhMucRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh muc role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhMucRolePersistence
 * @see DanhMucRoleUtil
 * @generated
 */
public class DanhMucRolePersistenceImpl extends BasePersistenceImpl<DanhMucRole>
	implements DanhMucRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhMucRoleUtil} to access the danh muc role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhMucRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucRoleModelImpl.FINDER_CACHE_ENABLED, DanhMucRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucRoleModelImpl.FINDER_CACHE_ENABLED, DanhMucRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh muc role in the entity cache if it is enabled.
	 *
	 * @param danhMucRole the danh muc role
	 */
	public void cacheResult(DanhMucRole danhMucRole) {
		EntityCacheUtil.putResult(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucRoleImpl.class, danhMucRole.getPrimaryKey(), danhMucRole);

		danhMucRole.resetOriginalValues();
	}

	/**
	 * Caches the danh muc roles in the entity cache if it is enabled.
	 *
	 * @param danhMucRoles the danh muc roles
	 */
	public void cacheResult(List<DanhMucRole> danhMucRoles) {
		for (DanhMucRole danhMucRole : danhMucRoles) {
			if (EntityCacheUtil.getResult(
						DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucRoleImpl.class, danhMucRole.getPrimaryKey()) == null) {
				cacheResult(danhMucRole);
			}
			else {
				danhMucRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh muc roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhMucRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhMucRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh muc role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhMucRole danhMucRole) {
		EntityCacheUtil.removeResult(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucRoleImpl.class, danhMucRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DanhMucRole> danhMucRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhMucRole danhMucRole : danhMucRoles) {
			EntityCacheUtil.removeResult(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucRoleImpl.class, danhMucRole.getPrimaryKey());
		}
	}

	/**
	 * Creates a new danh muc role with the primary key. Does not add the danh muc role to the database.
	 *
	 * @param ID the primary key for the new danh muc role
	 * @return the new danh muc role
	 */
	public DanhMucRole create(long ID) {
		DanhMucRole danhMucRole = new DanhMucRoleImpl();

		danhMucRole.setNew(true);
		danhMucRole.setPrimaryKey(ID);

		return danhMucRole;
	}

	/**
	 * Removes the danh muc role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the danh muc role
	 * @return the danh muc role that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucRole remove(long ID)
		throws NoSuchDanhMucRoleException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the danh muc role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh muc role
	 * @return the danh muc role that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucRole remove(Serializable primaryKey)
		throws NoSuchDanhMucRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhMucRole danhMucRole = (DanhMucRole)session.get(DanhMucRoleImpl.class,
					primaryKey);

			if (danhMucRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhMucRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhMucRole);
		}
		catch (NoSuchDanhMucRoleException nsee) {
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
	protected DanhMucRole removeImpl(DanhMucRole danhMucRole)
		throws SystemException {
		danhMucRole = toUnwrappedModel(danhMucRole);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhMucRole);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhMucRole);

		return danhMucRole;
	}

	@Override
	public DanhMucRole updateImpl(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole, boolean merge)
		throws SystemException {
		danhMucRole = toUnwrappedModel(danhMucRole);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhMucRole, merge);

			danhMucRole.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucRoleImpl.class, danhMucRole.getPrimaryKey(), danhMucRole);

		return danhMucRole;
	}

	protected DanhMucRole toUnwrappedModel(DanhMucRole danhMucRole) {
		if (danhMucRole instanceof DanhMucRoleImpl) {
			return danhMucRole;
		}

		DanhMucRoleImpl danhMucRoleImpl = new DanhMucRoleImpl();

		danhMucRoleImpl.setNew(danhMucRole.isNew());
		danhMucRoleImpl.setPrimaryKey(danhMucRole.getPrimaryKey());

		danhMucRoleImpl.setID(danhMucRole.getID());
		danhMucRoleImpl.setNAME(danhMucRole.getNAME());
		danhMucRoleImpl.setORDERS(danhMucRole.getORDERS());
		danhMucRoleImpl.setSTATUS(danhMucRole.getSTATUS());

		return danhMucRoleImpl;
	}

	/**
	 * Returns the danh muc role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc role
	 * @return the danh muc role
	 * @throws com.liferay.portal.NoSuchModelException if a danh muc role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc role with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchDanhMucRoleException} if it could not be found.
	 *
	 * @param ID the primary key of the danh muc role
	 * @return the danh muc role
	 * @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucRole findByPrimaryKey(long ID)
		throws NoSuchDanhMucRoleException, SystemException {
		DanhMucRole danhMucRole = fetchByPrimaryKey(ID);

		if (danhMucRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchDanhMucRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return danhMucRole;
	}

	/**
	 * Returns the danh muc role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc role
	 * @return the danh muc role, or <code>null</code> if a danh muc role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the danh muc role
	 * @return the danh muc role, or <code>null</code> if a danh muc role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucRole fetchByPrimaryKey(long ID) throws SystemException {
		DanhMucRole danhMucRole = (DanhMucRole)EntityCacheUtil.getResult(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucRoleImpl.class, ID);

		if (danhMucRole == _nullDanhMucRole) {
			return null;
		}

		if (danhMucRole == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhMucRole = (DanhMucRole)session.get(DanhMucRoleImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhMucRole != null) {
					cacheResult(danhMucRole);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhMucRoleModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucRoleImpl.class, ID, _nullDanhMucRole);
				}

				closeSession(session);
			}
		}

		return danhMucRole;
	}

	/**
	 * Returns all the danh muc roles.
	 *
	 * @return the danh muc roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc roles
	 * @param end the upper bound of the range of danh muc roles (not inclusive)
	 * @return the range of danh muc roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc roles
	 * @param end the upper bound of the range of danh muc roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh muc roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucRole> findAll(int start, int end,
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

		List<DanhMucRole> list = (List<DanhMucRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHMUCROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHMUCROLE.concat(DanhMucRoleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhMucRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhMucRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the danh muc roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhMucRole danhMucRole : findAll()) {
			remove(danhMucRole);
		}
	}

	/**
	 * Returns the number of danh muc roles.
	 *
	 * @return the number of danh muc roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHMUCROLE);

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
	 * Initializes the danh muc role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.DanhMucRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhMucRole>> listenersList = new ArrayList<ModelListener<DanhMucRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhMucRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhMucRoleImpl.class.getName());
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
	private static final String _SQL_SELECT_DANHMUCROLE = "SELECT danhMucRole FROM DanhMucRole danhMucRole";
	private static final String _SQL_COUNT_DANHMUCROLE = "SELECT COUNT(danhMucRole) FROM DanhMucRole danhMucRole";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhMucRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhMucRole exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhMucRolePersistenceImpl.class);
	private static DanhMucRole _nullDanhMucRole = new DanhMucRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhMucRole> toCacheModel() {
				return _nullDanhMucRoleCacheModel;
			}
		};

	private static CacheModel<DanhMucRole> _nullDanhMucRoleCacheModel = new CacheModel<DanhMucRole>() {
			public DanhMucRole toEntityModel() {
				return _nullDanhMucRole;
			}
		};
}