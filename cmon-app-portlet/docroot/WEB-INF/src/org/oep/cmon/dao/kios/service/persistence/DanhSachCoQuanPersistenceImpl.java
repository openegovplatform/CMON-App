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

import org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException;
import org.oep.cmon.dao.kios.model.DanhSachCoQuan;
import org.oep.cmon.dao.kios.model.impl.DanhSachCoQuanImpl;
import org.oep.cmon.dao.kios.model.impl.DanhSachCoQuanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh sach co quan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachCoQuanPersistence
 * @see DanhSachCoQuanUtil
 * @generated
 */
public class DanhSachCoQuanPersistenceImpl extends BasePersistenceImpl<DanhSachCoQuan>
	implements DanhSachCoQuanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhSachCoQuanUtil} to access the danh sach co quan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhSachCoQuanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachCoQuanModelImpl.FINDER_CACHE_ENABLED,
			DanhSachCoQuanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachCoQuanModelImpl.FINDER_CACHE_ENABLED,
			DanhSachCoQuanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachCoQuanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh sach co quan in the entity cache if it is enabled.
	 *
	 * @param danhSachCoQuan the danh sach co quan
	 */
	public void cacheResult(DanhSachCoQuan danhSachCoQuan) {
		EntityCacheUtil.putResult(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachCoQuanImpl.class, danhSachCoQuan.getPrimaryKey(),
			danhSachCoQuan);

		danhSachCoQuan.resetOriginalValues();
	}

	/**
	 * Caches the danh sach co quans in the entity cache if it is enabled.
	 *
	 * @param danhSachCoQuans the danh sach co quans
	 */
	public void cacheResult(List<DanhSachCoQuan> danhSachCoQuans) {
		for (DanhSachCoQuan danhSachCoQuan : danhSachCoQuans) {
			if (EntityCacheUtil.getResult(
						DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachCoQuanImpl.class, danhSachCoQuan.getPrimaryKey()) == null) {
				cacheResult(danhSachCoQuan);
			}
			else {
				danhSachCoQuan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh sach co quans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhSachCoQuanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhSachCoQuanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh sach co quan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhSachCoQuan danhSachCoQuan) {
		EntityCacheUtil.removeResult(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachCoQuanImpl.class, danhSachCoQuan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DanhSachCoQuan> danhSachCoQuans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhSachCoQuan danhSachCoQuan : danhSachCoQuans) {
			EntityCacheUtil.removeResult(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachCoQuanImpl.class, danhSachCoQuan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new danh sach co quan with the primary key. Does not add the danh sach co quan to the database.
	 *
	 * @param id the primary key for the new danh sach co quan
	 * @return the new danh sach co quan
	 */
	public DanhSachCoQuan create(long id) {
		DanhSachCoQuan danhSachCoQuan = new DanhSachCoQuanImpl();

		danhSachCoQuan.setNew(true);
		danhSachCoQuan.setPrimaryKey(id);

		return danhSachCoQuan;
	}

	/**
	 * Removes the danh sach co quan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh sach co quan
	 * @return the danh sach co quan that was removed
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException if a danh sach co quan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachCoQuan remove(long id)
		throws NoSuchDanhSachCoQuanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the danh sach co quan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh sach co quan
	 * @return the danh sach co quan that was removed
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException if a danh sach co quan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachCoQuan remove(Serializable primaryKey)
		throws NoSuchDanhSachCoQuanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhSachCoQuan danhSachCoQuan = (DanhSachCoQuan)session.get(DanhSachCoQuanImpl.class,
					primaryKey);

			if (danhSachCoQuan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhSachCoQuanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhSachCoQuan);
		}
		catch (NoSuchDanhSachCoQuanException nsee) {
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
	protected DanhSachCoQuan removeImpl(DanhSachCoQuan danhSachCoQuan)
		throws SystemException {
		danhSachCoQuan = toUnwrappedModel(danhSachCoQuan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhSachCoQuan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhSachCoQuan);

		return danhSachCoQuan;
	}

	@Override
	public DanhSachCoQuan updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan, boolean merge)
		throws SystemException {
		danhSachCoQuan = toUnwrappedModel(danhSachCoQuan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhSachCoQuan, merge);

			danhSachCoQuan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachCoQuanImpl.class, danhSachCoQuan.getPrimaryKey(),
			danhSachCoQuan);

		return danhSachCoQuan;
	}

	protected DanhSachCoQuan toUnwrappedModel(DanhSachCoQuan danhSachCoQuan) {
		if (danhSachCoQuan instanceof DanhSachCoQuanImpl) {
			return danhSachCoQuan;
		}

		DanhSachCoQuanImpl danhSachCoQuanImpl = new DanhSachCoQuanImpl();

		danhSachCoQuanImpl.setNew(danhSachCoQuan.isNew());
		danhSachCoQuanImpl.setPrimaryKey(danhSachCoQuan.getPrimaryKey());

		danhSachCoQuanImpl.setId(danhSachCoQuan.getId());
		danhSachCoQuanImpl.setTen(danhSachCoQuan.getTen());
		danhSachCoQuanImpl.setChaId(danhSachCoQuan.getChaId());
		danhSachCoQuanImpl.setTenCapCoQuanQuanly(danhSachCoQuan.getTenCapCoQuanQuanly());
		danhSachCoQuanImpl.setCapCoQuanQuanLyId(danhSachCoQuan.getCapCoQuanQuanLyId());

		return danhSachCoQuanImpl;
	}

	/**
	 * Returns the danh sach co quan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach co quan
	 * @return the danh sach co quan
	 * @throws com.liferay.portal.NoSuchModelException if a danh sach co quan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachCoQuan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach co quan with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException} if it could not be found.
	 *
	 * @param id the primary key of the danh sach co quan
	 * @return the danh sach co quan
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException if a danh sach co quan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachCoQuan findByPrimaryKey(long id)
		throws NoSuchDanhSachCoQuanException, SystemException {
		DanhSachCoQuan danhSachCoQuan = fetchByPrimaryKey(id);

		if (danhSachCoQuan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDanhSachCoQuanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return danhSachCoQuan;
	}

	/**
	 * Returns the danh sach co quan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach co quan
	 * @return the danh sach co quan, or <code>null</code> if a danh sach co quan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachCoQuan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach co quan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh sach co quan
	 * @return the danh sach co quan, or <code>null</code> if a danh sach co quan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachCoQuan fetchByPrimaryKey(long id) throws SystemException {
		DanhSachCoQuan danhSachCoQuan = (DanhSachCoQuan)EntityCacheUtil.getResult(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachCoQuanImpl.class, id);

		if (danhSachCoQuan == _nullDanhSachCoQuan) {
			return null;
		}

		if (danhSachCoQuan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhSachCoQuan = (DanhSachCoQuan)session.get(DanhSachCoQuanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhSachCoQuan != null) {
					cacheResult(danhSachCoQuan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhSachCoQuanModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachCoQuanImpl.class, id, _nullDanhSachCoQuan);
				}

				closeSession(session);
			}
		}

		return danhSachCoQuan;
	}

	/**
	 * Returns all the danh sach co quans.
	 *
	 * @return the danh sach co quans
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachCoQuan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh sach co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach co quans
	 * @param end the upper bound of the range of danh sach co quans (not inclusive)
	 * @return the range of danh sach co quans
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachCoQuan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh sach co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach co quans
	 * @param end the upper bound of the range of danh sach co quans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh sach co quans
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachCoQuan> findAll(int start, int end,
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

		List<DanhSachCoQuan> list = (List<DanhSachCoQuan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHSACHCOQUAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHSACHCOQUAN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhSachCoQuan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhSachCoQuan>)QueryUtil.list(q,
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
	 * Removes all the danh sach co quans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhSachCoQuan danhSachCoQuan : findAll()) {
			remove(danhSachCoQuan);
		}
	}

	/**
	 * Returns the number of danh sach co quans.
	 *
	 * @return the number of danh sach co quans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHSACHCOQUAN);

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
	 * Initializes the danh sach co quan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.kios.model.DanhSachCoQuan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhSachCoQuan>> listenersList = new ArrayList<ModelListener<DanhSachCoQuan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhSachCoQuan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhSachCoQuanImpl.class.getName());
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
	private static final String _SQL_SELECT_DANHSACHCOQUAN = "SELECT danhSachCoQuan FROM DanhSachCoQuan danhSachCoQuan";
	private static final String _SQL_COUNT_DANHSACHCOQUAN = "SELECT COUNT(danhSachCoQuan) FROM DanhSachCoQuan danhSachCoQuan";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhSachCoQuan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhSachCoQuan exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhSachCoQuanPersistenceImpl.class);
	private static DanhSachCoQuan _nullDanhSachCoQuan = new DanhSachCoQuanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhSachCoQuan> toCacheModel() {
				return _nullDanhSachCoQuanCacheModel;
			}
		};

	private static CacheModel<DanhSachCoQuan> _nullDanhSachCoQuanCacheModel = new CacheModel<DanhSachCoQuan>() {
			public DanhSachCoQuan toEntityModel() {
				return _nullDanhSachCoQuan;
			}
		};
}