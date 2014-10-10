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

package org.oep.cmon.dao.report.service.persistence;

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

import org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException;
import org.oep.cmon.dao.report.model.DanhMucBaoCao;
import org.oep.cmon.dao.report.model.impl.DanhMucBaoCaoImpl;
import org.oep.cmon.dao.report.model.impl.DanhMucBaoCaoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the danh muc bao cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhMucBaoCaoPersistence
 * @see DanhMucBaoCaoUtil
 * @generated
 */
public class DanhMucBaoCaoPersistenceImpl extends BasePersistenceImpl<DanhMucBaoCao>
	implements DanhMucBaoCaoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanhMucBaoCaoUtil} to access the danh muc bao cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanhMucBaoCaoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucBaoCaoModelImpl.FINDER_CACHE_ENABLED,
			DanhMucBaoCaoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucBaoCaoModelImpl.FINDER_CACHE_ENABLED,
			DanhMucBaoCaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucBaoCaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the danh muc bao cao in the entity cache if it is enabled.
	 *
	 * @param danhMucBaoCao the danh muc bao cao
	 */
	public void cacheResult(DanhMucBaoCao danhMucBaoCao) {
		EntityCacheUtil.putResult(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucBaoCaoImpl.class, danhMucBaoCao.getPrimaryKey(),
			danhMucBaoCao);

		danhMucBaoCao.resetOriginalValues();
	}

	/**
	 * Caches the danh muc bao caos in the entity cache if it is enabled.
	 *
	 * @param danhMucBaoCaos the danh muc bao caos
	 */
	public void cacheResult(List<DanhMucBaoCao> danhMucBaoCaos) {
		for (DanhMucBaoCao danhMucBaoCao : danhMucBaoCaos) {
			if (EntityCacheUtil.getResult(
						DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucBaoCaoImpl.class, danhMucBaoCao.getPrimaryKey()) == null) {
				cacheResult(danhMucBaoCao);
			}
			else {
				danhMucBaoCao.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh muc bao caos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanhMucBaoCaoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanhMucBaoCaoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh muc bao cao.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhMucBaoCao danhMucBaoCao) {
		EntityCacheUtil.removeResult(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucBaoCaoImpl.class, danhMucBaoCao.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DanhMucBaoCao> danhMucBaoCaos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhMucBaoCao danhMucBaoCao : danhMucBaoCaos) {
			EntityCacheUtil.removeResult(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucBaoCaoImpl.class, danhMucBaoCao.getPrimaryKey());
		}
	}

	/**
	 * Creates a new danh muc bao cao with the primary key. Does not add the danh muc bao cao to the database.
	 *
	 * @param ID the primary key for the new danh muc bao cao
	 * @return the new danh muc bao cao
	 */
	public DanhMucBaoCao create(long ID) {
		DanhMucBaoCao danhMucBaoCao = new DanhMucBaoCaoImpl();

		danhMucBaoCao.setNew(true);
		danhMucBaoCao.setPrimaryKey(ID);

		return danhMucBaoCao;
	}

	/**
	 * Removes the danh muc bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the danh muc bao cao
	 * @return the danh muc bao cao that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException if a danh muc bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucBaoCao remove(long ID)
		throws NoSuchDanhMucBaoCaoException, SystemException {
		return remove(Long.valueOf(ID));
	}

	/**
	 * Removes the danh muc bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh muc bao cao
	 * @return the danh muc bao cao that was removed
	 * @throws org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException if a danh muc bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucBaoCao remove(Serializable primaryKey)
		throws NoSuchDanhMucBaoCaoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanhMucBaoCao danhMucBaoCao = (DanhMucBaoCao)session.get(DanhMucBaoCaoImpl.class,
					primaryKey);

			if (danhMucBaoCao == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhMucBaoCaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danhMucBaoCao);
		}
		catch (NoSuchDanhMucBaoCaoException nsee) {
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
	protected DanhMucBaoCao removeImpl(DanhMucBaoCao danhMucBaoCao)
		throws SystemException {
		danhMucBaoCao = toUnwrappedModel(danhMucBaoCao);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danhMucBaoCao);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danhMucBaoCao);

		return danhMucBaoCao;
	}

	@Override
	public DanhMucBaoCao updateImpl(
		org.oep.cmon.dao.report.model.DanhMucBaoCao danhMucBaoCao, boolean merge)
		throws SystemException {
		danhMucBaoCao = toUnwrappedModel(danhMucBaoCao);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danhMucBaoCao, merge);

			danhMucBaoCao.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucBaoCaoImpl.class, danhMucBaoCao.getPrimaryKey(),
			danhMucBaoCao);

		return danhMucBaoCao;
	}

	protected DanhMucBaoCao toUnwrappedModel(DanhMucBaoCao danhMucBaoCao) {
		if (danhMucBaoCao instanceof DanhMucBaoCaoImpl) {
			return danhMucBaoCao;
		}

		DanhMucBaoCaoImpl danhMucBaoCaoImpl = new DanhMucBaoCaoImpl();

		danhMucBaoCaoImpl.setNew(danhMucBaoCao.isNew());
		danhMucBaoCaoImpl.setPrimaryKey(danhMucBaoCao.getPrimaryKey());

		danhMucBaoCaoImpl.setID(danhMucBaoCao.getID());
		danhMucBaoCaoImpl.setTENBAOCAO(danhMucBaoCao.getTENBAOCAO());
		danhMucBaoCaoImpl.setDUONGDAN(danhMucBaoCao.getDUONGDAN());
		danhMucBaoCaoImpl.setORDERS(danhMucBaoCao.getORDERS());
		danhMucBaoCaoImpl.setSTATUS(danhMucBaoCao.getSTATUS());
		danhMucBaoCaoImpl.setPUBLISH(danhMucBaoCao.getPUBLISH());

		return danhMucBaoCaoImpl;
	}

	/**
	 * Returns the danh muc bao cao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc bao cao
	 * @return the danh muc bao cao
	 * @throws com.liferay.portal.NoSuchModelException if a danh muc bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucBaoCao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc bao cao with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException} if it could not be found.
	 *
	 * @param ID the primary key of the danh muc bao cao
	 * @return the danh muc bao cao
	 * @throws org.oep.cmon.dao.report.NoSuchDanhMucBaoCaoException if a danh muc bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucBaoCao findByPrimaryKey(long ID)
		throws NoSuchDanhMucBaoCaoException, SystemException {
		DanhMucBaoCao danhMucBaoCao = fetchByPrimaryKey(ID);

		if (danhMucBaoCao == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ID);
			}

			throw new NoSuchDanhMucBaoCaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ID);
		}

		return danhMucBaoCao;
	}

	/**
	 * Returns the danh muc bao cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc bao cao
	 * @return the danh muc bao cao, or <code>null</code> if a danh muc bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanhMucBaoCao fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the danh muc bao cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the danh muc bao cao
	 * @return the danh muc bao cao, or <code>null</code> if a danh muc bao cao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanhMucBaoCao fetchByPrimaryKey(long ID) throws SystemException {
		DanhMucBaoCao danhMucBaoCao = (DanhMucBaoCao)EntityCacheUtil.getResult(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
				DanhMucBaoCaoImpl.class, ID);

		if (danhMucBaoCao == _nullDanhMucBaoCao) {
			return null;
		}

		if (danhMucBaoCao == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danhMucBaoCao = (DanhMucBaoCao)session.get(DanhMucBaoCaoImpl.class,
						Long.valueOf(ID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danhMucBaoCao != null) {
					cacheResult(danhMucBaoCao);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanhMucBaoCaoModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucBaoCaoImpl.class, ID, _nullDanhMucBaoCao);
				}

				closeSession(session);
			}
		}

		return danhMucBaoCao;
	}

	/**
	 * Returns all the danh muc bao caos.
	 *
	 * @return the danh muc bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucBaoCao> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh muc bao caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc bao caos
	 * @param end the upper bound of the range of danh muc bao caos (not inclusive)
	 * @return the range of danh muc bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucBaoCao> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh muc bao caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh muc bao caos
	 * @param end the upper bound of the range of danh muc bao caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh muc bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanhMucBaoCao> findAll(int start, int end,
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

		List<DanhMucBaoCao> list = (List<DanhMucBaoCao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANHMUCBAOCAO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHMUCBAOCAO.concat(DanhMucBaoCaoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanhMucBaoCao>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanhMucBaoCao>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the danh muc bao caos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanhMucBaoCao danhMucBaoCao : findAll()) {
			remove(danhMucBaoCao);
		}
	}

	/**
	 * Returns the number of danh muc bao caos.
	 *
	 * @return the number of danh muc bao caos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHMUCBAOCAO);

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
	 * Initializes the danh muc bao cao persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.report.model.DanhMucBaoCao")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanhMucBaoCao>> listenersList = new ArrayList<ModelListener<DanhMucBaoCao>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanhMucBaoCao>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DanhMucBaoCaoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BaocaochitietPersistence.class)
	protected BaocaochitietPersistence baocaochitietPersistence;
	@BeanReference(type = CongChuc2RolePersistence.class)
	protected CongChuc2RolePersistence congChuc2RolePersistence;
	@BeanReference(type = CoQuanQuanLy2LinhVucPersistence.class)
	protected CoQuanQuanLy2LinhVucPersistence coQuanQuanLy2LinhVucPersistence;
	@BeanReference(type = DanhMucBaoCaoPersistence.class)
	protected DanhMucBaoCaoPersistence danhMucBaoCaoPersistence;
	@BeanReference(type = DanhMucRolePersistence.class)
	protected DanhMucRolePersistence danhMucRolePersistence;
	@BeanReference(type = Lephi_chitietPersistence.class)
	protected Lephi_chitietPersistence lephi_chitietPersistence;
	@BeanReference(type = Lephi_linhvucPersistence.class)
	protected Lephi_linhvucPersistence lephi_linhvucPersistence;
	@BeanReference(type = Lephi_tonghopPersistence.class)
	protected Lephi_tonghopPersistence lephi_tonghopPersistence;
	@BeanReference(type = ReportThongKePersistence.class)
	protected ReportThongKePersistence reportThongKePersistence;
	@BeanReference(type = ReportTongHopPersistence.class)
	protected ReportTongHopPersistence reportTongHopPersistence;
	@BeanReference(type = ReportTongHopChiTietPersistence.class)
	protected ReportTongHopChiTietPersistence reportTongHopChiTietPersistence;
	@BeanReference(type = Role2BaoCaoPersistence.class)
	protected Role2BaoCaoPersistence role2BaoCaoPersistence;
	@BeanReference(type = Role2DonViBaoCaoPersistence.class)
	protected Role2DonViBaoCaoPersistence role2DonViBaoCaoPersistence;
	@BeanReference(type = Role2NhomTTHCPersistence.class)
	protected Role2NhomTTHCPersistence role2NhomTTHCPersistence;
	@BeanReference(type = Role2TTHCPersistence.class)
	protected Role2TTHCPersistence role2TTHCPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DANHMUCBAOCAO = "SELECT danhMucBaoCao FROM DanhMucBaoCao danhMucBaoCao";
	private static final String _SQL_COUNT_DANHMUCBAOCAO = "SELECT COUNT(danhMucBaoCao) FROM DanhMucBaoCao danhMucBaoCao";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danhMucBaoCao.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanhMucBaoCao exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanhMucBaoCaoPersistenceImpl.class);
	private static DanhMucBaoCao _nullDanhMucBaoCao = new DanhMucBaoCaoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanhMucBaoCao> toCacheModel() {
				return _nullDanhMucBaoCaoCacheModel;
			}
		};

	private static CacheModel<DanhMucBaoCao> _nullDanhMucBaoCaoCacheModel = new CacheModel<DanhMucBaoCao>() {
			public DanhMucBaoCao toEntityModel() {
				return _nullDanhMucBaoCao;
			}
		};
}