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

import org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.DonViGtvtImpl;
import org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl.DonViGtvtModelImpl;

/**
 * The persistence implementation for the don vi gtvt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see DonViGtvtPersistence
 * @see DonViGtvtUtil
 * @generated
 */
public class DonViGtvtPersistenceImpl extends BasePersistenceImpl<DonViGtvt>
	implements DonViGtvtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DonViGtvtUtil} to access the don vi gtvt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DonViGtvtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
			DonViGtvtModelImpl.FINDER_CACHE_ENABLED, DonViGtvtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
			DonViGtvtModelImpl.FINDER_CACHE_ENABLED, DonViGtvtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
			DonViGtvtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the don vi gtvt in the entity cache if it is enabled.
	 *
	 * @param donViGtvt the don vi gtvt
	 */
	public void cacheResult(DonViGtvt donViGtvt) {
		EntityCacheUtil.putResult(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
			DonViGtvtImpl.class, donViGtvt.getPrimaryKey(), donViGtvt);

		donViGtvt.resetOriginalValues();
	}

	/**
	 * Caches the don vi gtvts in the entity cache if it is enabled.
	 *
	 * @param donViGtvts the don vi gtvts
	 */
	public void cacheResult(List<DonViGtvt> donViGtvts) {
		for (DonViGtvt donViGtvt : donViGtvts) {
			if (EntityCacheUtil.getResult(
						DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
						DonViGtvtImpl.class, donViGtvt.getPrimaryKey()) == null) {
				cacheResult(donViGtvt);
			}
			else {
				donViGtvt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all don vi gtvts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DonViGtvtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DonViGtvtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the don vi gtvt.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DonViGtvt donViGtvt) {
		EntityCacheUtil.removeResult(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
			DonViGtvtImpl.class, donViGtvt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DonViGtvt> donViGtvts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DonViGtvt donViGtvt : donViGtvts) {
			EntityCacheUtil.removeResult(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
				DonViGtvtImpl.class, donViGtvt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new don vi gtvt with the primary key. Does not add the don vi gtvt to the database.
	 *
	 * @param id the primary key for the new don vi gtvt
	 * @return the new don vi gtvt
	 */
	public DonViGtvt create(long id) {
		DonViGtvt donViGtvt = new DonViGtvtImpl();

		donViGtvt.setNew(true);
		donViGtvt.setPrimaryKey(id);

		return donViGtvt;
	}

	/**
	 * Removes the don vi gtvt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the don vi gtvt
	 * @return the don vi gtvt that was removed
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViGtvt remove(long id)
		throws NoSuchDonViGtvtException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the don vi gtvt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the don vi gtvt
	 * @return the don vi gtvt that was removed
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DonViGtvt remove(Serializable primaryKey)
		throws NoSuchDonViGtvtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DonViGtvt donViGtvt = (DonViGtvt)session.get(DonViGtvtImpl.class,
					primaryKey);

			if (donViGtvt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDonViGtvtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(donViGtvt);
		}
		catch (NoSuchDonViGtvtException nsee) {
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
	protected DonViGtvt removeImpl(DonViGtvt donViGtvt)
		throws SystemException {
		donViGtvt = toUnwrappedModel(donViGtvt);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, donViGtvt);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(donViGtvt);

		return donViGtvt;
	}

	@Override
	public DonViGtvt updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt,
		boolean merge) throws SystemException {
		donViGtvt = toUnwrappedModel(donViGtvt);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, donViGtvt, merge);

			donViGtvt.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
			DonViGtvtImpl.class, donViGtvt.getPrimaryKey(), donViGtvt);

		return donViGtvt;
	}

	protected DonViGtvt toUnwrappedModel(DonViGtvt donViGtvt) {
		if (donViGtvt instanceof DonViGtvtImpl) {
			return donViGtvt;
		}

		DonViGtvtImpl donViGtvtImpl = new DonViGtvtImpl();

		donViGtvtImpl.setNew(donViGtvt.isNew());
		donViGtvtImpl.setPrimaryKey(donViGtvt.getPrimaryKey());

		donViGtvtImpl.setId(donViGtvt.getId());
		donViGtvtImpl.setMa(donViGtvt.getMa());
		donViGtvtImpl.setTen(donViGtvt.getTen());
		donViGtvtImpl.setCoQuanQl(donViGtvt.getCoQuanQl());
		donViGtvtImpl.setDienThoai(donViGtvt.getDienThoai());
		donViGtvtImpl.setFax(donViGtvt.getFax());
		donViGtvtImpl.setDiaChi(donViGtvt.getDiaChi());
		donViGtvtImpl.setLanhDao(donViGtvt.getLanhDao());
		donViGtvtImpl.setNgayTao(donViGtvt.getNgayTao());
		donViGtvtImpl.setNgaySua(donViGtvt.getNgaySua());
		donViGtvtImpl.setNguoiTao(donViGtvt.getNguoiTao());
		donViGtvtImpl.setNguoiSua(donViGtvt.getNguoiSua());
		donViGtvtImpl.setXoa(donViGtvt.getXoa());

		return donViGtvtImpl;
	}

	/**
	 * Returns the don vi gtvt with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the don vi gtvt
	 * @return the don vi gtvt
	 * @throws com.liferay.portal.NoSuchModelException if a don vi gtvt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DonViGtvt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the don vi gtvt with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException} if it could not be found.
	 *
	 * @param id the primary key of the don vi gtvt
	 * @return the don vi gtvt
	 * @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViGtvt findByPrimaryKey(long id)
		throws NoSuchDonViGtvtException, SystemException {
		DonViGtvt donViGtvt = fetchByPrimaryKey(id);

		if (donViGtvt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDonViGtvtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return donViGtvt;
	}

	/**
	 * Returns the don vi gtvt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the don vi gtvt
	 * @return the don vi gtvt, or <code>null</code> if a don vi gtvt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DonViGtvt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the don vi gtvt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the don vi gtvt
	 * @return the don vi gtvt, or <code>null</code> if a don vi gtvt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DonViGtvt fetchByPrimaryKey(long id) throws SystemException {
		DonViGtvt donViGtvt = (DonViGtvt)EntityCacheUtil.getResult(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
				DonViGtvtImpl.class, id);

		if (donViGtvt == _nullDonViGtvt) {
			return null;
		}

		if (donViGtvt == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				donViGtvt = (DonViGtvt)session.get(DonViGtvtImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (donViGtvt != null) {
					cacheResult(donViGtvt);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DonViGtvtModelImpl.ENTITY_CACHE_ENABLED,
						DonViGtvtImpl.class, id, _nullDonViGtvt);
				}

				closeSession(session);
			}
		}

		return donViGtvt;
	}

	/**
	 * Returns all the don vi gtvts.
	 *
	 * @return the don vi gtvts
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViGtvt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the don vi gtvts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of don vi gtvts
	 * @param end the upper bound of the range of don vi gtvts (not inclusive)
	 * @return the range of don vi gtvts
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViGtvt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the don vi gtvts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of don vi gtvts
	 * @param end the upper bound of the range of don vi gtvts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of don vi gtvts
	 * @throws SystemException if a system exception occurred
	 */
	public List<DonViGtvt> findAll(int start, int end,
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

		List<DonViGtvt> list = (List<DonViGtvt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DONVIGTVT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DONVIGTVT.concat(DonViGtvtModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DonViGtvt>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DonViGtvt>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the don vi gtvts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DonViGtvt donViGtvt : findAll()) {
			remove(donViGtvt);
		}
	}

	/**
	 * Returns the number of don vi gtvts.
	 *
	 * @return the number of don vi gtvts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DONVIGTVT);

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
	 * Initializes the don vi gtvt persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DonViGtvt>> listenersList = new ArrayList<ModelListener<DonViGtvt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DonViGtvt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DonViGtvtImpl.class.getName());
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
	private static final String _SQL_SELECT_DONVIGTVT = "SELECT donViGtvt FROM DonViGtvt donViGtvt";
	private static final String _SQL_COUNT_DONVIGTVT = "SELECT COUNT(donViGtvt) FROM DonViGtvt donViGtvt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "donViGtvt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DonViGtvt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DonViGtvtPersistenceImpl.class);
	private static DonViGtvt _nullDonViGtvt = new DonViGtvtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DonViGtvt> toCacheModel() {
				return _nullDonViGtvtCacheModel;
			}
		};

	private static CacheModel<DonViGtvt> _nullDonViGtvtCacheModel = new CacheModel<DonViGtvt>() {
			public DonViGtvt toEntityModel() {
				return _nullDonViGtvt;
			}
		};
}