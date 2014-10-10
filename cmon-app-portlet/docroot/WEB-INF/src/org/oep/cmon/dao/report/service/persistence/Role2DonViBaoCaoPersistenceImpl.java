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

import org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException;
import org.oep.cmon.dao.report.model.Role2DonViBaoCao;
import org.oep.cmon.dao.report.model.impl.Role2DonViBaoCaoImpl;
import org.oep.cmon.dao.report.model.impl.Role2DonViBaoCaoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the role2 don vi bao cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2DonViBaoCaoPersistence
 * @see Role2DonViBaoCaoUtil
 * @generated
 */
public class Role2DonViBaoCaoPersistenceImpl extends BasePersistenceImpl<Role2DonViBaoCao>
	implements Role2DonViBaoCaoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Role2DonViBaoCaoUtil} to access the role2 don vi bao cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Role2DonViBaoCaoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			Role2DonViBaoCaoModelImpl.FINDER_CACHE_ENABLED,
			Role2DonViBaoCaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			Role2DonViBaoCaoModelImpl.FINDER_CACHE_ENABLED,
			Role2DonViBaoCaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			Role2DonViBaoCaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the role2 don vi bao cao in the entity cache if it is enabled.
	 *
	 * @param role2DonViBaoCao the role2 don vi bao cao
	 */
	public void cacheResult(Role2DonViBaoCao role2DonViBaoCao) {
		EntityCacheUtil.putResult(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			Role2DonViBaoCaoImpl.class, role2DonViBaoCao.getPrimaryKey(),
			role2DonViBaoCao);

		role2DonViBaoCao.resetOriginalValues();
	}

	/**
	 * Caches the role2 don vi bao caos in the entity cache if it is enabled.
	 *
	 * @param role2DonViBaoCaos the role2 don vi bao caos
	 */
	public void cacheResult(List<Role2DonViBaoCao> role2DonViBaoCaos) {
		for (Role2DonViBaoCao role2DonViBaoCao : role2DonViBaoCaos) {
			if (EntityCacheUtil.getResult(
						Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
						Role2DonViBaoCaoImpl.class,
						role2DonViBaoCao.getPrimaryKey()) == null) {
				cacheResult(role2DonViBaoCao);
			}
			else {
				role2DonViBaoCao.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all role2 don vi bao caos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Role2DonViBaoCaoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Role2DonViBaoCaoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the role2 don vi bao cao.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Role2DonViBaoCao role2DonViBaoCao) {
		EntityCacheUtil.removeResult(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			Role2DonViBaoCaoImpl.class, role2DonViBaoCao.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Role2DonViBaoCao> role2DonViBaoCaos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Role2DonViBaoCao role2DonViBaoCao : role2DonViBaoCaos) {
			EntityCacheUtil.removeResult(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
				Role2DonViBaoCaoImpl.class, role2DonViBaoCao.getPrimaryKey());
		}
	}

	/**
	 * Creates a new role2 don vi bao cao with the primary key. Does not add the role2 don vi bao cao to the database.
	 *
	 * @param ID the primary key for the new role2 don vi bao cao
	 * @return the new role2 don vi bao cao
	 */
	public Role2DonViBaoCao create(long ID) {
		Role2DonViBaoCao role2DonViBaoCao = new Role2DonViBaoCaoImpl();

		role2DonViBaoCao.setNew(true);
		role2DonViBaoCao.setPrimaryKey(ID);

		return role2DonViBaoCao;
	}

	/**
	 * Removes the role2 don vi bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the role2 don vi bao cao
	 * @return the role2 don vi bao cao that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2DonViBaoCao remove(long ID)
		throws NoSuchRole2DonViBaoCaoException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the role2 don vi bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role2 don vi bao cao
	 * @return the role2 don vi bao cao that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2DonViBaoCao remove(Serializable primaryKey)
		throws NoSuchRole2DonViBaoCaoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Role2DonViBaoCao role2DonViBaoCao = (Role2DonViBaoCao)session.get(Role2DonViBaoCaoImpl.class,
					primaryKey);

			if (role2DonViBaoCao == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRole2DonViBaoCaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(role2DonViBaoCao);
		}
		catch (NoSuchRole2DonViBaoCaoException nsee) {
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
	protected Role2DonViBaoCao removeImpl(Role2DonViBaoCao role2DonViBaoCao)
		throws SystemException {
		role2DonViBaoCao = toUnwrappedModel(role2DonViBaoCao);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, role2DonViBaoCao);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(role2DonViBaoCao);

		return role2DonViBaoCao;
	}

	@Override
	public Role2DonViBaoCao updateImpl(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao,
		boolean merge) throws SystemException {
		role2DonViBaoCao = toUnwrappedModel(role2DonViBaoCao);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, role2DonViBaoCao, merge);

			role2DonViBaoCao.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			Role2DonViBaoCaoImpl.class, role2DonViBaoCao.getPrimaryKey(),
			role2DonViBaoCao);

		return role2DonViBaoCao;
	}

	protected Role2DonViBaoCao toUnwrappedModel(
		Role2DonViBaoCao role2DonViBaoCao) {
		if (role2DonViBaoCao instanceof Role2DonViBaoCaoImpl) {
			return role2DonViBaoCao;
		}

		Role2DonViBaoCaoImpl role2DonViBaoCaoImpl = new Role2DonViBaoCaoImpl();

		role2DonViBaoCaoImpl.setNew(role2DonViBaoCao.isNew());
		role2DonViBaoCaoImpl.setPrimaryKey(role2DonViBaoCao.getPrimaryKey());

		role2DonViBaoCaoImpl.setID(role2DonViBaoCao.getID());
		role2DonViBaoCaoImpl.setRPDANHMUCROLEID(role2DonViBaoCao.getRPDANHMUCROLEID());
		role2DonViBaoCaoImpl.setRPDANHMUCBAOCAOID(role2DonViBaoCao.getRPDANHMUCBAOCAOID());
		role2DonViBaoCaoImpl.setCOQUANQUANLYID(role2DonViBaoCao.getCOQUANQUANLYID());

		return role2DonViBaoCaoImpl;
	}

	/**
	 * Returns the role2 don vi bao cao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the role2 don vi bao cao
	 * @return the role2 don vi bao cao
	 * @throws com.liferay.portal.NoSuchModelException if a role2 don vi bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2DonViBaoCao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the role2 don vi bao cao with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException} if it could not be found.
	 *
	 * @param ID the primary key of the role2 don vi bao cao
	 * @return the role2 don vi bao cao
	 * @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2DonViBaoCao findByPrimaryKey(long ID)
		throws NoSuchRole2DonViBaoCaoException, SystemException {
		Role2DonViBaoCao role2DonViBaoCao = fetchByPrimaryKey(ID);

		if (role2DonViBaoCao == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchRole2DonViBaoCaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return role2DonViBaoCao;
	}

	/**
	 * Returns the role2 don vi bao cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role2 don vi bao cao
	 * @return the role2 don vi bao cao, or <code>null</code> if a role2 don vi bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role2DonViBaoCao fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the role2 don vi bao cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the role2 don vi bao cao
	 * @return the role2 don vi bao cao, or <code>null</code> if a role2 don vi bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Role2DonViBaoCao fetchByPrimaryKey(long ID)
		throws SystemException {
		Role2DonViBaoCao role2DonViBaoCao = (Role2DonViBaoCao)EntityCacheUtil.getResult(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
				Role2DonViBaoCaoImpl.class, ID);

		if (role2DonViBaoCao == _nullRole2DonViBaoCao) {
			return null;
		}

		if (role2DonViBaoCao == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				role2DonViBaoCao = (Role2DonViBaoCao)session.get(Role2DonViBaoCaoImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (role2DonViBaoCao != null) {
					cacheResult(role2DonViBaoCao);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Role2DonViBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
						Role2DonViBaoCaoImpl.class, ID, _nullRole2DonViBaoCao);
				}

				closeSession(session);
			}
		}

		return role2DonViBaoCao;
	}

	/**
	 * Returns all the role2 don vi bao caos.
	 *
	 * @return the role2 don vi bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2DonViBaoCao> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role2 don vi bao caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of role2 don vi bao caos
	 * @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	 * @return the range of role2 don vi bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2DonViBaoCao> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role2 don vi bao caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of role2 don vi bao caos
	 * @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role2 don vi bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Role2DonViBaoCao> findAll(int start, int end,
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

		List<Role2DonViBaoCao> list = (List<Role2DonViBaoCao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROLE2DONVIBAOCAO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROLE2DONVIBAOCAO.concat(Role2DonViBaoCaoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Role2DonViBaoCao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Role2DonViBaoCao>)QueryUtil.list(q,
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
	 * Removes all the role2 don vi bao caos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Role2DonViBaoCao role2DonViBaoCao : findAll()) {
			remove(role2DonViBaoCao);
		}
	}

	/**
	 * Returns the number of role2 don vi bao caos.
	 *
	 * @return the number of role2 don vi bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROLE2DONVIBAOCAO);

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
	 * Initializes the role2 don vi bao cao persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Role2DonViBaoCao")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Role2DonViBaoCao>> listenersList = new ArrayList<ModelListener<Role2DonViBaoCao>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Role2DonViBaoCao>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Role2DonViBaoCaoImpl.class.getName());
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
	private static final String _SQL_SELECT_ROLE2DONVIBAOCAO = "SELECT role2DonViBaoCao FROM Role2DonViBaoCao role2DonViBaoCao";
	private static final String _SQL_COUNT_ROLE2DONVIBAOCAO = "SELECT COUNT(role2DonViBaoCao) FROM Role2DonViBaoCao role2DonViBaoCao";
	private static final String _ORDER_BY_ENTITY_ALIAS = "role2DonViBaoCao.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Role2DonViBaoCao exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Role2DonViBaoCaoPersistenceImpl.class);
	private static Role2DonViBaoCao _nullRole2DonViBaoCao = new Role2DonViBaoCaoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Role2DonViBaoCao> toCacheModel() {
				return _nullRole2DonViBaoCaoCacheModel;
			}
		};

	private static CacheModel<Role2DonViBaoCao> _nullRole2DonViBaoCaoCacheModel = new CacheModel<Role2DonViBaoCao>() {
			public Role2DonViBaoCao toEntityModel() {
				return _nullRole2DonViBaoCao;
			}
		};
}