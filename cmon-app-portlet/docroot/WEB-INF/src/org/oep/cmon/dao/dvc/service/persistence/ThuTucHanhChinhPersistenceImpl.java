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

import org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl;
import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the thu tuc hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see ThuTucHanhChinhPersistence
 * @see ThuTucHanhChinhUtil
 * @generated
 */
public class ThuTucHanhChinhPersistenceImpl extends BasePersistenceImpl<ThuTucHanhChinh>
	implements ThuTucHanhChinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThuTucHanhChinhUtil} to access the thu tuc hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThuTucHanhChinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			ThuTucHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			ThuTucHanhChinhModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			ThuTucHanhChinhModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH =
		new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNhomDanhMucHanhChinh",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH =
		new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNhomDanhMucHanhChinh",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ThuTucHanhChinhModelImpl.NHOMTHUTUCHANHCHINHID_COLUMN_BITMASK |
			ThuTucHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NHOMDANHMUCHANHCHINH = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNhomDanhMucHanhChinh",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the thu tuc hanh chinh in the entity cache if it is enabled.
	 *
	 * @param thuTucHanhChinh the thu tuc hanh chinh
	 */
	public void cacheResult(ThuTucHanhChinh thuTucHanhChinh) {
		EntityCacheUtil.putResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey(),
			thuTucHanhChinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { thuTucHanhChinh.getMa() }, thuTucHanhChinh);

		thuTucHanhChinh.resetOriginalValues();
	}

	/**
	 * Caches the thu tuc hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param thuTucHanhChinhs the thu tuc hanh chinhs
	 */
	public void cacheResult(List<ThuTucHanhChinh> thuTucHanhChinhs) {
		for (ThuTucHanhChinh thuTucHanhChinh : thuTucHanhChinhs) {
			if (EntityCacheUtil.getResult(
						ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						ThuTucHanhChinhImpl.class,
						thuTucHanhChinh.getPrimaryKey()) == null) {
				cacheResult(thuTucHanhChinh);
			}
			else {
				thuTucHanhChinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thu tuc hanh chinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThuTucHanhChinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThuTucHanhChinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thu tuc hanh chinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThuTucHanhChinh thuTucHanhChinh) {
		EntityCacheUtil.removeResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(thuTucHanhChinh);
	}

	@Override
	public void clearCache(List<ThuTucHanhChinh> thuTucHanhChinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThuTucHanhChinh thuTucHanhChinh : thuTucHanhChinhs) {
			EntityCacheUtil.removeResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey());

			clearUniqueFindersCache(thuTucHanhChinh);
		}
	}

	protected void clearUniqueFindersCache(ThuTucHanhChinh thuTucHanhChinh) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { thuTucHanhChinh.getMa() });
	}

	/**
	 * Creates a new thu tuc hanh chinh with the primary key. Does not add the thu tuc hanh chinh to the database.
	 *
	 * @param id the primary key for the new thu tuc hanh chinh
	 * @return the new thu tuc hanh chinh
	 */
	public ThuTucHanhChinh create(long id) {
		ThuTucHanhChinh thuTucHanhChinh = new ThuTucHanhChinhImpl();

		thuTucHanhChinh.setNew(true);
		thuTucHanhChinh.setPrimaryKey(id);

		return thuTucHanhChinh;
	}

	/**
	 * Removes the thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thu tuc hanh chinh
	 * @return the thu tuc hanh chinh that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh remove(long id)
		throws NoSuchThuTucHanhChinhException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thu tuc hanh chinh
	 * @return the thu tuc hanh chinh that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThuTucHanhChinh remove(Serializable primaryKey)
		throws NoSuchThuTucHanhChinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThuTucHanhChinh thuTucHanhChinh = (ThuTucHanhChinh)session.get(ThuTucHanhChinhImpl.class,
					primaryKey);

			if (thuTucHanhChinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThuTucHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thuTucHanhChinh);
		}
		catch (NoSuchThuTucHanhChinhException nsee) {
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
	protected ThuTucHanhChinh removeImpl(ThuTucHanhChinh thuTucHanhChinh)
		throws SystemException {
		thuTucHanhChinh = toUnwrappedModel(thuTucHanhChinh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, thuTucHanhChinh);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(thuTucHanhChinh);

		return thuTucHanhChinh;
	}

	@Override
	public ThuTucHanhChinh updateImpl(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh,
		boolean merge) throws SystemException {
		thuTucHanhChinh = toUnwrappedModel(thuTucHanhChinh);

		boolean isNew = thuTucHanhChinh.isNew();

		ThuTucHanhChinhModelImpl thuTucHanhChinhModelImpl = (ThuTucHanhChinhModelImpl)thuTucHanhChinh;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, thuTucHanhChinh, merge);

			thuTucHanhChinh.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThuTucHanhChinhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thuTucHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(thuTucHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(thuTucHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((thuTucHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						thuTucHanhChinhModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { thuTucHanhChinhModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((thuTucHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(thuTucHanhChinhModelImpl.getOriginalNhomThuTucHanhChinhId()),
						Integer.valueOf(thuTucHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMDANHMUCHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH,
					args);

				args = new Object[] {
						Long.valueOf(thuTucHanhChinhModelImpl.getNhomThuTucHanhChinhId()),
						Integer.valueOf(thuTucHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NHOMDANHMUCHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH,
					args);
			}
		}

		EntityCacheUtil.putResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey(),
			thuTucHanhChinh);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { thuTucHanhChinh.getMa() }, thuTucHanhChinh);
		}
		else {
			if ((thuTucHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						thuTucHanhChinhModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { thuTucHanhChinh.getMa() }, thuTucHanhChinh);
			}
		}

		return thuTucHanhChinh;
	}

	protected ThuTucHanhChinh toUnwrappedModel(ThuTucHanhChinh thuTucHanhChinh) {
		if (thuTucHanhChinh instanceof ThuTucHanhChinhImpl) {
			return thuTucHanhChinh;
		}

		ThuTucHanhChinhImpl thuTucHanhChinhImpl = new ThuTucHanhChinhImpl();

		thuTucHanhChinhImpl.setNew(thuTucHanhChinh.isNew());
		thuTucHanhChinhImpl.setPrimaryKey(thuTucHanhChinh.getPrimaryKey());

		thuTucHanhChinhImpl.setId(thuTucHanhChinh.getId());
		thuTucHanhChinhImpl.setMa(thuTucHanhChinh.getMa());
		thuTucHanhChinhImpl.setTen(thuTucHanhChinh.getTen());
		thuTucHanhChinhImpl.setSoNgayXuLy(thuTucHanhChinh.getSoNgayXuLy());
		thuTucHanhChinhImpl.setNgayTao(thuTucHanhChinh.getNgayTao());
		thuTucHanhChinhImpl.setNgaySua(thuTucHanhChinh.getNgaySua());
		thuTucHanhChinhImpl.setDaXoa(thuTucHanhChinh.getDaXoa());
		thuTucHanhChinhImpl.setNguoiTao(thuTucHanhChinh.getNguoiTao());
		thuTucHanhChinhImpl.setNguoiSua(thuTucHanhChinh.getNguoiSua());
		thuTucHanhChinhImpl.setNhomThuTucHanhChinhId(thuTucHanhChinh.getNhomThuTucHanhChinhId());
		thuTucHanhChinhImpl.setTrangThai(thuTucHanhChinh.getTrangThai());
		thuTucHanhChinhImpl.setPhienBan(thuTucHanhChinh.getPhienBan());
		thuTucHanhChinhImpl.setCanTichHop(thuTucHanhChinh.getCanTichHop());
		thuTucHanhChinhImpl.setTrinhTuThucHien(thuTucHanhChinh.getTrinhTuThucHien());
		thuTucHanhChinhImpl.setCachThucHien(thuTucHanhChinh.getCachThucHien());
		thuTucHanhChinhImpl.setThanhPhanHoSo(thuTucHanhChinh.getThanhPhanHoSo());
		thuTucHanhChinhImpl.setLePhi(thuTucHanhChinh.getLePhi());
		thuTucHanhChinhImpl.setDonViLePhi(thuTucHanhChinh.getDonViLePhi());
		thuTucHanhChinhImpl.setPhi(thuTucHanhChinh.getPhi());
		thuTucHanhChinhImpl.setDonViPhi(thuTucHanhChinh.getDonViPhi());
		thuTucHanhChinhImpl.setTenMauDonToKhai(thuTucHanhChinh.getTenMauDonToKhai());
		thuTucHanhChinhImpl.setYeuCauDieuKienThucHien(thuTucHanhChinh.getYeuCauDieuKienThucHien());
		thuTucHanhChinhImpl.setCanCuPhapLy(thuTucHanhChinh.getCanCuPhapLy());
		thuTucHanhChinhImpl.setCapCoQuanQuanLyId(thuTucHanhChinh.getCapCoQuanQuanLyId());
		thuTucHanhChinhImpl.setLinhVucThucHien(thuTucHanhChinh.getLinhVucThucHien());
		thuTucHanhChinhImpl.setMaDNG(thuTucHanhChinh.getMaDNG());
		thuTucHanhChinhImpl.setUengineProcessName(thuTucHanhChinh.getUengineProcessName());
		thuTucHanhChinhImpl.setThuTucLienThongId(thuTucHanhChinh.getThuTucLienThongId());

		return thuTucHanhChinhImpl;
	}

	/**
	 * Returns the thu tuc hanh chinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the thu tuc hanh chinh
	 * @return the thu tuc hanh chinh
	 * @throws com.liferay.portal.NoSuchModelException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThuTucHanhChinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thu tuc hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException} if it could not be found.
	 *
	 * @param id the primary key of the thu tuc hanh chinh
	 * @return the thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByPrimaryKey(long id)
		throws NoSuchThuTucHanhChinhException, SystemException {
		ThuTucHanhChinh thuTucHanhChinh = fetchByPrimaryKey(id);

		if (thuTucHanhChinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchThuTucHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return thuTucHanhChinh;
	}

	/**
	 * Returns the thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thu tuc hanh chinh
	 * @return the thu tuc hanh chinh, or <code>null</code> if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThuTucHanhChinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thu tuc hanh chinh
	 * @return the thu tuc hanh chinh, or <code>null</code> if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh fetchByPrimaryKey(long id) throws SystemException {
		ThuTucHanhChinh thuTucHanhChinh = (ThuTucHanhChinh)EntityCacheUtil.getResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				ThuTucHanhChinhImpl.class, id);

		if (thuTucHanhChinh == _nullThuTucHanhChinh) {
			return null;
		}

		if (thuTucHanhChinh == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				thuTucHanhChinh = (ThuTucHanhChinh)session.get(ThuTucHanhChinhImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (thuTucHanhChinh != null) {
					cacheResult(thuTucHanhChinh);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						ThuTucHanhChinhImpl.class, id, _nullThuTucHanhChinh);
				}

				closeSession(session);
			}
		}

		return thuTucHanhChinh;
	}

	/**
	 * Returns all the thu tuc hanh chinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc hanh chinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @return the range of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc hanh chinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByTrangThai(int daXoa, int start, int end,
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

		List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<ThuTucHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		List<ThuTucHanhChinh> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		int count = countByTrangThai(daXoa);

		List<ThuTucHanhChinh> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thu tuc hanh chinh
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		ThuTucHanhChinh thuTucHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThuTucHanhChinh[] array = new ThuTucHanhChinhImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, thuTucHanhChinh,
					daXoa, orderByComparator, true);

			array[1] = thuTucHanhChinh;

			array[2] = getByTrangThai_PrevAndNext(session, thuTucHanhChinh,
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

	protected ThuTucHanhChinh getByTrangThai_PrevAndNext(Session session,
		ThuTucHanhChinh thuTucHanhChinh, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

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
			query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thuTucHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThuTucHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the thu tuc hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByMa(String ma)
		throws NoSuchThuTucHanhChinhException, SystemException {
		ThuTucHanhChinh thuTucHanhChinh = fetchByMa(ma);

		if (thuTucHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}

		return thuTucHanhChinh;
	}

	/**
	 * Returns the thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching thu tuc hanh chinh, or <code>null</code> if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching thu tuc hanh chinh, or <code>null</code> if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<ThuTucHanhChinh> list = q.list();

				result = list;

				ThuTucHanhChinh thuTucHanhChinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					thuTucHanhChinh = list.get(0);

					cacheResult(thuTucHanhChinh);

					if ((thuTucHanhChinh.getMa() == null) ||
							!thuTucHanhChinh.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, thuTucHanhChinh);
					}
				}

				return thuTucHanhChinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ThuTucHanhChinh)result;
			}
		}
	}

	/**
	 * Returns all the thu tuc hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByTen(String ten)
		throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc hanh chinhs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @return the range of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc hanh chinhs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByTen(String ten, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten, start, end, orderByComparator };
		}

		List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				list = (List<ThuTucHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first thu tuc hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		List<ThuTucHanhChinh> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thu tuc hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		int count = countByTen(ten);

		List<ThuTucHanhChinh> list = findByTen(ten, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thu tuc hanh chinh
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		ThuTucHanhChinh thuTucHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThuTucHanhChinh[] array = new ThuTucHanhChinhImpl[3];

			array[0] = getByTen_PrevAndNext(session, thuTucHanhChinh, ten,
					orderByComparator, true);

			array[1] = thuTucHanhChinh;

			array[2] = getByTen_PrevAndNext(session, thuTucHanhChinh, ten,
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

	protected ThuTucHanhChinh getByTen_PrevAndNext(Session session,
		ThuTucHanhChinh thuTucHanhChinh, String ten,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

		if (ten == null) {
			query.append(_FINDER_COLUMN_TEN_TEN_1);
		}
		else {
			if (ten.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEN_TEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_TEN_TEN_2);
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
			query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ten != null) {
			qPos.add(ten);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thuTucHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThuTucHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa) throws SystemException {
		return findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @return the range of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa, int start, int end)
		throws SystemException {
		return findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH;
			finderArgs = new Object[] { nhomThuTucHanhChinhId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NHOMDANHMUCHANHCHINH;
			finderArgs = new Object[] {
					nhomThuTucHanhChinhId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_NHOMDANHMUCHANHCHINH_NHOMTHUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_NHOMDANHMUCHANHCHINH_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomThuTucHanhChinhId);

				qPos.add(daXoa);

				list = (List<ThuTucHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByNhomDanhMucHanhChinh_First(
		long nhomThuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		List<ThuTucHanhChinh> list = findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nhomThuTucHanhChinhId=");
			msg.append(nhomThuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh findByNhomDanhMucHanhChinh_Last(
		long nhomThuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		int count = countByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa);

		List<ThuTucHanhChinh> list = findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nhomThuTucHanhChinhId=");
			msg.append(nhomThuTucHanhChinhId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThuTucHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thu tuc hanh chinh
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thu tuc hanh chinh
	 * @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThuTucHanhChinh[] findByNhomDanhMucHanhChinh_PrevAndNext(long id,
		long nhomThuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchThuTucHanhChinhException, SystemException {
		ThuTucHanhChinh thuTucHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThuTucHanhChinh[] array = new ThuTucHanhChinhImpl[3];

			array[0] = getByNhomDanhMucHanhChinh_PrevAndNext(session,
					thuTucHanhChinh, nhomThuTucHanhChinhId, daXoa,
					orderByComparator, true);

			array[1] = thuTucHanhChinh;

			array[2] = getByNhomDanhMucHanhChinh_PrevAndNext(session,
					thuTucHanhChinh, nhomThuTucHanhChinhId, daXoa,
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

	protected ThuTucHanhChinh getByNhomDanhMucHanhChinh_PrevAndNext(
		Session session, ThuTucHanhChinh thuTucHanhChinh,
		long nhomThuTucHanhChinhId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THUTUCHANHCHINH_WHERE);

		query.append(_FINDER_COLUMN_NHOMDANHMUCHANHCHINH_NHOMTHUTUCHANHCHINHID_2);

		query.append(_FINDER_COLUMN_NHOMDANHMUCHANHCHINH_DAXOA_2);

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
			query.append(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomThuTucHanhChinhId);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thuTucHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThuTucHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thu tuc hanh chinhs.
	 *
	 * @return the thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thu tuc hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @return the range of thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thu tuc hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thu tuc hanh chinhs
	 * @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThuTucHanhChinh> findAll(int start, int end,
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

		List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THUTUCHANHCHINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THUTUCHANHCHINH.concat(ThuTucHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ThuTucHanhChinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ThuTucHanhChinh>)QueryUtil.list(q,
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
	 * Removes all the thu tuc hanh chinhs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (ThuTucHanhChinh thuTucHanhChinh : findByTrangThai(daXoa)) {
			remove(thuTucHanhChinh);
		}
	}

	/**
	 * Removes the thu tuc hanh chinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchThuTucHanhChinhException, SystemException {
		ThuTucHanhChinh thuTucHanhChinh = findByMa(ma);

		remove(thuTucHanhChinh);
	}

	/**
	 * Removes all the thu tuc hanh chinhs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (ThuTucHanhChinh thuTucHanhChinh : findByTen(ten)) {
			remove(thuTucHanhChinh);
		}
	}

	/**
	 * Removes all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNhomDanhMucHanhChinh(long nhomThuTucHanhChinhId,
		int daXoa) throws SystemException {
		for (ThuTucHanhChinh thuTucHanhChinh : findByNhomDanhMucHanhChinh(
				nhomThuTucHanhChinhId, daXoa)) {
			remove(thuTucHanhChinh);
		}
	}

	/**
	 * Removes all the thu tuc hanh chinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ThuTucHanhChinh thuTucHanhChinh : findAll()) {
			remove(thuTucHanhChinh);
		}
	}

	/**
	 * Returns the number of thu tuc hanh chinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THUTUCHANHCHINH_WHERE);

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
	 * Returns the number of thu tuc hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THUTUCHANHCHINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MA, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thu tuc hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THUTUCHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	 *
	 * @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	 * @param daXoa the da xoa
	 * @return the number of matching thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNhomDanhMucHanhChinh(long nhomThuTucHanhChinhId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { nhomThuTucHanhChinhId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NHOMDANHMUCHANHCHINH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_THUTUCHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_NHOMDANHMUCHANHCHINH_NHOMTHUTUCHANHCHINHID_2);

			query.append(_FINDER_COLUMN_NHOMDANHMUCHANHCHINH_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomThuTucHanhChinhId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NHOMDANHMUCHANHCHINH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thu tuc hanh chinhs.
	 *
	 * @return the number of thu tuc hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THUTUCHANHCHINH);

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
	 * Initializes the thu tuc hanh chinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.ThuTucHanhChinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThuTucHanhChinh>> listenersList = new ArrayList<ModelListener<ThuTucHanhChinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThuTucHanhChinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ThuTucHanhChinhImpl.class.getName());
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
	private static final String _SQL_SELECT_THUTUCHANHCHINH = "SELECT thuTucHanhChinh FROM ThuTucHanhChinh thuTucHanhChinh";
	private static final String _SQL_SELECT_THUTUCHANHCHINH_WHERE = "SELECT thuTucHanhChinh FROM ThuTucHanhChinh thuTucHanhChinh WHERE ";
	private static final String _SQL_COUNT_THUTUCHANHCHINH = "SELECT COUNT(thuTucHanhChinh) FROM ThuTucHanhChinh thuTucHanhChinh";
	private static final String _SQL_COUNT_THUTUCHANHCHINH_WHERE = "SELECT COUNT(thuTucHanhChinh) FROM ThuTucHanhChinh thuTucHanhChinh WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "thuTucHanhChinh.daXoa = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "thuTucHanhChinh.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "thuTucHanhChinh.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(thuTucHanhChinh.ma IS NULL OR thuTucHanhChinh.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "thuTucHanhChinh.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "thuTucHanhChinh.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(thuTucHanhChinh.ten IS NULL OR thuTucHanhChinh.ten = ?)";
	private static final String _FINDER_COLUMN_NHOMDANHMUCHANHCHINH_NHOMTHUTUCHANHCHINHID_2 =
		"thuTucHanhChinh.nhomThuTucHanhChinhId = ? AND ";
	private static final String _FINDER_COLUMN_NHOMDANHMUCHANHCHINH_DAXOA_2 = "thuTucHanhChinh.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thuTucHanhChinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThuTucHanhChinh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThuTucHanhChinh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThuTucHanhChinhPersistenceImpl.class);
	private static ThuTucHanhChinh _nullThuTucHanhChinh = new ThuTucHanhChinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ThuTucHanhChinh> toCacheModel() {
				return _nullThuTucHanhChinhCacheModel;
			}
		};

	private static CacheModel<ThuTucHanhChinh> _nullThuTucHanhChinhCacheModel = new CacheModel<ThuTucHanhChinh>() {
			public ThuTucHanhChinh toEntityModel() {
				return _nullThuTucHanhChinh;
			}
		};
}