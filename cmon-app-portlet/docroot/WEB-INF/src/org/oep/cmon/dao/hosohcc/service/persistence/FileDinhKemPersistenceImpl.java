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

package org.oep.cmon.dao.hosohcc.service.persistence;

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

import org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.impl.FileDinhKemImpl;
import org.oep.cmon.dao.hosohcc.model.impl.FileDinhKemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the file dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see FileDinhKemPersistence
 * @see FileDinhKemUtil
 * @generated
 */
public class FileDinhKemPersistenceImpl extends BasePersistenceImpl<FileDinhKem>
	implements FileDinhKemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FileDinhKemUtil} to access the file dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FileDinhKemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FileDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FileDinhKemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			FileDinhKemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the file dinh kem in the entity cache if it is enabled.
	 *
	 * @param fileDinhKem the file dinh kem
	 */
	public void cacheResult(FileDinhKem fileDinhKem) {
		EntityCacheUtil.putResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			FileDinhKemImpl.class, fileDinhKem.getPrimaryKey(), fileDinhKem);

		fileDinhKem.resetOriginalValues();
	}

	/**
	 * Caches the file dinh kems in the entity cache if it is enabled.
	 *
	 * @param fileDinhKems the file dinh kems
	 */
	public void cacheResult(List<FileDinhKem> fileDinhKems) {
		for (FileDinhKem fileDinhKem : fileDinhKems) {
			if (EntityCacheUtil.getResult(
						FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
						FileDinhKemImpl.class, fileDinhKem.getPrimaryKey()) == null) {
				cacheResult(fileDinhKem);
			}
			else {
				fileDinhKem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all file dinh kems.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FileDinhKemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FileDinhKemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the file dinh kem.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileDinhKem fileDinhKem) {
		EntityCacheUtil.removeResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			FileDinhKemImpl.class, fileDinhKem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FileDinhKem> fileDinhKems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FileDinhKem fileDinhKem : fileDinhKems) {
			EntityCacheUtil.removeResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
				FileDinhKemImpl.class, fileDinhKem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new file dinh kem with the primary key. Does not add the file dinh kem to the database.
	 *
	 * @param id the primary key for the new file dinh kem
	 * @return the new file dinh kem
	 */
	public FileDinhKem create(long id) {
		FileDinhKem fileDinhKem = new FileDinhKemImpl();

		fileDinhKem.setNew(true);
		fileDinhKem.setPrimaryKey(id);

		return fileDinhKem;
	}

	/**
	 * Removes the file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the file dinh kem
	 * @return the file dinh kem that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException if a file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FileDinhKem remove(long id)
		throws NoSuchFileDinhKemException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file dinh kem
	 * @return the file dinh kem that was removed
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException if a file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileDinhKem remove(Serializable primaryKey)
		throws NoSuchFileDinhKemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FileDinhKem fileDinhKem = (FileDinhKem)session.get(FileDinhKemImpl.class,
					primaryKey);

			if (fileDinhKem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileDinhKemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fileDinhKem);
		}
		catch (NoSuchFileDinhKemException nsee) {
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
	protected FileDinhKem removeImpl(FileDinhKem fileDinhKem)
		throws SystemException {
		fileDinhKem = toUnwrappedModel(fileDinhKem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, fileDinhKem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(fileDinhKem);

		return fileDinhKem;
	}

	@Override
	public FileDinhKem updateImpl(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem, boolean merge)
		throws SystemException {
		fileDinhKem = toUnwrappedModel(fileDinhKem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, fileDinhKem, merge);

			fileDinhKem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
			FileDinhKemImpl.class, fileDinhKem.getPrimaryKey(), fileDinhKem);

		return fileDinhKem;
	}

	protected FileDinhKem toUnwrappedModel(FileDinhKem fileDinhKem) {
		if (fileDinhKem instanceof FileDinhKemImpl) {
			return fileDinhKem;
		}

		FileDinhKemImpl fileDinhKemImpl = new FileDinhKemImpl();

		fileDinhKemImpl.setNew(fileDinhKem.isNew());
		fileDinhKemImpl.setPrimaryKey(fileDinhKem.getPrimaryKey());

		fileDinhKemImpl.setId(fileDinhKem.getId());
		fileDinhKemImpl.setSoBanGiay(fileDinhKem.getSoBanGiay());
		fileDinhKemImpl.setDaDoiChieu(fileDinhKem.getDaDoiChieu());
		fileDinhKemImpl.setTrangThaiHoSoTaiThoiDiemDinhKem(fileDinhKem.getTrangThaiHoSoTaiThoiDiemDinhKem());
		fileDinhKemImpl.setNoiLuuTruTaiLieuId(fileDinhKem.getNoiLuuTruTaiLieuId());
		fileDinhKemImpl.setCanBoId(fileDinhKem.getCanBoId());
		fileDinhKemImpl.setHoSoTTHCCongId(fileDinhKem.getHoSoTTHCCongId());
		fileDinhKemImpl.setThuTuc2GiayToId(fileDinhKem.getThuTuc2GiayToId());
		fileDinhKemImpl.setDanhMucGiayToId(fileDinhKem.getDanhMucGiayToId());
		fileDinhKemImpl.setNgayUpload(fileDinhKem.getNgayUpload());
		fileDinhKemImpl.setNgaySua(fileDinhKem.getNgaySua());
		fileDinhKemImpl.setNguoiUpload(fileDinhKem.getNguoiUpload());
		fileDinhKemImpl.setMaLoaiTaiLieuDuocThayThe(fileDinhKem.getMaLoaiTaiLieuDuocThayThe());
		fileDinhKemImpl.setNguoiSua(fileDinhKem.getNguoiSua());
		fileDinhKemImpl.setXoa(fileDinhKem.getXoa());
		fileDinhKemImpl.setDaTra(fileDinhKem.getDaTra());
		fileDinhKemImpl.setBanChinh(fileDinhKem.getBanChinh());
		fileDinhKemImpl.setGhiChu(fileDinhKem.getGhiChu());

		return fileDinhKemImpl;
	}

	/**
	 * Returns the file dinh kem with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the file dinh kem
	 * @return the file dinh kem
	 * @throws com.liferay.portal.NoSuchModelException if a file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileDinhKem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the file dinh kem with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException} if it could not be found.
	 *
	 * @param id the primary key of the file dinh kem
	 * @return the file dinh kem
	 * @throws org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException if a file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FileDinhKem findByPrimaryKey(long id)
		throws NoSuchFileDinhKemException, SystemException {
		FileDinhKem fileDinhKem = fetchByPrimaryKey(id);

		if (fileDinhKem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchFileDinhKemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return fileDinhKem;
	}

	/**
	 * Returns the file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file dinh kem
	 * @return the file dinh kem, or <code>null</code> if a file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileDinhKem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the file dinh kem
	 * @return the file dinh kem, or <code>null</code> if a file dinh kem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FileDinhKem fetchByPrimaryKey(long id) throws SystemException {
		FileDinhKem fileDinhKem = (FileDinhKem)EntityCacheUtil.getResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
				FileDinhKemImpl.class, id);

		if (fileDinhKem == _nullFileDinhKem) {
			return null;
		}

		if (fileDinhKem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				fileDinhKem = (FileDinhKem)session.get(FileDinhKemImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (fileDinhKem != null) {
					cacheResult(fileDinhKem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
						FileDinhKemImpl.class, id, _nullFileDinhKem);
				}

				closeSession(session);
			}
		}

		return fileDinhKem;
	}

	/**
	 * Returns all the file dinh kems.
	 *
	 * @return the file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<FileDinhKem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of file dinh kems
	 * @param end the upper bound of the range of file dinh kems (not inclusive)
	 * @return the range of file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<FileDinhKem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of file dinh kems
	 * @param end the upper bound of the range of file dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public List<FileDinhKem> findAll(int start, int end,
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

		List<FileDinhKem> list = (List<FileDinhKem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FILEDINHKEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FILEDINHKEM.concat(FileDinhKemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FileDinhKem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FileDinhKem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the file dinh kems from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FileDinhKem fileDinhKem : findAll()) {
			remove(fileDinhKem);
		}
	}

	/**
	 * Returns the number of file dinh kems.
	 *
	 * @return the number of file dinh kems
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FILEDINHKEM);

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
	 * Initializes the file dinh kem persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.hosohcc.model.FileDinhKem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FileDinhKem>> listenersList = new ArrayList<ModelListener<FileDinhKem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FileDinhKem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FileDinhKemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FileDinhKemPersistence.class)
	protected FileDinhKemPersistence fileDinhKemPersistence;
	@BeanReference(type = HoSoAnhXaPersistence.class)
	protected HoSoAnhXaPersistence hoSoAnhXaPersistence;
	@BeanReference(type = HoSoTTHCCongPersistence.class)
	protected HoSoTTHCCongPersistence hoSoTTHCCongPersistence;
	@BeanReference(type = TrangThaiHoSoPersistence.class)
	protected TrangThaiHoSoPersistence trangThaiHoSoPersistence;
	@BeanReference(type = YKienTraoDoiPersistence.class)
	protected YKienTraoDoiPersistence yKienTraoDoiPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FILEDINHKEM = "SELECT fileDinhKem FROM FileDinhKem fileDinhKem";
	private static final String _SQL_COUNT_FILEDINHKEM = "SELECT COUNT(fileDinhKem) FROM FileDinhKem fileDinhKem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fileDinhKem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FileDinhKem exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FileDinhKemPersistenceImpl.class);
	private static FileDinhKem _nullFileDinhKem = new FileDinhKemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FileDinhKem> toCacheModel() {
				return _nullFileDinhKemCacheModel;
			}
		};

	private static CacheModel<FileDinhKem> _nullFileDinhKemCacheModel = new CacheModel<FileDinhKem>() {
			public FileDinhKem toEntityModel() {
				return _nullFileDinhKem;
			}
		};
}