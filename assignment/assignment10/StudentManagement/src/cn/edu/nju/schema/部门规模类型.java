
package cn.edu.nju.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>���Ź�ģ���� complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="���Ź�ģ����">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="3">
 *         &lt;element name="����" type="{http://www.nju.edu.cn/schema}������������"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u90e8\u95e8\u89c4\u6a21\u7c7b\u578b", propOrder = {
    "\u4eba\u6570"
})
public class ���Ź�ģ���� {

    @XmlElement(required = true)
    protected List<������������> ����;

    /**
     * Gets the value of the ���� property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ���� property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get����().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ������������ }
     * 
     * 
     */
    public List<������������> get����() {
        if (���� == null) {
            ���� = new ArrayList<������������>();
        }
        return this.����;
    }

	@Override
	public String toString() {
		return "���Ź�ģ���� [����=" + ���� + "]";
	}
    
    

}
