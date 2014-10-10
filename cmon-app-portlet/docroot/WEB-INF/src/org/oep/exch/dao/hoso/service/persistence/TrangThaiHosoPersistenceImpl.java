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

import org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;
import org.oep.exch.dao.hoso.model.TrangThaiHoso;
import org.oep.exch.dao.hoso.model.impl.TrangThaiHosoImpl;
import org.oep.exch.dao.hoso.model.impl.TrangThaiHosoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the trang thai hoso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see TrangThaiHosoPersistence
 * @see TrangThaiHosoUtil
 * @generated
 */
public class TrangThaiHosoPersistenceImpl extends BasePersistenceImpl<TrangThaiHoso>
	implements TrangThaiHosoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrangThaiHosoUtil} to access the trang thai hoso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrangThaiHosoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIXULY =
		new FinderPath(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHosoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThaiXuLy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY =
		new FinderPath(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHosoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTrangThaiXuLy", new String[] { Integer.class.getName() },
			TrangThaiHosoModelImpl.TRANGTHAIXULY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAIXULY = new FinderPath(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThaiXuLy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHosoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiHosoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the trang thai hoso in the entity cache if it is enabled.
	 *
	 * @param trangThaiHoso the trang thai hoso
	 */
	public void cacheResult(TrangThaiHoso trangThaiHoso) {
		EntityCacheUtil.putResult(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoImpl.class, trangThaiHoso.getPrimaryKey(),
			trangThaiHoso);

		trangThaiHoso.resetOriginalValues();
	}

	/**
	 * Caches the trang thai hosos in the entity cache if it is enabled.
	 *
	 * @param trangThaiHosos the trang thai hosos
	 */
	public void cacheResult(List<TrangThaiHoso> trangThaiHosos) {
		for (TrangThaiHoso trangThaiHoso : trangThaiHosos) {
			if (EntityCacheUtil.getResult(
						TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiHosoImpl.class, trangThaiHoso.getPrimaryKey()) == null) {
				cacheResult(trangThaiHoso);
			}
			else {
				trangThaiHoso.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trang thai hosos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrangThaiHosoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrangThaiHosoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trang thai hoso.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrangThaiHoso trangThaiHoso) {
		EntityCacheUtil.removeResult(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoImpl.class, trangThaiHoso.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TrangThaiHoso> trangThaiHosos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrangThaiHoso trangThaiHoso : trangThaiHosos) {
			EntityCacheUtil.removeResult(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiHosoImpl.class, trangThaiHoso.getPrimaryKey());
		}
	}

	/**
	 * Creates a new trang thai hoso with the primary key. Does not add the trang thai hoso to the database.
	 *
	 * @param id the primary key for the new trang thai hoso
	 * @return the new trang thai hoso
	 */
	public TrangThaiHoso create(long id) {
		TrangThaiHoso trangThaiHoso = new TrangThaiHosoImpl();

		trangThaiHoso.setNew(true);
		trangThaiHoso.setPrimaryKey(id);

		return trangThaiHoso;
	}

	/**
	 * Removes the trang thai hoso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trang thai hoso
	 * @return the trang thai hoso that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoso remove(long id)
		throws NoSuchTrangThaiHosoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the trang thai hoso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trang thai hoso
	 * @return the trang thai hoso that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiHoso remove(Serializable primaryKey)
		throws NoSuchTrangThaiHosoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrangThaiHoso trangThaiHoso = (TrangThaiHoso)session.get(TrangThaiHosoImpl.class,
					primaryKey);

			if (trangThaiHoso == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrangThaiHosoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trangThaiHoso);
		}
		catch (NoSuchTrangThaiHosoException nsee) {
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
	protected TrangThaiHoso removeImpl(TrangThaiHoso trangThaiHoso)
		throws SystemException {
		trangThaiHoso = toUnwrappedModel(trangThaiHoso);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, trangThaiHoso);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(trangThaiHoso);

		return trangThaiHoso;
	}

	@Override
	public TrangThaiHoso updateImpl(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso, boolean merge)
		throws SystemException {
		trangThaiHoso = toUnwrappedModel(trangThaiHoso);

		boolean isNew = trangThaiHoso.isNew();

		TrangThaiHosoModelImpl trangThaiHosoModelImpl = (TrangThaiHosoModelImpl)trangThaiHoso;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, trangThaiHoso, merge);

			trangThaiHoso.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrangThaiHosoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trangThaiHosoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(trangThaiHosoModelImpl.getOriginalTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY,
					args);

				args = new Object[] {
						Integer.valueOf(trangThaiHosoModelImpl.getTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY,
					args);
			}
		}

		EntityCacheUtil.putResult(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiHosoImpl.class, trangThaiHoso.getPrimaryKey(),
			trangThaiHoso);

		return trangThaiHoso;
	}

	protected TrangThaiHoso toUnwrappedModel(TrangThaiHoso trangThaiHoso) {
		if (trangThaiHoso instanceof TrangThaiHosoImpl) {
			return trangThaiHoso;
		}

		TrangThaiHosoImpl trangThaiHosoImpl = new TrangThaiHosoImpl();

		trangThaiHosoImpl.setNew(trangThaiHoso.isNew());
		trangThaiHosoImpl.setPrimaryKey(trangThaiHoso.getPrimaryKey());

		trangThaiHosoImpl.setId(trangThaiHoso.getId());
		trangThaiHosoImpl.setNgayChuyen(trangThaiHoso.getNgayChuyen());
		trangThaiHosoImpl.setOnlineId(trangThaiHoso.getOnlineId());
		trangThaiHosoImpl.setMaSoHoSo(trangThaiHoso.getMaSoHoSo());
		trangThaiHosoImpl.setNgayHenTra(trangThaiHoso.getNgayHenTra());
		trangThaiHosoImpl.setMaNguoiXuLyHienTai(trangThaiHoso.getMaNguoiXuLyHienTai());
		trangThaiHosoImpl.setTenNguoiXuLyHienTai(trangThaiHoso.getTenNguoiXuLyHienTai());
		trangThaiHosoImpl.setTenPhongBanXuLyHienTai(trangThaiHoso.getTenPhongBanXuLyHienTai());
		trangThaiHosoImpl.setNgayGioLuanChuyen(trangThaiHoso.getNgayGioLuanChuyen());
		trangThaiHosoImpl.setSoGioYeuCauXuLy(trangThaiHoso.getSoGioYeuCauXuLy());
		trangThaiHosoImpl.setNoiDungYeuCauXuLy(trangThaiHoso.getNoiDungYeuCauXuLy());
		trangThaiHosoImpl.setSoGioThucHien(trangThaiHoso.getSoGioThucHien());
		trangThaiHosoImpl.setTrangThaiHienTai(trangThaiHoso.getTrangThaiHienTai());
		trangThaiHosoImpl.setMaNguoiXuLyKeTiep(trangThaiHoso.getMaNguoiXuLyKeTiep());
		trangThaiHosoImpl.setTenNguoiXuLyKeTiep(trangThaiHoso.getTenNguoiXuLyKeTiep());
		trangThaiHosoImpl.setTenPhongBanXuLyKeTiep(trangThaiHoso.getTenPhongBanXuLyKeTiep());
		trangThaiHosoImpl.setTrangThaiKeTiep(trangThaiHoso.getTrangThaiKeTiep());
		trangThaiHosoImpl.setDonViCungCap(trangThaiHoso.getDonViCungCap());
		trangThaiHosoImpl.setTrangThaiXuLy(trangThaiHoso.getTrangThaiXuLy());
		trangThaiHosoImpl.setNgayXuLy(trangThaiHoso.getNgayXuLy());
		trangThaiHosoImpl.setLoiKhiXuLy(trangThaiHoso.getLoiKhiXuLy());

		return trangThaiHosoImpl;
	}

	/**
	 * Returns the trang thai hoso with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai hoso
	 * @return the trang thai hoso
	 * @throws com.liferay.portal.NoSuchModelException if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiHoso findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai hoso with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException} if it could not be found.
	 *
	 * @param id the primary key of the trang thai hoso
	 * @return the trang thai hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoso findByPrimaryKey(long id)
		throws NoSuchTrangThaiHosoException, SystemException {
		TrangThaiHoso trangThaiHoso = fetchByPrimaryKey(id);

		if (trangThaiHoso == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTrangThaiHosoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return trangThaiHoso;
	}

	/**
	 * Returns the trang thai hoso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai hoso
	 * @return the trang thai hoso, or <code>null</code> if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiHoso fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the trang thai hoso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trang thai hoso
	 * @return the trang thai hoso, or <code>null</code> if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoso fetchByPrimaryKey(long id) throws SystemException {
		TrangThaiHoso trangThaiHoso = (TrangThaiHoso)EntityCacheUtil.getResult(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiHosoImpl.class, id);

		if (trangThaiHoso == _nullTrangThaiHoso) {
			return null;
		}

		if (trangThaiHoso == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				trangThaiHoso = (TrangThaiHoso)session.get(TrangThaiHosoImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (trangThaiHoso != null) {
					cacheResult(trangThaiHoso);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TrangThaiHosoModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiHosoImpl.class, id, _nullTrangThaiHoso);
				}

				closeSession(session);
			}
		}

		return trangThaiHoso;
	}

	/**
	 * Returns all the trang thai hosos where TrangThaiXuLy = &#63;.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the matching trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoso> findByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		return findByTrangThaiXuLy(TrangThaiXuLy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai hosos where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of trang thai hosos
	 * @param end the upper bound of the range of trang thai hosos (not inclusive)
	 * @return the range of matching trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoso> findByTrangThaiXuLy(int TrangThaiXuLy,
		int start, int end) throws SystemException {
		return findByTrangThaiXuLy(TrangThaiXuLy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai hosos where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of trang thai hosos
	 * @param end the upper bound of the range of trang thai hosos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoso> findByTrangThaiXuLy(int TrangThaiXuLy,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY;
			finderArgs = new Object[] { TrangThaiXuLy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIXULY;
			finderArgs = new Object[] {
					TrangThaiXuLy,
					
					start, end, orderByComparator
				};
		}

		List<TrangThaiHoso> list = (List<TrangThaiHoso>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TRANGTHAIHOSO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TrangThaiHosoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TrangThaiXuLy);

				list = (List<TrangThaiHoso>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a matching trang thai hoso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoso findByTrangThaiXuLy_First(int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiHosoException, SystemException {
		List<TrangThaiHoso> list = findByTrangThaiXuLy(TrangThaiXuLy, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiHosoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a matching trang thai hoso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoso findByTrangThaiXuLy_Last(int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiHosoException, SystemException {
		int count = countByTrangThaiXuLy(TrangThaiXuLy);

		List<TrangThaiHoso> list = findByTrangThaiXuLy(TrangThaiXuLy,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTrangThaiHosoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the trang thai hosos before and after the current trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current trang thai hoso
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trang thai hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TrangThaiHoso[] findByTrangThaiXuLy_PrevAndNext(long id,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchTrangThaiHosoException, SystemException {
		TrangThaiHoso trangThaiHoso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrangThaiHoso[] array = new TrangThaiHosoImpl[3];

			array[0] = getByTrangThaiXuLy_PrevAndNext(session, trangThaiHoso,
					TrangThaiXuLy, orderByComparator, true);

			array[1] = trangThaiHoso;

			array[2] = getByTrangThaiXuLy_PrevAndNext(session, trangThaiHoso,
					TrangThaiXuLy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrangThaiHoso getByTrangThaiXuLy_PrevAndNext(Session session,
		TrangThaiHoso trangThaiHoso, int TrangThaiXuLy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANGTHAIHOSO_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

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
			query.append(TrangThaiHosoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(TrangThaiXuLy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiHoso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiHoso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the trang thai hosos.
	 *
	 * @return the trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoso> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai hosos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai hosos
	 * @param end the upper bound of the range of trang thai hosos (not inclusive)
	 * @return the range of trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoso> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai hosos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai hosos
	 * @param end the upper bound of the range of trang thai hosos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TrangThaiHoso> findAll(int start, int end,
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

		List<TrangThaiHoso> list = (List<TrangThaiHoso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANGTHAIHOSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANGTHAIHOSO.concat(TrangThaiHosoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TrangThaiHoso>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TrangThaiHoso>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the trang thai hosos where TrangThaiXuLy = &#63; from the database.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		for (TrangThaiHoso trangThaiHoso : findByTrangThaiXuLy(TrangThaiXuLy)) {
			remove(trangThaiHoso);
		}
	}

	/**
	 * Removes all the trang thai hosos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TrangThaiHoso trangThaiHoso : findAll()) {
			remove(trangThaiHoso);
		}
	}

	/**
	 * Returns the number of trang thai hosos where TrangThaiXuLy = &#63;.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the number of matching trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		Object[] finderArgs = new Object[] { TrangThaiXuLy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIHOSO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of trang thai hosos.
	 *
	 * @return the number of trang thai hosos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRANGTHAIHOSO);

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
	 * Initializes the trang thai hoso persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.exch.dao.hoso.model.TrangThaiHoso")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrangThaiHoso>> listenersList = new ArrayList<ModelListener<TrangThaiHoso>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrangThaiHoso>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrangThaiHosoImpl.class.getName());
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
	private static final String _SQL_SELECT_TRANGTHAIHOSO = "SELECT trangThaiHoso FROM TrangThaiHoso trangThaiHoso";
	private static final String _SQL_SELECT_TRANGTHAIHOSO_WHERE = "SELECT trangThaiHoso FROM TrangThaiHoso trangThaiHoso WHERE ";
	private static final String _SQL_COUNT_TRANGTHAIHOSO = "SELECT COUNT(trangThaiHoso) FROM TrangThaiHoso trangThaiHoso";
	private static final String _SQL_COUNT_TRANGTHAIHOSO_WHERE = "SELECT COUNT(trangThaiHoso) FROM TrangThaiHoso trangThaiHoso WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2 = "trangThaiHoso.TrangThaiXuLy = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trangThaiHoso.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrangThaiHoso exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrangThaiHoso exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrangThaiHosoPersistenceImpl.class);
	private static TrangThaiHoso _nullTrangThaiHoso = new TrangThaiHosoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrangThaiHoso> toCacheModel() {
				return _nullTrangThaiHosoCacheModel;
			}
		};

	private static CacheModel<TrangThaiHoso> _nullTrangThaiHosoCacheModel = new CacheModel<TrangThaiHoso>() {
			public TrangThaiHoso toEntityModel() {
				return _nullTrangThaiHoso;
			}
		};
}