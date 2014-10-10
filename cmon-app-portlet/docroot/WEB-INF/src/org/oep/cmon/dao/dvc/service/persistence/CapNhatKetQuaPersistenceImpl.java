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

import org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException;
import org.oep.cmon.dao.dvc.model.CapNhatKetQua;
import org.oep.cmon.dao.dvc.model.impl.CapNhatKetQuaImpl;
import org.oep.cmon.dao.dvc.model.impl.CapNhatKetQuaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cap nhat ket qua service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see CapNhatKetQuaPersistence
 * @see CapNhatKetQuaUtil
 * @generated
 */
public class CapNhatKetQuaPersistenceImpl extends BasePersistenceImpl<CapNhatKetQua>
	implements CapNhatKetQuaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CapNhatKetQuaUtil} to access the cap nhat ket qua persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CapNhatKetQuaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
			CapNhatKetQuaModelImpl.FINDER_CACHE_ENABLED,
			CapNhatKetQuaImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
			CapNhatKetQuaModelImpl.FINDER_CACHE_ENABLED,
			CapNhatKetQuaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
			CapNhatKetQuaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cap nhat ket qua in the entity cache if it is enabled.
	 *
	 * @param capNhatKetQua the cap nhat ket qua
	 */
	public void cacheResult(CapNhatKetQua capNhatKetQua) {
		EntityCacheUtil.putResult(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
			CapNhatKetQuaImpl.class, capNhatKetQua.getPrimaryKey(),
			capNhatKetQua);

		capNhatKetQua.resetOriginalValues();
	}

	/**
	 * Caches the cap nhat ket quas in the entity cache if it is enabled.
	 *
	 * @param capNhatKetQuas the cap nhat ket quas
	 */
	public void cacheResult(List<CapNhatKetQua> capNhatKetQuas) {
		for (CapNhatKetQua capNhatKetQua : capNhatKetQuas) {
			if (EntityCacheUtil.getResult(
						CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
						CapNhatKetQuaImpl.class, capNhatKetQua.getPrimaryKey()) == null) {
				cacheResult(capNhatKetQua);
			}
			else {
				capNhatKetQua.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cap nhat ket quas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CapNhatKetQuaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CapNhatKetQuaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cap nhat ket qua.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CapNhatKetQua capNhatKetQua) {
		EntityCacheUtil.removeResult(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
			CapNhatKetQuaImpl.class, capNhatKetQua.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CapNhatKetQua> capNhatKetQuas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CapNhatKetQua capNhatKetQua : capNhatKetQuas) {
			EntityCacheUtil.removeResult(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
				CapNhatKetQuaImpl.class, capNhatKetQua.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cap nhat ket qua with the primary key. Does not add the cap nhat ket qua to the database.
	 *
	 * @param id the primary key for the new cap nhat ket qua
	 * @return the new cap nhat ket qua
	 */
	public CapNhatKetQua create(long id) {
		CapNhatKetQua capNhatKetQua = new CapNhatKetQuaImpl();

		capNhatKetQua.setNew(true);
		capNhatKetQua.setPrimaryKey(id);

		return capNhatKetQua;
	}

	/**
	 * Removes the cap nhat ket qua with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cap nhat ket qua
	 * @return the cap nhat ket qua that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapNhatKetQua remove(long id)
		throws NoSuchCapNhatKetQuaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cap nhat ket qua with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cap nhat ket qua
	 * @return the cap nhat ket qua that was removed
	 * @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapNhatKetQua remove(Serializable primaryKey)
		throws NoSuchCapNhatKetQuaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CapNhatKetQua capNhatKetQua = (CapNhatKetQua)session.get(CapNhatKetQuaImpl.class,
					primaryKey);

			if (capNhatKetQua == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCapNhatKetQuaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(capNhatKetQua);
		}
		catch (NoSuchCapNhatKetQuaException nsee) {
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
	protected CapNhatKetQua removeImpl(CapNhatKetQua capNhatKetQua)
		throws SystemException {
		capNhatKetQua = toUnwrappedModel(capNhatKetQua);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, capNhatKetQua);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(capNhatKetQua);

		return capNhatKetQua;
	}

	@Override
	public CapNhatKetQua updateImpl(
		org.oep.cmon.dao.dvc.model.CapNhatKetQua capNhatKetQua, boolean merge)
		throws SystemException {
		capNhatKetQua = toUnwrappedModel(capNhatKetQua);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, capNhatKetQua, merge);

			capNhatKetQua.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
			CapNhatKetQuaImpl.class, capNhatKetQua.getPrimaryKey(),
			capNhatKetQua);

		return capNhatKetQua;
	}

	protected CapNhatKetQua toUnwrappedModel(CapNhatKetQua capNhatKetQua) {
		if (capNhatKetQua instanceof CapNhatKetQuaImpl) {
			return capNhatKetQua;
		}

		CapNhatKetQuaImpl capNhatKetQuaImpl = new CapNhatKetQuaImpl();

		capNhatKetQuaImpl.setNew(capNhatKetQua.isNew());
		capNhatKetQuaImpl.setPrimaryKey(capNhatKetQua.getPrimaryKey());

		capNhatKetQuaImpl.setId(capNhatKetQua.getId());
		capNhatKetQuaImpl.setTenBang(capNhatKetQua.getTenBang());
		capNhatKetQuaImpl.setBanGhiId(capNhatKetQua.getBanGhiId());
		capNhatKetQuaImpl.setHanhDong(capNhatKetQua.getHanhDong());
		capNhatKetQuaImpl.setNgayTao(capNhatKetQua.getNgayTao());
		capNhatKetQuaImpl.setNguoiTao(capNhatKetQua.getNguoiTao());
		capNhatKetQuaImpl.setNgaySua(capNhatKetQua.getNgaySua());
		capNhatKetQuaImpl.setNguoiSua(capNhatKetQua.getNguoiSua());
		capNhatKetQuaImpl.setDaXoa(capNhatKetQua.getDaXoa());
		capNhatKetQuaImpl.setHosoTTHCCId(capNhatKetQua.getHosoTTHCCId());

		return capNhatKetQuaImpl;
	}

	/**
	 * Returns the cap nhat ket qua with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap nhat ket qua
	 * @return the cap nhat ket qua
	 * @throws com.liferay.portal.NoSuchModelException if a cap nhat ket qua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapNhatKetQua findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap nhat ket qua with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException} if it could not be found.
	 *
	 * @param id the primary key of the cap nhat ket qua
	 * @return the cap nhat ket qua
	 * @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapNhatKetQua findByPrimaryKey(long id)
		throws NoSuchCapNhatKetQuaException, SystemException {
		CapNhatKetQua capNhatKetQua = fetchByPrimaryKey(id);

		if (capNhatKetQua == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCapNhatKetQuaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return capNhatKetQua;
	}

	/**
	 * Returns the cap nhat ket qua with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap nhat ket qua
	 * @return the cap nhat ket qua, or <code>null</code> if a cap nhat ket qua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapNhatKetQua fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap nhat ket qua with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cap nhat ket qua
	 * @return the cap nhat ket qua, or <code>null</code> if a cap nhat ket qua with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapNhatKetQua fetchByPrimaryKey(long id) throws SystemException {
		CapNhatKetQua capNhatKetQua = (CapNhatKetQua)EntityCacheUtil.getResult(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
				CapNhatKetQuaImpl.class, id);

		if (capNhatKetQua == _nullCapNhatKetQua) {
			return null;
		}

		if (capNhatKetQua == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				capNhatKetQua = (CapNhatKetQua)session.get(CapNhatKetQuaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (capNhatKetQua != null) {
					cacheResult(capNhatKetQua);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CapNhatKetQuaModelImpl.ENTITY_CACHE_ENABLED,
						CapNhatKetQuaImpl.class, id, _nullCapNhatKetQua);
				}

				closeSession(session);
			}
		}

		return capNhatKetQua;
	}

	/**
	 * Returns all the cap nhat ket quas.
	 *
	 * @return the cap nhat ket quas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapNhatKetQua> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap nhat ket quas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap nhat ket quas
	 * @param end the upper bound of the range of cap nhat ket quas (not inclusive)
	 * @return the range of cap nhat ket quas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapNhatKetQua> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap nhat ket quas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap nhat ket quas
	 * @param end the upper bound of the range of cap nhat ket quas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cap nhat ket quas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapNhatKetQua> findAll(int start, int end,
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

		List<CapNhatKetQua> list = (List<CapNhatKetQua>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAPNHATKETQUA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAPNHATKETQUA.concat(CapNhatKetQuaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CapNhatKetQua>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CapNhatKetQua>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cap nhat ket quas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CapNhatKetQua capNhatKetQua : findAll()) {
			remove(capNhatKetQua);
		}
	}

	/**
	 * Returns the number of cap nhat ket quas.
	 *
	 * @return the number of cap nhat ket quas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAPNHATKETQUA);

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
	 * Initializes the cap nhat ket qua persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.dvc.model.CapNhatKetQua")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CapNhatKetQua>> listenersList = new ArrayList<ModelListener<CapNhatKetQua>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CapNhatKetQua>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CapNhatKetQuaImpl.class.getName());
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
	private static final String _SQL_SELECT_CAPNHATKETQUA = "SELECT capNhatKetQua FROM CapNhatKetQua capNhatKetQua";
	private static final String _SQL_COUNT_CAPNHATKETQUA = "SELECT COUNT(capNhatKetQua) FROM CapNhatKetQua capNhatKetQua";
	private static final String _ORDER_BY_ENTITY_ALIAS = "capNhatKetQua.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CapNhatKetQua exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CapNhatKetQuaPersistenceImpl.class);
	private static CapNhatKetQua _nullCapNhatKetQua = new CapNhatKetQuaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CapNhatKetQua> toCacheModel() {
				return _nullCapNhatKetQuaCacheModel;
			}
		};

	private static CacheModel<CapNhatKetQua> _nullCapNhatKetQuaCacheModel = new CacheModel<CapNhatKetQua>() {
			public CapNhatKetQua toEntityModel() {
				return _nullCapNhatKetQua;
			}
		};
}