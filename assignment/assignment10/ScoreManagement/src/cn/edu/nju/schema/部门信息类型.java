
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ������Ϣ���� complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="������Ϣ����">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="��������" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="���Ź�ģ" type="{http://www.nju.edu.cn/schema}���Ź�ģ����"/>
 *       &lt;/all>
 *       &lt;attribute name="���ű��" type="{http://www.nju.edu.cn/schema}���ű������" />
 *       &lt;attribute name="��������" type="{http://www.nju.edu.cn/schema}������������" />
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
public class ������Ϣ���� {

    @XmlElement(required = true)
    protected String ��������;
    @XmlElement(required = true)
    protected ���Ź�ģ���� ���Ź�ģ;
    @XmlAttribute
    protected String ���ű��;
    @XmlAttribute
    protected ������������ ��������;

    /**
     * Gets the value of the �������� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get��������() {
        return ��������;
    }

    /**
     * Sets the value of the �������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set��������(String value) {
        this.�������� = value;
    }

    /**
     * Gets the value of the ���Ź�ģ property.
     * 
     * @return
     *     possible object is
     *     {@link ���Ź�ģ���� }
     *     
     */
    public ���Ź�ģ���� get���Ź�ģ() {
        return ���Ź�ģ;
    }

    /**
     * Sets the value of the ���Ź�ģ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ���Ź�ģ���� }
     *     
     */
    public void set���Ź�ģ(���Ź�ģ���� value) {
        this.���Ź�ģ = value;
    }

    /**
     * Gets the value of the ���ű�� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get���ű��() {
        return ���ű��;
    }

    /**
     * Sets the value of the ���ű�� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set���ű��(String value) {
        this.���ű�� = value;
    }

    /**
     * Gets the value of the �������� property.
     * 
     * @return
     *     possible object is
     *     {@link ������������ }
     *     
     */
    public ������������ get��������() {
        return ��������;
    }

    /**
     * Sets the value of the �������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link ������������ }
     *     
     */
    public void set��������(������������ value) {
        this.�������� = value;
    }

}
