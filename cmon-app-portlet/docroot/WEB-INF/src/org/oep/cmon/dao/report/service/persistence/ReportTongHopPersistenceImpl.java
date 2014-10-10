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

import org.oep.cmon.dao.report.NoSuchReportTongHopException;
import org.oep.cmon.dao.report.model.ReportTongHop;
import org.oep.cmon.dao.report.model.impl.ReportTongHopImpl;
import org.oep.cmon.dao.report.model.impl.ReportTongHopModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the report tong hop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see ReportTongHopPersistence
 * @see ReportTongHopUtil
 * @generated
 */
public class ReportTongHopPersistenceImpl extends BasePersistenceImpl<ReportTongHop>
	implements ReportTongHopPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReportTongHopUtil} to access the report tong hop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReportTongHopImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopModelImpl.FINDER_CACHE_ENABLED,
			ReportTongHopImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopModelImpl.FINDER_CACHE_ENABLED,
			ReportTongHopImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the report tong hop in the entity cache if it is enabled.
	 *
	 * @param reportTongHop the report tong hop
	 */
	public void cacheResult(ReportTongHop reportTongHop) {
		EntityCacheUtil.putResult(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopImpl.class, reportTongHop.getPrimaryKey(),
			reportTongHop);

		reportTongHop.resetOriginalValues();
	}

	/**
	 * Caches the report tong hops in the entity cache if it is enabled.
	 *
	 * @param reportTongHops the report tong hops
	 */
	public void cacheResult(List<ReportTongHop> reportTongHops) {
		for (ReportTongHop reportTongHop : reportTongHops) {
			if (EntityCacheUtil.getResult(
						ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
						ReportTongHopImpl.class, reportTongHop.getPrimaryKey()) == null) {
				cacheResult(reportTongHop);
			}
			else {
				reportTongHop.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all report tong hops.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReportTongHopImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReportTongHopImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the report tong hop.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReportTongHop reportTongHop) {
		EntityCacheUtil.removeResult(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopImpl.class, reportTongHop.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ReportTongHop> reportTongHops) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReportTongHop reportTongHop : reportTongHops) {
			EntityCacheUtil.removeResult(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
				ReportTongHopImpl.class, reportTongHop.getPrimaryKey());
		}
	}

	/**
	 * Creates a new report tong hop with the primary key. Does not add the report tong hop to the database.
	 *
	 * @param reportTongHopPK the primary key for the new report tong hop
	 * @return the new report tong hop
	 */
	public ReportTongHop create(ReportTongHopPK reportTongHopPK) {
		ReportTongHop reportTongHop = new ReportTongHopImpl();

		reportTongHop.setNew(true);
		reportTongHop.setPrimaryKey(reportTongHopPK);

		return reportTongHop;
	}

	/**
	 * Removes the report tong hop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportTongHopPK the primary key of the report tong hop
	 * @return the report tong hop that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ReportTongHop remove(ReportTongHopPK reportTongHopPK)
		throws NoSuchReportTongHopException, SystemException {
		return remove((Serializable)reportTongHopPK);
	}

	/**
	 * Removes the report tong hop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the report tong hop
	 * @return the report tong hop that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportTongHop remove(Serializable primaryKey)
		throws NoSuchReportTongHopException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ReportTongHop reportTongHop = (ReportTongHop)session.get(ReportTongHopImpl.class,
					primaryKey);

			if (reportTongHop == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReportTongHopException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(reportTongHop);
		}
		catch (NoSuchReportTongHopException nsee) {
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
	protected ReportTongHop removeImpl(ReportTongHop reportTongHop)
		throws SystemException {
		reportTongHop = toUnwrappedModel(reportTongHop);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, reportTongHop);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(reportTongHop);

		return reportTongHop;
	}

	@Override
	public ReportTongHop updateImpl(
		org.oep.cmon.dao.report.model.ReportTongHop reportTongHop, boolean merge)
		throws SystemException {
		reportTongHop = toUnwrappedModel(reportTongHop);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, reportTongHop, merge);

			reportTongHop.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopImpl.class, reportTongHop.getPrimaryKey(),
			reportTongHop);

		return reportTongHop;
	}

	protected ReportTongHop toUnwrappedModel(ReportTongHop reportTongHop) {
		if (reportTongHop instanceof ReportTongHopImpl) {
			return reportTongHop;
		}

		ReportTongHopImpl reportTongHopImpl = new ReportTongHopImpl();

		reportTongHopImpl.setNew(reportTongHop.isNew());
		reportTongHopImpl.setPrimaryKey(reportTongHop.getPrimaryKey());

		reportTongHopImpl.setCOQUANQUANLYID(reportTongHop.getCOQUANQUANLYID());
		reportTongHopImpl.setNHOMTHUTUCHANHCHINHID(reportTongHop.getNHOMTHUTUCHANHCHINHID());
		reportTongHopImpl.setTHANG(reportTongHop.getTHANG());
		reportTongHopImpl.setNAM(reportTongHop.getNAM());
		reportTongHopImpl.setTONGNHAN(reportTongHop.getTONGNHAN());
		reportTongHopImpl.setTIEPNHAN(reportTongHop.getTIEPNHAN());
		reportTongHopImpl.setTONDAU(reportTongHop.getTONDAU());
		reportTongHopImpl.setTONGDAGIAIQUYET(reportTongHop.getTONGDAGIAIQUYET());
		reportTongHopImpl.setSOM(reportTongHop.getSOM());
		reportTongHopImpl.setDUNG(reportTongHop.getDUNG());
		reportTongHopImpl.setTRE(reportTongHop.getTRE());
		reportTongHopImpl.setTONGDANGGIAIQUYET(reportTongHop.getTONGDANGGIAIQUYET());
		reportTongHopImpl.setCHUADENHAN(reportTongHop.getCHUADENHAN());
		reportTongHopImpl.setQUAHAN(reportTongHop.getQUAHAN());
		reportTongHopImpl.setRUTHOSO(reportTongHop.getRUTHOSO());
		reportTongHopImpl.setKHONGHOPLE(reportTongHop.getKHONGHOPLE());
		reportTongHopImpl.setTYLE(reportTongHop.getTYLE());
		reportTongHopImpl.setTONCUOI(reportTongHop.getTONCUOI());

		return reportTongHopImpl;
	}

	/**
	 * Returns the report tong hop with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the report tong hop
	 * @return the report tong hop
	 * @throws com.liferay.portal.NoSuchModelException if a report tong hop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportTongHop findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((ReportTongHopPK)primaryKey);
	}

	/**
	 * Returns the report tong hop with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchReportTongHopException} if it could not be found.
	 *
	 * @param reportTongHopPK the primary key of the report tong hop
	 * @return the report tong hop
	 * @throws org.oep.cmon.dao.report.NoSuchReportTongHopException if a report tong hop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ReportTongHop findByPrimaryKey(ReportTongHopPK reportTongHopPK)
		throws NoSuchReportTongHopException, SystemException {
		ReportTongHop reportTongHop = fetchByPrimaryKey(reportTongHopPK);

		if (reportTongHop == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + reportTongHopPK);
			}

			throw new NoSuchReportTongHopException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				reportTongHopPK);
		}

		return reportTongHop;
	}

	/**
	 * Returns the report tong hop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the report tong hop
	 * @return the report tong hop, or <code>null</code> if a report tong hop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportTongHop fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((ReportTongHopPK)primaryKey);
	}

	/**
	 * Returns the report tong hop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportTongHopPK the primary key of the report tong hop
	 * @return the report tong hop, or <code>null</code> if a report tong hop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ReportTongHop fetchByPrimaryKey(ReportTongHopPK reportTongHopPK)
		throws SystemException {
		ReportTongHop reportTongHop = (ReportTongHop)EntityCacheUtil.getResult(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
				ReportTongHopImpl.class, reportTongHopPK);

		if (reportTongHop == _nullReportTongHop) {
			return null;
		}

		if (reportTongHop == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				reportTongHop = (ReportTongHop)session.get(ReportTongHopImpl.class,
						reportTongHopPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (reportTongHop != null) {
					cacheResult(reportTongHop);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ReportTongHopModelImpl.ENTITY_CACHE_ENABLED,
						ReportTongHopImpl.class, reportTongHopPK,
						_nullReportTongHop);
				}

				closeSession(session);
			}
		}

		return reportTongHop;
	}

	/**
	 * Returns all the report tong hops.
	 *
	 * @return the report tong hops
	 * @throws SystemException if a system exception occurred
	 */
	public List<ReportTongHop> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report tong hops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of report tong hops
	 * @param end the upper bound of the range of report tong hops (not inclusive)
	 * @return the range of report tong hops
	 * @throws SystemException if a system exception occurred
	 */
	public List<ReportTongHop> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the report tong hops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of report tong hops
	 * @param end the upper bound of the range of report tong hops (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of report tong hops
	 * @throws SystemException if a system exception occurred
	 */
	public List<ReportTongHop> findAll(int start, int end,
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

		List<ReportTongHop> list = (List<ReportTongHop>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REPORTTONGHOP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REPORTTONGHOP.concat(ReportTongHopModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ReportTongHop>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ReportTongHop>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the report tong hops from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ReportTongHop reportTongHop : findAll()) {
			remove(reportTongHop);
		}
	}

	/**
	 * Returns the number of report tong hops.
	 *
	 * @return the number of report tong hops
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REPORTTONGHOP);

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
	 * Initializes the report tong hop persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.ReportTongHop")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ReportTongHop>> listenersList = new ArrayList<ModelListener<ReportTongHop>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ReportTongHop>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReportTongHopImpl.class.getName());
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
	private static final String _SQL_SELECT_REPORTTONGHOP = "SELECT reportTongHop FROM ReportTongHop reportTongHop";
	private static final String _SQL_COUNT_REPORTTONGHOP = "SELECT COUNT(reportTongHop) FROM ReportTongHop reportTongHop";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reportTongHop.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReportTongHop exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReportTongHopPersistenceImpl.class);
	private static ReportTongHop _nullReportTongHop = new ReportTongHopImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ReportTongHop> toCacheModel() {
				return _nullReportTongHopCacheModel;
			}
		};

	private static CacheModel<ReportTongHop> _nullReportTongHopCacheModel = new CacheModel<ReportTongHop>() {
			public ReportTongHop toEntityModel() {
				return _nullReportTongHop;
			}
		};
}