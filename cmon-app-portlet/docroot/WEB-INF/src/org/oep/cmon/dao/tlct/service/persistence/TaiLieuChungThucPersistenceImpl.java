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

package org.oep.cmon.dao.tlct.service.persistence;

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

import org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.impl.TaiLieuChungThucImpl;
import org.oep.cmon.dao.tlct.model.impl.TaiLieuChungThucModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tai lieu chung thuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiLieuChungThucPersistence
 * @see TaiLieuChungThucUtil
 * @generated
 */
public class TaiLieuChungThucPersistenceImpl extends BasePersistenceImpl<TaiLieuChungThuc>
	implements TaiLieuChungThucPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaiLieuChungThucUtil} to access the tai lieu chung thuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaiLieuChungThucImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI =
		new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED,
			TaiLieuChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByHosotthcCongIdAndLoai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI =
		new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED,
			TaiLieuChungThucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByHosotthcCongIdAndLoai",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TaiLieuChungThucModelImpl.HOSOTTHCCID_COLUMN_BITMASK |
			TaiLieuChungThucModelImpl.LOAI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOSOTTHCCONGIDANDLOAI = new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByHosotthcCongIdAndLoai",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NOILUUTRUID = new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED,
			TaiLieuChungThucImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBynoiLuuTruId", new String[] { Long.class.getName() },
			TaiLieuChungThucModelImpl.NOILUUTRUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOILUUTRUID = new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynoiLuuTruId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED,
			TaiLieuChungThucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED,
			TaiLieuChungThucImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tai lieu chung thuc in the entity cache if it is enabled.
	 *
	 * @param taiLieuChungThuc the tai lieu chung thuc
	 */
	public void cacheResult(TaiLieuChungThuc taiLieuChungThuc) {
		EntityCacheUtil.putResult(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucImpl.class, taiLieuChungThuc.getPrimaryKey(),
			taiLieuChungThuc);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
			new Object[] { Long.valueOf(taiLieuChungThuc.getNoiLuuTruId()) },
			taiLieuChungThuc);

		taiLieuChungThuc.resetOriginalValues();
	}

	/**
	 * Caches the tai lieu chung thucs in the entity cache if it is enabled.
	 *
	 * @param taiLieuChungThucs the tai lieu chung thucs
	 */
	public void cacheResult(List<TaiLieuChungThuc> taiLieuChungThucs) {
		for (TaiLieuChungThuc taiLieuChungThuc : taiLieuChungThucs) {
			if (EntityCacheUtil.getResult(
						TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
						TaiLieuChungThucImpl.class,
						taiLieuChungThuc.getPrimaryKey()) == null) {
				cacheResult(taiLieuChungThuc);
			}
			else {
				taiLieuChungThuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tai lieu chung thucs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaiLieuChungThucImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaiLieuChungThucImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tai lieu chung thuc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaiLieuChungThuc taiLieuChungThuc) {
		EntityCacheUtil.removeResult(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucImpl.class, taiLieuChungThuc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(taiLieuChungThuc);
	}

	@Override
	public void clearCache(List<TaiLieuChungThuc> taiLieuChungThucs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaiLieuChungThuc taiLieuChungThuc : taiLieuChungThucs) {
			EntityCacheUtil.removeResult(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
				TaiLieuChungThucImpl.class, taiLieuChungThuc.getPrimaryKey());

			clearUniqueFindersCache(taiLieuChungThuc);
		}
	}

	protected void clearUniqueFindersCache(TaiLieuChungThuc taiLieuChungThuc) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
			new Object[] { Long.valueOf(taiLieuChungThuc.getNoiLuuTruId()) });
	}

	/**
	 * Creates a new tai lieu chung thuc with the primary key. Does not add the tai lieu chung thuc to the database.
	 *
	 * @param id the primary key for the new tai lieu chung thuc
	 * @return the new tai lieu chung thuc
	 */
	public TaiLieuChungThuc create(long id) {
		TaiLieuChungThuc taiLieuChungThuc = new TaiLieuChungThucImpl();

		taiLieuChungThuc.setNew(true);
		taiLieuChungThuc.setPrimaryKey(id);

		return taiLieuChungThuc;
	}

	/**
	 * Removes the tai lieu chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tai lieu chung thuc
	 * @return the tai lieu chung thuc that was removed
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc remove(long id)
		throws NoSuchTaiLieuChungThucException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tai lieu chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tai lieu chung thuc
	 * @return the tai lieu chung thuc that was removed
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiLieuChungThuc remove(Serializable primaryKey)
		throws NoSuchTaiLieuChungThucException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaiLieuChungThuc taiLieuChungThuc = (TaiLieuChungThuc)session.get(TaiLieuChungThucImpl.class,
					primaryKey);

			if (taiLieuChungThuc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaiLieuChungThucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taiLieuChungThuc);
		}
		catch (NoSuchTaiLieuChungThucException nsee) {
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
	protected TaiLieuChungThuc removeImpl(TaiLieuChungThuc taiLieuChungThuc)
		throws SystemException {
		taiLieuChungThuc = toUnwrappedModel(taiLieuChungThuc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, taiLieuChungThuc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(taiLieuChungThuc);

		return taiLieuChungThuc;
	}

	@Override
	public TaiLieuChungThuc updateImpl(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc,
		boolean merge) throws SystemException {
		taiLieuChungThuc = toUnwrappedModel(taiLieuChungThuc);

		boolean isNew = taiLieuChungThuc.isNew();

		TaiLieuChungThucModelImpl taiLieuChungThucModelImpl = (TaiLieuChungThucModelImpl)taiLieuChungThuc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taiLieuChungThuc, merge);

			taiLieuChungThuc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaiLieuChungThucModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((taiLieuChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(taiLieuChungThucModelImpl.getOriginalHoSoTTHCCId()),
						Integer.valueOf(taiLieuChungThucModelImpl.getOriginalLoai())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGIDANDLOAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI,
					args);

				args = new Object[] {
						Long.valueOf(taiLieuChungThucModelImpl.getHoSoTTHCCId()),
						Integer.valueOf(taiLieuChungThucModelImpl.getLoai())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGIDANDLOAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI,
					args);
			}
		}

		EntityCacheUtil.putResult(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
			TaiLieuChungThucImpl.class, taiLieuChungThuc.getPrimaryKey(),
			taiLieuChungThuc);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
				new Object[] { Long.valueOf(taiLieuChungThuc.getNoiLuuTruId()) },
				taiLieuChungThuc);
		}
		else {
			if ((taiLieuChungThucModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NOILUUTRUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(taiLieuChungThucModelImpl.getOriginalNoiLuuTruId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
					new Object[] { Long.valueOf(
							taiLieuChungThuc.getNoiLuuTruId()) },
					taiLieuChungThuc);
			}
		}

		return taiLieuChungThuc;
	}

	protected TaiLieuChungThuc toUnwrappedModel(
		TaiLieuChungThuc taiLieuChungThuc) {
		if (taiLieuChungThuc instanceof TaiLieuChungThucImpl) {
			return taiLieuChungThuc;
		}

		TaiLieuChungThucImpl taiLieuChungThucImpl = new TaiLieuChungThucImpl();

		taiLieuChungThucImpl.setNew(taiLieuChungThuc.isNew());
		taiLieuChungThucImpl.setPrimaryKey(taiLieuChungThuc.getPrimaryKey());

		taiLieuChungThucImpl.setId(taiLieuChungThuc.getId());
		taiLieuChungThucImpl.setTen(taiLieuChungThuc.getTen());
		taiLieuChungThucImpl.setGhiChu(taiLieuChungThuc.getGhiChu());
		taiLieuChungThucImpl.setNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId());
		taiLieuChungThucImpl.setNgayUpload(taiLieuChungThuc.getNgayUpload());
		taiLieuChungThucImpl.setPhienBan(taiLieuChungThuc.getPhienBan());
		taiLieuChungThucImpl.setNgayDuyet(taiLieuChungThuc.getNgayDuyet());
		taiLieuChungThucImpl.setHieuLucTuNgay(taiLieuChungThuc.getHieuLucTuNgay());
		taiLieuChungThucImpl.setHieuLucDenNgay(taiLieuChungThuc.getHieuLucDenNgay());
		taiLieuChungThucImpl.setNgaySua(taiLieuChungThuc.getNgaySua());
		taiLieuChungThucImpl.setNguoiSua(taiLieuChungThuc.getNguoiSua());
		taiLieuChungThucImpl.setDanhMucGiayToId(taiLieuChungThuc.getDanhMucGiayToId());
		taiLieuChungThucImpl.setTrangThai(taiLieuChungThuc.getTrangThai());
		taiLieuChungThucImpl.setChuSohuuId(taiLieuChungThuc.getChuSohuuId());
		taiLieuChungThucImpl.setNguoiUploadId(taiLieuChungThuc.getNguoiUploadId());
		taiLieuChungThucImpl.setNguoiduyetId(taiLieuChungThuc.getNguoiduyetId());
		taiLieuChungThucImpl.setHoSoTTHCCId(taiLieuChungThuc.getHoSoTTHCCId());
		taiLieuChungThucImpl.setMaUngDung(taiLieuChungThuc.getMaUngDung());
		taiLieuChungThucImpl.setLoai(taiLieuChungThuc.getLoai());

		return taiLieuChungThucImpl;
	}

	/**
	 * Returns the tai lieu chung thuc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai lieu chung thuc
	 * @return the tai lieu chung thuc
	 * @throws com.liferay.portal.NoSuchModelException if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiLieuChungThuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai lieu chung thuc with the primary key or throws a {@link org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException} if it could not be found.
	 *
	 * @param id the primary key of the tai lieu chung thuc
	 * @return the tai lieu chung thuc
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc findByPrimaryKey(long id)
		throws NoSuchTaiLieuChungThucException, SystemException {
		TaiLieuChungThuc taiLieuChungThuc = fetchByPrimaryKey(id);

		if (taiLieuChungThuc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTaiLieuChungThucException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return taiLieuChungThuc;
	}

	/**
	 * Returns the tai lieu chung thuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai lieu chung thuc
	 * @return the tai lieu chung thuc, or <code>null</code> if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaiLieuChungThuc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tai lieu chung thuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tai lieu chung thuc
	 * @return the tai lieu chung thuc, or <code>null</code> if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc fetchByPrimaryKey(long id)
		throws SystemException {
		TaiLieuChungThuc taiLieuChungThuc = (TaiLieuChungThuc)EntityCacheUtil.getResult(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
				TaiLieuChungThucImpl.class, id);

		if (taiLieuChungThuc == _nullTaiLieuChungThuc) {
			return null;
		}

		if (taiLieuChungThuc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				taiLieuChungThuc = (TaiLieuChungThuc)session.get(TaiLieuChungThucImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (taiLieuChungThuc != null) {
					cacheResult(taiLieuChungThuc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TaiLieuChungThucModelImpl.ENTITY_CACHE_ENABLED,
						TaiLieuChungThucImpl.class, id, _nullTaiLieuChungThuc);
				}

				closeSession(session);
			}
		}

		return taiLieuChungThuc;
	}

	/**
	 * Returns all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @return the matching tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		Long hoSoTTHCCId, int loai) throws SystemException {
		return findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @param start the lower bound of the range of tai lieu chung thucs
	 * @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	 * @return the range of matching tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		Long hoSoTTHCCId, int loai, int start, int end)
		throws SystemException {
		return findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @param start the lower bound of the range of tai lieu chung thucs
	 * @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		Long hoSoTTHCCId, int loai, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI;
			finderArgs = new Object[] { hoSoTTHCCId, loai };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSOTTHCCONGIDANDLOAI;
			finderArgs = new Object[] {
					hoSoTTHCCId, loai,
					
					start, end, orderByComparator
				};
		}

		List<TaiLieuChungThuc> list = (List<TaiLieuChungThuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TAILIEUCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_HOSOTTHCCID_2);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_LOAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaiLieuChungThucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCId.longValue());

				qPos.add(loai);

				list = (List<TaiLieuChungThuc>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tai lieu chung thuc in the ordered set where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai lieu chung thuc
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a matching tai lieu chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc findByHosotthcCongIdAndLoai_First(
		Long hoSoTTHCCId, int loai, OrderByComparator orderByComparator)
		throws NoSuchTaiLieuChungThucException, SystemException {
		List<TaiLieuChungThuc> list = findByHosotthcCongIdAndLoai(hoSoTTHCCId,
				loai, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCId=");
			msg.append(hoSoTTHCCId);

			msg.append(", loai=");
			msg.append(loai);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiLieuChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last tai lieu chung thuc in the ordered set where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai lieu chung thuc
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a matching tai lieu chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc findByHosotthcCongIdAndLoai_Last(Long hoSoTTHCCId,
		int loai, OrderByComparator orderByComparator)
		throws NoSuchTaiLieuChungThucException, SystemException {
		int count = countByHosotthcCongIdAndLoai(hoSoTTHCCId, loai);

		List<TaiLieuChungThuc> list = findByHosotthcCongIdAndLoai(hoSoTTHCCId,
				loai, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCId=");
			msg.append(hoSoTTHCCId);

			msg.append(", loai=");
			msg.append(loai);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaiLieuChungThucException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the tai lieu chung thucs before and after the current tai lieu chung thuc in the ordered set where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current tai lieu chung thuc
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai lieu chung thuc
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc[] findByHosotthcCongIdAndLoai_PrevAndNext(long id,
		Long hoSoTTHCCId, int loai, OrderByComparator orderByComparator)
		throws NoSuchTaiLieuChungThucException, SystemException {
		TaiLieuChungThuc taiLieuChungThuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TaiLieuChungThuc[] array = new TaiLieuChungThucImpl[3];

			array[0] = getByHosotthcCongIdAndLoai_PrevAndNext(session,
					taiLieuChungThuc, hoSoTTHCCId, loai, orderByComparator, true);

			array[1] = taiLieuChungThuc;

			array[2] = getByHosotthcCongIdAndLoai_PrevAndNext(session,
					taiLieuChungThuc, hoSoTTHCCId, loai, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaiLieuChungThuc getByHosotthcCongIdAndLoai_PrevAndNext(
		Session session, TaiLieuChungThuc taiLieuChungThuc, Long hoSoTTHCCId,
		int loai, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILIEUCHUNGTHUC_WHERE);

		query.append(_FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_HOSOTTHCCID_2);

		query.append(_FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_LOAI_2);

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
			query.append(TaiLieuChungThucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hoSoTTHCCId.longValue());

		qPos.add(loai);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taiLieuChungThuc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaiLieuChungThuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the tai lieu chung thuc where noiLuuTruId = &#63; or throws a {@link org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException} if it could not be found.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @return the matching tai lieu chung thuc
	 * @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a matching tai lieu chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc findBynoiLuuTruId(long noiLuuTruId)
		throws NoSuchTaiLieuChungThucException, SystemException {
		TaiLieuChungThuc taiLieuChungThuc = fetchBynoiLuuTruId(noiLuuTruId);

		if (taiLieuChungThuc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("noiLuuTruId=");
			msg.append(noiLuuTruId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaiLieuChungThucException(msg.toString());
		}

		return taiLieuChungThuc;
	}

	/**
	 * Returns the tai lieu chung thuc where noiLuuTruId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @return the matching tai lieu chung thuc, or <code>null</code> if a matching tai lieu chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc fetchBynoiLuuTruId(long noiLuuTruId)
		throws SystemException {
		return fetchBynoiLuuTruId(noiLuuTruId, true);
	}

	/**
	 * Returns the tai lieu chung thuc where noiLuuTruId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tai lieu chung thuc, or <code>null</code> if a matching tai lieu chung thuc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaiLieuChungThuc fetchBynoiLuuTruId(long noiLuuTruId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { noiLuuTruId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAILIEUCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2);

			query.append(TaiLieuChungThucModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(noiLuuTruId);

				List<TaiLieuChungThuc> list = q.list();

				result = list;

				TaiLieuChungThuc taiLieuChungThuc = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
						finderArgs, list);
				}
				else {
					taiLieuChungThuc = list.get(0);

					cacheResult(taiLieuChungThuc);

					if ((taiLieuChungThuc.getNoiLuuTruId() != noiLuuTruId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
							finderArgs, taiLieuChungThuc);
					}
				}

				return taiLieuChungThuc;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOILUUTRUID,
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
				return (TaiLieuChungThuc)result;
			}
		}
	}

	/**
	 * Returns all the tai lieu chung thucs.
	 *
	 * @return the tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiLieuChungThuc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai lieu chung thucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai lieu chung thucs
	 * @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	 * @return the range of tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiLieuChungThuc> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai lieu chung thucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai lieu chung thucs
	 * @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaiLieuChungThuc> findAll(int start, int end,
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

		List<TaiLieuChungThuc> list = (List<TaiLieuChungThuc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILIEUCHUNGTHUC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILIEUCHUNGTHUC.concat(TaiLieuChungThucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TaiLieuChungThuc>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaiLieuChungThuc>)QueryUtil.list(q,
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
	 * Removes all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63; from the database.
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByHosotthcCongIdAndLoai(Long hoSoTTHCCId, int loai)
		throws SystemException {
		for (TaiLieuChungThuc taiLieuChungThuc : findByHosotthcCongIdAndLoai(
				hoSoTTHCCId, loai)) {
			remove(taiLieuChungThuc);
		}
	}

	/**
	 * Removes the tai lieu chung thuc where noiLuuTruId = &#63; from the database.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBynoiLuuTruId(long noiLuuTruId)
		throws NoSuchTaiLieuChungThucException, SystemException {
		TaiLieuChungThuc taiLieuChungThuc = findBynoiLuuTruId(noiLuuTruId);

		remove(taiLieuChungThuc);
	}

	/**
	 * Removes all the tai lieu chung thucs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TaiLieuChungThuc taiLieuChungThuc : findAll()) {
			remove(taiLieuChungThuc);
		}
	}

	/**
	 * Returns the number of tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	 *
	 * @param hoSoTTHCCId the ho so t t h c c ID
	 * @param loai the loai
	 * @return the number of matching tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByHosotthcCongIdAndLoai(Long hoSoTTHCCId, int loai)
		throws SystemException {
		Object[] finderArgs = new Object[] { hoSoTTHCCId, loai };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGIDANDLOAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAILIEUCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_HOSOTTHCCID_2);

			query.append(_FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_LOAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCId.longValue());

				qPos.add(loai);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOSOTTHCCONGIDANDLOAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai lieu chung thucs where noiLuuTruId = &#63;.
	 *
	 * @param noiLuuTruId the noi luu tru ID
	 * @return the number of matching tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countBynoiLuuTruId(long noiLuuTruId) throws SystemException {
		Object[] finderArgs = new Object[] { noiLuuTruId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAILIEUCHUNGTHUC_WHERE);

			query.append(_FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(noiLuuTruId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOILUUTRUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tai lieu chung thucs.
	 *
	 * @return the number of tai lieu chung thucs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAILIEUCHUNGTHUC);

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
	 * Initializes the tai lieu chung thuc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.tlct.model.TaiLieuChungThuc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaiLieuChungThuc>> listenersList = new ArrayList<ModelListener<TaiLieuChungThuc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaiLieuChungThuc>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaiLieuChungThucImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DanhMucGiayToPersistence.class)
	protected DanhMucGiayToPersistence danhMucGiayToPersistence;
	@BeanReference(type = LichSuGiayToDinhKemPersistence.class)
	protected LichSuGiayToDinhKemPersistence lichSuGiayToDinhKemPersistence;
	@BeanReference(type = TaiLieuChungThucPersistence.class)
	protected TaiLieuChungThucPersistence taiLieuChungThucPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TAILIEUCHUNGTHUC = "SELECT taiLieuChungThuc FROM TaiLieuChungThuc taiLieuChungThuc";
	private static final String _SQL_SELECT_TAILIEUCHUNGTHUC_WHERE = "SELECT taiLieuChungThuc FROM TaiLieuChungThuc taiLieuChungThuc WHERE ";
	private static final String _SQL_COUNT_TAILIEUCHUNGTHUC = "SELECT COUNT(taiLieuChungThuc) FROM TaiLieuChungThuc taiLieuChungThuc";
	private static final String _SQL_COUNT_TAILIEUCHUNGTHUC_WHERE = "SELECT COUNT(taiLieuChungThuc) FROM TaiLieuChungThuc taiLieuChungThuc WHERE ";
	private static final String _FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_HOSOTTHCCID_2 =
		"taiLieuChungThuc.hoSoTTHCCId = ? AND ";
	private static final String _FINDER_COLUMN_HOSOTTHCCONGIDANDLOAI_LOAI_2 = "taiLieuChungThuc.loai = ?";
	private static final String _FINDER_COLUMN_NOILUUTRUID_NOILUUTRUID_2 = "taiLieuChungThuc.noiLuuTruId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taiLieuChungThuc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaiLieuChungThuc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaiLieuChungThuc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaiLieuChungThucPersistenceImpl.class);
	private static TaiLieuChungThuc _nullTaiLieuChungThuc = new TaiLieuChungThucImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaiLieuChungThuc> toCacheModel() {
				return _nullTaiLieuChungThucCacheModel;
			}
		};

	private static CacheModel<TaiLieuChungThuc> _nullTaiLieuChungThucCacheModel = new CacheModel<TaiLieuChungThuc>() {
			public TaiLieuChungThuc toEntityModel() {
				return _nullTaiLieuChungThuc;
			}
		};
}