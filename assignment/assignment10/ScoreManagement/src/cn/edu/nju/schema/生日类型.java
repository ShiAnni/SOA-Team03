
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for �������� complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="��������">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="��" type="{http://www.nju.edu.cn/schema}������"/>
 *         &lt;element name="��" type="{http://www.nju.edu.cn/schema}������"/>
 *         &lt;element name="��" type="{http://www.nju.edu.cn/schema}������"/>
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
public class �������� {

    protected int ��;
    protected int ��;
    protected int ��;

    /**
     * Gets the value of the �� property.
     * 
     */
    public int get��() {
        return ��;
    }

    /**
     * Sets the value of the �� property.
     * 
     */
    public void set��(int value) {
        this.�� = value;
    }

    /**
     * Gets the value of the �� property.
     * 
     */
    public int get��() {
        return ��;
    }

    /**
     * Sets the value of the �� property.
     * 
     */
    public void set��(int value) {
        this.�� = value;
    }

    /**
     * Gets the value of the �� property.
     * 
     */
    public int get��() {
        return ��;
    }

    /**
     * Sets the value of the �� property.
     * 
     */
    public void set��(int value) {
        this.�� = value;
    }

}
