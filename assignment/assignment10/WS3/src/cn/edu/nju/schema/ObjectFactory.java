
package cn.edu.nju.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _������Ϣ_QNAME = new QName("http://www.nju.edu.cn/schema", "\u90e8\u95e8\u4fe1\u606f");
    private final static QName _ѧ��������Ϣ_QNAME = new QName("http://www.nju.edu.cn/schema", "\u5b66\u751f\u57fa\u672c\u4fe1\u606f");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ���˻�����Ϣ���� }
     * 
     */
    public ���˻�����Ϣ���� create���˻�����Ϣ����() {
        return new ���˻�����Ϣ����();
    }

    /**
     * Create an instance of {@link ������Ϣ���� }
     * 
     */
    public ������Ϣ���� create������Ϣ����() {
        return new ������Ϣ����();
    }

    /**
     * Create an instance of {@link �������� }
     * 
     */
    public �������� create��������() {
        return new ��������();
    }

    /**
     * Create an instance of {@link ���Ź�ģ���� }
     * 
     */
    public ���Ź�ģ���� create���Ź�ģ����() {
        return new ���Ź�ģ����();
    }

    /**
     * Create an instance of {@link ������������ }
     * 
     */
    public ������������ create������������() {
        return new ������������();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ������Ϣ���� }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u90e8\u95e8\u4fe1\u606f")
    public JAXBElement<������Ϣ����> create������Ϣ(������Ϣ���� value) {
        return new JAXBElement<������Ϣ����>(_������Ϣ_QNAME, ������Ϣ����.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ���˻�����Ϣ���� }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u5b66\u751f\u57fa\u672c\u4fe1\u606f")
    public JAXBElement<���˻�����Ϣ����> createѧ��������Ϣ(���˻�����Ϣ���� value) {
        return new JAXBElement<���˻�����Ϣ����>(_ѧ��������Ϣ_QNAME, ���˻�����Ϣ����.class, null, value);
    }

}