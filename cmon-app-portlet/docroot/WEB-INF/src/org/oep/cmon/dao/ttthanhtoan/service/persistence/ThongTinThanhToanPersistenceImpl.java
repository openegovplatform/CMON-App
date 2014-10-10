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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

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

import org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException;
import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanImpl;
import org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the thong tin thanh toan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thanhdd
 * @see ThongTinThanhToanPersistence
 * @see ThongTinThanhToanUtil
 * @generated
 */
public class ThongTinThanhToanPersistenceImpl extends BasePersistenceImpl<ThongTinThanhToan>
	implements ThongTinThanhToanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThongTinThanhToanUtil} to access the thong tin thanh toan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThongTinThanhToanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSOTTHCCONGID =
		new FinderPath(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanModelImpl.FINDER_CACHE_ENABLED,
			ThongTinThanhToanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHoSoTTHCCongId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGID =
		new FinderPath(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanModelImpl.FINDER_CACHE_ENABLED,
			ThongTinThanhToanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHoSoTTHCCongId",
			new String[] { Long.class.getName() },
			ThongTinThanhToanModelImpl.HOSOTTHCCONGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOSOTTHCCONGID = new FinderPath(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoSoTTHCCongId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanModelImpl.FINDER_CACHE_ENABLED,
			ThongTinThanhToanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanModelImpl.FINDER_CACHE_ENABLED,
			ThongTinThanhToanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the thong tin thanh toan in the entity cache if it is enabled.
	 *
	 * @param thongTinThanhToan the thong tin thanh toan
	 */
	public void cacheResult(ThongTinThanhToan thongTinThanhToan) {
		EntityCacheUtil.putResult(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanImpl.class, thongTinThanhToan.getPrimaryKey(),
			thongTinThanhToan);

		thongTinThanhToan.resetOriginalValues();
	}

	/**
	 * Caches the thong tin thanh toans in the entity cache if it is enabled.
	 *
	 * @param thongTinThanhToans the thong tin thanh toans
	 */
	public void cacheResult(List<ThongTinThanhToan> thongTinThanhToans) {
		for (ThongTinThanhToan thongTinThanhToan : thongTinThanhToans) {
			if (EntityCacheUtil.getResult(
						ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
						ThongTinThanhToanImpl.class,
						thongTinThanhToan.getPrimaryKey()) == null) {
				cacheResult(thongTinThanhToan);
			}
			else {
				thongTinThanhToan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thong tin thanh toans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThongTinThanhToanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThongTinThanhToanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thong tin thanh toan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThongTinThanhToan thongTinThanhToan) {
		EntityCacheUtil.removeResult(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanImpl.class, thongTinThanhToan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ThongTinThanhToan> thongTinThanhToans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThongTinThanhToan thongTinThanhToan : thongTinThanhToans) {
			EntityCacheUtil.removeResult(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinThanhToanImpl.class, thongTinThanhToan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new thong tin thanh toan with the primary key. Does not add the thong tin thanh toan to the database.
	 *
	 * @param id the primary key for the new thong tin thanh toan
	 * @return the new thong tin thanh toan
	 */
	public ThongTinThanhToan create(long id) {
		ThongTinThanhToan thongTinThanhToan = new ThongTinThanhToanImpl();

		thongTinThanhToan.setNew(true);
		thongTinThanhToan.setPrimaryKey(id);

		return thongTinThanhToan;
	}

	/**
	 * Removes the thong tin thanh toan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin thanh toan
	 * @return the thong tin thanh toan that was removed
	 * @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThongTinThanhToan remove(long id)
		throws NoSuchThongTinThanhToanException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the thong tin thanh toan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thong tin thanh toan
	 * @return the thong tin thanh toan that was removed
	 * @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinThanhToan remove(Serializable primaryKey)
		throws NoSuchThongTinThanhToanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThongTinThanhToan thongTinThanhToan = (ThongTinThanhToan)session.get(ThongTinThanhToanImpl.class,
					primaryKey);

			if (thongTinThanhToan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThongTinThanhToanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thongTinThanhToan);
		}
		catch (NoSuchThongTinThanhToanException nsee) {
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
	protected ThongTinThanhToan removeImpl(ThongTinThanhToan thongTinThanhToan)
		throws SystemException {
		thongTinThanhToan = toUnwrappedModel(thongTinThanhToan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, thongTinThanhToan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(thongTinThanhToan);

		return thongTinThanhToan;
	}

	@Override
	public ThongTinThanhToan updateImpl(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan,
		boolean merge) throws SystemException {
		thongTinThanhToan = toUnwrappedModel(thongTinThanhToan);

		boolean isNew = thongTinThanhToan.isNew();

		ThongTinThanhToanModelImpl thongTinThanhToanModelImpl = (ThongTinThanhToanModelImpl)thongTinThanhToan;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, thongTinThanhToan, merge);

			thongTinThanhToan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThongTinThanhToanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thongTinThanhToanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(thongTinThanhToanModelImpl.getOriginalHoSoTTHCCongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGID,
					args);

				args = new Object[] {
						Long.valueOf(thongTinThanhToanModelImpl.getHoSoTTHCCongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGID,
					args);
			}
		}

		EntityCacheUtil.putResult(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinThanhToanImpl.class, thongTinThanhToan.getPrimaryKey(),
			thongTinThanhToan);

		return thongTinThanhToan;
	}

	protected ThongTinThanhToan toUnwrappedModel(
		ThongTinThanhToan thongTinThanhToan) {
		if (thongTinThanhToan instanceof ThongTinThanhToanImpl) {
			return thongTinThanhToan;
		}

		ThongTinThanhToanImpl thongTinThanhToanImpl = new ThongTinThanhToanImpl();

		thongTinThanhToanImpl.setNew(thongTinThanhToan.isNew());
		thongTinThanhToanImpl.setPrimaryKey(thongTinThanhToan.getPrimaryKey());

		thongTinThanhToanImpl.setId(thongTinThanhToan.getId());
		thongTinThanhToanImpl.setHoSoTTHCCongId(thongTinThanhToan.getHoSoTTHCCongId());
		thongTinThanhToanImpl.setTaiKhoanNguoiDungNopId(thongTinThanhToan.getTaiKhoanNguoiDungNopId());
		thongTinThanhToanImpl.setTaiKhoanNguoiDungNhanId(thongTinThanhToan.getTaiKhoanNguoiDungNhanId());
		thongTinThanhToanImpl.setLoaiThanhToan(thongTinThanhToan.getLoaiThanhToan());
		thongTinThanhToanImpl.setTenNguoiNopTien(thongTinThanhToan.getTenNguoiNopTien());
		thongTinThanhToanImpl.setTenCanBoNhanTien(thongTinThanhToan.getTenCanBoNhanTien());
		thongTinThanhToanImpl.setXacNhan(thongTinThanhToan.getXacNhan());
		thongTinThanhToanImpl.setLoaiPhi(thongTinThanhToan.getLoaiPhi());
		thongTinThanhToanImpl.setSoTien(thongTinThanhToan.getSoTien());
		thongTinThanhToanImpl.setNgayThuTien(thongTinThanhToan.getNgayThuTien());
		thongTinThanhToanImpl.setNgayXacNhan(thongTinThanhToan.getNgayXacNhan());
		thongTinThanhToanImpl.setNgayChuyenTien(thongTinThanhToan.getNgayChuyenTien());
		thongTinThanhToanImpl.setYKien(thongTinThanhToan.getYKien());
		thongTinThanhToanImpl.setNoiLuuTruId(thongTinThanhToan.getNoiLuuTruId());
		thongTinThanhToanImpl.setNguoiTao(thongTinThanhToan.getNguoiTao());
		thongTinThanhToanImpl.setNguoiSua(thongTinThanhToan.getNguoiSua());
		thongTinThanhToanImpl.setNgayTao(thongTinThanhToan.getNgayTao());
		thongTinThanhToanImpl.setNgaySua(thongTinThanhToan.getNgaySua());

		return thongTinThanhToanImpl;
	}

	/**
	 * Returns the thong tin thanh toan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin thanh toan
	 * @return the thong tin thanh toan
	 * @throws com.liferay.portal.NoSuchModelException if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinThanhToan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thong tin thanh toan with the primary key or throws a {@link org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException} if it could not be found.
	 *
	 * @param id the primary key of the thong tin thanh toan
	 * @return the thong tin thanh toan
	 * @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThongTinThanhToan findByPrimaryKey(long id)
		throws NoSuchThongTinThanhToanException, SystemException {
		ThongTinThanhToan thongTinThanhToan = fetchByPrimaryKey(id);

		if (thongTinThanhToan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchThongTinThanhToanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return thongTinThanhToan;
	}

	/**
	 * Returns the thong tin thanh toan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin thanh toan
	 * @return the thong tin thanh toan, or <code>null</code> if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinThanhToan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the thong tin thanh toan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin thanh toan
	 * @return the thong tin thanh toan, or <code>null</code> if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThongTinThanhToan fetchByPrimaryKey(long id)
		throws SystemException {
		ThongTinThanhToan thongTinThanhToan = (ThongTinThanhToan)EntityCacheUtil.getResult(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinThanhToanImpl.class, id);

		if (thongTinThanhToan == _nullThongTinThanhToan) {
			return null;
		}

		if (thongTinThanhToan == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				thongTinThanhToan = (ThongTinThanhToan)session.get(ThongTinThanhToanImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (thongTinThanhToan != null) {
					cacheResult(thongTinThanhToan);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ThongTinThanhToanModelImpl.ENTITY_CACHE_ENABLED,
						ThongTinThanhToanImpl.class, id, _nullThongTinThanhToan);
				}

				closeSession(session);
			}
		}

		return thongTinThanhToan;
	}

	/**
	 * Returns all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the matching thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThongTinThanhToan> findByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		return findByHoSoTTHCCongId(hoSoTTHCCongId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param start the lower bound of the range of thong tin thanh toans
	 * @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	 * @return the range of matching thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThongTinThanhToan> findByHoSoTTHCCongId(long hoSoTTHCCongId,
		int start, int end) throws SystemException {
		return findByHoSoTTHCCongId(hoSoTTHCCongId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param start the lower bound of the range of thong tin thanh toans
	 * @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThongTinThanhToan> findByHoSoTTHCCongId(long hoSoTTHCCongId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGID;
			finderArgs = new Object[] { hoSoTTHCCongId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSOTTHCCONGID;
			finderArgs = new Object[] {
					hoSoTTHCCongId,
					
					start, end, orderByComparator
				};
		}

		List<ThongTinThanhToan> list = (List<ThongTinThanhToan>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_THONGTINTHANHTOAN_WHERE);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ThongTinThanhToanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCongId);

				list = (List<ThongTinThanhToan>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin thanh toan
	 * @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a matching thong tin thanh toan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThongTinThanhToan findByHoSoTTHCCongId_First(long hoSoTTHCCongId,
		OrderByComparator orderByComparator)
		throws NoSuchThongTinThanhToanException, SystemException {
		List<ThongTinThanhToan> list = findByHoSoTTHCCongId(hoSoTTHCCongId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCongId=");
			msg.append(hoSoTTHCCongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThongTinThanhToanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin thanh toan
	 * @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a matching thong tin thanh toan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThongTinThanhToan findByHoSoTTHCCongId_Last(long hoSoTTHCCongId,
		OrderByComparator orderByComparator)
		throws NoSuchThongTinThanhToanException, SystemException {
		int count = countByHoSoTTHCCongId(hoSoTTHCCongId);

		List<ThongTinThanhToan> list = findByHoSoTTHCCongId(hoSoTTHCCongId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCongId=");
			msg.append(hoSoTTHCCongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThongTinThanhToanException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the thong tin thanh toans before and after the current thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current thong tin thanh toan
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thong tin thanh toan
	 * @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThongTinThanhToan[] findByHoSoTTHCCongId_PrevAndNext(long id,
		long hoSoTTHCCongId, OrderByComparator orderByComparator)
		throws NoSuchThongTinThanhToanException, SystemException {
		ThongTinThanhToan thongTinThanhToan = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThongTinThanhToan[] array = new ThongTinThanhToanImpl[3];

			array[0] = getByHoSoTTHCCongId_PrevAndNext(session,
					thongTinThanhToan, hoSoTTHCCongId, orderByComparator, true);

			array[1] = thongTinThanhToan;

			array[2] = getByHoSoTTHCCongId_PrevAndNext(session,
					thongTinThanhToan, hoSoTTHCCongId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThongTinThanhToan getByHoSoTTHCCongId_PrevAndNext(
		Session session, ThongTinThanhToan thongTinThanhToan,
		long hoSoTTHCCongId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THONGTINTHANHTOAN_WHERE);

		query.append(_FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2);

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
			query.append(ThongTinThanhToanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hoSoTTHCCongId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thongTinThanhToan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThongTinThanhToan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the thong tin thanh toans.
	 *
	 * @return the thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThongTinThanhToan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thong tin thanh toans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin thanh toans
	 * @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	 * @return the range of thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThongTinThanhToan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thong tin thanh toans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin thanh toans
	 * @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThongTinThanhToan> findAll(int start, int end,
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

		List<ThongTinThanhToan> list = (List<ThongTinThanhToan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THONGTINTHANHTOAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THONGTINTHANHTOAN.concat(ThongTinThanhToanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ThongTinThanhToan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ThongTinThanhToan>)QueryUtil.list(q,
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
	 * Removes all the thong tin thanh toans where hoSoTTHCCongId = &#63; from the database.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		for (ThongTinThanhToan thongTinThanhToan : findByHoSoTTHCCongId(
				hoSoTTHCCongId)) {
			remove(thongTinThanhToan);
		}
	}

	/**
	 * Removes all the thong tin thanh toans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ThongTinThanhToan thongTinThanhToan : findAll()) {
			remove(thongTinThanhToan);
		}
	}

	/**
	 * Returns the number of thong tin thanh toans where hoSoTTHCCongId = &#63;.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the number of matching thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		Object[] finderArgs = new Object[] { hoSoTTHCCongId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINTHANHTOAN_WHERE);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCongId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of thong tin thanh toans.
	 *
	 * @return the number of thong tin thanh toans
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THONGTINTHANHTOAN);

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
	 * Initializes the thong tin thanh toan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThongTinThanhToan>> listenersList = new ArrayList<ModelListener<ThongTinThanhToan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThongTinThanhToan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ThongTinThanhToanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ThongTinThanhToanPersistence.class)
	protected ThongTinThanhToanPersistence thongTinThanhToanPersistence;
	@BeanReference(type = TienTePersistence.class)
	protected TienTePersistence tienTePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_THONGTINTHANHTOAN = "SELECT thongTinThanhToan FROM ThongTinThanhToan thongTinThanhToan";
	private static final String _SQL_SELECT_THONGTINTHANHTOAN_WHERE = "SELECT thongTinThanhToan FROM ThongTinThanhToan thongTinThanhToan WHERE ";
	private static final String _SQL_COUNT_THONGTINTHANHTOAN = "SELECT COUNT(thongTinThanhToan) FROM ThongTinThanhToan thongTinThanhToan";
	private static final String _SQL_COUNT_THONGTINTHANHTOAN_WHERE = "SELECT COUNT(thongTinThanhToan) FROM ThongTinThanhToan thongTinThanhToan WHERE ";
	private static final String _FINDER_COLUMN_HOSOTTHCCONGID_HOSOTTHCCONGID_2 = "thongTinThanhToan.hoSoTTHCCongId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thongTinThanhToan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThongTinThanhToan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThongTinThanhToan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThongTinThanhToanPersistenceImpl.class);
	private static ThongTinThanhToan _nullThongTinThanhToan = new ThongTinThanhToanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ThongTinThanhToan> toCacheModel() {
				return _nullThongTinThanhToanCacheModel;
			}
		};

	private static CacheModel<ThongTinThanhToan> _nullThongTinThanhToanCacheModel =
		new CacheModel<ThongTinThanhToan>() {
			public ThongTinThanhToan toEntityModel() {
				return _nullThongTinThanhToan;
			}
		};
}