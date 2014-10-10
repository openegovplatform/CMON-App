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

import org.oep.cmon.dao.report.NoSuchLephi_tonghopException;
import org.oep.cmon.dao.report.model.Lephi_tonghop;
import org.oep.cmon.dao.report.model.impl.Lephi_tonghopImpl;
import org.oep.cmon.dao.report.model.impl.Lephi_tonghopModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lephi_tonghop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_tonghopPersistence
 * @see Lephi_tonghopUtil
 * @generated
 */
public class Lephi_tonghopPersistenceImpl extends BasePersistenceImpl<Lephi_tonghop>
	implements Lephi_tonghopPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lephi_tonghopUtil} to access the lephi_tonghop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lephi_tonghopImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_tonghopModelImpl.FINDER_CACHE_ENABLED,
			Lephi_tonghopImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_tonghopModelImpl.FINDER_CACHE_ENABLED,
			Lephi_tonghopImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_tonghopModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the lephi_tonghop in the entity cache if it is enabled.
	 *
	 * @param lephi_tonghop the lephi_tonghop
	 */
	public void cacheResult(Lephi_tonghop lephi_tonghop) {
		EntityCacheUtil.putResult(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_tonghopImpl.class, lephi_tonghop.getPrimaryKey(),
			lephi_tonghop);

		lephi_tonghop.resetOriginalValues();
	}

	/**
	 * Caches the lephi_tonghops in the entity cache if it is enabled.
	 *
	 * @param lephi_tonghops the lephi_tonghops
	 */
	public void cacheResult(List<Lephi_tonghop> lephi_tonghops) {
		for (Lephi_tonghop lephi_tonghop : lephi_tonghops) {
			if (EntityCacheUtil.getResult(
						Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
						Lephi_tonghopImpl.class, lephi_tonghop.getPrimaryKey()) == null) {
				cacheResult(lephi_tonghop);
			}
			else {
				lephi_tonghop.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lephi_tonghops.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lephi_tonghopImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lephi_tonghopImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lephi_tonghop.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lephi_tonghop lephi_tonghop) {
		EntityCacheUtil.removeResult(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_tonghopImpl.class, lephi_tonghop.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lephi_tonghop> lephi_tonghops) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lephi_tonghop lephi_tonghop : lephi_tonghops) {
			EntityCacheUtil.removeResult(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
				Lephi_tonghopImpl.class, lephi_tonghop.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lephi_tonghop with the primary key. Does not add the lephi_tonghop to the database.
	 *
	 * @param lephi_tonghopPK the primary key for the new lephi_tonghop
	 * @return the new lephi_tonghop
	 */
	public Lephi_tonghop create(Lephi_tonghopPK lephi_tonghopPK) {
		Lephi_tonghop lephi_tonghop = new Lephi_tonghopImpl();

		lephi_tonghop.setNew(true);
		lephi_tonghop.setPrimaryKey(lephi_tonghopPK);

		return lephi_tonghop;
	}

	/**
	 * Removes the lephi_tonghop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lephi_tonghopPK the primary key of the lephi_tonghop
	 * @return the lephi_tonghop that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_tonghop remove(Lephi_tonghopPK lephi_tonghopPK)
		throws NoSuchLephi_tonghopException, SystemException {
		return remove((Serializable)lephi_tonghopPK);
	}

	/**
	 * Removes the lephi_tonghop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lephi_tonghop
	 * @return the lephi_tonghop that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_tonghop remove(Serializable primaryKey)
		throws NoSuchLephi_tonghopException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lephi_tonghop lephi_tonghop = (Lephi_tonghop)session.get(Lephi_tonghopImpl.class,
					primaryKey);

			if (lephi_tonghop == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLephi_tonghopException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lephi_tonghop);
		}
		catch (NoSuchLephi_tonghopException nsee) {
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
	protected Lephi_tonghop removeImpl(Lephi_tonghop lephi_tonghop)
		throws SystemException {
		lephi_tonghop = toUnwrappedModel(lephi_tonghop);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lephi_tonghop);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lephi_tonghop);

		return lephi_tonghop;
	}

	@Override
	public Lephi_tonghop updateImpl(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop, boolean merge)
		throws SystemException {
		lephi_tonghop = toUnwrappedModel(lephi_tonghop);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lephi_tonghop, merge);

			lephi_tonghop.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_tonghopImpl.class, lephi_tonghop.getPrimaryKey(),
			lephi_tonghop);

		return lephi_tonghop;
	}

	protected Lephi_tonghop toUnwrappedModel(Lephi_tonghop lephi_tonghop) {
		if (lephi_tonghop instanceof Lephi_tonghopImpl) {
			return lephi_tonghop;
		}

		Lephi_tonghopImpl lephi_tonghopImpl = new Lephi_tonghopImpl();

		lephi_tonghopImpl.setNew(lephi_tonghop.isNew());
		lephi_tonghopImpl.setPrimaryKey(lephi_tonghop.getPrimaryKey());

		lephi_tonghopImpl.setNHOMTHUTUCHANHCHINHID(lephi_tonghop.getNHOMTHUTUCHANHCHINHID());
		lephi_tonghopImpl.setTONGHOSO(lephi_tonghop.getTONGHOSO());
		lephi_tonghopImpl.setLEPHI(lephi_tonghop.getLEPHI());
		lephi_tonghopImpl.setPHIHOSO(lephi_tonghop.getPHIHOSO());
		lephi_tonghopImpl.setTONGLEPHI(lephi_tonghop.getTONGLEPHI());
		lephi_tonghopImpl.setTHANGNHAN(lephi_tonghop.getTHANGNHAN());

		return lephi_tonghopImpl;
	}

	/**
	 * Returns the lephi_tonghop with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lephi_tonghop
	 * @return the lephi_tonghop
	 * @throws com.liferay.portal.NoSuchModelException if a lephi_tonghop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_tonghop findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((Lephi_tonghopPK)primaryKey);
	}

	/**
	 * Returns the lephi_tonghop with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_tonghopException} if it could not be found.
	 *
	 * @param lephi_tonghopPK the primary key of the lephi_tonghop
	 * @return the lephi_tonghop
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_tonghop findByPrimaryKey(Lephi_tonghopPK lephi_tonghopPK)
		throws NoSuchLephi_tonghopException, SystemException {
		Lephi_tonghop lephi_tonghop = fetchByPrimaryKey(lephi_tonghopPK);

		if (lephi_tonghop == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + lephi_tonghopPK);
			}

			throw new NoSuchLephi_tonghopException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				lephi_tonghopPK);
		}

		return lephi_tonghop;
	}

	/**
	 * Returns the lephi_tonghop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lephi_tonghop
	 * @return the lephi_tonghop, or <code>null</code> if a lephi_tonghop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_tonghop fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((Lephi_tonghopPK)primaryKey);
	}

	/**
	 * Returns the lephi_tonghop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lephi_tonghopPK the primary key of the lephi_tonghop
	 * @return the lephi_tonghop, or <code>null</code> if a lephi_tonghop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_tonghop fetchByPrimaryKey(Lephi_tonghopPK lephi_tonghopPK)
		throws SystemException {
		Lephi_tonghop lephi_tonghop = (Lephi_tonghop)EntityCacheUtil.getResult(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
				Lephi_tonghopImpl.class, lephi_tonghopPK);

		if (lephi_tonghop == _nullLephi_tonghop) {
			return null;
		}

		if (lephi_tonghop == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lephi_tonghop = (Lephi_tonghop)session.get(Lephi_tonghopImpl.class,
						lephi_tonghopPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lephi_tonghop != null) {
					cacheResult(lephi_tonghop);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Lephi_tonghopModelImpl.ENTITY_CACHE_ENABLED,
						Lephi_tonghopImpl.class, lephi_tonghopPK,
						_nullLephi_tonghop);
				}

				closeSession(session);
			}
		}

		return lephi_tonghop;
	}

	/**
	 * Returns all the lephi_tonghops.
	 *
	 * @return the lephi_tonghops
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_tonghop> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lephi_tonghops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lephi_tonghops
	 * @param end the upper bound of the range of lephi_tonghops (not inclusive)
	 * @return the range of lephi_tonghops
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_tonghop> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lephi_tonghops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lephi_tonghops
	 * @param end the upper bound of the range of lephi_tonghops (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lephi_tonghops
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_tonghop> findAll(int start, int end,
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

		List<Lephi_tonghop> list = (List<Lephi_tonghop>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEPHI_TONGHOP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEPHI_TONGHOP.concat(Lephi_tonghopModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Lephi_tonghop>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Lephi_tonghop>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lephi_tonghops from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Lephi_tonghop lephi_tonghop : findAll()) {
			remove(lephi_tonghop);
		}
	}

	/**
	 * Returns the number of lephi_tonghops.
	 *
	 * @return the number of lephi_tonghops
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEPHI_TONGHOP);

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
	 * Initializes the lephi_tonghop persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Lephi_tonghop")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lephi_tonghop>> listenersList = new ArrayList<ModelListener<Lephi_tonghop>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lephi_tonghop>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lephi_tonghopImpl.class.getName());
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
	private static final String _SQL_SELECT_LEPHI_TONGHOP = "SELECT lephi_tonghop FROM Lephi_tonghop lephi_tonghop";
	private static final String _SQL_COUNT_LEPHI_TONGHOP = "SELECT COUNT(lephi_tonghop) FROM Lephi_tonghop lephi_tonghop";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lephi_tonghop.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lephi_tonghop exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lephi_tonghopPersistenceImpl.class);
	private static Lephi_tonghop _nullLephi_tonghop = new Lephi_tonghopImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lephi_tonghop> toCacheModel() {
				return _nullLephi_tonghopCacheModel;
			}
		};

	private static CacheModel<Lephi_tonghop> _nullLephi_tonghopCacheModel = new CacheModel<Lephi_tonghop>() {
			public Lephi_tonghop toEntityModel() {
				return _nullLephi_tonghop;
			}
		};
}