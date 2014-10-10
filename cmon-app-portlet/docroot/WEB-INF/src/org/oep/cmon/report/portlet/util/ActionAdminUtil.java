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

package org.oep.cmon.report.portlet.util;

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.report.model.CongChuc2Role;
import org.oep.cmon.dao.report.model.DanhMucBaoCao;
import org.oep.cmon.dao.report.model.DanhMucRole;
import org.oep.cmon.dao.report.model.Role2BaoCao;
import org.oep.cmon.dao.report.model.Role2DonViBaoCao;
import org.oep.cmon.dao.report.model.Role2NhomTTHC;
import org.oep.cmon.dao.report.model.Role2TTHC;
import org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil;
import org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.DanhMucBaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2BaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2DonViBaoCaoLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2NhomTTHCLocalServiceUtil;
import org.oep.cmon.dao.report.service.Role2TTHCLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * This is class ActionAdminUtil  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ActionAdminUtil {

	
	/**
	 * This is function get all DMBaocao by TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws Exception
	 * @return List<DanhMucBaoCao>
	 */
	@SuppressWarnings("unchecked")
	public static List<DanhMucBaoCao> getAllDMBaocao(int trangthai)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DanhMucBaoCao.class);
		if (trangthai != 2) {
			query.add(PropertyFactoryUtil.forName("STATUS").eq(trangthai));
		}
		query.addOrder(OrderFactoryUtil.asc("ORDERS"));
		return DanhMucBaoCaoLocalServiceUtil.dynamicQuery(query);
	}

	
	/**
	 * This is function get all DMRole by TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws Exception
	 * @return List<DanhMucRole>
	 */
	@SuppressWarnings("unchecked")
	public static List<DanhMucRole> getAllDMRole(int trangthai)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DanhMucRole.class);
		if (trangthai != 2) {
			query.add(PropertyFactoryUtil.forName("STATUS").eq(trangthai));
		}
		query.addOrder(OrderFactoryUtil.asc("ORDERS"));
		return DanhMucRoleLocalServiceUtil.dynamicQuery(query);
	}

	
	/**
	 * This is function get all CapCoQuanQuanLy by daxoa
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws Exception
	 * @return List<CapCoQuanQuanLy>
	 */
	@SuppressWarnings("unchecked")
	public static List<CapCoQuanQuanLy> getAllCapcoquanquanly(int daxoa)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(CapCoQuanQuanLy.class);
		if (daxoa != 2) {
			query.add(PropertyFactoryUtil.forName("daXoa").eq(daxoa));
		}
		query.addOrder(OrderFactoryUtil.desc("cap"));
		return CapCoQuanQuanLyLocalServiceUtil.dynamicQuery(query);
	}
	
	/**
	 * This is function get all TaiKhoanNguoiDung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param daxoa
	 * @param tennguoidung
	 * @param id_donvi
	 * @param trangthai
	 * @throws Exception
	 * @return List<TaiKhoanNguoiDung>
	 */
	@SuppressWarnings("unchecked")
	public static List<TaiKhoanNguoiDung> getAllTaiKhoanNguoiDung(int daxoa,String tennguoidung,long id_donvi,String trangthai)
			throws Exception {
		List<Long> listidUser = new ArrayList<Long>();
		if(Validator.isNotNull(id_donvi) && id_donvi!=0){
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc.class);
			query.add(PropertyFactoryUtil.forName("coQuanQuanLyId").eq(id_donvi));
			query.setProjection(ProjectionFactoryUtil.property("taiKhoanNguoiDungId"));
			listidUser = CongChucLocalServiceUtil.dynamicQuery(query);
		}
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(TaiKhoanNguoiDung.class);
		if (daxoa != 2) {
			query.add(PropertyFactoryUtil.forName("daXoa").eq(daxoa));
		}
		if(!tennguoidung.equals("")){
			Criterion creterion = RestrictionsFactoryUtil.ilike("tenNguoiDung",StringPool.PERCENT + tennguoidung + StringPool.PERCENT);
					  creterion = RestrictionsFactoryUtil.or(creterion, RestrictionsFactoryUtil.ilike("email", StringPool.PERCENT+ tennguoidung + StringPool.PERCENT));
			query.add(creterion);
//			query.add(PropertyFactoryUtil.forName("tenNguoiDung").like(StringPool.PERCENT + tennguoidung + StringPool.PERCENT));
		}
		
		if(trangthai.equals("1")){
			DynamicQuery query2 = DynamicQueryFactoryUtil.forClass(CongChuc2Role.class);
			query2.setProjection(ProjectionFactoryUtil.property("CONGCHUCID"));
			List<Long> idu = CongChuc2RoleLocalServiceUtil.dynamicQuery(query2);
			query.add(PropertyFactoryUtil.forName("id").in(idu.toArray()));
		}else if(trangthai.equals("0")){
			DynamicQuery query2 = DynamicQueryFactoryUtil.forClass(CongChuc2Role.class);
			query2.setProjection(ProjectionFactoryUtil.property("CONGCHUCID"));
			query.add(PropertyFactoryUtil.forName("id").notIn(query2));
		}
		
		if(listidUser.size()>0){
			query.add(PropertyFactoryUtil.forName("id").in(listidUser.toArray()));
		}
		query.addOrder(OrderFactoryUtil.asc("id"));
		return TaiKhoanNguoiDungLocalServiceUtil.dynamicQuery(query);
	}
	
	
	/**
	 * This is function check role in CongChucRole
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkRoleInCongchucRole(long role_id)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(CongChuc2Role.class);
			query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		List<CongChuc2Role> listresult = CongChuc2RoleLocalServiceUtil.dynamicQuery(query);
		if(listresult.size()>0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * This is function check role by UserId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tkNguoidungId
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkRoleByIdUser(long tkNguoidungId)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(CongChuc2Role.class);
			query.add(PropertyFactoryUtil.forName("CONGCHUCID").eq(tkNguoidungId));
		List<CongChuc2Role> listresult = CongChuc2RoleLocalServiceUtil.dynamicQuery(query);
		if(listresult.size()>0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * This is function check BaoCao in Role2BaoCao
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param baocao_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkBaocaoInRole2Baocao(long baocao_id)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2BaoCao.class);
			query.add(PropertyFactoryUtil.forName("RPDANHMUCBAOCAOID").eq(baocao_id));
		List<Role2BaoCao> listresult = Role2BaoCaoLocalServiceUtil.dynamicQuery(query);
		if(listresult.size()>0){
			return true;
		}
		return false;
	}
	

	
	/**
	 * This is function delete Role2BaoCao
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static void deleteRole2Baocao(long role_id) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2BaoCao.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		List<Role2BaoCao> listresult = Role2BaoCaoLocalServiceUtil
				.dynamicQuery(query);
		for (int i = 0; i < listresult.size(); i++) {
			Role2BaoCaoLocalServiceUtil.deleteRole2BaoCao(listresult.get(i)
					.getID());
		}
	}

	
	/**
	 * This is function delete Role2DonViBaoCao
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static void deleteRole2DonviBaocao(long role_id) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2DonViBaoCao.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		List<Role2DonViBaoCao> listresult = Role2DonViBaoCaoLocalServiceUtil
				.dynamicQuery(query);
		for (int i = 0; i < listresult.size(); i++) {
			Role2DonViBaoCaoLocalServiceUtil.deleteRole2DonViBaoCao(listresult
					.get(i).getID());
		}
	}

	
	/**
	 * This is function delete Role2NhomTTHC
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static void deleteRole2NhomTTHC(long role_id) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2NhomTTHC.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		List<Role2NhomTTHC> listresult = Role2NhomTTHCLocalServiceUtil
				.dynamicQuery(query);
		for (int i = 0; i < listresult.size(); i++) {
			Role2NhomTTHCLocalServiceUtil.deleteRole2NhomTTHC(listresult.get(i)
					.getID());
		}
	}

	
	/**
	 * This is function delete Role2TTHC
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static void deleteRole2TTHC(long role_id) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Role2TTHC.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		List<Role2TTHC> listresult = Role2TTHCLocalServiceUtil
				.dynamicQuery(query);
		for (int i = 0; i < listresult.size(); i++) {
			Role2TTHCLocalServiceUtil
					.deleteRole2TTHC(listresult.get(i).getID());
		}
	}
	
	
	/**
	 * This is function delete Role2NhomTTHC
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static void deleteUserRoleByTkNguoiDungId(long tkNguoidungId) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc2Role.class);
		query.add(PropertyFactoryUtil.forName("CONGCHUCID").eq(tkNguoidungId));
		List<CongChuc2Role> listresult = CongChuc2RoleLocalServiceUtil.dynamicQuery(query);
		for (int i = 0; i < listresult.size(); i++) {
			CongChuc2RoleLocalServiceUtil.deleteCongChuc2Role(listresult.get(i).getID());
		}
	}
	
	/**
	 * This is function delete Role2NhomTTHC
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static void deleteTkNguoiDungByRoleId(long roleId,String[] tkNguoiDungId) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc2Role.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(roleId));
		List<CongChuc2Role> listresult = CongChuc2RoleLocalServiceUtil.dynamicQuery(query);
		for (int i = 0; i < listresult.size(); i++) {
			for(int j=0;j<tkNguoiDungId.length;j++){
				if(listresult.get(i).getCONGCHUCID()==Long.valueOf(tkNguoiDungId[j])){
					CongChuc2RoleLocalServiceUtil.deleteCongChuc2Role(listresult.get(i).getID());	
				}
			}
		}
	}

	/**
	 * This is function get BaoCao by RoleId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> getBaocaoByRoleId(long role_id) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2BaoCao.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		query.setProjection(ProjectionFactoryUtil.property("RPDANHMUCBAOCAOID"));
		List<Long> listresult = Role2BaoCaoLocalServiceUtil.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get DonViBaoCao by RoleId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @param id_baocao
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> getDovibaocaoByRoleId(long role_id, long id_baocao)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2DonViBaoCao.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		query.add(PropertyFactoryUtil.forName("RPDANHMUCBAOCAOID")
				.eq(id_baocao));
		query.setProjection(ProjectionFactoryUtil.property("COQUANQUANLYID"));
		List<Long> listresult = Role2DonViBaoCaoLocalServiceUtil
				.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get LinhVuc by RoleId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @param id_baocao
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> getLinhvucByRoleId(long role_id, long id_baocao)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Role2NhomTTHC.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		query.add(PropertyFactoryUtil.forName("RPDANHMUCBAOCAOID")
				.eq(id_baocao));
		query.setProjection(ProjectionFactoryUtil
				.property("NHOMTHUTUCHANHCHINHID"));
		List<Long> listresult = Role2NhomTTHCLocalServiceUtil
				.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get LoaiHoSo by RoleId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param role_id
	 * @param id_baocao
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> getLoaihosoByRoleId(long role_id, long id_baocao)
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Role2TTHC.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(role_id));
		query.add(PropertyFactoryUtil.forName("RPDANHMUCBAOCAOID")
				.eq(id_baocao));
		query.setProjection(ProjectionFactoryUtil.property("THUTUCHANHCHINHID"));
		List<Long> listresult = Role2TTHCLocalServiceUtil.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get NhomTTHC by NhomTTHCId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_nhomtthc
	 * @throws Exception
	 * @return List<NhomThuTucHanhChinh>
	 */
	@SuppressWarnings("unchecked")
	public static List<NhomThuTucHanhChinh> getNhomTTHCByIdNhomTTHC(
			List<Long> id_nhomtthc) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(NhomThuTucHanhChinh.class);
		query.add(PropertyFactoryUtil.forName("id").in(id_nhomtthc.toArray()));
		query.add(PropertyFactoryUtil.forName("daXoa").eq(0));
		query.addOrder(OrderFactoryUtil.asc("id"));
		List<NhomThuTucHanhChinh> listresult = NhomThuTucHanhChinhLocalServiceUtil
				.dynamicQuery(query);
		return listresult;
	}

	/**
	 * This is function get TTHC by NhomTTHCId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_nhomtthc
	 * @param id_donvi
	 * @throws Exception
	 * @return List<ThuTucHanhChinh>
	 */
	public static List<ThuTucHanhChinh> getTTHCByIdNhomTTHC(List<Long> id_nhomtthc,String id_donvi) throws Exception {
		String str_nhomtthc ="";
		for (int k = 0; k < id_nhomtthc.size(); k++) {
			str_nhomtthc += id_nhomtthc.get(k);
			if(k<(id_nhomtthc.size()-1)){
				str_nhomtthc += ",";
			}
		}
		List<ThuTucHanhChinh> listresult = CoQuanQuanLy2LinhVucLocalServiceUtil.getTTHC(str_nhomtthc, id_donvi); 
		return listresult;
	}
	
	/**
	 * This is function get Role by TKNguoiDungId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tkNguoidungId
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> getRoleByTkNguoiDungId(long tkNguoidungId) 
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc2Role.class);
		query.add(PropertyFactoryUtil.forName("CONGCHUCID").eq(tkNguoidungId));
		query.setProjection(ProjectionFactoryUtil.property("RPDANHMUCROLEID"));
		List<Long> listresult = CongChuc2RoleLocalServiceUtil.dynamicQuery(query);
		return listresult;
	}
	
	/**
	 * This is function get TkNguoiDung by RoleId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param RoleId
	 * @throws Exception
	 * @return List<Long>
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> getTkNguoiDungByRoleId(long roleId) 
			throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc2Role.class);
		query.add(PropertyFactoryUtil.forName("RPDANHMUCROLEID").eq(roleId));
		query.setProjection(ProjectionFactoryUtil.property("CONGCHUCID"));
		List<Long> listresult = CongChuc2RoleLocalServiceUtil.dynamicQuery(query);
		return listresult;
	}
	
	
	

}
