
package cn.edu.nju.jw.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ѧ���б���Ϣ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ѧ���б���Ϣ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ѧ��" type="{http://jw.nju.edu.cn/schema}ѧ������"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u5b66\u751f\u5217\u8868\u4fe1\u606f", propOrder = {
    "\u5b66\u751f"
})
public class ѧ���б���Ϣ {

    protected List<ѧ������> ѧ��;

    /**
     * Gets the value of the ѧ�� property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ѧ�� property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getѧ��().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ѧ������ }
     * 
     * 
     */
    public List<ѧ������> getѧ��() {
        if (ѧ�� == null) {
            ѧ�� = new ArrayList<ѧ������>();
        }
        return this.ѧ��;
    }

}
