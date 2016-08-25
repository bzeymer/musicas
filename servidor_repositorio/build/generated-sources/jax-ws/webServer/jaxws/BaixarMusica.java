
package webServer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "baixarMusica", namespace = "http://webServer/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baixarMusica", namespace = "http://webServer/")
public class BaixarMusica {

    @XmlElement(name = "id", namespace = "")
    private Integer id;

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     *     the value for the id property
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
