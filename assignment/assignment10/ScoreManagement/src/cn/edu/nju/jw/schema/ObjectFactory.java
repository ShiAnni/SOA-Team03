
package cn.edu.nju.jw.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.jw.schema package. 
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

    private final static QName _ѧ��_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7");
    private final static QName _ѧ��_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u751f");
    private final static QName _�γ̱��_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u7f16\u53f7");
    private final static QName _�γ̳ɼ��б�_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.jw.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link �γ̳ɼ��б����� }
     * 
     */
    public �γ̳ɼ��б����� create�γ̳ɼ��б�����() {
        return new �γ̳ɼ��б�����();
    }

    /**
     * Create an instance of {@link �γ̳ɼ����� }
     * 
     */
    public �γ̳ɼ����� create�γ̳ɼ�����() {
        return new �γ̳ɼ�����();
    }

    /**
     * Create an instance of {@link ѧ������ }
     * 
     */
    public ѧ������ createѧ������() {
        return new ѧ������();
    }

    /**
     * Create an instance of {@link �ɼ����� }
     * 
     */
    public �ɼ����� create�ɼ�����() {
        return new �ɼ�����();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7")
    public JAXBElement<String> createѧ��(String value) {
        return new JAXBElement<String>(_ѧ��_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ѧ������ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u751f")
    public JAXBElement<ѧ������> createѧ��(ѧ������ value) {
        return new JAXBElement<ѧ������>(_ѧ��_QNAME, ѧ������.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u7f16\u53f7")
    public JAXBElement<String> create�γ̱��(String value) {
        return new JAXBElement<String>(_�γ̱��_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link �γ̳ɼ��б����� }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868")
    public JAXBElement<�γ̳ɼ��б�����> create�γ̳ɼ��б�(�γ̳ɼ��б����� value) {
        return new JAXBElement<�γ̳ɼ��б�����>(_�γ̳ɼ��б�_QNAME, �γ̳ɼ��б�����.class, null, value);
    }

}
