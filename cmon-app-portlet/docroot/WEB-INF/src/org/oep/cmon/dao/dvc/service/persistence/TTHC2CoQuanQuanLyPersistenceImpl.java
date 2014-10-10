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

import org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.impl.TTHC2CoQuanQuanLyImpl;
import org.oep.cmon.dao.dvc.model.impl.TTHC2CoQuanQuanLyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t t h c2 co quan quan ly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see TTHC2CoQuanQuanLyPersistence
 * @see TTHC2CoQuanQuanLyUtil
 * @generated
 */
public class TTHC2CoQuanQuanLyPersistenceImpl extends BasePersistenceImpl<TTHC2CoQuanQuanLy>
	implements TTHC2CoQuanQuanLyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTHC2CoQuanQuanLyUtil} to access the t t h c2 co quan quan ly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTHC2CoQuanQuanLyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			TTHC2CoQuanQuanLyModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHID =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThuTucHanhChinhId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTucHanhChinhId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TTHC2CoQuanQuanLyModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			TTHC2CoQuanQuanLyModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTucHanhChinhId",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYID =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCoQuanQuanLyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCoQuanQuanLyId",
			new String[] { Long.class.getName() },
			TTHC2CoQuanQuanLyModelImpl.COQUANQUANLYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COQUANQUANLYID = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCoQuanQuanLyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANANDTHUTUC =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCoQuanAndThuTuc",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANANDTHUTUC =
		new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCoQuanAndThuTuc",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC2CoQuanQuanLyModelImpl.COQUANQUANLYID_COLUMN_BITMASK |
			TTHC2CoQuanQuanLyModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COQUANANDTHUTUC = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCoQuanAndThuTuc",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the t t h c2 co quan quan ly in the entity cache if it is enabled.
	 *
	 * @param tthc2CoQuanQuanLy the t t h c2 co quan quan ly
	 */
	public void cacheResult(TTHC2CoQuanQuanLy tthc2CoQuanQuanLy) {
		EntityCacheUtil.putResult(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class, tthc2CoQuanQuanLy.getPrimaryKey(),
			tthc2CoQuanQuanLy);

		tthc2CoQuanQuanLy.resetOriginalValues();
	}

	/**
	 * Caches the t t h c2 co quan quan lies in the entity cache if it is enabled.
	 *
	 * @param tthc2CoQuanQuanLies the t t h c2 co quan quan lies
	 */
	public void cacheResult(List<TTHC2CoQuanQuanLy> tthc2CoQuanQuanLies) {
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : tthc2CoQuanQuanLies) {
			if (EntityCacheUtil.getResult(
						TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
						TTHC2CoQuanQuanLyImpl.class,
						tthc2CoQuanQuanLy.getPrimaryKey()) == null) {
				cacheResult(tthc2CoQuanQuanLy);
			}
			else {
				tthc2CoQuanQuanLy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t t h c2 co quan quan lies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TTHC2CoQuanQuanLyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TTHC2CoQuanQuanLyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t t h c2 co quan quan ly.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTHC2CoQuanQuanLy tthc2CoQuanQuanLy) {
		EntityCacheUtil.removeResult(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class, tthc2CoQuanQuanLy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TTHC2CoQuanQuanLy> tthc2CoQuanQuanLies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : tthc2CoQuanQuanLies) {
			EntityCacheUtil.removeResult(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
				TTHC2CoQuanQuanLyImpl.class, tthc2CoQuanQuanLy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t t h c2 co quan quan ly with the primary key. Does not add the t t h c2 co quan quan ly to the database.
	 *
	 * @param id the primary key for the new t t h c2 co quan quan ly
	 * @return the new t t h c2 co quan quan ly
	 */
	public TTHC2CoQuanQuanLy create(long id) {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = new TTHC2CoQuanQuanLyImpl();

		tthc2CoQuanQuanLy.setNew(true);
		tthc2CoQuanQuanLy.setPrimaryKey(id);

		return tthc2CoQuanQuanLy;
	}

	/**
	 * Removes the t t h c2 co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the t t h c2 co quan quan ly
	 * @return the t t h c2 co quan quan ly that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy remove(long id)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the t t h c2 co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t t h c2 co quan quan ly
	 * @return the t t h c2 co quan quan ly that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC2CoQuanQuanLy remove(Serializable primaryKey)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = (TTHC2CoQuanQuanLy)session.get(TTHC2CoQuanQuanLyImpl.class,
					primaryKey);

			if (tthc2CoQuanQuanLy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTHC2CoQuanQuanLyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tthc2CoQuanQuanLy);
		}
		catch (NoSuchTTHC2CoQuanQuanLyException nsee) {
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
	protected TTHC2CoQuanQuanLy removeImpl(TTHC2CoQuanQuanLy tthc2CoQuanQuanLy)
		throws SystemException {
		tthc2CoQuanQuanLy = toUnwrappedModel(tthc2CoQuanQuanLy);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tthc2CoQuanQuanLy);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tthc2CoQuanQuanLy);

		return tthc2CoQuanQuanLy;
	}

	@Override
	public TTHC2CoQuanQuanLy updateImpl(
		org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy tthc2CoQuanQuanLy,
		boolean merge) throws SystemException {
		tthc2CoQuanQuanLy = toUnwrappedModel(tthc2CoQuanQuanLy);

		boolean isNew = tthc2CoQuanQuanLy.isNew();

		TTHC2CoQuanQuanLyModelImpl tthc2CoQuanQuanLyModelImpl = (TTHC2CoQuanQuanLyModelImpl)tthc2CoQuanQuanLy;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tthc2CoQuanQuanLy, merge);

			tthc2CoQuanQuanLy.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TTHC2CoQuanQuanLyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tthc2CoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(tthc2CoQuanQuanLyModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(tthc2CoQuanQuanLyModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((tthc2CoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getOriginalThuTucHanhChinhId()),
						Integer.valueOf(tthc2CoQuanQuanLyModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID,
					args);

				args = new Object[] {
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getThuTucHanhChinhId()),
						Integer.valueOf(tthc2CoQuanQuanLyModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID,
					args);
			}

			if ((tthc2CoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getOriginalCoQuanQuanLyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID,
					args);

				args = new Object[] {
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getCoQuanQuanLyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID,
					args);
			}

			if ((tthc2CoQuanQuanLyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANANDTHUTUC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getOriginalCoQuanQuanLyId()),
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getOriginalThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANANDTHUTUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANANDTHUTUC,
					args);

				args = new Object[] {
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getCoQuanQuanLyId()),
						Long.valueOf(tthc2CoQuanQuanLyModelImpl.getThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COQUANANDTHUTUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANANDTHUTUC,
					args);
			}
		}

		EntityCacheUtil.putResult(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2CoQuanQuanLyImpl.class, tthc2CoQuanQuanLy.getPrimaryKey(),
			tthc2CoQuanQuanLy);

		return tthc2CoQuanQuanLy;
	}

	protected TTHC2CoQuanQuanLy toUnwrappedModel(
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy) {
		if (tthc2CoQuanQuanLy instanceof TTHC2CoQuanQuanLyImpl) {
			return tthc2CoQuanQuanLy;
		}

		TTHC2CoQuanQuanLyImpl tthc2CoQuanQuanLyImpl = new TTHC2CoQuanQuanLyImpl();

		tthc2CoQuanQuanLyImpl.setNew(tthc2CoQuanQuanLy.isNew());
		tthc2CoQuanQuanLyImpl.setPrimaryKey(tthc2CoQuanQuanLy.getPrimaryKey());

		tthc2CoQuanQuanLyImpl.setId(tthc2CoQuanQuanLy.getId());
		tthc2CoQuanQuanLyImpl.setNgayTao(tthc2CoQuanQuanLy.getNgayTao());
		tthc2CoQuanQuanLyImpl.setNgaySua(tthc2CoQuanQuanLy.getNgaySua());
		tthc2CoQuanQuanLyImpl.setDaXoa(tthc2CoQuanQuanLy.getDaXoa());
		tthc2CoQuanQuanLyImpl.setNguoiTao(tthc2CoQuanQuanLy.getNguoiTao());
		tthc2CoQuanQuanLyImpl.setNguoiSua(tthc2CoQuanQuanLy.getNguoiSua());
		tthc2CoQuanQuanLyImpl.setSoNgayXyLy(tthc2CoQuanQuanLy.getSoNgayXyLy());
		tthc2CoQuanQuanLyImpl.setThuTucHanhChinhId(tthc2CoQuanQuanLy.getThuTucHanhChinhId());
		tthc2CoQuanQuanLyImpl.setCoQuanQuanLyId(tthc2CoQuanQuanLy.getCoQuanQuanLyId());
		tthc2CoQuanQuanLyImpl.setTrangThai(tthc2CoQuanQuanLy.getTrangThai());
		tthc2CoQuanQuanLyImpl.setPhi(tthc2CoQuanQuanLy.getPhi());
		tthc2CoQuanQuanLyImpl.setLePhi(tthc2CoQuanQuanLy.getLePhi());

		return tthc2CoQuanQuanLyImpl;
	}

	/**
	 * Returns the t t h c2 co quan quan ly with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c2 co quan quan ly
	 * @return the t t h c2 co quan quan ly
	 * @throws com.liferay.portal.NoSuchModelException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC2CoQuanQuanLy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c2 co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException} if it could not be found.
	 *
	 * @param id the primary key of the t t h c2 co quan quan ly
	 * @return the t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByPrimaryKey(long id)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = fetchByPrimaryKey(id);

		if (tthc2CoQuanQuanLy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTTHC2CoQuanQuanLyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tthc2CoQuanQuanLy;
	}

	/**
	 * Returns the t t h c2 co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c2 co quan quan ly
	 * @return the t t h c2 co quan quan ly, or <code>null</code> if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC2CoQuanQuanLy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c2 co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the t t h c2 co quan quan ly
	 * @return the t t h c2 co quan quan ly, or <code>null</code> if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy fetchByPrimaryKey(long id)
		throws SystemException {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = (TTHC2CoQuanQuanLy)EntityCacheUtil.getResult(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
				TTHC2CoQuanQuanLyImpl.class, id);

		if (tthc2CoQuanQuanLy == _nullTTHC2CoQuanQuanLy) {
			return null;
		}

		if (tthc2CoQuanQuanLy == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tthc2CoQuanQuanLy = (TTHC2CoQuanQuanLy)session.get(TTHC2CoQuanQuanLyImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tthc2CoQuanQuanLy != null) {
					cacheResult(tthc2CoQuanQuanLy);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TTHC2CoQuanQuanLyModelImpl.ENTITY_CACHE_ENABLED,
						TTHC2CoQuanQuanLyImpl.class, id, _nullTTHC2CoQuanQuanLy);
				}

				closeSession(session);
			}
		}

		return tthc2CoQuanQuanLy;
	}

	/**
	 * Returns all the t t h c2 co quan quan lies where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 co quan quan lies where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @return the range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 co quan quan lies where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByTrangThai(int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TTHC2CoQuanQuanLy> list = (List<TTHC2CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TTHC2CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		List<TTHC2CoQuanQuanLy> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		int count = countByTrangThai(daXoa);

		List<TTHC2CoQuanQuanLy> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 co quan quan ly
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2CoQuanQuanLy[] array = new TTHC2CoQuanQuanLyImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, tthc2CoQuanQuanLy,
					daXoa, orderByComparator, true);

			array[1] = tthc2CoQuanQuanLy;

			array[2] = getByTrangThai_PrevAndNext(session, tthc2CoQuanQuanLy,
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

	protected TTHC2CoQuanQuanLy getByTrangThai_PrevAndNext(Session session,
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

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
			query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2CoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa) throws SystemException {
		return findByThuTucHanhChinhId(thuTucHanhChinhId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @return the range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa, int start, int end)
		throws SystemException {
		return findByThuTucHanhChinhId(thuTucHanhChinhId, daXoa, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID;
			finderArgs = new Object[] { thuTucHanhChinhId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHID;
			finderArgs = new Object[] {
					thuTucHanhChinhId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<TTHC2CoQuanQuanLy> list = (List<TTHC2CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(daXoa);

				list = (List<TTHC2CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		List<TTHC2CoQuanQuanLy> list = findByThuTucHanhChinhId(thuTucHanhChinhId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		int count = countByThuTucHanhChinhId(thuTucHanhChinhId, daXoa);

		List<TTHC2CoQuanQuanLy> list = findByThuTucHanhChinhId(thuTucHanhChinhId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 co quan quan ly
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy[] findByThuTucHanhChinhId_PrevAndNext(long id,
		long thuTucHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2CoQuanQuanLy[] array = new TTHC2CoQuanQuanLyImpl[3];

			array[0] = getByThuTucHanhChinhId_PrevAndNext(session,
					tthc2CoQuanQuanLy, thuTucHanhChinhId, daXoa,
					orderByComparator, true);

			array[1] = tthc2CoQuanQuanLy;

			array[2] = getByThuTucHanhChinhId_PrevAndNext(session,
					tthc2CoQuanQuanLy, thuTucHanhChinhId, daXoa,
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

	protected TTHC2CoQuanQuanLy getByThuTucHanhChinhId_PrevAndNext(
		Session session, TTHC2CoQuanQuanLy tthc2CoQuanQuanLy,
		long thuTucHanhChinhId, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_DAXOA_2);

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
			query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2CoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @return the matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(long coQuanQuanLyId)
		throws SystemException {
		return findByCoQuanQuanLyId(coQuanQuanLyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @return the range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(long coQuanQuanLyId,
		int start, int end) throws SystemException {
		return findByCoQuanQuanLyId(coQuanQuanLyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(long coQuanQuanLyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANQUANLYID;
			finderArgs = new Object[] { coQuanQuanLyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANQUANLYID;
			finderArgs = new Object[] {
					coQuanQuanLyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC2CoQuanQuanLy> list = (List<TTHC2CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId);

				list = (List<TTHC2CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByCoQuanQuanLyId_First(long coQuanQuanLyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		List<TTHC2CoQuanQuanLy> list = findByCoQuanQuanLyId(coQuanQuanLyId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByCoQuanQuanLyId_Last(long coQuanQuanLyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		int count = countByCoQuanQuanLyId(coQuanQuanLyId);

		List<TTHC2CoQuanQuanLy> list = findByCoQuanQuanLyId(coQuanQuanLyId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 co quan quan ly
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy[] findByCoQuanQuanLyId_PrevAndNext(long id,
		long coQuanQuanLyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2CoQuanQuanLy[] array = new TTHC2CoQuanQuanLyImpl[3];

			array[0] = getByCoQuanQuanLyId_PrevAndNext(session,
					tthc2CoQuanQuanLy, coQuanQuanLyId, orderByComparator, true);

			array[1] = tthc2CoQuanQuanLy;

			array[2] = getByCoQuanQuanLyId_PrevAndNext(session,
					tthc2CoQuanQuanLy, coQuanQuanLyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC2CoQuanQuanLy getByCoQuanQuanLyId_PrevAndNext(
		Session session, TTHC2CoQuanQuanLy tthc2CoQuanQuanLy,
		long coQuanQuanLyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

		query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

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
			query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(coQuanQuanLyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2CoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId) throws SystemException {
		return findByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @return the range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId, int start, int end) throws SystemException {
		return findByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COQUANANDTHUTUC;
			finderArgs = new Object[] { coQuanQuanLyId, thuTucHanhChinhId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COQUANANDTHUTUC;
			finderArgs = new Object[] {
					coQuanQuanLyId, thuTucHanhChinhId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC2CoQuanQuanLy> list = (List<TTHC2CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_COQUANANDTHUTUC_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_COQUANANDTHUTUC_THUTUCHANHCHINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId);

				qPos.add(thuTucHanhChinhId);

				list = (List<TTHC2CoQuanQuanLy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByCoQuanAndThuTuc_First(long coQuanQuanLyId,
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		List<TTHC2CoQuanQuanLy> list = findByCoQuanAndThuTuc(coQuanQuanLyId,
				thuTucHanhChinhId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy findByCoQuanAndThuTuc_Last(long coQuanQuanLyId,
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		int count = countByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId);

		List<TTHC2CoQuanQuanLy> list = findByCoQuanAndThuTuc(coQuanQuanLyId,
				thuTucHanhChinhId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("coQuanQuanLyId=");
			msg.append(coQuanQuanLyId);

			msg.append(", thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2CoQuanQuanLyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 co quan quan ly
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 co quan quan ly
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2CoQuanQuanLy[] findByCoQuanAndThuTuc_PrevAndNext(long id,
		long coQuanQuanLyId, long thuTucHanhChinhId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2CoQuanQuanLyException, SystemException {
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2CoQuanQuanLy[] array = new TTHC2CoQuanQuanLyImpl[3];

			array[0] = getByCoQuanAndThuTuc_PrevAndNext(session,
					tthc2CoQuanQuanLy, coQuanQuanLyId, thuTucHanhChinhId,
					orderByComparator, true);

			array[1] = tthc2CoQuanQuanLy;

			array[2] = getByCoQuanAndThuTuc_PrevAndNext(session,
					tthc2CoQuanQuanLy, coQuanQuanLyId, thuTucHanhChinhId,
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

	protected TTHC2CoQuanQuanLy getByCoQuanAndThuTuc_PrevAndNext(
		Session session, TTHC2CoQuanQuanLy tthc2CoQuanQuanLy,
		long coQuanQuanLyId, long thuTucHanhChinhId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2COQUANQUANLY_WHERE);

		query.append(_FINDER_COLUMN_COQUANANDTHUTUC_COQUANQUANLYID_2);

		query.append(_FINDER_COLUMN_COQUANANDTHUTUC_THUTUCHANHCHINHID_2);

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
			query.append(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(coQuanQuanLyId);

		qPos.add(thuTucHanhChinhId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2CoQuanQuanLy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2CoQuanQuanLy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 co quan quan lies.
	 *
	 * @return the t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 co quan quan lies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @return the range of t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 co quan quan lies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c2 co quan quan lies
	 * @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2CoQuanQuanLy> findAll(int start, int end,
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

		List<TTHC2CoQuanQuanLy> list = (List<TTHC2CoQuanQuanLy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TTHC2COQUANQUANLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTHC2COQUANQUANLY.concat(TTHC2CoQuanQuanLyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TTHC2CoQuanQuanLy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TTHC2CoQuanQuanLy>)QueryUtil.list(q,
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
	 * Removes all the t t h c2 co quan quan lies where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : findByTrangThai(daXoa)) {
			remove(tthc2CoQuanQuanLy);
		}
	}

	/**
	 * Removes all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId, int daXoa)
		throws SystemException {
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : findByThuTucHanhChinhId(
				thuTucHanhChinhId, daXoa)) {
			remove(tthc2CoQuanQuanLy);
		}
	}

	/**
	 * Removes all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; from the database.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCoQuanQuanLyId(long coQuanQuanLyId)
		throws SystemException {
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : findByCoQuanQuanLyId(
				coQuanQuanLyId)) {
			remove(tthc2CoQuanQuanLy);
		}
	}

	/**
	 * Removes all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63; from the database.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId) throws SystemException {
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : findByCoQuanAndThuTuc(
				coQuanQuanLyId, thuTucHanhChinhId)) {
			remove(tthc2CoQuanQuanLy);
		}
	}

	/**
	 * Removes all the t t h c2 co quan quan lies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TTHC2CoQuanQuanLy tthc2CoQuanQuanLy : findAll()) {
			remove(tthc2CoQuanQuanLy);
		}
	}

	/**
	 * Returns the number of t t h c2 co quan quan lies where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC2COQUANQUANLY_WHERE);

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
	 * Returns the number of t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the number of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @return the number of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCoQuanQuanLyId(long coQuanQuanLyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { coQuanQuanLyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COQUANQUANLYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	 *
	 * @param coQuanQuanLyId the co quan quan ly ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the number of matching t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId) throws SystemException {
		Object[] finderArgs = new Object[] { coQuanQuanLyId, thuTucHanhChinhId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COQUANANDTHUTUC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC2COQUANQUANLY_WHERE);

			query.append(_FINDER_COLUMN_COQUANANDTHUTUC_COQUANQUANLYID_2);

			query.append(_FINDER_COLUMN_COQUANANDTHUTUC_THUTUCHANHCHINHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(coQuanQuanLyId);

				qPos.add(thuTucHanhChinhId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COQUANANDTHUTUC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c2 co quan quan lies.
	 *
	 * @return the number of t t h c2 co quan quan lies
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTHC2COQUANQUANLY);

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
	 * Initializes the t t h c2 co quan quan ly persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TTHC2CoQuanQuanLy>> listenersList = new ArrayList<ModelListener<TTHC2CoQuanQuanLy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TTHC2CoQuanQuanLy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TTHC2CoQuanQuanLyImpl.class.getName());
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
	private static final String _SQL_SELECT_TTHC2COQUANQUANLY = "SELECT tthc2CoQuanQuanLy FROM TTHC2CoQuanQuanLy tthc2CoQuanQuanLy";
	private static final String _SQL_SELECT_TTHC2COQUANQUANLY_WHERE = "SELECT tthc2CoQuanQuanLy FROM TTHC2CoQuanQuanLy tthc2CoQuanQuanLy WHERE ";
	private static final String _SQL_COUNT_TTHC2COQUANQUANLY = "SELECT COUNT(tthc2CoQuanQuanLy) FROM TTHC2CoQuanQuanLy tthc2CoQuanQuanLy";
	private static final String _SQL_COUNT_TTHC2COQUANQUANLY_WHERE = "SELECT COUNT(tthc2CoQuanQuanLy) FROM TTHC2CoQuanQuanLy tthc2CoQuanQuanLy WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "tthc2CoQuanQuanLy.daXoa = ?";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2 =
		"tthc2CoQuanQuanLy.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHID_DAXOA_2 = "tthc2CoQuanQuanLy.daXoa = ?";
	private static final String _FINDER_COLUMN_COQUANQUANLYID_COQUANQUANLYID_2 = "tthc2CoQuanQuanLy.coQuanQuanLyId = ?";
	private static final String _FINDER_COLUMN_COQUANANDTHUTUC_COQUANQUANLYID_2 = "tthc2CoQuanQuanLy.coQuanQuanLyId = ? AND ";
	private static final String _FINDER_COLUMN_COQUANANDTHUTUC_THUTUCHANHCHINHID_2 =
		"tthc2CoQuanQuanLy.thuTucHanhChinhId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tthc2CoQuanQuanLy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTHC2CoQuanQuanLy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTHC2CoQuanQuanLy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TTHC2CoQuanQuanLyPersistenceImpl.class);
	private static TTHC2CoQuanQuanLy _nullTTHC2CoQuanQuanLy = new TTHC2CoQuanQuanLyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TTHC2CoQuanQuanLy> toCacheModel() {
				return _nullTTHC2CoQuanQuanLyCacheModel;
			}
		};

	private static CacheModel<TTHC2CoQuanQuanLy> _nullTTHC2CoQuanQuanLyCacheModel =
		new CacheModel<TTHC2CoQuanQuanLy>() {
			public TTHC2CoQuanQuanLy toEntityModel() {
				return _nullTTHC2CoQuanQuanLy;
			}
		};
}