
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ѧ�� == null) ? 0 : ѧ��.hashCode());
		result = prime * result + ((ѧ��������Ϣ == null) ? 0 : ѧ��������Ϣ.hashCode());
		result = prime * result + ((�γ̳ɼ��б� == null) ? 0 : �γ̳ɼ��б�.hashCode());
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
		ѧ������ other = (ѧ������) obj;
		if (ѧ�� == null) {
			if (other.ѧ�� != null)
				return false;
		} else if (!ѧ��.equals(other.ѧ��))
			return false;
		if (ѧ��������Ϣ == null) {
			if (other.ѧ��������Ϣ != null)
				return false;
		} else if (!ѧ��������Ϣ.equals(other.ѧ��������Ϣ))
			return false;
		if (�γ̳ɼ��б� == null) {
			if (other.�γ̳ɼ��б� != null)
				return false;
		} else if (!�γ̳ɼ��б�.equals(other.�γ̳ɼ��б�))
			return false;
		return true;
	}

	

}
