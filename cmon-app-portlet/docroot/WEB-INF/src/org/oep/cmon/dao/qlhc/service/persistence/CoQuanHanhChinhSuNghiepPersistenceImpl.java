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

package org.oep.cmon.dao.qlhc.service.persistence;

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

import org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException;
import org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanHanhChinhSuNghiepImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanHanhChinhSuNghiepModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the co quan hanh chinh su nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CoQuanHanhChinhSuNghiepPersistence
 * @see CoQuanHanhChinhSuNghiepUtil
 * @generated
 */
public class CoQuanHanhChinhSuNghiepPersistenceImpl extends BasePersistenceImpl<CoQuanHanhChinhSuNghiep>
	implements CoQuanHanhChinhSuNghiepPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoQuanHanhChinhSuNghiepUtil} to access the co quan hanh chinh su nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoQuanHanhChinhSuNghiepImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepModelImpl.FINDER_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepModelImpl.FINDER_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the co quan hanh chinh su nghiep in the entity cache if it is enabled.
	 *
	 * @param coQuanHanhChinhSuNghiep the co quan hanh chinh su nghiep
	 */
	public void cacheResult(CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep) {
		EntityCacheUtil.putResult(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepImpl.class,
			coQuanHanhChinhSuNghiep.getPrimaryKey(), coQuanHanhChinhSuNghiep);

		coQuanHanhChinhSuNghiep.resetOriginalValues();
	}

	/**
	 * Caches the co quan hanh chinh su nghieps in the entity cache if it is enabled.
	 *
	 * @param coQuanHanhChinhSuNghieps the co quan hanh chinh su nghieps
	 */
	public void cacheResult(
		List<CoQuanHanhChinhSuNghiep> coQuanHanhChinhSuNghieps) {
		for (CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep : coQuanHanhChinhSuNghieps) {
			if (EntityCacheUtil.getResult(
						CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanHanhChinhSuNghiepImpl.class,
						coQuanHanhChinhSuNghiep.getPrimaryKey()) == null) {
				cacheResult(coQuanHanhChinhSuNghiep);
			}
			else {
				coQuanHanhChinhSuNghiep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all co quan hanh chinh su nghieps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoQuanHanhChinhSuNghiepImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoQuanHanhChinhSuNghiepImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the co quan hanh chinh su nghiep.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep) {
		EntityCacheUtil.removeResult(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepImpl.class,
			coQuanHanhChinhSuNghiep.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CoQuanHanhChinhSuNghiep> coQuanHanhChinhSuNghieps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep : coQuanHanhChinhSuNghieps) {
			EntityCacheUtil.removeResult(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanHanhChinhSuNghiepImpl.class,
				coQuanHanhChinhSuNghiep.getPrimaryKey());
		}
	}

	/**
	 * Creates a new co quan hanh chinh su nghiep with the primary key. Does not add the co quan hanh chinh su nghiep to the database.
	 *
	 * @param id the primary key for the new co quan hanh chinh su nghiep
	 * @return the new co quan hanh chinh su nghiep
	 */
	public CoQuanHanhChinhSuNghiep create(long id) {
		CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep = new CoQuanHanhChinhSuNghiepImpl();

		coQuanHanhChinhSuNghiep.setNew(true);
		coQuanHanhChinhSuNghiep.setPrimaryKey(id);

		return coQuanHanhChinhSuNghiep;
	}

	/**
	 * Removes the co quan hanh chinh su nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the co quan hanh chinh su nghiep
	 * @return the co quan hanh chinh su nghiep that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException if a co quan hanh chinh su nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanHanhChinhSuNghiep remove(long id)
		throws NoSuchCoQuanHanhChinhSuNghiepException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the co quan hanh chinh su nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the co quan hanh chinh su nghiep
	 * @return the co quan hanh chinh su nghiep that was removed
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException if a co quan hanh chinh su nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanHanhChinhSuNghiep remove(Serializable primaryKey)
		throws NoSuchCoQuanHanhChinhSuNghiepException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep = (CoQuanHanhChinhSuNghiep)session.get(CoQuanHanhChinhSuNghiepImpl.class,
					primaryKey);

			if (coQuanHanhChinhSuNghiep == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoQuanHanhChinhSuNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coQuanHanhChinhSuNghiep);
		}
		catch (NoSuchCoQuanHanhChinhSuNghiepException nsee) {
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
	protected CoQuanHanhChinhSuNghiep removeImpl(
		CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep)
		throws SystemException {
		coQuanHanhChinhSuNghiep = toUnwrappedModel(coQuanHanhChinhSuNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, coQuanHanhChinhSuNghiep);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(coQuanHanhChinhSuNghiep);

		return coQuanHanhChinhSuNghiep;
	}

	@Override
	public CoQuanHanhChinhSuNghiep updateImpl(
		org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep,
		boolean merge) throws SystemException {
		coQuanHanhChinhSuNghiep = toUnwrappedModel(coQuanHanhChinhSuNghiep);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, coQuanHanhChinhSuNghiep, merge);

			coQuanHanhChinhSuNghiep.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
			CoQuanHanhChinhSuNghiepImpl.class,
			coQuanHanhChinhSuNghiep.getPrimaryKey(), coQuanHanhChinhSuNghiep);

		return coQuanHanhChinhSuNghiep;
	}

	protected CoQuanHanhChinhSuNghiep toUnwrappedModel(
		CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep) {
		if (coQuanHanhChinhSuNghiep instanceof CoQuanHanhChinhSuNghiepImpl) {
			return coQuanHanhChinhSuNghiep;
		}

		CoQuanHanhChinhSuNghiepImpl coQuanHanhChinhSuNghiepImpl = new CoQuanHanhChinhSuNghiepImpl();

		coQuanHanhChinhSuNghiepImpl.setNew(coQuanHanhChinhSuNghiep.isNew());
		coQuanHanhChinhSuNghiepImpl.setPrimaryKey(coQuanHanhChinhSuNghiep.getPrimaryKey());

		coQuanHanhChinhSuNghiepImpl.setId(coQuanHanhChinhSuNghiep.getId());
		coQuanHanhChinhSuNghiepImpl.setMa(coQuanHanhChinhSuNghiep.getMa());
		coQuanHanhChinhSuNghiepImpl.setTen(coQuanHanhChinhSuNghiep.getTen());
		coQuanHanhChinhSuNghiepImpl.setSoDTDuongDayNong(coQuanHanhChinhSuNghiep.getSoDTDuongDayNong());
		coQuanHanhChinhSuNghiepImpl.setNoiBo(coQuanHanhChinhSuNghiep.getNoiBo());
		coQuanHanhChinhSuNghiepImpl.setChucNang(coQuanHanhChinhSuNghiep.getChucNang());
		coQuanHanhChinhSuNghiepImpl.setTongSoCBNV(coQuanHanhChinhSuNghiep.getTongSoCBNV());
		coQuanHanhChinhSuNghiepImpl.setSoDT(coQuanHanhChinhSuNghiep.getSoDT());
		coQuanHanhChinhSuNghiepImpl.setFax(coQuanHanhChinhSuNghiep.getFax());
		coQuanHanhChinhSuNghiepImpl.setEmail(coQuanHanhChinhSuNghiep.getEmail());
		coQuanHanhChinhSuNghiepImpl.setTongSoGiuongBenh(coQuanHanhChinhSuNghiep.getTongSoGiuongBenh());
		coQuanHanhChinhSuNghiepImpl.setViDo(coQuanHanhChinhSuNghiep.getViDo());
		coQuanHanhChinhSuNghiepImpl.setKinhDo(coQuanHanhChinhSuNghiep.getKinhDo());
		coQuanHanhChinhSuNghiepImpl.setDiaChiCoQuanHCSNXaId(coQuanHanhChinhSuNghiep.getDiaChiCoQuanHCSNXaId());
		coQuanHanhChinhSuNghiepImpl.setTuyenId(coQuanHanhChinhSuNghiep.getTuyenId());
		coQuanHanhChinhSuNghiepImpl.setDiaChiCoQuanHCSNTinhId(coQuanHanhChinhSuNghiep.getDiaChiCoQuanHCSNTinhId());
		coQuanHanhChinhSuNghiepImpl.setNguoiDaiDienId(coQuanHanhChinhSuNghiep.getNguoiDaiDienId());
		coQuanHanhChinhSuNghiepImpl.setDiaChiCoQuanHCSNHuyenId(coQuanHanhChinhSuNghiep.getDiaChiCoQuanHCSNHuyenId());
		coQuanHanhChinhSuNghiepImpl.setHangId(coQuanHanhChinhSuNghiep.getHangId());
		coQuanHanhChinhSuNghiepImpl.setCoQuanQuanLyId(coQuanHanhChinhSuNghiep.getCoQuanQuanLyId());
		coQuanHanhChinhSuNghiepImpl.setLoaiId(coQuanHanhChinhSuNghiep.getLoaiId());
		coQuanHanhChinhSuNghiepImpl.setSoQdThanhLap(coQuanHanhChinhSuNghiep.getSoQdThanhLap());
		coQuanHanhChinhSuNghiepImpl.setMoTaDiaChi(coQuanHanhChinhSuNghiep.getMoTaDiaChi());
		coQuanHanhChinhSuNghiepImpl.setTenNguoiDaiDien(coQuanHanhChinhSuNghiep.getTenNguoiDaiDien());
		coQuanHanhChinhSuNghiepImpl.setNgayTao(coQuanHanhChinhSuNghiep.getNgayTao());
		coQuanHanhChinhSuNghiepImpl.setDaXoa(coQuanHanhChinhSuNghiep.getDaXoa());
		coQuanHanhChinhSuNghiepImpl.setNgaySua(coQuanHanhChinhSuNghiep.getNgaySua());
		coQuanHanhChinhSuNghiepImpl.setChaId(coQuanHanhChinhSuNghiep.getChaId());
		coQuanHanhChinhSuNghiepImpl.setNguoiTao(coQuanHanhChinhSuNghiep.getNguoiTao());
		coQuanHanhChinhSuNghiepImpl.setNguoiSua(coQuanHanhChinhSuNghiep.getNguoiSua());

		return coQuanHanhChinhSuNghiepImpl;
	}

	/**
	 * Returns the co quan hanh chinh su nghiep with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan hanh chinh su nghiep
	 * @return the co quan hanh chinh su nghiep
	 * @throws com.liferay.portal.NoSuchModelException if a co quan hanh chinh su nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanHanhChinhSuNghiep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the co quan hanh chinh su nghiep with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException} if it could not be found.
	 *
	 * @param id the primary key of the co quan hanh chinh su nghiep
	 * @return the co quan hanh chinh su nghiep
	 * @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException if a co quan hanh chinh su nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanHanhChinhSuNghiep findByPrimaryKey(long id)
		throws NoSuchCoQuanHanhChinhSuNghiepException, SystemException {
		CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep = fetchByPrimaryKey(id);

		if (coQuanHanhChinhSuNghiep == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCoQuanHanhChinhSuNghiepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return coQuanHanhChinhSuNghiep;
	}

	/**
	 * Returns the co quan hanh chinh su nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the co quan hanh chinh su nghiep
	 * @return the co quan hanh chinh su nghiep, or <code>null</code> if a co quan hanh chinh su nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CoQuanHanhChinhSuNghiep fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the co quan hanh chinh su nghiep with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the co quan hanh chinh su nghiep
	 * @return the co quan hanh chinh su nghiep, or <code>null</code> if a co quan hanh chinh su nghiep with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CoQuanHanhChinhSuNghiep fetchByPrimaryKey(long id)
		throws SystemException {
		CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep = (CoQuanHanhChinhSuNghiep)EntityCacheUtil.getResult(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
				CoQuanHanhChinhSuNghiepImpl.class, id);

		if (coQuanHanhChinhSuNghiep == _nullCoQuanHanhChinhSuNghiep) {
			return null;
		}

		if (coQuanHanhChinhSuNghiep == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				coQuanHanhChinhSuNghiep = (CoQuanHanhChinhSuNghiep)session.get(CoQuanHanhChinhSuNghiepImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (coQuanHanhChinhSuNghiep != null) {
					cacheResult(coQuanHanhChinhSuNghiep);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CoQuanHanhChinhSuNghiepModelImpl.ENTITY_CACHE_ENABLED,
						CoQuanHanhChinhSuNghiepImpl.class, id,
						_nullCoQuanHanhChinhSuNghiep);
				}

				closeSession(session);
			}
		}

		return coQuanHanhChinhSuNghiep;
	}

	/**
	 * Returns all the co quan hanh chinh su nghieps.
	 *
	 * @return the co quan hanh chinh su nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanHanhChinhSuNghiep> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the co quan hanh chinh su nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan hanh chinh su nghieps
	 * @param end the upper bound of the range of co quan hanh chinh su nghieps (not inclusive)
	 * @return the range of co quan hanh chinh su nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanHanhChinhSuNghiep> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the co quan hanh chinh su nghieps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of co quan hanh chinh su nghieps
	 * @param end the upper bound of the range of co quan hanh chinh su nghieps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of co quan hanh chinh su nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CoQuanHanhChinhSuNghiep> findAll(int start, int end,
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

		List<CoQuanHanhChinhSuNghiep> list = (List<CoQuanHanhChinhSuNghiep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COQUANHANHCHINHSUNGHIEP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COQUANHANHCHINHSUNGHIEP.concat(CoQuanHanhChinhSuNghiepModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CoQuanHanhChinhSuNghiep>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CoQuanHanhChinhSuNghiep>)QueryUtil.list(q,
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
	 * Removes all the co quan hanh chinh su nghieps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep : findAll()) {
			remove(coQuanHanhChinhSuNghiep);
		}
	}

	/**
	 * Returns the number of co quan hanh chinh su nghieps.
	 *
	 * @return the number of co quan hanh chinh su nghieps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COQUANHANHCHINHSUNGHIEP);

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
	 * Initializes the co quan hanh chinh su nghiep persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CoQuanHanhChinhSuNghiep>> listenersList = new ArrayList<ModelListener<CoQuanHanhChinhSuNghiep>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CoQuanHanhChinhSuNghiep>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CoQuanHanhChinhSuNghiepImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapCoQuanQuanLyPersistence.class)
	protected CapCoQuanQuanLyPersistence capCoQuanQuanLyPersistence;
	@BeanReference(type = CapDonViHanhChinhPersistence.class)
	protected CapDonViHanhChinhPersistence capDonViHanhChinhPersistence;
	@BeanReference(type = ChucVu2VaiTroPersistence.class)
	protected ChucVu2VaiTroPersistence chucVu2VaiTroPersistence;
	@BeanReference(type = CoQuanHanhChinhSuNghiepPersistence.class)
	protected CoQuanHanhChinhSuNghiepPersistence coQuanHanhChinhSuNghiepPersistence;
	@BeanReference(type = CoQuanQuanLyPersistence.class)
	protected CoQuanQuanLyPersistence coQuanQuanLyPersistence;
	@BeanReference(type = DonViHanhChinhPersistence.class)
	protected DonViHanhChinhPersistence donViHanhChinhPersistence;
	@BeanReference(type = QuocGiaPersistence.class)
	protected QuocGiaPersistence quocGiaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COQUANHANHCHINHSUNGHIEP = "SELECT coQuanHanhChinhSuNghiep FROM CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep";
	private static final String _SQL_COUNT_COQUANHANHCHINHSUNGHIEP = "SELECT COUNT(coQuanHanhChinhSuNghiep) FROM CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coQuanHanhChinhSuNghiep.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CoQuanHanhChinhSuNghiep exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoQuanHanhChinhSuNghiepPersistenceImpl.class);
	private static CoQuanHanhChinhSuNghiep _nullCoQuanHanhChinhSuNghiep = new CoQuanHanhChinhSuNghiepImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CoQuanHanhChinhSuNghiep> toCacheModel() {
				return _nullCoQuanHanhChinhSuNghiepCacheModel;
			}
		};

	private static CacheModel<CoQuanHanhChinhSuNghiep> _nullCoQuanHanhChinhSuNghiepCacheModel =
		new CacheModel<CoQuanHanhChinhSuNghiep>() {
			public CoQuanHanhChinhSuNghiep toEntityModel() {
				return _nullCoQuanHanhChinhSuNghiep;
			}
		};
}