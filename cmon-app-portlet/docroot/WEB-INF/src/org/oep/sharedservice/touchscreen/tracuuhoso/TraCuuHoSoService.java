package org.oep.sharedservice.touchscreen.tracuuhoso;

import javax.jws.WebService;

import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCongSoap;

@WebService(name = "TraCuuHoSoService", targetNamespace = "http://tracuuhoso.touchscreen.sharedservice.dtt.vn/")
public interface TraCuuHoSoService {
	
	public TraCuuHoSoTTHCCongSoap getHoSoTTHCCongByMaSoBienNhan(String mabiennhan);	
	
}
