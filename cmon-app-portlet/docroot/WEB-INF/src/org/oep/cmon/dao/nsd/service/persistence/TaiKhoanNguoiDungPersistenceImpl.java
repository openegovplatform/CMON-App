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

package org.oep.cmon.dao.nsd.service.persistence;

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

import org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl;
import org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tai khoan nguoi dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiKhoanNguoiDungPersistence
 * @see TaiKhoanNguoiDungUtil
 * @generated
 */
public class TaiKhoanNguoiDungPersistenceImpl extends BasePersistenceImpl<TaiKhoanNguoiDung>
	implements TaiKhoanNguoiDungPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaiKhoanNguoiDungUtil} to access the tai khoan nguoi dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaiKhoanNguoiDungImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_TENDANGNHAP = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTenDangNhap", new String[] { String.class.getName() },
			TaiKhoanNguoiDungModelImpl.TENDANGNHAP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENDANGNHAP = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTenDangNhap",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TENNGUOIDUNG =
		new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTenNguoiDung",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENNGUOIDUNG =
		new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTenNguoiDung",
			new String[] { String.class.getName() },
			TaiKhoanNguoiDungModelImpl.TENNGUOIDUNG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENNGUOIDUNG = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTenNguoiDung",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] { String.class.getName() },
			TaiKhoanNguoiDungModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			TaiKhoanNguoiDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG =
		new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaiKhoanNguoiDung",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG =
		new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTaiKhoanNguoiDung",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TaiKhoanNguoiDungModelImpl.TAIKHOANNGUOIDUNGID_COLUMN_BITMASK |
			TaiKhoanNguoiDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNG = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanNguoiDung",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tai khoan nguoi dung in the entity cache if it is enabled.
	 *
	 * @param taiKhoanNguoiDung the tai khoan nguoi dung
	 */
	public void cacheResult(TaiKhoanNguoiDung taiKhoanNguoiDung) {
		EntityCacheUtil.putResult(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class, taiKhoanNguoiDung.getPrimaryKey(),
			taiKhoanNguoiDung);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
			new Object[] { taiKhoanNguoiDung.getTenDangNhap() },
			taiKhoanNguoiDung);

		taiKhoanNguoiDung.resetOriginalValues();
	}

	/**
	 * Caches the tai khoan nguoi dungs in the entity cache if it is enabled.
	 *
	 * @param taiKhoanNguoiDungs the tai khoan nguoi dungs
	 */
	public void cacheResult(List<TaiKhoanNguoiDung> taiKhoanNguoiDungs) {
		for (TaiKhoanNguoiDung taiKhoanNguoiDung : taiKhoanNguoiDungs) {
			if (EntityCacheUtil.getResult(
						TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
						TaiKhoanNguoiDungImpl.class,
						taiKhoanNguoiDung.getPrimaryKey()) == null) {
				cacheResult(taiKhoanNguoiDung);
			}
			else {
				taiKhoanNguoiDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tai khoan nguoi dungs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaiKhoanNguoiDungImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaiKhoanNguoiDungImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tai khoan nguoi dung.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaiKhoanNguoiDung taiKhoanNguoiDung) {
		EntityCacheUtil.removeResult(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class, taiKhoanNguoiDung.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(taiKhoanNguoiDung);
	}

	@Override
	public void clearCache(List<TaiKhoanNguoiDung> taiKhoanNguoiDungs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaiKhoanNguoiDung taiKhoanNguoiDung : taiKhoanNguoiDungs) {
			EntityCacheUtil.removeResult(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanNguoiDungImpl.class, taiKhoanNguoiDung.getPrimaryKey());

			clearUniqueFindersCache(taiKhoanNguoiDung);
		}
	}

	protected void clearUniqueFindersCache(TaiKhoanNguoiDung taiKhoanNguoiDung) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
			new Object[] { taiKhoanNguoiDung.getTenDangNhap() });
	}

	/**
	 * Creates a new tai khoan nguoi dung with the primary key. Does not add the tai khoan nguoi dung to the database.
	 *
	 * @param id the primary key for the new tai khoan nguoi dung
	 * @return the new tai khoan nguoi dung
	 */
	public TaiKhoanNguoiDung create(long id) {
		TaiKhoanNguoiDung taiKhoanNguoiDung = new TaiKhoanNguoiDungImpl();

		taiKhoanNguoiDung.setNew(true);
		taiKhoanNguoiDung.setPrimaryKey(id);

		return taiKhoanNguoiDung;
	}

	/**
	 * Removes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tai khoan nguoi dung
	 * @return the tai khoan nguoi dung that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung remove(long id)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tai khoan nguoi dung
	 * @return the tai khoan nguoi dung that was removed
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiKhoanNguoiDung remove(Serializable primaryKey)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaiKhoanNguoiDung taiKhoanNguoiDung = (TaiKhoanNguoiDung)session.get(TaiKhoanNguoiDungImpl.class,
					primaryKey);

			if (taiKhoanNguoiDung == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaiKhoanNguoiDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taiKhoanNguoiDung);
		}
		catch (NoSuchTaiKhoanNguoiDungException nsee) {
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
	protected TaiKhoanNguoiDung removeImpl(TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws SystemException {
		taiKhoanNguoiDung = toUnwrappedModel(taiKhoanNguoiDung);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, taiKhoanNguoiDung);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(taiKhoanNguoiDung);

		return taiKhoanNguoiDung;
	}

	@Override
	public TaiKhoanNguoiDung updateImpl(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
		boolean merge) throws SystemException {
		taiKhoanNguoiDung = toUnwrappedModel(taiKhoanNguoiDung);

		boolean isNew = taiKhoanNguoiDung.isNew();

		TaiKhoanNguoiDungModelImpl taiKhoanNguoiDungModelImpl = (TaiKhoanNguoiDungModelImpl)taiKhoanNguoiDung;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taiKhoanNguoiDung, merge);

			taiKhoanNguoiDung.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaiKhoanNguoiDungModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((taiKhoanNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENNGUOIDUNG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taiKhoanNguoiDungModelImpl.getOriginalTenNguoiDung()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENNGUOIDUNG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENNGUOIDUNG,
					args);

				args = new Object[] { taiKhoanNguoiDungModelImpl.getTenNguoiDung() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENNGUOIDUNG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENNGUOIDUNG,
					args);
			}

			if ((taiKhoanNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taiKhoanNguoiDungModelImpl.getOriginalEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { taiKhoanNguoiDungModelImpl.getEmail() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((taiKhoanNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(taiKhoanNguoiDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(taiKhoanNguoiDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((taiKhoanNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(taiKhoanNguoiDungModelImpl.getOriginalTaiKhoanNguoiDungId()),
						Integer.valueOf(taiKhoanNguoiDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG,
					args);

				args = new Object[] {
						Long.valueOf(taiKhoanNguoiDungModelImpl.getTaiKhoanNguoiDungId()),
						Integer.valueOf(taiKhoanNguoiDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG,
					args);
			}
		}

		EntityCacheUtil.putResult(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanNguoiDungImpl.class, taiKhoanNguoiDung.getPrimaryKey(),
			taiKhoanNguoiDung);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
				new Object[] { taiKhoanNguoiDung.getTenDangNhap() },
				taiKhoanNguoiDung);
		}
		else {
			if ((taiKhoanNguoiDungModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TENDANGNHAP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taiKhoanNguoiDungModelImpl.getOriginalTenDangNhap()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENDANGNHAP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
					new Object[] { taiKhoanNguoiDung.getTenDangNhap() },
					taiKhoanNguoiDung);
			}
		}

		return taiKhoanNguoiDung;
	}

	protected TaiKhoanNguoiDung toUnwrappedModel(
		TaiKhoanNguoiDung taiKhoanNguoiDung) {
		if (taiKhoanNguoiDung instanceof TaiKhoanNguoiDungImpl) {
			return taiKhoanNguoiDung;
		}

		TaiKhoanNguoiDungImpl taiKhoanNguoiDungImpl = new TaiKhoanNguoiDungImpl();

		taiKhoanNguoiDungImpl.setNew(taiKhoanNguoiDung.isNew());
		taiKhoanNguoiDungImpl.setPrimaryKey(taiKhoanNguoiDung.getPrimaryKey());

		taiKhoanNguoiDungImpl.setId(taiKhoanNguoiDung.getId());
		taiKhoanNguoiDungImpl.setTenDangNhap(taiKhoanNguoiDung.getTenDangNhap());
		taiKhoanNguoiDungImpl.setMatKhau(taiKhoanNguoiDung.getMatKhau());
		taiKhoanNguoiDungImpl.setTenNguoiDung(taiKhoanNguoiDung.getTenNguoiDung());
		taiKhoanNguoiDungImpl.setCauHoiMatKhau(taiKhoanNguoiDung.getCauHoiMatKhau());
		taiKhoanNguoiDungImpl.setCauTraLoiMatKhau(taiKhoanNguoiDung.getCauTraLoiMatKhau());
		taiKhoanNguoiDungImpl.setEmail(taiKhoanNguoiDung.getEmail());
		taiKhoanNguoiDungImpl.setNgayTao(taiKhoanNguoiDung.getNgayTao());
		taiKhoanNguoiDungImpl.setDaXoa(taiKhoanNguoiDung.getDaXoa());
		taiKhoanNguoiDungImpl.setNgaySua(taiKhoanNguoiDung.getNgaySua());
		taiKhoanNguoiDungImpl.setNguoiTao(taiKhoanNguoiDung.getNguoiTao());
		taiKhoanNguoiDungImpl.setNguoiSua(taiKhoanNguoiDung.getNguoiSua());
		taiKhoanNguoiDungImpl.setTrangThai(taiKhoanNguoiDung.getTrangThai());
		taiKhoanNguoiDungImpl.setLoaiDoiTuongId(taiKhoanNguoiDung.getLoaiDoiTuongId());
		taiKhoanNguoiDungImpl.setTaiKhoanNguoiDungId(taiKhoanNguoiDung.getTaiKhoanNguoiDungId());

		return taiKhoanNguoiDungImpl;
	}

	/**
	 * Returns the tai khoan nguoi dung with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai khoan nguoi dung
	 * @return the tai khoan nguoi dung
	 * @throws com.liferay.portal.NoSuchModelException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiKhoanNguoiDung findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai khoan nguoi dung with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException} if it could not be found.
	 *
	 * @param id the primary key of the tai khoan nguoi dung
	 * @return the tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByPrimaryKey(long id)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = fetchByPrimaryKey(id);

		if (taiKhoanNguoiDung == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTaiKhoanNguoiDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return taiKhoanNguoiDung;
	}

	/**
	 * Returns the tai khoan nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai khoan nguoi dung
	 * @return the tai khoan nguoi dung, or <code>null</code> if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiKhoanNguoiDung fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai khoan nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tai khoan nguoi dung
	 * @return the tai khoan nguoi dung, or <code>null</code> if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung fetchByPrimaryKey(long id)
		throws SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = (TaiKhoanNguoiDung)EntityCacheUtil.getResult(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanNguoiDungImpl.class, id);

		if (taiKhoanNguoiDung == _nullTaiKhoanNguoiDung) {
			return null;
		}

		if (taiKhoanNguoiDung == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				taiKhoanNguoiDung = (TaiKhoanNguoiDung)session.get(TaiKhoanNguoiDungImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (taiKhoanNguoiDung != null) {
					cacheResult(taiKhoanNguoiDung);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TaiKhoanNguoiDungModelImpl.ENTITY_CACHE_ENABLED,
						TaiKhoanNguoiDungImpl.class, id, _nullTaiKhoanNguoiDung);
				}

				closeSession(session);
			}
		}

		return taiKhoanNguoiDung;
	}

	/**
	 * Returns the tai khoan nguoi dung where tenDangNhap = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException} if it could not be found.
	 *
	 * @param tenDangNhap the ten dang nhap
	 * @return the matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTenDangNhap(String tenDangNhap)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = fetchByTenDangNhap(tenDangNhap);

		if (taiKhoanNguoiDung == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenDangNhap=");
			msg.append(tenDangNhap);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}

		return taiKhoanNguoiDung;
	}

	/**
	 * Returns the tai khoan nguoi dung where tenDangNhap = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenDangNhap the ten dang nhap
	 * @return the matching tai khoan nguoi dung, or <code>null</code> if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung fetchByTenDangNhap(String tenDangNhap)
		throws SystemException {
		return fetchByTenDangNhap(tenDangNhap, true);
	}

	/**
	 * Returns the tai khoan nguoi dung where tenDangNhap = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenDangNhap the ten dang nhap
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tai khoan nguoi dung, or <code>null</code> if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung fetchByTenDangNhap(String tenDangNhap,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { tenDangNhap };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

			if (tenDangNhap == null) {
				query.append(_FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_1);
			}
			else {
				if (tenDangNhap.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_2);
				}
			}

			query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenDangNhap != null) {
					qPos.add(tenDangNhap);
				}

				List<TaiKhoanNguoiDung> list = q.list();

				result = list;

				TaiKhoanNguoiDung taiKhoanNguoiDung = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
						finderArgs, list);
				}
				else {
					taiKhoanNguoiDung = list.get(0);

					cacheResult(taiKhoanNguoiDung);

					if ((taiKhoanNguoiDung.getTenDangNhap() == null) ||
							!taiKhoanNguoiDung.getTenDangNhap()
												  .equals(tenDangNhap)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
							finderArgs, taiKhoanNguoiDung);
					}
				}

				return taiKhoanNguoiDung;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDANGNHAP,
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
				return (TaiKhoanNguoiDung)result;
			}
		}
	}

	/**
	 * Returns all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @return the matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTenNguoiDung(String tenNguoiDung)
		throws SystemException {
		return findByTenNguoiDung(tenNguoiDung, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @return the range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTenNguoiDung(String tenNguoiDung,
		int start, int end) throws SystemException {
		return findByTenNguoiDung(tenNguoiDung, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTenNguoiDung(String tenNguoiDung,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TENNGUOIDUNG;
			finderArgs = new Object[] { tenNguoiDung };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TENNGUOIDUNG;
			finderArgs = new Object[] {
					tenNguoiDung,
					
					start, end, orderByComparator
				};
		}

		List<TaiKhoanNguoiDung> list = (List<TaiKhoanNguoiDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

			if (tenNguoiDung == null) {
				query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_1);
			}
			else {
				if (tenNguoiDung.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenNguoiDung != null) {
					qPos.add(tenNguoiDung);
				}

				list = (List<TaiKhoanNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTenNguoiDung_First(String tenNguoiDung,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		List<TaiKhoanNguoiDung> list = findByTenNguoiDung(tenNguoiDung, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenNguoiDung=");
			msg.append(tenNguoiDung);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTenNguoiDung_Last(String tenNguoiDung,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		int count = countByTenNguoiDung(tenNguoiDung);

		List<TaiKhoanNguoiDung> list = findByTenNguoiDung(tenNguoiDung,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tenNguoiDung=");
			msg.append(tenNguoiDung);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tai khoan nguoi dung
	 * @param tenNguoiDung the ten nguoi dung
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung[] findByTenNguoiDung_PrevAndNext(long id,
		String tenNguoiDung, OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanNguoiDung[] array = new TaiKhoanNguoiDungImpl[3];

			array[0] = getByTenNguoiDung_PrevAndNext(session,
					taiKhoanNguoiDung, tenNguoiDung, orderByComparator, true);

			array[1] = taiKhoanNguoiDung;

			array[2] = getByTenNguoiDung_PrevAndNext(session,
					taiKhoanNguoiDung, tenNguoiDung, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaiKhoanNguoiDung getByTenNguoiDung_PrevAndNext(Session session,
		TaiKhoanNguoiDung taiKhoanNguoiDung, String tenNguoiDung,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

		if (tenNguoiDung == null) {
			query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_1);
		}
		else {
			if (tenNguoiDung.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_3);
			}
			else {
				query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_2);
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
			query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (tenNguoiDung != null) {
			qPos.add(tenNguoiDung);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taiKhoanNguoiDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaiKhoanNguoiDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tai khoan nguoi dungs where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByEmail(String email)
		throws SystemException {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan nguoi dungs where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @return the range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByEmail(String email, int start, int end)
		throws SystemException {
		return findByEmail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan nguoi dungs where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByEmail(String email, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email, start, end, orderByComparator };
		}

		List<TaiKhoanNguoiDung> list = (List<TaiKhoanNguoiDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				list = (List<TaiKhoanNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tai khoan nguoi dung in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByEmail_First(String email,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		List<TaiKhoanNguoiDung> list = findByEmail(email, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tai khoan nguoi dung in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByEmail_Last(String email,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		int count = countByEmail(email);

		List<TaiKhoanNguoiDung> list = findByEmail(email, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tai khoan nguoi dung
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung[] findByEmail_PrevAndNext(long id, String email,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanNguoiDung[] array = new TaiKhoanNguoiDungImpl[3];

			array[0] = getByEmail_PrevAndNext(session, taiKhoanNguoiDung,
					email, orderByComparator, true);

			array[1] = taiKhoanNguoiDung;

			array[2] = getByEmail_PrevAndNext(session, taiKhoanNguoiDung,
					email, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaiKhoanNguoiDung getByEmail_PrevAndNext(Session session,
		TaiKhoanNguoiDung taiKhoanNguoiDung, String email,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

		if (email == null) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (email != null) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taiKhoanNguoiDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaiKhoanNguoiDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tai khoan nguoi dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan nguoi dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @return the range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan nguoi dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTrangThai(int daXoa, int start,
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

		List<TaiKhoanNguoiDung> list = (List<TaiKhoanNguoiDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<TaiKhoanNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		List<TaiKhoanNguoiDung> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		int count = countByTrangThai(daXoa);

		List<TaiKhoanNguoiDung> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tai khoan nguoi dung
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanNguoiDung[] array = new TaiKhoanNguoiDungImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, taiKhoanNguoiDung,
					daXoa, orderByComparator, true);

			array[1] = taiKhoanNguoiDung;

			array[2] = getByTrangThai_PrevAndNext(session, taiKhoanNguoiDung,
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

	protected TaiKhoanNguoiDung getByTrangThai_PrevAndNext(Session session,
		TaiKhoanNguoiDung taiKhoanNguoiDung, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

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
			query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taiKhoanNguoiDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaiKhoanNguoiDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		Long taiKhoanNguoiDungId, int daXoa) throws SystemException {
		return findByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @return the range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		Long taiKhoanNguoiDungId, int daXoa, int start, int end)
		throws SystemException {
		return findByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		Long taiKhoanNguoiDungId, int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG;
			finderArgs = new Object[] { taiKhoanNguoiDungId, daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAIKHOANNGUOIDUNG;
			finderArgs = new Object[] {
					taiKhoanNguoiDungId, daXoa,
					
					start, end, orderByComparator
				};
		}

		List<TaiKhoanNguoiDung> list = (List<TaiKhoanNguoiDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNG_TAIKHOANNGUOIDUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNG_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanNguoiDungId.longValue());

				qPos.add(daXoa);

				list = (List<TaiKhoanNguoiDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTaiKhoanNguoiDung_First(
		Long taiKhoanNguoiDungId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		List<TaiKhoanNguoiDung> list = findByTaiKhoanNguoiDung(taiKhoanNguoiDungId,
				daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung findByTaiKhoanNguoiDung_Last(
		Long taiKhoanNguoiDungId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		int count = countByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa);

		List<TaiKhoanNguoiDung> list = findByTaiKhoanNguoiDung(taiKhoanNguoiDungId,
				daXoa, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanNguoiDungId=");
			msg.append(taiKhoanNguoiDungId);

			msg.append(", daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiKhoanNguoiDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tai khoan nguoi dung
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan nguoi dung
	 * @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiKhoanNguoiDung[] findByTaiKhoanNguoiDung_PrevAndNext(long id,
		Long taiKhoanNguoiDungId, int daXoa, OrderByComparator orderByComparator)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanNguoiDung[] array = new TaiKhoanNguoiDungImpl[3];

			array[0] = getByTaiKhoanNguoiDung_PrevAndNext(session,
					taiKhoanNguoiDung, taiKhoanNguoiDungId, daXoa,
					orderByComparator, true);

			array[1] = taiKhoanNguoiDung;

			array[2] = getByTaiKhoanNguoiDung_PrevAndNext(session,
					taiKhoanNguoiDung, taiKhoanNguoiDungId, daXoa,
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

	protected TaiKhoanNguoiDung getByTaiKhoanNguoiDung_PrevAndNext(
		Session session, TaiKhoanNguoiDung taiKhoanNguoiDung,
		Long taiKhoanNguoiDungId, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE);

		query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNG_TAIKHOANNGUOIDUNGID_2);

		query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNG_DAXOA_2);

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
			query.append(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taiKhoanNguoiDungId.longValue());

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taiKhoanNguoiDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaiKhoanNguoiDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tai khoan nguoi dungs.
	 *
	 * @return the tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan nguoi dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @return the range of tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan nguoi dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan nguoi dungs
	 * @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiKhoanNguoiDung> findAll(int start, int end,
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

		List<TaiKhoanNguoiDung> list = (List<TaiKhoanNguoiDung>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAIKHOANNGUOIDUNG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAIKHOANNGUOIDUNG.concat(TaiKhoanNguoiDungModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TaiKhoanNguoiDung>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaiKhoanNguoiDung>)QueryUtil.list(q,
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
	 * Removes the tai khoan nguoi dung where tenDangNhap = &#63; from the database.
	 *
	 * @param tenDangNhap the ten dang nhap
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTenDangNhap(String tenDangNhap)
		throws NoSuchTaiKhoanNguoiDungException, SystemException {
		TaiKhoanNguoiDung taiKhoanNguoiDung = findByTenDangNhap(tenDangNhap);

		remove(taiKhoanNguoiDung);
	}

	/**
	 * Removes all the tai khoan nguoi dungs where tenNguoiDung = &#63; from the database.
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTenNguoiDung(String tenNguoiDung)
		throws SystemException {
		for (TaiKhoanNguoiDung taiKhoanNguoiDung : findByTenNguoiDung(
				tenNguoiDung)) {
			remove(taiKhoanNguoiDung);
		}
	}

	/**
	 * Removes all the tai khoan nguoi dungs where email = &#63; from the database.
	 *
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmail(String email) throws SystemException {
		for (TaiKhoanNguoiDung taiKhoanNguoiDung : findByEmail(email)) {
			remove(taiKhoanNguoiDung);
		}
	}

	/**
	 * Removes all the tai khoan nguoi dungs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (TaiKhoanNguoiDung taiKhoanNguoiDung : findByTrangThai(daXoa)) {
			remove(taiKhoanNguoiDung);
		}
	}

	/**
	 * Removes all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTaiKhoanNguoiDung(Long taiKhoanNguoiDungId, int daXoa)
		throws SystemException {
		for (TaiKhoanNguoiDung taiKhoanNguoiDung : findByTaiKhoanNguoiDung(
				taiKhoanNguoiDungId, daXoa)) {
			remove(taiKhoanNguoiDung);
		}
	}

	/**
	 * Removes all the tai khoan nguoi dungs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TaiKhoanNguoiDung taiKhoanNguoiDung : findAll()) {
			remove(taiKhoanNguoiDung);
		}
	}

	/**
	 * Returns the number of tai khoan nguoi dungs where tenDangNhap = &#63;.
	 *
	 * @param tenDangNhap the ten dang nhap
	 * @return the number of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTenDangNhap(String tenDangNhap) throws SystemException {
		Object[] finderArgs = new Object[] { tenDangNhap };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENDANGNHAP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAIKHOANNGUOIDUNG_WHERE);

			if (tenDangNhap == null) {
				query.append(_FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_1);
			}
			else {
				if (tenDangNhap.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenDangNhap != null) {
					qPos.add(tenDangNhap);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENDANGNHAP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai khoan nguoi dungs where tenNguoiDung = &#63;.
	 *
	 * @param tenNguoiDung the ten nguoi dung
	 * @return the number of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTenNguoiDung(String tenNguoiDung)
		throws SystemException {
		Object[] finderArgs = new Object[] { tenNguoiDung };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENNGUOIDUNG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAIKHOANNGUOIDUNG_WHERE);

			if (tenNguoiDung == null) {
				query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_1);
			}
			else {
				if (tenNguoiDung.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tenNguoiDung != null) {
					qPos.add(tenNguoiDung);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENNGUOIDUNG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai khoan nguoi dungs where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmail(String email) throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAIKHOANNGUOIDUNG_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai khoan nguoi dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAIKHOANNGUOIDUNG_WHERE);

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
	 * Returns the number of tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	 *
	 * @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	 * @param daXoa the da xoa
	 * @return the number of matching tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTaiKhoanNguoiDung(Long taiKhoanNguoiDungId, int daXoa)
		throws SystemException {
		Object[] finderArgs = new Object[] { taiKhoanNguoiDungId, daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAIKHOANNGUOIDUNG_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNG_TAIKHOANNGUOIDUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANNGUOIDUNG_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanNguoiDungId.longValue());

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAIKHOANNGUOIDUNG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai khoan nguoi dungs.
	 *
	 * @return the number of tai khoan nguoi dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAIKHOANNGUOIDUNG);

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
	 * Initializes the tai khoan nguoi dung persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaiKhoanNguoiDung>> listenersList = new ArrayList<ModelListener<TaiKhoanNguoiDung>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaiKhoanNguoiDung>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaiKhoanNguoiDungImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = NguoiDung2VaiTroPersistence.class)
	protected NguoiDung2VaiTroPersistence nguoiDung2VaiTroPersistence;
	@BeanReference(type = NhomNguoiDungPersistence.class)
	protected NhomNguoiDungPersistence nhomNguoiDungPersistence;
	@BeanReference(type = TaiKhoanNguoiDungPersistence.class)
	protected TaiKhoanNguoiDungPersistence taiKhoanNguoiDungPersistence;
	@BeanReference(type = TaiNguyenPersistence.class)
	protected TaiNguyenPersistence taiNguyenPersistence;
	@BeanReference(type = TaiNguyen2VaiTroPersistence.class)
	protected TaiNguyen2VaiTroPersistence taiNguyen2VaiTroPersistence;
	@BeanReference(type = VaiTroPersistence.class)
	protected VaiTroPersistence vaiTroPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TAIKHOANNGUOIDUNG = "SELECT taiKhoanNguoiDung FROM TaiKhoanNguoiDung taiKhoanNguoiDung";
	private static final String _SQL_SELECT_TAIKHOANNGUOIDUNG_WHERE = "SELECT taiKhoanNguoiDung FROM TaiKhoanNguoiDung taiKhoanNguoiDung WHERE ";
	private static final String _SQL_COUNT_TAIKHOANNGUOIDUNG = "SELECT COUNT(taiKhoanNguoiDung) FROM TaiKhoanNguoiDung taiKhoanNguoiDung";
	private static final String _SQL_COUNT_TAIKHOANNGUOIDUNG_WHERE = "SELECT COUNT(taiKhoanNguoiDung) FROM TaiKhoanNguoiDung taiKhoanNguoiDung WHERE ";
	private static final String _FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_1 = "taiKhoanNguoiDung.tenDangNhap IS NULL";
	private static final String _FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_2 = "taiKhoanNguoiDung.tenDangNhap = ?";
	private static final String _FINDER_COLUMN_TENDANGNHAP_TENDANGNHAP_3 = "(taiKhoanNguoiDung.tenDangNhap IS NULL OR taiKhoanNguoiDung.tenDangNhap = ?)";
	private static final String _FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_1 = "taiKhoanNguoiDung.tenNguoiDung IS NULL";
	private static final String _FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_2 = "taiKhoanNguoiDung.tenNguoiDung = ?";
	private static final String _FINDER_COLUMN_TENNGUOIDUNG_TENNGUOIDUNG_3 = "(taiKhoanNguoiDung.tenNguoiDung IS NULL OR taiKhoanNguoiDung.tenNguoiDung = ?)";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "taiKhoanNguoiDung.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "taiKhoanNguoiDung.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(taiKhoanNguoiDung.email IS NULL OR taiKhoanNguoiDung.email = ?)";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "taiKhoanNguoiDung.daXoa = ?";
	private static final String _FINDER_COLUMN_TAIKHOANNGUOIDUNG_TAIKHOANNGUOIDUNGID_2 =
		"taiKhoanNguoiDung.taiKhoanNguoiDungId = ? AND ";
	private static final String _FINDER_COLUMN_TAIKHOANNGUOIDUNG_DAXOA_2 = "taiKhoanNguoiDung.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taiKhoanNguoiDung.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaiKhoanNguoiDung exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaiKhoanNguoiDung exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaiKhoanNguoiDungPersistenceImpl.class);
	private static TaiKhoanNguoiDung _nullTaiKhoanNguoiDung = new TaiKhoanNguoiDungImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaiKhoanNguoiDung> toCacheModel() {
				return _nullTaiKhoanNguoiDungCacheModel;
			}
		};

	private static CacheModel<TaiKhoanNguoiDung> _nullTaiKhoanNguoiDungCacheModel =
		new CacheModel<TaiKhoanNguoiDung>() {
			public TaiKhoanNguoiDung toEntityModel() {
				return _nullTaiKhoanNguoiDung;
			}
		};
}