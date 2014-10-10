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

package org.oep.cmon.dao.cd.service.persistence;

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

import org.oep.cmon.dao.cd.NoSuchChuyenMonException;
import org.oep.cmon.dao.cd.model.ChuyenMon;
import org.oep.cmon.dao.cd.model.impl.ChuyenMonImpl;
import org.oep.cmon.dao.cd.model.impl.ChuyenMonModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the chuyen mon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ChuyenMonPersistence
 * @see ChuyenMonUtil
 * @generated
 */
public class ChuyenMonPersistenceImpl extends BasePersistenceImpl<ChuyenMon>
	implements ChuyenMonPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChuyenMonUtil} to access the chuyen mon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChuyenMonImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			ChuyenMonModelImpl.FINDER_CACHE_ENABLED, ChuyenMonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			ChuyenMonModelImpl.FINDER_CACHE_ENABLED, ChuyenMonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			ChuyenMonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the chuyen mon in the entity cache if it is enabled.
	 *
	 * @param chuyenMon the chuyen mon
	 */
	public void cacheResult(ChuyenMon chuyenMon) {
		EntityCacheUtil.putResult(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			ChuyenMonImpl.class, chuyenMon.getPrimaryKey(), chuyenMon);

		chuyenMon.resetOriginalValues();
	}

	/**
	 * Caches the chuyen mons in the entity cache if it is enabled.
	 *
	 * @param chuyenMons the chuyen mons
	 */
	public void cacheResult(List<ChuyenMon> chuyenMons) {
		for (ChuyenMon chuyenMon : chuyenMons) {
			if (EntityCacheUtil.getResult(
						ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
						ChuyenMonImpl.class, chuyenMon.getPrimaryKey()) == null) {
				cacheResult(chuyenMon);
			}
			else {
				chuyenMon.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chuyen mons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChuyenMonImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChuyenMonImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chuyen mon.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChuyenMon chuyenMon) {
		EntityCacheUtil.removeResult(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			ChuyenMonImpl.class, chuyenMon.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChuyenMon> chuyenMons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChuyenMon chuyenMon : chuyenMons) {
			EntityCacheUtil.removeResult(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
				ChuyenMonImpl.class, chuyenMon.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chuyen mon with the primary key. Does not add the chuyen mon to the database.
	 *
	 * @param id the primary key for the new chuyen mon
	 * @return the new chuyen mon
	 */
	public ChuyenMon create(long id) {
		ChuyenMon chuyenMon = new ChuyenMonImpl();

		chuyenMon.setNew(true);
		chuyenMon.setPrimaryKey(id);

		return chuyenMon;
	}

	/**
	 * Removes the chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chuyen mon
	 * @return the chuyen mon that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchChuyenMonException if a chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChuyenMon remove(long id)
		throws NoSuchChuyenMonException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chuyen mon
	 * @return the chuyen mon that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchChuyenMonException if a chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChuyenMon remove(Serializable primaryKey)
		throws NoSuchChuyenMonException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChuyenMon chuyenMon = (ChuyenMon)session.get(ChuyenMonImpl.class,
					primaryKey);

			if (chuyenMon == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChuyenMonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chuyenMon);
		}
		catch (NoSuchChuyenMonException nsee) {
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
	protected ChuyenMon removeImpl(ChuyenMon chuyenMon)
		throws SystemException {
		chuyenMon = toUnwrappedModel(chuyenMon);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, chuyenMon);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(chuyenMon);

		return chuyenMon;
	}

	@Override
	public ChuyenMon updateImpl(org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon,
		boolean merge) throws SystemException {
		chuyenMon = toUnwrappedModel(chuyenMon);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, chuyenMon, merge);

			chuyenMon.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
			ChuyenMonImpl.class, chuyenMon.getPrimaryKey(), chuyenMon);

		return chuyenMon;
	}

	protected ChuyenMon toUnwrappedModel(ChuyenMon chuyenMon) {
		if (chuyenMon instanceof ChuyenMonImpl) {
			return chuyenMon;
		}

		ChuyenMonImpl chuyenMonImpl = new ChuyenMonImpl();

		chuyenMonImpl.setNew(chuyenMon.isNew());
		chuyenMonImpl.setPrimaryKey(chuyenMon.getPrimaryKey());

		chuyenMonImpl.setId(chuyenMon.getId());
		chuyenMonImpl.setMa(chuyenMon.getMa());
		chuyenMonImpl.setTen(chuyenMon.getTen());
		chuyenMonImpl.setPhienban(chuyenMon.getPhienban());
		chuyenMonImpl.setNgaytao(chuyenMon.getNgaytao());
		chuyenMonImpl.setNguoitao(chuyenMon.getNguoitao());
		chuyenMonImpl.setNgaysua(chuyenMon.getNgaysua());
		chuyenMonImpl.setNguoisua(chuyenMon.getNguoisua());
		chuyenMonImpl.setDaxoa(chuyenMon.getDaxoa());

		return chuyenMonImpl;
	}

	/**
	 * Returns the chuyen mon with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chuyen mon
	 * @return the chuyen mon
	 * @throws com.liferay.portal.NoSuchModelException if a chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChuyenMon findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chuyen mon with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchChuyenMonException} if it could not be found.
	 *
	 * @param id the primary key of the chuyen mon
	 * @return the chuyen mon
	 * @throws org.oep.cmon.dao.cd.NoSuchChuyenMonException if a chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChuyenMon findByPrimaryKey(long id)
		throws NoSuchChuyenMonException, SystemException {
		ChuyenMon chuyenMon = fetchByPrimaryKey(id);

		if (chuyenMon == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchChuyenMonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return chuyenMon;
	}

	/**
	 * Returns the chuyen mon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chuyen mon
	 * @return the chuyen mon, or <code>null</code> if a chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChuyenMon fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the chuyen mon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chuyen mon
	 * @return the chuyen mon, or <code>null</code> if a chuyen mon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChuyenMon fetchByPrimaryKey(long id) throws SystemException {
		ChuyenMon chuyenMon = (ChuyenMon)EntityCacheUtil.getResult(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
				ChuyenMonImpl.class, id);

		if (chuyenMon == _nullChuyenMon) {
			return null;
		}

		if (chuyenMon == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				chuyenMon = (ChuyenMon)session.get(ChuyenMonImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (chuyenMon != null) {
					cacheResult(chuyenMon);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ChuyenMonModelImpl.ENTITY_CACHE_ENABLED,
						ChuyenMonImpl.class, id, _nullChuyenMon);
				}

				closeSession(session);
			}
		}

		return chuyenMon;
	}

	/**
	 * Returns all the chuyen mons.
	 *
	 * @return the chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChuyenMon> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chuyen mons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chuyen mons
	 * @param end the upper bound of the range of chuyen mons (not inclusive)
	 * @return the range of chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChuyenMon> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chuyen mons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of chuyen mons
	 * @param end the upper bound of the range of chuyen mons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChuyenMon> findAll(int start, int end,
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

		List<ChuyenMon> list = (List<ChuyenMon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHUYENMON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHUYENMON.concat(ChuyenMonModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ChuyenMon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ChuyenMon>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the chuyen mons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ChuyenMon chuyenMon : findAll()) {
			remove(chuyenMon);
		}
	}

	/**
	 * Returns the number of chuyen mons.
	 *
	 * @return the number of chuyen mons
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHUYENMON);

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
	 * Initializes the chuyen mon persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.ChuyenMon")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChuyenMon>> listenersList = new ArrayList<ModelListener<ChuyenMon>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChuyenMon>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChuyenMonImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChuyenMonPersistence.class)
	protected ChuyenMonPersistence chuyenMonPersistence;
	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = HeThongPersistence.class)
	protected HeThongPersistence heThongPersistence;
	@BeanReference(type = HoChieuCMNDPersistence.class)
	protected HoChieuCMNDPersistence hoChieuCMNDPersistence;
	@BeanReference(type = NgheNghiepPersistence.class)
	protected NgheNghiepPersistence ngheNghiepPersistence;
	@BeanReference(type = QuanHeGiaDinhPersistence.class)
	protected QuanHeGiaDinhPersistence quanHeGiaDinhPersistence;
	@BeanReference(type = TinhTrangHonNhanPersistence.class)
	protected TinhTrangHonNhanPersistence tinhTrangHonNhanPersistence;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = TrinhDoChuyenMonPersistence.class)
	protected TrinhDoChuyenMonPersistence trinhDoChuyenMonPersistence;
	@BeanReference(type = TrinhDoHocVanPersistence.class)
	protected TrinhDoHocVanPersistence trinhDoHocVanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CHUYENMON = "SELECT chuyenMon FROM ChuyenMon chuyenMon";
	private static final String _SQL_COUNT_CHUYENMON = "SELECT COUNT(chuyenMon) FROM ChuyenMon chuyenMon";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chuyenMon.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChuyenMon exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChuyenMonPersistenceImpl.class);
	private static ChuyenMon _nullChuyenMon = new ChuyenMonImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChuyenMon> toCacheModel() {
				return _nullChuyenMonCacheModel;
			}
		};

	private static CacheModel<ChuyenMon> _nullChuyenMonCacheModel = new CacheModel<ChuyenMon>() {
			public ChuyenMon toEntityModel() {
				return _nullChuyenMon;
			}
		};
}