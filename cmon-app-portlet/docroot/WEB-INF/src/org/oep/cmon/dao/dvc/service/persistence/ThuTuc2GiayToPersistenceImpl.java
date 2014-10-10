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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.impl.ThuTuc2GiayToImpl;
import org.oep.cmon.dao.dvc.model.impl.ThuTuc2GiayToModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the thu tuc2 giay to service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see ThuTuc2GiayToPersistence
 * @see ThuTuc2GiayToUtil
 * @generated
 */
public class ThuTuc2GiayToPersistenceImpl extends BasePersistenceImpl<ThuTuc2GiayTo>
	implements ThuTuc2GiayToPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThuTuc2GiayToUtil} to access the thu tuc2 giay to persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThuTuc2GiayToImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTrangThai", new String[] { Integer.class.getName() },
			ThuTuc2GiayToModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINH =
		new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThuTuchanhChinh",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINH =
		new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTuchanhChinh",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			ThuTuc2GiayToModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			ThuTuc2GiayToModelImpl.DAXOA_COLUMN_BITMASK |
			ThuTuc2GiayToModelImpl.GIAIDOAN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINH = new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTuchanhChinh",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUC2GIAYTO =
		new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThuTuc2GiayTo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC2GIAYTO =
		new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTuc2GiayTo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ThuTuc2GiayToModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			ThuTuc2GiayToModelImpl.DANHMUCGIAYTOID_COLUMN_BITMASK |
			ThuTuc2GiayToModelImpl.GIAIDOAN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUC2GIAYTO = new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThuTuc2GiayTo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the thu tuc2 giay to in the entity cache if it is enabled.
	 *
	 * @param thuTuc2GiayTo the thu tuc2 giay to
	 */
	public void cacheResult(ThuTuc2GiayTo thuTuc2GiayTo) {
		EntityCacheUtil.putResult(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, thuTuc2GiayTo.getPrimaryKey(),
			thuTuc2GiayTo);

		thuTuc2GiayTo.resetOriginalValues();
	}

	/**
	 * Caches the thu tuc2 giay tos in the entity cache if it is enabled.
	 *
	 * @param thuTuc2GiayTos the thu tuc2 giay tos
	 */
	public void cacheResult(List<ThuTuc2GiayTo> thuTuc2GiayTos) {
		for (ThuTuc2GiayTo thuTuc2GiayTo : thuTuc2GiayTos) {
			if (EntityCacheUtil.getResult(
						ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
						ThuTuc2GiayToImpl.class, thuTuc2GiayTo.getPrimaryKey()) == null) {
				cacheResult(thuTuc2GiayTo);
			}
			else {
				thuTuc2GiayTo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thu tuc2 giay tos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThuTuc2GiayToImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThuTuc2GiayToImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thu tuc2 giay to.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThuTuc2GiayTo thuTuc2GiayTo) {
		EntityCacheUtil.removeResult(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, thuTuc2GiayTo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ThuTuc2GiayTo> thuTuc2GiayTos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThuTuc2GiayTo thuTuc2GiayTo : thuTuc2GiayTos) {
			EntityCacheUtil.removeResult(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
				ThuTuc2GiayToImpl.class, thuTuc2GiayTo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new thu tuc2 giay to with the primary key. Does not add the thu tuc2 giay to to the database.
	 *
	 * @param id the primary key for the new thu tuc2 giay to
	 * @return the new thu tuc2 giay to
	 */
	public ThuTuc2GiayTo create(long id) {
		ThuTuc2GiayTo thuTuc2GiayTo = new ThuTuc2GiayToImpl();

		thuTuc2GiayTo.setNew(true);
		thuTuc2GiayTo.setPrimaryKey(id);

		return thuTuc2GiayTo;
	}

	/**
	 * Removes the thu tuc2 giay to with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thu tuc2 giay to
	 * @return the thu tuc2 giay to that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo remove(long id)
		throws NoSuchThuTuc2GiayToException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the thu tuc2 giay to with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thu tuc2 giay to
	 * @return the thu tuc2 giay to that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThuTuc2GiayTo remove(Serializable primaryKey)
		throws NoSuchThuTuc2GiayToException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThuTuc2GiayTo thuTuc2GiayTo = (ThuTuc2GiayTo)session.get(ThuTuc2GiayToImpl.class,
					primaryKey);

			if (thuTuc2GiayTo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThuTuc2GiayToException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thuTuc2GiayTo);
		}
		catch (NoSuchThuTuc2GiayToException nsee) {
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
	protected ThuTuc2GiayTo removeImpl(ThuTuc2GiayTo thuTuc2GiayTo)
		throws SystemException {
		thuTuc2GiayTo = toUnwrappedModel(thuTuc2GiayTo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, thuTuc2GiayTo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(thuTuc2GiayTo);

		return thuTuc2GiayTo;
	}

	@Override
	public ThuTuc2GiayTo updateImpl(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo, boolean merge)
		throws SystemException {
		thuTuc2GiayTo = toUnwrappedModel(thuTuc2GiayTo);

		boolean isNew = thuTuc2GiayTo.isNew();

		ThuTuc2GiayToModelImpl thuTuc2GiayToModelImpl = (ThuTuc2GiayToModelImpl)thuTuc2GiayTo;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, thuTuc2GiayTo, merge);

			thuTuc2GiayTo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThuTuc2GiayToModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thuTuc2GiayToModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(thuTuc2GiayToModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(thuTuc2GiayToModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((thuTuc2GiayToModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(thuTuc2GiayToModelImpl.getOriginalThuTucHanhChinhId()),
						Integer.valueOf(thuTuc2GiayToModelImpl.getOriginalDaXoa()),
						Integer.valueOf(thuTuc2GiayToModelImpl.getOriginalGiaidoan())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINH,
					args);

				args = new Object[] {
						Long.valueOf(thuTuc2GiayToModelImpl.getThuTucHanhChinhId()),
						Integer.valueOf(thuTuc2GiayToModelImpl.getDaXoa()),
						Integer.valueOf(thuTuc2GiayToModelImpl.getGiaidoan())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINH,
					args);
			}

			if ((thuTuc2GiayToModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC2GIAYTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(thuTuc2GiayToModelImpl.getOriginalThuTucHanhChinhId()),
						Long.valueOf(thuTuc2GiayToModelImpl.getOriginalDanhMucGiayToId()),
						Integer.valueOf(thuTuc2GiayToModelImpl.getOriginalGiaidoan())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUC2GIAYTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC2GIAYTO,
					args);

				args = new Object[] {
						Long.valueOf(thuTuc2GiayToModelImpl.getThuTucHanhChinhId()),
						Long.valueOf(thuTuc2GiayToModelImpl.getDanhMucGiayToId()),
						Integer.valueOf(thuTuc2GiayToModelImpl.getGiaidoan())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUC2GIAYTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC2GIAYTO,
					args);
			}
		}

		EntityCacheUtil.putResult(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
			ThuTuc2GiayToImpl.class, thuTuc2GiayTo.getPrimaryKey(),
			thuTuc2GiayTo);

		return thuTuc2GiayTo;
	}

	protected ThuTuc2GiayTo toUnwrappedModel(ThuTuc2GiayTo thuTuc2GiayTo) {
		if (thuTuc2GiayTo instanceof ThuTuc2GiayToImpl) {
			return thuTuc2GiayTo;
		}

		ThuTuc2GiayToImpl thuTuc2GiayToImpl = new ThuTuc2GiayToImpl();

		thuTuc2GiayToImpl.setNew(thuTuc2GiayTo.isNew());
		thuTuc2GiayToImpl.setPrimaryKey(thuTuc2GiayTo.getPrimaryKey());

		thuTuc2GiayToImpl.setId(thuTuc2GiayTo.getId());
		thuTuc2GiayToImpl.setGhiChu(thuTuc2GiayTo.getGhiChu());
		thuTuc2GiayToImpl.setBatBuoc(thuTuc2GiayTo.getBatBuoc());
		thuTuc2GiayToImpl.setThuTuHienThi(thuTuc2GiayTo.getThuTuHienThi());
		thuTuc2GiayToImpl.setNgayTao(thuTuc2GiayTo.getNgayTao());
		thuTuc2GiayToImpl.setNgaySua(thuTuc2GiayTo.getNgaySua());
		thuTuc2GiayToImpl.setDaXoa(thuTuc2GiayTo.getDaXoa());
		thuTuc2GiayToImpl.setNguoiTao(thuTuc2GiayTo.getNguoiTao());
		thuTuc2GiayToImpl.setNguoiSua(thuTuc2GiayTo.getNguoiSua());
		thuTuc2GiayToImpl.setThuTucHanhChinhId(thuTuc2GiayTo.getThuTucHanhChinhId());
		thuTuc2GiayToImpl.setDanhMucGiayToId(thuTuc2GiayTo.getDanhMucGiayToId());
		thuTuc2GiayToImpl.setTrangThai(thuTuc2GiayTo.getTrangThai());
		thuTuc2GiayToImpl.setGiaidoan(thuTuc2GiayTo.getGiaidoan());

		return thuTuc2GiayToImpl;
	}

	/**
	 * Returns the thu tuc2 giay to with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the thu tuc2 giay to
	 * @return the thu tuc2 giay to
	 * @throws com.liferay.portal.NoSuchModelException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThuTuc2GiayTo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thu tuc2 giay to with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException} if it could not be found.
	 *
	 * @param id the primary key of the thu tuc2 giay to
	 * @return the thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByPrimaryKey(long id)
		throws NoSuchThuTuc2GiayToException, SystemException {
		ThuTuc2GiayTo thuTuc2GiayTo = fetchByPrimaryKey(id);

		if (thuTuc2GiayTo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchThuTuc2GiayToException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return thuTuc2GiayTo;
	}

	/**
	 * Returns the thu tuc2 giay to with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thu tuc2 giay to
	 * @return the thu tuc2 giay to, or <code>null</code> if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThuTuc2GiayTo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thu tuc2 giay to with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thu tuc2 giay to
	 * @return the thu tuc2 giay to, or <code>null</code> if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo fetchByPrimaryKey(long id) throws SystemException {
		ThuTuc2GiayTo thuTuc2GiayTo = (ThuTuc2GiayTo)EntityCacheUtil.getResult(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
				ThuTuc2GiayToImpl.class, id);

		if (thuTuc2GiayTo == _nullThuTuc2GiayTo) {
			return null;
		}

		if (thuTuc2GiayTo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				thuTuc2GiayTo = (ThuTuc2GiayTo)session.get(ThuTuc2GiayToImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (thuTuc2GiayTo != null) {
					cacheResult(thuTuc2GiayTo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ThuTuc2GiayToModelImpl.ENTITY_CACHE_ENABLED,
						ThuTuc2GiayToImpl.class, id, _nullThuTuc2GiayTo);
				}

				closeSession(session);
			}
		}

		return thuTuc2GiayTo;
	}

	/**
	 * Returns all the thu tuc2 giay tos where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc2 giay tos where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @return the range of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc2 giay tos where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByTrangThai(int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<ThuTuc2GiayTo> list = (List<ThuTuc2GiayTo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_THUTUC2GIAYTO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<ThuTuc2GiayTo>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first thu tuc2 giay to in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		List<ThuTuc2GiayTo> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTuc2GiayToException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thu tuc2 giay to in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		int count = countByTrangThai(daXoa);

		List<ThuTuc2GiayTo> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTuc2GiayToException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thu tuc2 giay to
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		ThuTuc2GiayTo thuTuc2GiayTo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThuTuc2GiayTo[] array = new ThuTuc2GiayToImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, thuTuc2GiayTo,
					daXoa, orderByComparator, true);

			array[1] = thuTuc2GiayTo;

			array[2] = getByTrangThai_PrevAndNext(session, thuTuc2GiayTo,
					daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThuTuc2GiayTo getByTrangThai_PrevAndNext(Session session,
		ThuTuc2GiayTo thuTuc2GiayTo, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THUTUC2GIAYTO_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thuTuc2GiayTo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThuTuc2GiayTo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @return the matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByThuTuchanhChinh(long thuTucHanhChinhId,
		int daXoa, int giaidoan) throws SystemException {
		return findByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @return the range of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByThuTuchanhChinh(long thuTucHanhChinhId,
		int daXoa, int giaidoan, int start, int end) throws SystemException {
		return findByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByThuTuchanhChinh(long thuTucHanhChinhId,
		int daXoa, int giaidoan, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINH;
			finderArgs = new Object[] { thuTucHanhChinhId, daXoa, giaidoan };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINH;
			finderArgs = new Object[] {
					thuTucHanhChinhId, daXoa, giaidoan,
					
					start, end, orderByComparator
				};
		}

		List<ThuTuc2GiayTo> list = (List<ThuTuc2GiayTo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_THUTUC2GIAYTO_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINH_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINH_DAXOA_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINH_GIAIDOAN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(daXoa);

				qPos.add(giaidoan);

				list = (List<ThuTuc2GiayTo>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByThuTuchanhChinh_First(long thuTucHanhChinhId,
		int daXoa, int giaidoan, OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		List<ThuTuc2GiayTo> list = findByThuTuchanhChinh(thuTucHanhChinhId,
				daXoa, giaidoan, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(", giaidoan=");
			msg.append(giaidoan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTuc2GiayToException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByThuTuchanhChinh_Last(long thuTucHanhChinhId,
		int daXoa, int giaidoan, OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		int count = countByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan);

		List<ThuTuc2GiayTo> list = findByThuTuchanhChinh(thuTucHanhChinhId,
				daXoa, giaidoan, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(", giaidoan=");
			msg.append(giaidoan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTuc2GiayToException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thu tuc2 giay to
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo[] findByThuTuchanhChinh_PrevAndNext(long id,
		long thuTucHanhChinhId, int daXoa, int giaidoan,
		OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		ThuTuc2GiayTo thuTuc2GiayTo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThuTuc2GiayTo[] array = new ThuTuc2GiayToImpl[3];

			array[0] = getByThuTuchanhChinh_PrevAndNext(session, thuTuc2GiayTo,
					thuTucHanhChinhId, daXoa, giaidoan, orderByComparator, true);

			array[1] = thuTuc2GiayTo;

			array[2] = getByThuTuchanhChinh_PrevAndNext(session, thuTuc2GiayTo,
					thuTucHanhChinhId, daXoa, giaidoan, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThuTuc2GiayTo getByThuTuchanhChinh_PrevAndNext(Session session,
		ThuTuc2GiayTo thuTuc2GiayTo, long thuTucHanhChinhId, int daXoa,
		int giaidoan, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THUTUC2GIAYTO_WHERE);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINH_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINH_DAXOA_2);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINH_GIAIDOAN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		qPos.add(daXoa);

		qPos.add(giaidoan);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thuTuc2GiayTo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThuTuc2GiayTo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @return the matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan) throws SystemException {
		return findByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
			giaidoan, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @return the range of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan, int start, int end)
		throws SystemException {
		return findByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
			giaidoan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC2GIAYTO;
			finderArgs = new Object[] {
					thuTucHanhChinhId, danhMucGiayToId, giaidoan
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUC2GIAYTO;
			finderArgs = new Object[] {
					thuTucHanhChinhId, danhMucGiayToId, giaidoan,
					
					start, end, orderByComparator
				};
		}

		List<ThuTuc2GiayTo> list = (List<ThuTuc2GiayTo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_THUTUC2GIAYTO_WHERE);

			query.append(_FINDER_COLUMN_THUTUC2GIAYTO_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUC2GIAYTO_DANHMUCGIAYTOID_2);

			query.append(_FINDER_COLUMN_THUTUC2GIAYTO_GIAIDOAN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(danhMucGiayToId);

				qPos.add(giaidoan);

				list = (List<ThuTuc2GiayTo>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByThuTuc2GiayTo_First(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan, OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		List<ThuTuc2GiayTo> list = findByThuTuc2GiayTo(thuTucHanhChinhId,
				danhMucGiayToId, giaidoan, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", danhMucGiayToId=");
			msg.append(danhMucGiayToId);

			msg.append(", giaidoan=");
			msg.append(giaidoan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTuc2GiayToException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo findByThuTuc2GiayTo_Last(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan, OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		int count = countByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
				giaidoan);

		List<ThuTuc2GiayTo> list = findByThuTuc2GiayTo(thuTucHanhChinhId,
				danhMucGiayToId, giaidoan, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", danhMucGiayToId=");
			msg.append(danhMucGiayToId);

			msg.append(", giaidoan=");
			msg.append(giaidoan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTuc2GiayToException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thu tuc2 giay to
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thu tuc2 giay to
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTuc2GiayTo[] findByThuTuc2GiayTo_PrevAndNext(long id,
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		OrderByComparator orderByComparator)
		throws NoSuchThuTuc2GiayToException, SystemException {
		ThuTuc2GiayTo thuTuc2GiayTo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThuTuc2GiayTo[] array = new ThuTuc2GiayToImpl[3];

			array[0] = getByThuTuc2GiayTo_PrevAndNext(session, thuTuc2GiayTo,
					thuTucHanhChinhId, danhMucGiayToId, giaidoan,
					orderByComparator, true);

			array[1] = thuTuc2GiayTo;

			array[2] = getByThuTuc2GiayTo_PrevAndNext(session, thuTuc2GiayTo,
					thuTucHanhChinhId, danhMucGiayToId, giaidoan,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThuTuc2GiayTo getByThuTuc2GiayTo_PrevAndNext(Session session,
		ThuTuc2GiayTo thuTuc2GiayTo, long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THUTUC2GIAYTO_WHERE);

		query.append(_FINDER_COLUMN_THUTUC2GIAYTO_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THUTUC2GIAYTO_DANHMUCGIAYTOID_2);

		query.append(_FINDER_COLUMN_THUTUC2GIAYTO_GIAIDOAN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		qPos.add(danhMucGiayToId);

		qPos.add(giaidoan);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thuTuc2GiayTo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThuTuc2GiayTo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thu tuc2 giay tos.
	 *
	 * @return the thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc2 giay tos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @return the range of thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc2 giay tos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thu tuc2 giay tos
	 * @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTuc2GiayTo> findAll(int start, int end,
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

		List<ThuTuc2GiayTo> list = (List<ThuTuc2GiayTo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THUTUC2GIAYTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THUTUC2GIAYTO.concat(ThuTuc2GiayToModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ThuTuc2GiayTo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ThuTuc2GiayTo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the thu tuc2 giay tos where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (ThuTuc2GiayTo thuTuc2GiayTo : findByTrangThai(daXoa)) {
			remove(thuTuc2GiayTo);
		}
	}

	/**
	 * Removes all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTuchanhChinh(long thuTucHanhChinhId, int daXoa,
		int giaidoan) throws SystemException {
		for (ThuTuc2GiayTo thuTuc2GiayTo : findByThuTuchanhChinh(
				thuTucHanhChinhId, daXoa, giaidoan)) {
			remove(thuTuc2GiayTo);
		}
	}

	/**
	 * Removes all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan) throws SystemException {
		for (ThuTuc2GiayTo thuTuc2GiayTo : findByThuTuc2GiayTo(
				thuTucHanhChinhId, danhMucGiayToId, giaidoan)) {
			remove(thuTuc2GiayTo);
		}
	}

	/**
	 * Removes all the thu tuc2 giay tos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ThuTuc2GiayTo thuTuc2GiayTo : findAll()) {
			remove(thuTuc2GiayTo);
		}
	}

	/**
	 * Returns the number of thu tuc2 giay tos where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THUTUC2GIAYTO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param giaidoan the giaidoan
	 * @return the number of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTuchanhChinh(long thuTucHanhChinhId, int daXoa,
		int giaidoan) throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, daXoa, giaidoan };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_THUTUC2GIAYTO_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINH_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINH_DAXOA_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINH_GIAIDOAN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(daXoa);

				qPos.add(giaidoan);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param danhMucGiayToId the danh muc giay to ID
	 * @param giaidoan the giaidoan
	 * @return the number of matching thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan) throws SystemException {
		Object[] finderArgs = new Object[] {
				thuTucHanhChinhId, danhMucGiayToId, giaidoan
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUC2GIAYTO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_THUTUC2GIAYTO_WHERE);

			query.append(_FINDER_COLUMN_THUTUC2GIAYTO_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUC2GIAYTO_DANHMUCGIAYTOID_2);

			query.append(_FINDER_COLUMN_THUTUC2GIAYTO_GIAIDOAN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(danhMucGiayToId);

				qPos.add(giaidoan);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUC2GIAYTO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thu tuc2 giay tos.
	 *
	 * @return the number of thu tuc2 giay tos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THUTUC2GIAYTO);

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
	 * Initializes the thu tuc2 giay to persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThuTuc2GiayTo>> listenersList = new ArrayList<ModelListener<ThuTuc2GiayTo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThuTuc2GiayTo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ThuTuc2GiayToImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapNhatKetQuaPersistence.class)
	protected CapNhatKetQuaPersistence capNhatKetQuaPersistence;
	@BeanReference(type = CauHinhPortlet2ThuTucPersistence.class)
	protected CauHinhPortlet2ThuTucPersistence cauHinhPortlet2ThuTucPersistence;
	@BeanReference(type = DanhMucGiayTo2DoiTuongSuDungPersistence.class)
	protected DanhMucGiayTo2DoiTuongSuDungPersistence danhMucGiayTo2DoiTuongSuDungPersistence;
	@BeanReference(type = DanhMucUngDungPersistence.class)
	protected DanhMucUngDungPersistence danhMucUngDungPersistence;
	@BeanReference(type = DoiTuongSuDungPersistence.class)
	protected DoiTuongSuDungPersistence doiTuongSuDungPersistence;
	@BeanReference(type = NhomThuTucHanhChinhPersistence.class)
	protected NhomThuTucHanhChinhPersistence nhomThuTucHanhChinhPersistence;
	@BeanReference(type = ThuTuc2GiayToPersistence.class)
	protected ThuTuc2GiayToPersistence thuTuc2GiayToPersistence;
	@BeanReference(type = ThuTucHanhChinhPersistence.class)
	protected ThuTucHanhChinhPersistence thuTucHanhChinhPersistence;
	@BeanReference(type = TTHC2CoQuanQuanLyPersistence.class)
	protected TTHC2CoQuanQuanLyPersistence tthc2CoQuanQuanLyPersistence;
	@BeanReference(type = TTHC2DoiTuongSuDungPersistence.class)
	protected TTHC2DoiTuongSuDungPersistence tthc2DoiTuongSuDungPersistence;
	@BeanReference(type = VanBanHuongDanPersistence.class)
	protected VanBanHuongDanPersistence vanBanHuongDanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_THUTUC2GIAYTO = "SELECT thuTuc2GiayTo FROM ThuTuc2GiayTo thuTuc2GiayTo";
	private static final String _SQL_SELECT_THUTUC2GIAYTO_WHERE = "SELECT thuTuc2GiayTo FROM ThuTuc2GiayTo thuTuc2GiayTo WHERE ";
	private static final String _SQL_COUNT_THUTUC2GIAYTO = "SELECT COUNT(thuTuc2GiayTo) FROM ThuTuc2GiayTo thuTuc2GiayTo";
	private static final String _SQL_COUNT_THUTUC2GIAYTO_WHERE = "SELECT COUNT(thuTuc2GiayTo) FROM ThuTuc2GiayTo thuTuc2GiayTo WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "thuTuc2GiayTo.daXoa = ?";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINH_THUTUCHANHCHINHID_2 =
		"thuTuc2GiayTo.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINH_DAXOA_2 = "thuTuc2GiayTo.daXoa = ? AND ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINH_GIAIDOAN_2 = "thuTuc2GiayTo.giaidoan = ?";
	private static final String _FINDER_COLUMN_THUTUC2GIAYTO_THUTUCHANHCHINHID_2 =
		"thuTuc2GiayTo.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUC2GIAYTO_DANHMUCGIAYTOID_2 = "thuTuc2GiayTo.danhMucGiayToId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUC2GIAYTO_GIAIDOAN_2 = "thuTuc2GiayTo.giaidoan = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thuTuc2GiayTo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThuTuc2GiayTo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThuTuc2GiayTo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThuTuc2GiayToPersistenceImpl.class);
	private static ThuTuc2GiayTo _nullThuTuc2GiayTo = new ThuTuc2GiayToImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ThuTuc2GiayTo> toCacheModel() {
				return _nullThuTuc2GiayToCacheModel;
			}
		};

	private static CacheModel<ThuTuc2GiayTo> _nullThuTuc2GiayToCacheModel = new CacheModel<ThuTuc2GiayTo>() {
			public ThuTuc2GiayTo toEntityModel() {
				return _nullThuTuc2GiayTo;
			}
		};
}