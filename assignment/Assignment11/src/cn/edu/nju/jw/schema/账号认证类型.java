
package cn.edu.nju.jw.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>账号认证类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="账号认证类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="邮箱" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="密码" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u8d26\u53f7\u8ba4\u8bc1\u7c7b\u578b", propOrder = {
    "\u90ae\u7bb1",
    "\u5bc6\u7801"
})
public class 账号认证类型 {

    @XmlElement(required = true)
    protected String 邮箱;
    @XmlElement(required = true)
    protected String 密码;

    /**
     * 获取邮箱属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get邮箱() {
        return 邮箱;
    }

    /**
     * 设置邮箱属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set邮箱(String value) {
        this.邮箱 = value;
    }

    /**
     * 获取密码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get密码() {
        return 密码;
    }

    /**
     * 设置密码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set密码(String value) {
        this.密码 = value;
    }

}
