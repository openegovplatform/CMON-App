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

package org.oep.cmon.dao.csms.service.persistence;

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

import org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException;
import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;
import org.oep.cmon.dao.csms.model.impl.YeuCauDangKyCongDanImpl;
import org.oep.cmon.dao.csms.model.impl.YeuCauDangKyCongDanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the yeu cau dang ky cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see YeuCauDangKyCongDanPersistence
 * @see YeuCauDangKyCongDanUtil
 * @generated
 */
public class YeuCauDangKyCongDanPersistenceImpl extends BasePersistenceImpl<YeuCauDangKyCongDan>
	implements YeuCauDangKyCongDanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YeuCauDangKyCongDanUtil} to access the yeu cau dang ky cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YeuCauDangKyCongDanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAXACNHAN =
		new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaXacNhan",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAXACNHAN =
		new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaXacNhan",
			new String[] { String.class.getName() },
			YeuCauDangKyCongDanModelImpl.MAXACNHAN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAXACNHAN = new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaXacNhan",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCMND = new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySoCmnd",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND =
		new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySoCmnd",
			new String[] { String.class.getName() },
			YeuCauDangKyCongDanModelImpl.SOCMND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOCMND = new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoCmnd",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the yeu cau dang ky cong dan in the entity cache if it is enabled.
	 *
	 * @param yeuCauDangKyCongDan the yeu cau dang ky cong dan
	 */
	public void cacheResult(YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		EntityCacheUtil.putResult(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class, yeuCauDangKyCongDan.getPrimaryKey(),
			yeuCauDangKyCongDan);

		yeuCauDangKyCongDan.resetOriginalValues();
	}

	/**
	 * Caches the yeu cau dang ky cong dans in the entity cache if it is enabled.
	 *
	 * @param yeuCauDangKyCongDans the yeu cau dang ky cong dans
	 */
	public void cacheResult(List<YeuCauDangKyCongDan> yeuCauDangKyCongDans) {
		for (YeuCauDangKyCongDan yeuCauDangKyCongDan : yeuCauDangKyCongDans) {
			if (EntityCacheUtil.getResult(
						YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauDangKyCongDanImpl.class,
						yeuCauDangKyCongDan.getPrimaryKey()) == null) {
				cacheResult(yeuCauDangKyCongDan);
			}
			else {
				yeuCauDangKyCongDan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all yeu cau dang ky cong dans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YeuCauDangKyCongDanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YeuCauDangKyCongDanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the yeu cau dang ky cong dan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		EntityCacheUtil.removeResult(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class, yeuCauDangKyCongDan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YeuCauDangKyCongDan> yeuCauDangKyCongDans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YeuCauDangKyCongDan yeuCauDangKyCongDan : yeuCauDangKyCongDans) {
			EntityCacheUtil.removeResult(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauDangKyCongDanImpl.class,
				yeuCauDangKyCongDan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new yeu cau dang ky cong dan with the primary key. Does not add the yeu cau dang ky cong dan to the database.
	 *
	 * @param id the primary key for the new yeu cau dang ky cong dan
	 * @return the new yeu cau dang ky cong dan
	 */
	public YeuCauDangKyCongDan create(long id) {
		YeuCauDangKyCongDan yeuCauDangKyCongDan = new YeuCauDangKyCongDanImpl();

		yeuCauDangKyCongDan.setNew(true);
		yeuCauDangKyCongDan.setPrimaryKey(id);

		return yeuCauDangKyCongDan;
	}

	/**
	 * Removes the yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the yeu cau dang ky cong dan
	 * @return the yeu cau dang ky cong dan that was removed
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan remove(long id)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky cong dan
	 * @return the yeu cau dang ky cong dan that was removed
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyCongDan remove(Serializable primaryKey)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YeuCauDangKyCongDan yeuCauDangKyCongDan = (YeuCauDangKyCongDan)session.get(YeuCauDangKyCongDanImpl.class,
					primaryKey);

			if (yeuCauDangKyCongDan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYeuCauDangKyCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yeuCauDangKyCongDan);
		}
		catch (NoSuchYeuCauDangKyCongDanException nsee) {
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
	protected YeuCauDangKyCongDan removeImpl(
		YeuCauDangKyCongDan yeuCauDangKyCongDan) throws SystemException {
		yeuCauDangKyCongDan = toUnwrappedModel(yeuCauDangKyCongDan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, yeuCauDangKyCongDan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(yeuCauDangKyCongDan);

		return yeuCauDangKyCongDan;
	}

	@Override
	public YeuCauDangKyCongDan updateImpl(
		org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan yeuCauDangKyCongDan,
		boolean merge) throws SystemException {
		yeuCauDangKyCongDan = toUnwrappedModel(yeuCauDangKyCongDan);

		boolean isNew = yeuCauDangKyCongDan.isNew();

		YeuCauDangKyCongDanModelImpl yeuCauDangKyCongDanModelImpl = (YeuCauDangKyCongDanModelImpl)yeuCauDangKyCongDan;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, yeuCauDangKyCongDan, merge);

			yeuCauDangKyCongDan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YeuCauDangKyCongDanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((yeuCauDangKyCongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAXACNHAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						yeuCauDangKyCongDanModelImpl.getOriginalMaXacNhan()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAXACNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAXACNHAN,
					args);

				args = new Object[] { yeuCauDangKyCongDanModelImpl.getMaXacNhan() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAXACNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAXACNHAN,
					args);
			}

			if ((yeuCauDangKyCongDanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						yeuCauDangKyCongDanModelImpl.getOriginalSoCmnd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCMND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND,
					args);

				args = new Object[] { yeuCauDangKyCongDanModelImpl.getSoCmnd() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCMND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND,
					args);
			}
		}

		EntityCacheUtil.putResult(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyCongDanImpl.class, yeuCauDangKyCongDan.getPrimaryKey(),
			yeuCauDangKyCongDan);

		return yeuCauDangKyCongDan;
	}

	protected YeuCauDangKyCongDan toUnwrappedModel(
		YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		if (yeuCauDangKyCongDan instanceof YeuCauDangKyCongDanImpl) {
			return yeuCauDangKyCongDan;
		}

		YeuCauDangKyCongDanImpl yeuCauDangKyCongDanImpl = new YeuCauDangKyCongDanImpl();

		yeuCauDangKyCongDanImpl.setNew(yeuCauDangKyCongDan.isNew());
		yeuCauDangKyCongDanImpl.setPrimaryKey(yeuCauDangKyCongDan.getPrimaryKey());

		yeuCauDangKyCongDanImpl.setId(yeuCauDangKyCongDan.getId());
		yeuCauDangKyCongDanImpl.setNgayYeuCau(yeuCauDangKyCongDan.getNgayYeuCau());
		yeuCauDangKyCongDanImpl.setSoCmnd(yeuCauDangKyCongDan.getSoCmnd());
		yeuCauDangKyCongDanImpl.setNgayCapCmnd(yeuCauDangKyCongDan.getNgayCapCmnd());
		yeuCauDangKyCongDanImpl.setIDNoiCapCmnd(yeuCauDangKyCongDan.getIDNoiCapCmnd());
		yeuCauDangKyCongDanImpl.setGhiChuCmnd(yeuCauDangKyCongDan.getGhiChuCmnd());
		yeuCauDangKyCongDanImpl.setEmail(yeuCauDangKyCongDan.getEmail());
		yeuCauDangKyCongDanImpl.setHoCongDan(yeuCauDangKyCongDan.getHoCongDan());
		yeuCauDangKyCongDanImpl.setHoVaTen(yeuCauDangKyCongDan.getHoVaTen());
		yeuCauDangKyCongDanImpl.setTenDem(yeuCauDangKyCongDan.getTenDem());
		yeuCauDangKyCongDanImpl.setTenCongDan(yeuCauDangKyCongDan.getTenCongDan());
		yeuCauDangKyCongDanImpl.setNgaySinh(yeuCauDangKyCongDan.getNgaySinh());
		yeuCauDangKyCongDanImpl.setGioiTinh(yeuCauDangKyCongDan.getGioiTinh());
		yeuCauDangKyCongDanImpl.setIDDanToc(yeuCauDangKyCongDan.getIDDanToc());
		yeuCauDangKyCongDanImpl.setIDQuocTich(yeuCauDangKyCongDan.getIDQuocTich());
		yeuCauDangKyCongDanImpl.setIDTonGiao(yeuCauDangKyCongDan.getIDTonGiao());
		yeuCauDangKyCongDanImpl.setDienThoaiCoDinh(yeuCauDangKyCongDan.getDienThoaiCoDinh());
		yeuCauDangKyCongDanImpl.setDienThoaiDiDong(yeuCauDangKyCongDan.getDienThoaiDiDong());
		yeuCauDangKyCongDanImpl.setIDTrinhDoHocVan(yeuCauDangKyCongDan.getIDTrinhDoHocVan());
		yeuCauDangKyCongDanImpl.setSoHoChieu(yeuCauDangKyCongDan.getSoHoChieu());
		yeuCauDangKyCongDanImpl.setNgayCapHoChieu(yeuCauDangKyCongDan.getNgayCapHoChieu());
		yeuCauDangKyCongDanImpl.setIDNoiCapHoChieu(yeuCauDangKyCongDan.getIDNoiCapHoChieu());
		yeuCauDangKyCongDanImpl.setNgayHetHanHoChieu(yeuCauDangKyCongDan.getNgayHetHanHoChieu());
		yeuCauDangKyCongDanImpl.setGhiChuHoChieu(yeuCauDangKyCongDan.getGhiChuHoChieu());
		yeuCauDangKyCongDanImpl.setSoBaoHiemYte(yeuCauDangKyCongDan.getSoBaoHiemYte());
		yeuCauDangKyCongDanImpl.setMaSoThueCaNhan(yeuCauDangKyCongDan.getMaSoThueCaNhan());
		yeuCauDangKyCongDanImpl.setIDNgheNghiep(yeuCauDangKyCongDan.getIDNgheNghiep());
		yeuCauDangKyCongDanImpl.setIDTrinhDoChuyenMon(yeuCauDangKyCongDan.getIDTrinhDoChuyenMon());
		yeuCauDangKyCongDanImpl.setTinhTrangHonNhan(yeuCauDangKyCongDan.getTinhTrangHonNhan());
		yeuCauDangKyCongDanImpl.setHoVaTenCha(yeuCauDangKyCongDan.getHoVaTenCha());
		yeuCauDangKyCongDanImpl.setHoVaTenMe(yeuCauDangKyCongDan.getHoVaTenMe());
		yeuCauDangKyCongDanImpl.setHoVaTenVoChong(yeuCauDangKyCongDan.getHoVaTenVoChong());
		yeuCauDangKyCongDanImpl.setSoHoKhau(yeuCauDangKyCongDan.getSoHoKhau());
		yeuCauDangKyCongDanImpl.setChuHo(yeuCauDangKyCongDan.getChuHo());
		yeuCauDangKyCongDanImpl.setIDQuanHe(yeuCauDangKyCongDan.getIDQuanHe());
		yeuCauDangKyCongDanImpl.setIDTinhThanhNoiSinh(yeuCauDangKyCongDan.getIDTinhThanhNoiSinh());
		yeuCauDangKyCongDanImpl.setIDQuanHuyenNoiSinh(yeuCauDangKyCongDan.getIDQuanHuyenNoiSinh());
		yeuCauDangKyCongDanImpl.setIDPhuongXaNoiSinh(yeuCauDangKyCongDan.getIDPhuongXaNoiSinh());
		yeuCauDangKyCongDanImpl.setMoTaDiaChiNoiSinh(yeuCauDangKyCongDan.getMoTaDiaChiNoiSinh());
		yeuCauDangKyCongDanImpl.setIDTinhThanhThuongTru(yeuCauDangKyCongDan.getIDTinhThanhThuongTru());
		yeuCauDangKyCongDanImpl.setIDQuanHuyenThuongTru(yeuCauDangKyCongDan.getIDQuanHuyenThuongTru());
		yeuCauDangKyCongDanImpl.setIDPhuongXaThuongTru(yeuCauDangKyCongDan.getIDPhuongXaThuongTru());
		yeuCauDangKyCongDanImpl.setMoTaDiaChiThuongTru(yeuCauDangKyCongDan.getMoTaDiaChiThuongTru());
		yeuCauDangKyCongDanImpl.setIDTinhThanhHienTai(yeuCauDangKyCongDan.getIDTinhThanhHienTai());
		yeuCauDangKyCongDanImpl.setIDQuanHuyenHienTai(yeuCauDangKyCongDan.getIDQuanHuyenHienTai());
		yeuCauDangKyCongDanImpl.setIDPhuongXaHienTai(yeuCauDangKyCongDan.getIDPhuongXaHienTai());
		yeuCauDangKyCongDanImpl.setMoTaDiaChiHienTai(yeuCauDangKyCongDan.getMoTaDiaChiHienTai());
		yeuCauDangKyCongDanImpl.setMaXacNhan(yeuCauDangKyCongDan.getMaXacNhan());
		yeuCauDangKyCongDanImpl.setNgayChungThuc(yeuCauDangKyCongDan.getNgayChungThuc());
		yeuCauDangKyCongDanImpl.setNguoiChungThuc(yeuCauDangKyCongDan.getNguoiChungThuc());
		yeuCauDangKyCongDanImpl.setMaCongDanCha(yeuCauDangKyCongDan.getMaCongDanCha());
		yeuCauDangKyCongDanImpl.setMaCongDanMe(yeuCauDangKyCongDan.getMaCongDanMe());
		yeuCauDangKyCongDanImpl.setMaCongDanVoChong(yeuCauDangKyCongDan.getMaCongDanVoChong());
		yeuCauDangKyCongDanImpl.setMaCongDan(yeuCauDangKyCongDan.getMaCongDan());
		yeuCauDangKyCongDanImpl.setLoaiYeuCau(yeuCauDangKyCongDan.getLoaiYeuCau());
		yeuCauDangKyCongDanImpl.setTrangThaiYeuCau(yeuCauDangKyCongDan.getTrangThaiYeuCau());
		yeuCauDangKyCongDanImpl.setNgayTao(yeuCauDangKyCongDan.getNgayTao());
		yeuCauDangKyCongDanImpl.setNgaySua(yeuCauDangKyCongDan.getNgaySua());
		yeuCauDangKyCongDanImpl.setNguoiTao(yeuCauDangKyCongDan.getNguoiTao());
		yeuCauDangKyCongDanImpl.setNguoiSua(yeuCauDangKyCongDan.getNguoiSua());
		yeuCauDangKyCongDanImpl.setXoa(yeuCauDangKyCongDan.getXoa());

		return yeuCauDangKyCongDanImpl;
	}

	/**
	 * Returns the yeu cau dang ky cong dan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky cong dan
	 * @return the yeu cau dang ky cong dan
	 * @throws com.liferay.portal.NoSuchModelException if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyCongDan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the yeu cau dang ky cong dan with the primary key or throws a {@link org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException} if it could not be found.
	 *
	 * @param id the primary key of the yeu cau dang ky cong dan
	 * @return the yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan findByPrimaryKey(long id)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		YeuCauDangKyCongDan yeuCauDangKyCongDan = fetchByPrimaryKey(id);

		if (yeuCauDangKyCongDan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchYeuCauDangKyCongDanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return yeuCauDangKyCongDan;
	}

	/**
	 * Returns the yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky cong dan
	 * @return the yeu cau dang ky cong dan, or <code>null</code> if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyCongDan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the yeu cau dang ky cong dan
	 * @return the yeu cau dang ky cong dan, or <code>null</code> if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan fetchByPrimaryKey(long id)
		throws SystemException {
		YeuCauDangKyCongDan yeuCauDangKyCongDan = (YeuCauDangKyCongDan)EntityCacheUtil.getResult(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauDangKyCongDanImpl.class, id);

		if (yeuCauDangKyCongDan == _nullYeuCauDangKyCongDan) {
			return null;
		}

		if (yeuCauDangKyCongDan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				yeuCauDangKyCongDan = (YeuCauDangKyCongDan)session.get(YeuCauDangKyCongDanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (yeuCauDangKyCongDan != null) {
					cacheResult(yeuCauDangKyCongDan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YeuCauDangKyCongDanModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauDangKyCongDanImpl.class, id,
						_nullYeuCauDangKyCongDan);
				}

				closeSession(session);
			}
		}

		return yeuCauDangKyCongDan;
	}

	/**
	 * Returns all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @return the matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findByMaXacNhan(String MaXacNhan)
		throws SystemException {
		return findByMaXacNhan(MaXacNhan, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @param start the lower bound of the range of yeu cau dang ky cong dans
	 * @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	 * @return the range of matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findByMaXacNhan(String MaXacNhan,
		int start, int end) throws SystemException {
		return findByMaXacNhan(MaXacNhan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @param start the lower bound of the range of yeu cau dang ky cong dans
	 * @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findByMaXacNhan(String MaXacNhan,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAXACNHAN;
			finderArgs = new Object[] { MaXacNhan };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAXACNHAN;
			finderArgs = new Object[] { MaXacNhan, start, end, orderByComparator };
		}

		List<YeuCauDangKyCongDan> list = (List<YeuCauDangKyCongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_YEUCAUDANGKYCONGDAN_WHERE);

			if (MaXacNhan == null) {
				query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_1);
			}
			else {
				if (MaXacNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (MaXacNhan != null) {
					qPos.add(MaXacNhan);
				}

				list = (List<YeuCauDangKyCongDan>)QueryUtil.list(q,
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
	 * Returns the first yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan findByMaXacNhan_First(String MaXacNhan,
		OrderByComparator orderByComparator)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		List<YeuCauDangKyCongDan> list = findByMaXacNhan(MaXacNhan, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MaXacNhan=");
			msg.append(MaXacNhan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYeuCauDangKyCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan findByMaXacNhan_Last(String MaXacNhan,
		OrderByComparator orderByComparator)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		int count = countByMaXacNhan(MaXacNhan);

		List<YeuCauDangKyCongDan> list = findByMaXacNhan(MaXacNhan, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MaXacNhan=");
			msg.append(MaXacNhan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYeuCauDangKyCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the yeu cau dang ky cong dans before and after the current yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current yeu cau dang ky cong dan
	 * @param MaXacNhan the ma xac nhan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan[] findByMaXacNhan_PrevAndNext(long id,
		String MaXacNhan, OrderByComparator orderByComparator)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		YeuCauDangKyCongDan yeuCauDangKyCongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			YeuCauDangKyCongDan[] array = new YeuCauDangKyCongDanImpl[3];

			array[0] = getByMaXacNhan_PrevAndNext(session, yeuCauDangKyCongDan,
					MaXacNhan, orderByComparator, true);

			array[1] = yeuCauDangKyCongDan;

			array[2] = getByMaXacNhan_PrevAndNext(session, yeuCauDangKyCongDan,
					MaXacNhan, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YeuCauDangKyCongDan getByMaXacNhan_PrevAndNext(Session session,
		YeuCauDangKyCongDan yeuCauDangKyCongDan, String MaXacNhan,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YEUCAUDANGKYCONGDAN_WHERE);

		if (MaXacNhan == null) {
			query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_1);
		}
		else {
			if (MaXacNhan.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_3);
			}
			else {
				query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (MaXacNhan != null) {
			qPos.add(MaXacNhan);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(yeuCauDangKyCongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YeuCauDangKyCongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	 *
	 * @param SoCmnd the so cmnd
	 * @return the matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findBySoCmnd(String SoCmnd)
		throws SystemException {
		return findBySoCmnd(SoCmnd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param SoCmnd the so cmnd
	 * @param start the lower bound of the range of yeu cau dang ky cong dans
	 * @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	 * @return the range of matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findBySoCmnd(String SoCmnd, int start,
		int end) throws SystemException {
		return findBySoCmnd(SoCmnd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param SoCmnd the so cmnd
	 * @param start the lower bound of the range of yeu cau dang ky cong dans
	 * @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findBySoCmnd(String SoCmnd, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCMND;
			finderArgs = new Object[] { SoCmnd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCMND;
			finderArgs = new Object[] { SoCmnd, start, end, orderByComparator };
		}

		List<YeuCauDangKyCongDan> list = (List<YeuCauDangKyCongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_YEUCAUDANGKYCONGDAN_WHERE);

			if (SoCmnd == null) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_1);
			}
			else {
				if (SoCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (SoCmnd != null) {
					qPos.add(SoCmnd);
				}

				list = (List<YeuCauDangKyCongDan>)QueryUtil.list(q,
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
	 * Returns the first yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param SoCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan findBySoCmnd_First(String SoCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		List<YeuCauDangKyCongDan> list = findBySoCmnd(SoCmnd, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("SoCmnd=");
			msg.append(SoCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYeuCauDangKyCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param SoCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan findBySoCmnd_Last(String SoCmnd,
		OrderByComparator orderByComparator)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		int count = countBySoCmnd(SoCmnd);

		List<YeuCauDangKyCongDan> list = findBySoCmnd(SoCmnd, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("SoCmnd=");
			msg.append(SoCmnd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchYeuCauDangKyCongDanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the yeu cau dang ky cong dans before and after the current yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current yeu cau dang ky cong dan
	 * @param SoCmnd the so cmnd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next yeu cau dang ky cong dan
	 * @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyCongDan[] findBySoCmnd_PrevAndNext(long id,
		String SoCmnd, OrderByComparator orderByComparator)
		throws NoSuchYeuCauDangKyCongDanException, SystemException {
		YeuCauDangKyCongDan yeuCauDangKyCongDan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			YeuCauDangKyCongDan[] array = new YeuCauDangKyCongDanImpl[3];

			array[0] = getBySoCmnd_PrevAndNext(session, yeuCauDangKyCongDan,
					SoCmnd, orderByComparator, true);

			array[1] = yeuCauDangKyCongDan;

			array[2] = getBySoCmnd_PrevAndNext(session, yeuCauDangKyCongDan,
					SoCmnd, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YeuCauDangKyCongDan getBySoCmnd_PrevAndNext(Session session,
		YeuCauDangKyCongDan yeuCauDangKyCongDan, String SoCmnd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YEUCAUDANGKYCONGDAN_WHERE);

		if (SoCmnd == null) {
			query.append(_FINDER_COLUMN_SOCMND_SOCMND_1);
		}
		else {
			if (SoCmnd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
			}
			else {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (SoCmnd != null) {
			qPos.add(SoCmnd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(yeuCauDangKyCongDan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YeuCauDangKyCongDan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the yeu cau dang ky cong dans.
	 *
	 * @return the yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the yeu cau dang ky cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of yeu cau dang ky cong dans
	 * @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	 * @return the range of yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the yeu cau dang ky cong dans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of yeu cau dang ky cong dans
	 * @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyCongDan> findAll(int start, int end,
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

		List<YeuCauDangKyCongDan> list = (List<YeuCauDangKyCongDan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YEUCAUDANGKYCONGDAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YEUCAUDANGKYCONGDAN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YeuCauDangKyCongDan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YeuCauDangKyCongDan>)QueryUtil.list(q,
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
	 * Removes all the yeu cau dang ky cong dans where MaXacNhan = &#63; from the database.
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaXacNhan(String MaXacNhan) throws SystemException {
		for (YeuCauDangKyCongDan yeuCauDangKyCongDan : findByMaXacNhan(
				MaXacNhan)) {
			remove(yeuCauDangKyCongDan);
		}
	}

	/**
	 * Removes all the yeu cau dang ky cong dans where SoCmnd = &#63; from the database.
	 *
	 * @param SoCmnd the so cmnd
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySoCmnd(String SoCmnd) throws SystemException {
		for (YeuCauDangKyCongDan yeuCauDangKyCongDan : findBySoCmnd(SoCmnd)) {
			remove(yeuCauDangKyCongDan);
		}
	}

	/**
	 * Removes all the yeu cau dang ky cong dans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YeuCauDangKyCongDan yeuCauDangKyCongDan : findAll()) {
			remove(yeuCauDangKyCongDan);
		}
	}

	/**
	 * Returns the number of yeu cau dang ky cong dans where MaXacNhan = &#63;.
	 *
	 * @param MaXacNhan the ma xac nhan
	 * @return the number of matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaXacNhan(String MaXacNhan) throws SystemException {
		Object[] finderArgs = new Object[] { MaXacNhan };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAXACNHAN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YEUCAUDANGKYCONGDAN_WHERE);

			if (MaXacNhan == null) {
				query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_1);
			}
			else {
				if (MaXacNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAXACNHAN_MAXACNHAN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (MaXacNhan != null) {
					qPos.add(MaXacNhan);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAXACNHAN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of yeu cau dang ky cong dans where SoCmnd = &#63;.
	 *
	 * @param SoCmnd the so cmnd
	 * @return the number of matching yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySoCmnd(String SoCmnd) throws SystemException {
		Object[] finderArgs = new Object[] { SoCmnd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SOCMND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YEUCAUDANGKYCONGDAN_WHERE);

			if (SoCmnd == null) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_1);
			}
			else {
				if (SoCmnd.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
				}
				else {
					query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (SoCmnd != null) {
					qPos.add(SoCmnd);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SOCMND,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of yeu cau dang ky cong dans.
	 *
	 * @return the number of yeu cau dang ky cong dans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YEUCAUDANGKYCONGDAN);

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
	 * Initializes the yeu cau dang ky cong dan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YeuCauDangKyCongDan>> listenersList = new ArrayList<ModelListener<YeuCauDangKyCongDan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YeuCauDangKyCongDan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YeuCauDangKyCongDanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnhChanDungYeuCauDangKyCongDanPersistence.class)
	protected AnhChanDungYeuCauDangKyCongDanPersistence anhChanDungYeuCauDangKyCongDanPersistence;
	@BeanReference(type = YeuCauDangKyCongDanPersistence.class)
	protected YeuCauDangKyCongDanPersistence yeuCauDangKyCongDanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_YEUCAUDANGKYCONGDAN = "SELECT yeuCauDangKyCongDan FROM YeuCauDangKyCongDan yeuCauDangKyCongDan";
	private static final String _SQL_SELECT_YEUCAUDANGKYCONGDAN_WHERE = "SELECT yeuCauDangKyCongDan FROM YeuCauDangKyCongDan yeuCauDangKyCongDan WHERE ";
	private static final String _SQL_COUNT_YEUCAUDANGKYCONGDAN = "SELECT COUNT(yeuCauDangKyCongDan) FROM YeuCauDangKyCongDan yeuCauDangKyCongDan";
	private static final String _SQL_COUNT_YEUCAUDANGKYCONGDAN_WHERE = "SELECT COUNT(yeuCauDangKyCongDan) FROM YeuCauDangKyCongDan yeuCauDangKyCongDan WHERE ";
	private static final String _FINDER_COLUMN_MAXACNHAN_MAXACNHAN_1 = "yeuCauDangKyCongDan.MaXacNhan IS NULL";
	private static final String _FINDER_COLUMN_MAXACNHAN_MAXACNHAN_2 = "yeuCauDangKyCongDan.MaXacNhan = ?";
	private static final String _FINDER_COLUMN_MAXACNHAN_MAXACNHAN_3 = "(yeuCauDangKyCongDan.MaXacNhan IS NULL OR yeuCauDangKyCongDan.MaXacNhan = ?)";
	private static final String _FINDER_COLUMN_SOCMND_SOCMND_1 = "yeuCauDangKyCongDan.SoCmnd IS NULL";
	private static final String _FINDER_COLUMN_SOCMND_SOCMND_2 = "yeuCauDangKyCongDan.SoCmnd = ?";
	private static final String _FINDER_COLUMN_SOCMND_SOCMND_3 = "(yeuCauDangKyCongDan.SoCmnd IS NULL OR yeuCauDangKyCongDan.SoCmnd = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yeuCauDangKyCongDan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YeuCauDangKyCongDan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YeuCauDangKyCongDan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YeuCauDangKyCongDanPersistenceImpl.class);
	private static YeuCauDangKyCongDan _nullYeuCauDangKyCongDan = new YeuCauDangKyCongDanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YeuCauDangKyCongDan> toCacheModel() {
				return _nullYeuCauDangKyCongDanCacheModel;
			}
		};

	private static CacheModel<YeuCauDangKyCongDan> _nullYeuCauDangKyCongDanCacheModel =
		new CacheModel<YeuCauDangKyCongDan>() {
			public YeuCauDangKyCongDan toEntityModel() {
				return _nullYeuCauDangKyCongDan;
			}
		};
}