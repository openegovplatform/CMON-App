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

package org.oep.exch.dao.hoso.service.persistence;

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

import org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;
import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;
import org.oep.exch.dao.hoso.model.impl.HoSoTrucTuyenImpl;
import org.oep.exch.dao.hoso.model.impl.HoSoTrucTuyenModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho so truc tuyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see HoSoTrucTuyenPersistence
 * @see HoSoTrucTuyenUtil
 * @generated
 */
public class HoSoTrucTuyenPersistenceImpl extends BasePersistenceImpl<HoSoTrucTuyen>
	implements HoSoTrucTuyenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoSoTrucTuyenUtil} to access the ho so truc tuyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoSoTrucTuyenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOICHUYENHOSO =
		new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNoiChuyenHoSo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOICHUYENHOSO =
		new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNoiChuyenHoSo",
			new String[] { String.class.getName(), Integer.class.getName() },
			HoSoTrucTuyenModelImpl.NOICHUYENHOSO_COLUMN_BITMASK |
			HoSoTrucTuyenModelImpl.TRANGTHAIXULY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOICHUYENHOSO = new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNoiChuyenHoSo",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MADONVITIEPNHAN =
		new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMaDonViTiepNhan",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MADONVITIEPNHAN =
		new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMaDonViTiepNhan",
			new String[] { String.class.getName(), Integer.class.getName() },
			HoSoTrucTuyenModelImpl.MADONVITIEPNHAN_COLUMN_BITMASK |
			HoSoTrucTuyenModelImpl.TRANGTHAIXULY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MADONVITIEPNHAN = new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMaDonViTiepNhan",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho so truc tuyen in the entity cache if it is enabled.
	 *
	 * @param hoSoTrucTuyen the ho so truc tuyen
	 */
	public void cacheResult(HoSoTrucTuyen hoSoTrucTuyen) {
		EntityCacheUtil.putResult(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, hoSoTrucTuyen.getPrimaryKey(),
			hoSoTrucTuyen);

		hoSoTrucTuyen.resetOriginalValues();
	}

	/**
	 * Caches the ho so truc tuyens in the entity cache if it is enabled.
	 *
	 * @param hoSoTrucTuyens the ho so truc tuyens
	 */
	public void cacheResult(List<HoSoTrucTuyen> hoSoTrucTuyens) {
		for (HoSoTrucTuyen hoSoTrucTuyen : hoSoTrucTuyens) {
			if (EntityCacheUtil.getResult(
						HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
						HoSoTrucTuyenImpl.class, hoSoTrucTuyen.getPrimaryKey()) == null) {
				cacheResult(hoSoTrucTuyen);
			}
			else {
				hoSoTrucTuyen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho so truc tuyens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoSoTrucTuyenImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoSoTrucTuyenImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho so truc tuyen.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoSoTrucTuyen hoSoTrucTuyen) {
		EntityCacheUtil.removeResult(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, hoSoTrucTuyen.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HoSoTrucTuyen> hoSoTrucTuyens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoSoTrucTuyen hoSoTrucTuyen : hoSoTrucTuyens) {
			EntityCacheUtil.removeResult(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
				HoSoTrucTuyenImpl.class, hoSoTrucTuyen.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ho so truc tuyen with the primary key. Does not add the ho so truc tuyen to the database.
	 *
	 * @param id the primary key for the new ho so truc tuyen
	 * @return the new ho so truc tuyen
	 */
	public HoSoTrucTuyen create(long id) {
		HoSoTrucTuyen hoSoTrucTuyen = new HoSoTrucTuyenImpl();

		hoSoTrucTuyen.setNew(true);
		hoSoTrucTuyen.setPrimaryKey(id);

		return hoSoTrucTuyen;
	}

	/**
	 * Removes the ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ho so truc tuyen
	 * @return the ho so truc tuyen that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen remove(long id)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho so truc tuyen
	 * @return the ho so truc tuyen that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoTrucTuyen remove(Serializable primaryKey)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoSoTrucTuyen hoSoTrucTuyen = (HoSoTrucTuyen)session.get(HoSoTrucTuyenImpl.class,
					primaryKey);

			if (hoSoTrucTuyen == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoSoTrucTuyenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoSoTrucTuyen);
		}
		catch (NoSuchHoSoTrucTuyenException nsee) {
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
	protected HoSoTrucTuyen removeImpl(HoSoTrucTuyen hoSoTrucTuyen)
		throws SystemException {
		hoSoTrucTuyen = toUnwrappedModel(hoSoTrucTuyen);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoSoTrucTuyen);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoSoTrucTuyen);

		return hoSoTrucTuyen;
	}

	@Override
	public HoSoTrucTuyen updateImpl(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen, boolean merge)
		throws SystemException {
		hoSoTrucTuyen = toUnwrappedModel(hoSoTrucTuyen);

		boolean isNew = hoSoTrucTuyen.isNew();

		HoSoTrucTuyenModelImpl hoSoTrucTuyenModelImpl = (HoSoTrucTuyenModelImpl)hoSoTrucTuyen;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoSoTrucTuyen, merge);

			hoSoTrucTuyen.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HoSoTrucTuyenModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hoSoTrucTuyenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOICHUYENHOSO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTrucTuyenModelImpl.getOriginalNoiChuyenHoSo(),
						Integer.valueOf(hoSoTrucTuyenModelImpl.getOriginalTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOICHUYENHOSO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOICHUYENHOSO,
					args);

				args = new Object[] {
						hoSoTrucTuyenModelImpl.getNoiChuyenHoSo(),
						Integer.valueOf(hoSoTrucTuyenModelImpl.getTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOICHUYENHOSO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOICHUYENHOSO,
					args);
			}

			if ((hoSoTrucTuyenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MADONVITIEPNHAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hoSoTrucTuyenModelImpl.getOriginalMaDonViTiepNhan(),
						Integer.valueOf(hoSoTrucTuyenModelImpl.getOriginalTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MADONVITIEPNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MADONVITIEPNHAN,
					args);

				args = new Object[] {
						hoSoTrucTuyenModelImpl.getMaDonViTiepNhan(),
						Integer.valueOf(hoSoTrucTuyenModelImpl.getTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MADONVITIEPNHAN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MADONVITIEPNHAN,
					args);
			}
		}

		EntityCacheUtil.putResult(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
			HoSoTrucTuyenImpl.class, hoSoTrucTuyen.getPrimaryKey(),
			hoSoTrucTuyen);

		return hoSoTrucTuyen;
	}

	protected HoSoTrucTuyen toUnwrappedModel(HoSoTrucTuyen hoSoTrucTuyen) {
		if (hoSoTrucTuyen instanceof HoSoTrucTuyenImpl) {
			return hoSoTrucTuyen;
		}

		HoSoTrucTuyenImpl hoSoTrucTuyenImpl = new HoSoTrucTuyenImpl();

		hoSoTrucTuyenImpl.setNew(hoSoTrucTuyen.isNew());
		hoSoTrucTuyenImpl.setPrimaryKey(hoSoTrucTuyen.getPrimaryKey());

		hoSoTrucTuyenImpl.setId(hoSoTrucTuyen.getId());
		hoSoTrucTuyenImpl.setNgayTrichXuat(hoSoTrucTuyen.getNgayTrichXuat());
		hoSoTrucTuyenImpl.setOnlineId(hoSoTrucTuyen.getOnlineId());
		hoSoTrucTuyenImpl.setMaLoaiHoSo(hoSoTrucTuyen.getMaLoaiHoSo());
		hoSoTrucTuyenImpl.setMaDonViTiepNhan(hoSoTrucTuyen.getMaDonViTiepNhan());
		hoSoTrucTuyenImpl.setHoTenNguoiNop(hoSoTrucTuyen.getHoTenNguoiNop());
		hoSoTrucTuyenImpl.setDiaChiNguoiNop(hoSoTrucTuyen.getDiaChiNguoiNop());
		hoSoTrucTuyenImpl.setNgaySinh(hoSoTrucTuyen.getNgaySinh());
		hoSoTrucTuyenImpl.setSoCmnd(hoSoTrucTuyen.getSoCmnd());
		hoSoTrucTuyenImpl.setEmail(hoSoTrucTuyen.getEmail());
		hoSoTrucTuyenImpl.setSoDtDiDong(hoSoTrucTuyen.getSoDtDiDong());
		hoSoTrucTuyenImpl.setSoDtCoDinh(hoSoTrucTuyen.getSoDtCoDinh());
		hoSoTrucTuyenImpl.setNgayDangKyHoSo(hoSoTrucTuyen.getNgayDangKyHoSo());
		hoSoTrucTuyenImpl.setNoiChuyenHoSo(hoSoTrucTuyen.getNoiChuyenHoSo());
		hoSoTrucTuyenImpl.setTrangThaiXuLy(hoSoTrucTuyen.getTrangThaiXuLy());
		hoSoTrucTuyenImpl.setNgayChuyen(hoSoTrucTuyen.getNgayChuyen());
		hoSoTrucTuyenImpl.setGioiTinh(hoSoTrucTuyen.getGioiTinh());
		hoSoTrucTuyenImpl.setChuSoHuuHoSo(hoSoTrucTuyen.getChuSoHuuHoSo());

		return hoSoTrucTuyenImpl;
	}

	/**
	 * Returns the ho so truc tuyen with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so truc tuyen
	 * @return the ho so truc tuyen
	 * @throws com.liferay.portal.NoSuchModelException if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoTrucTuyen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so truc tuyen with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException} if it could not be found.
	 *
	 * @param id the primary key of the ho so truc tuyen
	 * @return the ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen findByPrimaryKey(long id)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		HoSoTrucTuyen hoSoTrucTuyen = fetchByPrimaryKey(id);

		if (hoSoTrucTuyen == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHoSoTrucTuyenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hoSoTrucTuyen;
	}

	/**
	 * Returns the ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho so truc tuyen
	 * @return the ho so truc tuyen, or <code>null</code> if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoSoTrucTuyen fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ho so truc tuyen
	 * @return the ho so truc tuyen, or <code>null</code> if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen fetchByPrimaryKey(long id) throws SystemException {
		HoSoTrucTuyen hoSoTrucTuyen = (HoSoTrucTuyen)EntityCacheUtil.getResult(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
				HoSoTrucTuyenImpl.class, id);

		if (hoSoTrucTuyen == _nullHoSoTrucTuyen) {
			return null;
		}

		if (hoSoTrucTuyen == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoSoTrucTuyen = (HoSoTrucTuyen)session.get(HoSoTrucTuyenImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoSoTrucTuyen != null) {
					cacheResult(hoSoTrucTuyen);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoSoTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
						HoSoTrucTuyenImpl.class, id, _nullHoSoTrucTuyen);
				}

				closeSession(session);
			}
		}

		return hoSoTrucTuyen;
	}

	/**
	 * Returns all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findByNoiChuyenHoSo(String NoiChuyenHoSo,
		int TrangThaiXuLy) throws SystemException {
		return findByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of ho so truc tuyens
	 * @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	 * @return the range of matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findByNoiChuyenHoSo(String NoiChuyenHoSo,
		int TrangThaiXuLy, int start, int end) throws SystemException {
		return findByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of ho so truc tuyens
	 * @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findByNoiChuyenHoSo(String NoiChuyenHoSo,
		int TrangThaiXuLy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOICHUYENHOSO;
			finderArgs = new Object[] { NoiChuyenHoSo, TrangThaiXuLy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOICHUYENHOSO;
			finderArgs = new Object[] {
					NoiChuyenHoSo, TrangThaiXuLy,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTrucTuyen> list = (List<HoSoTrucTuyen>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTRUCTUYEN_WHERE);

			if (NoiChuyenHoSo == null) {
				query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_1);
			}
			else {
				if (NoiChuyenHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_2);
				}
			}

			query.append(_FINDER_COLUMN_NOICHUYENHOSO_TRANGTHAIXULY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTrucTuyenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (NoiChuyenHoSo != null) {
					qPos.add(NoiChuyenHoSo);
				}

				qPos.add(TrangThaiXuLy);

				list = (List<HoSoTrucTuyen>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so truc tuyen in the ordered set where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen findByNoiChuyenHoSo_First(String NoiChuyenHoSo,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		List<HoSoTrucTuyen> list = findByNoiChuyenHoSo(NoiChuyenHoSo,
				TrangThaiXuLy, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("NoiChuyenHoSo=");
			msg.append(NoiChuyenHoSo);

			msg.append(", TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTrucTuyenException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so truc tuyen in the ordered set where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen findByNoiChuyenHoSo_Last(String NoiChuyenHoSo,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		int count = countByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy);

		List<HoSoTrucTuyen> list = findByNoiChuyenHoSo(NoiChuyenHoSo,
				TrangThaiXuLy, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("NoiChuyenHoSo=");
			msg.append(NoiChuyenHoSo);

			msg.append(", TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTrucTuyenException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so truc tuyens before and after the current ho so truc tuyen in the ordered set where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so truc tuyen
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen[] findByNoiChuyenHoSo_PrevAndNext(long id,
		String NoiChuyenHoSo, int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		HoSoTrucTuyen hoSoTrucTuyen = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTrucTuyen[] array = new HoSoTrucTuyenImpl[3];

			array[0] = getByNoiChuyenHoSo_PrevAndNext(session, hoSoTrucTuyen,
					NoiChuyenHoSo, TrangThaiXuLy, orderByComparator, true);

			array[1] = hoSoTrucTuyen;

			array[2] = getByNoiChuyenHoSo_PrevAndNext(session, hoSoTrucTuyen,
					NoiChuyenHoSo, TrangThaiXuLy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTrucTuyen getByNoiChuyenHoSo_PrevAndNext(Session session,
		HoSoTrucTuyen hoSoTrucTuyen, String NoiChuyenHoSo, int TrangThaiXuLy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTRUCTUYEN_WHERE);

		if (NoiChuyenHoSo == null) {
			query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_1);
		}
		else {
			if (NoiChuyenHoSo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_3);
			}
			else {
				query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_2);
			}
		}

		query.append(_FINDER_COLUMN_NOICHUYENHOSO_TRANGTHAIXULY_2);

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
			query.append(HoSoTrucTuyenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (NoiChuyenHoSo != null) {
			qPos.add(NoiChuyenHoSo);
		}

		qPos.add(TrangThaiXuLy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTrucTuyen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTrucTuyen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findByMaDonViTiepNhan(String MaDonViTiepNhan,
		int TrangThaiXuLy) throws SystemException {
		return findByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of ho so truc tuyens
	 * @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	 * @return the range of matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findByMaDonViTiepNhan(String MaDonViTiepNhan,
		int TrangThaiXuLy, int start, int end) throws SystemException {
		return findByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of ho so truc tuyens
	 * @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findByMaDonViTiepNhan(String MaDonViTiepNhan,
		int TrangThaiXuLy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MADONVITIEPNHAN;
			finderArgs = new Object[] { MaDonViTiepNhan, TrangThaiXuLy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MADONVITIEPNHAN;
			finderArgs = new Object[] {
					MaDonViTiepNhan, TrangThaiXuLy,
					
					start, end, orderByComparator
				};
		}

		List<HoSoTrucTuyen> list = (List<HoSoTrucTuyen>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HOSOTRUCTUYEN_WHERE);

			if (MaDonViTiepNhan == null) {
				query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_1);
			}
			else {
				if (MaDonViTiepNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_2);
				}
			}

			query.append(_FINDER_COLUMN_MADONVITIEPNHAN_TRANGTHAIXULY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HoSoTrucTuyenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (MaDonViTiepNhan != null) {
					qPos.add(MaDonViTiepNhan);
				}

				qPos.add(TrangThaiXuLy);

				list = (List<HoSoTrucTuyen>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ho so truc tuyen in the ordered set where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen findByMaDonViTiepNhan_First(String MaDonViTiepNhan,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		List<HoSoTrucTuyen> list = findByMaDonViTiepNhan(MaDonViTiepNhan,
				TrangThaiXuLy, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MaDonViTiepNhan=");
			msg.append(MaDonViTiepNhan);

			msg.append(", TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTrucTuyenException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ho so truc tuyen in the ordered set where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen findByMaDonViTiepNhan_Last(String MaDonViTiepNhan,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		int count = countByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy);

		List<HoSoTrucTuyen> list = findByMaDonViTiepNhan(MaDonViTiepNhan,
				TrangThaiXuLy, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MaDonViTiepNhan=");
			msg.append(MaDonViTiepNhan);

			msg.append(", TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHoSoTrucTuyenException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ho so truc tuyens before and after the current ho so truc tuyen in the ordered set where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ho so truc tuyen
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ho so truc tuyen
	 * @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoSoTrucTuyen[] findByMaDonViTiepNhan_PrevAndNext(long id,
		String MaDonViTiepNhan, int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchHoSoTrucTuyenException, SystemException {
		HoSoTrucTuyen hoSoTrucTuyen = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HoSoTrucTuyen[] array = new HoSoTrucTuyenImpl[3];

			array[0] = getByMaDonViTiepNhan_PrevAndNext(session, hoSoTrucTuyen,
					MaDonViTiepNhan, TrangThaiXuLy, orderByComparator, true);

			array[1] = hoSoTrucTuyen;

			array[2] = getByMaDonViTiepNhan_PrevAndNext(session, hoSoTrucTuyen,
					MaDonViTiepNhan, TrangThaiXuLy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HoSoTrucTuyen getByMaDonViTiepNhan_PrevAndNext(Session session,
		HoSoTrucTuyen hoSoTrucTuyen, String MaDonViTiepNhan, int TrangThaiXuLy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOSOTRUCTUYEN_WHERE);

		if (MaDonViTiepNhan == null) {
			query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_1);
		}
		else {
			if (MaDonViTiepNhan.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_3);
			}
			else {
				query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_2);
			}
		}

		query.append(_FINDER_COLUMN_MADONVITIEPNHAN_TRANGTHAIXULY_2);

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
			query.append(HoSoTrucTuyenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (MaDonViTiepNhan != null) {
			qPos.add(MaDonViTiepNhan);
		}

		qPos.add(TrangThaiXuLy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hoSoTrucTuyen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HoSoTrucTuyen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ho so truc tuyens.
	 *
	 * @return the ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho so truc tuyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so truc tuyens
	 * @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	 * @return the range of ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho so truc tuyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho so truc tuyens
	 * @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoSoTrucTuyen> findAll(int start, int end,
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

		List<HoSoTrucTuyen> list = (List<HoSoTrucTuyen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOSOTRUCTUYEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOSOTRUCTUYEN.concat(HoSoTrucTuyenModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoSoTrucTuyen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoSoTrucTuyen>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63; from the database.
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNoiChuyenHoSo(String NoiChuyenHoSo, int TrangThaiXuLy)
		throws SystemException {
		for (HoSoTrucTuyen hoSoTrucTuyen : findByNoiChuyenHoSo(NoiChuyenHoSo,
				TrangThaiXuLy)) {
			remove(hoSoTrucTuyen);
		}
	}

	/**
	 * Removes all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63; from the database.
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaDonViTiepNhan(String MaDonViTiepNhan,
		int TrangThaiXuLy) throws SystemException {
		for (HoSoTrucTuyen hoSoTrucTuyen : findByMaDonViTiepNhan(
				MaDonViTiepNhan, TrangThaiXuLy)) {
			remove(hoSoTrucTuyen);
		}
	}

	/**
	 * Removes all the ho so truc tuyens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoSoTrucTuyen hoSoTrucTuyen : findAll()) {
			remove(hoSoTrucTuyen);
		}
	}

	/**
	 * Returns the number of ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * @param NoiChuyenHoSo the noi chuyen ho so
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the number of matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNoiChuyenHoSo(String NoiChuyenHoSo, int TrangThaiXuLy)
		throws SystemException {
		Object[] finderArgs = new Object[] { NoiChuyenHoSo, TrangThaiXuLy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOICHUYENHOSO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOTRUCTUYEN_WHERE);

			if (NoiChuyenHoSo == null) {
				query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_1);
			}
			else {
				if (NoiChuyenHoSo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_3);
				}
				else {
					query.append(_FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_2);
				}
			}

			query.append(_FINDER_COLUMN_NOICHUYENHOSO_TRANGTHAIXULY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (NoiChuyenHoSo != null) {
					qPos.add(NoiChuyenHoSo);
				}

				qPos.add(TrangThaiXuLy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOICHUYENHOSO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	 *
	 * @param MaDonViTiepNhan the ma don vi tiep nhan
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the number of matching ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaDonViTiepNhan(String MaDonViTiepNhan, int TrangThaiXuLy)
		throws SystemException {
		Object[] finderArgs = new Object[] { MaDonViTiepNhan, TrangThaiXuLy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MADONVITIEPNHAN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOSOTRUCTUYEN_WHERE);

			if (MaDonViTiepNhan == null) {
				query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_1);
			}
			else {
				if (MaDonViTiepNhan.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_3);
				}
				else {
					query.append(_FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_2);
				}
			}

			query.append(_FINDER_COLUMN_MADONVITIEPNHAN_TRANGTHAIXULY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (MaDonViTiepNhan != null) {
					qPos.add(MaDonViTiepNhan);
				}

				qPos.add(TrangThaiXuLy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MADONVITIEPNHAN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ho so truc tuyens.
	 *
	 * @return the number of ho so truc tuyens
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOSOTRUCTUYEN);

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
	 * Initializes the ho so truc tuyen persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.exch.dao.hoso.model.HoSoTrucTuyen")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoSoTrucTuyen>> listenersList = new ArrayList<ModelListener<HoSoTrucTuyen>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoSoTrucTuyen>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HoSoTrucTuyenImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ExchFileDinhKemPersistence.class)
	protected ExchFileDinhKemPersistence exchFileDinhKemPersistence;
	@BeanReference(type = HoSoMotCuaPersistence.class)
	protected HoSoMotCuaPersistence hoSoMotCuaPersistence;
	@BeanReference(type = HoSoTrucTuyenPersistence.class)
	protected HoSoTrucTuyenPersistence hoSoTrucTuyenPersistence;
	@BeanReference(type = KetQuaHosoPersistence.class)
	protected KetQuaHosoPersistence ketQuaHosoPersistence;
	@BeanReference(type = TrangThaiHosoPersistence.class)
	protected TrangThaiHosoPersistence trangThaiHosoPersistence;
	@BeanReference(type = UpdateHoSoTrucTuyenPersistence.class)
	protected UpdateHoSoTrucTuyenPersistence updateHoSoTrucTuyenPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HOSOTRUCTUYEN = "SELECT hoSoTrucTuyen FROM HoSoTrucTuyen hoSoTrucTuyen";
	private static final String _SQL_SELECT_HOSOTRUCTUYEN_WHERE = "SELECT hoSoTrucTuyen FROM HoSoTrucTuyen hoSoTrucTuyen WHERE ";
	private static final String _SQL_COUNT_HOSOTRUCTUYEN = "SELECT COUNT(hoSoTrucTuyen) FROM HoSoTrucTuyen hoSoTrucTuyen";
	private static final String _SQL_COUNT_HOSOTRUCTUYEN_WHERE = "SELECT COUNT(hoSoTrucTuyen) FROM HoSoTrucTuyen hoSoTrucTuyen WHERE ";
	private static final String _FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_1 = "hoSoTrucTuyen.NoiChuyenHoSo IS NULL AND ";
	private static final String _FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_2 = "hoSoTrucTuyen.NoiChuyenHoSo = ? AND ";
	private static final String _FINDER_COLUMN_NOICHUYENHOSO_NOICHUYENHOSO_3 = "(hoSoTrucTuyen.NoiChuyenHoSo IS NULL OR hoSoTrucTuyen.NoiChuyenHoSo = ?) AND ";
	private static final String _FINDER_COLUMN_NOICHUYENHOSO_TRANGTHAIXULY_2 = "hoSoTrucTuyen.TrangThaiXuLy = ?";
	private static final String _FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_1 =
		"hoSoTrucTuyen.MaDonViTiepNhan IS NULL AND ";
	private static final String _FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_2 =
		"hoSoTrucTuyen.MaDonViTiepNhan = ? AND ";
	private static final String _FINDER_COLUMN_MADONVITIEPNHAN_MADONVITIEPNHAN_3 =
		"(hoSoTrucTuyen.MaDonViTiepNhan IS NULL OR hoSoTrucTuyen.MaDonViTiepNhan = ?) AND ";
	private static final String _FINDER_COLUMN_MADONVITIEPNHAN_TRANGTHAIXULY_2 = "hoSoTrucTuyen.TrangThaiXuLy = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoSoTrucTuyen.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoSoTrucTuyen exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HoSoTrucTuyen exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoSoTrucTuyenPersistenceImpl.class);
	private static HoSoTrucTuyen _nullHoSoTrucTuyen = new HoSoTrucTuyenImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoSoTrucTuyen> toCacheModel() {
				return _nullHoSoTrucTuyenCacheModel;
			}
		};

	private static CacheModel<HoSoTrucTuyen> _nullHoSoTrucTuyenCacheModel = new CacheModel<HoSoTrucTuyen>() {
			public HoSoTrucTuyen toEntityModel() {
				return _nullHoSoTrucTuyen;
			}
		};
}