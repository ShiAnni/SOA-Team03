
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>������Ϣ���� complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡ�����������Ե�ֵ��
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
     * ���ò����������Ե�ֵ��
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
     * ��ȡ���Ź�ģ���Ե�ֵ��
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
     * ���ò��Ź�ģ���Ե�ֵ��
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
     * ��ȡ���ű�����Ե�ֵ��
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
     * ���ò��ű�����Ե�ֵ��
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
     * ��ȡ�����������Ե�ֵ��
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
     * ���ò����������Ե�ֵ��
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
