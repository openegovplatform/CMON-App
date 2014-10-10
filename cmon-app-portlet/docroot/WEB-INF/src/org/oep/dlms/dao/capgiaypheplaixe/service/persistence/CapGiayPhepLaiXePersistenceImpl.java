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

package org.oep.dlms.dao.capgiaypheplaixe.service.persistence;

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


import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException;
import org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe;
import org.oep.dlms.dao.capgiaypheplaixe.model.impl.CapGiayPhepLaiXeImpl;
import org.oep.dlms.dao.capgiaypheplaixe.model.impl.CapGiayPhepLaiXeModelImpl;

/**
 * The persistence implementation for the cap giay phep lai xe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see CapGiayPhepLaiXePersistence
 * @see CapGiayPhepLaiXeUtil
 * @generated
 */
public class CapGiayPhepLaiXePersistenceImpl extends BasePersistenceImpl<CapGiayPhepLaiXe>
	implements CapGiayPhepLaiXePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CapGiayPhepLaiXeUtil} to access the cap giay phep lai xe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CapGiayPhepLaiXeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			CapGiayPhepLaiXeModelImpl.FINDER_CACHE_ENABLED,
			CapGiayPhepLaiXeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			CapGiayPhepLaiXeModelImpl.FINDER_CACHE_ENABLED,
			CapGiayPhepLaiXeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			CapGiayPhepLaiXeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cap giay phep lai xe in the entity cache if it is enabled.
	 *
	 * @param capGiayPhepLaiXe the cap giay phep lai xe
	 */
	public void cacheResult(CapGiayPhepLaiXe capGiayPhepLaiXe) {
		EntityCacheUtil.putResult(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			CapGiayPhepLaiXeImpl.class, capGiayPhepLaiXe.getPrimaryKey(),
			capGiayPhepLaiXe);

		capGiayPhepLaiXe.resetOriginalValues();
	}

	/**
	 * Caches the cap giay phep lai xes in the entity cache if it is enabled.
	 *
	 * @param capGiayPhepLaiXes the cap giay phep lai xes
	 */
	public void cacheResult(List<CapGiayPhepLaiXe> capGiayPhepLaiXes) {
		for (CapGiayPhepLaiXe capGiayPhepLaiXe : capGiayPhepLaiXes) {
			if (EntityCacheUtil.getResult(
						CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
						CapGiayPhepLaiXeImpl.class,
						capGiayPhepLaiXe.getPrimaryKey()) == null) {
				cacheResult(capGiayPhepLaiXe);
			}
			else {
				capGiayPhepLaiXe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cap giay phep lai xes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CapGiayPhepLaiXeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CapGiayPhepLaiXeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cap giay phep lai xe.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CapGiayPhepLaiXe capGiayPhepLaiXe) {
		EntityCacheUtil.removeResult(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			CapGiayPhepLaiXeImpl.class, capGiayPhepLaiXe.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CapGiayPhepLaiXe> capGiayPhepLaiXes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CapGiayPhepLaiXe capGiayPhepLaiXe : capGiayPhepLaiXes) {
			EntityCacheUtil.removeResult(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
				CapGiayPhepLaiXeImpl.class, capGiayPhepLaiXe.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cap giay phep lai xe with the primary key. Does not add the cap giay phep lai xe to the database.
	 *
	 * @param id the primary key for the new cap giay phep lai xe
	 * @return the new cap giay phep lai xe
	 */
	public CapGiayPhepLaiXe create(long id) {
		CapGiayPhepLaiXe capGiayPhepLaiXe = new CapGiayPhepLaiXeImpl();

		capGiayPhepLaiXe.setNew(true);
		capGiayPhepLaiXe.setPrimaryKey(id);

		return capGiayPhepLaiXe;
	}

	/**
	 * Removes the cap giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cap giay phep lai xe
	 * @return the cap giay phep lai xe that was removed
	 * @throws org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException if a cap giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapGiayPhepLaiXe remove(long id)
		throws NoSuchCapGiayPhepLaiXeException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cap giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cap giay phep lai xe
	 * @return the cap giay phep lai xe that was removed
	 * @throws org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException if a cap giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapGiayPhepLaiXe remove(Serializable primaryKey)
		throws NoSuchCapGiayPhepLaiXeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CapGiayPhepLaiXe capGiayPhepLaiXe = (CapGiayPhepLaiXe)session.get(CapGiayPhepLaiXeImpl.class,
					primaryKey);

			if (capGiayPhepLaiXe == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCapGiayPhepLaiXeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(capGiayPhepLaiXe);
		}
		catch (NoSuchCapGiayPhepLaiXeException nsee) {
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
	protected CapGiayPhepLaiXe removeImpl(CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws SystemException {
		capGiayPhepLaiXe = toUnwrappedModel(capGiayPhepLaiXe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, capGiayPhepLaiXe);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(capGiayPhepLaiXe);

		return capGiayPhepLaiXe;
	}

	@Override
	public CapGiayPhepLaiXe updateImpl(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe,
		boolean merge) throws SystemException {
		capGiayPhepLaiXe = toUnwrappedModel(capGiayPhepLaiXe);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, capGiayPhepLaiXe, merge);

			capGiayPhepLaiXe.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
			CapGiayPhepLaiXeImpl.class, capGiayPhepLaiXe.getPrimaryKey(),
			capGiayPhepLaiXe);

		return capGiayPhepLaiXe;
	}

	protected CapGiayPhepLaiXe toUnwrappedModel(
		CapGiayPhepLaiXe capGiayPhepLaiXe) {
		if (capGiayPhepLaiXe instanceof CapGiayPhepLaiXeImpl) {
			return capGiayPhepLaiXe;
		}

		CapGiayPhepLaiXeImpl capGiayPhepLaiXeImpl = new CapGiayPhepLaiXeImpl();

		capGiayPhepLaiXeImpl.setNew(capGiayPhepLaiXe.isNew());
		capGiayPhepLaiXeImpl.setPrimaryKey(capGiayPhepLaiXe.getPrimaryKey());

		capGiayPhepLaiXeImpl.setId(capGiayPhepLaiXe.getId());
		capGiayPhepLaiXeImpl.setIdCoQuanQuanLy(capGiayPhepLaiXe.getIdCoQuanQuanLy());
		capGiayPhepLaiXeImpl.setIdCongDan(capGiayPhepLaiXe.getIdCongDan());
		capGiayPhepLaiXeImpl.setIdLoaiHoSo(capGiayPhepLaiXe.getIdLoaiHoSo());
		capGiayPhepLaiXeImpl.setSoHoSo(capGiayPhepLaiXe.getSoHoSo());
		capGiayPhepLaiXeImpl.setHoVaTen(capGiayPhepLaiXe.getHoVaTen());
		capGiayPhepLaiXeImpl.setNgaySinh(capGiayPhepLaiXe.getNgaySinh());
		capGiayPhepLaiXeImpl.setIdGioiTinh(capGiayPhepLaiXe.getIdGioiTinh());
		capGiayPhepLaiXeImpl.setIdQuocTich(capGiayPhepLaiXe.getIdQuocTich());
		capGiayPhepLaiXeImpl.setSoCMND(capGiayPhepLaiXe.getSoCMND());
		capGiayPhepLaiXeImpl.setNgayCapCMND(capGiayPhepLaiXe.getNgayCapCMND());
		capGiayPhepLaiXeImpl.setIdNoiCapCMND(capGiayPhepLaiXe.getIdNoiCapCMND());
		capGiayPhepLaiXeImpl.setSoHoChieu(capGiayPhepLaiXe.getSoHoChieu());
		capGiayPhepLaiXeImpl.setNgayCapHoChieu(capGiayPhepLaiXe.getNgayCapHoChieu());
		capGiayPhepLaiXeImpl.setNoiCapHoChieu(capGiayPhepLaiXe.getNoiCapHoChieu());
		capGiayPhepLaiXeImpl.setDienThoai(capGiayPhepLaiXe.getDienThoai());
		capGiayPhepLaiXeImpl.setEmail(capGiayPhepLaiXe.getEmail());
		capGiayPhepLaiXeImpl.setGhiChu(capGiayPhepLaiXe.getGhiChu());
		capGiayPhepLaiXeImpl.setIdTinhThuongTru(capGiayPhepLaiXe.getIdTinhThuongTru());
		capGiayPhepLaiXeImpl.setIdHuyenThuongTru(capGiayPhepLaiXe.getIdHuyenThuongTru());
		capGiayPhepLaiXeImpl.setIdXaThuongTru(capGiayPhepLaiXe.getIdXaThuongTru());
		capGiayPhepLaiXeImpl.setDiaChiThuongTru(capGiayPhepLaiXe.getDiaChiThuongTru());
		capGiayPhepLaiXeImpl.setIdTinhCuTru(capGiayPhepLaiXe.getIdTinhCuTru());
		capGiayPhepLaiXeImpl.setIdHuyenCuTru(capGiayPhepLaiXe.getIdHuyenCuTru());
		capGiayPhepLaiXeImpl.setIdXaCuTru(capGiayPhepLaiXe.getIdXaCuTru());
		capGiayPhepLaiXeImpl.setDiaChiCuTru(capGiayPhepLaiXe.getDiaChiCuTru());
		capGiayPhepLaiXeImpl.setSoGiayPhepLaiXe(capGiayPhepLaiXe.getSoGiayPhepLaiXe());
		capGiayPhepLaiXeImpl.setIdHangGiayPhepLaiXe(capGiayPhepLaiXe.getIdHangGiayPhepLaiXe());
		capGiayPhepLaiXeImpl.setIdDonViCapGPLX(capGiayPhepLaiXe.getIdDonViCapGPLX());
		capGiayPhepLaiXeImpl.setNgayCapGPLX(capGiayPhepLaiXe.getNgayCapGPLX());
		capGiayPhepLaiXeImpl.setIdNoiCapGPLX(capGiayPhepLaiXe.getIdNoiCapGPLX());
		capGiayPhepLaiXeImpl.setNgayDauSatHach(capGiayPhepLaiXe.getNgayDauSatHach());
		capGiayPhepLaiXeImpl.setIdNoiHocLaiXe(capGiayPhepLaiXe.getIdNoiHocLaiXe());
		capGiayPhepLaiXeImpl.setNamHocLaiXe(capGiayPhepLaiXe.getNamHocLaiXe());
		capGiayPhepLaiXeImpl.setNamTrungTuyenHangCaoNhat(capGiayPhepLaiXe.getNamTrungTuyenHangCaoNhat());
		capGiayPhepLaiXeImpl.setLyDoHoc(capGiayPhepLaiXe.getLyDoHoc());
		capGiayPhepLaiXeImpl.setMucDichHoc(capGiayPhepLaiXe.getMucDichHoc());
		capGiayPhepLaiXeImpl.setSoNamLaiXe(capGiayPhepLaiXe.getSoNamLaiXe());
		capGiayPhepLaiXeImpl.setSoKmLaiXe(capGiayPhepLaiXe.getSoKmLaiXe());
		capGiayPhepLaiXeImpl.setNgayTraGPLX(capGiayPhepLaiXe.getNgayTraGPLX());
		capGiayPhepLaiXeImpl.setIdLyDoCapDoiLaiGPLX(capGiayPhepLaiXe.getIdLyDoCapDoiLaiGPLX());
		capGiayPhepLaiXeImpl.setLyDo(capGiayPhepLaiXe.getLyDo());
		capGiayPhepLaiXeImpl.setNgayTao(capGiayPhepLaiXe.getNgayTao());
		capGiayPhepLaiXeImpl.setNgaySua(capGiayPhepLaiXe.getNgaySua());
		capGiayPhepLaiXeImpl.setNguoiTao(capGiayPhepLaiXe.getNguoiTao());
		capGiayPhepLaiXeImpl.setNguoiSua(capGiayPhepLaiXe.getNguoiSua());
		capGiayPhepLaiXeImpl.setXoa(capGiayPhepLaiXe.getXoa());

		return capGiayPhepLaiXeImpl;
	}

	/**
	 * Returns the cap giay phep lai xe with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap giay phep lai xe
	 * @return the cap giay phep lai xe
	 * @throws com.liferay.portal.NoSuchModelException if a cap giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapGiayPhepLaiXe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap giay phep lai xe with the primary key or throws a {@link org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException} if it could not be found.
	 *
	 * @param id the primary key of the cap giay phep lai xe
	 * @return the cap giay phep lai xe
	 * @throws org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException if a cap giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapGiayPhepLaiXe findByPrimaryKey(long id)
		throws NoSuchCapGiayPhepLaiXeException, SystemException {
		CapGiayPhepLaiXe capGiayPhepLaiXe = fetchByPrimaryKey(id);

		if (capGiayPhepLaiXe == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCapGiayPhepLaiXeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return capGiayPhepLaiXe;
	}

	/**
	 * Returns the cap giay phep lai xe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap giay phep lai xe
	 * @return the cap giay phep lai xe, or <code>null</code> if a cap giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapGiayPhepLaiXe fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap giay phep lai xe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cap giay phep lai xe
	 * @return the cap giay phep lai xe, or <code>null</code> if a cap giay phep lai xe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapGiayPhepLaiXe fetchByPrimaryKey(long id)
		throws SystemException {
		CapGiayPhepLaiXe capGiayPhepLaiXe = (CapGiayPhepLaiXe)EntityCacheUtil.getResult(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
				CapGiayPhepLaiXeImpl.class, id);

		if (capGiayPhepLaiXe == _nullCapGiayPhepLaiXe) {
			return null;
		}

		if (capGiayPhepLaiXe == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				capGiayPhepLaiXe = (CapGiayPhepLaiXe)session.get(CapGiayPhepLaiXeImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (capGiayPhepLaiXe != null) {
					cacheResult(capGiayPhepLaiXe);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CapGiayPhepLaiXeModelImpl.ENTITY_CACHE_ENABLED,
						CapGiayPhepLaiXeImpl.class, id, _nullCapGiayPhepLaiXe);
				}

				closeSession(session);
			}
		}

		return capGiayPhepLaiXe;
	}

	/**
	 * Returns all the cap giay phep lai xes.
	 *
	 * @return the cap giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapGiayPhepLaiXe> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap giay phep lai xes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap giay phep lai xes
	 * @param end the upper bound of the range of cap giay phep lai xes (not inclusive)
	 * @return the range of cap giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapGiayPhepLaiXe> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap giay phep lai xes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap giay phep lai xes
	 * @param end the upper bound of the range of cap giay phep lai xes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cap giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapGiayPhepLaiXe> findAll(int start, int end,
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

		List<CapGiayPhepLaiXe> list = (List<CapGiayPhepLaiXe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAPGIAYPHEPLAIXE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAPGIAYPHEPLAIXE.concat(CapGiayPhepLaiXeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CapGiayPhepLaiXe>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CapGiayPhepLaiXe>)QueryUtil.list(q,
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
	 * Removes all the cap giay phep lai xes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CapGiayPhepLaiXe capGiayPhepLaiXe : findAll()) {
			remove(capGiayPhepLaiXe);
		}
	}

	/**
	 * Returns the number of cap giay phep lai xes.
	 *
	 * @return the number of cap giay phep lai xes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAPGIAYPHEPLAIXE);

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
	 * Initializes the cap giay phep lai xe persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CapGiayPhepLaiXe>> listenersList = new ArrayList<ModelListener<CapGiayPhepLaiXe>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CapGiayPhepLaiXe>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CapGiayPhepLaiXeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapGiayPhepLaiXePersistence.class)
	protected CapGiayPhepLaiXePersistence capGiayPhepLaiXePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CAPGIAYPHEPLAIXE = "SELECT capGiayPhepLaiXe FROM CapGiayPhepLaiXe capGiayPhepLaiXe";
	private static final String _SQL_COUNT_CAPGIAYPHEPLAIXE = "SELECT COUNT(capGiayPhepLaiXe) FROM CapGiayPhepLaiXe capGiayPhepLaiXe";
	private static final String _ORDER_BY_ENTITY_ALIAS = "capGiayPhepLaiXe.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CapGiayPhepLaiXe exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CapGiayPhepLaiXePersistenceImpl.class);
	private static CapGiayPhepLaiXe _nullCapGiayPhepLaiXe = new CapGiayPhepLaiXeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CapGiayPhepLaiXe> toCacheModel() {
				return _nullCapGiayPhepLaiXeCacheModel;
			}
		};

	private static CacheModel<CapGiayPhepLaiXe> _nullCapGiayPhepLaiXeCacheModel = new CacheModel<CapGiayPhepLaiXe>() {
			public CapGiayPhepLaiXe toEntityModel() {
				return _nullCapGiayPhepLaiXe;
			}
		};
}