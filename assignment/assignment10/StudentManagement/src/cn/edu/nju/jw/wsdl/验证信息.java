
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ��֤��Ϣ.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="��֤��Ϣ">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="��ȷ"/>
 *     &lt;enumeration value="����"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u9a8c\u8bc1\u4fe1\u606f")
@XmlEnum
public enum ��֤��Ϣ {

    ��ȷ,
    ����;

    public String value() {
        return name();
    }

    public static ��֤��Ϣ fromValue(String v) {
        return valueOf(v);
    }

}
