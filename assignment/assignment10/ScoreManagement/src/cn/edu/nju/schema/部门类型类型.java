
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ������������.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="������������">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ժϵ"/>
 *     &lt;enumeration value="������"/>
 *     &lt;enumeration value="���ڲ���"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u90e8\u95e8\u7c7b\u578b\u7c7b\u578b")
@XmlEnum
public enum ������������ {

    Ժϵ,
    ������,
    ���ڲ���;

    public String value() {
        return name();
    }

    public static ������������ fromValue(String v) {
        return valueOf(v);
    }

}
