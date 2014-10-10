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

import org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException;
import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.impl.DanhMucGiayTo2DoiTuongSuDungImpl;
import org.oep.cmon.dao.dvc.model.impl.DanhMucGiayTo2DoiTuongSuDungModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh muc giay to2 doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see DanhMucGiayTo2DoiTuongSuDungPersistence
 * @see DanhMucGiayTo2DoiTuongSuDungUtil
 * @generated
 */
public class DanhMucGiayTo2DoiTuongSuDungPersistenceImpl
	extends BasePersistenceImpl<DanhMucGiayTo2DoiTuongSuDung>
	implements DanhMucGiayTo2DoiTuongSuDungPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhMucGiayTo2DoiTuongSuDungUtil} to access the danh muc giay to2 doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhMucGiayTo2DoiTuongSuDungImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			DanhMucGiayTo2DoiTuongSuDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTrangThai", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAIDOITUONGID =
		new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByloaiDoiTuongId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIDOITUONGID =
		new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByloaiDoiTuongId",
			new String[] { Long.class.getName() },
			DanhMucGiayTo2DoiTuongSuDungModelImpl.LOAIDOITUONGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOAIDOITUONGID = new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByloaiDoiTuongId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAIGIAYTOID =
		new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByloaiGiayToId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIGIAYTOID =
		new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByloaiGiayToId",
			new String[] { Long.class.getName() },
			DanhMucGiayTo2DoiTuongSuDungModelImpl.LOAIGIAYTOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOAIGIAYTOID = new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByloaiGiayToId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the danh muc giay to2 doi tuong su dung in the entity cache if it is enabled.
	 *
	 * @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	 */
	public void cacheResult(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung) {
		EntityCacheUtil.putResult(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			danhMucGiayTo2DoiTuongSuDung.getPrimaryKey(),
			danhMucGiayTo2DoiTuongSuDung);

		danhMucGiayTo2DoiTuongSuDung.resetOriginalValues();
	}

	/**
	 * Caches the danh muc giay to2 doi tuong su dungs in the entity cache if it is enabled.
	 *
	 * @param danhMucGiayTo2DoiTuongSuDungs the danh muc giay to2 doi tuong su dungs
	 */
	public void cacheResult(
		List<DanhMucGiayTo2DoiTuongSuDung> danhMucGiayTo2DoiTuongSuDungs) {
		for (DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung : danhMucGiayTo2DoiTuongSuDungs) {
			if (EntityCacheUtil.getResult(
						DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucGiayTo2DoiTuongSuDungImpl.class,
						danhMucGiayTo2DoiTuongSuDung.getPrimaryKey()) == null) {
				cacheResult(danhMucGiayTo2DoiTuongSuDung);
			}
			else {
				danhMucGiayTo2DoiTuongSuDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh muc giay to2 doi tuong su dungs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhMucGiayTo2DoiTuongSuDungImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhMucGiayTo2DoiTuongSuDungImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh muc giay to2 doi tuong su dung.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung) {
		EntityCacheUtil.removeResult(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			danhMucGiayTo2DoiTuongSuDung.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<DanhMucGiayTo2DoiTuongSuDung> danhMucGiayTo2DoiTuongSuDungs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung : danhMucGiayTo2DoiTuongSuDungs) {
			EntityCacheUtil.removeResult(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucGiayTo2DoiTuongSuDungImpl.class,
				danhMucGiayTo2DoiTuongSuDung.getPrimaryKey());
		}
	}

	/**
	 * Creates a new danh muc giay to2 doi tuong su dung with the primary key. Does not add the danh muc giay to2 doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new danh muc giay to2 doi tuong su dung
	 * @return the new danh muc giay to2 doi tuong su dung
	 */
	public DanhMucGiayTo2DoiTuongSuDung create(long id) {
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = new DanhMucGiayTo2DoiTuongSuDungImpl();

		danhMucGiayTo2DoiTuongSuDung.setNew(true);
		danhMucGiayTo2DoiTuongSuDung.setPrimaryKey(id);

		return danhMucGiayTo2DoiTuongSuDung;
	}

	/**
	 * Removes the danh muc giay to2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc giay to2 doi tuong su dung
	 * @return the danh muc giay to2 doi tuong su dung that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung remove(long id)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the danh muc giay to2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh muc giay to2 doi tuong su dung
	 * @return the danh muc giay to2 doi tuong su dung that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucGiayTo2DoiTuongSuDung remove(Serializable primaryKey)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = (DanhMucGiayTo2DoiTuongSuDung)session.get(DanhMucGiayTo2DoiTuongSuDungImpl.class,
					primaryKey);

			if (danhMucGiayTo2DoiTuongSuDung == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhMucGiayTo2DoiTuongSuDung);
		}
		catch (NoSuchDanhMucGiayTo2DoiTuongSuDungException nsee) {
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
	protected DanhMucGiayTo2DoiTuongSuDung removeImpl(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws SystemException {
		danhMucGiayTo2DoiTuongSuDung = toUnwrappedModel(danhMucGiayTo2DoiTuongSuDung);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhMucGiayTo2DoiTuongSuDung);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhMucGiayTo2DoiTuongSuDung);

		return danhMucGiayTo2DoiTuongSuDung;
	}

	@Override
	public DanhMucGiayTo2DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		boolean merge) throws SystemException {
		danhMucGiayTo2DoiTuongSuDung = toUnwrappedModel(danhMucGiayTo2DoiTuongSuDung);

		boolean isNew = danhMucGiayTo2DoiTuongSuDung.isNew();

		DanhMucGiayTo2DoiTuongSuDungModelImpl danhMucGiayTo2DoiTuongSuDungModelImpl =
			(DanhMucGiayTo2DoiTuongSuDungModelImpl)danhMucGiayTo2DoiTuongSuDung;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhMucGiayTo2DoiTuongSuDung, merge);

			danhMucGiayTo2DoiTuongSuDung.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!DanhMucGiayTo2DoiTuongSuDungModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((danhMucGiayTo2DoiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(danhMucGiayTo2DoiTuongSuDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(danhMucGiayTo2DoiTuongSuDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((danhMucGiayTo2DoiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIDOITUONGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(danhMucGiayTo2DoiTuongSuDungModelImpl.getOriginalLoaiDoiTuongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAIDOITUONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIDOITUONGID,
					args);

				args = new Object[] {
						Long.valueOf(danhMucGiayTo2DoiTuongSuDungModelImpl.getLoaiDoiTuongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAIDOITUONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIDOITUONGID,
					args);
			}

			if ((danhMucGiayTo2DoiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIGIAYTOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(danhMucGiayTo2DoiTuongSuDungModelImpl.getOriginalLoaiGiayToId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAIGIAYTOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIGIAYTOID,
					args);

				args = new Object[] {
						Long.valueOf(danhMucGiayTo2DoiTuongSuDungModelImpl.getLoaiGiayToId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAIGIAYTOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIGIAYTOID,
					args);
			}
		}

		EntityCacheUtil.putResult(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucGiayTo2DoiTuongSuDungImpl.class,
			danhMucGiayTo2DoiTuongSuDung.getPrimaryKey(),
			danhMucGiayTo2DoiTuongSuDung);

		return danhMucGiayTo2DoiTuongSuDung;
	}

	protected DanhMucGiayTo2DoiTuongSuDung toUnwrappedModel(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung) {
		if (danhMucGiayTo2DoiTuongSuDung instanceof DanhMucGiayTo2DoiTuongSuDungImpl) {
			return danhMucGiayTo2DoiTuongSuDung;
		}

		DanhMucGiayTo2DoiTuongSuDungImpl danhMucGiayTo2DoiTuongSuDungImpl = new DanhMucGiayTo2DoiTuongSuDungImpl();

		danhMucGiayTo2DoiTuongSuDungImpl.setNew(danhMucGiayTo2DoiTuongSuDung.isNew());
		danhMucGiayTo2DoiTuongSuDungImpl.setPrimaryKey(danhMucGiayTo2DoiTuongSuDung.getPrimaryKey());

		danhMucGiayTo2DoiTuongSuDungImpl.setId(danhMucGiayTo2DoiTuongSuDung.getId());
		danhMucGiayTo2DoiTuongSuDungImpl.setNgayTao(danhMucGiayTo2DoiTuongSuDung.getNgayTao());
		danhMucGiayTo2DoiTuongSuDungImpl.setNgaySua(danhMucGiayTo2DoiTuongSuDung.getNgaySua());
		danhMucGiayTo2DoiTuongSuDungImpl.setDaXoa(danhMucGiayTo2DoiTuongSuDung.getDaXoa());
		danhMucGiayTo2DoiTuongSuDungImpl.setNguoiTao(danhMucGiayTo2DoiTuongSuDung.getNguoiTao());
		danhMucGiayTo2DoiTuongSuDungImpl.setNguoiSua(danhMucGiayTo2DoiTuongSuDung.getNguoiSua());
		danhMucGiayTo2DoiTuongSuDungImpl.setLoaiDoiTuongId(danhMucGiayTo2DoiTuongSuDung.getLoaiDoiTuongId());
		danhMucGiayTo2DoiTuongSuDungImpl.setLoaiGiayToId(danhMucGiayTo2DoiTuongSuDung.getLoaiGiayToId());
		danhMucGiayTo2DoiTuongSuDungImpl.setTrangThai(danhMucGiayTo2DoiTuongSuDung.getTrangThai());

		return danhMucGiayTo2DoiTuongSuDungImpl;
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dung with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc giay to2 doi tuong su dung
	 * @return the danh muc giay to2 doi tuong su dung
	 * @throws com.liferay.portal.NoSuchModelException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucGiayTo2DoiTuongSuDung findByPrimaryKey(
		Serializable primaryKey) throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException} if it could not be found.
	 *
	 * @param id the primary key of the danh muc giay to2 doi tuong su dung
	 * @return the danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByPrimaryKey(long id)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = fetchByPrimaryKey(id);

		if (danhMucGiayTo2DoiTuongSuDung == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return danhMucGiayTo2DoiTuongSuDung;
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc giay to2 doi tuong su dung
	 * @return the danh muc giay to2 doi tuong su dung, or <code>null</code> if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucGiayTo2DoiTuongSuDung fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc giay to2 doi tuong su dung
	 * @return the danh muc giay to2 doi tuong su dung, or <code>null</code> if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung fetchByPrimaryKey(long id)
		throws SystemException {
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = (DanhMucGiayTo2DoiTuongSuDung)EntityCacheUtil.getResult(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucGiayTo2DoiTuongSuDungImpl.class, id);

		if (danhMucGiayTo2DoiTuongSuDung == _nullDanhMucGiayTo2DoiTuongSuDung) {
			return null;
		}

		if (danhMucGiayTo2DoiTuongSuDung == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhMucGiayTo2DoiTuongSuDung = (DanhMucGiayTo2DoiTuongSuDung)session.get(DanhMucGiayTo2DoiTuongSuDungImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhMucGiayTo2DoiTuongSuDung != null) {
					cacheResult(danhMucGiayTo2DoiTuongSuDung);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhMucGiayTo2DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucGiayTo2DoiTuongSuDungImpl.class, id,
						_nullDanhMucGiayTo2DoiTuongSuDung);
				}

				closeSession(session);
			}
		}

		return danhMucGiayTo2DoiTuongSuDung;
	}

	/**
	 * Returns all the danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @return the range of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByTrangThai(int daXoa,
		int start, int end) throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByTrangThai(int daXoa,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<DanhMucGiayTo2DoiTuongSuDung> list = (List<DanhMucGiayTo2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<DanhMucGiayTo2DoiTuongSuDung>)QueryUtil.list(q,
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
	 * Returns the first danh muc giay to2 doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		List<DanhMucGiayTo2DoiTuongSuDung> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last danh muc giay to2 doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		int count = countByTrangThai(daXoa);

		List<DanhMucGiayTo2DoiTuongSuDung> list = findByTrangThai(daXoa,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dungs before and after the current danh muc giay to2 doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current danh muc giay to2 doi tuong su dung
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung[] findByTrangThai_PrevAndNext(long id,
		int daXoa, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMucGiayTo2DoiTuongSuDung[] array = new DanhMucGiayTo2DoiTuongSuDungImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session,
					danhMucGiayTo2DoiTuongSuDung, daXoa, orderByComparator, true);

			array[1] = danhMucGiayTo2DoiTuongSuDung;

			array[2] = getByTrangThai_PrevAndNext(session,
					danhMucGiayTo2DoiTuongSuDung, daXoa, orderByComparator,
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

	protected DanhMucGiayTo2DoiTuongSuDung getByTrangThai_PrevAndNext(
		Session session,
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

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
			query.append(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(danhMucGiayTo2DoiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DanhMucGiayTo2DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @return the matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByloaiDoiTuongId(
		long loaiDoiTuongId) throws SystemException {
		return findByloaiDoiTuongId(loaiDoiTuongId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @return the range of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByloaiDoiTuongId(
		long loaiDoiTuongId, int start, int end) throws SystemException {
		return findByloaiDoiTuongId(loaiDoiTuongId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByloaiDoiTuongId(
		long loaiDoiTuongId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIDOITUONGID;
			finderArgs = new Object[] { loaiDoiTuongId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAIDOITUONGID;
			finderArgs = new Object[] {
					loaiDoiTuongId,
					
					start, end, orderByComparator
				};
		}

		List<DanhMucGiayTo2DoiTuongSuDung> list = (List<DanhMucGiayTo2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_LOAIDOITUONGID_LOAIDOITUONGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiDoiTuongId);

				list = (List<DanhMucGiayTo2DoiTuongSuDung>)QueryUtil.list(q,
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
	 * Returns the first danh muc giay to2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByloaiDoiTuongId_First(
		long loaiDoiTuongId, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		List<DanhMucGiayTo2DoiTuongSuDung> list = findByloaiDoiTuongId(loaiDoiTuongId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiDoiTuongId=");
			msg.append(loaiDoiTuongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last danh muc giay to2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByloaiDoiTuongId_Last(
		long loaiDoiTuongId, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		int count = countByloaiDoiTuongId(loaiDoiTuongId);

		List<DanhMucGiayTo2DoiTuongSuDung> list = findByloaiDoiTuongId(loaiDoiTuongId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiDoiTuongId=");
			msg.append(loaiDoiTuongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dungs before and after the current danh muc giay to2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current danh muc giay to2 doi tuong su dung
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung[] findByloaiDoiTuongId_PrevAndNext(
		long id, long loaiDoiTuongId, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMucGiayTo2DoiTuongSuDung[] array = new DanhMucGiayTo2DoiTuongSuDungImpl[3];

			array[0] = getByloaiDoiTuongId_PrevAndNext(session,
					danhMucGiayTo2DoiTuongSuDung, loaiDoiTuongId,
					orderByComparator, true);

			array[1] = danhMucGiayTo2DoiTuongSuDung;

			array[2] = getByloaiDoiTuongId_PrevAndNext(session,
					danhMucGiayTo2DoiTuongSuDung, loaiDoiTuongId,
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

	protected DanhMucGiayTo2DoiTuongSuDung getByloaiDoiTuongId_PrevAndNext(
		Session session,
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		long loaiDoiTuongId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

		query.append(_FINDER_COLUMN_LOAIDOITUONGID_LOAIDOITUONGID_2);

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
			query.append(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiDoiTuongId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(danhMucGiayTo2DoiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DanhMucGiayTo2DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @return the matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByloaiGiayToId(
		long loaiGiayToId) throws SystemException {
		return findByloaiGiayToId(loaiGiayToId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @return the range of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByloaiGiayToId(
		long loaiGiayToId, int start, int end) throws SystemException {
		return findByloaiGiayToId(loaiGiayToId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findByloaiGiayToId(
		long loaiGiayToId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIGIAYTOID;
			finderArgs = new Object[] { loaiGiayToId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAIGIAYTOID;
			finderArgs = new Object[] {
					loaiGiayToId,
					
					start, end, orderByComparator
				};
		}

		List<DanhMucGiayTo2DoiTuongSuDung> list = (List<DanhMucGiayTo2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_LOAIGIAYTOID_LOAIGIAYTOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiGiayToId);

				list = (List<DanhMucGiayTo2DoiTuongSuDung>)QueryUtil.list(q,
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
	 * Returns the first danh muc giay to2 doi tuong su dung in the ordered set where loaiGiayToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByloaiGiayToId_First(
		long loaiGiayToId, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		List<DanhMucGiayTo2DoiTuongSuDung> list = findByloaiGiayToId(loaiGiayToId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiGiayToId=");
			msg.append(loaiGiayToId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last danh muc giay to2 doi tuong su dung in the ordered set where loaiGiayToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung findByloaiGiayToId_Last(
		long loaiGiayToId, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		int count = countByloaiGiayToId(loaiGiayToId);

		List<DanhMucGiayTo2DoiTuongSuDung> list = findByloaiGiayToId(loaiGiayToId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiGiayToId=");
			msg.append(loaiGiayToId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucGiayTo2DoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the danh muc giay to2 doi tuong su dungs before and after the current danh muc giay to2 doi tuong su dung in the ordered set where loaiGiayToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current danh muc giay to2 doi tuong su dung
	 * @param loaiGiayToId the loai giay to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc giay to2 doi tuong su dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucGiayTo2DoiTuongSuDung[] findByloaiGiayToId_PrevAndNext(
		long id, long loaiGiayToId, OrderByComparator orderByComparator)
		throws NoSuchDanhMucGiayTo2DoiTuongSuDungException, SystemException {
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMucGiayTo2DoiTuongSuDung[] array = new DanhMucGiayTo2DoiTuongSuDungImpl[3];

			array[0] = getByloaiGiayToId_PrevAndNext(session,
					danhMucGiayTo2DoiTuongSuDung, loaiGiayToId,
					orderByComparator, true);

			array[1] = danhMucGiayTo2DoiTuongSuDung;

			array[2] = getByloaiGiayToId_PrevAndNext(session,
					danhMucGiayTo2DoiTuongSuDung, loaiGiayToId,
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

	protected DanhMucGiayTo2DoiTuongSuDung getByloaiGiayToId_PrevAndNext(
		Session session,
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		long loaiGiayToId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

		query.append(_FINDER_COLUMN_LOAIGIAYTOID_LOAIGIAYTOID_2);

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
			query.append(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiGiayToId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(danhMucGiayTo2DoiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DanhMucGiayTo2DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the danh muc giay to2 doi tuong su dungs.
	 *
	 * @return the danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc giay to2 doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @return the range of danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc giay to2 doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	 * @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucGiayTo2DoiTuongSuDung> findAll(int start, int end,
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

		List<DanhMucGiayTo2DoiTuongSuDung> list = (List<DanhMucGiayTo2DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG.concat(DanhMucGiayTo2DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhMucGiayTo2DoiTuongSuDung>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhMucGiayTo2DoiTuongSuDung>)QueryUtil.list(q,
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
	 * Removes all the danh muc giay to2 doi tuong su dungs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung : findByTrangThai(
				daXoa)) {
			remove(danhMucGiayTo2DoiTuongSuDung);
		}
	}

	/**
	 * Removes all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63; from the database.
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByloaiDoiTuongId(long loaiDoiTuongId)
		throws SystemException {
		for (DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung : findByloaiDoiTuongId(
				loaiDoiTuongId)) {
			remove(danhMucGiayTo2DoiTuongSuDung);
		}
	}

	/**
	 * Removes all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63; from the database.
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByloaiGiayToId(long loaiGiayToId)
		throws SystemException {
		for (DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung : findByloaiGiayToId(
				loaiGiayToId)) {
			remove(danhMucGiayTo2DoiTuongSuDung);
		}
	}

	/**
	 * Removes all the danh muc giay to2 doi tuong su dungs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung : findAll()) {
			remove(danhMucGiayTo2DoiTuongSuDung);
		}
	}

	/**
	 * Returns the number of danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

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
	 * Returns the number of danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	 *
	 * @param loaiDoiTuongId the loai doi tuong ID
	 * @return the number of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByloaiDoiTuongId(long loaiDoiTuongId)
		throws SystemException {
		Object[] finderArgs = new Object[] { loaiDoiTuongId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAIDOITUONGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_LOAIDOITUONGID_LOAIDOITUONGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiDoiTuongId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAIDOITUONGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	 *
	 * @param loaiGiayToId the loai giay to ID
	 * @return the number of matching danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByloaiGiayToId(long loaiGiayToId) throws SystemException {
		Object[] finderArgs = new Object[] { loaiGiayToId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAIGIAYTOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_LOAIGIAYTOID_LOAIGIAYTOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiGiayToId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAIGIAYTOID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of danh muc giay to2 doi tuong su dungs.
	 *
	 * @return the number of danh muc giay to2 doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHMUCGIAYTO2DOITUONGSUDUNG);

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
	 * Initializes the danh muc giay to2 doi tuong su dung persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhMucGiayTo2DoiTuongSuDung>> listenersList = new ArrayList<ModelListener<DanhMucGiayTo2DoiTuongSuDung>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhMucGiayTo2DoiTuongSuDung>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhMucGiayTo2DoiTuongSuDungImpl.class.getName());
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
	private static final String _SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG = "SELECT danhMucGiayTo2DoiTuongSuDung FROM DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung";
	private static final String _SQL_SELECT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE = "SELECT danhMucGiayTo2DoiTuongSuDung FROM DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung WHERE ";
	private static final String _SQL_COUNT_DANHMUCGIAYTO2DOITUONGSUDUNG = "SELECT COUNT(danhMucGiayTo2DoiTuongSuDung) FROM DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung";
	private static final String _SQL_COUNT_DANHMUCGIAYTO2DOITUONGSUDUNG_WHERE = "SELECT COUNT(danhMucGiayTo2DoiTuongSuDung) FROM DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "danhMucGiayTo2DoiTuongSuDung.daXoa = ?";
	private static final String _FINDER_COLUMN_LOAIDOITUONGID_LOAIDOITUONGID_2 = "danhMucGiayTo2DoiTuongSuDung.loaiDoiTuongId = ?";
	private static final String _FINDER_COLUMN_LOAIGIAYTOID_LOAIGIAYTOID_2 = "danhMucGiayTo2DoiTuongSuDung.loaiGiayToId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhMucGiayTo2DoiTuongSuDung.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhMucGiayTo2DoiTuongSuDung exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DanhMucGiayTo2DoiTuongSuDung exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhMucGiayTo2DoiTuongSuDungPersistenceImpl.class);
	private static DanhMucGiayTo2DoiTuongSuDung _nullDanhMucGiayTo2DoiTuongSuDung =
		new DanhMucGiayTo2DoiTuongSuDungImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhMucGiayTo2DoiTuongSuDung> toCacheModel() {
				return _nullDanhMucGiayTo2DoiTuongSuDungCacheModel;
			}
		};

	private static CacheModel<DanhMucGiayTo2DoiTuongSuDung> _nullDanhMucGiayTo2DoiTuongSuDungCacheModel =
		new CacheModel<DanhMucGiayTo2DoiTuongSuDung>() {
			public DanhMucGiayTo2DoiTuongSuDung toEntityModel() {
				return _nullDanhMucGiayTo2DoiTuongSuDung;
			}
		};
}