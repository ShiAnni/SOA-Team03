
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>个人基本信息类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="个人基本信息类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="姓名" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="性别" type="{http://www.nju.edu.cn/schema}性别类型"/>
 *         &lt;element name="出生日期" type="{http://www.nju.edu.cn/schema}生日类型"/>
 *         &lt;element name="入学年份" type="{http://www.nju.edu.cn/schema}年类型"/>
 *         &lt;element name="手机" type="{http://www.nju.edu.cn/schema}手机类型"/>
 *         &lt;element name="家庭住址" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.nju.edu.cn/schema}部门信息"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u4e2a\u4eba\u57fa\u672c\u4fe1\u606f\u7c7b\u578b", propOrder = {

})
public class 个人基本信息类型 {

    @XmlElement(required = true)
    protected String 姓名;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected 性别类型 性别;
    @XmlElement(required = true)
    protected 生日类型 出生日期;
    protected int 入学年份;
    @XmlElement(required = true)
    protected String 手机;
    @XmlElement(required = true)
    protected String 家庭住址;
    @XmlElement(required = true)
    protected 部门信息类型 部门信息;

    /**
     * 获取姓名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get姓名() {
        return 姓名;
    }

    /**
     * 设置姓名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set姓名(String value) {
        this.姓名 = value;
    }

    /**
     * 获取性别属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 性别类型 }
     *     
     */
    public 性别类型 get性别() {
        return 性别;
    }

    /**
     * 设置性别属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 性别类型 }
     *     
     */
    public void set性别(性别类型 value) {
        this.性别 = value;
    }

    /**
     * 获取出生日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 生日类型 }
     *     
     */
    public 生日类型 get出生日期() {
        return 出生日期;
    }

    /**
     * 设置出生日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 生日类型 }
     *     
     */
    public void set出生日期(生日类型 value) {
        this.出生日期 = value;
    }

    /**
     * 获取入学年份属性的值。
     * 
     */
    public int get入学年份() {
        return 入学年份;
    }

    /**
     * 设置入学年份属性的值。
     * 
     */
    public void set入学年份(int value) {
        this.入学年份 = value;
    }

    /**
     * 获取手机属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get手机() {
        return 手机;
    }

    /**
     * 设置手机属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set手机(String value) {
        this.手机 = value;
    }

    /**
     * 获取家庭住址属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get家庭住址() {
        return 家庭住址;
    }

    /**
     * 设置家庭住址属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set家庭住址(String value) {
        this.家庭住址 = value;
    }

    /**
     * 获取部门信息属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 部门信息类型 }
     *     
     */
    public 部门信息类型 get部门信息() {
        return 部门信息;
    }

    /**
     * 设置部门信息属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 部门信息类型 }
     *     
     */
    public void set部门信息(部门信息类型 value) {
        this.部门信息 = value;
    }

	@Override
	public String toString() {
		return "个人基本信息类型 [姓名=" + 姓名 + ", 性别=" + 性别 + ", 出生日期=" + 出生日期 + ", 入学年份=" + 入学年份 + ", 手机=" + 手机 + ", 家庭住址="
				+ 家庭住址 + ", 部门信息=" + 部门信息 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + 入学年份;
		result = prime * result + ((出生日期 == null) ? 0 : 出生日期.hashCode());
		result = prime * result + ((姓名 == null) ? 0 : 姓名.hashCode());
		result = prime * result + ((家庭住址 == null) ? 0 : 家庭住址.hashCode());
		result = prime * result + ((性别 == null) ? 0 : 性别.hashCode());
		result = prime * result + ((手机 == null) ? 0 : 手机.hashCode());
		result = prime * result + ((部门信息 == null) ? 0 : 部门信息.hashCode());
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
		个人基本信息类型 other = (个人基本信息类型) obj;
		if (入学年份 != other.入学年份)
			return false;
		if (出生日期 == null) {
			if (other.出生日期 != null)
				return false;
		} else if (!出生日期.equals(other.出生日期))
			return false;
		if (姓名 == null) {
			if (other.姓名 != null)
				return false;
		} else if (!姓名.equals(other.姓名))
			return false;
		if (家庭住址 == null) {
			if (other.家庭住址 != null)
				return false;
		} else if (!家庭住址.equals(other.家庭住址))
			return false;
		if (性别 != other.性别)
			return false;
		if (手机 == null) {
			if (other.手机 != null)
				return false;
		} else if (!手机.equals(other.手机))
			return false;
		if (部门信息 == null) {
			if (other.部门信息 != null)
				return false;
		} else if (!部门信息.equals(other.部门信息))
			return false;
		return true;
	}
    
    
	
}
