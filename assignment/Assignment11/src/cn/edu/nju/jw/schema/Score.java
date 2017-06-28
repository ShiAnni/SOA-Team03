
package cn.edu.nju.jw.schema;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Score", targetNamespace = "http://jw.nju.edu.cn/schema")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Score {


    /**
     * 
     * @param parameters
     * @throws AuthorityException
     * @throws IdNotFoundException
     * @throws ScoreTypeException
     * @throws ScoreModifyException
     */
    @WebMethod(action = "score/deleteScore")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "score/deleteScoreRequest", output = "score/deleteScoreResponse", fault = {
        @FaultAction(className = ScoreTypeException.class, value = "score/deleteScore/Fault/ScoreTypeException"),
        @FaultAction(className = ScoreModifyException.class, value = "score/deleteScore/Fault/ScoreModifyException"),
        @FaultAction(className = AuthorityException.class, value = "score/deleteScore/Fault/AuthorityException"),
        @FaultAction(className = IdNotFoundException.class, value = "score/deleteScore/Fault/IdNotFoundException")
    })
    public void deleteScore(
        @WebParam(name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868", targetNamespace = "http://jw.nju.edu.cn/schema", mode = WebParam.Mode.INOUT, partName = "parameters")
        Holder<课程成绩列表类型> parameters)
        throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException
    ;

    /**
     * 
     * @param 课程成绩列表
     * @throws AuthorityException
     * @throws IdNotFoundException
     * @throws ScoreTypeException
     * @throws ScoreModifyException
     */
    @WebMethod(action = "score/addScore")
    @RequestWrapper(localName = "addScore", targetNamespace = "http://jw.nju.edu.cn/schema", className = "cn.edu.nju.jw.schema.AddScore")
    @ResponseWrapper(localName = "modifyScore", targetNamespace = "http://jw.nju.edu.cn/schema", className = "cn.edu.nju.jw.schema.ModifyScore")
    @Action(input = "score/addScoreRequest", output = "score/addScoreResponse", fault = {
        @FaultAction(className = ScoreTypeException.class, value = "score/addScore/Fault/ScoreTypeException"),
        @FaultAction(className = ScoreModifyException.class, value = "score/addScore/Fault/ScoreModifyException"),
        @FaultAction(className = AuthorityException.class, value = "score/addScore/Fault/AuthorityException"),
        @FaultAction(className = IdNotFoundException.class, value = "score/addScore/Fault/IdNotFoundException")
    })
    public void addScore(
        @WebParam(name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868", targetNamespace = "http://jw.nju.edu.cn/schema", mode = WebParam.Mode.INOUT)
        Holder<课程成绩列表类型> 课程成绩列表)
        throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns cn.edu.nju.jw.schema.课程成绩列表类型
     * @throws IdNotFoundException
     */
    @WebMethod(action = "score/getScore")
    @WebResult(name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "score/getScoreRequest", output = "score/getScoreResponse", fault = {
        @FaultAction(className = IdNotFoundException.class, value = "score/getScore/Fault/IdNotFoundException")
    })
    public 课程成绩列表类型 getScore(
        @WebParam(name = "\u5b66\u53f7", targetNamespace = "http://jw.nju.edu.cn/schema", partName = "parameters")
        String parameters)
        throws IdNotFoundException
    ;

    /**
     * 
     * @param parameters
     * @throws AuthorityException
     * @throws IdNotFoundException
     * @throws ScoreTypeException
     * @throws ScoreModifyException
     */
    @WebMethod(action = "score/modifyScore")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "score/modifyScoreRequest", output = "score/modifyScoreResponse", fault = {
        @FaultAction(className = ScoreTypeException.class, value = "score/modifyScore/Fault/ScoreTypeException"),
        @FaultAction(className = ScoreModifyException.class, value = "score/modifyScore/Fault/ScoreModifyException"),
        @FaultAction(className = AuthorityException.class, value = "score/modifyScore/Fault/AuthorityException"),
        @FaultAction(className = IdNotFoundException.class, value = "score/modifyScore/Fault/IdNotFoundException")
    })
    public void modifyScore(
        @WebParam(name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868", targetNamespace = "http://jw.nju.edu.cn/schema", mode = WebParam.Mode.INOUT, partName = "parameters")
        Holder<课程成绩列表类型> parameters)
        throws AuthorityException, IdNotFoundException, ScoreModifyException, ScoreTypeException
    ;

}
