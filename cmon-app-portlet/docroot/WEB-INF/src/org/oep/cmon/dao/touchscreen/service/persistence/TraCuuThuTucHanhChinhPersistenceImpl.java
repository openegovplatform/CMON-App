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

import org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException;
import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh;
import org.oep.cmon.dao.touchscreen.model.impl.TraCuuThuTucHanhChinhImpl;
import org.oep.cmon.dao.touchscreen.model.impl.TraCuuThuTucHanhChinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tra cuu thu tuc hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TraCuuThuTucHanhChinhPersistence
 * @see TraCuuThuTucHanhChinhUtil
 * @generated
 */
public class TraCuuThuTucHanhChinhPersistenceImpl extends BasePersistenceImpl<TraCuuThuTucHanhChinh>
	implements TraCuuThuTucHanhChinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TraCuuThuTucHanhChinhUtil} to access the tra cuu thu tuc hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TraCuuThuTucHanhChinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			TraCuuThuTucHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			TraCuuThuTucHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tra cuu thu tuc hanh chinh in the entity cache if it is enabled.
	 *
	 * @param traCuuThuTucHanhChinh the tra cuu thu tuc hanh chinh
	 */
	public void cacheResult(TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) {
		EntityCacheUtil.putResult(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuThuTucHanhChinhImpl.class,
			traCuuThuTucHanhChinh.getPrimaryKey(), traCuuThuTucHanhChinh);

		traCuuThuTucHanhChinh.resetOriginalValues();
	}

	/**
	 * Caches the tra cuu thu tuc hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param traCuuThuTucHanhChinhs the tra cuu thu tuc hanh chinhs
	 */
	public void cacheResult(List<TraCuuThuTucHanhChinh> traCuuThuTucHanhChinhs) {
		for (TraCuuThuTucHanhChinh traCuuThuTucHanhChinh : traCuuThuTucHanhChinhs) {
			if (EntityCacheUtil.getResult(
						TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						TraCuuThuTucHanhChinhImpl.class,
						traCuuThuTucHanhChinh.getPrimaryKey()) == null) {
				cacheResult(traCuuThuTucHanhChinh);
			}
			else {
				traCuuThuTucHanhChinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tra cuu thu tuc hanh chinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TraCuuThuTucHanhChinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TraCuuThuTucHanhChinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tra cuu thu tuc hanh chinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) {
		EntityCacheUtil.removeResult(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuThuTucHanhChinhImpl.class,
			traCuuThuTucHanhChinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TraCuuThuTucHanhChinh> traCuuThuTucHanhChinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TraCuuThuTucHanhChinh traCuuThuTucHanhChinh : traCuuThuTucHanhChinhs) {
			EntityCacheUtil.removeResult(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				TraCuuThuTucHanhChinhImpl.class,
				traCuuThuTucHanhChinh.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tra cuu thu tuc hanh chinh with the primary key. Does not add the tra cuu thu tuc hanh chinh to the database.
	 *
	 * @param id the primary key for the new tra cuu thu tuc hanh chinh
	 * @return the new tra cuu thu tuc hanh chinh
	 */
	public TraCuuThuTucHanhChinh create(long id) {
		TraCuuThuTucHanhChinh traCuuThuTucHanhChinh = new TraCuuThuTucHanhChinhImpl();

		traCuuThuTucHanhChinh.setNew(true);
		traCuuThuTucHanhChinh.setPrimaryKey(id);

		return traCuuThuTucHanhChinh;
	}

	/**
	 * Removes the tra cuu thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tra cuu thu tuc hanh chinh
	 * @return the tra cuu thu tuc hanh chinh that was removed
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException if a tra cuu thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TraCuuThuTucHanhChinh remove(long id)
		throws NoSuchTraCuuThuTucHanhChinhException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tra cuu thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tra cuu thu tuc hanh chinh
	 * @return the tra cuu thu tuc hanh chinh that was removed
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException if a tra cuu thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TraCuuThuTucHanhChinh remove(Serializable primaryKey)
		throws NoSuchTraCuuThuTucHanhChinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TraCuuThuTucHanhChinh traCuuThuTucHanhChinh = (TraCuuThuTucHanhChinh)session.get(TraCuuThuTucHanhChinhImpl.class,
					primaryKey);

			if (traCuuThuTucHanhChinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraCuuThuTucHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(traCuuThuTucHanhChinh);
		}
		catch (NoSuchTraCuuThuTucHanhChinhException nsee) {
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
	protected TraCuuThuTucHanhChinh removeImpl(
		TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) throws SystemException {
		traCuuThuTucHanhChinh = toUnwrappedModel(traCuuThuTucHanhChinh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, traCuuThuTucHanhChinh);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(traCuuThuTucHanhChinh);

		return traCuuThuTucHanhChinh;
	}

	@Override
	public TraCuuThuTucHanhChinh updateImpl(
		org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh traCuuThuTucHanhChinh,
		boolean merge) throws SystemException {
		traCuuThuTucHanhChinh = toUnwrappedModel(traCuuThuTucHanhChinh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, traCuuThuTucHanhChinh, merge);

			traCuuThuTucHanhChinh.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TraCuuThuTucHanhChinhImpl.class,
			traCuuThuTucHanhChinh.getPrimaryKey(), traCuuThuTucHanhChinh);

		return traCuuThuTucHanhChinh;
	}

	protected TraCuuThuTucHanhChinh toUnwrappedModel(
		TraCuuThuTucHanhChinh traCuuThuTucHanhChinh) {
		if (traCuuThuTucHanhChinh instanceof TraCuuThuTucHanhChinhImpl) {
			return traCuuThuTucHanhChinh;
		}

		TraCuuThuTucHanhChinhImpl traCuuThuTucHanhChinhImpl = new TraCuuThuTucHanhChinhImpl();

		traCuuThuTucHanhChinhImpl.setNew(traCuuThuTucHanhChinh.isNew());
		traCuuThuTucHanhChinhImpl.setPrimaryKey(traCuuThuTucHanhChinh.getPrimaryKey());

		traCuuThuTucHanhChinhImpl.setId(traCuuThuTucHanhChinh.getId());
		traCuuThuTucHanhChinhImpl.setMa(traCuuThuTucHanhChinh.getMa());
		traCuuThuTucHanhChinhImpl.setTen(traCuuThuTucHanhChinh.getTen());
		traCuuThuTucHanhChinhImpl.setSoNgayXuLy(traCuuThuTucHanhChinh.getSoNgayXuLy());
		traCuuThuTucHanhChinhImpl.setNgayTao(traCuuThuTucHanhChinh.getNgayTao());
		traCuuThuTucHanhChinhImpl.setNgaySua(traCuuThuTucHanhChinh.getNgaySua());
		traCuuThuTucHanhChinhImpl.setDaXoa(traCuuThuTucHanhChinh.getDaXoa());
		traCuuThuTucHanhChinhImpl.setNguoiTao(traCuuThuTucHanhChinh.getNguoiTao());
		traCuuThuTucHanhChinhImpl.setNguoiSua(traCuuThuTucHanhChinh.getNguoiSua());
		traCuuThuTucHanhChinhImpl.setNhomThuTucHanhChinhId(traCuuThuTucHanhChinh.getNhomThuTucHanhChinhId());
		traCuuThuTucHanhChinhImpl.setNhomThuTucHanhChinhTen(traCuuThuTucHanhChinh.getNhomThuTucHanhChinhTen());
		traCuuThuTucHanhChinhImpl.setTrangThai(traCuuThuTucHanhChinh.getTrangThai());
		traCuuThuTucHanhChinhImpl.setPhienBan(traCuuThuTucHanhChinh.getPhienBan());
		traCuuThuTucHanhChinhImpl.setCanTichHop(traCuuThuTucHanhChinh.getCanTichHop());
		traCuuThuTucHanhChinhImpl.setTrinhTuThucHien(traCuuThuTucHanhChinh.getTrinhTuThucHien());
		traCuuThuTucHanhChinhImpl.setCachThucHien(traCuuThuTucHanhChinh.getCachThucHien());
		traCuuThuTucHanhChinhImpl.setThanhPhanHoSo(traCuuThuTucHanhChinh.getThanhPhanHoSo());
		traCuuThuTucHanhChinhImpl.setLePhi(traCuuThuTucHanhChinh.getLePhi());
		traCuuThuTucHanhChinhImpl.setDonViLePhi(traCuuThuTucHanhChinh.getDonViLePhi());
		traCuuThuTucHanhChinhImpl.setPhi(traCuuThuTucHanhChinh.getPhi());
		traCuuThuTucHanhChinhImpl.setDonViPhi(traCuuThuTucHanhChinh.getDonViPhi());
		traCuuThuTucHanhChinhImpl.setTenMauDonToKhai(traCuuThuTucHanhChinh.getTenMauDonToKhai());
		traCuuThuTucHanhChinhImpl.setYeuCauDieuKienThucHien(traCuuThuTucHanhChinh.getYeuCauDieuKienThucHien());
		traCuuThuTucHanhChinhImpl.setCanCuPhapLy(traCuuThuTucHanhChinh.getCanCuPhapLy());
		traCuuThuTucHanhChinhImpl.setCapCoQuanQuanLyId(traCuuThuTucHanhChinh.getCapCoQuanQuanLyId());
		traCuuThuTucHanhChinhImpl.setLinhVucThucHien(traCuuThuTucHanhChinh.getLinhVucThucHien());
		traCuuThuTucHanhChinhImpl.setMaDNG(traCuuThuTucHanhChinh.getMaDNG());
		traCuuThuTucHanhChinhImpl.setUengineProcessName(traCuuThuTucHanhChinh.getUengineProcessName());
		traCuuThuTucHanhChinhImpl.setThuTucLienThongId(traCuuThuTucHanhChinh.getThuTucLienThongId());

		return traCuuThuTucHanhChinhImpl;
	}

	/**
	 * Returns the tra cuu thu tuc hanh chinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tra cuu thu tuc hanh chinh
	 * @return the tra cuu thu tuc hanh chinh
	 * @throws com.liferay.portal.NoSuchModelException if a tra cuu thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TraCuuThuTucHanhChinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tra cuu thu tuc hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException} if it could not be found.
	 *
	 * @param id the primary key of the tra cuu thu tuc hanh chinh
	 * @return the tra cuu thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException if a tra cuu thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TraCuuThuTucHanhChinh findByPrimaryKey(long id)
		throws NoSuchTraCuuThuTucHanhChinhException, SystemException {
		TraCuuThuTucHanhChinh traCuuThuTucHanhChinh = fetchByPrimaryKey(id);

		if (traCuuThuTucHanhChinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTraCuuThuTucHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return traCuuThuTucHanhChinh;
	}

	/**
	 * Returns the tra cuu thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tra cuu thu tuc hanh chinh
	 * @return the tra cuu thu tuc hanh chinh, or <code>null</code> if a tra cuu thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TraCuuThuTucHanhChinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tra cuu thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tra cuu thu tuc hanh chinh
	 * @return the tra cuu thu tuc hanh chinh, or <code>null</code> if a tra cuu thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TraCuuThuTucHanhChinh fetchByPrimaryKey(long id)
		throws SystemException {
		TraCuuThuTucHanhChinh traCuuThuTucHanhChinh = (TraCuuThuTucHanhChinh)EntityCacheUtil.getResult(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				TraCuuThuTucHanhChinhImpl.class, id);

		if (traCuuThuTucHanhChinh == _nullTraCuuThuTucHanhChinh) {
			return null;
		}

		if (traCuuThuTucHanhChinh == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				traCuuThuTucHanhChinh = (TraCuuThuTucHanhChinh)session.get(TraCuuThuTucHanhChinhImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (traCuuThuTucHanhChinh != null) {
					cacheResult(traCuuThuTucHanhChinh);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TraCuuThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						TraCuuThuTucHanhChinhImpl.class, id,
						_nullTraCuuThuTucHanhChinh);
				}

				closeSession(session);
			}
		}

		return traCuuThuTucHanhChinh;
	}

	/**
	 * Returns all the tra cuu thu tuc hanh chinhs.
	 *
	 * @return the tra cuu thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TraCuuThuTucHanhChinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tra cuu thu tuc hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tra cuu thu tuc hanh chinhs
	 * @param end the upper bound of the range of tra cuu thu tuc hanh chinhs (not inclusive)
	 * @return the range of tra cuu thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TraCuuThuTucHanhChinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tra cuu thu tuc hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tra cuu thu tuc hanh chinhs
	 * @param end the upper bound of the range of tra cuu thu tuc hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tra cuu thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TraCuuThuTucHanhChinh> findAll(int start, int end,
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

		List<TraCuuThuTucHanhChinh> list = (List<TraCuuThuTucHanhChinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRACUUTHUTUCHANHCHINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACUUTHUTUCHANHCHINH;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TraCuuThuTucHanhChinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TraCuuThuTucHanhChinh>)QueryUtil.list(q,
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
	 * Removes all the tra cuu thu tuc hanh chinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TraCuuThuTucHanhChinh traCuuThuTucHanhChinh : findAll()) {
			remove(traCuuThuTucHanhChinh);
		}
	}

	/**
	 * Returns the number of tra cuu thu tuc hanh chinhs.
	 *
	 * @return the number of tra cuu thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRACUUTHUTUCHANHCHINH);

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
	 * Initializes the tra cuu thu tuc hanh chinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TraCuuThuTucHanhChinh>> listenersList = new ArrayList<ModelListener<TraCuuThuTucHanhChinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TraCuuThuTucHanhChinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TraCuuThuTucHanhChinhImpl.class.getName());
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
	private static final String _SQL_SELECT_TRACUUTHUTUCHANHCHINH = "SELECT traCuuThuTucHanhChinh FROM TraCuuThuTucHanhChinh traCuuThuTucHanhChinh";
	private static final String _SQL_COUNT_TRACUUTHUTUCHANHCHINH = "SELECT COUNT(traCuuThuTucHanhChinh) FROM TraCuuThuTucHanhChinh traCuuThuTucHanhChinh";
	private static final String _ORDER_BY_ENTITY_ALIAS = "traCuuThuTucHanhChinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TraCuuThuTucHanhChinh exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TraCuuThuTucHanhChinhPersistenceImpl.class);
	private static TraCuuThuTucHanhChinh _nullTraCuuThuTucHanhChinh = new TraCuuThuTucHanhChinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TraCuuThuTucHanhChinh> toCacheModel() {
				return _nullTraCuuThuTucHanhChinhCacheModel;
			}
		};

	private static CacheModel<TraCuuThuTucHanhChinh> _nullTraCuuThuTucHanhChinhCacheModel =
		new CacheModel<TraCuuThuTucHanhChinh>() {
			public TraCuuThuTucHanhChinh toEntityModel() {
				return _nullTraCuuThuTucHanhChinh;
			}
		};
}