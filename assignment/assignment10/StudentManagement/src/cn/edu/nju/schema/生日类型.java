
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>�������� complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡ�����Ե�ֵ��
     * 
     */
    public int get��() {
        return ��;
    }

    /**
     * ���������Ե�ֵ��
     * 
     */
    public void set��(int value) {
        this.�� = value;
    }

    /**
     * ��ȡ�����Ե�ֵ��
     * 
     */
    public int get��() {
        return ��;
    }

    /**
     * ���������Ե�ֵ��
     * 
     */
    public void set��(int value) {
        this.�� = value;
    }

    /**
     * ��ȡ�����Ե�ֵ��
     * 
     */
    public int get��() {
        return ��;
    }

    /**
     * ���������Ե�ֵ��
     * 
     */
    public void set��(int value) {
        this.�� = value;
    }

	@Override
	public String toString() {
		return "�������� [��=" + �� + ", ��=" + �� + ", ��=" + �� + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ��;
		result = prime * result + ��;
		result = prime * result + ��;
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
		�������� other = (��������) obj;
		if (�� != other.��)
			return false;
		if (�� != other.��)
			return false;
		if (�� != other.��)
			return false;
		return true;
	}
    
    

}
