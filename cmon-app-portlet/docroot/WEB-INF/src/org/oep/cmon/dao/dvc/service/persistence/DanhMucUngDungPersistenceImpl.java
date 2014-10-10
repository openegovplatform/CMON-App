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

import org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungImpl;
import org.oep.cmon.dao.dvc.model.impl.DanhMucUngDungModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh muc ung dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see DanhMucUngDungPersistence
 * @see DanhMucUngDungUtil
 * @generated
 */
public class DanhMucUngDungPersistenceImpl extends BasePersistenceImpl<DanhMucUngDung>
	implements DanhMucUngDungPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhMucUngDungUtil} to access the danh muc ung dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhMucUngDungImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			DanhMucUngDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			DanhMucUngDungModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			DanhMucUngDungModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED,
			DanhMucUngDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh muc ung dung in the entity cache if it is enabled.
	 *
	 * @param danhMucUngDung the danh muc ung dung
	 */
	public void cacheResult(DanhMucUngDung danhMucUngDung) {
		EntityCacheUtil.putResult(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungImpl.class, danhMucUngDung.getPrimaryKey(),
			danhMucUngDung);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { danhMucUngDung.getMa() }, danhMucUngDung);

		danhMucUngDung.resetOriginalValues();
	}

	/**
	 * Caches the danh muc ung dungs in the entity cache if it is enabled.
	 *
	 * @param danhMucUngDungs the danh muc ung dungs
	 */
	public void cacheResult(List<DanhMucUngDung> danhMucUngDungs) {
		for (DanhMucUngDung danhMucUngDung : danhMucUngDungs) {
			if (EntityCacheUtil.getResult(
						DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucUngDungImpl.class, danhMucUngDung.getPrimaryKey()) == null) {
				cacheResult(danhMucUngDung);
			}
			else {
				danhMucUngDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh muc ung dungs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhMucUngDungImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhMucUngDungImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh muc ung dung.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhMucUngDung danhMucUngDung) {
		EntityCacheUtil.removeResult(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungImpl.class, danhMucUngDung.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(danhMucUngDung);
	}

	@Override
	public void clearCache(List<DanhMucUngDung> danhMucUngDungs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhMucUngDung danhMucUngDung : danhMucUngDungs) {
			EntityCacheUtil.removeResult(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucUngDungImpl.class, danhMucUngDung.getPrimaryKey());

			clearUniqueFindersCache(danhMucUngDung);
		}
	}

	protected void clearUniqueFindersCache(DanhMucUngDung danhMucUngDung) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { danhMucUngDung.getMa() });
	}

	/**
	 * Creates a new danh muc ung dung with the primary key. Does not add the danh muc ung dung to the database.
	 *
	 * @param id the primary key for the new danh muc ung dung
	 * @return the new danh muc ung dung
	 */
	public DanhMucUngDung create(long id) {
		DanhMucUngDung danhMucUngDung = new DanhMucUngDungImpl();

		danhMucUngDung.setNew(true);
		danhMucUngDung.setPrimaryKey(id);

		return danhMucUngDung;
	}

	/**
	 * Removes the danh muc ung dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc ung dung
	 * @return the danh muc ung dung that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung remove(long id)
		throws NoSuchDanhMucUngDungException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the danh muc ung dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh muc ung dung
	 * @return the danh muc ung dung that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucUngDung remove(Serializable primaryKey)
		throws NoSuchDanhMucUngDungException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhMucUngDung danhMucUngDung = (DanhMucUngDung)session.get(DanhMucUngDungImpl.class,
					primaryKey);

			if (danhMucUngDung == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhMucUngDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhMucUngDung);
		}
		catch (NoSuchDanhMucUngDungException nsee) {
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
	protected DanhMucUngDung removeImpl(DanhMucUngDung danhMucUngDung)
		throws SystemException {
		danhMucUngDung = toUnwrappedModel(danhMucUngDung);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhMucUngDung);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhMucUngDung);

		return danhMucUngDung;
	}

	@Override
	public DanhMucUngDung updateImpl(
		org.oep.cmon.dao.dvc.model.DanhMucUngDung danhMucUngDung, boolean merge)
		throws SystemException {
		danhMucUngDung = toUnwrappedModel(danhMucUngDung);

		boolean isNew = danhMucUngDung.isNew();

		DanhMucUngDungModelImpl danhMucUngDungModelImpl = (DanhMucUngDungModelImpl)danhMucUngDung;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhMucUngDung, merge);

			danhMucUngDung.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DanhMucUngDungModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((danhMucUngDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(danhMucUngDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(danhMucUngDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((danhMucUngDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						danhMucUngDungModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { danhMucUngDungModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}
		}

		EntityCacheUtil.putResult(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucUngDungImpl.class, danhMucUngDung.getPrimaryKey(),
			danhMucUngDung);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { danhMucUngDung.getMa() }, danhMucUngDung);
		}
		else {
			if ((danhMucUngDungModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						danhMucUngDungModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { danhMucUngDung.getMa() }, danhMucUngDung);
			}
		}

		return danhMucUngDung;
	}

	protected DanhMucUngDung toUnwrappedModel(DanhMucUngDung danhMucUngDung) {
		if (danhMucUngDung instanceof DanhMucUngDungImpl) {
			return danhMucUngDung;
		}

		DanhMucUngDungImpl danhMucUngDungImpl = new DanhMucUngDungImpl();

		danhMucUngDungImpl.setNew(danhMucUngDung.isNew());
		danhMucUngDungImpl.setPrimaryKey(danhMucUngDung.getPrimaryKey());

		danhMucUngDungImpl.setId(danhMucUngDung.getId());
		danhMucUngDungImpl.setMa(danhMucUngDung.getMa());
		danhMucUngDungImpl.setTen(danhMucUngDung.getTen());
		danhMucUngDungImpl.setNgayTao(danhMucUngDung.getNgayTao());
		danhMucUngDungImpl.setNgaySua(danhMucUngDung.getNgaySua());
		danhMucUngDungImpl.setDaXoa(danhMucUngDung.getDaXoa());
		danhMucUngDungImpl.setNguoiSua(danhMucUngDung.getNguoiSua());
		danhMucUngDungImpl.setNguoiTao(danhMucUngDung.getNguoiTao());

		return danhMucUngDungImpl;
	}

	/**
	 * Returns the danh muc ung dung with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc ung dung
	 * @return the danh muc ung dung
	 * @throws com.liferay.portal.NoSuchModelException if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucUngDung findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc ung dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException} if it could not be found.
	 *
	 * @param id the primary key of the danh muc ung dung
	 * @return the danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung findByPrimaryKey(long id)
		throws NoSuchDanhMucUngDungException, SystemException {
		DanhMucUngDung danhMucUngDung = fetchByPrimaryKey(id);

		if (danhMucUngDung == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDanhMucUngDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return danhMucUngDung;
	}

	/**
	 * Returns the danh muc ung dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc ung dung
	 * @return the danh muc ung dung, or <code>null</code> if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucUngDung fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc ung dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc ung dung
	 * @return the danh muc ung dung, or <code>null</code> if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung fetchByPrimaryKey(long id) throws SystemException {
		DanhMucUngDung danhMucUngDung = (DanhMucUngDung)EntityCacheUtil.getResult(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucUngDungImpl.class, id);

		if (danhMucUngDung == _nullDanhMucUngDung) {
			return null;
		}

		if (danhMucUngDung == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhMucUngDung = (DanhMucUngDung)session.get(DanhMucUngDungImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhMucUngDung != null) {
					cacheResult(danhMucUngDung);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhMucUngDungModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucUngDungImpl.class, id, _nullDanhMucUngDung);
				}

				closeSession(session);
			}
		}

		return danhMucUngDung;
	}

	/**
	 * Returns all the danh muc ung dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc ung dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of danh muc ung dungs
	 * @param end the upper bound of the range of danh muc ung dungs (not inclusive)
	 * @return the range of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc ung dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of danh muc ung dungs
	 * @param end the upper bound of the range of danh muc ung dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findByTrangThai(int daXoa, int start, int end,
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

		List<DanhMucUngDung> list = (List<DanhMucUngDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DANHMUCUNGDUNG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DanhMucUngDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<DanhMucUngDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first danh muc ung dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucUngDungException, SystemException {
		List<DanhMucUngDung> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucUngDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last danh muc ung dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucUngDungException, SystemException {
		int count = countByTrangThai(daXoa);

		List<DanhMucUngDung> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucUngDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the danh muc ung dungs before and after the current danh muc ung dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current danh muc ung dung
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucUngDungException, SystemException {
		DanhMucUngDung danhMucUngDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMucUngDung[] array = new DanhMucUngDungImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, danhMucUngDung,
					daXoa, orderByComparator, true);

			array[1] = danhMucUngDung;

			array[2] = getByTrangThai_PrevAndNext(session, danhMucUngDung,
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

	protected DanhMucUngDung getByTrangThai_PrevAndNext(Session session,
		DanhMucUngDung danhMucUngDung, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUCUNGDUNG_WHERE);

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
			query.append(DanhMucUngDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(danhMucUngDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DanhMucUngDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the danh muc ung dung where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung findByMa(String ma)
		throws NoSuchDanhMucUngDungException, SystemException {
		DanhMucUngDung danhMucUngDung = fetchByMa(ma);

		if (danhMucUngDung == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDanhMucUngDungException(msg.toString());
		}

		return danhMucUngDung;
	}

	/**
	 * Returns the danh muc ung dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching danh muc ung dung, or <code>null</code> if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the danh muc ung dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching danh muc ung dung, or <code>null</code> if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DANHMUCUNGDUNG_WHERE);

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

			query.append(DanhMucUngDungModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<DanhMucUngDung> list = q.list();

				result = list;

				DanhMucUngDung danhMucUngDung = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					danhMucUngDung = list.get(0);

					cacheResult(danhMucUngDung);

					if ((danhMucUngDung.getMa() == null) ||
							!danhMucUngDung.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, danhMucUngDung);
					}
				}

				return danhMucUngDung;
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
				return (DanhMucUngDung)result;
			}
		}
	}

	/**
	 * Returns all the danh muc ung dungs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findByTen(String ten) throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc ung dungs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of danh muc ung dungs
	 * @param end the upper bound of the range of danh muc ung dungs (not inclusive)
	 * @return the range of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc ung dungs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of danh muc ung dungs
	 * @param end the upper bound of the range of danh muc ung dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findByTen(String ten, int start, int end,
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

		List<DanhMucUngDung> list = (List<DanhMucUngDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DANHMUCUNGDUNG_WHERE);

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
				query.append(DanhMucUngDungModelImpl.ORDER_BY_JPQL);
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

				list = (List<DanhMucUngDung>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first danh muc ung dung in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucUngDungException, SystemException {
		List<DanhMucUngDung> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucUngDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last danh muc ung dung in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a matching danh muc ung dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucUngDungException, SystemException {
		int count = countByTen(ten);

		List<DanhMucUngDung> list = findByTen(ten, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanhMucUngDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the danh muc ung dungs before and after the current danh muc ung dung in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current danh muc ung dung
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc ung dung
	 * @throws org.oep.cmon.dao.dvc.NoSuchDanhMucUngDungException if a danh muc ung dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucUngDung[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchDanhMucUngDungException, SystemException {
		DanhMucUngDung danhMucUngDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMucUngDung[] array = new DanhMucUngDungImpl[3];

			array[0] = getByTen_PrevAndNext(session, danhMucUngDung, ten,
					orderByComparator, true);

			array[1] = danhMucUngDung;

			array[2] = getByTen_PrevAndNext(session, danhMucUngDung, ten,
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

	protected DanhMucUngDung getByTen_PrevAndNext(Session session,
		DanhMucUngDung danhMucUngDung, String ten,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUCUNGDUNG_WHERE);

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
			query.append(DanhMucUngDungModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(danhMucUngDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DanhMucUngDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the danh muc ung dungs.
	 *
	 * @return the danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc ung dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc ung dungs
	 * @param end the upper bound of the range of danh muc ung dungs (not inclusive)
	 * @return the range of danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc ung dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc ung dungs
	 * @param end the upper bound of the range of danh muc ung dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucUngDung> findAll(int start, int end,
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

		List<DanhMucUngDung> list = (List<DanhMucUngDung>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHMUCUNGDUNG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHMUCUNGDUNG.concat(DanhMucUngDungModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhMucUngDung>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhMucUngDung>)QueryUtil.list(q,
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
	 * Removes all the danh muc ung dungs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (DanhMucUngDung danhMucUngDung : findByTrangThai(daXoa)) {
			remove(danhMucUngDung);
		}
	}

	/**
	 * Removes the danh muc ung dung where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchDanhMucUngDungException, SystemException {
		DanhMucUngDung danhMucUngDung = findByMa(ma);

		remove(danhMucUngDung);
	}

	/**
	 * Removes all the danh muc ung dungs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (DanhMucUngDung danhMucUngDung : findByTen(ten)) {
			remove(danhMucUngDung);
		}
	}

	/**
	 * Removes all the danh muc ung dungs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhMucUngDung danhMucUngDung : findAll()) {
			remove(danhMucUngDung);
		}
	}

	/**
	 * Returns the number of danh muc ung dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUCUNGDUNG_WHERE);

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
	 * Returns the number of danh muc ung dungs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUCUNGDUNG_WHERE);

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
	 * Returns the number of danh muc ung dungs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUCUNGDUNG_WHERE);

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
	 * Returns the number of danh muc ung dungs.
	 *
	 * @return the number of danh muc ung dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHMUCUNGDUNG);

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
	 * Initializes the danh muc ung dung persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.DanhMucUngDung")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhMucUngDung>> listenersList = new ArrayList<ModelListener<DanhMucUngDung>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhMucUngDung>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhMucUngDungImpl.class.getName());
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
	private static final String _SQL_SELECT_DANHMUCUNGDUNG = "SELECT danhMucUngDung FROM DanhMucUngDung danhMucUngDung";
	private static final String _SQL_SELECT_DANHMUCUNGDUNG_WHERE = "SELECT danhMucUngDung FROM DanhMucUngDung danhMucUngDung WHERE ";
	private static final String _SQL_COUNT_DANHMUCUNGDUNG = "SELECT COUNT(danhMucUngDung) FROM DanhMucUngDung danhMucUngDung";
	private static final String _SQL_COUNT_DANHMUCUNGDUNG_WHERE = "SELECT COUNT(danhMucUngDung) FROM DanhMucUngDung danhMucUngDung WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "danhMucUngDung.daXoa = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "danhMucUngDung.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "danhMucUngDung.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(danhMucUngDung.ma IS NULL OR danhMucUngDung.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "danhMucUngDung.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "danhMucUngDung.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(danhMucUngDung.ten IS NULL OR danhMucUngDung.ten = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhMucUngDung.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhMucUngDung exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DanhMucUngDung exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhMucUngDungPersistenceImpl.class);
	private static DanhMucUngDung _nullDanhMucUngDung = new DanhMucUngDungImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhMucUngDung> toCacheModel() {
				return _nullDanhMucUngDungCacheModel;
			}
		};

	private static CacheModel<DanhMucUngDung> _nullDanhMucUngDungCacheModel = new CacheModel<DanhMucUngDung>() {
			public DanhMucUngDung toEntityModel() {
				return _nullDanhMucUngDung;
			}
		};
}