
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>������Ա���͵� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="������Ա����">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="��ʦ"/>
 *     &lt;enumeration value="������Ա"/>
 *     &lt;enumeration value="ѧ��"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u90e8\u95e8\u4eba\u5458\u7c7b\u578b")
@XmlEnum
public enum ������Ա���� {

    ��ʦ,
    ������Ա,
    ѧ��;

    public String value() {
        return name();
    }

    public static ������Ա���� fromValue(String v) {
        return valueOf(v);
    }

}
