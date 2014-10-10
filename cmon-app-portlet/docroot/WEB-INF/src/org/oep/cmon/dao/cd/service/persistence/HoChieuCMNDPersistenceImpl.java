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

package org.oep.cmon.dao.cd.service.persistence;

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

import org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException;
import org.oep.cmon.dao.cd.model.HoChieuCMND;
import org.oep.cmon.dao.cd.model.impl.HoChieuCMNDImpl;
import org.oep.cmon.dao.cd.model.impl.HoChieuCMNDModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ho chieu c m n d service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see HoChieuCMNDPersistence
 * @see HoChieuCMNDUtil
 * @generated
 */
public class HoChieuCMNDPersistenceImpl extends BasePersistenceImpl<HoChieuCMND>
	implements HoChieuCMNDPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HoChieuCMNDUtil} to access the ho chieu c m n d persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HoChieuCMNDImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
			HoChieuCMNDModelImpl.FINDER_CACHE_ENABLED, HoChieuCMNDImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
			HoChieuCMNDModelImpl.FINDER_CACHE_ENABLED, HoChieuCMNDImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
			HoChieuCMNDModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ho chieu c m n d in the entity cache if it is enabled.
	 *
	 * @param hoChieuCMND the ho chieu c m n d
	 */
	public void cacheResult(HoChieuCMND hoChieuCMND) {
		EntityCacheUtil.putResult(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
			HoChieuCMNDImpl.class, hoChieuCMND.getPrimaryKey(), hoChieuCMND);

		hoChieuCMND.resetOriginalValues();
	}

	/**
	 * Caches the ho chieu c m n ds in the entity cache if it is enabled.
	 *
	 * @param hoChieuCMNDs the ho chieu c m n ds
	 */
	public void cacheResult(List<HoChieuCMND> hoChieuCMNDs) {
		for (HoChieuCMND hoChieuCMND : hoChieuCMNDs) {
			if (EntityCacheUtil.getResult(
						HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
						HoChieuCMNDImpl.class, hoChieuCMND.getPrimaryKey()) == null) {
				cacheResult(hoChieuCMND);
			}
			else {
				hoChieuCMND.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ho chieu c m n ds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HoChieuCMNDImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HoChieuCMNDImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ho chieu c m n d.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoChieuCMND hoChieuCMND) {
		EntityCacheUtil.removeResult(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
			HoChieuCMNDImpl.class, hoChieuCMND.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HoChieuCMND> hoChieuCMNDs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HoChieuCMND hoChieuCMND : hoChieuCMNDs) {
			EntityCacheUtil.removeResult(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
				HoChieuCMNDImpl.class, hoChieuCMND.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ho chieu c m n d with the primary key. Does not add the ho chieu c m n d to the database.
	 *
	 * @param id the primary key for the new ho chieu c m n d
	 * @return the new ho chieu c m n d
	 */
	public HoChieuCMND create(long id) {
		HoChieuCMND hoChieuCMND = new HoChieuCMNDImpl();

		hoChieuCMND.setNew(true);
		hoChieuCMND.setPrimaryKey(id);

		return hoChieuCMND;
	}

	/**
	 * Removes the ho chieu c m n d with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ho chieu c m n d
	 * @return the ho chieu c m n d that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoChieuCMND remove(long id)
		throws NoSuchHoChieuCMNDException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the ho chieu c m n d with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ho chieu c m n d
	 * @return the ho chieu c m n d that was removed
	 * @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoChieuCMND remove(Serializable primaryKey)
		throws NoSuchHoChieuCMNDException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HoChieuCMND hoChieuCMND = (HoChieuCMND)session.get(HoChieuCMNDImpl.class,
					primaryKey);

			if (hoChieuCMND == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoChieuCMNDException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hoChieuCMND);
		}
		catch (NoSuchHoChieuCMNDException nsee) {
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
	protected HoChieuCMND removeImpl(HoChieuCMND hoChieuCMND)
		throws SystemException {
		hoChieuCMND = toUnwrappedModel(hoChieuCMND);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, hoChieuCMND);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(hoChieuCMND);

		return hoChieuCMND;
	}

	@Override
	public HoChieuCMND updateImpl(
		org.oep.cmon.dao.cd.model.HoChieuCMND hoChieuCMND, boolean merge)
		throws SystemException {
		hoChieuCMND = toUnwrappedModel(hoChieuCMND);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, hoChieuCMND, merge);

			hoChieuCMND.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
			HoChieuCMNDImpl.class, hoChieuCMND.getPrimaryKey(), hoChieuCMND);

		return hoChieuCMND;
	}

	protected HoChieuCMND toUnwrappedModel(HoChieuCMND hoChieuCMND) {
		if (hoChieuCMND instanceof HoChieuCMNDImpl) {
			return hoChieuCMND;
		}

		HoChieuCMNDImpl hoChieuCMNDImpl = new HoChieuCMNDImpl();

		hoChieuCMNDImpl.setNew(hoChieuCMND.isNew());
		hoChieuCMNDImpl.setPrimaryKey(hoChieuCMND.getPrimaryKey());

		hoChieuCMNDImpl.setId(hoChieuCMND.getId());
		hoChieuCMNDImpl.setSo(hoChieuCMND.getSo());
		hoChieuCMNDImpl.setNgayCap(hoChieuCMND.getNgayCap());
		hoChieuCMNDImpl.setNgayHetHan(hoChieuCMND.getNgayHetHan());
		hoChieuCMNDImpl.setNoiCapId(hoChieuCMND.getNoiCapId());
		hoChieuCMNDImpl.setNoiCap(hoChieuCMND.getNoiCap());
		hoChieuCMNDImpl.setGiChu(hoChieuCMND.getGiChu());
		hoChieuCMNDImpl.setLoai(hoChieuCMND.getLoai());
		hoChieuCMNDImpl.setTrangThai(hoChieuCMND.getTrangThai());
		hoChieuCMNDImpl.setNguoiTao(hoChieuCMND.getNguoiTao());
		hoChieuCMNDImpl.setNgayTao(hoChieuCMND.getNgayTao());
		hoChieuCMNDImpl.setNguoiSua(hoChieuCMND.getNguoiSua());
		hoChieuCMNDImpl.setNgaySua(hoChieuCMND.getNgaySua());
		hoChieuCMNDImpl.setCongDanID(hoChieuCMND.getCongDanID());

		return hoChieuCMNDImpl;
	}

	/**
	 * Returns the ho chieu c m n d with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho chieu c m n d
	 * @return the ho chieu c m n d
	 * @throws com.liferay.portal.NoSuchModelException if a ho chieu c m n d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoChieuCMND findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho chieu c m n d with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException} if it could not be found.
	 *
	 * @param id the primary key of the ho chieu c m n d
	 * @return the ho chieu c m n d
	 * @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoChieuCMND findByPrimaryKey(long id)
		throws NoSuchHoChieuCMNDException, SystemException {
		HoChieuCMND hoChieuCMND = fetchByPrimaryKey(id);

		if (hoChieuCMND == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHoChieuCMNDException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return hoChieuCMND;
	}

	/**
	 * Returns the ho chieu c m n d with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ho chieu c m n d
	 * @return the ho chieu c m n d, or <code>null</code> if a ho chieu c m n d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HoChieuCMND fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ho chieu c m n d with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ho chieu c m n d
	 * @return the ho chieu c m n d, or <code>null</code> if a ho chieu c m n d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HoChieuCMND fetchByPrimaryKey(long id) throws SystemException {
		HoChieuCMND hoChieuCMND = (HoChieuCMND)EntityCacheUtil.getResult(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
				HoChieuCMNDImpl.class, id);

		if (hoChieuCMND == _nullHoChieuCMND) {
			return null;
		}

		if (hoChieuCMND == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				hoChieuCMND = (HoChieuCMND)session.get(HoChieuCMNDImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (hoChieuCMND != null) {
					cacheResult(hoChieuCMND);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HoChieuCMNDModelImpl.ENTITY_CACHE_ENABLED,
						HoChieuCMNDImpl.class, id, _nullHoChieuCMND);
				}

				closeSession(session);
			}
		}

		return hoChieuCMND;
	}

	/**
	 * Returns all the ho chieu c m n ds.
	 *
	 * @return the ho chieu c m n ds
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoChieuCMND> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ho chieu c m n ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho chieu c m n ds
	 * @param end the upper bound of the range of ho chieu c m n ds (not inclusive)
	 * @return the range of ho chieu c m n ds
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoChieuCMND> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ho chieu c m n ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ho chieu c m n ds
	 * @param end the upper bound of the range of ho chieu c m n ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ho chieu c m n ds
	 * @throws SystemException if a system exception occurred
	 */
	public List<HoChieuCMND> findAll(int start, int end,
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

		List<HoChieuCMND> list = (List<HoChieuCMND>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOCHIEUCMND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOCHIEUCMND.concat(HoChieuCMNDModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HoChieuCMND>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HoChieuCMND>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ho chieu c m n ds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HoChieuCMND hoChieuCMND : findAll()) {
			remove(hoChieuCMND);
		}
	}

	/**
	 * Returns the number of ho chieu c m n ds.
	 *
	 * @return the number of ho chieu c m n ds
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOCHIEUCMND);

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
	 * Initializes the ho chieu c m n d persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.cd.model.HoChieuCMND")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HoChieuCMND>> listenersList = new ArrayList<ModelListener<HoChieuCMND>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HoChieuCMND>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HoChieuCMNDImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChuyenMonPersistence.class)
	protected ChuyenMonPersistence chuyenMonPersistence;
	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = HeThongPersistence.class)
	protected HeThongPersistence heThongPersistence;
	@BeanReference(type = HoChieuCMNDPersistence.class)
	protected HoChieuCMNDPersistence hoChieuCMNDPersistence;
	@BeanReference(type = NgheNghiepPersistence.class)
	protected NgheNghiepPersistence ngheNghiepPersistence;
	@BeanReference(type = QuanHeGiaDinhPersistence.class)
	protected QuanHeGiaDinhPersistence quanHeGiaDinhPersistence;
	@BeanReference(type = TinhTrangHonNhanPersistence.class)
	protected TinhTrangHonNhanPersistence tinhTrangHonNhanPersistence;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = TrinhDoChuyenMonPersistence.class)
	protected TrinhDoChuyenMonPersistence trinhDoChuyenMonPersistence;
	@BeanReference(type = TrinhDoHocVanPersistence.class)
	protected TrinhDoHocVanPersistence trinhDoHocVanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HOCHIEUCMND = "SELECT hoChieuCMND FROM HoChieuCMND hoChieuCMND";
	private static final String _SQL_COUNT_HOCHIEUCMND = "SELECT COUNT(hoChieuCMND) FROM HoChieuCMND hoChieuCMND";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hoChieuCMND.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HoChieuCMND exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HoChieuCMNDPersistenceImpl.class);
	private static HoChieuCMND _nullHoChieuCMND = new HoChieuCMNDImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HoChieuCMND> toCacheModel() {
				return _nullHoChieuCMNDCacheModel;
			}
		};

	private static CacheModel<HoChieuCMND> _nullHoChieuCMNDCacheModel = new CacheModel<HoChieuCMND>() {
			public HoChieuCMND toEntityModel() {
				return _nullHoChieuCMND;
			}
		};
}