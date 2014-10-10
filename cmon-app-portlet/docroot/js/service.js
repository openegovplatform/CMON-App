Liferay.Service.register("Liferay.Service.CC", "vn.dtt.commonapp.dao.cc.service", "common-db-portlet");

Liferay.Service.register("Liferay.Service.DN", "vn.dtt.commonapp.dao.dn.service", "common-db-portlet");

Liferay.Service.register("Liferay.Service.NSD", "vn.dtt.commonapp.dao.nsd.service", "common-db-portlet");

Liferay.Service.register("Liferay.Service.EGOV", "org.oep.cmon.dao.hosohcc.service", "cmon-app-portlet_v1.1_201410-portlet");

Liferay.Service.registerClass(
	Liferay.Service.EGOV, "FileDinhKem",
	{
		addFileDinhKem: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.EGOV, "HoSoTTHCCong",
	{
		addHoSoTTHCCong: true
	}
);