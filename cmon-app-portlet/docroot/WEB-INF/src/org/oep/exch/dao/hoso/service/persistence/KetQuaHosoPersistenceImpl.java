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

import org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;
import org.oep.exch.dao.hoso.model.KetQuaHoso;
import org.oep.exch.dao.hoso.model.impl.KetQuaHosoImpl;
import org.oep.exch.dao.hoso.model.impl.KetQuaHosoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ket qua hoso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see KetQuaHosoPersistence
 * @see KetQuaHosoUtil
 * @generated
 */
public class KetQuaHosoPersistenceImpl extends BasePersistenceImpl<KetQuaHoso>
	implements KetQuaHosoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KetQuaHosoUtil} to access the ket qua hoso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KetQuaHosoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAIXULY =
		new FinderPath(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoModelImpl.FINDER_CACHE_ENABLED, KetQuaHosoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThaiXuLy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY =
		new FinderPath(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoModelImpl.FINDER_CACHE_ENABLED, KetQuaHosoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThaiXuLy",
			new String[] { Integer.class.getName() },
			KetQuaHosoModelImpl.TRANGTHAIXULY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAIXULY = new FinderPath(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThaiXuLy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoModelImpl.FINDER_CACHE_ENABLED, KetQuaHosoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoModelImpl.FINDER_CACHE_ENABLED, KetQuaHosoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ket qua hoso in the entity cache if it is enabled.
	 *
	 * @param ketQuaHoso the ket qua hoso
	 */
	public void cacheResult(KetQuaHoso ketQuaHoso) {
		EntityCacheUtil.putResult(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoImpl.class, ketQuaHoso.getPrimaryKey(), ketQuaHoso);

		ketQuaHoso.resetOriginalValues();
	}

	/**
	 * Caches the ket qua hosos in the entity cache if it is enabled.
	 *
	 * @param ketQuaHosos the ket qua hosos
	 */
	public void cacheResult(List<KetQuaHoso> ketQuaHosos) {
		for (KetQuaHoso ketQuaHoso : ketQuaHosos) {
			if (EntityCacheUtil.getResult(
						KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
						KetQuaHosoImpl.class, ketQuaHoso.getPrimaryKey()) == null) {
				cacheResult(ketQuaHoso);
			}
			else {
				ketQuaHoso.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ket qua hosos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KetQuaHosoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KetQuaHosoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ket qua hoso.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KetQuaHoso ketQuaHoso) {
		EntityCacheUtil.removeResult(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoImpl.class, ketQuaHoso.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<KetQuaHoso> ketQuaHosos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KetQuaHoso ketQuaHoso : ketQuaHosos) {
			EntityCacheUtil.removeResult(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
				KetQuaHosoImpl.class, ketQuaHoso.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ket qua hoso with the primary key. Does not add the ket qua hoso to the database.
	 *
	 * @param id the primary key for the new ket qua hoso
	 * @return the new ket qua hoso
	 */
	public KetQuaHoso create(long id) {
		KetQuaHoso ketQuaHoso = new KetQuaHosoImpl();

		ketQuaHoso.setNew(true);
		ketQuaHoso.setPrimaryKey(id);

		return ketQuaHoso;
	}

	/**
	 * Removes the ket qua hoso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ket qua hoso
	 * @return the ket qua hoso that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KetQuaHoso remove(long id)
		throws NoSuchKetQuaHosoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ket qua hoso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ket qua hoso
	 * @return the ket qua hoso that was removed
	 * @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KetQuaHoso remove(Serializable primaryKey)
		throws NoSuchKetQuaHosoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KetQuaHoso ketQuaHoso = (KetQuaHoso)session.get(KetQuaHosoImpl.class,
					primaryKey);

			if (ketQuaHoso == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKetQuaHosoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ketQuaHoso);
		}
		catch (NoSuchKetQuaHosoException nsee) {
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
	protected KetQuaHoso removeImpl(KetQuaHoso ketQuaHoso)
		throws SystemException {
		ketQuaHoso = toUnwrappedModel(ketQuaHoso);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ketQuaHoso);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ketQuaHoso);

		return ketQuaHoso;
	}

	@Override
	public KetQuaHoso updateImpl(
		org.oep.exch.dao.hoso.model.KetQuaHoso ketQuaHoso, boolean merge)
		throws SystemException {
		ketQuaHoso = toUnwrappedModel(ketQuaHoso);

		boolean isNew = ketQuaHoso.isNew();

		KetQuaHosoModelImpl ketQuaHosoModelImpl = (KetQuaHosoModelImpl)ketQuaHoso;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ketQuaHoso, merge);

			ketQuaHoso.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KetQuaHosoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ketQuaHosoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(ketQuaHosoModelImpl.getOriginalTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY,
					args);

				args = new Object[] {
						Integer.valueOf(ketQuaHosoModelImpl.getTrangThaiXuLy())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAIXULY,
					args);
			}
		}

		EntityCacheUtil.putResult(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
			KetQuaHosoImpl.class, ketQuaHoso.getPrimaryKey(), ketQuaHoso);

		return ketQuaHoso;
	}

	protected KetQuaHoso toUnwrappedModel(KetQuaHoso ketQuaHoso) {
		if (ketQuaHoso instanceof KetQuaHosoImpl) {
			return ketQuaHoso;
		}

		KetQuaHosoImpl ketQuaHosoImpl = new KetQuaHosoImpl();

		ketQuaHosoImpl.setNew(ketQuaHoso.isNew());
		ketQuaHosoImpl.setPrimaryKey(ketQuaHoso.getPrimaryKey());

		ketQuaHosoImpl.setId(ketQuaHoso.getId());
		ketQuaHosoImpl.setNgayChuyen(ketQuaHoso.getNgayChuyen());
		ketQuaHosoImpl.setMaSoHoSo(ketQuaHoso.getMaSoHoSo());
		ketQuaHosoImpl.setTenNguoiNhanKetQua(ketQuaHoso.getTenNguoiNhanKetQua());
		ketQuaHosoImpl.setNgayNhanKetQua(ketQuaHoso.getNgayNhanKetQua());
		ketQuaHosoImpl.setLePhiHoSo(ketQuaHoso.getLePhiHoSo());
		ketQuaHosoImpl.setPhiXuLyHoSo(ketQuaHoso.getPhiXuLyHoSo());
		ketQuaHosoImpl.setNgayHoanThanh(ketQuaHoso.getNgayHoanThanh());
		ketQuaHosoImpl.setMaCanBoTraKetQua(ketQuaHoso.getMaCanBoTraKetQua());
		ketQuaHosoImpl.setTenCanBoTraKetQua(ketQuaHoso.getTenCanBoTraKetQua());
		ketQuaHosoImpl.setDonViCungCap(ketQuaHoso.getDonViCungCap());
		ketQuaHosoImpl.setTrangThaiXuLy(ketQuaHoso.getTrangThaiXuLy());
		ketQuaHosoImpl.setNgayXuLy(ketQuaHoso.getNgayXuLy());
		ketQuaHosoImpl.setLoiKhiXuLy(ketQuaHoso.getLoiKhiXuLy());

		return ketQuaHosoImpl;
	}

	/**
	 * Returns the ket qua hoso with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ket qua hoso
	 * @return the ket qua hoso
	 * @throws com.liferay.portal.NoSuchModelException if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KetQuaHoso findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ket qua hoso with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchKetQuaHosoException} if it could not be found.
	 *
	 * @param id the primary key of the ket qua hoso
	 * @return the ket qua hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KetQuaHoso findByPrimaryKey(long id)
		throws NoSuchKetQuaHosoException, SystemException {
		KetQuaHoso ketQuaHoso = fetchByPrimaryKey(id);

		if (ketQuaHoso == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchKetQuaHosoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return ketQuaHoso;
	}

	/**
	 * Returns the ket qua hoso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ket qua hoso
	 * @return the ket qua hoso, or <code>null</code> if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KetQuaHoso fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ket qua hoso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ket qua hoso
	 * @return the ket qua hoso, or <code>null</code> if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KetQuaHoso fetchByPrimaryKey(long id) throws SystemException {
		KetQuaHoso ketQuaHoso = (KetQuaHoso)EntityCacheUtil.getResult(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
				KetQuaHosoImpl.class, id);

		if (ketQuaHoso == _nullKetQuaHoso) {
			return null;
		}

		if (ketQuaHoso == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ketQuaHoso = (KetQuaHoso)session.get(KetQuaHosoImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ketQuaHoso != null) {
					cacheResult(ketQuaHoso);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(KetQuaHosoModelImpl.ENTITY_CACHE_ENABLED,
						KetQuaHosoImpl.class, id, _nullKetQuaHoso);
				}

				closeSession(session);
			}
		}

		return ketQuaHoso;
	}

	/**
	 * Returns all the ket qua hosos where TrangThaiXuLy = &#63;.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the matching ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<KetQuaHoso> findByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		return findByTrangThaiXuLy(TrangThaiXuLy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ket qua hosos where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of ket qua hosos
	 * @param end the upper bound of the range of ket qua hosos (not inclusive)
	 * @return the range of matching ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<KetQuaHoso> findByTrangThaiXuLy(int TrangThaiXuLy, int start,
		int end) throws SystemException {
		return findByTrangThaiXuLy(TrangThaiXuLy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ket qua hosos where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param start the lower bound of the range of ket qua hosos
	 * @param end the upper bound of the range of ket qua hosos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<KetQuaHoso> findByTrangThaiXuLy(int TrangThaiXuLy, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<KetQuaHoso> list = (List<KetQuaHoso>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_KETQUAHOSO_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(KetQuaHosoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TrangThaiXuLy);

				list = (List<KetQuaHoso>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ket qua hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a matching ket qua hoso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KetQuaHoso findByTrangThaiXuLy_First(int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchKetQuaHosoException, SystemException {
		List<KetQuaHoso> list = findByTrangThaiXuLy(TrangThaiXuLy, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchKetQuaHosoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ket qua hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a matching ket qua hoso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KetQuaHoso findByTrangThaiXuLy_Last(int TrangThaiXuLy,
		OrderByComparator orderByComparator)
		throws NoSuchKetQuaHosoException, SystemException {
		int count = countByTrangThaiXuLy(TrangThaiXuLy);

		List<KetQuaHoso> list = findByTrangThaiXuLy(TrangThaiXuLy, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TrangThaiXuLy=");
			msg.append(TrangThaiXuLy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchKetQuaHosoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the ket qua hosos before and after the current ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current ket qua hoso
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ket qua hoso
	 * @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KetQuaHoso[] findByTrangThaiXuLy_PrevAndNext(long id,
		int TrangThaiXuLy, OrderByComparator orderByComparator)
		throws NoSuchKetQuaHosoException, SystemException {
		KetQuaHoso ketQuaHoso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			KetQuaHoso[] array = new KetQuaHosoImpl[3];

			array[0] = getByTrangThaiXuLy_PrevAndNext(session, ketQuaHoso,
					TrangThaiXuLy, orderByComparator, true);

			array[1] = ketQuaHoso;

			array[2] = getByTrangThaiXuLy_PrevAndNext(session, ketQuaHoso,
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

	protected KetQuaHoso getByTrangThaiXuLy_PrevAndNext(Session session,
		KetQuaHoso ketQuaHoso, int TrangThaiXuLy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KETQUAHOSO_WHERE);

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
			query.append(KetQuaHosoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(TrangThaiXuLy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ketQuaHoso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KetQuaHoso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ket qua hosos.
	 *
	 * @return the ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<KetQuaHoso> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ket qua hosos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ket qua hosos
	 * @param end the upper bound of the range of ket qua hosos (not inclusive)
	 * @return the range of ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<KetQuaHoso> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ket qua hosos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ket qua hosos
	 * @param end the upper bound of the range of ket qua hosos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public List<KetQuaHoso> findAll(int start, int end,
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

		List<KetQuaHoso> list = (List<KetQuaHoso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KETQUAHOSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KETQUAHOSO.concat(KetQuaHosoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<KetQuaHoso>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<KetQuaHoso>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ket qua hosos where TrangThaiXuLy = &#63; from the database.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		for (KetQuaHoso ketQuaHoso : findByTrangThaiXuLy(TrangThaiXuLy)) {
			remove(ketQuaHoso);
		}
	}

	/**
	 * Removes all the ket qua hosos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (KetQuaHoso ketQuaHoso : findAll()) {
			remove(ketQuaHoso);
		}
	}

	/**
	 * Returns the number of ket qua hosos where TrangThaiXuLy = &#63;.
	 *
	 * @param TrangThaiXuLy the trang thai xu ly
	 * @return the number of matching ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws SystemException {
		Object[] finderArgs = new Object[] { TrangThaiXuLy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAIXULY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KETQUAHOSO_WHERE);

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
	 * Returns the number of ket qua hosos.
	 *
	 * @return the number of ket qua hosos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KETQUAHOSO);

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
	 * Initializes the ket qua hoso persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.exch.dao.hoso.model.KetQuaHoso")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KetQuaHoso>> listenersList = new ArrayList<ModelListener<KetQuaHoso>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KetQuaHoso>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KetQuaHosoImpl.class.getName());
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
	private static final String _SQL_SELECT_KETQUAHOSO = "SELECT ketQuaHoso FROM KetQuaHoso ketQuaHoso";
	private static final String _SQL_SELECT_KETQUAHOSO_WHERE = "SELECT ketQuaHoso FROM KetQuaHoso ketQuaHoso WHERE ";
	private static final String _SQL_COUNT_KETQUAHOSO = "SELECT COUNT(ketQuaHoso) FROM KetQuaHoso ketQuaHoso";
	private static final String _SQL_COUNT_KETQUAHOSO_WHERE = "SELECT COUNT(ketQuaHoso) FROM KetQuaHoso ketQuaHoso WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAIXULY_TRANGTHAIXULY_2 = "ketQuaHoso.TrangThaiXuLy = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ketQuaHoso.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KetQuaHoso exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KetQuaHoso exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KetQuaHosoPersistenceImpl.class);
	private static KetQuaHoso _nullKetQuaHoso = new KetQuaHosoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KetQuaHoso> toCacheModel() {
				return _nullKetQuaHosoCacheModel;
			}
		};

	private static CacheModel<KetQuaHoso> _nullKetQuaHosoCacheModel = new CacheModel<KetQuaHoso>() {
			public KetQuaHoso toEntityModel() {
				return _nullKetQuaHoso;
			}
		};
}