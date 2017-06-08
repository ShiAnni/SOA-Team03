
package cn.edu.nju.jw.wsdl.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import cn.edu.nju.jw.schema.�γ̳ɼ��б�����;
import cn.edu.nju.jw.schema.�γ̳ɼ�����;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.jw.wsdl.schema package. 
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

    private final static QName _StudentNo_QNAME = new QName("http://jw.nju.edu.cn/wsdl/schema", "studentNo");
    private final static QName _InvalidDataFault_QNAME = new QName("http://jw.nju.edu.cn/wsdl/schema", "InvalidDataFault");
    private final static QName _Score_QNAME = new QName("http://jw.nju.edu.cn/wsdl/schema", "score");
    private final static QName _IsSuccess_QNAME = new QName("http://jw.nju.edu.cn/wsdl/schema", "isSuccess");
    private final static QName _ScoreList_QNAME = new QName("http://jw.nju.edu.cn/wsdl/schema", "scoreList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.jw.wsdl.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl/schema", name = "studentNo")
    public JAXBElement<String> createStudentNo(String value) {
        return new JAXBElement<String>(_StudentNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl/schema", name = "InvalidDataFault")
    public JAXBElement<String> createInvalidDataFault(String value) {
        return new JAXBElement<String>(_InvalidDataFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link �γ̳ɼ����� }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl/schema", name = "score")
    public JAXBElement<�γ̳ɼ�����> createScore(�γ̳ɼ����� value) {
        return new JAXBElement<�γ̳ɼ�����>(_Score_QNAME, �γ̳ɼ�����.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl/schema", name = "isSuccess")
    public JAXBElement<String> createIsSuccess(String value) {
        return new JAXBElement<String>(_IsSuccess_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link �γ̳ɼ��б����� }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl/schema", name = "scoreList")
    public JAXBElement<�γ̳ɼ��б�����> createScoreList(�γ̳ɼ��б����� value) {
        return new JAXBElement<�γ̳ɼ��б�����>(_ScoreList_QNAME, �γ̳ɼ��б�����.class, null, value);
    }

}
