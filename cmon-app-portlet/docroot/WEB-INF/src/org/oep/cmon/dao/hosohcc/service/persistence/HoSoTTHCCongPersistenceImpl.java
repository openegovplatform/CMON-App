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

package org.oep.cmon.dao.hosohcc.service.persistence;

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

import org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho so t t h c cong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongPersistence
 * @see HoSoTTHCCongUtil
 * @generated
 */
public class HoSoTTHCCongPersistenceImpl extends BasePersistenceImpl<HoSoTTHCCong>
	implements HoSoTTHCCongPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoSoTTHCCongUtil} to access the ho so t t h c cong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoSoTTHCCongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOBIENNHAN =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymaSoBienNhan",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymaSoBienNhan",
			new String[] { String.class.getName() },
			HoSoTTHCCongModelImpl.MASOBIENNHAN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASOBIENNHAN = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymaSoBienNhan",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOHOSO = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymaSoHoSo",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymaSoHoSo",
			new String[] { String.class.getName() },
			HoSoTTHCCongModelImpl.MASOHOSO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASOHOSO = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymaSoHoSo",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DV_PB = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDV_PB",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DV_PB = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDV_PB",
			new String[] { String.class.getName(), String.class.getName() },
			HoSoTTHCCongModelImpl.TENCOQUANTIEPNHAN_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.TENPHONGBANXULYHIENTHOI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DV_PB = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDV_PB",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTenThuTucHanhChinh",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTenThuTucHanhChinh",
			new String[] { String.class.getName() },
			HoSoTTHCCongModelImpl.TENTHUTUCHANHCHINH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENTHUTUCHANHCHINH = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTenThuTucHanhChinh", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN_DT_DD =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen_DT_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen_DT_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			HoSoTTHCCongModelImpl.HOTENNGUOINOPHOSO_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.SODIENTHOAIDIDONGNGUOINOP_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.SODIENTHOAICODINHNGUOINOP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN_DT_DD = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen_DT_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONGDANNOPID =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCongDanNopId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCongDanNopId",
			new String[] { Long.class.getName() },
			HoSoTTHCCongModelImpl.CONGDANNOPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONGDANNOPID = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCongDanNopId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUC_CONGDAN =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThuTuc_CongDan",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC_CONGDAN =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByThuTuc_CongDan",
			new String[] { Long.class.getName(), Long.class.getName() },
			HoSoTTHCCongModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.CONGDANNOPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THUTUC_CONGDAN = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThuTuc_CongDan",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCongDanNopId_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCongDanNopId_TrangThai",
			new String[] { Long.class.getName(), Integer.class.getName() },
			HoSoTTHCCongModelImpl.CONGDANNOPID_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.TRANGTHAIHOSO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONGDANNOPID_TRANGTHAI = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCongDanNopId_TrangThai",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAIHOSO = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLoaiHoSo",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIHOSO =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoaiHoSo",
			new String[] { Integer.class.getName() },
			HoSoTTHCCongModelImpl.LOAIHOSO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOAIHOSO = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoaiHoSo",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIHOSO =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThaiHoSo",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO =
		new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThaiHoSo",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			HoSoTTHCCongModelImpl.TRANGTHAIHOSO_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.DAXOA_COLUMN_BITMASK |
			HoSoTTHCCongModelImpl.COQUANTIEPNHANID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAIHOSO = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThaiHoSo",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, HoSoTTHCCongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho so t t h c cong in the entity cache if it is enabled.
	 *
	 * @param hoSoTTHCCong the ho so t t h c cong
	 */
	public void cacheResult(HoSoTTHCCong hoSoTTHCCong) {
		EntityCacheUtil.putResult(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongImpl.class, hoSoTTHCCong.getPrimaryKey(), hoSoTTHCCong);

		hoSoTTHCCong.resetOriginalValues();
	}

	/**
	 * Caches the ho so t t h c congs in the entity cache if it is enabled.
	 *
	 * @param hoSoTTHCCongs the ho so t t h c congs
	 */
	public void cacheResult(List<HoSoTTHCCong> hoSoTTHCCongs) {
		for (HoSoTTHCCong hoSoTTHCCong : hoSoTTHCCongs) {
			if (EntityCacheUtil.getResult(
						HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
						HoSoTTHCCongImpl.class, hoSoTTHCCong.getPrimaryKey()) == null) {
				cacheResult(hoSoTTHCCong);
			}
			else {
				hoSoTTHCCong.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho so t t h c congs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoSoTTHCCongImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoSoTTHCCongImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho so t t h c cong.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoSoTTHCCong hoSoTTHCCong) {
		EntityCacheUtil.removeResult(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongImpl.class, hoSoTTHCCong.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HoSoTTHCCong> hoSoTTHCCongs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoSoTTHCCong hoSoTTHCCong : hoSoTTHCCongs) {
			EntityCacheUtil.removeResult(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
				HoSoTTHCCongImpl.class, hoSoTTHCCong.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ho so t t h c cong with the primary key. Does not add the ho so t t h c cong to the database.
	 *
	 * @param id the primary key for the new ho so t t h c cong
	 * @return the new ho so t t h c cong
	 */
	public HoSoTTHCCong create(long id) {
		HoSoTTHCCong hoSoTTHCCong = new HoSoTTHCCongImpl();

		hoSoTTHCCong.setNew(true);
		hoSoTTHCCong.setPrimaryKey(id);

		return hoSoTTHCCong;
	}

	/**
	 * Removes the ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ho so t t h c cong
	 * @return the ho so t t h c cong that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong remove(long id)
		throws NoSuchHoSoTTHCCongException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho so t t h c cong
	 * @return the ho so t t h c cong that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoTTHCCong remove(Serializable primaryKey)
		throws NoSuchHoSoTTHCCongException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong hoSoTTHCCong = (HoSoTTHCCong)session.get(HoSoTTHCCongImpl.class,
					primaryKey);

			if (hoSoTTHCCong == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoSoTTHCCongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoSoTTHCCong);
		}
		catch (NoSuchHoSoTTHCCongException nsee) {
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
	protected HoSoTTHCCong removeImpl(HoSoTTHCCong hoSoTTHCCong)
		throws SystemException {
		hoSoTTHCCong = toUnwrappedModel(hoSoTTHCCong);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoSoTTHCCong);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoSoTTHCCong);

		return hoSoTTHCCong;
	}

	@Override
	public HoSoTTHCCong updateImpl(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong, boolean merge)
		throws SystemException {
		hoSoTTHCCong = toUnwrappedModel(hoSoTTHCCong);

		boolean isNew = hoSoTTHCCong.isNew();

		HoSoTTHCCongModelImpl hoSoTTHCCongModelImpl = (HoSoTTHCCongModelImpl)hoSoTTHCCong;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoSoTTHCCong, merge);

			hoSoTTHCCong.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HoSoTTHCCongModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTTHCCongModelImpl.getOriginalMaSoBienNhan()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN,
					args);

				args = new Object[] { hoSoTTHCCongModelImpl.getMaSoBienNhan() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTTHCCongModelImpl.getOriginalMaSoHoSo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO,
					args);

				args = new Object[] { hoSoTTHCCongModelImpl.getMaSoHoSo() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DV_PB.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTTHCCongModelImpl.getOriginalTenCoQuanTiepNhan(),
						
						hoSoTTHCCongModelImpl.getOriginalTenPhongBanXuLyHienThoi()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DV_PB, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DV_PB,
					args);

				args = new Object[] {
						hoSoTTHCCongModelImpl.getTenCoQuanTiepNhan(),
						
						hoSoTTHCCongModelImpl.getTenPhongBanXuLyHienThoi()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DV_PB, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DV_PB,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTTHCCongModelImpl.getOriginalTenThuTucHanhChinh()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENTHUTUCHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH,
					args);

				args = new Object[] {
						hoSoTTHCCongModelImpl.getTenThuTucHanhChinh()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENTHUTUCHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTTHCCongModelImpl.getOriginalHoTenNguoiNopHoSo(),
						
						hoSoTTHCCongModelImpl.getOriginalSoDienThoaiDiDongNguoiNop(),
						
						hoSoTTHCCongModelImpl.getOriginalSoDienThoaiCoDinhNguoiNop()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN_DT_DD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD,
					args);

				args = new Object[] {
						hoSoTTHCCongModelImpl.getHoTenNguoiNopHoSo(),
						
						hoSoTTHCCongModelImpl.getSoDienThoaiDiDongNguoiNop(),
						
						hoSoTTHCCongModelImpl.getSoDienThoaiCoDinhNguoiNop()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN_DT_DD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoTTHCCongModelImpl.getOriginalCongDanNopId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGDANNOPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID,
					args);

				args = new Object[] {
						Long.valueOf(hoSoTTHCCongModelImpl.getCongDanNopId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGDANNOPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC_CONGDAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoTTHCCongModelImpl.getOriginalThuTucHanhChinhId()),
						Long.valueOf(hoSoTTHCCongModelImpl.getOriginalCongDanNopId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUC_CONGDAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC_CONGDAN,
					args);

				args = new Object[] {
						Long.valueOf(hoSoTTHCCongModelImpl.getThuTucHanhChinhId()),
						Long.valueOf(hoSoTTHCCongModelImpl.getCongDanNopId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THUTUC_CONGDAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC_CONGDAN,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoTTHCCongModelImpl.getOriginalCongDanNopId()),
						Integer.valueOf(hoSoTTHCCongModelImpl.getOriginalTrangThaiHoSo())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGDANNOPID_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI,
					args);

				args = new Object[] {
						Long.valueOf(hoSoTTHCCongModelImpl.getCongDanNopId()),
						Integer.valueOf(hoSoTTHCCongModelImpl.getTrangThaiHoSo())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONGDANNOPID_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(hoSoTTHCCongModelImpl.getOriginalLoaiHoSo())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAIHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIHOSO,
					args);

				args = new Object[] {
						Integer.valueOf(hoSoTTHCCongModelImpl.getLoaiHoSo())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOAIHOSO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIHOSO,
					args);
			}

			if ((hoSoTTHCCongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(hoSoTTHCCongModelImpl.getOriginalTrangThaiHoSo()),
						Integer.valueOf(hoSoTTHCCongModelImpl.getOriginalDaXoa()),
						Long.valueOf(hoSoTTHCCongModelImpl.getOriginalCoQuanTiepNhanId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO,
					args);

				args = new Object[] {
						Integer.valueOf(hoSoTTHCCongModelImpl.getTrangThaiHoSo()),
						Integer.valueOf(hoSoTTHCCongModelImpl.getDaXoa()),
						Long.valueOf(hoSoTTHCCongModelImpl.getCoQuanTiepNhanId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO,
					args);
			}
		}

		EntityCacheUtil.putResult(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTTHCCongImpl.class, hoSoTTHCCong.getPrimaryKey(), hoSoTTHCCong);

		return hoSoTTHCCong;
	}

	protected HoSoTTHCCong toUnwrappedModel(HoSoTTHCCong hoSoTTHCCong) {
		if (hoSoTTHCCong instanceof HoSoTTHCCongImpl) {
			return hoSoTTHCCong;
		}

		HoSoTTHCCongImpl hoSoTTHCCongImpl = new HoSoTTHCCongImpl();

		hoSoTTHCCongImpl.setNew(hoSoTTHCCong.isNew());
		hoSoTTHCCongImpl.setPrimaryKey(hoSoTTHCCong.getPrimaryKey());

		hoSoTTHCCongImpl.setId(hoSoTTHCCong.getId());
		hoSoTTHCCongImpl.setMaSoHoSo(hoSoTTHCCong.getMaSoHoSo());
		hoSoTTHCCongImpl.setNgayNopHoSo(hoSoTTHCCong.getNgayNopHoSo());
		hoSoTTHCCongImpl.setNgayNhanHoSo(hoSoTTHCCong.getNgayNhanHoSo());
		hoSoTTHCCongImpl.setTenCoQuanTiepNhan(hoSoTTHCCong.getTenCoQuanTiepNhan());
		hoSoTTHCCongImpl.setTenThuTucHanhChinh(hoSoTTHCCong.getTenThuTucHanhChinh());
		hoSoTTHCCongImpl.setNgayHenTraKetQua(hoSoTTHCCong.getNgayHenTraKetQua());
		hoSoTTHCCongImpl.setNgayTraKetQua(hoSoTTHCCong.getNgayTraKetQua());
		hoSoTTHCCongImpl.setNgayNopHoSoGoc(hoSoTTHCCong.getNgayNopHoSoGoc());
		hoSoTTHCCongImpl.setNgayHenNopHoSoGoc(hoSoTTHCCong.getNgayHenNopHoSoGoc());
		hoSoTTHCCongImpl.setTenCanBoTiepNhan(hoSoTTHCCong.getTenCanBoTiepNhan());
		hoSoTTHCCongImpl.setChucVuCanBoTiepNhan(hoSoTTHCCong.getChucVuCanBoTiepNhan());
		hoSoTTHCCongImpl.setHoTenNguoiNopHoSo(hoSoTTHCCong.getHoTenNguoiNopHoSo());
		hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNop(hoSoTTHCCong.getDiaChiThuongTruNguoiNop());
		hoSoTTHCCongImpl.setSoDienThoaiCoDinhNguoiNop(hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop());
		hoSoTTHCCongImpl.setTenCanBoTraKetQua(hoSoTTHCCong.getTenCanBoTraKetQua());
		hoSoTTHCCongImpl.setChucVuCanBoTraKetQua(hoSoTTHCCong.getChucVuCanBoTraKetQua());
		hoSoTTHCCongImpl.setHoTenNguoiNhanKetQua(hoSoTTHCCong.getHoTenNguoiNhanKetQua());
		hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNhanKQ(hoSoTTHCCong.getDiaChiThuongTruNguoiNhanKQ());
		hoSoTTHCCongImpl.setSoDienThoaiNguoiNhan(hoSoTTHCCong.getSoDienThoaiNguoiNhan());
		hoSoTTHCCongImpl.setNgayCap(hoSoTTHCCong.getNgayCap());
		hoSoTTHCCongImpl.setLanCap(hoSoTTHCCong.getLanCap());
		hoSoTTHCCongImpl.setTenCoQuanCap(hoSoTTHCCong.getTenCoQuanCap());
		hoSoTTHCCongImpl.setHieuLucTuNgay(hoSoTTHCCong.getHieuLucTuNgay());
		hoSoTTHCCongImpl.setHieuLucDenNgay(hoSoTTHCCong.getHieuLucDenNgay());
		hoSoTTHCCongImpl.setTrangThaiHoSo(hoSoTTHCCong.getTrangThaiHoSo());
		hoSoTTHCCongImpl.setDaXoa(hoSoTTHCCong.getDaXoa());
		hoSoTTHCCongImpl.setNguoiTao(hoSoTTHCCong.getNguoiTao());
		hoSoTTHCCongImpl.setNgayTao(hoSoTTHCCong.getNgayTao());
		hoSoTTHCCongImpl.setNguoiSua(hoSoTTHCCong.getNguoiSua());
		hoSoTTHCCongImpl.setNgaySua(hoSoTTHCCong.getNgaySua());
		hoSoTTHCCongImpl.setThuTucHanhChinhId(hoSoTTHCCong.getThuTucHanhChinhId());
		hoSoTTHCCongImpl.setCongDanNopId(hoSoTTHCCong.getCongDanNopId());
		hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNhanKQId(hoSoTTHCCong.getDiaChiThuongTruNguoiNhanKQId());
		hoSoTTHCCongImpl.setCoQuanTiepNhanId(hoSoTTHCCong.getCoQuanTiepNhanId());
		hoSoTTHCCongImpl.setCanBoTraKetQuaId(hoSoTTHCCong.getCanBoTraKetQuaId());
		hoSoTTHCCongImpl.setCanBoTiepNhanId(hoSoTTHCCong.getCanBoTiepNhanId());
		hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNopId(hoSoTTHCCong.getDiaChiThuongTruNguoiNopId());
		hoSoTTHCCongImpl.setSoDienThoaiDiDongNguoiNop(hoSoTTHCCong.getSoDienThoaiDiDongNguoiNop());
		hoSoTTHCCongImpl.setPhongBanXuLyHienThoiId(hoSoTTHCCong.getPhongBanXuLyHienThoiId());
		hoSoTTHCCongImpl.setTenPhongBanXuLyHienThoi(hoSoTTHCCong.getTenPhongBanXuLyHienThoi());
		hoSoTTHCCongImpl.setCanBoXuLyHienThoiId(hoSoTTHCCong.getCanBoXuLyHienThoiId());
		hoSoTTHCCongImpl.setTenCanBoXuLyHienThoi(hoSoTTHCCong.getTenCanBoXuLyHienThoi());
		hoSoTTHCCongImpl.setDanhGiaKetQua(hoSoTTHCCong.getDanhGiaKetQua());
		hoSoTTHCCongImpl.setGhiChu(hoSoTTHCCong.getGhiChu());
		hoSoTTHCCongImpl.setNgayKetThucXuLy(hoSoTTHCCong.getNgayKetThucXuLy());
		hoSoTTHCCongImpl.setLoaiHoSo(hoSoTTHCCong.getLoaiHoSo());
		hoSoTTHCCongImpl.setYeuCauHuyHoSo(hoSoTTHCCong.getYeuCauHuyHoSo());
		hoSoTTHCCongImpl.setMaSoBienNhan(hoSoTTHCCong.getMaSoBienNhan());
		hoSoTTHCCongImpl.setTenBangChuaHoSo(hoSoTTHCCong.getTenBangChuaHoSo());
		hoSoTTHCCongImpl.setChuSoHuu(hoSoTTHCCong.getChuSoHuu());
		hoSoTTHCCongImpl.setSoBoHoSo(hoSoTTHCCong.getSoBoHoSo());
		hoSoTTHCCongImpl.setLePhi(hoSoTTHCCong.getLePhi());
		hoSoTTHCCongImpl.setPhiHoSo(hoSoTTHCCong.getPhiHoSo());
		hoSoTTHCCongImpl.setTrichYeu(hoSoTTHCCong.getTrichYeu());
		hoSoTTHCCongImpl.setNgayHenTBThue(hoSoTTHCCong.getNgayHenTBThue());
		hoSoTTHCCongImpl.setEmailNguoiNop(hoSoTTHCCong.getEmailNguoiNop());
		hoSoTTHCCongImpl.setMaUngDung(hoSoTTHCCong.getMaUngDung());
		hoSoTTHCCongImpl.setDaGuiGiayHen(hoSoTTHCCong.getDaGuiGiayHen());
		hoSoTTHCCongImpl.setNguoiDaiDienPhapLuat(hoSoTTHCCong.getNguoiDaiDienPhapLuat());
		hoSoTTHCCongImpl.setNguoiDaiDienPhapLuatId(hoSoTTHCCong.getNguoiDaiDienPhapLuatId());
		hoSoTTHCCongImpl.setChuyenSangMotCua(hoSoTTHCCong.getChuyenSangMotCua());
		hoSoTTHCCongImpl.setDoiTuongCanXuLyId(hoSoTTHCCong.getDoiTuongCanXuLyId());
		hoSoTTHCCongImpl.setLyDo(hoSoTTHCCong.getLyDo());
		hoSoTTHCCongImpl.setMoTaThanhPhanHoSo(hoSoTTHCCong.getMoTaThanhPhanHoSo());
		hoSoTTHCCongImpl.setLienKetThanhPhanHoSo(hoSoTTHCCong.getLienKetThanhPhanHoSo());
		hoSoTTHCCongImpl.setSoNgayXuLy(hoSoTTHCCong.getSoNgayXuLy());
		hoSoTTHCCongImpl.setDaTraKetQuaTrucTuyen(hoSoTTHCCong.getDaTraKetQuaTrucTuyen());
		hoSoTTHCCongImpl.setEMailNguoiNhan(hoSoTTHCCong.getEMailNguoiNhan());
		hoSoTTHCCongImpl.setNgaySinhNguoiNhan(hoSoTTHCCong.getNgaySinhNguoiNhan());
		hoSoTTHCCongImpl.setDienThoiCoDinhNguoiNhan(hoSoTTHCCong.getDienThoiCoDinhNguoiNhan());
		hoSoTTHCCongImpl.setCmndNguoiNhan(hoSoTTHCCong.getCmndNguoiNhan());
		hoSoTTHCCongImpl.setGioiTinh(hoSoTTHCCong.getGioiTinh());
		hoSoTTHCCongImpl.setDungXuLy(hoSoTTHCCong.isDungXuLy());
		hoSoTTHCCongImpl.setNgayBoSung(hoSoTTHCCong.getNgayBoSung());
		hoSoTTHCCongImpl.setGhiChuGiayToDinhKem(hoSoTTHCCong.getGhiChuGiayToDinhKem());
		hoSoTTHCCongImpl.setDaDangKyNhanSMS(hoSoTTHCCong.getDaDangKyNhanSMS());
		hoSoTTHCCongImpl.setDaDangKyChuyenPhatNhanh(hoSoTTHCCong.getDaDangKyChuyenPhatNhanh());
		hoSoTTHCCongImpl.setDiaChiChuHoSo(hoSoTTHCCong.getDiaChiChuHoSo());

		return hoSoTTHCCongImpl;
	}

	/**
	 * Returns the ho so t t h c cong with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so t t h c cong
	 * @return the ho so t t h c cong
	 * @throws com.liferay.portal.NoSuchModelException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoTTHCCong findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so t t h c cong with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException} if it could not be found.
	 *
	 * @param id the primary key of the ho so t t h c cong
	 * @return the ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByPrimaryKey(long id)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = fetchByPrimaryKey(id);

		if (hoSoTTHCCong == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHoSoTTHCCongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hoSoTTHCCong;
	}

	/**
	 * Returns the ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so t t h c cong
	 * @return the ho so t t h c cong, or <code>null</code> if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoTTHCCong fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ho so t t h c cong
	 * @return the ho so t t h c cong, or <code>null</code> if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong fetchByPrimaryKey(long id) throws SystemException {
		HoSoTTHCCong hoSoTTHCCong = (HoSoTTHCCong)EntityCacheUtil.getResult(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
				HoSoTTHCCongImpl.class, id);

		if (hoSoTTHCCong == _nullHoSoTTHCCong) {
			return null;
		}

		if (hoSoTTHCCong == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoSoTTHCCong = (HoSoTTHCCong)session.get(HoSoTTHCCongImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoSoTTHCCong != null) {
					cacheResult(hoSoTTHCCong);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoSoTTHCCongModelImpl.ENTITY_CACHE_ENABLED,
						HoSoTTHCCongImpl.class, id, _nullHoSoTTHCCong);
				}

				closeSession(session);
			}
		}

		return hoSoTTHCCong;
	}

	/**
	 * Returns all the ho so t t h c congs where maSoBienNhan = &#63;.
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findBymaSoBienNhan(String maSoBienNhan)
		throws SystemException {
		return findBymaSoBienNhan(maSoBienNhan, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findBymaSoBienNhan(String maSoBienNhan,
		int start, int end) throws SystemException {
		return findBymaSoBienNhan(maSoBienNhan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findBymaSoBienNhan(String maSoBienNhan,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN;
			finderArgs = new Object[] { maSoBienNhan };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOBIENNHAN;
			finderArgs = new Object[] {
					maSoBienNhan,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			if (maSoBienNhan == null) {
				query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_1);
			}
			else {
				if (maSoBienNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoBienNhan != null) {
					qPos.add(maSoBienNhan);
				}

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findBymaSoBienNhan_First(String maSoBienNhan,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findBymaSoBienNhan(maSoBienNhan, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoBienNhan=");
			msg.append(maSoBienNhan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findBymaSoBienNhan_Last(String maSoBienNhan,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countBymaSoBienNhan(maSoBienNhan);

		List<HoSoTTHCCong> list = findBymaSoBienNhan(maSoBienNhan, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoBienNhan=");
			msg.append(maSoBienNhan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param maSoBienNhan the ma so bien nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findBymaSoBienNhan_PrevAndNext(long id,
		String maSoBienNhan, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getBymaSoBienNhan_PrevAndNext(session, hoSoTTHCCong,
					maSoBienNhan, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getBymaSoBienNhan_PrevAndNext(session, hoSoTTHCCong,
					maSoBienNhan, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getBymaSoBienNhan_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, String maSoBienNhan,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		if (maSoBienNhan == null) {
			query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_1);
		}
		else {
			if (maSoBienNhan.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_3);
			}
			else {
				query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_2);
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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (maSoBienNhan != null) {
			qPos.add(maSoBienNhan);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where maSoHoSo = &#63;.
	 *
	 * @param maSoHoSo the ma so ho so
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findBymaSoHoSo(String maSoHoSo)
		throws SystemException {
		return findBymaSoHoSo(maSoHoSo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where maSoHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoHoSo the ma so ho so
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findBymaSoHoSo(String maSoHoSo, int start, int end)
		throws SystemException {
		return findBymaSoHoSo(maSoHoSo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where maSoHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoHoSo the ma so ho so
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findBymaSoHoSo(String maSoHoSo, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOHOSO;
			finderArgs = new Object[] { maSoHoSo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOHOSO;
			finderArgs = new Object[] { maSoHoSo, start, end, orderByComparator };
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			if (maSoHoSo == null) {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_1);
			}
			else {
				if (maSoHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoHoSo != null) {
					qPos.add(maSoHoSo);
				}

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where maSoHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoHoSo the ma so ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findBymaSoHoSo_First(String maSoHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findBymaSoHoSo(maSoHoSo, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoHoSo=");
			msg.append(maSoHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where maSoHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoHoSo the ma so ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findBymaSoHoSo_Last(String maSoHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countBymaSoHoSo(maSoHoSo);

		List<HoSoTTHCCong> list = findBymaSoHoSo(maSoHoSo, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoHoSo=");
			msg.append(maSoHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where maSoHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param maSoHoSo the ma so ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findBymaSoHoSo_PrevAndNext(long id, String maSoHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getBymaSoHoSo_PrevAndNext(session, hoSoTTHCCong,
					maSoHoSo, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getBymaSoHoSo_PrevAndNext(session, hoSoTTHCCong,
					maSoHoSo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getBymaSoHoSo_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, String maSoHoSo,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		if (maSoHoSo == null) {
			query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_1);
		}
		else {
			if (maSoHoSo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_3);
			}
			else {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_2);
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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (maSoHoSo != null) {
			qPos.add(maSoHoSo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByDV_PB(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi) throws SystemException {
		return findByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByDV_PB(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi, int start, int end)
		throws SystemException {
		return findByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByDV_PB(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DV_PB;
			finderArgs = new Object[] { tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DV_PB;
			finderArgs = new Object[] {
					tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			if (tenCoQuanTiepNhan == null) {
				query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_1);
			}
			else {
				if (tenCoQuanTiepNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_2);
				}
			}

			if (tenPhongBanXuLyHienThoi == null) {
				query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_1);
			}
			else {
				if (tenPhongBanXuLyHienThoi.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_3);
				}
				else {
					query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenCoQuanTiepNhan != null) {
					qPos.add(tenCoQuanTiepNhan);
				}

				if (tenPhongBanXuLyHienThoi != null) {
					qPos.add(tenPhongBanXuLyHienThoi);
				}

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByDV_PB_First(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByDV_PB(tenCoQuanTiepNhan,
				tenPhongBanXuLyHienThoi, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenCoQuanTiepNhan=");
			msg.append(tenCoQuanTiepNhan);

			msg.append(", tenPhongBanXuLyHienThoi=");
			msg.append(tenPhongBanXuLyHienThoi);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByDV_PB_Last(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi);

		List<HoSoTTHCCong> list = findByDV_PB(tenCoQuanTiepNhan,
				tenPhongBanXuLyHienThoi, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenCoQuanTiepNhan=");
			msg.append(tenCoQuanTiepNhan);

			msg.append(", tenPhongBanXuLyHienThoi=");
			msg.append(tenPhongBanXuLyHienThoi);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByDV_PB_PrevAndNext(long id,
		String tenCoQuanTiepNhan, String tenPhongBanXuLyHienThoi,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByDV_PB_PrevAndNext(session, hoSoTTHCCong,
					tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi,
					orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByDV_PB_PrevAndNext(session, hoSoTTHCCong,
					tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi,
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

	protected HoSoTTHCCong getByDV_PB_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		if (tenCoQuanTiepNhan == null) {
			query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_1);
		}
		else {
			if (tenCoQuanTiepNhan.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_3);
			}
			else {
				query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_2);
			}
		}

		if (tenPhongBanXuLyHienThoi == null) {
			query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_1);
		}
		else {
			if (tenPhongBanXuLyHienThoi.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_3);
			}
			else {
				query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_2);
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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (tenCoQuanTiepNhan != null) {
			qPos.add(tenCoQuanTiepNhan);
		}

		if (tenPhongBanXuLyHienThoi != null) {
			qPos.add(tenPhongBanXuLyHienThoi);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTenThuTucHanhChinh(
		String tenThuTucHanhChinh) throws SystemException {
		return findByTenThuTucHanhChinh(tenThuTucHanhChinh, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTenThuTucHanhChinh(
		String tenThuTucHanhChinh, int start, int end)
		throws SystemException {
		return findByTenThuTucHanhChinh(tenThuTucHanhChinh, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTenThuTucHanhChinh(
		String tenThuTucHanhChinh, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH;
			finderArgs = new Object[] { tenThuTucHanhChinh };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TENTHUTUCHANHCHINH;
			finderArgs = new Object[] {
					tenThuTucHanhChinh,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			if (tenThuTucHanhChinh == null) {
				query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_1);
			}
			else {
				if (tenThuTucHanhChinh.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenThuTucHanhChinh != null) {
					qPos.add(tenThuTucHanhChinh);
				}

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where tenThuTucHanhChinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByTenThuTucHanhChinh_First(
		String tenThuTucHanhChinh, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByTenThuTucHanhChinh(tenThuTucHanhChinh,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenThuTucHanhChinh=");
			msg.append(tenThuTucHanhChinh);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where tenThuTucHanhChinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByTenThuTucHanhChinh_Last(
		String tenThuTucHanhChinh, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByTenThuTucHanhChinh(tenThuTucHanhChinh);

		List<HoSoTTHCCong> list = findByTenThuTucHanhChinh(tenThuTucHanhChinh,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenThuTucHanhChinh=");
			msg.append(tenThuTucHanhChinh);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where tenThuTucHanhChinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByTenThuTucHanhChinh_PrevAndNext(long id,
		String tenThuTucHanhChinh, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByTenThuTucHanhChinh_PrevAndNext(session,
					hoSoTTHCCong, tenThuTucHanhChinh, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByTenThuTucHanhChinh_PrevAndNext(session,
					hoSoTTHCCong, tenThuTucHanhChinh, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getByTenThuTucHanhChinh_PrevAndNext(
		Session session, HoSoTTHCCong hoSoTTHCCong, String tenThuTucHanhChinh,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		if (tenThuTucHanhChinh == null) {
			query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_1);
		}
		else {
			if (tenThuTucHanhChinh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_3);
			}
			else {
				query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_2);
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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (tenThuTucHanhChinh != null) {
			qPos.add(tenThuTucHanhChinh);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop)
		throws SystemException {
		return findByTen_DT_DD(hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
			soDienThoaiCoDinhNguoiNop, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		int start, int end) throws SystemException {
		return findByTen_DT_DD(hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
			soDienThoaiCoDinhNguoiNop, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD;
			finderArgs = new Object[] {
					hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
					soDienThoaiCoDinhNguoiNop
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN_DT_DD;
			finderArgs = new Object[] {
					hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
					soDienThoaiCoDinhNguoiNop,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			if (hoTenNguoiNopHoSo == null) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_1);
			}
			else {
				if (hoTenNguoiNopHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_2);
				}
			}

			if (soDienThoaiDiDongNguoiNop == null) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_1);
			}
			else {
				if (soDienThoaiDiDongNguoiNop.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_2);
				}
			}

			if (soDienThoaiCoDinhNguoiNop == null) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_1);
			}
			else {
				if (soDienThoaiCoDinhNguoiNop.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (hoTenNguoiNopHoSo != null) {
					qPos.add(hoTenNguoiNopHoSo);
				}

				if (soDienThoaiDiDongNguoiNop != null) {
					qPos.add(soDienThoaiDiDongNguoiNop);
				}

				if (soDienThoaiCoDinhNguoiNop != null) {
					qPos.add(soDienThoaiCoDinhNguoiNop);
				}

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByTen_DT_DD_First(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByTen_DT_DD(hoTenNguoiNopHoSo,
				soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoTenNguoiNopHoSo=");
			msg.append(hoTenNguoiNopHoSo);

			msg.append(", soDienThoaiDiDongNguoiNop=");
			msg.append(soDienThoaiDiDongNguoiNop);

			msg.append(", soDienThoaiCoDinhNguoiNop=");
			msg.append(soDienThoaiCoDinhNguoiNop);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByTen_DT_DD_Last(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByTen_DT_DD(hoTenNguoiNopHoSo,
				soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop);

		List<HoSoTTHCCong> list = findByTen_DT_DD(hoTenNguoiNopHoSo,
				soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoTenNguoiNopHoSo=");
			msg.append(hoTenNguoiNopHoSo);

			msg.append(", soDienThoaiDiDongNguoiNop=");
			msg.append(soDienThoaiDiDongNguoiNop);

			msg.append(", soDienThoaiCoDinhNguoiNop=");
			msg.append(soDienThoaiCoDinhNguoiNop);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByTen_DT_DD_PrevAndNext(long id,
		String hoTenNguoiNopHoSo, String soDienThoaiDiDongNguoiNop,
		String soDienThoaiCoDinhNguoiNop, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByTen_DT_DD_PrevAndNext(session, hoSoTTHCCong,
					hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
					soDienThoaiCoDinhNguoiNop, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByTen_DT_DD_PrevAndNext(session, hoSoTTHCCong,
					hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
					soDienThoaiCoDinhNguoiNop, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getByTen_DT_DD_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		if (hoTenNguoiNopHoSo == null) {
			query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_1);
		}
		else {
			if (hoTenNguoiNopHoSo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_3);
			}
			else {
				query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_2);
			}
		}

		if (soDienThoaiDiDongNguoiNop == null) {
			query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_1);
		}
		else {
			if (soDienThoaiDiDongNguoiNop.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_3);
			}
			else {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_2);
			}
		}

		if (soDienThoaiCoDinhNguoiNop == null) {
			query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_1);
		}
		else {
			if (soDienThoaiCoDinhNguoiNop.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_3);
			}
			else {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_2);
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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (hoTenNguoiNopHoSo != null) {
			qPos.add(hoTenNguoiNopHoSo);
		}

		if (soDienThoaiDiDongNguoiNop != null) {
			qPos.add(soDienThoaiDiDongNguoiNop);
		}

		if (soDienThoaiCoDinhNguoiNop != null) {
			qPos.add(soDienThoaiCoDinhNguoiNop);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where congDanNopId = &#63;.
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByCongDanNopId(Long congDanNopId)
		throws SystemException {
		return findByCongDanNopId(congDanNopId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByCongDanNopId(Long congDanNopId, int start,
		int end) throws SystemException {
		return findByCongDanNopId(congDanNopId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByCongDanNopId(Long congDanNopId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID;
			finderArgs = new Object[] { congDanNopId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONGDANNOPID;
			finderArgs = new Object[] {
					congDanNopId,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_CONGDANNOPID_CONGDANNOPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congDanNopId.longValue());

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByCongDanNopId_First(Long congDanNopId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByCongDanNopId(congDanNopId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congDanNopId=");
			msg.append(congDanNopId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByCongDanNopId_Last(Long congDanNopId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByCongDanNopId(congDanNopId);

		List<HoSoTTHCCong> list = findByCongDanNopId(congDanNopId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congDanNopId=");
			msg.append(congDanNopId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param congDanNopId the cong dan nop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByCongDanNopId_PrevAndNext(long id,
		Long congDanNopId, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByCongDanNopId_PrevAndNext(session, hoSoTTHCCong,
					congDanNopId, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByCongDanNopId_PrevAndNext(session, hoSoTTHCCong,
					congDanNopId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getByCongDanNopId_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, Long congDanNopId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		query.append(_FINDER_COLUMN_CONGDANNOPID_CONGDANNOPID_2);

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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(congDanNopId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByThuTuc_CongDan(Long thuTucHanhChinhId,
		Long congDanNopId) throws SystemException {
		return findByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByThuTuc_CongDan(Long thuTucHanhChinhId,
		Long congDanNopId, int start, int end) throws SystemException {
		return findByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByThuTuc_CongDan(Long thuTucHanhChinhId,
		Long congDanNopId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THUTUC_CONGDAN;
			finderArgs = new Object[] { thuTucHanhChinhId, congDanNopId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THUTUC_CONGDAN;
			finderArgs = new Object[] {
					thuTucHanhChinhId, congDanNopId,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_THUTUC_CONGDAN_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUC_CONGDAN_CONGDANNOPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				qPos.add(congDanNopId.longValue());

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByThuTuc_CongDan_First(Long thuTucHanhChinhId,
		Long congDanNopId, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByThuTuc_CongDan(thuTucHanhChinhId,
				congDanNopId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", congDanNopId=");
			msg.append(congDanNopId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByThuTuc_CongDan_Last(Long thuTucHanhChinhId,
		Long congDanNopId, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId);

		List<HoSoTTHCCong> list = findByThuTuc_CongDan(thuTucHanhChinhId,
				congDanNopId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", congDanNopId=");
			msg.append(congDanNopId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByThuTuc_CongDan_PrevAndNext(long id,
		Long thuTucHanhChinhId, Long congDanNopId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByThuTuc_CongDan_PrevAndNext(session, hoSoTTHCCong,
					thuTucHanhChinhId, congDanNopId, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByThuTuc_CongDan_PrevAndNext(session, hoSoTTHCCong,
					thuTucHanhChinhId, congDanNopId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getByThuTuc_CongDan_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, Long thuTucHanhChinhId, Long congDanNopId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		query.append(_FINDER_COLUMN_THUTUC_CONGDAN_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THUTUC_CONGDAN_CONGDANNOPID_2);

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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId.longValue());

		qPos.add(congDanNopId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByCongDanNopId_TrangThai(Long congDanNopId,
		int trangThaiHoSo) throws SystemException {
		return findByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByCongDanNopId_TrangThai(Long congDanNopId,
		int trangThaiHoSo, int start, int end) throws SystemException {
		return findByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByCongDanNopId_TrangThai(Long congDanNopId,
		int trangThaiHoSo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI;
			finderArgs = new Object[] { congDanNopId, trangThaiHoSo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONGDANNOPID_TRANGTHAI;
			finderArgs = new Object[] {
					congDanNopId, trangThaiHoSo,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_CONGDANNOPID_2);

			query.append(_FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_TRANGTHAIHOSO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congDanNopId.longValue());

				qPos.add(trangThaiHoSo);

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByCongDanNopId_TrangThai_First(Long congDanNopId,
		int trangThaiHoSo, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByCongDanNopId_TrangThai(congDanNopId,
				trangThaiHoSo, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congDanNopId=");
			msg.append(congDanNopId);

			msg.append(", trangThaiHoSo=");
			msg.append(trangThaiHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByCongDanNopId_TrangThai_Last(Long congDanNopId,
		int trangThaiHoSo, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo);

		List<HoSoTTHCCong> list = findByCongDanNopId_TrangThai(congDanNopId,
				trangThaiHoSo, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("congDanNopId=");
			msg.append(congDanNopId);

			msg.append(", trangThaiHoSo=");
			msg.append(trangThaiHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByCongDanNopId_TrangThai_PrevAndNext(long id,
		Long congDanNopId, int trangThaiHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByCongDanNopId_TrangThai_PrevAndNext(session,
					hoSoTTHCCong, congDanNopId, trangThaiHoSo,
					orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByCongDanNopId_TrangThai_PrevAndNext(session,
					hoSoTTHCCong, congDanNopId, trangThaiHoSo,
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

	protected HoSoTTHCCong getByCongDanNopId_TrangThai_PrevAndNext(
		Session session, HoSoTTHCCong hoSoTTHCCong, Long congDanNopId,
		int trangThaiHoSo, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		query.append(_FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_CONGDANNOPID_2);

		query.append(_FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_TRANGTHAIHOSO_2);

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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(congDanNopId.longValue());

		qPos.add(trangThaiHoSo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where loaiHoSo = &#63;.
	 *
	 * @param loaiHoSo the loai ho so
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByLoaiHoSo(int loaiHoSo)
		throws SystemException {
		return findByLoaiHoSo(loaiHoSo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where loaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHoSo the loai ho so
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByLoaiHoSo(int loaiHoSo, int start, int end)
		throws SystemException {
		return findByLoaiHoSo(loaiHoSo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where loaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHoSo the loai ho so
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByLoaiHoSo(int loaiHoSo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOAIHOSO;
			finderArgs = new Object[] { loaiHoSo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOAIHOSO;
			finderArgs = new Object[] { loaiHoSo, start, end, orderByComparator };
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_LOAIHOSO_LOAIHOSO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiHoSo);

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where loaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHoSo the loai ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByLoaiHoSo_First(int loaiHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByLoaiHoSo(loaiHoSo, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiHoSo=");
			msg.append(loaiHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where loaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loaiHoSo the loai ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByLoaiHoSo_Last(int loaiHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByLoaiHoSo(loaiHoSo);

		List<HoSoTTHCCong> list = findByLoaiHoSo(loaiHoSo, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loaiHoSo=");
			msg.append(loaiHoSo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where loaiHoSo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param loaiHoSo the loai ho so
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByLoaiHoSo_PrevAndNext(long id, int loaiHoSo,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByLoaiHoSo_PrevAndNext(session, hoSoTTHCCong,
					loaiHoSo, orderByComparator, true);

			array[1] = hoSoTTHCCong;

			array[2] = getByLoaiHoSo_PrevAndNext(session, hoSoTTHCCong,
					loaiHoSo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTTHCCong getByLoaiHoSo_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, int loaiHoSo,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		query.append(_FINDER_COLUMN_LOAIHOSO_LOAIHOSO_2);

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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiHoSo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @return the matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId) throws SystemException {
		return findByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId, int start, int end) throws SystemException {
		return findByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIHOSO;
			finderArgs = new Object[] { trangThaiHoSo, daXoa, coQuanTiepNhanId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIHOSO;
			finderArgs = new Object[] {
					trangThaiHoSo, daXoa, coQuanTiepNhanId,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_TRANGTHAIHOSO_2);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_COQUANTIEPNHANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThaiHoSo);

				qPos.add(daXoa);

				qPos.add(coQuanTiepNhanId.longValue());

				list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so t t h c cong in the ordered set where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByTrangThaiHoSo_First(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		List<HoSoTTHCCong> list = findByTrangThaiHoSo(trangThaiHoSo, daXoa,
				coQuanTiepNhanId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("trangThaiHoSo=");
			msg.append(trangThaiHoSo);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(", coQuanTiepNhanId=");
			msg.append(coQuanTiepNhanId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so t t h c cong in the ordered set where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong findByTrangThaiHoSo_Last(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId, OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		int count = countByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId);

		List<HoSoTTHCCong> list = findByTrangThaiHoSo(trangThaiHoSo, daXoa,
				coQuanTiepNhanId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("trangThaiHoSo=");
			msg.append(trangThaiHoSo);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(", coQuanTiepNhanId=");
			msg.append(coQuanTiepNhanId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTTHCCongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so t t h c cong
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so t t h c cong
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTTHCCong[] findByTrangThaiHoSo_PrevAndNext(long id,
		int trangThaiHoSo, int daXoa, Long coQuanTiepNhanId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTTHCCongException, SystemException {
		HoSoTTHCCong hoSoTTHCCong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTTHCCong[] array = new HoSoTTHCCongImpl[3];

			array[0] = getByTrangThaiHoSo_PrevAndNext(session, hoSoTTHCCong,
					trangThaiHoSo, daXoa, coQuanTiepNhanId, orderByComparator,
					true);

			array[1] = hoSoTTHCCong;

			array[2] = getByTrangThaiHoSo_PrevAndNext(session, hoSoTTHCCong,
					trangThaiHoSo, daXoa, coQuanTiepNhanId, orderByComparator,
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

	protected HoSoTTHCCong getByTrangThaiHoSo_PrevAndNext(Session session,
		HoSoTTHCCong hoSoTTHCCong, int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTTHCCONG_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAIHOSO_TRANGTHAIHOSO_2);

		query.append(_FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2);

		query.append(_FINDER_COLUMN_TRANGTHAIHOSO_COQUANTIEPNHANID_2);

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
			query.append(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThaiHoSo);

		qPos.add(daXoa);

		qPos.add(coQuanTiepNhanId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTTHCCong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTTHCCong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so t t h c congs.
	 *
	 * @return the ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so t t h c congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @return the range of ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so t t h c congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so t t h c congs
	 * @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTTHCCong> findAll(int start, int end,
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

		List<HoSoTTHCCong> list = (List<HoSoTTHCCong>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOSOTTHCCONG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOSOTTHCCONG.concat(HoSoTTHCCongModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoSoTTHCCong>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ho so t t h c congs where maSoBienNhan = &#63; from the database.
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBymaSoBienNhan(String maSoBienNhan)
		throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findBymaSoBienNhan(maSoBienNhan)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where maSoHoSo = &#63; from the database.
	 *
	 * @param maSoHoSo the ma so ho so
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBymaSoHoSo(String maSoHoSo) throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findBymaSoHoSo(maSoHoSo)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63; from the database.
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDV_PB(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi) throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByDV_PB(tenCoQuanTiepNhan,
				tenPhongBanXuLyHienThoi)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where tenThuTucHanhChinh = &#63; from the database.
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTenThuTucHanhChinh(String tenThuTucHanhChinh)
		throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByTenThuTucHanhChinh(
				tenThuTucHanhChinh)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63; from the database.
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop)
		throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByTen_DT_DD(hoTenNguoiNopHoSo,
				soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where congDanNopId = &#63; from the database.
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCongDanNopId(Long congDanNopId)
		throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByCongDanNopId(congDanNopId)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThuTuc_CongDan(Long thuTucHanhChinhId, Long congDanNopId)
		throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByThuTuc_CongDan(
				thuTucHanhChinhId, congDanNopId)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63; from the database.
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCongDanNopId_TrangThai(Long congDanNopId,
		int trangThaiHoSo) throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByCongDanNopId_TrangThai(
				congDanNopId, trangThaiHoSo)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where loaiHoSo = &#63; from the database.
	 *
	 * @param loaiHoSo the loai ho so
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLoaiHoSo(int loaiHoSo) throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByLoaiHoSo(loaiHoSo)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63; from the database.
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId) throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findByTrangThaiHoSo(trangThaiHoSo,
				daXoa, coQuanTiepNhanId)) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Removes all the ho so t t h c congs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoSoTTHCCong hoSoTTHCCong : findAll()) {
			remove(hoSoTTHCCong);
		}
	}

	/**
	 * Returns the number of ho so t t h c congs where maSoBienNhan = &#63;.
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countBymaSoBienNhan(String maSoBienNhan)
		throws SystemException {
		Object[] finderArgs = new Object[] { maSoBienNhan };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			if (maSoBienNhan == null) {
				query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_1);
			}
			else {
				if (maSoBienNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoBienNhan != null) {
					qPos.add(maSoBienNhan);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where maSoHoSo = &#63;.
	 *
	 * @param maSoHoSo the ma so ho so
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countBymaSoHoSo(String maSoHoSo) throws SystemException {
		Object[] finderArgs = new Object[] { maSoHoSo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MASOHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			if (maSoHoSo == null) {
				query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_1);
			}
			else {
				if (maSoHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOHOSO_MASOHOSO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoHoSo != null) {
					qPos.add(maSoHoSo);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASOHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	 *
	 * @param tenCoQuanTiepNhan the ten co quan tiep nhan
	 * @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDV_PB(String tenCoQuanTiepNhan,
		String tenPhongBanXuLyHienThoi) throws SystemException {
		Object[] finderArgs = new Object[] {
				tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DV_PB,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			if (tenCoQuanTiepNhan == null) {
				query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_1);
			}
			else {
				if (tenCoQuanTiepNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_2);
				}
			}

			if (tenPhongBanXuLyHienThoi == null) {
				query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_1);
			}
			else {
				if (tenPhongBanXuLyHienThoi.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_3);
				}
				else {
					query.append(_FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenCoQuanTiepNhan != null) {
					qPos.add(tenCoQuanTiepNhan);
				}

				if (tenPhongBanXuLyHienThoi != null) {
					qPos.add(tenPhongBanXuLyHienThoi);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DV_PB,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	 *
	 * @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTenThuTucHanhChinh(String tenThuTucHanhChinh)
		throws SystemException {
		Object[] finderArgs = new Object[] { tenThuTucHanhChinh };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENTHUTUCHANHCHINH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			if (tenThuTucHanhChinh == null) {
				query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_1);
			}
			else {
				if (tenThuTucHanhChinh.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenThuTucHanhChinh != null) {
					qPos.add(tenThuTucHanhChinh);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENTHUTUCHANHCHINH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
				soDienThoaiCoDinhNguoiNop
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN_DT_DD,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			if (hoTenNguoiNopHoSo == null) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_1);
			}
			else {
				if (hoTenNguoiNopHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_2);
				}
			}

			if (soDienThoaiDiDongNguoiNop == null) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_1);
			}
			else {
				if (soDienThoaiDiDongNguoiNop.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_2);
				}
			}

			if (soDienThoaiCoDinhNguoiNop == null) {
				query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_1);
			}
			else {
				if (soDienThoaiCoDinhNguoiNop.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (hoTenNguoiNopHoSo != null) {
					qPos.add(hoTenNguoiNopHoSo);
				}

				if (soDienThoaiDiDongNguoiNop != null) {
					qPos.add(soDienThoaiDiDongNguoiNop);
				}

				if (soDienThoaiCoDinhNguoiNop != null) {
					qPos.add(soDienThoaiCoDinhNguoiNop);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN_DT_DD,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where congDanNopId = &#63;.
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCongDanNopId(Long congDanNopId) throws SystemException {
		Object[] finderArgs = new Object[] { congDanNopId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONGDANNOPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_CONGDANNOPID_CONGDANNOPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congDanNopId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONGDANNOPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param congDanNopId the cong dan nop ID
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThuTuc_CongDan(Long thuTucHanhChinhId, Long congDanNopId)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, congDanNopId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THUTUC_CONGDAN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_THUTUC_CONGDAN_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THUTUC_CONGDAN_CONGDANNOPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				qPos.add(congDanNopId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THUTUC_CONGDAN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	 *
	 * @param congDanNopId the cong dan nop ID
	 * @param trangThaiHoSo the trang thai ho so
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCongDanNopId_TrangThai(Long congDanNopId,
		int trangThaiHoSo) throws SystemException {
		Object[] finderArgs = new Object[] { congDanNopId, trangThaiHoSo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONGDANNOPID_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_CONGDANNOPID_2);

			query.append(_FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_TRANGTHAIHOSO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(congDanNopId.longValue());

				qPos.add(trangThaiHoSo);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONGDANNOPID_TRANGTHAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where loaiHoSo = &#63;.
	 *
	 * @param loaiHoSo the loai ho so
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLoaiHoSo(int loaiHoSo) throws SystemException {
		Object[] finderArgs = new Object[] { loaiHoSo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAIHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_LOAIHOSO_LOAIHOSO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiHoSo);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAIHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	 *
	 * @param trangThaiHoSo the trang thai ho so
	 * @param daXoa the da xoa
	 * @param coQuanTiepNhanId the co quan tiep nhan ID
	 * @return the number of matching ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		Long coQuanTiepNhanId) throws SystemException {
		Object[] finderArgs = new Object[] {
				trangThaiHoSo, daXoa, coQuanTiepNhanId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_HOSOTTHCCONG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_TRANGTHAIHOSO_2);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2);

			query.append(_FINDER_COLUMN_TRANGTHAIHOSO_COQUANTIEPNHANID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThaiHoSo);

				qPos.add(daXoa);

				qPos.add(coQuanTiepNhanId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAIHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so t t h c congs.
	 *
	 * @return the number of ho so t t h c congs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOSOTTHCCONG);

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
	 * Initializes the ho so t t h c cong persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoSoTTHCCong>> listenersList = new ArrayList<ModelListener<HoSoTTHCCong>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoSoTTHCCong>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HoSoTTHCCongImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FileDinhKemPersistence.class)
	protected FileDinhKemPersistence fileDinhKemPersistence;
	@BeanReference(type = HoSoAnhXaPersistence.class)
	protected HoSoAnhXaPersistence hoSoAnhXaPersistence;
	@BeanReference(type = HoSoTTHCCongPersistence.class)
	protected HoSoTTHCCongPersistence hoSoTTHCCongPersistence;
	@BeanReference(type = TrangThaiHoSoPersistence.class)
	protected TrangThaiHoSoPersistence trangThaiHoSoPersistence;
	@BeanReference(type = YKienTraoDoiPersistence.class)
	protected YKienTraoDoiPersistence yKienTraoDoiPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HOSOTTHCCONG = "SELECT hoSoTTHCCong FROM HoSoTTHCCong hoSoTTHCCong";
	private static final String _SQL_SELECT_HOSOTTHCCONG_WHERE = "SELECT hoSoTTHCCong FROM HoSoTTHCCong hoSoTTHCCong WHERE ";
	private static final String _SQL_COUNT_HOSOTTHCCONG = "SELECT COUNT(hoSoTTHCCong) FROM HoSoTTHCCong hoSoTTHCCong";
	private static final String _SQL_COUNT_HOSOTTHCCONG_WHERE = "SELECT COUNT(hoSoTTHCCong) FROM HoSoTTHCCong hoSoTTHCCong WHERE ";
	private static final String _FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_1 = "hoSoTTHCCong.maSoBienNhan IS NULL";
	private static final String _FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_2 = "hoSoTTHCCong.maSoBienNhan = ?";
	private static final String _FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_3 = "(hoSoTTHCCong.maSoBienNhan IS NULL OR hoSoTTHCCong.maSoBienNhan = ?)";
	private static final String _FINDER_COLUMN_MASOHOSO_MASOHOSO_1 = "hoSoTTHCCong.maSoHoSo IS NULL";
	private static final String _FINDER_COLUMN_MASOHOSO_MASOHOSO_2 = "hoSoTTHCCong.maSoHoSo = ?";
	private static final String _FINDER_COLUMN_MASOHOSO_MASOHOSO_3 = "(hoSoTTHCCong.maSoHoSo IS NULL OR hoSoTTHCCong.maSoHoSo = ?)";
	private static final String _FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_1 = "hoSoTTHCCong.tenCoQuanTiepNhan IS NULL AND ";
	private static final String _FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_2 = "hoSoTTHCCong.tenCoQuanTiepNhan = ? AND ";
	private static final String _FINDER_COLUMN_DV_PB_TENCOQUANTIEPNHAN_3 = "(hoSoTTHCCong.tenCoQuanTiepNhan IS NULL OR hoSoTTHCCong.tenCoQuanTiepNhan = ?) AND ";
	private static final String _FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_1 = "hoSoTTHCCong.tenPhongBanXuLyHienThoi IS NULL";
	private static final String _FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_2 = "hoSoTTHCCong.tenPhongBanXuLyHienThoi = ?";
	private static final String _FINDER_COLUMN_DV_PB_TENPHONGBANXULYHIENTHOI_3 = "(hoSoTTHCCong.tenPhongBanXuLyHienThoi IS NULL OR hoSoTTHCCong.tenPhongBanXuLyHienThoi = ?)";
	private static final String _FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_1 =
		"hoSoTTHCCong.tenThuTucHanhChinh IS NULL";
	private static final String _FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_2 =
		"hoSoTTHCCong.tenThuTucHanhChinh = ?";
	private static final String _FINDER_COLUMN_TENTHUTUCHANHCHINH_TENTHUTUCHANHCHINH_3 =
		"(hoSoTTHCCong.tenThuTucHanhChinh IS NULL OR hoSoTTHCCong.tenThuTucHanhChinh = ?)";
	private static final String _FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_1 = "hoSoTTHCCong.hoTenNguoiNopHoSo IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_2 = "hoSoTTHCCong.hoTenNguoiNopHoSo = ? AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_3 = "(hoSoTTHCCong.hoTenNguoiNopHoSo IS NULL OR hoSoTTHCCong.hoTenNguoiNopHoSo = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_1 =
		"hoSoTTHCCong.soDienThoaiDiDongNguoiNop IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_2 =
		"hoSoTTHCCong.soDienThoaiDiDongNguoiNop = ? AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_3 =
		"(hoSoTTHCCong.soDienThoaiDiDongNguoiNop IS NULL OR hoSoTTHCCong.soDienThoaiDiDongNguoiNop = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_1 =
		"hoSoTTHCCong.soDienThoaiCoDinhNguoiNop IS NULL";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_2 =
		"hoSoTTHCCong.soDienThoaiCoDinhNguoiNop = ?";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_3 =
		"(hoSoTTHCCong.soDienThoaiCoDinhNguoiNop IS NULL OR hoSoTTHCCong.soDienThoaiCoDinhNguoiNop = ?)";
	private static final String _FINDER_COLUMN_CONGDANNOPID_CONGDANNOPID_2 = "hoSoTTHCCong.congDanNopId = ?";
	private static final String _FINDER_COLUMN_THUTUC_CONGDAN_THUTUCHANHCHINHID_2 =
		"hoSoTTHCCong.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THUTUC_CONGDAN_CONGDANNOPID_2 = "hoSoTTHCCong.congDanNopId = ?";
	private static final String _FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_CONGDANNOPID_2 =
		"hoSoTTHCCong.congDanNopId = ? AND ";
	private static final String _FINDER_COLUMN_CONGDANNOPID_TRANGTHAI_TRANGTHAIHOSO_2 =
		"hoSoTTHCCong.trangThaiHoSo = ?";
	private static final String _FINDER_COLUMN_LOAIHOSO_LOAIHOSO_2 = "hoSoTTHCCong.loaiHoSo = ?";
	private static final String _FINDER_COLUMN_TRANGTHAIHOSO_TRANGTHAIHOSO_2 = "hoSoTTHCCong.trangThaiHoSo = ? AND ";
	private static final String _FINDER_COLUMN_TRANGTHAIHOSO_DAXOA_2 = "hoSoTTHCCong.daXoa = ? AND ";
	private static final String _FINDER_COLUMN_TRANGTHAIHOSO_COQUANTIEPNHANID_2 = "hoSoTTHCCong.coQuanTiepNhanId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoSoTTHCCong.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoSoTTHCCong exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HoSoTTHCCong exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoSoTTHCCongPersistenceImpl.class);
	private static HoSoTTHCCong _nullHoSoTTHCCong = new HoSoTTHCCongImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoSoTTHCCong> toCacheModel() {
				return _nullHoSoTTHCCongCacheModel;
			}
		};

	private static CacheModel<HoSoTTHCCong> _nullHoSoTTHCCongCacheModel = new CacheModel<HoSoTTHCCong>() {
			public HoSoTTHCCong toEntityModel() {
				return _nullHoSoTTHCCong;
			}
		};
}