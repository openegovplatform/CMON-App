
package org.oep.sharedservice.touchscreen.tracuuhoso.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.1
 * Tue Jul 22 10:04:23 ICT 2014
 * Generated source version: 2.6.1
 */

@XmlRootElement(name = "getHoSoTTHCCongByMaSoBienNhanResponse", namespace = "http://tracuuhoso.touchscreen.sharedservice.dtt.vn/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHoSoTTHCCongByMaSoBienNhanResponse", namespace = "http://tracuuhoso.touchscreen.sharedservice.dtt.vn/")

public class GetHoSoTTHCCongByMaSoBienNhanResponse {

    @XmlElement(name = "return")
    private vn.dtt.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCongSoap _return;

    public vn.dtt.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCongSoap getReturn() {
        return this._return;
    }

    public void setReturn(vn.dtt.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCongSoap new_return)  {
        this._return = new_return;
    }

}
