
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.jw.wsdl package. 
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

    private final static QName _DoubleIDError_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "doubleIDError");
    private final static QName _NoIDError_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "noIDError");
    private final static QName _StudentList_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "studentList");
    private final static QName _IsSuccess_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "isSuccess");
    private final static QName _IsCorrect_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "isCorrect");
    private final static QName _StudentInfo_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "studentInfo");
    private final static QName _None_QNAME = new QName("http://jw.nju.edu.cn/wsdl", "none");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.jw.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NoneType }
     * 
     */
    public NoneType createNoneType() {
        return new NoneType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "doubleIDError")
    public JAXBElement<String> createDoubleIDError(String value) {
        return new JAXBElement<String>(_DoubleIDError_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "noIDError")
    public JAXBElement<String> createNoIDError(String value) {
        return new JAXBElement<String>(_NoIDError_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学生列表信息 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "studentList")
    public JAXBElement<学生列表信息> createStudentList(学生列表信息 value) {
        return new JAXBElement<学生列表信息>(_StudentList_QNAME, 学生列表信息.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "isSuccess")
    public JAXBElement<String> createIsSuccess(String value) {
        return new JAXBElement<String>(_IsSuccess_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 验证信息 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "isCorrect")
    public JAXBElement<验证信息> createIsCorrect(验证信息 value) {
        return new JAXBElement<验证信息>(_IsCorrect_QNAME, 验证信息.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学生类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "studentInfo")
    public JAXBElement<学生类型> createStudentInfo(学生类型 value) {
        return new JAXBElement<学生类型>(_StudentInfo_QNAME, 学生类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoneType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/wsdl", name = "none")
    public JAXBElement<NoneType> createNone(NoneType value) {
        return new JAXBElement<NoneType>(_None_QNAME, NoneType.class, null, value);
    }

}
