
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>���˻�����Ϣ���� complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
    @XmlSchemaType(name = "string")
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
     * ��ȡ�������Ե�ֵ��
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
     * �����������Ե�ֵ��
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
     * ��ȡ�Ա����Ե�ֵ��
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
     * �����Ա����Ե�ֵ��
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
     * ��ȡ�����������Ե�ֵ��
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
     * ���ó����������Ե�ֵ��
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
     * ��ȡ��ѧ������Ե�ֵ��
     * 
     */
    public int get��ѧ���() {
        return ��ѧ���;
    }

    /**
     * ������ѧ������Ե�ֵ��
     * 
     */
    public void set��ѧ���(int value) {
        this.��ѧ��� = value;
    }

    /**
     * ��ȡ�ֻ����Ե�ֵ��
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
     * �����ֻ����Ե�ֵ��
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
     * ��ȡ��ͥסַ���Ե�ֵ��
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
     * ���ü�ͥסַ���Ե�ֵ��
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
     * ��ȡ������Ϣ���Ե�ֵ��
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
     * ���ò�����Ϣ���Ե�ֵ��
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
