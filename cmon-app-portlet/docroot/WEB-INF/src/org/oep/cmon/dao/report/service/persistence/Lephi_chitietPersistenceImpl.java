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

import org.oep.cmon.dao.report.NoSuchLephi_chitietException;
import org.oep.cmon.dao.report.model.Lephi_chitiet;
import org.oep.cmon.dao.report.model.impl.Lephi_chitietImpl;
import org.oep.cmon.dao.report.model.impl.Lephi_chitietModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lephi_chitiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_chitietPersistence
 * @see Lephi_chitietUtil
 * @generated
 */
public class Lephi_chitietPersistenceImpl extends BasePersistenceImpl<Lephi_chitiet>
	implements Lephi_chitietPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lephi_chitietUtil} to access the lephi_chitiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lephi_chitietImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_chitietModelImpl.FINDER_CACHE_ENABLED,
			Lephi_chitietImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_chitietModelImpl.FINDER_CACHE_ENABLED,
			Lephi_chitietImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_chitietModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the lephi_chitiet in the entity cache if it is enabled.
	 *
	 * @param lephi_chitiet the lephi_chitiet
	 */
	public void cacheResult(Lephi_chitiet lephi_chitiet) {
		EntityCacheUtil.putResult(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_chitietImpl.class, lephi_chitiet.getPrimaryKey(),
			lephi_chitiet);

		lephi_chitiet.resetOriginalValues();
	}

	/**
	 * Caches the lephi_chitiets in the entity cache if it is enabled.
	 *
	 * @param lephi_chitiets the lephi_chitiets
	 */
	public void cacheResult(List<Lephi_chitiet> lephi_chitiets) {
		for (Lephi_chitiet lephi_chitiet : lephi_chitiets) {
			if (EntityCacheUtil.getResult(
						Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
						Lephi_chitietImpl.class, lephi_chitiet.getPrimaryKey()) == null) {
				cacheResult(lephi_chitiet);
			}
			else {
				lephi_chitiet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lephi_chitiets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lephi_chitietImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lephi_chitietImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lephi_chitiet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lephi_chitiet lephi_chitiet) {
		EntityCacheUtil.removeResult(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_chitietImpl.class, lephi_chitiet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lephi_chitiet> lephi_chitiets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lephi_chitiet lephi_chitiet : lephi_chitiets) {
			EntityCacheUtil.removeResult(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
				Lephi_chitietImpl.class, lephi_chitiet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lephi_chitiet with the primary key. Does not add the lephi_chitiet to the database.
	 *
	 * @param ID the primary key for the new lephi_chitiet
	 * @return the new lephi_chitiet
	 */
	public Lephi_chitiet create(long ID) {
		Lephi_chitiet lephi_chitiet = new Lephi_chitietImpl();

		lephi_chitiet.setNew(true);
		lephi_chitiet.setPrimaryKey(ID);

		return lephi_chitiet;
	}

	/**
	 * Removes the lephi_chitiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the lephi_chitiet
	 * @return the lephi_chitiet that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_chitiet remove(long ID)
		throws NoSuchLephi_chitietException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the lephi_chitiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lephi_chitiet
	 * @return the lephi_chitiet that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_chitiet remove(Serializable primaryKey)
		throws NoSuchLephi_chitietException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lephi_chitiet lephi_chitiet = (Lephi_chitiet)session.get(Lephi_chitietImpl.class,
					primaryKey);

			if (lephi_chitiet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLephi_chitietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lephi_chitiet);
		}
		catch (NoSuchLephi_chitietException nsee) {
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
	protected Lephi_chitiet removeImpl(Lephi_chitiet lephi_chitiet)
		throws SystemException {
		lephi_chitiet = toUnwrappedModel(lephi_chitiet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lephi_chitiet);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lephi_chitiet);

		return lephi_chitiet;
	}

	@Override
	public Lephi_chitiet updateImpl(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet, boolean merge)
		throws SystemException {
		lephi_chitiet = toUnwrappedModel(lephi_chitiet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lephi_chitiet, merge);

			lephi_chitiet.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_chitietImpl.class, lephi_chitiet.getPrimaryKey(),
			lephi_chitiet);

		return lephi_chitiet;
	}

	protected Lephi_chitiet toUnwrappedModel(Lephi_chitiet lephi_chitiet) {
		if (lephi_chitiet instanceof Lephi_chitietImpl) {
			return lephi_chitiet;
		}

		Lephi_chitietImpl lephi_chitietImpl = new Lephi_chitietImpl();

		lephi_chitietImpl.setNew(lephi_chitiet.isNew());
		lephi_chitietImpl.setPrimaryKey(lephi_chitiet.getPrimaryKey());

		lephi_chitietImpl.setID(lephi_chitiet.getID());
		lephi_chitietImpl.setTENHOSO(lephi_chitiet.getTENHOSO());
		lephi_chitietImpl.setNGUOINOP(lephi_chitiet.getNGUOINOP());
		lephi_chitietImpl.setCHUHOSO(lephi_chitiet.getCHUHOSO());
		lephi_chitietImpl.setDIACHI(lephi_chitiet.getDIACHI());
		lephi_chitietImpl.setSOBOHOSO(lephi_chitiet.getSOBOHOSO());
		lephi_chitietImpl.setLEPHI(lephi_chitiet.getLEPHI());
		lephi_chitietImpl.setPHIHOSO(lephi_chitiet.getPHIHOSO());
		lephi_chitietImpl.setTONGLEPHI(lephi_chitiet.getTONGLEPHI());
		lephi_chitietImpl.setGHICHU(lephi_chitiet.getGHICHU());
		lephi_chitietImpl.setNHOMTHUTUCHANHCHINHID(lephi_chitiet.getNHOMTHUTUCHANHCHINHID());

		return lephi_chitietImpl;
	}

	/**
	 * Returns the lephi_chitiet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lephi_chitiet
	 * @return the lephi_chitiet
	 * @throws com.liferay.portal.NoSuchModelException if a lephi_chitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_chitiet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the lephi_chitiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_chitietException} if it could not be found.
	 *
	 * @param ID the primary key of the lephi_chitiet
	 * @return the lephi_chitiet
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_chitiet findByPrimaryKey(long ID)
		throws NoSuchLephi_chitietException, SystemException {
		Lephi_chitiet lephi_chitiet = fetchByPrimaryKey(ID);

		if (lephi_chitiet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchLephi_chitietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return lephi_chitiet;
	}

	/**
	 * Returns the lephi_chitiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lephi_chitiet
	 * @return the lephi_chitiet, or <code>null</code> if a lephi_chitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_chitiet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the lephi_chitiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the lephi_chitiet
	 * @return the lephi_chitiet, or <code>null</code> if a lephi_chitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_chitiet fetchByPrimaryKey(long ID) throws SystemException {
		Lephi_chitiet lephi_chitiet = (Lephi_chitiet)EntityCacheUtil.getResult(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
				Lephi_chitietImpl.class, ID);

		if (lephi_chitiet == _nullLephi_chitiet) {
			return null;
		}

		if (lephi_chitiet == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lephi_chitiet = (Lephi_chitiet)session.get(Lephi_chitietImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lephi_chitiet != null) {
					cacheResult(lephi_chitiet);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Lephi_chitietModelImpl.ENTITY_CACHE_ENABLED,
						Lephi_chitietImpl.class, ID, _nullLephi_chitiet);
				}

				closeSession(session);
			}
		}

		return lephi_chitiet;
	}

	/**
	 * Returns all the lephi_chitiets.
	 *
	 * @return the lephi_chitiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_chitiet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lephi_chitiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lephi_chitiets
	 * @param end the upper bound of the range of lephi_chitiets (not inclusive)
	 * @return the range of lephi_chitiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_chitiet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lephi_chitiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lephi_chitiets
	 * @param end the upper bound of the range of lephi_chitiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lephi_chitiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_chitiet> findAll(int start, int end,
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

		List<Lephi_chitiet> list = (List<Lephi_chitiet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEPHI_CHITIET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEPHI_CHITIET.concat(Lephi_chitietModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Lephi_chitiet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Lephi_chitiet>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lephi_chitiets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Lephi_chitiet lephi_chitiet : findAll()) {
			remove(lephi_chitiet);
		}
	}

	/**
	 * Returns the number of lephi_chitiets.
	 *
	 * @return the number of lephi_chitiets
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEPHI_CHITIET);

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
	 * Initializes the lephi_chitiet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Lephi_chitiet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lephi_chitiet>> listenersList = new ArrayList<ModelListener<Lephi_chitiet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lephi_chitiet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lephi_chitietImpl.class.getName());
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
	private static final String _SQL_SELECT_LEPHI_CHITIET = "SELECT lephi_chitiet FROM Lephi_chitiet lephi_chitiet";
	private static final String _SQL_COUNT_LEPHI_CHITIET = "SELECT COUNT(lephi_chitiet) FROM Lephi_chitiet lephi_chitiet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lephi_chitiet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lephi_chitiet exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lephi_chitietPersistenceImpl.class);
	private static Lephi_chitiet _nullLephi_chitiet = new Lephi_chitietImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lephi_chitiet> toCacheModel() {
				return _nullLephi_chitietCacheModel;
			}
		};

	private static CacheModel<Lephi_chitiet> _nullLephi_chitietCacheModel = new CacheModel<Lephi_chitiet>() {
			public Lephi_chitiet toEntityModel() {
				return _nullLephi_chitiet;
			}
		};
}