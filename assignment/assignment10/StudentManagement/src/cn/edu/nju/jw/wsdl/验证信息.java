
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>验证信息的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="验证信息">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="正确"/>
 *     &lt;enumeration value="错误"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u9a8c\u8bc1\u4fe1\u606f")
@XmlEnum
public enum 验证信息 {

    正确,
    错误;

    public String value() {
        return name();
    }

    public static 验证信息 fromValue(String v) {
        return valueOf(v);
    }

}
