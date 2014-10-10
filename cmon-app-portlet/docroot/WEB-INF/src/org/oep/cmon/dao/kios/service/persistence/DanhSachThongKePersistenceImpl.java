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

package org.oep.cmon.dao.kios.service.persistence;

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

import org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException;
import org.oep.cmon.dao.kios.model.DanhSachThongKe;
import org.oep.cmon.dao.kios.model.impl.DanhSachThongKeImpl;
import org.oep.cmon.dao.kios.model.impl.DanhSachThongKeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh sach thong ke service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachThongKePersistence
 * @see DanhSachThongKeUtil
 * @generated
 */
public class DanhSachThongKePersistenceImpl extends BasePersistenceImpl<DanhSachThongKe>
	implements DanhSachThongKePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhSachThongKeUtil} to access the danh sach thong ke persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhSachThongKeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachThongKeModelImpl.FINDER_CACHE_ENABLED,
			DanhSachThongKeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachThongKeModelImpl.FINDER_CACHE_ENABLED,
			DanhSachThongKeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachThongKeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh sach thong ke in the entity cache if it is enabled.
	 *
	 * @param danhSachThongKe the danh sach thong ke
	 */
	public void cacheResult(DanhSachThongKe danhSachThongKe) {
		EntityCacheUtil.putResult(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachThongKeImpl.class, danhSachThongKe.getPrimaryKey(),
			danhSachThongKe);

		danhSachThongKe.resetOriginalValues();
	}

	/**
	 * Caches the danh sach thong kes in the entity cache if it is enabled.
	 *
	 * @param danhSachThongKes the danh sach thong kes
	 */
	public void cacheResult(List<DanhSachThongKe> danhSachThongKes) {
		for (DanhSachThongKe danhSachThongKe : danhSachThongKes) {
			if (EntityCacheUtil.getResult(
						DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachThongKeImpl.class,
						danhSachThongKe.getPrimaryKey()) == null) {
				cacheResult(danhSachThongKe);
			}
			else {
				danhSachThongKe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh sach thong kes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhSachThongKeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhSachThongKeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh sach thong ke.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhSachThongKe danhSachThongKe) {
		EntityCacheUtil.removeResult(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachThongKeImpl.class, danhSachThongKe.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DanhSachThongKe> danhSachThongKes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhSachThongKe danhSachThongKe : danhSachThongKes) {
			EntityCacheUtil.removeResult(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachThongKeImpl.class, danhSachThongKe.getPrimaryKey());
		}
	}

	/**
	 * Creates a new danh sach thong ke with the primary key. Does not add the danh sach thong ke to the database.
	 *
	 * @param COQUANQUANLYID the primary key for the new danh sach thong ke
	 * @return the new danh sach thong ke
	 */
	public DanhSachThongKe create(long COQUANQUANLYID) {
		DanhSachThongKe danhSachThongKe = new DanhSachThongKeImpl();

		danhSachThongKe.setNew(true);
		danhSachThongKe.setPrimaryKey(COQUANQUANLYID);

		return danhSachThongKe;
	}

	/**
	 * Removes the danh sach thong ke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param COQUANQUANLYID the primary key of the danh sach thong ke
	 * @return the danh sach thong ke that was removed
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachThongKe remove(long COQUANQUANLYID)
		throws NoSuchDanhSachThongKeException, SystemException {
		return remove(Long.valueOf(COQUANQUANLYID));
	}

	/**
	 * Removes the danh sach thong ke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh sach thong ke
	 * @return the danh sach thong ke that was removed
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachThongKe remove(Serializable primaryKey)
		throws NoSuchDanhSachThongKeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhSachThongKe danhSachThongKe = (DanhSachThongKe)session.get(DanhSachThongKeImpl.class,
					primaryKey);

			if (danhSachThongKe == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhSachThongKeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhSachThongKe);
		}
		catch (NoSuchDanhSachThongKeException nsee) {
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
	protected DanhSachThongKe removeImpl(DanhSachThongKe danhSachThongKe)
		throws SystemException {
		danhSachThongKe = toUnwrappedModel(danhSachThongKe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhSachThongKe);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhSachThongKe);

		return danhSachThongKe;
	}

	@Override
	public DanhSachThongKe updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachThongKe danhSachThongKe,
		boolean merge) throws SystemException {
		danhSachThongKe = toUnwrappedModel(danhSachThongKe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhSachThongKe, merge);

			danhSachThongKe.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachThongKeImpl.class, danhSachThongKe.getPrimaryKey(),
			danhSachThongKe);

		return danhSachThongKe;
	}

	protected DanhSachThongKe toUnwrappedModel(DanhSachThongKe danhSachThongKe) {
		if (danhSachThongKe instanceof DanhSachThongKeImpl) {
			return danhSachThongKe;
		}

		DanhSachThongKeImpl danhSachThongKeImpl = new DanhSachThongKeImpl();

		danhSachThongKeImpl.setNew(danhSachThongKe.isNew());
		danhSachThongKeImpl.setPrimaryKey(danhSachThongKe.getPrimaryKey());

		danhSachThongKeImpl.setCAPCOQUANQUANLYID(danhSachThongKe.getCAPCOQUANQUANLYID());
		danhSachThongKeImpl.setCOQUANQUANLYID(danhSachThongKe.getCOQUANQUANLYID());
		danhSachThongKeImpl.setTHANG(danhSachThongKe.getTHANG());
		danhSachThongKeImpl.setNAM(danhSachThongKe.getNAM());
		danhSachThongKeImpl.setTONGNHAN(danhSachThongKe.getTONGNHAN());
		danhSachThongKeImpl.setTIEPNHAN(danhSachThongKe.getTIEPNHAN());
		danhSachThongKeImpl.setTONDAU(danhSachThongKe.getTONDAU());
		danhSachThongKeImpl.setTONGDAGIAIQUYET(danhSachThongKe.getTONGDAGIAIQUYET());
		danhSachThongKeImpl.setSOM(danhSachThongKe.getSOM());
		danhSachThongKeImpl.setDUNG(danhSachThongKe.getDUNG());
		danhSachThongKeImpl.setTRE(danhSachThongKe.getTRE());
		danhSachThongKeImpl.setTONGDANGGIAIQUYET(danhSachThongKe.getTONGDANGGIAIQUYET());
		danhSachThongKeImpl.setCHUADENHAN(danhSachThongKe.getCHUADENHAN());
		danhSachThongKeImpl.setQUAHAN(danhSachThongKe.getQUAHAN());
		danhSachThongKeImpl.setRUTHOSO(danhSachThongKe.getRUTHOSO());
		danhSachThongKeImpl.setKHONGHOPLE(danhSachThongKe.getKHONGHOPLE());
		danhSachThongKeImpl.setTYLE(danhSachThongKe.getTYLE());
		danhSachThongKeImpl.setTONCUOI(danhSachThongKe.getTONCUOI());
		danhSachThongKeImpl.setTENCAPCOQUANQUANLY(danhSachThongKe.getTENCAPCOQUANQUANLY());
		danhSachThongKeImpl.setTENCOQUANQUANLY(danhSachThongKe.getTENCOQUANQUANLY());

		return danhSachThongKeImpl;
	}

	/**
	 * Returns the danh sach thong ke with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach thong ke
	 * @return the danh sach thong ke
	 * @throws com.liferay.portal.NoSuchModelException if a danh sach thong ke with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachThongKe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach thong ke with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException} if it could not be found.
	 *
	 * @param COQUANQUANLYID the primary key of the danh sach thong ke
	 * @return the danh sach thong ke
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachThongKe findByPrimaryKey(long COQUANQUANLYID)
		throws NoSuchDanhSachThongKeException, SystemException {
		DanhSachThongKe danhSachThongKe = fetchByPrimaryKey(COQUANQUANLYID);

		if (danhSachThongKe == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + COQUANQUANLYID);
			}

			throw new NoSuchDanhSachThongKeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				COQUANQUANLYID);
		}

		return danhSachThongKe;
	}

	/**
	 * Returns the danh sach thong ke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach thong ke
	 * @return the danh sach thong ke, or <code>null</code> if a danh sach thong ke with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachThongKe fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach thong ke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param COQUANQUANLYID the primary key of the danh sach thong ke
	 * @return the danh sach thong ke, or <code>null</code> if a danh sach thong ke with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachThongKe fetchByPrimaryKey(long COQUANQUANLYID)
		throws SystemException {
		DanhSachThongKe danhSachThongKe = (DanhSachThongKe)EntityCacheUtil.getResult(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachThongKeImpl.class, COQUANQUANLYID);

		if (danhSachThongKe == _nullDanhSachThongKe) {
			return null;
		}

		if (danhSachThongKe == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhSachThongKe = (DanhSachThongKe)session.get(DanhSachThongKeImpl.class,
						Long.valueOf(COQUANQUANLYID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhSachThongKe != null) {
					cacheResult(danhSachThongKe);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhSachThongKeModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachThongKeImpl.class, COQUANQUANLYID,
						_nullDanhSachThongKe);
				}

				closeSession(session);
			}
		}

		return danhSachThongKe;
	}

	/**
	 * Returns all the danh sach thong kes.
	 *
	 * @return the danh sach thong kes
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachThongKe> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh sach thong kes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach thong kes
	 * @param end the upper bound of the range of danh sach thong kes (not inclusive)
	 * @return the range of danh sach thong kes
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachThongKe> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh sach thong kes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach thong kes
	 * @param end the upper bound of the range of danh sach thong kes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh sach thong kes
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachThongKe> findAll(int start, int end,
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

		List<DanhSachThongKe> list = (List<DanhSachThongKe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHSACHTHONGKE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHSACHTHONGKE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhSachThongKe>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhSachThongKe>)QueryUtil.list(q,
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
	 * Removes all the danh sach thong kes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhSachThongKe danhSachThongKe : findAll()) {
			remove(danhSachThongKe);
		}
	}

	/**
	 * Returns the number of danh sach thong kes.
	 *
	 * @return the number of danh sach thong kes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHSACHTHONGKE);

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
	 * Initializes the danh sach thong ke persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.kios.model.DanhSachThongKe")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhSachThongKe>> listenersList = new ArrayList<ModelListener<DanhSachThongKe>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhSachThongKe>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhSachThongKeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DanhSachCoQuanPersistence.class)
	protected DanhSachCoQuanPersistence danhSachCoQuanPersistence;
	@BeanReference(type = DanhSachHoSoPersistence.class)
	protected DanhSachHoSoPersistence danhSachHoSoPersistence;
	@BeanReference(type = DanhSachThongKePersistence.class)
	protected DanhSachThongKePersistence danhSachThongKePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DANHSACHTHONGKE = "SELECT danhSachThongKe FROM DanhSachThongKe danhSachThongKe";
	private static final String _SQL_COUNT_DANHSACHTHONGKE = "SELECT COUNT(danhSachThongKe) FROM DanhSachThongKe danhSachThongKe";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhSachThongKe.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhSachThongKe exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhSachThongKePersistenceImpl.class);
	private static DanhSachThongKe _nullDanhSachThongKe = new DanhSachThongKeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhSachThongKe> toCacheModel() {
				return _nullDanhSachThongKeCacheModel;
			}
		};

	private static CacheModel<DanhSachThongKe> _nullDanhSachThongKeCacheModel = new CacheModel<DanhSachThongKe>() {
			public DanhSachThongKe toEntityModel() {
				return _nullDanhSachThongKe;
			}
		};
}