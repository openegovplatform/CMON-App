
package org.oep.sharedservice.cmon.provider.thamso.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.1
 * Wed Sep 25 11:13:47 ICT 2013
 * Generated source version: 2.6.1
 */

@XmlRootElement(name = "getAnhXas", namespace = "http://thamso.provider.cmon.sharedservice.dtt.vn/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAnhXas", namespace = "http://thamso.provider.cmon.sharedservice.dtt.vn/")

public class GetAnhXas {

    @XmlElement(name = "arg0")
    private java.util.List<org.oep.sharedservice.cmon.provider.thamso.AnhXaInput> arg0;

    public java.util.List<org.oep.sharedservice.cmon.provider.thamso.AnhXaInput> getArg0() {
        return this.arg0;
    }

    public void setArg0(java.util.List<org.oep.sharedservice.cmon.provider.thamso.AnhXaInput> newArg0)  {
        this.arg0 = newArg0;
    }

}

