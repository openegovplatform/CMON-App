package org.oep.sharedservice.cmon.provider.thamso;


import java.util.List;

import javax.jws.WebService;


import org.oep.cmon.dao.thamso.model.AnhXaSoap;





@WebService(name = "IThamSoService", targetNamespace = "http://thamso.provider.cmon.sharedservice.dtt.vn/")
public interface IThamSoService {
	
	public AnhXaSoap getAnhXa(AnhXaInput input);
	public List<AnhXaSoap> getAnhXas(List<AnhXaInput> anhXas);
	
	public String getValue(String name);
	public List<String> getValues(List<String> keys);
	

}
