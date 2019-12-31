
package org.kd.ws.jaxws;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "getHelloWorldAsString", namespace = "org.kd")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHelloWorldAsString", namespace = "org.kd")
public class GetHelloWorldAsString {

    @XmlElement(name = "arg0", namespace = "")
    private String arg0;

    /**
     * @return returns String
     */
    public String getArg0() {
        return this.arg0;
    }

    /**
     * @param arg0 the value for the arg0 property
     */
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

}
