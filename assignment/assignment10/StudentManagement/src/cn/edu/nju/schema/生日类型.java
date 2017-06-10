
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>生日类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="生日类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="年" type="{http://www.nju.edu.cn/schema}年类型"/>
 *         &lt;element name="月" type="{http://www.nju.edu.cn/schema}月类型"/>
 *         &lt;element name="日" type="{http://www.nju.edu.cn/schema}日类型"/>
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
public class 生日类型 {

    protected int 年;
    protected int 月;
    protected int 日;

    /**
     * 获取年属性的值。
     * 
     */
    public int get年() {
        return 年;
    }

    /**
     * 设置年属性的值。
     * 
     */
    public void set年(int value) {
        this.年 = value;
    }

    /**
     * 获取月属性的值。
     * 
     */
    public int get月() {
        return 月;
    }

    /**
     * 设置月属性的值。
     * 
     */
    public void set月(int value) {
        this.月 = value;
    }

    /**
     * 获取日属性的值。
     * 
     */
    public int get日() {
        return 日;
    }

    /**
     * 设置日属性的值。
     * 
     */
    public void set日(int value) {
        this.日 = value;
    }

	@Override
	public String toString() {
		return "生日类型 [年=" + 年 + ", 月=" + 月 + ", 日=" + 日 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + 年;
		result = prime * result + 日;
		result = prime * result + 月;
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
		生日类型 other = (生日类型) obj;
		if (年 != other.年)
			return false;
		if (日 != other.日)
			return false;
		if (月 != other.月)
			return false;
		return true;
	}
    
    

}
