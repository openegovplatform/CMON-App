
package org.oep.sharedservice.touchscreen.tracuuhoso;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2014-07-22T10:04:23.213+07:00
 * Generated source version: 2.6.1
 * 
 */
 
public class TraCuuHoSoServiceServer{

    protected TraCuuHoSoServiceServer() throws Exception {
        Object implementor = new org.oep.sharedservice.touchscreen.tracuuhoso.TraCuuHoSoImpl();
        String address = "http://localhost:9090/TraCuuHoSoImplPort";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new TraCuuHoSoServiceServer();
        
        Thread.sleep(5 * 60 * 1000); 
        System.exit(0);
    }
}
 
 