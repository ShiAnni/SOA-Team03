package mail;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "userType")
@XmlEnum
public enum UserType {
	��ʦ,
    �о���,
    ������,
    δ֪����;
	
	public String value() {
        return name();
    }

    public static UserType fromValue(String v) {
        return valueOf(v);
    }
}
