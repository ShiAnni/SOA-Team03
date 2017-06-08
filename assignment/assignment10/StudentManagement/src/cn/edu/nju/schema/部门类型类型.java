
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for 部门类型类型.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="部门类型类型">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="院系"/>
 *     &lt;enumeration value="管理部门"/>
 *     &lt;enumeration value="后勤部门"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u90e8\u95e8\u7c7b\u578b\u7c7b\u578b")
@XmlEnum
public enum 部门类型类型 {

    院系,
    管理部门,
    后勤部门;

    public String value() {
        return name();
    }

    public static 部门类型类型 fromValue(String v) {
        return valueOf(v);
    }

}
