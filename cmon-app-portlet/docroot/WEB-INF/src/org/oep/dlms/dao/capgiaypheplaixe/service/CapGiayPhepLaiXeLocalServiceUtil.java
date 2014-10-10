/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.oep.dlms.dao.capgiaypheplaixe.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the cap giay phep lai xe local service. This utility wraps {@link org.oep.dlms.dao.capgiaypheplaixe.service.impl.CapGiayPhepLaiXeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhNT
 * @see CapGiayPhepLaiXeLocalService
 * @see org.oep.dlms.dao.capgiaypheplaixe.service.base.CapGiayPhepLaiXeLocalServiceBaseImpl
 * @see org.oep.dlms.dao.capgiaypheplaixe.service.impl.CapGiayPhepLaiXeLocalServiceImpl
 * @generated
 */
public class CapGiayPhepLaiXeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.dlms.dao.capgiaypheplaixe.service.impl.CapGiayPhepLaiXeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cap giay phep lai xe to the database. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @return the cap giay phep lai xe that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe addCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCapGiayPhepLaiXe(capGiayPhepLaiXe);
	}

	/**
	* Creates a new cap giay phep lai xe with the primary key. Does not add the cap giay phep lai xe to the database.
	*
	* @param id the primary key for the new cap giay phep lai xe
	* @return the new cap giay phep lai xe
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe createCapGiayPhepLaiXe(
		long id) {
		return getService().createCapGiayPhepLaiXe(id);
	}

	/**
	* Deletes the cap giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @throws PortalException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCapGiayPhepLaiXe(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCapGiayPhepLaiXe(id);
	}

	/**
	* Deletes the cap giay phep lai xe from the database. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCapGiayPhepLaiXe(capGiayPhepLaiXe);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe fetchCapGiayPhepLaiXe(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCapGiayPhepLaiXe(id);
	}

	/**
	* Returns the cap giay phep lai xe with the primary key.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @return the cap giay phep lai xe
	* @throws PortalException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe getCapGiayPhepLaiXe(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCapGiayPhepLaiXe(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> getCapGiayPhepLaiXes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCapGiayPhepLaiXes(start, end);
	}

	/**
	* Returns the number of cap giay phep lai xes.
	*
	* @return the number of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static int getCapGiayPhepLaiXesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCapGiayPhepLaiXesCount();
	}

	/**
	* Updates the cap giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @return the cap giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCapGiayPhepLaiXe(capGiayPhepLaiXe);
	}

	/**
	* Updates the cap giay phep lai xe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	* @param merge whether to merge the cap giay phep lai xe with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cap giay phep lai xe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateCapGiayPhepLaiXe(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCapGiayPhepLaiXe(capGiayPhepLaiXe, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static CapGiayPhepLaiXeLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CapGiayPhepLaiXeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CapGiayPhepLaiXeLocalService.class.getName(),
					portletClassLoader);

			_service = new CapGiayPhepLaiXeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CapGiayPhepLaiXeLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CapGiayPhepLaiXeLocalService.class);
		}

		return _service;
	}

	public void setService(CapGiayPhepLaiXeLocalService service) {
		MethodCache.remove(CapGiayPhepLaiXeLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CapGiayPhepLaiXeLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CapGiayPhepLaiXeLocalService.class);
	}

	private static CapGiayPhepLaiXeLocalService _service;
}