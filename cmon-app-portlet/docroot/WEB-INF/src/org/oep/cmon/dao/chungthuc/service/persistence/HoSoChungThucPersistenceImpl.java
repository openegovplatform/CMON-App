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

package org.oep.cmon.dao.chungthuc.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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

import org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException;
import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;
import org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl;
import org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho so chung thuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see HoSoChungThucPersistence
 * @see HoSoChungThucUtil
 * @generated
 */
public class HoSoChungThucPersistenceImpl extends BasePersistenceImpl<HoSoChungThuc>
	implements HoSoChungThucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoSoChungThucUtil} to access the ho so chung thuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoSoChungThucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASOBIENNHAN =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymaSoBienNhan",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymaSoBienNhan", new String[] { String.class.getName() },
			HoSoChungThucModelImpl.MASOBIENNHAN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASOBIENNHAN = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymaSoBienNhan",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN_DT_DD =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTen_DT_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTen_DT_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			HoSoChungThucModelImpl.HOTENNGUOINOPHOSO_COLUMN_BITMASK |
			HoSoChungThucModelImpl.SODIENTHOAIDIDONGNGUOINOP_COLUMN_BITMASK |
			HoSoChungThucModelImpl.SODIENTHOAICODINHNGUOINOP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN_DT_DD = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen_DT_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCID =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTheoTTHCID",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoTTHCID", new String[] { Long.class.getName() },
			HoSoChungThucModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOTTHCID = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTheoTTHCID",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTheoTTHCIDAndSoDanhMucId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoTTHCIDAndSoDanhMucId",
			new String[] { Long.class.getName(), Long.class.getName() },
			HoSoChungThucModelImpl.THUTUCHANHCHINHID_COLUMN_BITMASK |
			HoSoChungThucModelImpl.SODANHMUCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOTTHCIDANDSODANHMUCID =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTheoTTHCIDAndSoDanhMucId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOSODANHMUC =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTheoSoDanhMuc",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSODANHMUC =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoSoDanhMuc", new String[] { Long.class.getName() },
			HoSoChungThucModelImpl.SODANHMUCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOSODANHMUC = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTheoSoDanhMuc",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOSOCHUNGTHUC =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTheoSoChungThuc",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSOCHUNGTHUC =
		new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTheoSoChungThuc", new String[] { String.class.getName() },
			HoSoChungThucModelImpl.SOCHUNGTHUC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THEOSOCHUNGTHUC = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTheoSoChungThuc", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			HoSoChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho so chung thuc in the entity cache if it is enabled.
	 *
	 * @param hoSoChungThuc the ho so chung thuc
	 */
	public void cacheResult(HoSoChungThuc hoSoChungThuc) {
		EntityCacheUtil.putResult(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucImpl.class, hoSoChungThuc.getPrimaryKey(),
			hoSoChungThuc);

		hoSoChungThuc.resetOriginalValues();
	}

	/**
	 * Caches the ho so chung thucs in the entity cache if it is enabled.
	 *
	 * @param hoSoChungThucs the ho so chung thucs
	 */
	public void cacheResult(List<HoSoChungThuc> hoSoChungThucs) {
		for (HoSoChungThuc hoSoChungThuc : hoSoChungThucs) {
			if (EntityCacheUtil.getResult(
						HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
						HoSoChungThucImpl.class, hoSoChungThuc.getPrimaryKey()) == null) {
				cacheResult(hoSoChungThuc);
			}
			else {
				hoSoChungThuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho so chung thucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoSoChungThucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoSoChungThucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho so chung thuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoSoChungThuc hoSoChungThuc) {
		EntityCacheUtil.removeResult(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucImpl.class, hoSoChungThuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HoSoChungThuc> hoSoChungThucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoSoChungThuc hoSoChungThuc : hoSoChungThucs) {
			EntityCacheUtil.removeResult(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
				HoSoChungThucImpl.class, hoSoChungThuc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ho so chung thuc with the primary key. Does not add the ho so chung thuc to the database.
	 *
	 * @param hoSoChungThucId the primary key for the new ho so chung thuc
	 * @return the new ho so chung thuc
	 */
	public HoSoChungThuc create(long hoSoChungThucId) {
		HoSoChungThuc hoSoChungThuc = new HoSoChungThucImpl();

		hoSoChungThuc.setNew(true);
		hoSoChungThuc.setPrimaryKey(hoSoChungThucId);

		return hoSoChungThuc;
	}

	/**
	 * Removes the ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hoSoChungThucId the primary key of the ho so chung thuc
	 * @return the ho so chung thuc that was removed
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc remove(long hoSoChungThucId)
		throws NoSuchHoSoChungThucException, SystemException {
		return remove(Long.valueOf(hoSoChungThucId));
	}

	/**
	 * Removes the ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho so chung thuc
	 * @return the ho so chung thuc that was removed
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoChungThuc remove(Serializable primaryKey)
		throws NoSuchHoSoChungThucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc hoSoChungThuc = (HoSoChungThuc)session.get(HoSoChungThucImpl.class,
					primaryKey);

			if (hoSoChungThuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoSoChungThucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoSoChungThuc);
		}
		catch (NoSuchHoSoChungThucException nsee) {
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
	protected HoSoChungThuc removeImpl(HoSoChungThuc hoSoChungThuc)
		throws SystemException {
		hoSoChungThuc = toUnwrappedModel(hoSoChungThuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoSoChungThuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoSoChungThuc);

		return hoSoChungThuc;
	}

	@Override
	public HoSoChungThuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.HoSoChungThuc hoSoChungThuc,
		boolean merge) throws SystemException {
		hoSoChungThuc = toUnwrappedModel(hoSoChungThuc);

		boolean isNew = hoSoChungThuc.isNew();

		HoSoChungThucModelImpl hoSoChungThucModelImpl = (HoSoChungThucModelImpl)hoSoChungThuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoSoChungThuc, merge);

			hoSoChungThuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HoSoChungThucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoChungThucModelImpl.getOriginalMaSoBienNhan()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN,
					args);

				args = new Object[] { hoSoChungThucModelImpl.getMaSoBienNhan() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASOBIENNHAN,
					args);
			}

			if ((hoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoChungThucModelImpl.getOriginalHoTenNguoiNopHoSo(),
						
						hoSoChungThucModelImpl.getOriginalSoDienThoaiDiDongNguoiNop(),
						
						hoSoChungThucModelImpl.getOriginalSoDienThoaiCoDinhNguoiNop()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN_DT_DD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD,
					args);

				args = new Object[] {
						hoSoChungThucModelImpl.getHoTenNguoiNopHoSo(),
						
						hoSoChungThucModelImpl.getSoDienThoaiDiDongNguoiNop(),
						
						hoSoChungThucModelImpl.getSoDienThoaiCoDinhNguoiNop()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN_DT_DD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN_DT_DD,
					args);
			}

			if ((hoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoChungThucModelImpl.getOriginalThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID,
					args);

				args = new Object[] {
						Long.valueOf(hoSoChungThucModelImpl.getThuTucHanhChinhId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID,
					args);
			}

			if ((hoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoChungThucModelImpl.getOriginalThuTucHanhChinhId()),
						Long.valueOf(hoSoChungThucModelImpl.getOriginalSoDanhMucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDSODANHMUCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID,
					args);

				args = new Object[] {
						Long.valueOf(hoSoChungThucModelImpl.getThuTucHanhChinhId()),
						Long.valueOf(hoSoChungThucModelImpl.getSoDanhMucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDSODANHMUCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID,
					args);
			}

			if ((hoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSODANHMUC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoChungThucModelImpl.getOriginalSoDanhMucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOSODANHMUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSODANHMUC,
					args);

				args = new Object[] {
						Long.valueOf(hoSoChungThucModelImpl.getSoDanhMucId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOSODANHMUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSODANHMUC,
					args);
			}

			if ((hoSoChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSOCHUNGTHUC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoChungThucModelImpl.getOriginalSoChungThuc()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOSOCHUNGTHUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSOCHUNGTHUC,
					args);

				args = new Object[] { hoSoChungThucModelImpl.getSoChungThuc() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THEOSOCHUNGTHUC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSOCHUNGTHUC,
					args);
			}
		}

		EntityCacheUtil.putResult(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			HoSoChungThucImpl.class, hoSoChungThuc.getPrimaryKey(),
			hoSoChungThuc);

		return hoSoChungThuc;
	}

	protected HoSoChungThuc toUnwrappedModel(HoSoChungThuc hoSoChungThuc) {
		if (hoSoChungThuc instanceof HoSoChungThucImpl) {
			return hoSoChungThuc;
		}

		HoSoChungThucImpl hoSoChungThucImpl = new HoSoChungThucImpl();

		hoSoChungThucImpl.setNew(hoSoChungThuc.isNew());
		hoSoChungThucImpl.setPrimaryKey(hoSoChungThuc.getPrimaryKey());

		hoSoChungThucImpl.setHoSoChungThucId(hoSoChungThuc.getHoSoChungThucId());
		hoSoChungThucImpl.setTenChungThuc(hoSoChungThuc.getTenChungThuc());
		hoSoChungThucImpl.setSoChungThuc(hoSoChungThuc.getSoChungThuc());
		hoSoChungThucImpl.setNgayNopHoSo(hoSoChungThuc.getNgayNopHoSo());
		hoSoChungThucImpl.setNgayTraKetQua(hoSoChungThuc.getNgayTraKetQua());
		hoSoChungThucImpl.setHoTenNguoiNopHoSo(hoSoChungThuc.getHoTenNguoiNopHoSo());
		hoSoChungThucImpl.setDiaChiThuongTruNguoiNop(hoSoChungThuc.getDiaChiThuongTruNguoiNop());
		hoSoChungThucImpl.setSoDienThoaiCoDinhNguoiNop(hoSoChungThuc.getSoDienThoaiCoDinhNguoiNop());
		hoSoChungThucImpl.setTrangThaiHoSo(hoSoChungThuc.getTrangThaiHoSo());
		hoSoChungThucImpl.setDaXoa(hoSoChungThuc.getDaXoa());
		hoSoChungThucImpl.setNguoiTao(hoSoChungThuc.getNguoiTao());
		hoSoChungThucImpl.setNgayTao(hoSoChungThuc.getNgayTao());
		hoSoChungThucImpl.setNguoiSua(hoSoChungThuc.getNguoiSua());
		hoSoChungThucImpl.setNgaySua(hoSoChungThuc.getNgaySua());
		hoSoChungThucImpl.setThuTucHanhChinhId(hoSoChungThuc.getThuTucHanhChinhId());
		hoSoChungThucImpl.setCanBoTiepNhanId(hoSoChungThuc.getCanBoTiepNhanId());
		hoSoChungThucImpl.setSoDienThoaiDiDongNguoiNop(hoSoChungThuc.getSoDienThoaiDiDongNguoiNop());
		hoSoChungThucImpl.setGhiChu(hoSoChungThuc.getGhiChu());
		hoSoChungThucImpl.setMucDichChungThuc(hoSoChungThuc.getMucDichChungThuc());
		hoSoChungThucImpl.setMaSoBienNhan(hoSoChungThuc.getMaSoBienNhan());
		hoSoChungThucImpl.setChuSoHuu(hoSoChungThuc.getChuSoHuu());
		hoSoChungThucImpl.setSoBoHoSo(hoSoChungThuc.getSoBoHoSo());
		hoSoChungThucImpl.setSoTo(hoSoChungThuc.getSoTo());
		hoSoChungThucImpl.setTruongHop(hoSoChungThuc.getTruongHop());
		hoSoChungThucImpl.setLePhi(hoSoChungThuc.getLePhi());
		hoSoChungThucImpl.setPhiHoSo(hoSoChungThuc.getPhiHoSo());
		hoSoChungThucImpl.setEmailNguoiNop(hoSoChungThuc.getEmailNguoiNop());
		hoSoChungThucImpl.setNgaySinhNguoiNop(hoSoChungThuc.getNgaySinhNguoiNop());
		hoSoChungThucImpl.setSoCMNDNguoiNop(hoSoChungThuc.getSoCMNDNguoiNop());
		hoSoChungThucImpl.setGioiTinhNguoiNop(hoSoChungThuc.getGioiTinhNguoiNop());
		hoSoChungThucImpl.setTenCanBoKy(hoSoChungThuc.getTenCanBoKy());
		hoSoChungThucImpl.setChucVuCanBoKyId(hoSoChungThuc.getChucVuCanBoKyId());
		hoSoChungThucImpl.setSoDanhMucId(hoSoChungThuc.getSoDanhMucId());
		hoSoChungThucImpl.setThuongTruTinhId(hoSoChungThuc.getThuongTruTinhId());
		hoSoChungThucImpl.setThuongTruHuyenId(hoSoChungThuc.getThuongTruHuyenId());
		hoSoChungThucImpl.setThuongTruXaId(hoSoChungThuc.getThuongTruXaId());

		return hoSoChungThucImpl;
	}

	/**
	 * Returns the ho so chung thuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so chung thuc
	 * @return the ho so chung thuc
	 * @throws com.liferay.portal.NoSuchModelException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoChungThuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so chung thuc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException} if it could not be found.
	 *
	 * @param hoSoChungThucId the primary key of the ho so chung thuc
	 * @return the ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByPrimaryKey(long hoSoChungThucId)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = fetchByPrimaryKey(hoSoChungThucId);

		if (hoSoChungThuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hoSoChungThucId);
			}

			throw new NoSuchHoSoChungThucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hoSoChungThucId);
		}

		return hoSoChungThuc;
	}

	/**
	 * Returns the ho so chung thuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so chung thuc
	 * @return the ho so chung thuc, or <code>null</code> if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoChungThuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so chung thuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hoSoChungThucId the primary key of the ho so chung thuc
	 * @return the ho so chung thuc, or <code>null</code> if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc fetchByPrimaryKey(long hoSoChungThucId)
		throws SystemException {
		HoSoChungThuc hoSoChungThuc = (HoSoChungThuc)EntityCacheUtil.getResult(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
				HoSoChungThucImpl.class, hoSoChungThucId);

		if (hoSoChungThuc == _nullHoSoChungThuc) {
			return null;
		}

		if (hoSoChungThuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoSoChungThuc = (HoSoChungThuc)session.get(HoSoChungThucImpl.class,
						Long.valueOf(hoSoChungThucId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoSoChungThuc != null) {
					cacheResult(hoSoChungThuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
						HoSoChungThucImpl.class, hoSoChungThucId,
						_nullHoSoChungThuc);
				}

				closeSession(session);
			}
		}

		return hoSoChungThuc;
	}

	/**
	 * Returns all the ho so chung thucs where maSoBienNhan = &#63;.
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @return the matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findBymaSoBienNhan(String maSoBienNhan)
		throws SystemException {
		return findBymaSoBienNhan(maSoBienNhan, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so chung thucs where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findBymaSoBienNhan(String maSoBienNhan,
		int start, int end) throws SystemException {
		return findBymaSoBienNhan(maSoBienNhan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findBymaSoBienNhan(String maSoBienNhan,
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

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

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
				query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
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

				list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so chung thuc in the ordered set where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findBymaSoBienNhan_First(String maSoBienNhan,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		List<HoSoChungThuc> list = findBymaSoBienNhan(maSoBienNhan, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoBienNhan=");
			msg.append(maSoBienNhan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so chung thuc in the ordered set where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findBymaSoBienNhan_Last(String maSoBienNhan,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		int count = countBymaSoBienNhan(maSoBienNhan);

		List<HoSoChungThuc> list = findBymaSoBienNhan(maSoBienNhan, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoBienNhan=");
			msg.append(maSoBienNhan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where maSoBienNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the primary key of the current ho so chung thuc
	 * @param maSoBienNhan the ma so bien nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc[] findBymaSoBienNhan_PrevAndNext(
		long hoSoChungThucId, String maSoBienNhan,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = findByPrimaryKey(hoSoChungThucId);

		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc[] array = new HoSoChungThucImpl[3];

			array[0] = getBymaSoBienNhan_PrevAndNext(session, hoSoChungThuc,
					maSoBienNhan, orderByComparator, true);

			array[1] = hoSoChungThuc;

			array[2] = getBymaSoBienNhan_PrevAndNext(session, hoSoChungThuc,
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

	protected HoSoChungThuc getBymaSoBienNhan_PrevAndNext(Session session,
		HoSoChungThuc hoSoChungThuc, String maSoBienNhan,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

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
			query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @return the matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop)
		throws SystemException {
		return findByTen_DT_DD(hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
			soDienThoaiCoDinhNguoiNop, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		int start, int end) throws SystemException {
		return findByTen_DT_DD(hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
			soDienThoaiCoDinhNguoiNop, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTen_DT_DD(String hoTenNguoiNopHoSo,
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

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

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
				query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
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

				list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so chung thuc in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTen_DT_DD_First(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		List<HoSoChungThuc> list = findByTen_DT_DD(hoTenNguoiNopHoSo,
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

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so chung thuc in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTen_DT_DD_Last(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		int count = countByTen_DT_DD(hoTenNguoiNopHoSo,
				soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop);

		List<HoSoChungThuc> list = findByTen_DT_DD(hoTenNguoiNopHoSo,
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

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the primary key of the current ho so chung thuc
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc[] findByTen_DT_DD_PrevAndNext(long hoSoChungThucId,
		String hoTenNguoiNopHoSo, String soDienThoaiDiDongNguoiNop,
		String soDienThoaiCoDinhNguoiNop, OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = findByPrimaryKey(hoSoChungThucId);

		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc[] array = new HoSoChungThucImpl[3];

			array[0] = getByTen_DT_DD_PrevAndNext(session, hoSoChungThuc,
					hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
					soDienThoaiCoDinhNguoiNop, orderByComparator, true);

			array[1] = hoSoChungThuc;

			array[2] = getByTen_DT_DD_PrevAndNext(session, hoSoChungThuc,
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

	protected HoSoChungThuc getByTen_DT_DD_PrevAndNext(Session session,
		HoSoChungThuc hoSoChungThuc, String hoTenNguoiNopHoSo,
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

		query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

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
			query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so chung thucs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoTTHCID(Long thuTucHanhChinhId)
		throws SystemException {
		return findByTheoTTHCID(thuTucHanhChinhId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so chung thucs where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoTTHCID(Long thuTucHanhChinhId,
		int start, int end) throws SystemException {
		return findByTheoTTHCID(thuTucHanhChinhId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoTTHCID(Long thuTucHanhChinhId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCID;
			finderArgs = new Object[] { thuTucHanhChinhId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCID;
			finderArgs = new Object[] {
					thuTucHanhChinhId,
					
					start, end, orderByComparator
				};
		}

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoTTHCID_First(Long thuTucHanhChinhId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		List<HoSoChungThuc> list = findByTheoTTHCID(thuTucHanhChinhId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoTTHCID_Last(Long thuTucHanhChinhId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		int count = countByTheoTTHCID(thuTucHanhChinhId);

		List<HoSoChungThuc> list = findByTheoTTHCID(thuTucHanhChinhId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the primary key of the current ho so chung thuc
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc[] findByTheoTTHCID_PrevAndNext(long hoSoChungThucId,
		Long thuTucHanhChinhId, OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = findByPrimaryKey(hoSoChungThucId);

		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc[] array = new HoSoChungThucImpl[3];

			array[0] = getByTheoTTHCID_PrevAndNext(session, hoSoChungThuc,
					thuTucHanhChinhId, orderByComparator, true);

			array[1] = hoSoChungThuc;

			array[2] = getByTheoTTHCID_PrevAndNext(session, hoSoChungThuc,
					thuTucHanhChinhId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoChungThuc getByTheoTTHCID_PrevAndNext(Session session,
		HoSoChungThuc hoSoChungThuc, Long thuTucHanhChinhId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

		query.append(_FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2);

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
			query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @return the matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(
		Long thuTucHanhChinhId, Long soDanhMucId) throws SystemException {
		return findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId, soDanhMucId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(
		Long thuTucHanhChinhId, Long soDanhMucId, int start, int end)
		throws SystemException {
		return findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId, soDanhMucId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(
		Long thuTucHanhChinhId, Long soDanhMucId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID;
			finderArgs = new Object[] { thuTucHanhChinhId, soDanhMucId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOTTHCIDANDSODANHMUCID;
			finderArgs = new Object[] {
					thuTucHanhChinhId, soDanhMucId,
					
					start, end, orderByComparator
				};
		}

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_SODANHMUCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				qPos.add(soDanhMucId.longValue());

				list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoTTHCIDAndSoDanhMucId_First(
		Long thuTucHanhChinhId, Long soDanhMucId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		List<HoSoChungThuc> list = findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
				soDanhMucId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", soDanhMucId=");
			msg.append(soDanhMucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoTTHCIDAndSoDanhMucId_Last(
		Long thuTucHanhChinhId, Long soDanhMucId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		int count = countByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
				soDanhMucId);

		List<HoSoChungThuc> list = findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
				soDanhMucId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTucHanhChinhId=");
			msg.append(thuTucHanhChinhId);

			msg.append(", soDanhMucId=");
			msg.append(soDanhMucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the primary key of the current ho so chung thuc
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc[] findByTheoTTHCIDAndSoDanhMucId_PrevAndNext(
		long hoSoChungThucId, Long thuTucHanhChinhId, Long soDanhMucId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = findByPrimaryKey(hoSoChungThucId);

		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc[] array = new HoSoChungThucImpl[3];

			array[0] = getByTheoTTHCIDAndSoDanhMucId_PrevAndNext(session,
					hoSoChungThuc, thuTucHanhChinhId, soDanhMucId,
					orderByComparator, true);

			array[1] = hoSoChungThuc;

			array[2] = getByTheoTTHCIDAndSoDanhMucId_PrevAndNext(session,
					hoSoChungThuc, thuTucHanhChinhId, soDanhMucId,
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

	protected HoSoChungThuc getByTheoTTHCIDAndSoDanhMucId_PrevAndNext(
		Session session, HoSoChungThuc hoSoChungThuc, Long thuTucHanhChinhId,
		Long soDanhMucId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

		query.append(_FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_THUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_SODANHMUCID_2);

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
			query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thuTucHanhChinhId.longValue());

		qPos.add(soDanhMucId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so chung thucs where soDanhMucId = &#63;.
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @return the matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoSoDanhMuc(Long soDanhMucId)
		throws SystemException {
		return findByTheoSoDanhMuc(soDanhMucId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so chung thucs where soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoSoDanhMuc(Long soDanhMucId, int start,
		int end) throws SystemException {
		return findByTheoSoDanhMuc(soDanhMucId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs where soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoSoDanhMuc(Long soDanhMucId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSODANHMUC;
			finderArgs = new Object[] { soDanhMucId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOSODANHMUC;
			finderArgs = new Object[] { soDanhMucId, start, end, orderByComparator };
		}

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOSODANHMUC_SODANHMUCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(soDanhMucId.longValue());

				list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so chung thuc in the ordered set where soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoSoDanhMuc_First(Long soDanhMucId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		List<HoSoChungThuc> list = findByTheoSoDanhMuc(soDanhMucId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soDanhMucId=");
			msg.append(soDanhMucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so chung thuc in the ordered set where soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoSoDanhMuc_Last(Long soDanhMucId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		int count = countByTheoSoDanhMuc(soDanhMucId);

		List<HoSoChungThuc> list = findByTheoSoDanhMuc(soDanhMucId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soDanhMucId=");
			msg.append(soDanhMucId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where soDanhMucId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the primary key of the current ho so chung thuc
	 * @param soDanhMucId the so danh muc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc[] findByTheoSoDanhMuc_PrevAndNext(
		long hoSoChungThucId, Long soDanhMucId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = findByPrimaryKey(hoSoChungThucId);

		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc[] array = new HoSoChungThucImpl[3];

			array[0] = getByTheoSoDanhMuc_PrevAndNext(session, hoSoChungThuc,
					soDanhMucId, orderByComparator, true);

			array[1] = hoSoChungThuc;

			array[2] = getByTheoSoDanhMuc_PrevAndNext(session, hoSoChungThuc,
					soDanhMucId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoChungThuc getByTheoSoDanhMuc_PrevAndNext(Session session,
		HoSoChungThuc hoSoChungThuc, Long soDanhMucId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

		query.append(_FINDER_COLUMN_THEOSODANHMUC_SODANHMUCID_2);

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
			query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(soDanhMucId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so chung thucs where soChungThuc = &#63;.
	 *
	 * @param soChungThuc the so chung thuc
	 * @return the matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoSoChungThuc(String soChungThuc)
		throws SystemException {
		return findByTheoSoChungThuc(soChungThuc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so chung thucs where soChungThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soChungThuc the so chung thuc
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoSoChungThuc(String soChungThuc,
		int start, int end) throws SystemException {
		return findByTheoSoChungThuc(soChungThuc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs where soChungThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soChungThuc the so chung thuc
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findByTheoSoChungThuc(String soChungThuc,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THEOSOCHUNGTHUC;
			finderArgs = new Object[] { soChungThuc };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THEOSOCHUNGTHUC;
			finderArgs = new Object[] { soChungThuc, start, end, orderByComparator };
		}

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

			if (soChungThuc == null) {
				query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_1);
			}
			else {
				if (soChungThuc.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_3);
				}
				else {
					query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (soChungThuc != null) {
					qPos.add(soChungThuc);
				}

				list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so chung thuc in the ordered set where soChungThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soChungThuc the so chung thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoSoChungThuc_First(String soChungThuc,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		List<HoSoChungThuc> list = findByTheoSoChungThuc(soChungThuc, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soChungThuc=");
			msg.append(soChungThuc);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so chung thuc in the ordered set where soChungThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param soChungThuc the so chung thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc findByTheoSoChungThuc_Last(String soChungThuc,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		int count = countByTheoSoChungThuc(soChungThuc);

		List<HoSoChungThuc> list = findByTheoSoChungThuc(soChungThuc,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soChungThuc=");
			msg.append(soChungThuc);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where soChungThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoChungThucId the primary key of the current ho so chung thuc
	 * @param soChungThuc the so chung thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so chung thuc
	 * @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoChungThuc[] findByTheoSoChungThuc_PrevAndNext(
		long hoSoChungThucId, String soChungThuc,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoChungThucException, SystemException {
		HoSoChungThuc hoSoChungThuc = findByPrimaryKey(hoSoChungThucId);

		Session session = null;

		try {
			session = openSession();

			HoSoChungThuc[] array = new HoSoChungThucImpl[3];

			array[0] = getByTheoSoChungThuc_PrevAndNext(session, hoSoChungThuc,
					soChungThuc, orderByComparator, true);

			array[1] = hoSoChungThuc;

			array[2] = getByTheoSoChungThuc_PrevAndNext(session, hoSoChungThuc,
					soChungThuc, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoChungThuc getByTheoSoChungThuc_PrevAndNext(Session session,
		HoSoChungThuc hoSoChungThuc, String soChungThuc,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOCHUNGTHUC_WHERE);

		if (soChungThuc == null) {
			query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_1);
		}
		else {
			if (soChungThuc.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_3);
			}
			else {
				query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_2);
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
			query.append(HoSoChungThucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (soChungThuc != null) {
			qPos.add(soChungThuc);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so chung thucs.
	 *
	 * @return the ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so chung thucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so chung thucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoChungThuc> findAll(int start, int end,
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

		List<HoSoChungThuc> list = (List<HoSoChungThuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOSOCHUNGTHUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOSOCHUNGTHUC.concat(HoSoChungThucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoSoChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ho so chung thucs where maSoBienNhan = &#63; from the database.
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBymaSoBienNhan(String maSoBienNhan)
		throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findBymaSoBienNhan(maSoBienNhan)) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Removes all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63; from the database.
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen_DT_DD(String hoTenNguoiNopHoSo,
		String soDienThoaiDiDongNguoiNop, String soDienThoaiCoDinhNguoiNop)
		throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findByTen_DT_DD(hoTenNguoiNopHoSo,
				soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop)) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Removes all the ho so chung thucs where thuTucHanhChinhId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoTTHCID(Long thuTucHanhChinhId)
		throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findByTheoTTHCID(thuTucHanhChinhId)) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Removes all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63; from the database.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoTTHCIDAndSoDanhMucId(Long thuTucHanhChinhId,
		Long soDanhMucId) throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findByTheoTTHCIDAndSoDanhMucId(
				thuTucHanhChinhId, soDanhMucId)) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Removes all the ho so chung thucs where soDanhMucId = &#63; from the database.
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoSoDanhMuc(Long soDanhMucId)
		throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findByTheoSoDanhMuc(soDanhMucId)) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Removes all the ho so chung thucs where soChungThuc = &#63; from the database.
	 *
	 * @param soChungThuc the so chung thuc
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTheoSoChungThuc(String soChungThuc)
		throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findByTheoSoChungThuc(soChungThuc)) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Removes all the ho so chung thucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoSoChungThuc hoSoChungThuc : findAll()) {
			remove(hoSoChungThuc);
		}
	}

	/**
	 * Returns the number of ho so chung thucs where maSoBienNhan = &#63;.
	 *
	 * @param maSoBienNhan the ma so bien nhan
	 * @return the number of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countBymaSoBienNhan(String maSoBienNhan)
		throws SystemException {
		Object[] finderArgs = new Object[] { maSoBienNhan };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MASOBIENNHAN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOCHUNGTHUC_WHERE);

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
	 * Returns the number of ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	 *
	 * @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	 * @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	 * @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	 * @return the number of matching ho so chung thucs
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

			query.append(_SQL_COUNT_HOSOCHUNGTHUC_WHERE);

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
	 * Returns the number of ho so chung thucs where thuTucHanhChinhId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @return the number of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoTTHCID(Long thuTucHanhChinhId)
		throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOTTHCID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	 *
	 * @param thuTucHanhChinhId the thu tuc hanh chinh ID
	 * @param soDanhMucId the so danh muc ID
	 * @return the number of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoTTHCIDAndSoDanhMucId(Long thuTucHanhChinhId,
		Long soDanhMucId) throws SystemException {
		Object[] finderArgs = new Object[] { thuTucHanhChinhId, soDanhMucId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDSODANHMUCID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_THUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_SODANHMUCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTucHanhChinhId.longValue());

				qPos.add(soDanhMucId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOTTHCIDANDSODANHMUCID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so chung thucs where soDanhMucId = &#63;.
	 *
	 * @param soDanhMucId the so danh muc ID
	 * @return the number of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoSoDanhMuc(Long soDanhMucId) throws SystemException {
		Object[] finderArgs = new Object[] { soDanhMucId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOSODANHMUC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_THEOSODANHMUC_SODANHMUCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(soDanhMucId.longValue());

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOSODANHMUC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so chung thucs where soChungThuc = &#63;.
	 *
	 * @param soChungThuc the so chung thuc
	 * @return the number of matching ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTheoSoChungThuc(String soChungThuc)
		throws SystemException {
		Object[] finderArgs = new Object[] { soChungThuc };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THEOSOCHUNGTHUC,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOCHUNGTHUC_WHERE);

			if (soChungThuc == null) {
				query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_1);
			}
			else {
				if (soChungThuc.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_3);
				}
				else {
					query.append(_FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (soChungThuc != null) {
					qPos.add(soChungThuc);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THEOSOCHUNGTHUC,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so chung thucs.
	 *
	 * @return the number of ho so chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOSOCHUNGTHUC);

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
	 * Returns all the thanh phan ho so chung thucs associated with the ho so chung thuc.
	 *
	 * @param pk the primary key of the ho so chung thuc
	 * @return the thanh phan ho so chung thucs associated with the ho so chung thuc
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		long pk) throws SystemException {
		return getThanhPhanHoSoChungThucs(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the thanh phan ho so chung thucs associated with the ho so chung thuc.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the ho so chung thuc
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @return the range of thanh phan ho so chung thucs associated with the ho so chung thuc
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		long pk, int start, int end) throws SystemException {
		return getThanhPhanHoSoChungThucs(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS = new FinderPath(org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl.class,
			org.oep.cmon.dao.chungthuc.service.persistence.ThanhPhanHoSoChungThucPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getThanhPhanHoSoChungThucs",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Returns an ordered range of all the thanh phan ho so chung thucs associated with the ho so chung thuc.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the ho so chung thuc
	 * @param start the lower bound of the range of ho so chung thucs
	 * @param end the upper bound of the range of ho so chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thanh phan ho so chung thucs associated with the ho so chung thuc
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> list = (List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc>)FinderCacheUtil.getResult(FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETTHANHPHANHOSOCHUNGTHUCS.concat(ORDER_BY_CLAUSE)
														 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETTHANHPHANHOSOCHUNGTHUCS.concat(org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("CMON_THANHPHANHOSOCHUNGTHUC",
					org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS,
						finderArgs);
				}
				else {
					thanhPhanHoSoChungThucPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS_SIZE = new FinderPath(org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl.class,
			org.oep.cmon.dao.chungthuc.service.persistence.ThanhPhanHoSoChungThucPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getThanhPhanHoSoChungThucsSize",
			new String[] { Long.class.getName() });

	/**
	 * Returns the number of thanh phan ho so chung thucs associated with the ho so chung thuc.
	 *
	 * @param pk the primary key of the ho so chung thuc
	 * @return the number of thanh phan ho so chung thucs associated with the ho so chung thuc
	 * @throws SystemException if a system exception occurred
	 */
	public int getThanhPhanHoSoChungThucsSize(long pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETTHANHPHANHOSOCHUNGTHUCSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_THANHPHANHOSOCHUNGTHUCS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_THANHPHANHOSOCHUNGTHUC = new FinderPath(org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.ENTITY_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucModelImpl.FINDER_CACHE_ENABLED,
			org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl.class,
			org.oep.cmon.dao.chungthuc.service.persistence.ThanhPhanHoSoChungThucPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsThanhPhanHoSoChungThuc",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the thanh phan ho so chung thuc is associated with the ho so chung thuc.
	 *
	 * @param pk the primary key of the ho so chung thuc
	 * @param thanhPhanHoSoChungThucPK the primary key of the thanh phan ho so chung thuc
	 * @return <code>true</code> if the thanh phan ho so chung thuc is associated with the ho so chung thuc; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsThanhPhanHoSoChungThuc(long pk,
		long thanhPhanHoSoChungThucPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, thanhPhanHoSoChungThucPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_THANHPHANHOSOCHUNGTHUC,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsThanhPhanHoSoChungThuc.contains(
							pk, thanhPhanHoSoChungThucPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_THANHPHANHOSOCHUNGTHUC,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the ho so chung thuc has any thanh phan ho so chung thucs associated with it.
	 *
	 * @param pk the primary key of the ho so chung thuc to check for associations with thanh phan ho so chung thucs
	 * @return <code>true</code> if the ho so chung thuc has any thanh phan ho so chung thucs associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsThanhPhanHoSoChungThucs(long pk)
		throws SystemException {
		if (getThanhPhanHoSoChungThucsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the ho so chung thuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.chungthuc.model.HoSoChungThuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoSoChungThuc>> listenersList = new ArrayList<ModelListener<HoSoChungThuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoSoChungThuc>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsThanhPhanHoSoChungThuc = new ContainsThanhPhanHoSoChungThuc();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(HoSoChungThucImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = HoSoChungThucPersistence.class)
	protected HoSoChungThucPersistence hoSoChungThucPersistence;
	@BeanReference(type = SoDanhMucPersistence.class)
	protected SoDanhMucPersistence soDanhMucPersistence;
	@BeanReference(type = ThanhPhanHoSoChungThucPersistence.class)
	protected ThanhPhanHoSoChungThucPersistence thanhPhanHoSoChungThucPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsThanhPhanHoSoChungThuc containsThanhPhanHoSoChungThuc;

	protected class ContainsThanhPhanHoSoChungThuc {
		protected ContainsThanhPhanHoSoChungThuc() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSTHANHPHANHOSOCHUNGTHUC,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long hoSoChungThucId, long thanhPhanHoSoId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(hoSoChungThucId), new Long(thanhPhanHoSoId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_HOSOCHUNGTHUC = "SELECT hoSoChungThuc FROM HoSoChungThuc hoSoChungThuc";
	private static final String _SQL_SELECT_HOSOCHUNGTHUC_WHERE = "SELECT hoSoChungThuc FROM HoSoChungThuc hoSoChungThuc WHERE ";
	private static final String _SQL_COUNT_HOSOCHUNGTHUC = "SELECT COUNT(hoSoChungThuc) FROM HoSoChungThuc hoSoChungThuc";
	private static final String _SQL_COUNT_HOSOCHUNGTHUC_WHERE = "SELECT COUNT(hoSoChungThuc) FROM HoSoChungThuc hoSoChungThuc WHERE ";
	private static final String _SQL_GETTHANHPHANHOSOCHUNGTHUCS = "SELECT {CMON_THANHPHANHOSOCHUNGTHUC.*} FROM CMON_THANHPHANHOSOCHUNGTHUC INNER JOIN CMON_HOSOCHUNGTHUC ON (CMON_HOSOCHUNGTHUC.ID = CMON_THANHPHANHOSOCHUNGTHUC.ID) WHERE (CMON_HOSOCHUNGTHUC.ID = ?)";
	private static final String _SQL_GETTHANHPHANHOSOCHUNGTHUCSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM CMON_THANHPHANHOSOCHUNGTHUC WHERE ID = ?";
	private static final String _SQL_CONTAINSTHANHPHANHOSOCHUNGTHUC = "SELECT COUNT(*) AS COUNT_VALUE FROM CMON_THANHPHANHOSOCHUNGTHUC WHERE ID = ? AND ID = ?";
	private static final String _FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_1 = "hoSoChungThuc.maSoBienNhan IS NULL";
	private static final String _FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_2 = "hoSoChungThuc.maSoBienNhan = ?";
	private static final String _FINDER_COLUMN_MASOBIENNHAN_MASOBIENNHAN_3 = "(hoSoChungThuc.maSoBienNhan IS NULL OR hoSoChungThuc.maSoBienNhan = ?)";
	private static final String _FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_1 = "hoSoChungThuc.hoTenNguoiNopHoSo IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_2 = "hoSoChungThuc.hoTenNguoiNopHoSo = ? AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_HOTENNGUOINOPHOSO_3 = "(hoSoChungThuc.hoTenNguoiNopHoSo IS NULL OR hoSoChungThuc.hoTenNguoiNopHoSo = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_1 =
		"hoSoChungThuc.soDienThoaiDiDongNguoiNop IS NULL AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_2 =
		"hoSoChungThuc.soDienThoaiDiDongNguoiNop = ? AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAIDIDONGNGUOINOP_3 =
		"(hoSoChungThuc.soDienThoaiDiDongNguoiNop IS NULL OR hoSoChungThuc.soDienThoaiDiDongNguoiNop = ?) AND ";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_1 =
		"hoSoChungThuc.soDienThoaiCoDinhNguoiNop IS NULL";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_2 =
		"hoSoChungThuc.soDienThoaiCoDinhNguoiNop = ?";
	private static final String _FINDER_COLUMN_TEN_DT_DD_SODIENTHOAICODINHNGUOINOP_3 =
		"(hoSoChungThuc.soDienThoaiCoDinhNguoiNop IS NULL OR hoSoChungThuc.soDienThoaiCoDinhNguoiNop = ?)";
	private static final String _FINDER_COLUMN_THEOTTHCID_THUTUCHANHCHINHID_2 = "hoSoChungThuc.thuTucHanhChinhId = ?";
	private static final String _FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_THUTUCHANHCHINHID_2 =
		"hoSoChungThuc.thuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_THEOTTHCIDANDSODANHMUCID_SODANHMUCID_2 =
		"hoSoChungThuc.soDanhMucId = ?";
	private static final String _FINDER_COLUMN_THEOSODANHMUC_SODANHMUCID_2 = "hoSoChungThuc.soDanhMucId = ?";
	private static final String _FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_1 = "hoSoChungThuc.soChungThuc IS NULL";
	private static final String _FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_2 = "hoSoChungThuc.soChungThuc = ?";
	private static final String _FINDER_COLUMN_THEOSOCHUNGTHUC_SOCHUNGTHUC_3 = "(hoSoChungThuc.soChungThuc IS NULL OR hoSoChungThuc.soChungThuc = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoSoChungThuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoSoChungThuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HoSoChungThuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoSoChungThucPersistenceImpl.class);
	private static HoSoChungThuc _nullHoSoChungThuc = new HoSoChungThucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoSoChungThuc> toCacheModel() {
				return _nullHoSoChungThucCacheModel;
			}
		};

	private static CacheModel<HoSoChungThuc> _nullHoSoChungThucCacheModel = new CacheModel<HoSoChungThuc>() {
			public HoSoChungThuc toEntityModel() {
				return _nullHoSoChungThuc;
			}
		};
}