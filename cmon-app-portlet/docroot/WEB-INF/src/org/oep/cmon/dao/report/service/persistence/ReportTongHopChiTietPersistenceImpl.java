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

import org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException;
import org.oep.cmon.dao.report.model.ReportTongHopChiTiet;
import org.oep.cmon.dao.report.model.impl.ReportTongHopChiTietImpl;
import org.oep.cmon.dao.report.model.impl.ReportTongHopChiTietModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the report tong hop chi tiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see ReportTongHopChiTietPersistence
 * @see ReportTongHopChiTietUtil
 * @generated
 */
public class ReportTongHopChiTietPersistenceImpl extends BasePersistenceImpl<ReportTongHopChiTiet>
	implements ReportTongHopChiTietPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReportTongHopChiTietUtil} to access the report tong hop chi tiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReportTongHopChiTietImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopChiTietModelImpl.FINDER_CACHE_ENABLED,
			ReportTongHopChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopChiTietModelImpl.FINDER_CACHE_ENABLED,
			ReportTongHopChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopChiTietModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the report tong hop chi tiet in the entity cache if it is enabled.
	 *
	 * @param reportTongHopChiTiet the report tong hop chi tiet
	 */
	public void cacheResult(ReportTongHopChiTiet reportTongHopChiTiet) {
		EntityCacheUtil.putResult(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopChiTietImpl.class,
			reportTongHopChiTiet.getPrimaryKey(), reportTongHopChiTiet);

		reportTongHopChiTiet.resetOriginalValues();
	}

	/**
	 * Caches the report tong hop chi tiets in the entity cache if it is enabled.
	 *
	 * @param reportTongHopChiTiets the report tong hop chi tiets
	 */
	public void cacheResult(List<ReportTongHopChiTiet> reportTongHopChiTiets) {
		for (ReportTongHopChiTiet reportTongHopChiTiet : reportTongHopChiTiets) {
			if (EntityCacheUtil.getResult(
						ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
						ReportTongHopChiTietImpl.class,
						reportTongHopChiTiet.getPrimaryKey()) == null) {
				cacheResult(reportTongHopChiTiet);
			}
			else {
				reportTongHopChiTiet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all report tong hop chi tiets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReportTongHopChiTietImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReportTongHopChiTietImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the report tong hop chi tiet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReportTongHopChiTiet reportTongHopChiTiet) {
		EntityCacheUtil.removeResult(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopChiTietImpl.class, reportTongHopChiTiet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ReportTongHopChiTiet> reportTongHopChiTiets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReportTongHopChiTiet reportTongHopChiTiet : reportTongHopChiTiets) {
			EntityCacheUtil.removeResult(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
				ReportTongHopChiTietImpl.class,
				reportTongHopChiTiet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new report tong hop chi tiet with the primary key. Does not add the report tong hop chi tiet to the database.
	 *
	 * @param reportTongHopChiTietPK the primary key for the new report tong hop chi tiet
	 * @return the new report tong hop chi tiet
	 */
	public ReportTongHopChiTiet create(
		ReportTongHopChiTietPK reportTongHopChiTietPK) {
		ReportTongHopChiTiet reportTongHopChiTiet = new ReportTongHopChiTietImpl();

		reportTongHopChiTiet.setNew(true);
		reportTongHopChiTiet.setPrimaryKey(reportTongHopChiTietPK);

		return reportTongHopChiTiet;
	}

	/**
	 * Removes the report tong hop chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	 * @return the report tong hop chi tiet that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException if a report tong hop chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ReportTongHopChiTiet remove(
		ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws NoSuchReportTongHopChiTietException, SystemException {
		return remove((Serializable)reportTongHopChiTietPK);
	}

	/**
	 * Removes the report tong hop chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the report tong hop chi tiet
	 * @return the report tong hop chi tiet that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException if a report tong hop chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportTongHopChiTiet remove(Serializable primaryKey)
		throws NoSuchReportTongHopChiTietException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ReportTongHopChiTiet reportTongHopChiTiet = (ReportTongHopChiTiet)session.get(ReportTongHopChiTietImpl.class,
					primaryKey);

			if (reportTongHopChiTiet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReportTongHopChiTietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(reportTongHopChiTiet);
		}
		catch (NoSuchReportTongHopChiTietException nsee) {
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
	protected ReportTongHopChiTiet removeImpl(
		ReportTongHopChiTiet reportTongHopChiTiet) throws SystemException {
		reportTongHopChiTiet = toUnwrappedModel(reportTongHopChiTiet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, reportTongHopChiTiet);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(reportTongHopChiTiet);

		return reportTongHopChiTiet;
	}

	@Override
	public ReportTongHopChiTiet updateImpl(
		org.oep.cmon.dao.report.model.ReportTongHopChiTiet reportTongHopChiTiet,
		boolean merge) throws SystemException {
		reportTongHopChiTiet = toUnwrappedModel(reportTongHopChiTiet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, reportTongHopChiTiet, merge);

			reportTongHopChiTiet.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
			ReportTongHopChiTietImpl.class,
			reportTongHopChiTiet.getPrimaryKey(), reportTongHopChiTiet);

		return reportTongHopChiTiet;
	}

	protected ReportTongHopChiTiet toUnwrappedModel(
		ReportTongHopChiTiet reportTongHopChiTiet) {
		if (reportTongHopChiTiet instanceof ReportTongHopChiTietImpl) {
			return reportTongHopChiTiet;
		}

		ReportTongHopChiTietImpl reportTongHopChiTietImpl = new ReportTongHopChiTietImpl();

		reportTongHopChiTietImpl.setNew(reportTongHopChiTiet.isNew());
		reportTongHopChiTietImpl.setPrimaryKey(reportTongHopChiTiet.getPrimaryKey());

		reportTongHopChiTietImpl.setCOQUANQUANLYID(reportTongHopChiTiet.getCOQUANQUANLYID());
		reportTongHopChiTietImpl.setNHOMTHUTUCHANHCHINHID(reportTongHopChiTiet.getNHOMTHUTUCHANHCHINHID());
		reportTongHopChiTietImpl.setTHUTUCHANHCHINHID(reportTongHopChiTiet.getTHUTUCHANHCHINHID());
		reportTongHopChiTietImpl.setTHANG(reportTongHopChiTiet.getTHANG());
		reportTongHopChiTietImpl.setNAM(reportTongHopChiTiet.getNAM());
		reportTongHopChiTietImpl.setTONGNHAN(reportTongHopChiTiet.getTONGNHAN());
		reportTongHopChiTietImpl.setTIEPNHAN(reportTongHopChiTiet.getTIEPNHAN());
		reportTongHopChiTietImpl.setTONDAU(reportTongHopChiTiet.getTONDAU());
		reportTongHopChiTietImpl.setTONGDAGIAIQUYET(reportTongHopChiTiet.getTONGDAGIAIQUYET());
		reportTongHopChiTietImpl.setSOM(reportTongHopChiTiet.getSOM());
		reportTongHopChiTietImpl.setDUNG(reportTongHopChiTiet.getDUNG());
		reportTongHopChiTietImpl.setTRE(reportTongHopChiTiet.getTRE());
		reportTongHopChiTietImpl.setTONGDANGGIAIQUYET(reportTongHopChiTiet.getTONGDANGGIAIQUYET());
		reportTongHopChiTietImpl.setCHUADENHAN(reportTongHopChiTiet.getCHUADENHAN());
		reportTongHopChiTietImpl.setQUAHAN(reportTongHopChiTiet.getQUAHAN());
		reportTongHopChiTietImpl.setRUTHOSO(reportTongHopChiTiet.getRUTHOSO());
		reportTongHopChiTietImpl.setKHONGHOPLE(reportTongHopChiTiet.getKHONGHOPLE());
		reportTongHopChiTietImpl.setTYLE(reportTongHopChiTiet.getTYLE());
		reportTongHopChiTietImpl.setTONCUOI(reportTongHopChiTiet.getTONCUOI());

		return reportTongHopChiTietImpl;
	}

	/**
	 * Returns the report tong hop chi tiet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the report tong hop chi tiet
	 * @return the report tong hop chi tiet
	 * @throws com.liferay.portal.NoSuchModelException if a report tong hop chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportTongHopChiTiet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((ReportTongHopChiTietPK)primaryKey);
	}

	/**
	 * Returns the report tong hop chi tiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException} if it could not be found.
	 *
	 * @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	 * @return the report tong hop chi tiet
	 * @throws org.oep.cmon.dao.report.NoSuchReportTongHopChiTietException if a report tong hop chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ReportTongHopChiTiet findByPrimaryKey(
		ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws NoSuchReportTongHopChiTietException, SystemException {
		ReportTongHopChiTiet reportTongHopChiTiet = fetchByPrimaryKey(reportTongHopChiTietPK);

		if (reportTongHopChiTiet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					reportTongHopChiTietPK);
			}

			throw new NoSuchReportTongHopChiTietException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				reportTongHopChiTietPK);
		}

		return reportTongHopChiTiet;
	}

	/**
	 * Returns the report tong hop chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the report tong hop chi tiet
	 * @return the report tong hop chi tiet, or <code>null</code> if a report tong hop chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportTongHopChiTiet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((ReportTongHopChiTietPK)primaryKey);
	}

	/**
	 * Returns the report tong hop chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportTongHopChiTietPK the primary key of the report tong hop chi tiet
	 * @return the report tong hop chi tiet, or <code>null</code> if a report tong hop chi tiet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ReportTongHopChiTiet fetchByPrimaryKey(
		ReportTongHopChiTietPK reportTongHopChiTietPK)
		throws SystemException {
		ReportTongHopChiTiet reportTongHopChiTiet = (ReportTongHopChiTiet)EntityCacheUtil.getResult(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
				ReportTongHopChiTietImpl.class, reportTongHopChiTietPK);

		if (reportTongHopChiTiet == _nullReportTongHopChiTiet) {
			return null;
		}

		if (reportTongHopChiTiet == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				reportTongHopChiTiet = (ReportTongHopChiTiet)session.get(ReportTongHopChiTietImpl.class,
						reportTongHopChiTietPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (reportTongHopChiTiet != null) {
					cacheResult(reportTongHopChiTiet);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ReportTongHopChiTietModelImpl.ENTITY_CACHE_ENABLED,
						ReportTongHopChiTietImpl.class, reportTongHopChiTietPK,
						_nullReportTongHopChiTiet);
				}

				closeSession(session);
			}
		}

		return reportTongHopChiTiet;
	}

	/**
	 * Returns all the report tong hop chi tiets.
	 *
	 * @return the report tong hop chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<ReportTongHopChiTiet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report tong hop chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of report tong hop chi tiets
	 * @param end the upper bound of the range of report tong hop chi tiets (not inclusive)
	 * @return the range of report tong hop chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<ReportTongHopChiTiet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the report tong hop chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of report tong hop chi tiets
	 * @param end the upper bound of the range of report tong hop chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of report tong hop chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	public List<ReportTongHopChiTiet> findAll(int start, int end,
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

		List<ReportTongHopChiTiet> list = (List<ReportTongHopChiTiet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REPORTTONGHOPCHITIET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REPORTTONGHOPCHITIET.concat(ReportTongHopChiTietModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ReportTongHopChiTiet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ReportTongHopChiTiet>)QueryUtil.list(q,
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
	 * Removes all the report tong hop chi tiets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ReportTongHopChiTiet reportTongHopChiTiet : findAll()) {
			remove(reportTongHopChiTiet);
		}
	}

	/**
	 * Returns the number of report tong hop chi tiets.
	 *
	 * @return the number of report tong hop chi tiets
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REPORTTONGHOPCHITIET);

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
	 * Initializes the report tong hop chi tiet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.ReportTongHopChiTiet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ReportTongHopChiTiet>> listenersList = new ArrayList<ModelListener<ReportTongHopChiTiet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ReportTongHopChiTiet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReportTongHopChiTietImpl.class.getName());
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
	private static final String _SQL_SELECT_REPORTTONGHOPCHITIET = "SELECT reportTongHopChiTiet FROM ReportTongHopChiTiet reportTongHopChiTiet";
	private static final String _SQL_COUNT_REPORTTONGHOPCHITIET = "SELECT COUNT(reportTongHopChiTiet) FROM ReportTongHopChiTiet reportTongHopChiTiet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reportTongHopChiTiet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReportTongHopChiTiet exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReportTongHopChiTietPersistenceImpl.class);
	private static ReportTongHopChiTiet _nullReportTongHopChiTiet = new ReportTongHopChiTietImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ReportTongHopChiTiet> toCacheModel() {
				return _nullReportTongHopChiTietCacheModel;
			}
		};

	private static CacheModel<ReportTongHopChiTiet> _nullReportTongHopChiTietCacheModel =
		new CacheModel<ReportTongHopChiTiet>() {
			public ReportTongHopChiTiet toEntityModel() {
				return _nullReportTongHopChiTiet;
			}
		};
}