
package cn.edu.nju.jw.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cn.edu.nju.schema.���˻�����Ϣ����;


/**
 * <p>ѧ������ complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ѧ������">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{http://www.nju.edu.cn/schema}ѧ��������Ϣ"/>
 *         &lt;element ref="{http://jw.nju.edu.cn/schema}�γ̳ɼ��б�"/>
 *       &lt;/all>
 *       &lt;attribute name="ѧ��" type="{http://jw.nju.edu.cn/schema}ѧ������" />
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
public class ѧ������ {

    @XmlElement(namespace = "http://www.nju.edu.cn/schema", required = true)
    protected ���˻�����Ϣ���� ѧ��������Ϣ;
    @XmlElement(required = true)
    protected �γ̳ɼ��б����� �γ̳ɼ��б�;
    @XmlAttribute
    protected String ѧ��;

    /**
     * ��ȡѧ��������Ϣ���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ���˻�����Ϣ���� }
     *     
     */
    public ���˻�����Ϣ���� getѧ��������Ϣ() {
        return ѧ��������Ϣ;
    }

    /**
     * ����ѧ��������Ϣ���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ���˻�����Ϣ���� }
     *     
     */
    public void setѧ��������Ϣ(���˻�����Ϣ���� value) {
        this.ѧ��������Ϣ = value;
    }

    /**
     * ��ȡ�γ̳ɼ��б����Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link �γ̳ɼ��б����� }
     *     
     */
    public �γ̳ɼ��б����� get�γ̳ɼ��б�() {
        return �γ̳ɼ��б�;
    }

    /**
     * ���ÿγ̳ɼ��б����Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link �γ̳ɼ��б����� }
     *     
     */
    public void set�γ̳ɼ��б�(�γ̳ɼ��б����� value) {
        this.�γ̳ɼ��б� = value;
    }

    /**
     * ��ȡѧ�����Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getѧ��() {
        return ѧ��;
    }

    /**
     * ����ѧ�����Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setѧ��(String value) {
        this.ѧ�� = value;
    }

}
