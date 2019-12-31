
package org.kd.ws.jaxws;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "getHelloWorldAsStringResponse", namespace = "org.kd")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHelloWorldAsStringResponse", namespace = "org.kd")
public class GetHelloWorldAsStringResponse {

    @XmlElement(name = "return", namespace = "")
    private String _return;

    /**
     * @return returns String
     */
    public String getReturn() {
        return this._return;
    }

    /**
     * @param _return the value for the _return property
     */
    public void setReturn(String _return) {
        this._return = _return;
    }

}
