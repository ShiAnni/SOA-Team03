
package cn.edu.nju.jw.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>验证类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="验证类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="学号" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="权限" type="{http://jw.nju.edu.cn/schema}权限级别"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u9a8c\u8bc1\u7c7b\u578b", propOrder = {
    "\u5b66\u53f7",
    "\u6743\u9650"
})
public class 验证类型 {

    @XmlElement(required = true)
    protected String 学号;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected 权限级别 权限;

    /**
     * 获取学号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get学号() {
        return 学号;
    }

    /**
     * 设置学号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set学号(String value) {
        this.学号 = value;
    }

    /**
     * 获取权限属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 权限级别 }
     *     
     */
    public 权限级别 get权限() {
        return 权限;
    }

    /**
     * 设置权限属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 权限级别 }
     *     
     */
    public void set权限(权限级别 value) {
        this.权限 = value;
    }

}
