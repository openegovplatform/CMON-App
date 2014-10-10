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

import org.oep.cmon.dao.report.NoSuchBaocaochitietException;
import org.oep.cmon.dao.report.model.Baocaochitiet;
import org.oep.cmon.dao.report.model.impl.BaocaochitietImpl;
import org.oep.cmon.dao.report.model.impl.BaocaochitietModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the baocaochitiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see BaocaochitietPersistence
 * @see BaocaochitietUtil
 * @generated
 */
public class BaocaochitietPersistenceImpl extends BasePersistenceImpl<Baocaochitiet>
	implements BaocaochitietPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BaocaochitietUtil} to access the baocaochitiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BaocaochitietImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
			BaocaochitietModelImpl.FINDER_CACHE_ENABLED,
			BaocaochitietImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
			BaocaochitietModelImpl.FINDER_CACHE_ENABLED,
			BaocaochitietImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
			BaocaochitietModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the baocaochitiet in the entity cache if it is enabled.
	 *
	 * @param baocaochitiet the baocaochitiet
	 */
	public void cacheResult(Baocaochitiet baocaochitiet) {
		EntityCacheUtil.putResult(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
			BaocaochitietImpl.class, baocaochitiet.getPrimaryKey(),
			baocaochitiet);

		baocaochitiet.resetOriginalValues();
	}

	/**
	 * Caches the baocaochitiets in the entity cache if it is enabled.
	 *
	 * @param baocaochitiets the baocaochitiets
	 */
	public void cacheResult(List<Baocaochitiet> baocaochitiets) {
		for (Baocaochitiet baocaochitiet : baocaochitiets) {
			if (EntityCacheUtil.getResult(
						BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
						BaocaochitietImpl.class, baocaochitiet.getPrimaryKey()) == null) {
				cacheResult(baocaochitiet);
			}
			else {
				baocaochitiet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all baocaochitiets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BaocaochitietImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BaocaochitietImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the baocaochitiet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Baocaochitiet baocaochitiet) {
		EntityCacheUtil.removeResult(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
			BaocaochitietImpl.class, baocaochitiet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Baocaochitiet> baocaochitiets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Baocaochitiet baocaochitiet : baocaochitiets) {
			EntityCacheUtil.removeResult(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
				BaocaochitietImpl.class, baocaochitiet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new baocaochitiet with the primary key. Does not add the baocaochitiet to the database.
	 *
	 * @param MASOHOSO the primary key for the new baocaochitiet
	 * @return the new baocaochitiet
	 */
	public Baocaochitiet create(String MASOHOSO) {
		Baocaochitiet baocaochitiet = new BaocaochitietImpl();

		baocaochitiet.setNew(true);
		baocaochitiet.setPrimaryKey(MASOHOSO);

		return baocaochitiet;
	}

	/**
	 * Removes the baocaochitiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MASOHOSO the primary key of the baocaochitiet
	 * @return the baocaochitiet that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Baocaochitiet remove(String MASOHOSO)
		throws NoSuchBaocaochitietException, SystemException {
		return remove((Serializable)MASOHOSO);
	}

	/**
	 * Removes the baocaochitiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the baocaochitiet
	 * @return the baocaochitiet that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Baocaochitiet remove(Serializable primaryKey)
		throws NoSuchBaocaochitietException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Baocaochitiet baocaochitiet = (Baocaochitiet)session.get(BaocaochitietImpl.class,
					primaryKey);

			if (baocaochitiet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBaocaochitietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(baocaochitiet);
		}
		catch (NoSuchBaocaochitietException nsee) {
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
	protected Baocaochitiet removeImpl(Baocaochitiet baocaochitiet)
		throws SystemException {
		baocaochitiet = toUnwrappedModel(baocaochitiet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, baocaochitiet);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(baocaochitiet);

		return baocaochitiet;
	}

	@Override
	public Baocaochitiet updateImpl(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet, boolean merge)
		throws SystemException {
		baocaochitiet = toUnwrappedModel(baocaochitiet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, baocaochitiet, merge);

			baocaochitiet.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
			BaocaochitietImpl.class, baocaochitiet.getPrimaryKey(),
			baocaochitiet);

		return baocaochitiet;
	}

	protected Baocaochitiet toUnwrappedModel(Baocaochitiet baocaochitiet) {
		if (baocaochitiet instanceof BaocaochitietImpl) {
			return baocaochitiet;
		}

		BaocaochitietImpl baocaochitietImpl = new BaocaochitietImpl();

		baocaochitietImpl.setNew(baocaochitiet.isNew());
		baocaochitietImpl.setPrimaryKey(baocaochitiet.getPrimaryKey());

		baocaochitietImpl.setLINHVUCID(baocaochitiet.getLINHVUCID());
		baocaochitietImpl.setMASOHOSO(baocaochitiet.getMASOHOSO());
		baocaochitietImpl.setTEN(baocaochitiet.getTEN());
		baocaochitietImpl.setTRANGTHAI(baocaochitiet.getTRANGTHAI());
		baocaochitietImpl.setDIACHIHIENNAY(baocaochitiet.getDIACHIHIENNAY());
		baocaochitietImpl.setDIENTHOAIDIDONG(baocaochitiet.getDIENTHOAIDIDONG());
		baocaochitietImpl.setHOTENNGUOINOPHOSO(baocaochitiet.getHOTENNGUOINOPHOSO());
		baocaochitietImpl.setNGUOIDAIDIENPHAPLUAT(baocaochitiet.getNGUOIDAIDIENPHAPLUAT());
		baocaochitietImpl.setNGAYNHANHOSO(baocaochitiet.getNGAYNHANHOSO());
		baocaochitietImpl.setNGAYTRAKETQUA(baocaochitiet.getNGAYTRAKETQUA());
		baocaochitietImpl.setNGAYHENTRAKETQUA(baocaochitiet.getNGAYHENTRAKETQUA());
		baocaochitietImpl.setLINHVUC(baocaochitiet.getLINHVUC());
		baocaochitietImpl.setGHICHU(baocaochitiet.getGHICHU());

		return baocaochitietImpl;
	}

	/**
	 * Returns the baocaochitiet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the baocaochitiet
	 * @return the baocaochitiet
	 * @throws com.liferay.portal.NoSuchModelException if a baocaochitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Baocaochitiet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the baocaochitiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchBaocaochitietException} if it could not be found.
	 *
	 * @param MASOHOSO the primary key of the baocaochitiet
	 * @return the baocaochitiet
	 * @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Baocaochitiet findByPrimaryKey(String MASOHOSO)
		throws NoSuchBaocaochitietException, SystemException {
		Baocaochitiet baocaochitiet = fetchByPrimaryKey(MASOHOSO);

		if (baocaochitiet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + MASOHOSO);
			}

			throw new NoSuchBaocaochitietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				MASOHOSO);
		}

		return baocaochitiet;
	}

	/**
	 * Returns the baocaochitiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the baocaochitiet
	 * @return the baocaochitiet, or <code>null</code> if a baocaochitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Baocaochitiet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the baocaochitiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MASOHOSO the primary key of the baocaochitiet
	 * @return the baocaochitiet, or <code>null</code> if a baocaochitiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Baocaochitiet fetchByPrimaryKey(String MASOHOSO)
		throws SystemException {
		Baocaochitiet baocaochitiet = (Baocaochitiet)EntityCacheUtil.getResult(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
				BaocaochitietImpl.class, MASOHOSO);

		if (baocaochitiet == _nullBaocaochitiet) {
			return null;
		}

		if (baocaochitiet == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				baocaochitiet = (Baocaochitiet)session.get(BaocaochitietImpl.class,
						MASOHOSO);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (baocaochitiet != null) {
					cacheResult(baocaochitiet);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BaocaochitietModelImpl.ENTITY_CACHE_ENABLED,
						BaocaochitietImpl.class, MASOHOSO, _nullBaocaochitiet);
				}

				closeSession(session);
			}
		}

		return baocaochitiet;
	}

	/**
	 * Returns all the baocaochitiets.
	 *
	 * @return the baocaochitiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Baocaochitiet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the baocaochitiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of baocaochitiets
	 * @param end the upper bound of the range of baocaochitiets (not inclusive)
	 * @return the range of baocaochitiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Baocaochitiet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the baocaochitiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of baocaochitiets
	 * @param end the upper bound of the range of baocaochitiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of baocaochitiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Baocaochitiet> findAll(int start, int end,
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

		List<Baocaochitiet> list = (List<Baocaochitiet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BAOCAOCHITIET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BAOCAOCHITIET;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Baocaochitiet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Baocaochitiet>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the baocaochitiets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Baocaochitiet baocaochitiet : findAll()) {
			remove(baocaochitiet);
		}
	}

	/**
	 * Returns the number of baocaochitiets.
	 *
	 * @return the number of baocaochitiets
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BAOCAOCHITIET);

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
	 * Initializes the baocaochitiet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Baocaochitiet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Baocaochitiet>> listenersList = new ArrayList<ModelListener<Baocaochitiet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Baocaochitiet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BaocaochitietImpl.class.getName());
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
	private static final String _SQL_SELECT_BAOCAOCHITIET = "SELECT baocaochitiet FROM Baocaochitiet baocaochitiet";
	private static final String _SQL_COUNT_BAOCAOCHITIET = "SELECT COUNT(baocaochitiet) FROM Baocaochitiet baocaochitiet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "baocaochitiet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Baocaochitiet exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BaocaochitietPersistenceImpl.class);
	private static Baocaochitiet _nullBaocaochitiet = new BaocaochitietImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Baocaochitiet> toCacheModel() {
				return _nullBaocaochitietCacheModel;
			}
		};

	private static CacheModel<Baocaochitiet> _nullBaocaochitietCacheModel = new CacheModel<Baocaochitiet>() {
			public Baocaochitiet toEntityModel() {
				return _nullBaocaochitiet;
			}
		};
}