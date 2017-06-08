
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ���˻�����Ϣ���� complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="���˻�����Ϣ����">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="����" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="�Ա�" type="{http://www.nju.edu.cn/schema}�Ա�����"/>
 *         &lt;element name="��������" type="{http://www.nju.edu.cn/schema}��������"/>
 *         &lt;element name="��ѧ���" type="{http://www.nju.edu.cn/schema}������"/>
 *         &lt;element name="�ֻ�" type="{http://www.nju.edu.cn/schema}�ֻ�����"/>
 *         &lt;element name="��ͥסַ" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.nju.edu.cn/schema}������Ϣ"/>
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
public class ���˻�����Ϣ���� {

    @XmlElement(required = true)
    protected String ����;
    @XmlElement(required = true)
    protected �Ա����� �Ա�;
    @XmlElement(required = true)
    protected �������� ��������;
    protected int ��ѧ���;
    @XmlElement(required = true)
    protected String �ֻ�;
    @XmlElement(required = true)
    protected String ��ͥסַ;
    @XmlElement(required = true)
    protected ������Ϣ���� ������Ϣ;

    /**
     * Gets the value of the ���� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get����() {
        return ����;
    }

    /**
     * Sets the value of the ���� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set����(String value) {
        this.���� = value;
    }

    /**
     * Gets the value of the �Ա� property.
     * 
     * @return
     *     possible object is
     *     {@link �Ա����� }
     *     
     */
    public �Ա����� get�Ա�() {
        return �Ա�;
    }

    /**
     * Sets the value of the �Ա� property.
     * 
     * @param value
     *     allowed object is
     *     {@link �Ա����� }
     *     
     */
    public void set�Ա�(�Ա����� value) {
        this.�Ա� = value;
    }

    /**
     * Gets the value of the �������� property.
     * 
     * @return
     *     possible object is
     *     {@link �������� }
     *     
     */
    public �������� get��������() {
        return ��������;
    }

    /**
     * Sets the value of the �������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link �������� }
     *     
     */
    public void set��������(�������� value) {
        this.�������� = value;
    }

    /**
     * Gets the value of the ��ѧ��� property.
     * 
     */
    public int get��ѧ���() {
        return ��ѧ���;
    }

    /**
     * Sets the value of the ��ѧ��� property.
     * 
     */
    public void set��ѧ���(int value) {
        this.��ѧ��� = value;
    }

    /**
     * Gets the value of the �ֻ� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get�ֻ�() {
        return �ֻ�;
    }

    /**
     * Sets the value of the �ֻ� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set�ֻ�(String value) {
        this.�ֻ� = value;
    }

    /**
     * Gets the value of the ��ͥסַ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get��ͥסַ() {
        return ��ͥסַ;
    }

    /**
     * Sets the value of the ��ͥסַ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set��ͥסַ(String value) {
        this.��ͥסַ = value;
    }

    /**
     * Gets the value of the ������Ϣ property.
     * 
     * @return
     *     possible object is
     *     {@link ������Ϣ���� }
     *     
     */
    public ������Ϣ���� get������Ϣ() {
        return ������Ϣ;
    }

    /**
     * Sets the value of the ������Ϣ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ������Ϣ���� }
     *     
     */
    public void set������Ϣ(������Ϣ���� value) {
        this.������Ϣ = value;
    }

}
