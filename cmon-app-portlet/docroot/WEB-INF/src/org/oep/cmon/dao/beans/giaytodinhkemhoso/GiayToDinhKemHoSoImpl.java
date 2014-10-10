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
package org.oep.cmon.dao.beans.giaytodinhkemhoso;

import org.oep.sharedservice.cmon.provider.officer.OfficerServiceImpl;

@SuppressWarnings("serial")
public class GiayToDinhKemHoSoImpl extends BaseGiayToDinhKemHoSoImpl {
	
	public String getDownloadLink() {
		
		String link = super.getDownloadLink();
		
		if (link.isEmpty() && getNoiLuuTruTaiLieuId(true) != 0L) {
			link = new OfficerServiceImpl().getURLCuaGiayToDinhKem(getNoiLuuTruTaiLieuId(true));
			setDownloadLink(link);
		}
		
		return link;
	}
	
	public GiayToDinhKemHoSoImpl() {}
}