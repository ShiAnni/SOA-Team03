
package cn.edu.nju.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>部门规模类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="部门规模类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="3">
 *         &lt;element name="人数" type="{http://www.nju.edu.cn/schema}部门人数类型"/>
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
public class 部门规模类型 {

    @XmlElement(required = true)
    protected List<部门人数类型> 人数;

    /**
     * Gets the value of the 人数 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 人数 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get人数().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link 部门人数类型 }
     * 
     * 
     */
    public List<部门人数类型> get人数() {
        if (人数 == null) {
            人数 = new ArrayList<部门人数类型>();
        }
        return this.人数;
    }

	@Override
	public String toString() {
		return "部门规模类型 [人数=" + 人数 + "]";
	}
    
    

}
