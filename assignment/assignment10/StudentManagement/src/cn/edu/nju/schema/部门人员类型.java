
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>部门人员类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="部门人员类型">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="教师"/>
 *     &lt;enumeration value="管理人员"/>
 *     &lt;enumeration value="学生"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u90e8\u95e8\u4eba\u5458\u7c7b\u578b")
@XmlEnum
public enum 部门人员类型 {

    教师,
    管理人员,
    学生;

    public String value() {
        return name();
    }

    public static 部门人员类型 fromValue(String v) {
        return valueOf(v);
    }

}
