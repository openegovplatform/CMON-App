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

package org.oep.cmon.dao.touchscreen.service.persistence;

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

import org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException;
import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong;
import org.oep.cmon.dao.touchscreen.model.impl.TraCuuHoSoTTHCCongImpl;
import org.oep.cmon.dao.touchscreen.model.impl.TraCuuHoSoTTHCCongModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tra cuu ho so t t h c cong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TraCuuHoSoTTHCCongPersistence
 * @see TraCuuHoSoTTHCCongUtil
 * @generated
 */
public class TraCuuHoSoTTHCCongPersistenceImpl extends BasePersistenceImpl<TraCuuHoSoTTHCCong>
	implements TraCuuHoSoTTHCCongPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TraCuuHoSoTTHCCongUtil} to access the tra cuu ho so t t h c cong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TraCuuHoSoTTHCCongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuHoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED,
			TraCuuHoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuHoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED,
			TraCuuHoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuHoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tra cuu ho so t t h c cong in the entity cache if it is enabled.
	 *
	 * @param traCuuHoSoTTHCCong the tra cuu ho so t t h c cong
	 */
	public void cacheResult(TraCuuHoSoTTHCCong traCuuHoSoTTHCCong) {
		EntityCacheUtil.putResult(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuHoSoTTHCCongImpl.class, traCuuHoSoTTHCCong.getPrimaryKey(),
			traCuuHoSoTTHCCong);

		traCuuHoSoTTHCCong.resetOriginalValues();
	}

	/**
	 * Caches the tra cuu ho so t t h c congs in the entity cache if it is enabled.
	 *
	 * @param traCuuHoSoTTHCCongs the tra cuu ho so t t h c congs
	 */
	public void cacheResult(List<TraCuuHoSoTTHCCong> traCuuHoSoTTHCCongs) {
		for (TraCuuHoSoTTHCCong traCuuHoSoTTHCCong : traCuuHoSoTTHCCongs) {
			if (EntityCacheUtil.getResult(
						TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
						TraCuuHoSoTTHCCongImpl.class,
						traCuuHoSoTTHCCong.getPrimaryKey()) == null) {
				cacheResult(traCuuHoSoTTHCCong);
			}
			else {
				traCuuHoSoTTHCCong.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tra cuu ho so t t h c congs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TraCuuHoSoTTHCCongImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TraCuuHoSoTTHCCongImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tra cuu ho so t t h c cong.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TraCuuHoSoTTHCCong traCuuHoSoTTHCCong) {
		EntityCacheUtil.removeResult(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuHoSoTTHCCongImpl.class, traCuuHoSoTTHCCong.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TraCuuHoSoTTHCCong> traCuuHoSoTTHCCongs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TraCuuHoSoTTHCCong traCuuHoSoTTHCCong : traCuuHoSoTTHCCongs) {
			EntityCacheUtil.removeResult(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
				TraCuuHoSoTTHCCongImpl.class, traCuuHoSoTTHCCong.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tra cuu ho so t t h c cong with the primary key. Does not add the tra cuu ho so t t h c cong to the database.
	 *
	 * @param id the primary key for the new tra cuu ho so t t h c cong
	 * @return the new tra cuu ho so t t h c cong
	 */
	public TraCuuHoSoTTHCCong create(long id) {
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong = new TraCuuHoSoTTHCCongImpl();

		traCuuHoSoTTHCCong.setNew(true);
		traCuuHoSoTTHCCong.setPrimaryKey(id);

		return traCuuHoSoTTHCCong;
	}

	/**
	 * Removes the tra cuu ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tra cuu ho so t t h c cong
	 * @return the tra cuu ho so t t h c cong that was removed
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TraCuuHoSoTTHCCong remove(long id)
		throws NoSuchTraCuuHoSoTTHCCongException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tra cuu ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tra cuu ho so t t h c cong
	 * @return the tra cuu ho so t t h c cong that was removed
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TraCuuHoSoTTHCCong remove(Serializable primaryKey)
		throws NoSuchTraCuuHoSoTTHCCongException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TraCuuHoSoTTHCCong traCuuHoSoTTHCCong = (TraCuuHoSoTTHCCong)session.get(TraCuuHoSoTTHCCongImpl.class,
					primaryKey);

			if (traCuuHoSoTTHCCong == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraCuuHoSoTTHCCongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(traCuuHoSoTTHCCong);
		}
		catch (NoSuchTraCuuHoSoTTHCCongException nsee) {
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
	protected TraCuuHoSoTTHCCong removeImpl(
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong) throws SystemException {
		traCuuHoSoTTHCCong = toUnwrappedModel(traCuuHoSoTTHCCong);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, traCuuHoSoTTHCCong);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(traCuuHoSoTTHCCong);

		return traCuuHoSoTTHCCong;
	}

	@Override
	public TraCuuHoSoTTHCCong updateImpl(
		org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong traCuuHoSoTTHCCong,
		boolean merge) throws SystemException {
		traCuuHoSoTTHCCong = toUnwrappedModel(traCuuHoSoTTHCCong);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, traCuuHoSoTTHCCong, merge);

			traCuuHoSoTTHCCong.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuHoSoTTHCCongImpl.class, traCuuHoSoTTHCCong.getPrimaryKey(),
			traCuuHoSoTTHCCong);

		return traCuuHoSoTTHCCong;
	}

	protected TraCuuHoSoTTHCCong toUnwrappedModel(
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong) {
		if (traCuuHoSoTTHCCong instanceof TraCuuHoSoTTHCCongImpl) {
			return traCuuHoSoTTHCCong;
		}

		TraCuuHoSoTTHCCongImpl traCuuHoSoTTHCCongImpl = new TraCuuHoSoTTHCCongImpl();

		traCuuHoSoTTHCCongImpl.setNew(traCuuHoSoTTHCCong.isNew());
		traCuuHoSoTTHCCongImpl.setPrimaryKey(traCuuHoSoTTHCCong.getPrimaryKey());

		traCuuHoSoTTHCCongImpl.setId(traCuuHoSoTTHCCong.getId());
		traCuuHoSoTTHCCongImpl.setNgayNhanHoSo(traCuuHoSoTTHCCong.getNgayNhanHoSo());
		traCuuHoSoTTHCCongImpl.setTenCoQuanTiepNhan(traCuuHoSoTTHCCong.getTenCoQuanTiepNhan());
		traCuuHoSoTTHCCongImpl.setTenThuTucHanhChinh(traCuuHoSoTTHCCong.getTenThuTucHanhChinh());
		traCuuHoSoTTHCCongImpl.setNgayHenTraKetQua(traCuuHoSoTTHCCong.getNgayHenTraKetQua());
		traCuuHoSoTTHCCongImpl.setNgayTraKetQua(traCuuHoSoTTHCCong.getNgayTraKetQua());
		traCuuHoSoTTHCCongImpl.setHoTenNguoiNopHoSo(traCuuHoSoTTHCCong.getHoTenNguoiNopHoSo());
		traCuuHoSoTTHCCongImpl.setDiaChiThuongTruNguoiNop(traCuuHoSoTTHCCong.getDiaChiThuongTruNguoiNop());
		traCuuHoSoTTHCCongImpl.setSoDienThoaiDiDongNguoiNop(traCuuHoSoTTHCCong.getSoDienThoaiDiDongNguoiNop());
		traCuuHoSoTTHCCongImpl.setNgayKetThucXuLy(traCuuHoSoTTHCCong.getNgayKetThucXuLy());
		traCuuHoSoTTHCCongImpl.setLoaiHoSo(traCuuHoSoTTHCCong.getLoaiHoSo());
		traCuuHoSoTTHCCongImpl.setMaSoBienNhan(traCuuHoSoTTHCCong.getMaSoBienNhan());
		traCuuHoSoTTHCCongImpl.setChuSoHuu(traCuuHoSoTTHCCong.getChuSoHuu());
		traCuuHoSoTTHCCongImpl.setLePhi(traCuuHoSoTTHCCong.getLePhi());
		traCuuHoSoTTHCCongImpl.setPhiHoSo(traCuuHoSoTTHCCong.getPhiHoSo());
		traCuuHoSoTTHCCongImpl.setEmailNguoiNop(traCuuHoSoTTHCCong.getEmailNguoiNop());
		traCuuHoSoTTHCCongImpl.setSoDienThoaiCoDinhNguoiNop(traCuuHoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop());
		traCuuHoSoTTHCCongImpl.setNhomThuTucHanhChinhTen(traCuuHoSoTTHCCong.getNhomThuTucHanhChinhTen());
		traCuuHoSoTTHCCongImpl.setTrangThaiHoSoTen(traCuuHoSoTTHCCong.getTrangThaiHoSoTen());

		return traCuuHoSoTTHCCongImpl;
	}

	/**
	 * Returns the tra cuu ho so t t h c cong with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tra cuu ho so t t h c cong
	 * @return the tra cuu ho so t t h c cong
	 * @throws com.liferay.portal.NoSuchModelException if a tra cuu ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TraCuuHoSoTTHCCong findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tra cuu ho so t t h c cong with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException} if it could not be found.
	 *
	 * @param id the primary key of the tra cuu ho so t t h c cong
	 * @return the tra cuu ho so t t h c cong
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TraCuuHoSoTTHCCong findByPrimaryKey(long id)
		throws NoSuchTraCuuHoSoTTHCCongException, SystemException {
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong = fetchByPrimaryKey(id);

		if (traCuuHoSoTTHCCong == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTraCuuHoSoTTHCCongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return traCuuHoSoTTHCCong;
	}

	/**
	 * Returns the tra cuu ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tra cuu ho so t t h c cong
	 * @return the tra cuu ho so t t h c cong, or <code>null</code> if a tra cuu ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TraCuuHoSoTTHCCong fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tra cuu ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tra cuu ho so t t h c cong
	 * @return the tra cuu ho so t t h c cong, or <code>null</code> if a tra cuu ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TraCuuHoSoTTHCCong fetchByPrimaryKey(long id)
		throws SystemException {
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong = (TraCuuHoSoTTHCCong)EntityCacheUtil.getResult(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
				TraCuuHoSoTTHCCongImpl.class, id);

		if (traCuuHoSoTTHCCong == _nullTraCuuHoSoTTHCCong) {
			return null;
		}

		if (traCuuHoSoTTHCCong == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				traCuuHoSoTTHCCong = (TraCuuHoSoTTHCCong)session.get(TraCuuHoSoTTHCCongImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (traCuuHoSoTTHCCong != null) {
					cacheResult(traCuuHoSoTTHCCong);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TraCuuHoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
						TraCuuHoSoTTHCCongImpl.class, id,
						_nullTraCuuHoSoTTHCCong);
				}

				closeSession(session);
			}
		}

		return traCuuHoSoTTHCCong;
	}

	/**
	 * Returns all the tra cuu ho so t t h c congs.
	 *
	 * @return the tra cuu ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TraCuuHoSoTTHCCong> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tra cuu ho so t t h c congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tra cuu ho so t t h c congs
	 * @param end the upper bound of the range of tra cuu ho so t t h c congs (not inclusive)
	 * @return the range of tra cuu ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TraCuuHoSoTTHCCong> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tra cuu ho so t t h c congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tra cuu ho so t t h c congs
	 * @param end the upper bound of the range of tra cuu ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tra cuu ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TraCuuHoSoTTHCCong> findAll(int start, int end,
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

		List<TraCuuHoSoTTHCCong> list = (List<TraCuuHoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRACUUHOSOTTHCCONG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACUUHOSOTTHCCONG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TraCuuHoSoTTHCCong>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TraCuuHoSoTTHCCong>)QueryUtil.list(q,
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
	 * Removes all the tra cuu ho so t t h c congs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TraCuuHoSoTTHCCong traCuuHoSoTTHCCong : findAll()) {
			remove(traCuuHoSoTTHCCong);
		}
	}

	/**
	 * Returns the number of tra cuu ho so t t h c congs.
	 *
	 * @return the number of tra cuu ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRACUUHOSOTTHCCONG);

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
	 * Initializes the tra cuu ho so t t h c cong persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TraCuuHoSoTTHCCong>> listenersList = new ArrayList<ModelListener<TraCuuHoSoTTHCCong>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TraCuuHoSoTTHCCong>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TraCuuHoSoTTHCCongImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TouchScreenPersistence.class)
	protected TouchScreenPersistence touchScreenPersistence;
	@BeanReference(type = TraCuuHoSoTTHCCongPersistence.class)
	protected TraCuuHoSoTTHCCongPersistence traCuuHoSoTTHCCongPersistence;
	@BeanReference(type = TraCuuThuTucHanhChinhPersistence.class)
	protected TraCuuThuTucHanhChinhPersistence traCuuThuTucHanhChinhPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TRACUUHOSOTTHCCONG = "SELECT traCuuHoSoTTHCCong FROM TraCuuHoSoTTHCCong traCuuHoSoTTHCCong";
	private static final String _SQL_COUNT_TRACUUHOSOTTHCCONG = "SELECT COUNT(traCuuHoSoTTHCCong) FROM TraCuuHoSoTTHCCong traCuuHoSoTTHCCong";
	private static final String _ORDER_BY_ENTITY_ALIAS = "traCuuHoSoTTHCCong.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TraCuuHoSoTTHCCong exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TraCuuHoSoTTHCCongPersistenceImpl.class);
	private static TraCuuHoSoTTHCCong _nullTraCuuHoSoTTHCCong = new TraCuuHoSoTTHCCongImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TraCuuHoSoTTHCCong> toCacheModel() {
				return _nullTraCuuHoSoTTHCCongCacheModel;
			}
		};

	private static CacheModel<TraCuuHoSoTTHCCong> _nullTraCuuHoSoTTHCCongCacheModel =
		new CacheModel<TraCuuHoSoTTHCCong>() {
			public TraCuuHoSoTTHCCong toEntityModel() {
				return _nullTraCuuHoSoTTHCCong;
			}
		};
}