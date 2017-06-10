
package cn.edu.nju.jw.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cn.edu.nju.schema.个人基本信息类型;


/**
 * <p>学生类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="学生类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{http://www.nju.edu.cn/schema}学生基本信息"/>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}课程成绩列表"/>
 *       &lt;/all>
 *       &lt;attribute name="学号" type="{http://jw.nju.edu.cn/schema}学号类型" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u5b66\u751f\u7c7b\u578b", propOrder = {

})
public class 学生类型 {

    @XmlElement(namespace = "http://www.nju.edu.cn/schema", required = true)
    protected 个人基本信息类型 学生基本信息;
    @XmlElement(required = true)
    protected 课程成绩列表类型 课程成绩列表;
    @XmlAttribute
    protected String 学号;

    /**
     * 获取学生基本信息属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 个人基本信息类型 }
     *     
     */
    public 个人基本信息类型 get学生基本信息() {
        return 学生基本信息;
    }

    /**
     * 设置学生基本信息属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 个人基本信息类型 }
     *     
     */
    public void set学生基本信息(个人基本信息类型 value) {
        this.学生基本信息 = value;
    }

    /**
     * 获取课程成绩列表属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 课程成绩列表类型 }
     *     
     */
    public 课程成绩列表类型 get课程成绩列表() {
        return 课程成绩列表;
    }

    /**
     * 设置课程成绩列表属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 课程成绩列表类型 }
     *     
     */
    public void set课程成绩列表(课程成绩列表类型 value) {
        this.课程成绩列表 = value;
    }

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((学号 == null) ? 0 : 学号.hashCode());
		result = prime * result + ((学生基本信息 == null) ? 0 : 学生基本信息.hashCode());
		result = prime * result + ((课程成绩列表 == null) ? 0 : 课程成绩列表.hashCode());
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
		学生类型 other = (学生类型) obj;
		if (学号 == null) {
			if (other.学号 != null)
				return false;
		} else if (!学号.equals(other.学号))
			return false;
		if (学生基本信息 == null) {
			if (other.学生基本信息 != null)
				return false;
		} else if (!学生基本信息.equals(other.学生基本信息))
			return false;
		if (课程成绩列表 == null) {
			if (other.课程成绩列表 != null)
				return false;
		} else if (!课程成绩列表.equals(other.课程成绩列表))
			return false;
		return true;
	}

	

}
