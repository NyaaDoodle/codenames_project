//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.08 at 06:42:49 PM IDT 
//


package engine.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ECN-Game-Words"/>
 *         &lt;element ref="{}ECN-Black-Words"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ecnGameWords",
    "ecnBlackWords"
})
@XmlRootElement(name = "ECN-Words")
public class ECNWords {

    @XmlElement(name = "ECN-Game-Words", required = true)
    protected String ecnGameWords;
    @XmlElement(name = "ECN-Black-Words", required = true)
    protected String ecnBlackWords;

    /**
     * Gets the value of the ecnGameWords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECNGameWords() {
        return ecnGameWords;
    }

    /**
     * Sets the value of the ecnGameWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECNGameWords(String value) {
        this.ecnGameWords = value;
    }

    /**
     * Gets the value of the ecnBlackWords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECNBlackWords() {
        return ecnBlackWords;
    }

    /**
     * Sets the value of the ecnBlackWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECNBlackWords(String value) {
        this.ecnBlackWords = value;
    }

}
