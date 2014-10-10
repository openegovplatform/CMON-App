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

package org.oep.cmon.dao.dn.service.persistence;

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

import org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException;
import org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep;
import org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDoanhNghiepImpl;
import org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDoanhNghiepModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the yeu cau dang ky doanh nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see YeuCauDangKyDoanhNghiepPersistence
 * @see YeuCauDangKyDoanhNghiepUtil
 * @generated
 */
public class YeuCauDangKyDoanhNghiepPersistenceImpl extends BasePersistenceImpl<YeuCauDangKyDoanhNghiep>
	implements YeuCauDangKyDoanhNghiepPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YeuCauDangKyDoanhNghiepUtil} to access the yeu cau dang ky doanh nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YeuCauDangKyDoanhNghiepImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the yeu cau dang ky doanh nghiep in the entity cache if it is enabled.
	 *
	 * @param yeuCauDangKyDoanhNghiep the yeu cau dang ky doanh nghiep
	 */
	public void cacheResult(YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		EntityCacheUtil.putResult(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepImpl.class,
			yeuCauDangKyDoanhNghiep.getPrimaryKey(), yeuCauDangKyDoanhNghiep);

		yeuCauDangKyDoanhNghiep.resetOriginalValues();
	}

	/**
	 * Caches the yeu cau dang ky doanh nghieps in the entity cache if it is enabled.
	 *
	 * @param yeuCauDangKyDoanhNghieps the yeu cau dang ky doanh nghieps
	 */
	public void cacheResult(
		List<YeuCauDangKyDoanhNghiep> yeuCauDangKyDoanhNghieps) {
		for (YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep : yeuCauDangKyDoanhNghieps) {
			if (EntityCacheUtil.getResult(
						YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauDangKyDoanhNghiepImpl.class,
						yeuCauDangKyDoanhNghiep.getPrimaryKey()) == null) {
				cacheResult(yeuCauDangKyDoanhNghiep);
			}
			else {
				yeuCauDangKyDoanhNghiep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all yeu cau dang ky doanh nghieps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YeuCauDangKyDoanhNghiepImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YeuCauDangKyDoanhNghiepImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the yeu cau dang ky doanh nghiep.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		EntityCacheUtil.removeResult(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepImpl.class,
			yeuCauDangKyDoanhNghiep.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<YeuCauDangKyDoanhNghiep> yeuCauDangKyDoanhNghieps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep : yeuCauDangKyDoanhNghieps) {
			EntityCacheUtil.removeResult(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauDangKyDoanhNghiepImpl.class,
				yeuCauDangKyDoanhNghiep.getPrimaryKey());
		}
	}

	/**
	 * Creates a new yeu cau dang ky doanh nghiep with the primary key. Does not add the yeu cau dang ky doanh nghiep to the database.
	 *
	 * @param id the primary key for the new yeu cau dang ky doanh nghiep
	 * @return the new yeu cau dang ky doanh nghiep
	 */
	public YeuCauDangKyDoanhNghiep create(long id) {
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep = new YeuCauDangKyDoanhNghiepImpl();

		yeuCauDangKyDoanhNghiep.setNew(true);
		yeuCauDangKyDoanhNghiep.setPrimaryKey(id);

		return yeuCauDangKyDoanhNghiep;
	}

	/**
	 * Removes the yeu cau dang ky doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the yeu cau dang ky doanh nghiep
	 * @return the yeu cau dang ky doanh nghiep that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException if a yeu cau dang ky doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyDoanhNghiep remove(long id)
		throws NoSuchYeuCauDangKyDoanhNghiepException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the yeu cau dang ky doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky doanh nghiep
	 * @return the yeu cau dang ky doanh nghiep that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException if a yeu cau dang ky doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyDoanhNghiep remove(Serializable primaryKey)
		throws NoSuchYeuCauDangKyDoanhNghiepException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep = (YeuCauDangKyDoanhNghiep)session.get(YeuCauDangKyDoanhNghiepImpl.class,
					primaryKey);

			if (yeuCauDangKyDoanhNghiep == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYeuCauDangKyDoanhNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yeuCauDangKyDoanhNghiep);
		}
		catch (NoSuchYeuCauDangKyDoanhNghiepException nsee) {
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
	protected YeuCauDangKyDoanhNghiep removeImpl(
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep)
		throws SystemException {
		yeuCauDangKyDoanhNghiep = toUnwrappedModel(yeuCauDangKyDoanhNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, yeuCauDangKyDoanhNghiep);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(yeuCauDangKyDoanhNghiep);

		return yeuCauDangKyDoanhNghiep;
	}

	@Override
	public YeuCauDangKyDoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep,
		boolean merge) throws SystemException {
		yeuCauDangKyDoanhNghiep = toUnwrappedModel(yeuCauDangKyDoanhNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, yeuCauDangKyDoanhNghiep, merge);

			yeuCauDangKyDoanhNghiep.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDoanhNghiepImpl.class,
			yeuCauDangKyDoanhNghiep.getPrimaryKey(), yeuCauDangKyDoanhNghiep);

		return yeuCauDangKyDoanhNghiep;
	}

	protected YeuCauDangKyDoanhNghiep toUnwrappedModel(
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		if (yeuCauDangKyDoanhNghiep instanceof YeuCauDangKyDoanhNghiepImpl) {
			return yeuCauDangKyDoanhNghiep;
		}

		YeuCauDangKyDoanhNghiepImpl yeuCauDangKyDoanhNghiepImpl = new YeuCauDangKyDoanhNghiepImpl();

		yeuCauDangKyDoanhNghiepImpl.setNew(yeuCauDangKyDoanhNghiep.isNew());
		yeuCauDangKyDoanhNghiepImpl.setPrimaryKey(yeuCauDangKyDoanhNghiep.getPrimaryKey());

		yeuCauDangKyDoanhNghiepImpl.setId(yeuCauDangKyDoanhNghiep.getId());
		yeuCauDangKyDoanhNghiepImpl.setLoaiDoiTuongId(yeuCauDangKyDoanhNghiep.getLoaiDoiTuongId());
		yeuCauDangKyDoanhNghiepImpl.setTen(yeuCauDangKyDoanhNghiep.getTen());
		yeuCauDangKyDoanhNghiepImpl.setMaSoThue(yeuCauDangKyDoanhNghiep.getMaSoThue());
		yeuCauDangKyDoanhNghiepImpl.setMaGiayPhep(yeuCauDangKyDoanhNghiep.getMaGiayPhep());
		yeuCauDangKyDoanhNghiepImpl.setNgayCap(yeuCauDangKyDoanhNghiep.getNgayCap());
		yeuCauDangKyDoanhNghiepImpl.setEmail(yeuCauDangKyDoanhNghiep.getEmail());
		yeuCauDangKyDoanhNghiepImpl.setHoNguoiDaiDien(yeuCauDangKyDoanhNghiep.getHoNguoiDaiDien());
		yeuCauDangKyDoanhNghiepImpl.setTenDemNguoiDaiDien(yeuCauDangKyDoanhNghiep.getTenDemNguoiDaiDien());
		yeuCauDangKyDoanhNghiepImpl.setTenNguoiDaiDien(yeuCauDangKyDoanhNghiep.getTenNguoiDaiDien());
		yeuCauDangKyDoanhNghiepImpl.setSoCMND(yeuCauDangKyDoanhNghiep.getSoCMND());
		yeuCauDangKyDoanhNghiepImpl.setNgayCapCMND(yeuCauDangKyDoanhNghiep.getNgayCapCMND());
		yeuCauDangKyDoanhNghiepImpl.setNoiCapCMND(yeuCauDangKyDoanhNghiep.getNoiCapCMND());
		yeuCauDangKyDoanhNghiepImpl.setMoTaNganhNgheKinhDoanh(yeuCauDangKyDoanhNghiep.getMoTaNganhNgheKinhDoanh());
		yeuCauDangKyDoanhNghiepImpl.setLoaiHinhDoanhNghiep(yeuCauDangKyDoanhNghiep.getLoaiHinhDoanhNghiep());
		yeuCauDangKyDoanhNghiepImpl.setTruSo(yeuCauDangKyDoanhNghiep.getTruSo());
		yeuCauDangKyDoanhNghiepImpl.setTruSoXaId(yeuCauDangKyDoanhNghiep.getTruSoXaId());
		yeuCauDangKyDoanhNghiepImpl.setTruSoHuyenId(yeuCauDangKyDoanhNghiep.getTruSoHuyenId());
		yeuCauDangKyDoanhNghiepImpl.setTruSoTinhId(yeuCauDangKyDoanhNghiep.getTruSoTinhId());
		yeuCauDangKyDoanhNghiepImpl.setTrangThai(yeuCauDangKyDoanhNghiep.getTrangThai());

		return yeuCauDangKyDoanhNghiepImpl;
	}

	/**
	 * Returns the yeu cau dang ky doanh nghiep with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky doanh nghiep
	 * @return the yeu cau dang ky doanh nghiep
	 * @throws com.liferay.portal.NoSuchModelException if a yeu cau dang ky doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyDoanhNghiep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the yeu cau dang ky doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException} if it could not be found.
	 *
	 * @param id the primary key of the yeu cau dang ky doanh nghiep
	 * @return the yeu cau dang ky doanh nghiep
	 * @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException if a yeu cau dang ky doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyDoanhNghiep findByPrimaryKey(long id)
		throws NoSuchYeuCauDangKyDoanhNghiepException, SystemException {
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep = fetchByPrimaryKey(id);

		if (yeuCauDangKyDoanhNghiep == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchYeuCauDangKyDoanhNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return yeuCauDangKyDoanhNghiep;
	}

	/**
	 * Returns the yeu cau dang ky doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky doanh nghiep
	 * @return the yeu cau dang ky doanh nghiep, or <code>null</code> if a yeu cau dang ky doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyDoanhNghiep fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the yeu cau dang ky doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the yeu cau dang ky doanh nghiep
	 * @return the yeu cau dang ky doanh nghiep, or <code>null</code> if a yeu cau dang ky doanh nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyDoanhNghiep fetchByPrimaryKey(long id)
		throws SystemException {
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep = (YeuCauDangKyDoanhNghiep)EntityCacheUtil.getResult(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauDangKyDoanhNghiepImpl.class, id);

		if (yeuCauDangKyDoanhNghiep == _nullYeuCauDangKyDoanhNghiep) {
			return null;
		}

		if (yeuCauDangKyDoanhNghiep == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				yeuCauDangKyDoanhNghiep = (YeuCauDangKyDoanhNghiep)session.get(YeuCauDangKyDoanhNghiepImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (yeuCauDangKyDoanhNghiep != null) {
					cacheResult(yeuCauDangKyDoanhNghiep);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YeuCauDangKyDoanhNghiepModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauDangKyDoanhNghiepImpl.class, id,
						_nullYeuCauDangKyDoanhNghiep);
				}

				closeSession(session);
			}
		}

		return yeuCauDangKyDoanhNghiep;
	}

	/**
	 * Returns all the yeu cau dang ky doanh nghieps.
	 *
	 * @return the yeu cau dang ky doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyDoanhNghiep> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the yeu cau dang ky doanh nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of yeu cau dang ky doanh nghieps
	 * @param end the upper bound of the range of yeu cau dang ky doanh nghieps (not inclusive)
	 * @return the range of yeu cau dang ky doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyDoanhNghiep> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the yeu cau dang ky doanh nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of yeu cau dang ky doanh nghieps
	 * @param end the upper bound of the range of yeu cau dang ky doanh nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of yeu cau dang ky doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyDoanhNghiep> findAll(int start, int end,
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

		List<YeuCauDangKyDoanhNghiep> list = (List<YeuCauDangKyDoanhNghiep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YEUCAUDANGKYDOANHNGHIEP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YEUCAUDANGKYDOANHNGHIEP;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YeuCauDangKyDoanhNghiep>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YeuCauDangKyDoanhNghiep>)QueryUtil.list(q,
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
	 * Removes all the yeu cau dang ky doanh nghieps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep : findAll()) {
			remove(yeuCauDangKyDoanhNghiep);
		}
	}

	/**
	 * Returns the number of yeu cau dang ky doanh nghieps.
	 *
	 * @return the number of yeu cau dang ky doanh nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YEUCAUDANGKYDOANHNGHIEP);

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
	 * Initializes the yeu cau dang ky doanh nghiep persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YeuCauDangKyDoanhNghiep>> listenersList = new ArrayList<ModelListener<YeuCauDangKyDoanhNghiep>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YeuCauDangKyDoanhNghiep>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YeuCauDangKyDoanhNghiepImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DoanhNghiepPersistence.class)
	protected DoanhNghiepPersistence doanhNghiepPersistence;
	@BeanReference(type = DoanhNghiep2NganhNghePersistence.class)
	protected DoanhNghiep2NganhNghePersistence doanhNghiep2NganhNghePersistence;
	@BeanReference(type = LoaiDoanhNghiepPersistence.class)
	protected LoaiDoanhNghiepPersistence loaiDoanhNghiepPersistence;
	@BeanReference(type = NganhNgheKinhDoanhPersistence.class)
	protected NganhNgheKinhDoanhPersistence nganhNgheKinhDoanhPersistence;
	@BeanReference(type = TrangThaiDoanhNghiepPersistence.class)
	protected TrangThaiDoanhNghiepPersistence trangThaiDoanhNghiepPersistence;
	@BeanReference(type = YeuCauDangKyDNPersistence.class)
	protected YeuCauDangKyDNPersistence yeuCauDangKyDNPersistence;
	@BeanReference(type = YeuCauDangKyDoanhNghiepPersistence.class)
	protected YeuCauDangKyDoanhNghiepPersistence yeuCauDangKyDoanhNghiepPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_YEUCAUDANGKYDOANHNGHIEP = "SELECT yeuCauDangKyDoanhNghiep FROM YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep";
	private static final String _SQL_COUNT_YEUCAUDANGKYDOANHNGHIEP = "SELECT COUNT(yeuCauDangKyDoanhNghiep) FROM YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yeuCauDangKyDoanhNghiep.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YeuCauDangKyDoanhNghiep exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YeuCauDangKyDoanhNghiepPersistenceImpl.class);
	private static YeuCauDangKyDoanhNghiep _nullYeuCauDangKyDoanhNghiep = new YeuCauDangKyDoanhNghiepImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YeuCauDangKyDoanhNghiep> toCacheModel() {
				return _nullYeuCauDangKyDoanhNghiepCacheModel;
			}
		};

	private static CacheModel<YeuCauDangKyDoanhNghiep> _nullYeuCauDangKyDoanhNghiepCacheModel =
		new CacheModel<YeuCauDangKyDoanhNghiep>() {
			public YeuCauDangKyDoanhNghiep toEntityModel() {
				return _nullYeuCauDangKyDoanhNghiep;
			}
		};
}