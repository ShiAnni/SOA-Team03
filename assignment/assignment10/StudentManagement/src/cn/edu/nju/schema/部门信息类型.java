
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>部门信息类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取部门名称属性的值。
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
     * 设置部门名称属性的值。
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
     * 获取部门规模属性的值。
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
     * 设置部门规模属性的值。
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
     * 获取部门编号属性的值。
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
     * 设置部门编号属性的值。
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
     * 获取部门类型属性的值。
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
     * 设置部门类型属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 部门类型类型 }
     *     
     */
    public void set部门类型(部门类型类型 value) {
        this.部门类型 = value;
    }

	@Override
	public String toString() {
		return "部门信息类型 [部门名称=" + 部门名称 + ", 部门规模=" + 部门规模 + ", 部门编号=" + 部门编号 + ", 部门类型=" + 部门类型 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((部门名称 == null) ? 0 : 部门名称.hashCode());
		result = prime * result + ((部门类型 == null) ? 0 : 部门类型.hashCode());
		result = prime * result + ((部门编号 == null) ? 0 : 部门编号.hashCode());
		result = prime * result + ((部门规模 == null) ? 0 : 部门规模.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		部门信息类型 other = (部门信息类型) obj;
		if (部门名称 == null) {
			if (other.部门名称 != null)
				return false;
		} else if (!部门名称.equals(other.部门名称))
			return false;
		if (部门类型 != other.部门类型)
			return false;
		if (部门编号 == null) {
			if (other.部门编号 != null)
				return false;
		} else if (!部门编号.equals(other.部门编号))
			return false;
		if (部门规模 == null) {
			if (other.部门规模 != null)
				return false;
		} else if (!部门规模.equals(other.部门规模))
			return false;
		return true;
	}
    
    

}
