
package cn.edu.nju.jw.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>课程成绩类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="课程成绩类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="成绩" type="{http://jw.nju.edu.cn/schema}成绩类型"/>
 *       &lt;/sequence>
 *       &lt;attribute name="课程编号" type="{http://jw.nju.edu.cn/schema}课程编号类型" />
 *       &lt;attribute name="成绩性质" type="{http://jw.nju.edu.cn/schema}成绩性质类型" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u8bfe\u7a0b\u6210\u7ee9\u7c7b\u578b", propOrder = {
    "\u6210\u7ee9"
})
public class 课程成绩类型 {

    protected List<成绩类型> 成绩;
    @XmlAttribute
    protected String 课程编号;
    @XmlAttribute
    protected 成绩性质类型 成绩性质;

    /**
     * Gets the value of the 成绩 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 成绩 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get成绩().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link 成绩类型 }
     * 
     * 
     */
    public List<成绩类型> get成绩() {
        if (成绩 == null) {
            成绩 = new ArrayList<成绩类型>();
        }
        return this.成绩;
    }

    /**
     * 获取课程编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get课程编号() {
        return 课程编号;
    }

    /**
     * 设置课程编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set课程编号(String value) {
        this.课程编号 = value;
    }

    /**
     * 获取成绩性质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 成绩性质类型 }
     *     
     */
    public 成绩性质类型 get成绩性质() {
        return 成绩性质;
    }

    /**
     * 设置成绩性质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 成绩性质类型 }
     *     
     */
    public void set成绩性质(成绩性质类型 value) {
        this.成绩性质 = value;
    }

	@Override
	public String toString() {
		return "课程成绩类型 [成绩=" + 成绩 + ", 课程编号=" + 课程编号 + ", 成绩性质=" + 成绩性质 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((成绩 == null) ? 0 : 成绩.hashCode());
		result = prime * result + ((成绩性质 == null) ? 0 : 成绩性质.hashCode());
		result = prime * result + ((课程编号 == null) ? 0 : 课程编号.hashCode());
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
		课程成绩类型 other = (课程成绩类型) obj;
		if (成绩 == null) {
			if (other.成绩 != null)
				return false;
		} else if (!成绩.equals(other.成绩))
			return false;
		if (成绩性质 != other.成绩性质)
			return false;
		if (课程编号 == null) {
			if (other.课程编号 != null)
				return false;
		} else if (!课程编号.equals(other.课程编号))
			return false;
		return true;
	}
    
    

}
