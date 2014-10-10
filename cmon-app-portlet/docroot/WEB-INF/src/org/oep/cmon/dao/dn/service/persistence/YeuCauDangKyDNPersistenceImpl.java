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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException;
import org.oep.cmon.dao.dn.model.YeuCauDangKyDN;
import org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDNImpl;
import org.oep.cmon.dao.dn.model.impl.YeuCauDangKyDNModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the yeu cau dang ky d n service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see YeuCauDangKyDNPersistence
 * @see YeuCauDangKyDNUtil
 * @generated
 */
public class YeuCauDangKyDNPersistenceImpl extends BasePersistenceImpl<YeuCauDangKyDN>
	implements YeuCauDangKyDNPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YeuCauDangKyDNUtil} to access the yeu cau dang ky d n persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YeuCauDangKyDNImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDNModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyDNImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDNModelImpl.FINDER_CACHE_ENABLED,
			YeuCauDangKyDNImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDNModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the yeu cau dang ky d n in the entity cache if it is enabled.
	 *
	 * @param yeuCauDangKyDN the yeu cau dang ky d n
	 */
	public void cacheResult(YeuCauDangKyDN yeuCauDangKyDN) {
		EntityCacheUtil.putResult(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDNImpl.class, yeuCauDangKyDN.getPrimaryKey(),
			yeuCauDangKyDN);

		yeuCauDangKyDN.resetOriginalValues();
	}

	/**
	 * Caches the yeu cau dang ky d ns in the entity cache if it is enabled.
	 *
	 * @param yeuCauDangKyDNs the yeu cau dang ky d ns
	 */
	public void cacheResult(List<YeuCauDangKyDN> yeuCauDangKyDNs) {
		for (YeuCauDangKyDN yeuCauDangKyDN : yeuCauDangKyDNs) {
			if (EntityCacheUtil.getResult(
						YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauDangKyDNImpl.class, yeuCauDangKyDN.getPrimaryKey()) == null) {
				cacheResult(yeuCauDangKyDN);
			}
			else {
				yeuCauDangKyDN.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all yeu cau dang ky d ns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YeuCauDangKyDNImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YeuCauDangKyDNImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the yeu cau dang ky d n.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YeuCauDangKyDN yeuCauDangKyDN) {
		EntityCacheUtil.removeResult(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDNImpl.class, yeuCauDangKyDN.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YeuCauDangKyDN> yeuCauDangKyDNs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YeuCauDangKyDN yeuCauDangKyDN : yeuCauDangKyDNs) {
			EntityCacheUtil.removeResult(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauDangKyDNImpl.class, yeuCauDangKyDN.getPrimaryKey());
		}
	}

	/**
	 * Creates a new yeu cau dang ky d n with the primary key. Does not add the yeu cau dang ky d n to the database.
	 *
	 * @param id the primary key for the new yeu cau dang ky d n
	 * @return the new yeu cau dang ky d n
	 */
	public YeuCauDangKyDN create(long id) {
		YeuCauDangKyDN yeuCauDangKyDN = new YeuCauDangKyDNImpl();

		yeuCauDangKyDN.setNew(true);
		yeuCauDangKyDN.setPrimaryKey(id);

		return yeuCauDangKyDN;
	}

	/**
	 * Removes the yeu cau dang ky d n with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the yeu cau dang ky d n
	 * @return the yeu cau dang ky d n that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException if a yeu cau dang ky d n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyDN remove(long id)
		throws NoSuchYeuCauDangKyDNException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the yeu cau dang ky d n with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky d n
	 * @return the yeu cau dang ky d n that was removed
	 * @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException if a yeu cau dang ky d n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyDN remove(Serializable primaryKey)
		throws NoSuchYeuCauDangKyDNException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YeuCauDangKyDN yeuCauDangKyDN = (YeuCauDangKyDN)session.get(YeuCauDangKyDNImpl.class,
					primaryKey);

			if (yeuCauDangKyDN == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYeuCauDangKyDNException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yeuCauDangKyDN);
		}
		catch (NoSuchYeuCauDangKyDNException nsee) {
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
	protected YeuCauDangKyDN removeImpl(YeuCauDangKyDN yeuCauDangKyDN)
		throws SystemException {
		yeuCauDangKyDN = toUnwrappedModel(yeuCauDangKyDN);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, yeuCauDangKyDN);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(yeuCauDangKyDN);

		return yeuCauDangKyDN;
	}

	@Override
	public YeuCauDangKyDN updateImpl(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDN yeuCauDangKyDN, boolean merge)
		throws SystemException {
		yeuCauDangKyDN = toUnwrappedModel(yeuCauDangKyDN);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, yeuCauDangKyDN, merge);

			yeuCauDangKyDN.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauDangKyDNImpl.class, yeuCauDangKyDN.getPrimaryKey(),
			yeuCauDangKyDN);

		return yeuCauDangKyDN;
	}

	protected YeuCauDangKyDN toUnwrappedModel(YeuCauDangKyDN yeuCauDangKyDN) {
		if (yeuCauDangKyDN instanceof YeuCauDangKyDNImpl) {
			return yeuCauDangKyDN;
		}

		YeuCauDangKyDNImpl yeuCauDangKyDNImpl = new YeuCauDangKyDNImpl();

		yeuCauDangKyDNImpl.setNew(yeuCauDangKyDN.isNew());
		yeuCauDangKyDNImpl.setPrimaryKey(yeuCauDangKyDN.getPrimaryKey());

		yeuCauDangKyDNImpl.setId(yeuCauDangKyDN.getId());
		yeuCauDangKyDNImpl.setTen(yeuCauDangKyDN.getTen());
		yeuCauDangKyDNImpl.setMaSoThue(yeuCauDangKyDN.getMaSoThue());
		yeuCauDangKyDNImpl.setMaGiayPhep(yeuCauDangKyDN.getMaGiayPhep());
		yeuCauDangKyDNImpl.setNgayCap(yeuCauDangKyDN.getNgayCap());
		yeuCauDangKyDNImpl.setEmail(yeuCauDangKyDN.getEmail());
		yeuCauDangKyDNImpl.setHoNguoiDaiDien(yeuCauDangKyDN.getHoNguoiDaiDien());
		yeuCauDangKyDNImpl.setTenDemNguoiDaiDien(yeuCauDangKyDN.getTenDemNguoiDaiDien());
		yeuCauDangKyDNImpl.setTenNguoiDaiDien(yeuCauDangKyDN.getTenNguoiDaiDien());
		yeuCauDangKyDNImpl.setSoCmnd(yeuCauDangKyDN.getSoCmnd());
		yeuCauDangKyDNImpl.setNgayCapCmnd(yeuCauDangKyDN.getNgayCapCmnd());
		yeuCauDangKyDNImpl.setNoiCapCmndId(yeuCauDangKyDN.getNoiCapCmndId());
		yeuCauDangKyDNImpl.setMoTa(yeuCauDangKyDN.getMoTa());
		yeuCauDangKyDNImpl.setLoaiDoiTuongId(yeuCauDangKyDN.getLoaiDoiTuongId());
		yeuCauDangKyDNImpl.setTruSoTinhId(yeuCauDangKyDN.getTruSoTinhId());
		yeuCauDangKyDNImpl.setTruSoHuyenId(yeuCauDangKyDN.getTruSoHuyenId());
		yeuCauDangKyDNImpl.setTruSoXaId(yeuCauDangKyDN.getTruSoXaId());
		yeuCauDangKyDNImpl.setTruSo(yeuCauDangKyDN.getTruSo());
		yeuCauDangKyDNImpl.setDaXoa(yeuCauDangKyDN.getDaXoa());
		yeuCauDangKyDNImpl.setNgayTao(yeuCauDangKyDN.getNgayTao());
		yeuCauDangKyDNImpl.setNguoiTao(yeuCauDangKyDN.getNguoiTao());
		yeuCauDangKyDNImpl.setNgaySua(yeuCauDangKyDN.getNgaySua());
		yeuCauDangKyDNImpl.setNguoiSua(yeuCauDangKyDN.getNguoiSua());
		yeuCauDangKyDNImpl.setTrangThai(yeuCauDangKyDN.getTrangThai());
		yeuCauDangKyDNImpl.setLoaiHinhDoanhNghiepId(yeuCauDangKyDN.getLoaiHinhDoanhNghiepId());

		return yeuCauDangKyDNImpl;
	}

	/**
	 * Returns the yeu cau dang ky d n with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky d n
	 * @return the yeu cau dang ky d n
	 * @throws com.liferay.portal.NoSuchModelException if a yeu cau dang ky d n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyDN findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the yeu cau dang ky d n with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException} if it could not be found.
	 *
	 * @param id the primary key of the yeu cau dang ky d n
	 * @return the yeu cau dang ky d n
	 * @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDNException if a yeu cau dang ky d n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyDN findByPrimaryKey(long id)
		throws NoSuchYeuCauDangKyDNException, SystemException {
		YeuCauDangKyDN yeuCauDangKyDN = fetchByPrimaryKey(id);

		if (yeuCauDangKyDN == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchYeuCauDangKyDNException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return yeuCauDangKyDN;
	}

	/**
	 * Returns the yeu cau dang ky d n with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau dang ky d n
	 * @return the yeu cau dang ky d n, or <code>null</code> if a yeu cau dang ky d n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauDangKyDN fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the yeu cau dang ky d n with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the yeu cau dang ky d n
	 * @return the yeu cau dang ky d n, or <code>null</code> if a yeu cau dang ky d n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YeuCauDangKyDN fetchByPrimaryKey(long id) throws SystemException {
		YeuCauDangKyDN yeuCauDangKyDN = (YeuCauDangKyDN)EntityCacheUtil.getResult(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauDangKyDNImpl.class, id);

		if (yeuCauDangKyDN == _nullYeuCauDangKyDN) {
			return null;
		}

		if (yeuCauDangKyDN == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				yeuCauDangKyDN = (YeuCauDangKyDN)session.get(YeuCauDangKyDNImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (yeuCauDangKyDN != null) {
					cacheResult(yeuCauDangKyDN);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YeuCauDangKyDNModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauDangKyDNImpl.class, id, _nullYeuCauDangKyDN);
				}

				closeSession(session);
			}
		}

		return yeuCauDangKyDN;
	}

	/**
	 * Returns all the yeu cau dang ky d ns.
	 *
	 * @return the yeu cau dang ky d ns
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyDN> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the yeu cau dang ky d ns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of yeu cau dang ky d ns
	 * @param end the upper bound of the range of yeu cau dang ky d ns (not inclusive)
	 * @return the range of yeu cau dang ky d ns
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyDN> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the yeu cau dang ky d ns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of yeu cau dang ky d ns
	 * @param end the upper bound of the range of yeu cau dang ky d ns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of yeu cau dang ky d ns
	 * @throws SystemException if a system exception occurred
	 */
	public List<YeuCauDangKyDN> findAll(int start, int end,
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

		List<YeuCauDangKyDN> list = (List<YeuCauDangKyDN>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YEUCAUDANGKYDN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YEUCAUDANGKYDN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YeuCauDangKyDN>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YeuCauDangKyDN>)QueryUtil.list(q,
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
	 * Removes all the yeu cau dang ky d ns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YeuCauDangKyDN yeuCauDangKyDN : findAll()) {
			remove(yeuCauDangKyDN);
		}
	}

	/**
	 * Returns the number of yeu cau dang ky d ns.
	 *
	 * @return the number of yeu cau dang ky d ns
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YEUCAUDANGKYDN);

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
	 * Initializes the yeu cau dang ky d n persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dn.model.YeuCauDangKyDN")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YeuCauDangKyDN>> listenersList = new ArrayList<ModelListener<YeuCauDangKyDN>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YeuCauDangKyDN>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YeuCauDangKyDNImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DoanhNghiepPersistence.class)
	protected DoanhNghiepPersistence doanhNghiepPersistence;
	@BeanReference(type = DoanhNghiep2NganhNghePersistence.class)
	protected DoanhNghiep2NganhNghePersistence doanhNghiep2NganhNghePersistence;
	@BeanReference(type = LoaiDoanhNghiepPersistence.class)
	protected LoaiDoanhNghiepPersistence loaiDoanhNghiepPersistence;
	@BeanReference(type = NganhNgheKinhDoanhPersistence.class)
	protected NganhNgheKinhDoanhPersistence nganhNgheKinhDoanhPersistence;
	@BeanReference(type = TrangThaiDoanhNghiepPersistence.class)
	protected TrangThaiDoanhNghiepPersistence trangThaiDoanhNghiepPersistence;
	@BeanReference(type = YeuCauDangKyDNPersistence.class)
	protected YeuCauDangKyDNPersistence yeuCauDangKyDNPersistence;
	@BeanReference(type = YeuCauDangKyDoanhNghiepPersistence.class)
	protected YeuCauDangKyDoanhNghiepPersistence yeuCauDangKyDoanhNghiepPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_YEUCAUDANGKYDN = "SELECT yeuCauDangKyDN FROM YeuCauDangKyDN yeuCauDangKyDN";
	private static final String _SQL_COUNT_YEUCAUDANGKYDN = "SELECT COUNT(yeuCauDangKyDN) FROM YeuCauDangKyDN yeuCauDangKyDN";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yeuCauDangKyDN.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YeuCauDangKyDN exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YeuCauDangKyDNPersistenceImpl.class);
	private static YeuCauDangKyDN _nullYeuCauDangKyDN = new YeuCauDangKyDNImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YeuCauDangKyDN> toCacheModel() {
				return _nullYeuCauDangKyDNCacheModel;
			}
		};

	private static CacheModel<YeuCauDangKyDN> _nullYeuCauDangKyDNCacheModel = new CacheModel<YeuCauDangKyDN>() {
			public YeuCauDangKyDN toEntityModel() {
				return _nullYeuCauDangKyDN;
			}
		};
}