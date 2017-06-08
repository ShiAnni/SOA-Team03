package mail;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "userType")
@XmlEnum
public enum UserType {
	教师,
    研究生,
    本科生,
    未知类型;
	
	public String value() {
        return name();
    }

    public static UserType fromValue(String v) {
        return valueOf(v);
    }
}
