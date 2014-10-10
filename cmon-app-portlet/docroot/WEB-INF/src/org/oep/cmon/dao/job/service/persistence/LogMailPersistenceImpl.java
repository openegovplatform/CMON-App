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

package org.oep.cmon.dao.job.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import org.oep.cmon.dao.job.NoSuchLogMailException;
import org.oep.cmon.dao.job.model.LogMail;
import org.oep.cmon.dao.job.model.impl.LogMailImpl;
import org.oep.cmon.dao.job.model.impl.LogMailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the log mail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LogMailPersistence
 * @see LogMailUtil
 * @generated
 */
public class LogMailPersistenceImpl extends BasePersistenceImpl<LogMail>
	implements LogMailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogMailUtil} to access the log mail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogMailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYHOSOTTHCCONGID =
		new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByHoSoTTHCCongId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYHOSOTTHCCONGID =
		new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByByHoSoTTHCCongId", new String[] { Long.class.getName() },
			LogMailModelImpl.HOSOTTHCCONGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYHOSOTTHCCONGID = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByHoSoTTHCCongId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTATUS = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS =
		new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByStatus",
			new String[] { Integer.class.getName() },
			LogMailModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYSTATUS = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCREATETIME =
		new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByCreateTime",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCREATETIME =
		new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByCreateTime",
			new String[] { Date.class.getName() },
			LogMailModelImpl.CREATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYCREATETIME = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByCreateTime",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, LogMailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the log mail in the entity cache if it is enabled.
	 *
	 * @param logMail the log mail
	 */
	public void cacheResult(LogMail logMail) {
		EntityCacheUtil.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailImpl.class, logMail.getPrimaryKey(), logMail);

		logMail.resetOriginalValues();
	}

	/**
	 * Caches the log mails in the entity cache if it is enabled.
	 *
	 * @param logMails the log mails
	 */
	public void cacheResult(List<LogMail> logMails) {
		for (LogMail logMail : logMails) {
			if (EntityCacheUtil.getResult(
						LogMailModelImpl.ENTITY_CACHE_ENABLED,
						LogMailImpl.class, logMail.getPrimaryKey()) == null) {
				cacheResult(logMail);
			}
			else {
				logMail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log mails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LogMailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LogMailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log mail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogMail logMail) {
		EntityCacheUtil.removeResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailImpl.class, logMail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogMail> logMails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogMail logMail : logMails) {
			EntityCacheUtil.removeResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
				LogMailImpl.class, logMail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new log mail with the primary key. Does not add the log mail to the database.
	 *
	 * @param id the primary key for the new log mail
	 * @return the new log mail
	 */
	public LogMail create(long id) {
		LogMail logMail = new LogMailImpl();

		logMail.setNew(true);
		logMail.setPrimaryKey(id);

		return logMail;
	}

	/**
	 * Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the log mail
	 * @return the log mail that was removed
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail remove(long id)
		throws NoSuchLogMailException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log mail
	 * @return the log mail that was removed
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogMail remove(Serializable primaryKey)
		throws NoSuchLogMailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LogMail logMail = (LogMail)session.get(LogMailImpl.class, primaryKey);

			if (logMail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogMailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logMail);
		}
		catch (NoSuchLogMailException nsee) {
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
	protected LogMail removeImpl(LogMail logMail) throws SystemException {
		logMail = toUnwrappedModel(logMail);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, logMail);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(logMail);

		return logMail;
	}

	@Override
	public LogMail updateImpl(org.oep.cmon.dao.job.model.LogMail logMail,
		boolean merge) throws SystemException {
		logMail = toUnwrappedModel(logMail);

		boolean isNew = logMail.isNew();

		LogMailModelImpl logMailModelImpl = (LogMailModelImpl)logMail;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, logMail, merge);

			logMail.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LogMailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((logMailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYHOSOTTHCCONGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(logMailModelImpl.getOriginalHoSoTTHCCongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYHOSOTTHCCONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYHOSOTTHCCONGID,
					args);

				args = new Object[] {
						Long.valueOf(logMailModelImpl.getHoSoTTHCCongId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYHOSOTTHCCONGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYHOSOTTHCCONGID,
					args);
			}

			if ((logMailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(logMailModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS,
					args);

				args = new Object[] {
						Integer.valueOf(logMailModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS,
					args);
			}

			if ((logMailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCREATETIME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logMailModelImpl.getOriginalCreateTime()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYCREATETIME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCREATETIME,
					args);

				args = new Object[] { logMailModelImpl.getCreateTime() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYCREATETIME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCREATETIME,
					args);
			}
		}

		EntityCacheUtil.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
			LogMailImpl.class, logMail.getPrimaryKey(), logMail);

		return logMail;
	}

	protected LogMail toUnwrappedModel(LogMail logMail) {
		if (logMail instanceof LogMailImpl) {
			return logMail;
		}

		LogMailImpl logMailImpl = new LogMailImpl();

		logMailImpl.setNew(logMail.isNew());
		logMailImpl.setPrimaryKey(logMail.getPrimaryKey());

		logMailImpl.setId(logMail.getId());
		logMailImpl.setType(logMail.getType());
		logMailImpl.setHoSoTTHCCongId(logMail.getHoSoTTHCCongId());
		logMailImpl.setCreateTime(logMail.getCreateTime());
		logMailImpl.setStatus(logMail.getStatus());
		logMailImpl.setDescription(logMail.getDescription());

		return logMailImpl;
	}

	/**
	 * Returns the log mail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the log mail
	 * @return the log mail
	 * @throws com.liferay.portal.NoSuchModelException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogMail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the log mail with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchLogMailException} if it could not be found.
	 *
	 * @param id the primary key of the log mail
	 * @return the log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByPrimaryKey(long id)
		throws NoSuchLogMailException, SystemException {
		LogMail logMail = fetchByPrimaryKey(id);

		if (logMail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchLogMailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return logMail;
	}

	/**
	 * Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log mail
	 * @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogMail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the log mail
	 * @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail fetchByPrimaryKey(long id) throws SystemException {
		LogMail logMail = (LogMail)EntityCacheUtil.getResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
				LogMailImpl.class, id);

		if (logMail == _nullLogMail) {
			return null;
		}

		if (logMail == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				logMail = (LogMail)session.get(LogMailImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (logMail != null) {
					cacheResult(logMail);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LogMailModelImpl.ENTITY_CACHE_ENABLED,
						LogMailImpl.class, id, _nullLogMail);
				}

				closeSession(session);
			}
		}

		return logMail;
	}

	/**
	 * Returns all the log mails where hoSoTTHCCongId = &#63;.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		return findByByHoSoTTHCCongId(hoSoTTHCCongId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log mails where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @return the range of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByHoSoTTHCCongId(long hoSoTTHCCongId, int start,
		int end) throws SystemException {
		return findByByHoSoTTHCCongId(hoSoTTHCCongId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the log mails where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByHoSoTTHCCongId(long hoSoTTHCCongId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYHOSOTTHCCONGID;
			finderArgs = new Object[] { hoSoTTHCCongId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYHOSOTTHCCONGID;
			finderArgs = new Object[] {
					hoSoTTHCCongId,
					
					start, end, orderByComparator
				};
		}

		List<LogMail> list = (List<LogMail>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LOGMAIL_WHERE);

			query.append(_FINDER_COLUMN_BYHOSOTTHCCONGID_HOSOTTHCCONGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LogMailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoTTHCCongId);

				list = (List<LogMail>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first log mail in the ordered set where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByByHoSoTTHCCongId_First(long hoSoTTHCCongId,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		List<LogMail> list = findByByHoSoTTHCCongId(hoSoTTHCCongId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCongId=");
			msg.append(hoSoTTHCCongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLogMailException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last log mail in the ordered set where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByByHoSoTTHCCongId_Last(long hoSoTTHCCongId,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		int count = countByByHoSoTTHCCongId(hoSoTTHCCongId);

		List<LogMail> list = findByByHoSoTTHCCongId(hoSoTTHCCongId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoTTHCCongId=");
			msg.append(hoSoTTHCCongId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLogMailException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the log mails before and after the current log mail in the ordered set where hoSoTTHCCongId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current log mail
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail[] findByByHoSoTTHCCongId_PrevAndNext(long id,
		long hoSoTTHCCongId, OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		LogMail logMail = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LogMail[] array = new LogMailImpl[3];

			array[0] = getByByHoSoTTHCCongId_PrevAndNext(session, logMail,
					hoSoTTHCCongId, orderByComparator, true);

			array[1] = logMail;

			array[2] = getByByHoSoTTHCCongId_PrevAndNext(session, logMail,
					hoSoTTHCCongId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogMail getByByHoSoTTHCCongId_PrevAndNext(Session session,
		LogMail logMail, long hoSoTTHCCongId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGMAIL_WHERE);

		query.append(_FINDER_COLUMN_BYHOSOTTHCCONGID_HOSOTTHCCONGID_2);

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
			query.append(LogMailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hoSoTTHCCongId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logMail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogMail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the log mails where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByStatus(int status) throws SystemException {
		return findByByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log mails where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @return the range of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByStatus(int status, int start, int end)
		throws SystemException {
		return findByByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the log mails where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYSTATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYSTATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<LogMail> list = (List<LogMail>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LOGMAIL_WHERE);

			query.append(_FINDER_COLUMN_BYSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LogMailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<LogMail>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first log mail in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		List<LogMail> list = findByByStatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLogMailException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last log mail in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		int count = countByByStatus(status);

		List<LogMail> list = findByByStatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLogMailException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the log mails before and after the current log mail in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current log mail
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail[] findByByStatus_PrevAndNext(long id, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		LogMail logMail = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LogMail[] array = new LogMailImpl[3];

			array[0] = getByByStatus_PrevAndNext(session, logMail, status,
					orderByComparator, true);

			array[1] = logMail;

			array[2] = getByByStatus_PrevAndNext(session, logMail, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogMail getByByStatus_PrevAndNext(Session session,
		LogMail logMail, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGMAIL_WHERE);

		query.append(_FINDER_COLUMN_BYSTATUS_STATUS_2);

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
			query.append(LogMailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logMail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogMail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the log mails where createTime = &#63;.
	 *
	 * @param createTime the create time
	 * @return the matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByCreateTime(Date createTime)
		throws SystemException {
		return findByByCreateTime(createTime, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log mails where createTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createTime the create time
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @return the range of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByCreateTime(Date createTime, int start, int end)
		throws SystemException {
		return findByByCreateTime(createTime, start, end, null);
	}

	/**
	 * Returns an ordered range of all the log mails where createTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createTime the create time
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findByByCreateTime(Date createTime, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCREATETIME;
			finderArgs = new Object[] { createTime };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCREATETIME;
			finderArgs = new Object[] { createTime, start, end, orderByComparator };
		}

		List<LogMail> list = (List<LogMail>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LOGMAIL_WHERE);

			if (createTime == null) {
				query.append(_FINDER_COLUMN_BYCREATETIME_CREATETIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_BYCREATETIME_CREATETIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LogMailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createTime != null) {
					qPos.add(CalendarUtil.getTimestamp(createTime));
				}

				list = (List<LogMail>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first log mail in the ordered set where createTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createTime the create time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByByCreateTime_First(Date createTime,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		List<LogMail> list = findByByCreateTime(createTime, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createTime=");
			msg.append(createTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLogMailException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last log mail in the ordered set where createTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createTime the create time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail findByByCreateTime_Last(Date createTime,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		int count = countByByCreateTime(createTime);

		List<LogMail> list = findByByCreateTime(createTime, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createTime=");
			msg.append(createTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLogMailException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the log mails before and after the current log mail in the ordered set where createTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current log mail
	 * @param createTime the create time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next log mail
	 * @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogMail[] findByByCreateTime_PrevAndNext(long id, Date createTime,
		OrderByComparator orderByComparator)
		throws NoSuchLogMailException, SystemException {
		LogMail logMail = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LogMail[] array = new LogMailImpl[3];

			array[0] = getByByCreateTime_PrevAndNext(session, logMail,
					createTime, orderByComparator, true);

			array[1] = logMail;

			array[2] = getByByCreateTime_PrevAndNext(session, logMail,
					createTime, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogMail getByByCreateTime_PrevAndNext(Session session,
		LogMail logMail, Date createTime, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGMAIL_WHERE);

		if (createTime == null) {
			query.append(_FINDER_COLUMN_BYCREATETIME_CREATETIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_BYCREATETIME_CREATETIME_2);
		}

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
			query.append(LogMailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (createTime != null) {
			qPos.add(CalendarUtil.getTimestamp(createTime));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logMail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogMail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the log mails.
	 *
	 * @return the log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @return the range of log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the log mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of log mails
	 * @param end the upper bound of the range of log mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log mails
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogMail> findAll(int start, int end,
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

		List<LogMail> list = (List<LogMail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOGMAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGMAIL.concat(LogMailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LogMail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LogMail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the log mails where hoSoTTHCCongId = &#63; from the database.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		for (LogMail logMail : findByByHoSoTTHCCongId(hoSoTTHCCongId)) {
			remove(logMail);
		}
	}

	/**
	 * Removes all the log mails where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByStatus(int status) throws SystemException {
		for (LogMail logMail : findByByStatus(status)) {
			remove(logMail);
		}
	}

	/**
	 * Removes all the log mails where createTime = &#63; from the database.
	 *
	 * @param createTime the create time
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByByCreateTime(Date createTime) throws SystemException {
		for (LogMail logMail : findByByCreateTime(createTime)) {
			remove(logMail);
		}
	}

	/**
	 * Removes all the log mails from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LogMail logMail : findAll()) {
			remove(logMail);
		}
	}

	/**
	 * Returns the number of log mails where hoSoTTHCCongId = &#63;.
	 *
	 * @param hoSoTTHCCongId the ho so t t h c cong ID
	 * @return the number of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws SystemException {
		Object[] finderArgs = new Object[] { hoSoTTHCCongId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYHOSOTTHCCONGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGMAIL_WHERE);

			query.append(_FINDER_COLUMN_BYHOSOTTHCCONGID_HOSOTTHCCONGID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYHOSOTTHCCONGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of log mails where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByStatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGMAIL_WHERE);

			query.append(_FINDER_COLUMN_BYSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of log mails where createTime = &#63;.
	 *
	 * @param createTime the create time
	 * @return the number of matching log mails
	 * @throws SystemException if a system exception occurred
	 */
	public int countByByCreateTime(Date createTime) throws SystemException {
		Object[] finderArgs = new Object[] { createTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BYCREATETIME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGMAIL_WHERE);

			if (createTime == null) {
				query.append(_FINDER_COLUMN_BYCREATETIME_CREATETIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_BYCREATETIME_CREATETIME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createTime != null) {
					qPos.add(CalendarUtil.getTimestamp(createTime));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYCREATETIME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of log mails.
	 *
	 * @return the number of log mails
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGMAIL);

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
	 * Initializes the log mail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.oep.cmon.dao.job.model.LogMail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LogMail>> listenersList = new ArrayList<ModelListener<LogMail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LogMail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LogMailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DanhSachJobPersistence.class)
	protected DanhSachJobPersistence danhSachJobPersistence;
	@BeanReference(type = LogMailPersistence.class)
	protected LogMailPersistence logMailPersistence;
	@BeanReference(type = TrangThaiJobPersistence.class)
	protected TrangThaiJobPersistence trangThaiJobPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LOGMAIL = "SELECT logMail FROM LogMail logMail";
	private static final String _SQL_SELECT_LOGMAIL_WHERE = "SELECT logMail FROM LogMail logMail WHERE ";
	private static final String _SQL_COUNT_LOGMAIL = "SELECT COUNT(logMail) FROM LogMail logMail";
	private static final String _SQL_COUNT_LOGMAIL_WHERE = "SELECT COUNT(logMail) FROM LogMail logMail WHERE ";
	private static final String _FINDER_COLUMN_BYHOSOTTHCCONGID_HOSOTTHCCONGID_2 =
		"logMail.hoSoTTHCCongId = ?";
	private static final String _FINDER_COLUMN_BYSTATUS_STATUS_2 = "logMail.status = ?";
	private static final String _FINDER_COLUMN_BYCREATETIME_CREATETIME_1 = "logMail.createTime IS NULL";
	private static final String _FINDER_COLUMN_BYCREATETIME_CREATETIME_2 = "logMail.createTime = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logMail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogMail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LogMail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LogMailPersistenceImpl.class);
	private static LogMail _nullLogMail = new LogMailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LogMail> toCacheModel() {
				return _nullLogMailCacheModel;
			}
		};

	private static CacheModel<LogMail> _nullLogMailCacheModel = new CacheModel<LogMail>() {
			public LogMail toEntityModel() {
				return _nullLogMail;
			}
		};
}