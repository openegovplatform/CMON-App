
package org.oep.sharedservice.touchscreen.tracuutthc.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.1
 * Mon Jul 21 12:17:29 ICT 2014
 * Generated source version: 2.6.1
 */

@XmlRootElement(name = "getTTHCByIdNhomTTHC", namespace = "http://tracuutthc.touchscreen.sharedservice.dtt.vn/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTTHCByIdNhomTTHC", namespace = "http://tracuutthc.touchscreen.sharedservice.dtt.vn/", propOrder = {"arg0", "arg1"})

public class GetTTHCByIdNhomTTHC {

    @XmlElement(name = "arg0")
    private java.lang.Long arg0;
    @XmlElement(name = "arg1")
    private java.lang.Long arg1;

    public java.lang.Long getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.Long newArg0)  {
        this.arg0 = newArg0;
    }

    public java.lang.Long getArg1() {
        return this.arg1;
    }

    public void setArg1(java.lang.Long newArg1)  {
        this.arg1 = newArg1;
    }

}

