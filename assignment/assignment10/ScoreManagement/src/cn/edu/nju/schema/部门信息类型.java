
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for 部门信息类型 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="部门信息类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="部门名称" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="部门规模" type="{http://www.nju.edu.cn/schema}部门规模类型"/>
 *       &lt;/all>
 *       &lt;attribute name="部门编号" type="{http://www.nju.edu.cn/schema}部门编号类型" />
 *       &lt;attribute name="部门类型" type="{http://www.nju.edu.cn/schema}部门类型类型" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u90e8\u95e8\u4fe1\u606f\u7c7b\u578b", propOrder = {

})
public class 部门信息类型 {

    @XmlElement(required = true)
    protected String 部门名称;
    @XmlElement(required = true)
    protected 部门规模类型 部门规模;
    @XmlAttribute
    protected String 部门编号;
    @XmlAttribute
    protected 部门类型类型 部门类型;

    /**
     * Gets the value of the 部门名称 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get部门名称() {
        return 部门名称;
    }

    /**
     * Sets the value of the 部门名称 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set部门名称(String value) {
        this.部门名称 = value;
    }

    /**
     * Gets the value of the 部门规模 property.
     * 
     * @return
     *     possible object is
     *     {@link 部门规模类型 }
     *     
     */
    public 部门规模类型 get部门规模() {
        return 部门规模;
    }

    /**
     * Sets the value of the 部门规模 property.
     * 
     * @param value
     *     allowed object is
     *     {@link 部门规模类型 }
     *     
     */
    public void set部门规模(部门规模类型 value) {
        this.部门规模 = value;
    }

    /**
     * Gets the value of the 部门编号 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get部门编号() {
        return 部门编号;
    }

    /**
     * Sets the value of the 部门编号 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set部门编号(String value) {
        this.部门编号 = value;
    }

    /**
     * Gets the value of the 部门类型 property.
     * 
     * @return
     *     possible object is
     *     {@link 部门类型类型 }
     *     
     */
    public 部门类型类型 get部门类型() {
        return 部门类型;
    }

    /**
     * Sets the value of the 部门类型 property.
     * 
     * @param value
     *     allowed object is
     *     {@link 部门类型类型 }
     *     
     */
    public void set部门类型(部门类型类型 value) {
        this.部门类型 = value;
    }

}
