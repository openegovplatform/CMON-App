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

import org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;
import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.impl.TTHC2DoiTuongSuDungImpl;
import org.oep.cmon.dao.dvc.model.impl.TTHC2DoiTuongSuDungModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t t h c2 doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see TTHC2DoiTuongSuDungPersistence
 * @see TTHC2DoiTuongSuDungUtil
 * @generated
 */
public class TTHC2DoiTuongSuDungPersistenceImpl extends BasePersistenceImpl<TTHC2DoiTuongSuDung>
	implements TTHC2DoiTuongSuDungPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTHC2DoiTuongSuDungUtil} to access the t t h c2 doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTHC2DoiTuongSuDungImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			TTHC2DoiTuongSuDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHID =
		new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThuTucHanhChinhId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID =
		new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTucHanhChinhId", new String[] { Long.class.getName() },
			TTHC2DoiTuongSuDungModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID = new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTucHanhChinhId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TT2LOAIDOITUONG =
		new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTT2LoaiDoiTuong",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TT2LOAIDOITUONG =
		new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTT2LoaiDoiTuong",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TTHC2DoiTuongSuDungModelImpl.LOAIDOITUONGID_COLUMN_BITMASK |
			TTHC2DoiTuongSuDungModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			TTHC2DoiTuongSuDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TT2LOAIDOITUONG = new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTT2LoaiDoiTuong",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the t t h c2 doi tuong su dung in the entity cache if it is enabled.
	 *
	 * @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	 */
	public void cacheResult(TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		EntityCacheUtil.putResult(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class, tthc2DoiTuongSuDung.getPrimaryKey(),
			tthc2DoiTuongSuDung);

		tthc2DoiTuongSuDung.resetOriginalValues();
	}

	/**
	 * Caches the t t h c2 doi tuong su dungs in the entity cache if it is enabled.
	 *
	 * @param tthc2DoiTuongSuDungs the t t h c2 doi tuong su dungs
	 */
	public void cacheResult(List<TTHC2DoiTuongSuDung> tthc2DoiTuongSuDungs) {
		for (TTHC2DoiTuongSuDung tthc2DoiTuongSuDung : tthc2DoiTuongSuDungs) {
			if (EntityCacheUtil.getResult(
						TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						TTHC2DoiTuongSuDungImpl.class,
						tthc2DoiTuongSuDung.getPrimaryKey()) == null) {
				cacheResult(tthc2DoiTuongSuDung);
			}
			else {
				tthc2DoiTuongSuDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t t h c2 doi tuong su dungs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TTHC2DoiTuongSuDungImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TTHC2DoiTuongSuDungImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t t h c2 doi tuong su dung.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		EntityCacheUtil.removeResult(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class, tthc2DoiTuongSuDung.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TTHC2DoiTuongSuDung> tthc2DoiTuongSuDungs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTHC2DoiTuongSuDung tthc2DoiTuongSuDung : tthc2DoiTuongSuDungs) {
			EntityCacheUtil.removeResult(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				TTHC2DoiTuongSuDungImpl.class,
				tthc2DoiTuongSuDung.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t t h c2 doi tuong su dung with the primary key. Does not add the t t h c2 doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new t t h c2 doi tuong su dung
	 * @return the new t t h c2 doi tuong su dung
	 */
	public TTHC2DoiTuongSuDung create(long id) {
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = new TTHC2DoiTuongSuDungImpl();

		tthc2DoiTuongSuDung.setNew(true);
		tthc2DoiTuongSuDung.setPrimaryKey(id);

		return tthc2DoiTuongSuDung;
	}

	/**
	 * Removes the t t h c2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the t t h c2 doi tuong su dung
	 * @return the t t h c2 doi tuong su dung that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung remove(long id)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the t t h c2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t t h c2 doi tuong su dung
	 * @return the t t h c2 doi tuong su dung that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC2DoiTuongSuDung remove(Serializable primaryKey)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = (TTHC2DoiTuongSuDung)session.get(TTHC2DoiTuongSuDungImpl.class,
					primaryKey);

			if (tthc2DoiTuongSuDung == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTHC2DoiTuongSuDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tthc2DoiTuongSuDung);
		}
		catch (NoSuchTTHC2DoiTuongSuDungException nsee) {
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
	protected TTHC2DoiTuongSuDung removeImpl(
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) throws SystemException {
		tthc2DoiTuongSuDung = toUnwrappedModel(tthc2DoiTuongSuDung);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tthc2DoiTuongSuDung);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tthc2DoiTuongSuDung);

		return tthc2DoiTuongSuDung;
	}

	@Override
	public TTHC2DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		boolean merge) throws SystemException {
		tthc2DoiTuongSuDung = toUnwrappedModel(tthc2DoiTuongSuDung);

		boolean isNew = tthc2DoiTuongSuDung.isNew();

		TTHC2DoiTuongSuDungModelImpl tthc2DoiTuongSuDungModelImpl = (TTHC2DoiTuongSuDungModelImpl)tthc2DoiTuongSuDung;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tthc2DoiTuongSuDung, merge);

			tthc2DoiTuongSuDung.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TTHC2DoiTuongSuDungModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tthc2DoiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(tthc2DoiTuongSuDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(tthc2DoiTuongSuDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((tthc2DoiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc2DoiTuongSuDungModelImpl.getOriginalThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID,
					args);

				args = new Object[] {
						Long.valueOf(tthc2DoiTuongSuDungModelImpl.getThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID,
					args);
			}

			if ((tthc2DoiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TT2LOAIDOITUONG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc2DoiTuongSuDungModelImpl.getOriginalLoaiDoiTuongId()),
						Long.valueOf(tthc2DoiTuongSuDungModelImpl.getOriginalThuTucHanhChinhId()),
						Integer.valueOf(tthc2DoiTuongSuDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TT2LOAIDOITUONG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TT2LOAIDOITUONG,
					args);

				args = new Object[] {
						Long.valueOf(tthc2DoiTuongSuDungModelImpl.getLoaiDoiTuongId()),
						Long.valueOf(tthc2DoiTuongSuDungModelImpl.getThuTucHanhChinhId()),
						Integer.valueOf(tthc2DoiTuongSuDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TT2LOAIDOITUONG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TT2LOAIDOITUONG,
					args);
			}
		}

		EntityCacheUtil.putResult(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			TTHC2DoiTuongSuDungImpl.class, tthc2DoiTuongSuDung.getPrimaryKey(),
			tthc2DoiTuongSuDung);

		return tthc2DoiTuongSuDung;
	}

	protected TTHC2DoiTuongSuDung toUnwrappedModel(
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		if (tthc2DoiTuongSuDung instanceof TTHC2DoiTuongSuDungImpl) {
			return tthc2DoiTuongSuDung;
		}

		TTHC2DoiTuongSuDungImpl tthc2DoiTuongSuDungImpl = new TTHC2DoiTuongSuDungImpl();

		tthc2DoiTuongSuDungImpl.setNew(tthc2DoiTuongSuDung.isNew());
		tthc2DoiTuongSuDungImpl.setPrimaryKey(tthc2DoiTuongSuDung.getPrimaryKey());

		tthc2DoiTuongSuDungImpl.setId(tthc2DoiTuongSuDung.getId());
		tthc2DoiTuongSuDungImpl.setNgayTao(tthc2DoiTuongSuDung.getNgayTao());
		tthc2DoiTuongSuDungImpl.setNgaySua(tthc2DoiTuongSuDung.getNgaySua());
		tthc2DoiTuongSuDungImpl.setDaXoa(tthc2DoiTuongSuDung.getDaXoa());
		tthc2DoiTuongSuDungImpl.setNguoiTao(tthc2DoiTuongSuDung.getNguoiTao());
		tthc2DoiTuongSuDungImpl.setNguoiSua(tthc2DoiTuongSuDung.getNguoiSua());
		tthc2DoiTuongSuDungImpl.setThuTucHanhChinhId(tthc2DoiTuongSuDung.getThuTucHanhChinhId());
		tthc2DoiTuongSuDungImpl.setLoaiDoiTuongId(tthc2DoiTuongSuDung.getLoaiDoiTuongId());
		tthc2DoiTuongSuDungImpl.setTrangThai(tthc2DoiTuongSuDung.getTrangThai());

		return tthc2DoiTuongSuDungImpl;
	}

	/**
	 * Returns the t t h c2 doi tuong su dung with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c2 doi tuong su dung
	 * @return the t t h c2 doi tuong su dung
	 * @throws com.liferay.portal.NoSuchModelException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC2DoiTuongSuDung findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c2 doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException} if it could not be found.
	 *
	 * @param id the primary key of the t t h c2 doi tuong su dung
	 * @return the t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByPrimaryKey(long id)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = fetchByPrimaryKey(id);

		if (tthc2DoiTuongSuDung == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTTHC2DoiTuongSuDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tthc2DoiTuongSuDung;
	}

	/**
	 * Returns the t t h c2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c2 doi tuong su dung
	 * @return the t t h c2 doi tuong su dung, or <code>null</code> if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC2DoiTuongSuDung fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the t t h c2 doi tuong su dung
	 * @return the t t h c2 doi tuong su dung, or <code>null</code> if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung fetchByPrimaryKey(long id)
		throws SystemException {
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = (TTHC2DoiTuongSuDung)EntityCacheUtil.getResult(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				TTHC2DoiTuongSuDungImpl.class, id);

		if (tthc2DoiTuongSuDung == _nullTTHC2DoiTuongSuDung) {
			return null;
		}

		if (tthc2DoiTuongSuDung == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tthc2DoiTuongSuDung = (TTHC2DoiTuongSuDung)session.get(TTHC2DoiTuongSuDungImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tthc2DoiTuongSuDung != null) {
					cacheResult(tthc2DoiTuongSuDung);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TTHC2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						TTHC2DoiTuongSuDungImpl.class, id,
						_nullTTHC2DoiTuongSuDung);
				}

				closeSession(session);
			}
		}

		return tthc2DoiTuongSuDung;
	}

	/**
	 * Returns all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @return the range of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByTrangThai(int daXoa, int start,
		int end) throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByTrangThai(int daXoa, int start,
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

		List<TTHC2DoiTuongSuDung> list = (List<TTHC2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TTHC2DoiTuongSuDung>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		List<TTHC2DoiTuongSuDung> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		int count = countByTrangThai(daXoa);

		List<TTHC2DoiTuongSuDung> list = findByTrangThai(daXoa, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 doi tuong su dung
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung[] findByTrangThai_PrevAndNext(long id,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2DoiTuongSuDung[] array = new TTHC2DoiTuongSuDungImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, tthc2DoiTuongSuDung,
					daXoa, orderByComparator, true);

			array[1] = tthc2DoiTuongSuDung;

			array[2] = getByTrangThai_PrevAndNext(session, tthc2DoiTuongSuDung,
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

	protected TTHC2DoiTuongSuDung getByTrangThai_PrevAndNext(Session session,
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE);

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
			query.append(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2DoiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId) throws SystemException {
		return findByThuTucHanhChinhId(thuTucHanhChinhId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @return the range of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end) throws SystemException {
		return findByThuTucHanhChinhId(thuTucHanhChinhId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID;
			finderArgs = new Object[] { thuTucHanhChinhId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHID;
			finderArgs = new Object[] {
					thuTucHanhChinhId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC2DoiTuongSuDung> list = (List<TTHC2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				list = (List<TTHC2DoiTuongSuDung>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		List<TTHC2DoiTuongSuDung> list = findByThuTucHanhChinhId(thuTucHanhChinhId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		int count = countByThuTucHanhChinhId(thuTucHanhChinhId);

		List<TTHC2DoiTuongSuDung> list = findByThuTucHanhChinhId(thuTucHanhChinhId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 doi tuong su dung
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung[] findByThuTucHanhChinhId_PrevAndNext(long id,
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2DoiTuongSuDung[] array = new TTHC2DoiTuongSuDungImpl[3];

			array[0] = getByThuTucHanhChinhId_PrevAndNext(session,
					tthc2DoiTuongSuDung, thuTucHanhChinhId, orderByComparator,
					true);

			array[1] = tthc2DoiTuongSuDung;

			array[2] = getByThuTucHanhChinhId_PrevAndNext(session,
					tthc2DoiTuongSuDung, thuTucHanhChinhId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC2DoiTuongSuDung getByThuTucHanhChinhId_PrevAndNext(
		Session session, TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		long thuTucHanhChinhId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

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
			query.append(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2DoiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa)
		throws SystemException {
		return findByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @return the range of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa, int start,
		int end) throws SystemException {
		return findByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId, daXoa,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TT2LOAIDOITUONG;
			finderArgs = new Object[] { loaiDoiTuongId, thuTucHanhChinhId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TT2LOAIDOITUONG;
			finderArgs = new Object[] {
					loaiDoiTuongId, thuTucHanhChinhId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<TTHC2DoiTuongSuDung> list = (List<TTHC2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_LOAIDOITUONGID_2);

			query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiDoiTuongId);

				qPos.add(thuTucHanhChinhId);

				qPos.add(daXoa);

				list = (List<TTHC2DoiTuongSuDung>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByTT2LoaiDoiTuong_First(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		List<TTHC2DoiTuongSuDung> list = findByTT2LoaiDoiTuong(loaiDoiTuongId,
				thuTucHanhChinhId, daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiDoiTuongId=");
			msg.append(loaiDoiTuongId);

			msg.append(", thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung findByTT2LoaiDoiTuong_Last(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		int count = countByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId,
				daXoa);

		List<TTHC2DoiTuongSuDung> list = findByTT2LoaiDoiTuong(loaiDoiTuongId,
				thuTucHanhChinhId, daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiDoiTuongId=");
			msg.append(loaiDoiTuongId);

			msg.append(", thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTTHC2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t t h c2 doi tuong su dung
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC2DoiTuongSuDung[] findByTT2LoaiDoiTuong_PrevAndNext(long id,
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC2DoiTuongSuDungException, SystemException {
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TTHC2DoiTuongSuDung[] array = new TTHC2DoiTuongSuDungImpl[3];

			array[0] = getByTT2LoaiDoiTuong_PrevAndNext(session,
					tthc2DoiTuongSuDung, loaiDoiTuongId, thuTucHanhChinhId,
					daXoa, orderByComparator, true);

			array[1] = tthc2DoiTuongSuDung;

			array[2] = getByTT2LoaiDoiTuong_PrevAndNext(session,
					tthc2DoiTuongSuDung, loaiDoiTuongId, thuTucHanhChinhId,
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

	protected TTHC2DoiTuongSuDung getByTT2LoaiDoiTuong_PrevAndNext(
		Session session, TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE);

		query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_LOAIDOITUONGID_2);

		query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_DAXOA_2);

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
			query.append(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiDoiTuongId);

		qPos.add(thuTucHanhChinhId);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc2DoiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC2DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c2 doi tuong su dungs.
	 *
	 * @return the t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c2 doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @return the range of t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c2 doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c2 doi tuong su dungs
	 * @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC2DoiTuongSuDung> findAll(int start, int end,
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

		List<TTHC2DoiTuongSuDung> list = (List<TTHC2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TTHC2DOITUONGSUDUNG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTHC2DOITUONGSUDUNG.concat(TTHC2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TTHC2DoiTuongSuDung>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TTHC2DoiTuongSuDung>)QueryUtil.list(q,
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
	 * Removes all the t t h c2 doi tuong su dungs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (TTHC2DoiTuongSuDung tthc2DoiTuongSuDung : findByTrangThai(daXoa)) {
			remove(tthc2DoiTuongSuDung);
		}
	}

	/**
	 * Removes all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws SystemException {
		for (TTHC2DoiTuongSuDung tthc2DoiTuongSuDung : findByThuTucHanhChinhId(
				thuTucHanhChinhId)) {
			remove(tthc2DoiTuongSuDung);
		}
	}

	/**
	 * Removes all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTT2LoaiDoiTuong(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa) throws SystemException {
		for (TTHC2DoiTuongSuDung tthc2DoiTuongSuDung : findByTT2LoaiDoiTuong(
				loaiDoiTuongId, thuTucHanhChinhId, daXoa)) {
			remove(tthc2DoiTuongSuDung);
		}
	}

	/**
	 * Removes all the t t h c2 doi tuong su dungs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TTHC2DoiTuongSuDung tthc2DoiTuongSuDung : findAll()) {
			remove(tthc2DoiTuongSuDung);
		}
	}

	/**
	 * Returns the number of t t h c2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC2DOITUONGSUDUNG_WHERE);

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
	 * Returns the number of t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the number of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the number of matching t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTT2LoaiDoiTuong(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] {
				loaiDoiTuongId, thuTucHanhChinhId, daXoa
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TT2LOAIDOITUONG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTHC2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_LOAIDOITUONGID_2);

			query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_TT2LOAIDOITUONG_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiDoiTuongId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TT2LOAIDOITUONG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c2 doi tuong su dungs.
	 *
	 * @return the number of t t h c2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTHC2DOITUONGSUDUNG);

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
	 * Initializes the t t h c2 doi tuong su dung persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TTHC2DoiTuongSuDung>> listenersList = new ArrayList<ModelListener<TTHC2DoiTuongSuDung>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TTHC2DoiTuongSuDung>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TTHC2DoiTuongSuDungImpl.class.getName());
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
	private static final String _SQL_SELECT_TTHC2DOITUONGSUDUNG = "SELECT tthc2DoiTuongSuDung FROM TTHC2DoiTuongSuDung tthc2DoiTuongSuDung";
	private static final String _SQL_SELECT_TTHC2DOITUONGSUDUNG_WHERE = "SELECT tthc2DoiTuongSuDung FROM TTHC2DoiTuongSuDung tthc2DoiTuongSuDung WHERE ";
	private static final String _SQL_COUNT_TTHC2DOITUONGSUDUNG = "SELECT COUNT(tthc2DoiTuongSuDung) FROM TTHC2DoiTuongSuDung tthc2DoiTuongSuDung";
	private static final String _SQL_COUNT_TTHC2DOITUONGSUDUNG_WHERE = "SELECT COUNT(tthc2DoiTuongSuDung) FROM TTHC2DoiTuongSuDung tthc2DoiTuongSuDung WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "tthc2DoiTuongSuDung.daXoa = ?";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2 =
		"tthc2DoiTuongSuDung.thuTucHanhChinhId = ?";
	private static final String _FINDER_COLUMN_TT2LOAIDOITUONG_LOAIDOITUONGID_2 = "tthc2DoiTuongSuDung.loaiDoiTuongId = ? AND ";
	private static final String _FINDER_COLUMN_TT2LOAIDOITUONG_THUTUCHANHCHINHID_2 =
		"tthc2DoiTuongSuDung.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_TT2LOAIDOITUONG_DAXOA_2 = "tthc2DoiTuongSuDung.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tthc2DoiTuongSuDung.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTHC2DoiTuongSuDung exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTHC2DoiTuongSuDung exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TTHC2DoiTuongSuDungPersistenceImpl.class);
	private static TTHC2DoiTuongSuDung _nullTTHC2DoiTuongSuDung = new TTHC2DoiTuongSuDungImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TTHC2DoiTuongSuDung> toCacheModel() {
				return _nullTTHC2DoiTuongSuDungCacheModel;
			}
		};

	private static CacheModel<TTHC2DoiTuongSuDung> _nullTTHC2DoiTuongSuDungCacheModel =
		new CacheModel<TTHC2DoiTuongSuDung>() {
			public TTHC2DoiTuongSuDung toEntityModel() {
				return _nullTTHC2DoiTuongSuDung;
			}
		};
}