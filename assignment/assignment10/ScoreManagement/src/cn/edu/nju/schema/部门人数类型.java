
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>������������ complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="������������">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *       &lt;attribute name="����" type="{http://www.nju.edu.cn/schema}������Ա����" />
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
public class ������������ {

    @XmlValue
    protected int value;
    @XmlAttribute
    protected ������Ա���� ����;

    /**
     * ��ȡvalue���Ե�ֵ��
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * ����value���Ե�ֵ��
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * ��ȡ�������Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ������Ա���� }
     *     
     */
    public ������Ա���� get����() {
        return ����;
    }

    /**
     * �����������Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ������Ա���� }
     *     
     */
    public void set����(������Ա���� value) {
        this.���� = value;
    }

}
