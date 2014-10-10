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

package org.oep.cmon.dao.kios.service.persistence;

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

import org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException;
import org.oep.cmon.dao.kios.model.DanhSachHoSo;
import org.oep.cmon.dao.kios.model.impl.DanhSachHoSoImpl;
import org.oep.cmon.dao.kios.model.impl.DanhSachHoSoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh sach ho so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachHoSoPersistence
 * @see DanhSachHoSoUtil
 * @generated
 */
public class DanhSachHoSoPersistenceImpl extends BasePersistenceImpl<DanhSachHoSo>
	implements DanhSachHoSoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhSachHoSoUtil} to access the danh sach ho so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhSachHoSoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachHoSoModelImpl.FINDER_CACHE_ENABLED, DanhSachHoSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachHoSoModelImpl.FINDER_CACHE_ENABLED, DanhSachHoSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachHoSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh sach ho so in the entity cache if it is enabled.
	 *
	 * @param danhSachHoSo the danh sach ho so
	 */
	public void cacheResult(DanhSachHoSo danhSachHoSo) {
		EntityCacheUtil.putResult(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachHoSoImpl.class, danhSachHoSo.getPrimaryKey(), danhSachHoSo);

		danhSachHoSo.resetOriginalValues();
	}

	/**
	 * Caches the danh sach ho sos in the entity cache if it is enabled.
	 *
	 * @param danhSachHoSos the danh sach ho sos
	 */
	public void cacheResult(List<DanhSachHoSo> danhSachHoSos) {
		for (DanhSachHoSo danhSachHoSo : danhSachHoSos) {
			if (EntityCacheUtil.getResult(
						DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachHoSoImpl.class, danhSachHoSo.getPrimaryKey()) == null) {
				cacheResult(danhSachHoSo);
			}
			else {
				danhSachHoSo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh sach ho sos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhSachHoSoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhSachHoSoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh sach ho so.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhSachHoSo danhSachHoSo) {
		EntityCacheUtil.removeResult(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachHoSoImpl.class, danhSachHoSo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DanhSachHoSo> danhSachHoSos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhSachHoSo danhSachHoSo : danhSachHoSos) {
			EntityCacheUtil.removeResult(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachHoSoImpl.class, danhSachHoSo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new danh sach ho so with the primary key. Does not add the danh sach ho so to the database.
	 *
	 * @param id the primary key for the new danh sach ho so
	 * @return the new danh sach ho so
	 */
	public DanhSachHoSo create(long id) {
		DanhSachHoSo danhSachHoSo = new DanhSachHoSoImpl();

		danhSachHoSo.setNew(true);
		danhSachHoSo.setPrimaryKey(id);

		return danhSachHoSo;
	}

	/**
	 * Removes the danh sach ho so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh sach ho so
	 * @return the danh sach ho so that was removed
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachHoSo remove(long id)
		throws NoSuchDanhSachHoSoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the danh sach ho so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh sach ho so
	 * @return the danh sach ho so that was removed
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachHoSo remove(Serializable primaryKey)
		throws NoSuchDanhSachHoSoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhSachHoSo danhSachHoSo = (DanhSachHoSo)session.get(DanhSachHoSoImpl.class,
					primaryKey);

			if (danhSachHoSo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhSachHoSoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhSachHoSo);
		}
		catch (NoSuchDanhSachHoSoException nsee) {
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
	protected DanhSachHoSo removeImpl(DanhSachHoSo danhSachHoSo)
		throws SystemException {
		danhSachHoSo = toUnwrappedModel(danhSachHoSo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhSachHoSo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhSachHoSo);

		return danhSachHoSo;
	}

	@Override
	public DanhSachHoSo updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo, boolean merge)
		throws SystemException {
		danhSachHoSo = toUnwrappedModel(danhSachHoSo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhSachHoSo, merge);

			danhSachHoSo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
			DanhSachHoSoImpl.class, danhSachHoSo.getPrimaryKey(), danhSachHoSo);

		return danhSachHoSo;
	}

	protected DanhSachHoSo toUnwrappedModel(DanhSachHoSo danhSachHoSo) {
		if (danhSachHoSo instanceof DanhSachHoSoImpl) {
			return danhSachHoSo;
		}

		DanhSachHoSoImpl danhSachHoSoImpl = new DanhSachHoSoImpl();

		danhSachHoSoImpl.setNew(danhSachHoSo.isNew());
		danhSachHoSoImpl.setPrimaryKey(danhSachHoSo.getPrimaryKey());

		danhSachHoSoImpl.setId(danhSachHoSo.getId());
		danhSachHoSoImpl.setNgayNhanHoSo(danhSachHoSo.getNgayNhanHoSo());
		danhSachHoSoImpl.setTenCoQuanTiepNhan(danhSachHoSo.getTenCoQuanTiepNhan());
		danhSachHoSoImpl.setTenThuTucHanhChinh(danhSachHoSo.getTenThuTucHanhChinh());
		danhSachHoSoImpl.setNgayHenTraKetQua(danhSachHoSo.getNgayHenTraKetQua());
		danhSachHoSoImpl.setNgayTraKetQua(danhSachHoSo.getNgayTraKetQua());
		danhSachHoSoImpl.setHoTenNguoiNopHoSo(danhSachHoSo.getHoTenNguoiNopHoSo());
		danhSachHoSoImpl.setDiaChiThuongTruNguoiNop(danhSachHoSo.getDiaChiThuongTruNguoiNop());
		danhSachHoSoImpl.setSoDienThoaiDiDongNguoiNop(danhSachHoSo.getSoDienThoaiDiDongNguoiNop());
		danhSachHoSoImpl.setNgayKetThucXuLy(danhSachHoSo.getNgayKetThucXuLy());
		danhSachHoSoImpl.setLoaiHoSo(danhSachHoSo.getLoaiHoSo());
		danhSachHoSoImpl.setMaSoBienNhan(danhSachHoSo.getMaSoBienNhan());
		danhSachHoSoImpl.setChuSoHuu(danhSachHoSo.getChuSoHuu());
		danhSachHoSoImpl.setLePhi(danhSachHoSo.getLePhi());
		danhSachHoSoImpl.setPhiHoSo(danhSachHoSo.getPhiHoSo());
		danhSachHoSoImpl.setEmailNguoiNop(danhSachHoSo.getEmailNguoiNop());
		danhSachHoSoImpl.setSoDienThoaiCoDinhNguoiNop(danhSachHoSo.getSoDienThoaiCoDinhNguoiNop());
		danhSachHoSoImpl.setNhomThuTucHanhChinhTen(danhSachHoSo.getNhomThuTucHanhChinhTen());
		danhSachHoSoImpl.setTrangThaiHoSoTen(danhSachHoSo.getTrangThaiHoSoTen());
		danhSachHoSoImpl.setRNum(danhSachHoSo.getRNum());

		return danhSachHoSoImpl;
	}

	/**
	 * Returns the danh sach ho so with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach ho so
	 * @return the danh sach ho so
	 * @throws com.liferay.portal.NoSuchModelException if a danh sach ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachHoSo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach ho so with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException} if it could not be found.
	 *
	 * @param id the primary key of the danh sach ho so
	 * @return the danh sach ho so
	 * @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachHoSo findByPrimaryKey(long id)
		throws NoSuchDanhSachHoSoException, SystemException {
		DanhSachHoSo danhSachHoSo = fetchByPrimaryKey(id);

		if (danhSachHoSo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDanhSachHoSoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return danhSachHoSo;
	}

	/**
	 * Returns the danh sach ho so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh sach ho so
	 * @return the danh sach ho so, or <code>null</code> if a danh sach ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhSachHoSo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh sach ho so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh sach ho so
	 * @return the danh sach ho so, or <code>null</code> if a danh sach ho so with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhSachHoSo fetchByPrimaryKey(long id) throws SystemException {
		DanhSachHoSo danhSachHoSo = (DanhSachHoSo)EntityCacheUtil.getResult(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
				DanhSachHoSoImpl.class, id);

		if (danhSachHoSo == _nullDanhSachHoSo) {
			return null;
		}

		if (danhSachHoSo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhSachHoSo = (DanhSachHoSo)session.get(DanhSachHoSoImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhSachHoSo != null) {
					cacheResult(danhSachHoSo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhSachHoSoModelImpl.ENTITY_CACHE_ENABLED,
						DanhSachHoSoImpl.class, id, _nullDanhSachHoSo);
				}

				closeSession(session);
			}
		}

		return danhSachHoSo;
	}

	/**
	 * Returns all the danh sach ho sos.
	 *
	 * @return the danh sach ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachHoSo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh sach ho sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach ho sos
	 * @param end the upper bound of the range of danh sach ho sos (not inclusive)
	 * @return the range of danh sach ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachHoSo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh sach ho sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh sach ho sos
	 * @param end the upper bound of the range of danh sach ho sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh sach ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhSachHoSo> findAll(int start, int end,
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

		List<DanhSachHoSo> list = (List<DanhSachHoSo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHSACHHOSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHSACHHOSO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhSachHoSo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhSachHoSo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the danh sach ho sos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhSachHoSo danhSachHoSo : findAll()) {
			remove(danhSachHoSo);
		}
	}

	/**
	 * Returns the number of danh sach ho sos.
	 *
	 * @return the number of danh sach ho sos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHSACHHOSO);

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
	 * Initializes the danh sach ho so persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.kios.model.DanhSachHoSo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhSachHoSo>> listenersList = new ArrayList<ModelListener<DanhSachHoSo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhSachHoSo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhSachHoSoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DanhSachCoQuanPersistence.class)
	protected DanhSachCoQuanPersistence danhSachCoQuanPersistence;
	@BeanReference(type = DanhSachHoSoPersistence.class)
	protected DanhSachHoSoPersistence danhSachHoSoPersistence;
	@BeanReference(type = DanhSachThongKePersistence.class)
	protected DanhSachThongKePersistence danhSachThongKePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DANHSACHHOSO = "SELECT danhSachHoSo FROM DanhSachHoSo danhSachHoSo";
	private static final String _SQL_COUNT_DANHSACHHOSO = "SELECT COUNT(danhSachHoSo) FROM DanhSachHoSo danhSachHoSo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhSachHoSo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhSachHoSo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhSachHoSoPersistenceImpl.class);
	private static DanhSachHoSo _nullDanhSachHoSo = new DanhSachHoSoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhSachHoSo> toCacheModel() {
				return _nullDanhSachHoSoCacheModel;
			}
		};

	private static CacheModel<DanhSachHoSo> _nullDanhSachHoSoCacheModel = new CacheModel<DanhSachHoSo>() {
			public DanhSachHoSo toEntityModel() {
				return _nullDanhSachHoSo;
			}
		};
}