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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service.persistence;

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


import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.HangGiayPhepLaiXeImpl;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.HangGiayPhepLaiXeModelImpl;

/**
 * The persistence implementation for the hang giay phep lai xe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see HangGiayPhepLaiXePersistence
 * @see HangGiayPhepLaiXeUtil
 * @generated
 */
public class HangGiayPhepLaiXePersistenceImpl extends BasePersistenceImpl<HangGiayPhepLaiXe>
	implements HangGiayPhepLaiXePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HangGiayPhepLaiXeUtil} to access the hang giay phep lai xe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HangGiayPhepLaiXeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			HangGiayPhepLaiXeModelImpl.FINDER_CACHE_ENABLED,
			HangGiayPhepLaiXeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			HangGiayPhepLaiXeModelImpl.FINDER_CACHE_ENABLED,
			HangGiayPhepLaiXeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			HangGiayPhepLaiXeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the hang giay phep lai xe in the entity cache if it is enabled.
	 *
	 * @param hangGiayPhepLaiXe the hang giay phep lai xe
	 */
	public void cacheResult(HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		EntityCacheUtil.putResult(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			HangGiayPhepLaiXeImpl.class, hangGiayPhepLaiXe.getPrimaryKey(),
			hangGiayPhepLaiXe);

		hangGiayPhepLaiXe.resetOriginalValues();
	}

	/**
	 * Caches the hang giay phep lai xes in the entity cache if it is enabled.
	 *
	 * @param hangGiayPhepLaiXes the hang giay phep lai xes
	 */
	public void cacheResult(List<HangGiayPhepLaiXe> hangGiayPhepLaiXes) {
		for (HangGiayPhepLaiXe hangGiayPhepLaiXe : hangGiayPhepLaiXes) {
			if (EntityCacheUtil.getResult(
						HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
						HangGiayPhepLaiXeImpl.class,
						hangGiayPhepLaiXe.getPrimaryKey()) == null) {
				cacheResult(hangGiayPhepLaiXe);
			}
			else {
				hangGiayPhepLaiXe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hang giay phep lai xes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HangGiayPhepLaiXeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HangGiayPhepLaiXeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hang giay phep lai xe.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		EntityCacheUtil.removeResult(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			HangGiayPhepLaiXeImpl.class, hangGiayPhepLaiXe.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HangGiayPhepLaiXe> hangGiayPhepLaiXes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HangGiayPhepLaiXe hangGiayPhepLaiXe : hangGiayPhepLaiXes) {
			EntityCacheUtil.removeResult(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
				HangGiayPhepLaiXeImpl.class, hangGiayPhepLaiXe.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hang giay phep lai xe with the primary key. Does not add the hang giay phep lai xe to the database.
	 *
	 * @param id the primary key for the new hang giay phep lai xe
	 * @return the new hang giay phep lai xe
	 */
	public HangGiayPhepLaiXe create(long id) {
		HangGiayPhepLaiXe hangGiayPhepLaiXe = new HangGiayPhepLaiXeImpl();

		hangGiayPhepLaiXe.setNew(true);
		hangGiayPhepLaiXe.setPrimaryKey(id);

		return hangGiayPhepLaiXe;
	}

	/**
	 * Removes the hang giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hang giay phep lai xe
	 * @return the hang giay phep lai xe that was removed
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException if a hang giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HangGiayPhepLaiXe remove(long id)
		throws NoSuchHangGiayPhepLaiXeException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the hang giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hang giay phep lai xe
	 * @return the hang giay phep lai xe that was removed
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException if a hang giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangGiayPhepLaiXe remove(Serializable primaryKey)
		throws NoSuchHangGiayPhepLaiXeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HangGiayPhepLaiXe hangGiayPhepLaiXe = (HangGiayPhepLaiXe)session.get(HangGiayPhepLaiXeImpl.class,
					primaryKey);

			if (hangGiayPhepLaiXe == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHangGiayPhepLaiXeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hangGiayPhepLaiXe);
		}
		catch (NoSuchHangGiayPhepLaiXeException nsee) {
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
	protected HangGiayPhepLaiXe removeImpl(HangGiayPhepLaiXe hangGiayPhepLaiXe)
		throws SystemException {
		hangGiayPhepLaiXe = toUnwrappedModel(hangGiayPhepLaiXe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hangGiayPhepLaiXe);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hangGiayPhepLaiXe);

		return hangGiayPhepLaiXe;
	}

	@Override
	public HangGiayPhepLaiXe updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe,
		boolean merge) throws SystemException {
		hangGiayPhepLaiXe = toUnwrappedModel(hangGiayPhepLaiXe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hangGiayPhepLaiXe, merge);

			hangGiayPhepLaiXe.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			HangGiayPhepLaiXeImpl.class, hangGiayPhepLaiXe.getPrimaryKey(),
			hangGiayPhepLaiXe);

		return hangGiayPhepLaiXe;
	}

	protected HangGiayPhepLaiXe toUnwrappedModel(
		HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		if (hangGiayPhepLaiXe instanceof HangGiayPhepLaiXeImpl) {
			return hangGiayPhepLaiXe;
		}

		HangGiayPhepLaiXeImpl hangGiayPhepLaiXeImpl = new HangGiayPhepLaiXeImpl();

		hangGiayPhepLaiXeImpl.setNew(hangGiayPhepLaiXe.isNew());
		hangGiayPhepLaiXeImpl.setPrimaryKey(hangGiayPhepLaiXe.getPrimaryKey());

		hangGiayPhepLaiXeImpl.setId(hangGiayPhepLaiXe.getId());
		hangGiayPhepLaiXeImpl.setTenHang(hangGiayPhepLaiXe.getTenHang());
		hangGiayPhepLaiXeImpl.setNgayTao(hangGiayPhepLaiXe.getNgayTao());
		hangGiayPhepLaiXeImpl.setNgaySua(hangGiayPhepLaiXe.getNgaySua());
		hangGiayPhepLaiXeImpl.setNguoiTao(hangGiayPhepLaiXe.getNguoiTao());
		hangGiayPhepLaiXeImpl.setNguoiSua(hangGiayPhepLaiXe.getNguoiSua());
		hangGiayPhepLaiXeImpl.setXoa(hangGiayPhepLaiXe.getXoa());
		hangGiayPhepLaiXeImpl.setMa(hangGiayPhepLaiXe.getMa());

		return hangGiayPhepLaiXeImpl;
	}

	/**
	 * Returns the hang giay phep lai xe with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hang giay phep lai xe
	 * @return the hang giay phep lai xe
	 * @throws com.liferay.portal.NoSuchModelException if a hang giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangGiayPhepLaiXe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the hang giay phep lai xe with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException} if it could not be found.
	 *
	 * @param id the primary key of the hang giay phep lai xe
	 * @return the hang giay phep lai xe
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException if a hang giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HangGiayPhepLaiXe findByPrimaryKey(long id)
		throws NoSuchHangGiayPhepLaiXeException, SystemException {
		HangGiayPhepLaiXe hangGiayPhepLaiXe = fetchByPrimaryKey(id);

		if (hangGiayPhepLaiXe == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHangGiayPhepLaiXeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hangGiayPhepLaiXe;
	}

	/**
	 * Returns the hang giay phep lai xe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hang giay phep lai xe
	 * @return the hang giay phep lai xe, or <code>null</code> if a hang giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HangGiayPhepLaiXe fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the hang giay phep lai xe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hang giay phep lai xe
	 * @return the hang giay phep lai xe, or <code>null</code> if a hang giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HangGiayPhepLaiXe fetchByPrimaryKey(long id)
		throws SystemException {
		HangGiayPhepLaiXe hangGiayPhepLaiXe = (HangGiayPhepLaiXe)EntityCacheUtil.getResult(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
				HangGiayPhepLaiXeImpl.class, id);

		if (hangGiayPhepLaiXe == _nullHangGiayPhepLaiXe) {
			return null;
		}

		if (hangGiayPhepLaiXe == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hangGiayPhepLaiXe = (HangGiayPhepLaiXe)session.get(HangGiayPhepLaiXeImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hangGiayPhepLaiXe != null) {
					cacheResult(hangGiayPhepLaiXe);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HangGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
						HangGiayPhepLaiXeImpl.class, id, _nullHangGiayPhepLaiXe);
				}

				closeSession(session);
			}
		}

		return hangGiayPhepLaiXe;
	}

	/**
	 * Returns all the hang giay phep lai xes.
	 *
	 * @return the hang giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public List<HangGiayPhepLaiXe> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hang giay phep lai xes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of hang giay phep lai xes
	 * @param end the upper bound of the range of hang giay phep lai xes (not inclusive)
	 * @return the range of hang giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public List<HangGiayPhepLaiXe> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hang giay phep lai xes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of hang giay phep lai xes
	 * @param end the upper bound of the range of hang giay phep lai xes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hang giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public List<HangGiayPhepLaiXe> findAll(int start, int end,
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

		List<HangGiayPhepLaiXe> list = (List<HangGiayPhepLaiXe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HANGGIAYPHEPLAIXE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HANGGIAYPHEPLAIXE.concat(HangGiayPhepLaiXeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HangGiayPhepLaiXe>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HangGiayPhepLaiXe>)QueryUtil.list(q,
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
	 * Removes all the hang giay phep lai xes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HangGiayPhepLaiXe hangGiayPhepLaiXe : findAll()) {
			remove(hangGiayPhepLaiXe);
		}
	}

	/**
	 * Returns the number of hang giay phep lai xes.
	 *
	 * @return the number of hang giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HANGGIAYPHEPLAIXE);

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
	 * Initializes the hang giay phep lai xe persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HangGiayPhepLaiXe>> listenersList = new ArrayList<ModelListener<HangGiayPhepLaiXe>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HangGiayPhepLaiXe>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HangGiayPhepLaiXeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DonViGtvtPersistence.class)
	protected DonViGtvtPersistence donViGtvtPersistence;
	@BeanReference(type = HangGiayPhepLaiXePersistence.class)
	protected HangGiayPhepLaiXePersistence hangGiayPhepLaiXePersistence;
	@BeanReference(type = LyDoCapDoiCapLaiGPLXPersistence.class)
	protected LyDoCapDoiCapLaiGPLXPersistence lyDoCapDoiCapLaiGPLXPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HANGGIAYPHEPLAIXE = "SELECT hangGiayPhepLaiXe FROM HangGiayPhepLaiXe hangGiayPhepLaiXe";
	private static final String _SQL_COUNT_HANGGIAYPHEPLAIXE = "SELECT COUNT(hangGiayPhepLaiXe) FROM HangGiayPhepLaiXe hangGiayPhepLaiXe";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hangGiayPhepLaiXe.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HangGiayPhepLaiXe exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HangGiayPhepLaiXePersistenceImpl.class);
	private static HangGiayPhepLaiXe _nullHangGiayPhepLaiXe = new HangGiayPhepLaiXeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HangGiayPhepLaiXe> toCacheModel() {
				return _nullHangGiayPhepLaiXeCacheModel;
			}
		};

	private static CacheModel<HangGiayPhepLaiXe> _nullHangGiayPhepLaiXeCacheModel =
		new CacheModel<HangGiayPhepLaiXe>() {
			public HangGiayPhepLaiXe toEntityModel() {
				return _nullHangGiayPhepLaiXe;
			}
		};
}