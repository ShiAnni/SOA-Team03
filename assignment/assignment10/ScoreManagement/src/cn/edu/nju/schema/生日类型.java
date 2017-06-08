
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for 生日类型 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="生日类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="年" type="{http://www.nju.edu.cn/schema}年类型"/>
 *         &lt;element name="月" type="{http://www.nju.edu.cn/schema}月类型"/>
 *         &lt;element name="日" type="{http://www.nju.edu.cn/schema}日类型"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u751f\u65e5\u7c7b\u578b", propOrder = {
    "\u5e74",
    "\u6708",
    "\u65e5"
})
public class 生日类型 {

    protected int 年;
    protected int 月;
    protected int 日;

    /**
     * Gets the value of the 年 property.
     * 
     */
    public int get年() {
        return 年;
    }

    /**
     * Sets the value of the 年 property.
     * 
     */
    public void set年(int value) {
        this.年 = value;
    }

    /**
     * Gets the value of the 月 property.
     * 
     */
    public int get月() {
        return 月;
    }

    /**
     * Sets the value of the 月 property.
     * 
     */
    public void set月(int value) {
        this.月 = value;
    }

    /**
     * Gets the value of the 日 property.
     * 
     */
    public int get日() {
        return 日;
    }

    /**
     * Sets the value of the 日 property.
     * 
     */
    public void set日(int value) {
        this.日 = value;
    }

}
