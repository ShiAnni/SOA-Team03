
package cn.edu.nju.jw.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>学生列表信息 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="学生列表信息">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="学生" type="{http://jw.nju.edu.cn/schema}学生类型"/>
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
public class 学生列表信息 {

    protected List<学生类型> 学生;

    /**
     * Gets the value of the 学生 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 学生 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get学生().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link 学生类型 }
     * 
     * 
     */
    public List<学生类型> get学生() {
        if (学生 == null) {
            学生 = new ArrayList<学生类型>();
        }
        return this.学生;
    }

}
