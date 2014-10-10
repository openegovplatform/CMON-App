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

package org.oep.cmon.dao.hosolienthong.service.persistence;

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

import org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongImpl;
import org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho so lien thong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hoangtrung.nguyen
 * @see HoSoLienThongPersistence
 * @see HoSoLienThongUtil
 * @generated
 */
public class HoSoLienThongPersistenceImpl extends BasePersistenceImpl<HoSoLienThong>
	implements HoSoLienThongPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoSoLienThongUtil} to access the ho so lien thong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoSoLienThongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSOID = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED,
			HoSoLienThongImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByHoSoId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOID =
		new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED,
			HoSoLienThongImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByHoSoId", new String[] { Long.class.getName() },
			HoSoLienThongModelImpl.HOSOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOSOID = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoSoId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED,
			HoSoLienThongImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMaSoBienNhanLucGui",
			new String[] { String.class.getName() },
			HoSoLienThongModelImpl.MASOBIENNHANLUCGUI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASOBIENNHANLUCGUI = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMaSoBienNhanLucGui", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED,
			HoSoLienThongImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED,
			HoSoLienThongImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho so lien thong in the entity cache if it is enabled.
	 *
	 * @param hoSoLienThong the ho so lien thong
	 */
	public void cacheResult(HoSoLienThong hoSoLienThong) {
		EntityCacheUtil.putResult(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongImpl.class, hoSoLienThong.getPrimaryKey(),
			hoSoLienThong);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
			new Object[] { hoSoLienThong.getMaSoBienNhanLucGui() },
			hoSoLienThong);

		hoSoLienThong.resetOriginalValues();
	}

	/**
	 * Caches the ho so lien thongs in the entity cache if it is enabled.
	 *
	 * @param hoSoLienThongs the ho so lien thongs
	 */
	public void cacheResult(List<HoSoLienThong> hoSoLienThongs) {
		for (HoSoLienThong hoSoLienThong : hoSoLienThongs) {
			if (EntityCacheUtil.getResult(
						HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
						HoSoLienThongImpl.class, hoSoLienThong.getPrimaryKey()) == null) {
				cacheResult(hoSoLienThong);
			}
			else {
				hoSoLienThong.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho so lien thongs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoSoLienThongImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoSoLienThongImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho so lien thong.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoSoLienThong hoSoLienThong) {
		EntityCacheUtil.removeResult(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongImpl.class, hoSoLienThong.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(hoSoLienThong);
	}

	@Override
	public void clearCache(List<HoSoLienThong> hoSoLienThongs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoSoLienThong hoSoLienThong : hoSoLienThongs) {
			EntityCacheUtil.removeResult(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
				HoSoLienThongImpl.class, hoSoLienThong.getPrimaryKey());

			clearUniqueFindersCache(hoSoLienThong);
		}
	}

	protected void clearUniqueFindersCache(HoSoLienThong hoSoLienThong) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
			new Object[] { hoSoLienThong.getMaSoBienNhanLucGui() });
	}

	/**
	 * Creates a new ho so lien thong with the primary key. Does not add the ho so lien thong to the database.
	 *
	 * @param id the primary key for the new ho so lien thong
	 * @return the new ho so lien thong
	 */
	public HoSoLienThong create(long id) {
		HoSoLienThong hoSoLienThong = new HoSoLienThongImpl();

		hoSoLienThong.setNew(true);
		hoSoLienThong.setPrimaryKey(id);

		return hoSoLienThong;
	}

	/**
	 * Removes the ho so lien thong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ho so lien thong
	 * @return the ho so lien thong that was removed
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong remove(long id)
		throws NoSuchHoSoLienThongException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ho so lien thong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho so lien thong
	 * @return the ho so lien thong that was removed
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoLienThong remove(Serializable primaryKey)
		throws NoSuchHoSoLienThongException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoSoLienThong hoSoLienThong = (HoSoLienThong)session.get(HoSoLienThongImpl.class,
					primaryKey);

			if (hoSoLienThong == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoSoLienThongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoSoLienThong);
		}
		catch (NoSuchHoSoLienThongException nsee) {
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
	protected HoSoLienThong removeImpl(HoSoLienThong hoSoLienThong)
		throws SystemException {
		hoSoLienThong = toUnwrappedModel(hoSoLienThong);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoSoLienThong);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoSoLienThong);

		return hoSoLienThong;
	}

	@Override
	public HoSoLienThong updateImpl(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong,
		boolean merge) throws SystemException {
		hoSoLienThong = toUnwrappedModel(hoSoLienThong);

		boolean isNew = hoSoLienThong.isNew();

		HoSoLienThongModelImpl hoSoLienThongModelImpl = (HoSoLienThongModelImpl)hoSoLienThong;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoSoLienThong, merge);

			hoSoLienThong.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HoSoLienThongModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hoSoLienThongModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(hoSoLienThongModelImpl.getOriginalHoSoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOID,
					args);

				args = new Object[] {
						Long.valueOf(hoSoLienThongModelImpl.getHoSoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOID,
					args);
			}
		}

		EntityCacheUtil.putResult(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
			HoSoLienThongImpl.class, hoSoLienThong.getPrimaryKey(),
			hoSoLienThong);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
				new Object[] { hoSoLienThong.getMaSoBienNhanLucGui() },
				hoSoLienThong);
		}
		else {
			if ((hoSoLienThongModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoLienThongModelImpl.getOriginalMaSoBienNhanLucGui()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASOBIENNHANLUCGUI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
					new Object[] { hoSoLienThong.getMaSoBienNhanLucGui() },
					hoSoLienThong);
			}
		}

		return hoSoLienThong;
	}

	protected HoSoLienThong toUnwrappedModel(HoSoLienThong hoSoLienThong) {
		if (hoSoLienThong instanceof HoSoLienThongImpl) {
			return hoSoLienThong;
		}

		HoSoLienThongImpl hoSoLienThongImpl = new HoSoLienThongImpl();

		hoSoLienThongImpl.setNew(hoSoLienThong.isNew());
		hoSoLienThongImpl.setPrimaryKey(hoSoLienThong.getPrimaryKey());

		hoSoLienThongImpl.setId(hoSoLienThong.getId());
		hoSoLienThongImpl.setHoSoId(hoSoLienThong.getHoSoId());
		hoSoLienThongImpl.setCoQuanGuiId(hoSoLienThong.getCoQuanGuiId());
		hoSoLienThongImpl.setCoQuanNhanId(hoSoLienThong.getCoQuanNhanId());
		hoSoLienThongImpl.setThuTucGuiId(hoSoLienThong.getThuTucGuiId());
		hoSoLienThongImpl.setThuTucNhanId(hoSoLienThong.getThuTucNhanId());
		hoSoLienThongImpl.setMaSoBienNhanLucGui(hoSoLienThong.getMaSoBienNhanLucGui());
		hoSoLienThongImpl.setMaSoBienNhanLucNhan(hoSoLienThong.getMaSoBienNhanLucNhan());
		hoSoLienThongImpl.setCanBoGuiId(hoSoLienThong.getCanBoGuiId());
		hoSoLienThongImpl.setCanBoNhanId(hoSoLienThong.getCanBoNhanId());
		hoSoLienThongImpl.setNgayGui(hoSoLienThong.getNgayGui());
		hoSoLienThongImpl.setNgayNhan(hoSoLienThong.getNgayNhan());
		hoSoLienThongImpl.setHoTenCanBoGui(hoSoLienThong.getHoTenCanBoGui());
		hoSoLienThongImpl.setHoTenCanBoNhan(hoSoLienThong.getHoTenCanBoNhan());
		hoSoLienThongImpl.setCanBoNopHoSoGiayId(hoSoLienThong.getCanBoNopHoSoGiayId());
		hoSoLienThongImpl.setHoTenCanBoNopHoSoGiay(hoSoLienThong.getHoTenCanBoNopHoSoGiay());
		hoSoLienThongImpl.setTrangThaiLienThong(hoSoLienThong.getTrangThaiLienThong());
		hoSoLienThongImpl.setGhiChuGuiLienThong(hoSoLienThong.getGhiChuGuiLienThong());
		hoSoLienThongImpl.setHoTenCongDanNop(hoSoLienThong.getHoTenCongDanNop());
		hoSoLienThongImpl.setDiaChiDayDuCongDanNop(hoSoLienThong.getDiaChiDayDuCongDanNop());
		hoSoLienThongImpl.setNgayTuChoi(hoSoLienThong.getNgayTuChoi());
		hoSoLienThongImpl.setNgayNoiNhanTraKetQua(hoSoLienThong.getNgayNoiNhanTraKetQua());
		hoSoLienThongImpl.setNgayNoiGuiNhanKetQua(hoSoLienThong.getNgayNoiGuiNhanKetQua());
		hoSoLienThongImpl.setCanBoTiepNhanNoiGuiId(hoSoLienThong.getCanBoTiepNhanNoiGuiId());
		hoSoLienThongImpl.setHoTenCanBoTiepNhanNoiGui(hoSoLienThong.getHoTenCanBoTiepNhanNoiGui());
		hoSoLienThongImpl.setTenCoQuanGui(hoSoLienThong.getTenCoQuanGui());
		hoSoLienThongImpl.setTenThuTucGui(hoSoLienThong.getTenThuTucGui());
		hoSoLienThongImpl.setTenCoQuanNhan(hoSoLienThong.getTenCoQuanNhan());
		hoSoLienThongImpl.setTenThuTucNhan(hoSoLienThong.getTenThuTucNhan());
		hoSoLienThongImpl.setThuTuLienThong(hoSoLienThong.getThuTuLienThong());
		hoSoLienThongImpl.setNgayNoiNhanHenTra(hoSoLienThong.getNgayNoiNhanHenTra());
		hoSoLienThongImpl.setSoNgayNoiNhanXuLyDuKien(hoSoLienThong.getSoNgayNoiNhanXuLyDuKien());
		hoSoLienThongImpl.setNguoiTao(hoSoLienThong.getNguoiTao());
		hoSoLienThongImpl.setNgayTao(hoSoLienThong.getNgayTao());
		hoSoLienThongImpl.setNguoiSua(hoSoLienThong.getNguoiSua());
		hoSoLienThongImpl.setNgaySua(hoSoLienThong.getNgaySua());
		hoSoLienThongImpl.setDaXoa(hoSoLienThong.getDaXoa());

		return hoSoLienThongImpl;
	}

	/**
	 * Returns the ho so lien thong with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so lien thong
	 * @return the ho so lien thong
	 * @throws com.liferay.portal.NoSuchModelException if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoLienThong findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so lien thong with the primary key or throws a {@link org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException} if it could not be found.
	 *
	 * @param id the primary key of the ho so lien thong
	 * @return the ho so lien thong
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong findByPrimaryKey(long id)
		throws NoSuchHoSoLienThongException, SystemException {
		HoSoLienThong hoSoLienThong = fetchByPrimaryKey(id);

		if (hoSoLienThong == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHoSoLienThongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hoSoLienThong;
	}

	/**
	 * Returns the ho so lien thong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so lien thong
	 * @return the ho so lien thong, or <code>null</code> if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoLienThong fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so lien thong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ho so lien thong
	 * @return the ho so lien thong, or <code>null</code> if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong fetchByPrimaryKey(long id) throws SystemException {
		HoSoLienThong hoSoLienThong = (HoSoLienThong)EntityCacheUtil.getResult(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
				HoSoLienThongImpl.class, id);

		if (hoSoLienThong == _nullHoSoLienThong) {
			return null;
		}

		if (hoSoLienThong == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoSoLienThong = (HoSoLienThong)session.get(HoSoLienThongImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoSoLienThong != null) {
					cacheResult(hoSoLienThong);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoSoLienThongModelImpl.ENTITY_CACHE_ENABLED,
						HoSoLienThongImpl.class, id, _nullHoSoLienThong);
				}

				closeSession(session);
			}
		}

		return hoSoLienThong;
	}

	/**
	 * Returns all the ho so lien thongs where hoSoId = &#63;.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoLienThong> findByHoSoId(long hoSoId)
		throws SystemException {
		return findByHoSoId(hoSoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so lien thongs where hoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoId the ho so ID
	 * @param start the lower bound of the range of ho so lien thongs
	 * @param end the upper bound of the range of ho so lien thongs (not inclusive)
	 * @return the range of matching ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoLienThong> findByHoSoId(long hoSoId, int start, int end)
		throws SystemException {
		return findByHoSoId(hoSoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so lien thongs where hoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoId the ho so ID
	 * @param start the lower bound of the range of ho so lien thongs
	 * @param end the upper bound of the range of ho so lien thongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoLienThong> findByHoSoId(long hoSoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOID;
			finderArgs = new Object[] { hoSoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSOID;
			finderArgs = new Object[] { hoSoId, start, end, orderByComparator };
		}

		List<HoSoLienThong> list = (List<HoSoLienThong>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOLIENTHONG_WHERE);

			query.append(_FINDER_COLUMN_HOSOID_HOSOID_2);

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

				qPos.add(hoSoId);

				list = (List<HoSoLienThong>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so lien thong in the ordered set where hoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoId the ho so ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so lien thong
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong findByHoSoId_First(long hoSoId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoLienThongException, SystemException {
		List<HoSoLienThong> list = findByHoSoId(hoSoId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoId=");
			msg.append(hoSoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoLienThongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so lien thong in the ordered set where hoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoId the ho so ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so lien thong
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong findByHoSoId_Last(long hoSoId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoLienThongException, SystemException {
		int count = countByHoSoId(hoSoId);

		List<HoSoLienThong> list = findByHoSoId(hoSoId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoId=");
			msg.append(hoSoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoLienThongException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so lien thongs before and after the current ho so lien thong in the ordered set where hoSoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so lien thong
	 * @param hoSoId the ho so ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so lien thong
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong[] findByHoSoId_PrevAndNext(long id, long hoSoId,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoLienThongException, SystemException {
		HoSoLienThong hoSoLienThong = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoLienThong[] array = new HoSoLienThongImpl[3];

			array[0] = getByHoSoId_PrevAndNext(session, hoSoLienThong, hoSoId,
					orderByComparator, true);

			array[1] = hoSoLienThong;

			array[2] = getByHoSoId_PrevAndNext(session, hoSoLienThong, hoSoId,
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

	protected HoSoLienThong getByHoSoId_PrevAndNext(Session session,
		HoSoLienThong hoSoLienThong, long hoSoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOLIENTHONG_WHERE);

		query.append(_FINDER_COLUMN_HOSOID_HOSOID_2);

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

		qPos.add(hoSoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoLienThong);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoLienThong> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or throws a {@link org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException} if it could not be found.
	 *
	 * @param maSoBienNhanLucGui the ma so bien nhan luc gui
	 * @return the matching ho so lien thong
	 * @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong findByMaSoBienNhanLucGui(String maSoBienNhanLucGui)
		throws NoSuchHoSoLienThongException, SystemException {
		HoSoLienThong hoSoLienThong = fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui);

		if (hoSoLienThong == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maSoBienNhanLucGui=");
			msg.append(maSoBienNhanLucGui);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHoSoLienThongException(msg.toString());
		}

		return hoSoLienThong;
	}

	/**
	 * Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param maSoBienNhanLucGui the ma so bien nhan luc gui
	 * @return the matching ho so lien thong, or <code>null</code> if a matching ho so lien thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong fetchByMaSoBienNhanLucGui(String maSoBienNhanLucGui)
		throws SystemException {
		return fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui, true);
	}

	/**
	 * Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param maSoBienNhanLucGui the ma so bien nhan luc gui
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching ho so lien thong, or <code>null</code> if a matching ho so lien thong could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoLienThong fetchByMaSoBienNhanLucGui(String maSoBienNhanLucGui,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { maSoBienNhanLucGui };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_HOSOLIENTHONG_WHERE);

			if (maSoBienNhanLucGui == null) {
				query.append(_FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_1);
			}
			else {
				if (maSoBienNhanLucGui.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoBienNhanLucGui != null) {
					qPos.add(maSoBienNhanLucGui);
				}

				List<HoSoLienThong> list = q.list();

				result = list;

				HoSoLienThong hoSoLienThong = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
						finderArgs, list);
				}
				else {
					hoSoLienThong = list.get(0);

					cacheResult(hoSoLienThong);

					if ((hoSoLienThong.getMaSoBienNhanLucGui() == null) ||
							!hoSoLienThong.getMaSoBienNhanLucGui()
											  .equals(maSoBienNhanLucGui)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
							finderArgs, hoSoLienThong);
					}
				}

				return hoSoLienThong;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASOBIENNHANLUCGUI,
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
				return (HoSoLienThong)result;
			}
		}
	}

	/**
	 * Returns all the ho so lien thongs.
	 *
	 * @return the ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoLienThong> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so lien thongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so lien thongs
	 * @param end the upper bound of the range of ho so lien thongs (not inclusive)
	 * @return the range of ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoLienThong> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so lien thongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so lien thongs
	 * @param end the upper bound of the range of ho so lien thongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoLienThong> findAll(int start, int end,
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

		List<HoSoLienThong> list = (List<HoSoLienThong>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOSOLIENTHONG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOSOLIENTHONG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoSoLienThong>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoSoLienThong>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ho so lien thongs where hoSoId = &#63; from the database.
	 *
	 * @param hoSoId the ho so ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByHoSoId(long hoSoId) throws SystemException {
		for (HoSoLienThong hoSoLienThong : findByHoSoId(hoSoId)) {
			remove(hoSoLienThong);
		}
	}

	/**
	 * Removes the ho so lien thong where maSoBienNhanLucGui = &#63; from the database.
	 *
	 * @param maSoBienNhanLucGui the ma so bien nhan luc gui
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaSoBienNhanLucGui(String maSoBienNhanLucGui)
		throws NoSuchHoSoLienThongException, SystemException {
		HoSoLienThong hoSoLienThong = findByMaSoBienNhanLucGui(maSoBienNhanLucGui);

		remove(hoSoLienThong);
	}

	/**
	 * Removes all the ho so lien thongs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoSoLienThong hoSoLienThong : findAll()) {
			remove(hoSoLienThong);
		}
	}

	/**
	 * Returns the number of ho so lien thongs where hoSoId = &#63;.
	 *
	 * @param hoSoId the ho so ID
	 * @return the number of matching ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByHoSoId(long hoSoId) throws SystemException {
		Object[] finderArgs = new Object[] { hoSoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOSOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOLIENTHONG_WHERE);

			query.append(_FINDER_COLUMN_HOSOID_HOSOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOSOID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so lien thongs where maSoBienNhanLucGui = &#63;.
	 *
	 * @param maSoBienNhanLucGui the ma so bien nhan luc gui
	 * @return the number of matching ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaSoBienNhanLucGui(String maSoBienNhanLucGui)
		throws SystemException {
		Object[] finderArgs = new Object[] { maSoBienNhanLucGui };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MASOBIENNHANLUCGUI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOSOLIENTHONG_WHERE);

			if (maSoBienNhanLucGui == null) {
				query.append(_FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_1);
			}
			else {
				if (maSoBienNhanLucGui.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_3);
				}
				else {
					query.append(_FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (maSoBienNhanLucGui != null) {
					qPos.add(maSoBienNhanLucGui);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASOBIENNHANLUCGUI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so lien thongs.
	 *
	 * @return the number of ho so lien thongs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOSOLIENTHONG);

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
	 * Initializes the ho so lien thong persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.hosolienthong.model.HoSoLienThong")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoSoLienThong>> listenersList = new ArrayList<ModelListener<HoSoLienThong>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoSoLienThong>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HoSoLienThongImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = HoSoLienThongPersistence.class)
	protected HoSoLienThongPersistence hoSoLienThongPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HOSOLIENTHONG = "SELECT hoSoLienThong FROM HoSoLienThong hoSoLienThong";
	private static final String _SQL_SELECT_HOSOLIENTHONG_WHERE = "SELECT hoSoLienThong FROM HoSoLienThong hoSoLienThong WHERE ";
	private static final String _SQL_COUNT_HOSOLIENTHONG = "SELECT COUNT(hoSoLienThong) FROM HoSoLienThong hoSoLienThong";
	private static final String _SQL_COUNT_HOSOLIENTHONG_WHERE = "SELECT COUNT(hoSoLienThong) FROM HoSoLienThong hoSoLienThong WHERE ";
	private static final String _FINDER_COLUMN_HOSOID_HOSOID_2 = "hoSoLienThong.hoSoId = ? AND hoSoLienThong.daXoa = 0";
	private static final String _FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_1 =
		"hoSoLienThong.maSoBienNhanLucGui IS NULL AND hoSoLienThong.daXoa = 0";
	private static final String _FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_2 =
		"hoSoLienThong.maSoBienNhanLucGui = ? AND hoSoLienThong.daXoa = 0";
	private static final String _FINDER_COLUMN_MASOBIENNHANLUCGUI_MASOBIENNHANLUCGUI_3 =
		"(hoSoLienThong.maSoBienNhanLucGui IS NULL OR hoSoLienThong.maSoBienNhanLucGui = ?) AND hoSoLienThong.daXoa = 0";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoSoLienThong.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoSoLienThong exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HoSoLienThong exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoSoLienThongPersistenceImpl.class);
	private static HoSoLienThong _nullHoSoLienThong = new HoSoLienThongImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoSoLienThong> toCacheModel() {
				return _nullHoSoLienThongCacheModel;
			}
		};

	private static CacheModel<HoSoLienThong> _nullHoSoLienThongCacheModel = new CacheModel<HoSoLienThong>() {
			public HoSoLienThong toEntityModel() {
				return _nullHoSoLienThong;
			}
		};
}