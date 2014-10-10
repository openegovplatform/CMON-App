package org.oep.sharedservice.touchscreen.kios;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.oep.cmon.dao.kios.model.DanhSachCoQuan;
import org.oep.cmon.dao.kios.model.DanhSachCoQuanSoap;
import org.oep.cmon.dao.kios.model.DanhSachHoSo;
import org.oep.cmon.dao.kios.model.DanhSachHoSoSoap;
import org.oep.cmon.dao.kios.model.DanhSachThongKe;
import org.oep.cmon.dao.kios.model.DanhSachThongKeSoap;
import org.oep.cmon.dao.kios.service.DanhSachHoSoLocalServiceUtil;

@WebService(targetNamespace = "http://kios.touchscreen.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.touchscreen.kios.KiosService", portName = "KiosImplPort", serviceName = "KiosImplService")
public class KiosImpl implements KiosService {

	@Override
	public List<DanhSachHoSoSoap> getDanhSachHoSo(String id_coquan, int start,
			int end) {
		// TODO Auto-generated method stub
		try {
			List<DanhSachHoSo> listdshs = DanhSachHoSoLocalServiceUtil.getListHoSo(id_coquan, start, end);
			List<DanhSachHoSoSoap> listdshssoap = new ArrayList<DanhSachHoSoSoap>();
			if(listdshs.size()>0){
				for (int i = 0; i < listdshs.size(); i++) {
					listdshssoap.add(DanhSachHoSoSoap.toSoapModel(listdshs.get(i)));
				}
			}
			return listdshssoap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DanhSachThongKeSoap> getDanhSachThongKe(String arrCapCoQuanid,
			String arrThang, String nam) {
		// TODO Auto-generated method stub
		try {
			List<DanhSachThongKe> listdstk = DanhSachHoSoLocalServiceUtil.getListReportThongKeGroupByIDCoQuan(arrCapCoQuanid, arrThang, nam);
			List<DanhSachThongKeSoap> listdstksoap = new ArrayList<DanhSachThongKeSoap>();
			if(listdstk.size()>0){
				for (int i = 0; i < listdstk.size(); i++) {
					listdstksoap.add(DanhSachThongKeSoap.toSoapModel(listdstk.get(i)));
				}
			}
			return listdstksoap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DanhSachCoQuanSoap> getDanhSachCoQuan(String arrayCapCoQuanId) {
		// TODO Auto-generated method stub
		try {
			List<DanhSachCoQuan> listdscq = DanhSachHoSoLocalServiceUtil.getListCoQuan(arrayCapCoQuanId);
			List<DanhSachCoQuanSoap> listdscqsoap = new ArrayList<DanhSachCoQuanSoap>();
			if(listdscq.size()>0){
				for (int i = 0; i < listdscq.size(); i++) {
					listdscqsoap.add(DanhSachCoQuanSoap.toSoapModel(listdscq.get(i)));
				}
			}
			return listdscqsoap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}



}
