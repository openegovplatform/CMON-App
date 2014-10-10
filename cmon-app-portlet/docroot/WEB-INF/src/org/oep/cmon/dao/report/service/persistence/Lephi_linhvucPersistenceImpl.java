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

import org.oep.cmon.dao.report.NoSuchLephi_linhvucException;
import org.oep.cmon.dao.report.model.Lephi_linhvuc;
import org.oep.cmon.dao.report.model.impl.Lephi_linhvucImpl;
import org.oep.cmon.dao.report.model.impl.Lephi_linhvucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lephi_linhvuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_linhvucPersistence
 * @see Lephi_linhvucUtil
 * @generated
 */
public class Lephi_linhvucPersistenceImpl extends BasePersistenceImpl<Lephi_linhvuc>
	implements Lephi_linhvucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lephi_linhvucUtil} to access the lephi_linhvuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lephi_linhvucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_linhvucModelImpl.FINDER_CACHE_ENABLED,
			Lephi_linhvucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_linhvucModelImpl.FINDER_CACHE_ENABLED,
			Lephi_linhvucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_linhvucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the lephi_linhvuc in the entity cache if it is enabled.
	 *
	 * @param lephi_linhvuc the lephi_linhvuc
	 */
	public void cacheResult(Lephi_linhvuc lephi_linhvuc) {
		EntityCacheUtil.putResult(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_linhvucImpl.class, lephi_linhvuc.getPrimaryKey(),
			lephi_linhvuc);

		lephi_linhvuc.resetOriginalValues();
	}

	/**
	 * Caches the lephi_linhvucs in the entity cache if it is enabled.
	 *
	 * @param lephi_linhvucs the lephi_linhvucs
	 */
	public void cacheResult(List<Lephi_linhvuc> lephi_linhvucs) {
		for (Lephi_linhvuc lephi_linhvuc : lephi_linhvucs) {
			if (EntityCacheUtil.getResult(
						Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
						Lephi_linhvucImpl.class, lephi_linhvuc.getPrimaryKey()) == null) {
				cacheResult(lephi_linhvuc);
			}
			else {
				lephi_linhvuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lephi_linhvucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lephi_linhvucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lephi_linhvucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lephi_linhvuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lephi_linhvuc lephi_linhvuc) {
		EntityCacheUtil.removeResult(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_linhvucImpl.class, lephi_linhvuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lephi_linhvuc> lephi_linhvucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lephi_linhvuc lephi_linhvuc : lephi_linhvucs) {
			EntityCacheUtil.removeResult(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
				Lephi_linhvucImpl.class, lephi_linhvuc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lephi_linhvuc with the primary key. Does not add the lephi_linhvuc to the database.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key for the new lephi_linhvuc
	 * @return the new lephi_linhvuc
	 */
	public Lephi_linhvuc create(int NHOMTHUTUCHANHCHINHID) {
		Lephi_linhvuc lephi_linhvuc = new Lephi_linhvucImpl();

		lephi_linhvuc.setNew(true);
		lephi_linhvuc.setPrimaryKey(NHOMTHUTUCHANHCHINHID);

		return lephi_linhvuc;
	}

	/**
	 * Removes the lephi_linhvuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	 * @return the lephi_linhvuc that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_linhvuc remove(int NHOMTHUTUCHANHCHINHID)
		throws NoSuchLephi_linhvucException, SystemException {
		return remove(Integer.valueOf(NHOMTHUTUCHANHCHINHID));
	}

	/**
	 * Removes the lephi_linhvuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lephi_linhvuc
	 * @return the lephi_linhvuc that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_linhvuc remove(Serializable primaryKey)
		throws NoSuchLephi_linhvucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lephi_linhvuc lephi_linhvuc = (Lephi_linhvuc)session.get(Lephi_linhvucImpl.class,
					primaryKey);

			if (lephi_linhvuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLephi_linhvucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lephi_linhvuc);
		}
		catch (NoSuchLephi_linhvucException nsee) {
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
	protected Lephi_linhvuc removeImpl(Lephi_linhvuc lephi_linhvuc)
		throws SystemException {
		lephi_linhvuc = toUnwrappedModel(lephi_linhvuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lephi_linhvuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lephi_linhvuc);

		return lephi_linhvuc;
	}

	@Override
	public Lephi_linhvuc updateImpl(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc, boolean merge)
		throws SystemException {
		lephi_linhvuc = toUnwrappedModel(lephi_linhvuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lephi_linhvuc, merge);

			lephi_linhvuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
			Lephi_linhvucImpl.class, lephi_linhvuc.getPrimaryKey(),
			lephi_linhvuc);

		return lephi_linhvuc;
	}

	protected Lephi_linhvuc toUnwrappedModel(Lephi_linhvuc lephi_linhvuc) {
		if (lephi_linhvuc instanceof Lephi_linhvucImpl) {
			return lephi_linhvuc;
		}

		Lephi_linhvucImpl lephi_linhvucImpl = new Lephi_linhvucImpl();

		lephi_linhvucImpl.setNew(lephi_linhvuc.isNew());
		lephi_linhvucImpl.setPrimaryKey(lephi_linhvuc.getPrimaryKey());

		lephi_linhvucImpl.setNHOMTHUTUCHANHCHINHID(lephi_linhvuc.getNHOMTHUTUCHANHCHINHID());
		lephi_linhvucImpl.setTONGHOSO(lephi_linhvuc.getTONGHOSO());
		lephi_linhvucImpl.setLEPHIHOSO(lephi_linhvuc.getLEPHIHOSO());
		lephi_linhvucImpl.setPHIHOSO(lephi_linhvuc.getPHIHOSO());
		lephi_linhvucImpl.setTONGLEPHI(lephi_linhvuc.getTONGLEPHI());

		return lephi_linhvucImpl;
	}

	/**
	 * Returns the lephi_linhvuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lephi_linhvuc
	 * @return the lephi_linhvuc
	 * @throws com.liferay.portal.NoSuchModelException if a lephi_linhvuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_linhvuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the lephi_linhvuc with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_linhvucException} if it could not be found.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	 * @return the lephi_linhvuc
	 * @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_linhvuc findByPrimaryKey(int NHOMTHUTUCHANHCHINHID)
		throws NoSuchLephi_linhvucException, SystemException {
		Lephi_linhvuc lephi_linhvuc = fetchByPrimaryKey(NHOMTHUTUCHANHCHINHID);

		if (lephi_linhvuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					NHOMTHUTUCHANHCHINHID);
			}

			throw new NoSuchLephi_linhvucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				NHOMTHUTUCHANHCHINHID);
		}

		return lephi_linhvuc;
	}

	/**
	 * Returns the lephi_linhvuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lephi_linhvuc
	 * @return the lephi_linhvuc, or <code>null</code> if a lephi_linhvuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lephi_linhvuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the lephi_linhvuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	 * @return the lephi_linhvuc, or <code>null</code> if a lephi_linhvuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lephi_linhvuc fetchByPrimaryKey(int NHOMTHUTUCHANHCHINHID)
		throws SystemException {
		Lephi_linhvuc lephi_linhvuc = (Lephi_linhvuc)EntityCacheUtil.getResult(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
				Lephi_linhvucImpl.class, NHOMTHUTUCHANHCHINHID);

		if (lephi_linhvuc == _nullLephi_linhvuc) {
			return null;
		}

		if (lephi_linhvuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lephi_linhvuc = (Lephi_linhvuc)session.get(Lephi_linhvucImpl.class,
						Integer.valueOf(NHOMTHUTUCHANHCHINHID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lephi_linhvuc != null) {
					cacheResult(lephi_linhvuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Lephi_linhvucModelImpl.ENTITY_CACHE_ENABLED,
						Lephi_linhvucImpl.class, NHOMTHUTUCHANHCHINHID,
						_nullLephi_linhvuc);
				}

				closeSession(session);
			}
		}

		return lephi_linhvuc;
	}

	/**
	 * Returns all the lephi_linhvucs.
	 *
	 * @return the lephi_linhvucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_linhvuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lephi_linhvucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lephi_linhvucs
	 * @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	 * @return the range of lephi_linhvucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_linhvuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lephi_linhvucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of lephi_linhvucs
	 * @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lephi_linhvucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lephi_linhvuc> findAll(int start, int end,
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

		List<Lephi_linhvuc> list = (List<Lephi_linhvuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEPHI_LINHVUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEPHI_LINHVUC.concat(Lephi_linhvucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Lephi_linhvuc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Lephi_linhvuc>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lephi_linhvucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Lephi_linhvuc lephi_linhvuc : findAll()) {
			remove(lephi_linhvuc);
		}
	}

	/**
	 * Returns the number of lephi_linhvucs.
	 *
	 * @return the number of lephi_linhvucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEPHI_LINHVUC);

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
	 * Initializes the lephi_linhvuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.Lephi_linhvuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lephi_linhvuc>> listenersList = new ArrayList<ModelListener<Lephi_linhvuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lephi_linhvuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lephi_linhvucImpl.class.getName());
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
	private static final String _SQL_SELECT_LEPHI_LINHVUC = "SELECT lephi_linhvuc FROM Lephi_linhvuc lephi_linhvuc";
	private static final String _SQL_COUNT_LEPHI_LINHVUC = "SELECT COUNT(lephi_linhvuc) FROM Lephi_linhvuc lephi_linhvuc";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lephi_linhvuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lephi_linhvuc exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lephi_linhvucPersistenceImpl.class);
	private static Lephi_linhvuc _nullLephi_linhvuc = new Lephi_linhvucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lephi_linhvuc> toCacheModel() {
				return _nullLephi_linhvucCacheModel;
			}
		};

	private static CacheModel<Lephi_linhvuc> _nullLephi_linhvucCacheModel = new CacheModel<Lephi_linhvuc>() {
			public Lephi_linhvuc toEntityModel() {
				return _nullLephi_linhvuc;
			}
		};
}