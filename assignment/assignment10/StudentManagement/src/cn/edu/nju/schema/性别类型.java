
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for �Ա�����.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="�Ա�����">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="��"/>
 *     &lt;enumeration value="Ů"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u6027\u522b\u7c7b\u578b")
@XmlEnum
public enum �Ա����� {

    ��,
    Ů;

    public String value() {
        return name();
    }

    public static �Ա����� fromValue(String v) {
        return valueOf(v);
    }

}
