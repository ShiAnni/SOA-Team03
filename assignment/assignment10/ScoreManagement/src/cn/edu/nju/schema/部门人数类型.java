
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>部门人数类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="部门人数类型">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *       &lt;attribute name="类型" type="{http://www.nju.edu.cn/schema}部门人员类型" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u90e8\u95e8\u4eba\u6570\u7c7b\u578b", propOrder = {
    "value"
})
public class 部门人数类型 {

    @XmlValue
    protected int value;
    @XmlAttribute
    protected 部门人员类型 类型;

    /**
     * 获取value属性的值。
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 获取类型属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 部门人员类型 }
     *     
     */
    public 部门人员类型 get类型() {
        return 类型;
    }

    /**
     * 设置类型属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 部门人员类型 }
     *     
     */
    public void set类型(部门人员类型 value) {
        this.类型 = value;
    }

}
