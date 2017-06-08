
package cn.edu.nju.jw.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cn.edu.nju.schema.个人基本信息类型;


/**
 * <p>Java class for 学生类型 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the 学生基本信息 property.
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
     * Sets the value of the 学生基本信息 property.
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
     * Gets the value of the 课程成绩列表 property.
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
     * Sets the value of the 课程成绩列表 property.
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
     * Gets the value of the 学号 property.
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
     * Sets the value of the 学号 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set学号(String value) {
        this.学号 = value;
    }

}
