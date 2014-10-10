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

import org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;
import org.oep.cmon.dao.dvc.model.VanBanHuongDan;
import org.oep.cmon.dao.dvc.model.impl.VanBanHuongDanImpl;
import org.oep.cmon.dao.dvc.model.impl.VanBanHuongDanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the van ban huong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see VanBanHuongDanPersistence
 * @see VanBanHuongDanUtil
 * @generated
 */
public class VanBanHuongDanPersistenceImpl extends BasePersistenceImpl<VanBanHuongDan>
	implements VanBanHuongDanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VanBanHuongDanUtil} to access the van ban huong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VanBanHuongDanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOILUUTRUID =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNoiLuuTruId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOILUUTRUID =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNoiLuuTruId",
			new String[] { Long.class.getName() },
			VanBanHuongDanModelImpl.NOILUUTRUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOILUUTRUID = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNoiLuuTruId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TENTAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTenTaiLieu",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTenTaiLieu",
			new String[] { String.class.getName() },
			VanBanHuongDanModelImpl.TENTAILIEU_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENTAILIEU = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTenTaiLieu",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAITAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLoaiTaiLieu",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAITAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoaiTaiLieu",
			new String[] { Long.class.getName() },
			VanBanHuongDanModelImpl.LOAITAILIEU_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOAITAILIEU = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoaiTaiLieu",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHID =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThuTucHanhChinhId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTucHanhChinhId", new String[] { Long.class.getName() },
			VanBanHuongDanModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTucHanhChinhId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			VanBanHuongDanModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			VanBanHuongDanModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			VanBanHuongDanModelImpl.LOAITAILIEU_COLUMN_BITMASK |
			VanBanHuongDanModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThuTucHanhChinhIdAndLoaiTaiLieu",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThuTucHanhChinhIdAndLoaiTaiLieu",
			new String[] { Long.class.getName(), Long.class.getName() },
			VanBanHuongDanModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			VanBanHuongDanModelImpl.LOAITAILIEU_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEU =
		new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThuTucHanhChinhIdAndLoaiTaiLieu",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED,
			VanBanHuongDanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the van ban huong dan in the entity cache if it is enabled.
	 *
	 * @param vanBanHuongDan the van ban huong dan
	 */
	public void cacheResult(VanBanHuongDan vanBanHuongDan) {
		EntityCacheUtil.putResult(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanImpl.class, vanBanHuongDan.getPrimaryKey(),
			vanBanHuongDan);

		vanBanHuongDan.resetOriginalValues();
	}

	/**
	 * Caches the van ban huong dans in the entity cache if it is enabled.
	 *
	 * @param vanBanHuongDans the van ban huong dans
	 */
	public void cacheResult(List<VanBanHuongDan> vanBanHuongDans) {
		for (VanBanHuongDan vanBanHuongDan : vanBanHuongDans) {
			if (EntityCacheUtil.getResult(
						VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
						VanBanHuongDanImpl.class, vanBanHuongDan.getPrimaryKey()) == null) {
				cacheResult(vanBanHuongDan);
			}
			else {
				vanBanHuongDan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all van ban huong dans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VanBanHuongDanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VanBanHuongDanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the van ban huong dan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VanBanHuongDan vanBanHuongDan) {
		EntityCacheUtil.removeResult(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanImpl.class, vanBanHuongDan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VanBanHuongDan> vanBanHuongDans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VanBanHuongDan vanBanHuongDan : vanBanHuongDans) {
			EntityCacheUtil.removeResult(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
				VanBanHuongDanImpl.class, vanBanHuongDan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new van ban huong dan with the primary key. Does not add the van ban huong dan to the database.
	 *
	 * @param id the primary key for the new van ban huong dan
	 * @return the new van ban huong dan
	 */
	public VanBanHuongDan create(long id) {
		VanBanHuongDan vanBanHuongDan = new VanBanHuongDanImpl();

		vanBanHuongDan.setNew(true);
		vanBanHuongDan.setPrimaryKey(id);

		return vanBanHuongDan;
	}

	/**
	 * Removes the van ban huong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the van ban huong dan
	 * @return the van ban huong dan that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan remove(long id)
		throws NoSuchVanBanHuongDanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the van ban huong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the van ban huong dan
	 * @return the van ban huong dan that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanHuongDan remove(Serializable primaryKey)
		throws NoSuchVanBanHuongDanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan vanBanHuongDan = (VanBanHuongDan)session.get(VanBanHuongDanImpl.class,
					primaryKey);

			if (vanBanHuongDan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVanBanHuongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vanBanHuongDan);
		}
		catch (NoSuchVanBanHuongDanException nsee) {
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
	protected VanBanHuongDan removeImpl(VanBanHuongDan vanBanHuongDan)
		throws SystemException {
		vanBanHuongDan = toUnwrappedModel(vanBanHuongDan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vanBanHuongDan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vanBanHuongDan);

		return vanBanHuongDan;
	}

	@Override
	public VanBanHuongDan updateImpl(
		org.oep.cmon.dao.dvc.model.VanBanHuongDan vanBanHuongDan, boolean merge)
		throws SystemException {
		vanBanHuongDan = toUnwrappedModel(vanBanHuongDan);

		boolean isNew = vanBanHuongDan.isNew();

		VanBanHuongDanModelImpl vanBanHuongDanModelImpl = (VanBanHuongDanModelImpl)vanBanHuongDan;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vanBanHuongDan, merge);

			vanBanHuongDan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VanBanHuongDanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOILUUTRUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalNoiLuuTruId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOILUUTRUID,
					args);

				args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getNoiLuuTruId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOILUUTRUID,
					args);
			}

			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTAILIEU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vanBanHuongDanModelImpl.getOriginalTenTaiLieu()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENTAILIEU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTAILIEU,
					args);

				args = new Object[] { vanBanHuongDanModelImpl.getTenTaiLieu() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENTAILIEU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTAILIEU,
					args);
			}

			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAITAILIEU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalLoaiTaiLieu())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAITAILIEU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAITAILIEU,
					args);

				args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getLoaiTaiLieu())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAITAILIEU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAITAILIEU,
					args);
			}

			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID,
					args);

				args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHID,
					args);
			}

			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(vanBanHuongDanModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(vanBanHuongDanModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalThuTucHanhChinhId()),
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalLoaiTaiLieu()),
						Integer.valueOf(vanBanHuongDanModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA,
					args);

				args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getThuTucHanhChinhId()),
						Long.valueOf(vanBanHuongDanModelImpl.getLoaiTaiLieu()),
						Integer.valueOf(vanBanHuongDanModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA,
					args);
			}

			if ((vanBanHuongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalThuTucHanhChinhId()),
						Long.valueOf(vanBanHuongDanModelImpl.getOriginalLoaiTaiLieu())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU,
					args);

				args = new Object[] {
						Long.valueOf(vanBanHuongDanModelImpl.getThuTucHanhChinhId()),
						Long.valueOf(vanBanHuongDanModelImpl.getLoaiTaiLieu())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU,
					args);
			}
		}

		EntityCacheUtil.putResult(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
			VanBanHuongDanImpl.class, vanBanHuongDan.getPrimaryKey(),
			vanBanHuongDan);

		return vanBanHuongDan;
	}

	protected VanBanHuongDan toUnwrappedModel(VanBanHuongDan vanBanHuongDan) {
		if (vanBanHuongDan instanceof VanBanHuongDanImpl) {
			return vanBanHuongDan;
		}

		VanBanHuongDanImpl vanBanHuongDanImpl = new VanBanHuongDanImpl();

		vanBanHuongDanImpl.setNew(vanBanHuongDan.isNew());
		vanBanHuongDanImpl.setPrimaryKey(vanBanHuongDan.getPrimaryKey());

		vanBanHuongDanImpl.setId(vanBanHuongDan.getId());
		vanBanHuongDanImpl.setNoiLuuTruId(vanBanHuongDan.getNoiLuuTruId());
		vanBanHuongDanImpl.setTenTaiLieu(vanBanHuongDan.getTenTaiLieu());
		vanBanHuongDanImpl.setMoTa(vanBanHuongDan.getMoTa());
		vanBanHuongDanImpl.setLoaiTaiLieu(vanBanHuongDan.getLoaiTaiLieu());
		vanBanHuongDanImpl.setNgayTao(vanBanHuongDan.getNgayTao());
		vanBanHuongDanImpl.setNgaySua(vanBanHuongDan.getNgaySua());
		vanBanHuongDanImpl.setDaXoa(vanBanHuongDan.getDaXoa());
		vanBanHuongDanImpl.setNguoiTao(vanBanHuongDan.getNguoiTao());
		vanBanHuongDanImpl.setNguoiSua(vanBanHuongDan.getNguoiSua());
		vanBanHuongDanImpl.setThuTucHanhChinhId(vanBanHuongDan.getThuTucHanhChinhId());

		return vanBanHuongDanImpl;
	}

	/**
	 * Returns the van ban huong dan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the van ban huong dan
	 * @return the van ban huong dan
	 * @throws com.liferay.portal.NoSuchModelException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanHuongDan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the van ban huong dan with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException} if it could not be found.
	 *
	 * @param id the primary key of the van ban huong dan
	 * @return the van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByPrimaryKey(long id)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = fetchByPrimaryKey(id);

		if (vanBanHuongDan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchVanBanHuongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return vanBanHuongDan;
	}

	/**
	 * Returns the van ban huong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the van ban huong dan
	 * @return the van ban huong dan, or <code>null</code> if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanHuongDan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the van ban huong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the van ban huong dan
	 * @return the van ban huong dan, or <code>null</code> if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan fetchByPrimaryKey(long id) throws SystemException {
		VanBanHuongDan vanBanHuongDan = (VanBanHuongDan)EntityCacheUtil.getResult(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
				VanBanHuongDanImpl.class, id);

		if (vanBanHuongDan == _nullVanBanHuongDan) {
			return null;
		}

		if (vanBanHuongDan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vanBanHuongDan = (VanBanHuongDan)session.get(VanBanHuongDanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vanBanHuongDan != null) {
					cacheResult(vanBanHuongDan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VanBanHuongDanModelImpl.ENTITY_CACHE_ENABLED,
						VanBanHuongDanImpl.class, id, _nullVanBanHuongDan);
				}

				closeSession(session);
			}
		}

		return vanBanHuongDan;
	}

	/**
	 * Returns all the van ban huong dans where noiLuuTruId = &#63;.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByNoiLuuTruId(long noiLuuTruId)
		throws SystemException {
		return findByNoiLuuTruId(noiLuuTruId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where noiLuuTruId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByNoiLuuTruId(long noiLuuTruId, int start,
		int end) throws SystemException {
		return findByNoiLuuTruId(noiLuuTruId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where noiLuuTruId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByNoiLuuTruId(long noiLuuTruId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOILUUTRUID;
			finderArgs = new Object[] { noiLuuTruId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOILUUTRUID;
			finderArgs = new Object[] { noiLuuTruId, start, end, orderByComparator };
		}

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(noiLuuTruId);

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where noiLuuTruId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByNoiLuuTruId_First(long noiLuuTruId,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByNoiLuuTruId(noiLuuTruId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("noiLuuTruId=");
			msg.append(noiLuuTruId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where noiLuuTruId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByNoiLuuTruId_Last(long noiLuuTruId,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByNoiLuuTruId(noiLuuTruId);

		List<VanBanHuongDan> list = findByNoiLuuTruId(noiLuuTruId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("noiLuuTruId=");
			msg.append(noiLuuTruId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where noiLuuTruId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param noiLuuTruId the noi luu tru ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByNoiLuuTruId_PrevAndNext(long id,
		long noiLuuTruId, OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByNoiLuuTruId_PrevAndNext(session, vanBanHuongDan,
					noiLuuTruId, orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByNoiLuuTruId_PrevAndNext(session, vanBanHuongDan,
					noiLuuTruId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanHuongDan getByNoiLuuTruId_PrevAndNext(Session session,
		VanBanHuongDan vanBanHuongDan, long noiLuuTruId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

		query.append(_FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2);

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(noiLuuTruId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans where tenTaiLieu = &#63;.
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByTenTaiLieu(String tenTaiLieu)
		throws SystemException {
		return findByTenTaiLieu(tenTaiLieu, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where tenTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByTenTaiLieu(String tenTaiLieu, int start,
		int end) throws SystemException {
		return findByTenTaiLieu(tenTaiLieu, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where tenTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByTenTaiLieu(String tenTaiLieu, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTAILIEU;
			finderArgs = new Object[] { tenTaiLieu };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TENTAILIEU;
			finderArgs = new Object[] { tenTaiLieu, start, end, orderByComparator };
		}

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			if (tenTaiLieu == null) {
				query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_1);
			}
			else {
				if (tenTaiLieu.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenTaiLieu != null) {
					qPos.add(tenTaiLieu);
				}

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where tenTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByTenTaiLieu_First(String tenTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByTenTaiLieu(tenTaiLieu, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenTaiLieu=");
			msg.append(tenTaiLieu);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where tenTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByTenTaiLieu_Last(String tenTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByTenTaiLieu(tenTaiLieu);

		List<VanBanHuongDan> list = findByTenTaiLieu(tenTaiLieu, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenTaiLieu=");
			msg.append(tenTaiLieu);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where tenTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param tenTaiLieu the ten tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByTenTaiLieu_PrevAndNext(long id,
		String tenTaiLieu, OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByTenTaiLieu_PrevAndNext(session, vanBanHuongDan,
					tenTaiLieu, orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByTenTaiLieu_PrevAndNext(session, vanBanHuongDan,
					tenTaiLieu, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanHuongDan getByTenTaiLieu_PrevAndNext(Session session,
		VanBanHuongDan vanBanHuongDan, String tenTaiLieu,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

		if (tenTaiLieu == null) {
			query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_1);
		}
		else {
			if (tenTaiLieu.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_3);
			}
			else {
				query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_2);
			}
		}

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (tenTaiLieu != null) {
			qPos.add(tenTaiLieu);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans where loaiTaiLieu = &#63;.
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByLoaiTaiLieu(long loaiTaiLieu)
		throws SystemException {
		return findByLoaiTaiLieu(loaiTaiLieu, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByLoaiTaiLieu(long loaiTaiLieu, int start,
		int end) throws SystemException {
		return findByLoaiTaiLieu(loaiTaiLieu, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByLoaiTaiLieu(long loaiTaiLieu, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAITAILIEU;
			finderArgs = new Object[] { loaiTaiLieu };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAITAILIEU;
			finderArgs = new Object[] { loaiTaiLieu, start, end, orderByComparator };
		}

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_LOAITAILIEU_LOAITAILIEU_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiTaiLieu);

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByLoaiTaiLieu_First(long loaiTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByLoaiTaiLieu(loaiTaiLieu, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiTaiLieu=");
			msg.append(loaiTaiLieu);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByLoaiTaiLieu_Last(long loaiTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByLoaiTaiLieu(loaiTaiLieu);

		List<VanBanHuongDan> list = findByLoaiTaiLieu(loaiTaiLieu, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiTaiLieu=");
			msg.append(loaiTaiLieu);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param loaiTaiLieu the loai tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByLoaiTaiLieu_PrevAndNext(long id,
		long loaiTaiLieu, OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByLoaiTaiLieu_PrevAndNext(session, vanBanHuongDan,
					loaiTaiLieu, orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByLoaiTaiLieu_PrevAndNext(session, vanBanHuongDan,
					loaiTaiLieu, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanHuongDan getByLoaiTaiLieu_PrevAndNext(Session session,
		VanBanHuongDan vanBanHuongDan, long loaiTaiLieu,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

		query.append(_FINDER_COLUMN_LOAITAILIEU_LOAITAILIEU_2);

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiTaiLieu);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws SystemException {
		return findByThuTucHanhChinhId(thuTucHanhChinhId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end) throws SystemException {
		return findByThuTucHanhChinhId(thuTucHanhChinhId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhId(
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

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByThuTucHanhChinhId(thuTucHanhChinhId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByThuTucHanhChinhId_Last(long thuTucHanhChinhId,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByThuTucHanhChinhId(thuTucHanhChinhId);

		List<VanBanHuongDan> list = findByThuTucHanhChinhId(thuTucHanhChinhId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByThuTucHanhChinhId_PrevAndNext(long id,
		long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByThuTucHanhChinhId_PrevAndNext(session,
					vanBanHuongDan, thuTucHanhChinhId, orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByThuTucHanhChinhId_PrevAndNext(session,
					vanBanHuongDan, thuTucHanhChinhId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanHuongDan getByThuTucHanhChinhId_PrevAndNext(
		Session session, VanBanHuongDan vanBanHuongDan, long thuTucHanhChinhId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByTrangThai(int daXoa, int start, int end,
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

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByTrangThai(daXoa);

		List<VanBanHuongDan> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, vanBanHuongDan,
					daXoa, orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByTrangThai_PrevAndNext(session, vanBanHuongDan,
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

	protected VanBanHuongDan getByTrangThai_PrevAndNext(Session session,
		VanBanHuongDan vanBanHuongDan, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws SystemException {
		return findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa, int start, int end)
		throws SystemException {
		return findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA;
			finderArgs = new Object[] { thuTucHanhChinhId, loaiTaiLieu, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA;
			finderArgs = new Object[] {
					thuTucHanhChinhId, loaiTaiLieu, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_LOAITAILIEU_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(loaiTaiLieu);

				qPos.add(daXoa);

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_First(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
				loaiTaiLieu, daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", loaiTaiLieu=");
			msg.append(loaiTaiLieu);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_Last(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
				loaiTaiLieu, daXoa);

		List<VanBanHuongDan> list = findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
				loaiTaiLieu, daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", loaiTaiLieu=");
			msg.append(loaiTaiLieu);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(
		long id, long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(session,
					vanBanHuongDan, thuTucHanhChinhId, loaiTaiLieu, daXoa,
					orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(session,
					vanBanHuongDan, thuTucHanhChinhId, loaiTaiLieu, daXoa,
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

	protected VanBanHuongDan getByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(
		Session session, VanBanHuongDan vanBanHuongDan, long thuTucHanhChinhId,
		long loaiTaiLieu, int daXoa, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_LOAITAILIEU_2);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_DAXOA_2);

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		qPos.add(loaiTaiLieu);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @return the matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu) throws SystemException {
		return findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu, int start, int end)
		throws SystemException {
		return findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU;
			finderArgs = new Object[] { thuTucHanhChinhId, loaiTaiLieu };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUCHANHCHINHIDANDLOAITAILIEU;
			finderArgs = new Object[] {
					thuTucHanhChinhId, loaiTaiLieu,
					
					start, end, orderByComparator
				};
		}

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_LOAITAILIEU_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(loaiTaiLieu);

				list = (List<VanBanHuongDan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieu_First(
		long thuTucHanhChinhId, long loaiTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		List<VanBanHuongDan> list = findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
				loaiTaiLieu, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", loaiTaiLieu=");
			msg.append(loaiTaiLieu);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieu_Last(
		long thuTucHanhChinhId, long loaiTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		int count = countByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
				loaiTaiLieu);

		List<VanBanHuongDan> list = findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
				loaiTaiLieu, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", loaiTaiLieu=");
			msg.append(loaiTaiLieu);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVanBanHuongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current van ban huong dan
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban huong dan
	 * @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VanBanHuongDan[] findByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(
		long id, long thuTucHanhChinhId, long loaiTaiLieu,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanHuongDanException, SystemException {
		VanBanHuongDan vanBanHuongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanHuongDan[] array = new VanBanHuongDanImpl[3];

			array[0] = getByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(session,
					vanBanHuongDan, thuTucHanhChinhId, loaiTaiLieu,
					orderByComparator, true);

			array[1] = vanBanHuongDan;

			array[2] = getByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(session,
					vanBanHuongDan, thuTucHanhChinhId, loaiTaiLieu,
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

	protected VanBanHuongDan getByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(
		Session session, VanBanHuongDan vanBanHuongDan, long thuTucHanhChinhId,
		long loaiTaiLieu, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANHUONGDAN_WHERE);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_LOAITAILIEU_2);

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
			query.append(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId);

		qPos.add(loaiTaiLieu);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanHuongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanHuongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the van ban huong dans.
	 *
	 * @return the van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban huong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @return the range of van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban huong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of van ban huong dans
	 * @param end the upper bound of the range of van ban huong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<VanBanHuongDan> findAll(int start, int end,
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

		List<VanBanHuongDan> list = (List<VanBanHuongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VANBANHUONGDAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VANBANHUONGDAN.concat(VanBanHuongDanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VanBanHuongDan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VanBanHuongDan>)QueryUtil.list(q,
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
	 * Removes all the van ban huong dans where noiLuuTruId = &#63; from the database.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNoiLuuTruId(long noiLuuTruId) throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByNoiLuuTruId(noiLuuTruId)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans where tenTaiLieu = &#63; from the database.
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTenTaiLieu(String tenTaiLieu) throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByTenTaiLieu(tenTaiLieu)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans where loaiTaiLieu = &#63; from the database.
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLoaiTaiLieu(long loaiTaiLieu) throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByLoaiTaiLieu(loaiTaiLieu)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans where thuTucHanhChinhId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByThuTucHanhChinhId(
				thuTucHanhChinhId)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByTrangThai(daXoa)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
				thuTucHanhChinhId, loaiTaiLieu, daXoa)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu) throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findByThuTucHanhChinhIdAndLoaiTaiLieu(
				thuTucHanhChinhId, loaiTaiLieu)) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Removes all the van ban huong dans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VanBanHuongDan vanBanHuongDan : findAll()) {
			remove(vanBanHuongDan);
		}
	}

	/**
	 * Returns the number of van ban huong dans where noiLuuTruId = &#63;.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNoiLuuTruId(long noiLuuTruId) throws SystemException {
		Object[] finderArgs = new Object[] { noiLuuTruId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(noiLuuTruId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of van ban huong dans where tenTaiLieu = &#63;.
	 *
	 * @param tenTaiLieu the ten tai lieu
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTenTaiLieu(String tenTaiLieu) throws SystemException {
		Object[] finderArgs = new Object[] { tenTaiLieu };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENTAILIEU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

			if (tenTaiLieu == null) {
				query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_1);
			}
			else {
				if (tenTaiLieu.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENTAILIEU_TENTAILIEU_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenTaiLieu != null) {
					qPos.add(tenTaiLieu);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENTAILIEU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of van ban huong dans where loaiTaiLieu = &#63;.
	 *
	 * @param loaiTaiLieu the loai tai lieu
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLoaiTaiLieu(long loaiTaiLieu) throws SystemException {
		Object[] finderArgs = new Object[] { loaiTaiLieu };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAITAILIEU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_LOAITAILIEU_LOAITAILIEU_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiTaiLieu);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAITAILIEU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of van ban huong dans where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

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
	 * Returns the number of van ban huong dans where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

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
	 * Returns the number of van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @param daXoa the da xoa
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, loaiTaiLieu, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_LOAITAILIEU_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(loaiTaiLieu);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param loaiTaiLieu the loai tai lieu
	 * @return the number of matching van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTucHanhChinhIdAndLoaiTaiLieu(long thuTucHanhChinhId,
		long loaiTaiLieu) throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, loaiTaiLieu };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VANBANHUONGDAN_WHERE);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_LOAITAILIEU_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId);

				qPos.add(loaiTaiLieu);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUCHANHCHINHIDANDLOAITAILIEU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of van ban huong dans.
	 *
	 * @return the number of van ban huong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VANBANHUONGDAN);

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
	 * Initializes the van ban huong dan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.VanBanHuongDan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VanBanHuongDan>> listenersList = new ArrayList<ModelListener<VanBanHuongDan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VanBanHuongDan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VanBanHuongDanImpl.class.getName());
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
	private static final String _SQL_SELECT_VANBANHUONGDAN = "SELECT vanBanHuongDan FROM VanBanHuongDan vanBanHuongDan";
	private static final String _SQL_SELECT_VANBANHUONGDAN_WHERE = "SELECT vanBanHuongDan FROM VanBanHuongDan vanBanHuongDan WHERE ";
	private static final String _SQL_COUNT_VANBANHUONGDAN = "SELECT COUNT(vanBanHuongDan) FROM VanBanHuongDan vanBanHuongDan";
	private static final String _SQL_COUNT_VANBANHUONGDAN_WHERE = "SELECT COUNT(vanBanHuongDan) FROM VanBanHuongDan vanBanHuongDan WHERE ";
	private static final String _FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2 = "vanBanHuongDan.noiLuuTruId = ?";
	private static final String _FINDER_COLUMN_TENTAILIEU_TENTAILIEU_1 = "vanBanHuongDan.tenTaiLieu IS NULL";
	private static final String _FINDER_COLUMN_TENTAILIEU_TENTAILIEU_2 = "vanBanHuongDan.tenTaiLieu = ?";
	private static final String _FINDER_COLUMN_TENTAILIEU_TENTAILIEU_3 = "(vanBanHuongDan.tenTaiLieu IS NULL OR vanBanHuongDan.tenTaiLieu = ?)";
	private static final String _FINDER_COLUMN_LOAITAILIEU_LOAITAILIEU_2 = "vanBanHuongDan.loaiTaiLieu = ?";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHID_THUTUCHANHCHINHID_2 =
		"vanBanHuongDan.thuTucHanhChinhId = ?";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "vanBanHuongDan.daXoa = ?";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_THUTUCHANHCHINHID_2 =
		"vanBanHuongDan.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_LOAITAILIEU_2 =
		"vanBanHuongDan.loaiTaiLieu = ? AND ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEUDAXOA_DAXOA_2 =
		"vanBanHuongDan.daXoa = ?";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_THUTUCHANHCHINHID_2 =
		"vanBanHuongDan.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUCHANHCHINHIDANDLOAITAILIEU_LOAITAILIEU_2 =
		"vanBanHuongDan.loaiTaiLieu = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vanBanHuongDan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VanBanHuongDan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VanBanHuongDan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VanBanHuongDanPersistenceImpl.class);
	private static VanBanHuongDan _nullVanBanHuongDan = new VanBanHuongDanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VanBanHuongDan> toCacheModel() {
				return _nullVanBanHuongDanCacheModel;
			}
		};

	private static CacheModel<VanBanHuongDan> _nullVanBanHuongDanCacheModel = new CacheModel<VanBanHuongDan>() {
			public VanBanHuongDan toEntityModel() {
				return _nullVanBanHuongDan;
			}
		};
}