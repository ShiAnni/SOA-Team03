package cn.edu.nju.jw.wsdl;

import java.io.File;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.成绩性质类型;
import cn.edu.nju.jw.schema.成绩类型;
import cn.edu.nju.jw.schema.课程成绩列表类型;
import cn.edu.nju.jw.schema.课程成绩类型;
@WebService(endpointInterface="cn.edu.nju.jw.wsdl.ScoreInterface")  
public class ScoreInterfaceImpl implements ScoreInterface {

	@Override
	public 课程成绩列表类型 searchScore(String studentNo) throws SearchScoreFault {
		Document document = getDocument();
		课程成绩列表类型 result = new 课程成绩列表类型();
		boolean exist = false;
//		List<课程成绩类型> list = result.get课程成绩();
        NodeList nodes = document.getDocumentElement().getElementsByTagName("课程成绩");
        
        for(int i=0; i<nodes.getLength(); i++){
            NodeList childNodes = nodes.item(i).getChildNodes();
           
            NamedNodeMap nodeAttr = nodes.item(i).getAttributes();
            
//            System.out.println("课程编号与成绩类型:"+nodeAttr.getNamedItem("成绩性质")+"　"+nodeAttr.getNamedItem("课程编号"));
            for(int j=0; j<childNodes.getLength(); j++){
                Node temp = childNodes.item(j);
                if(temp.getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                    continue;  
                }  
                // 比较学号
                String stuID="";
                int score=0;
                for(int k=0;k<temp.getChildNodes().getLength();k++){
                	 if(temp.getChildNodes().item(k).getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                         continue;  
                     } else{
                    	 //System.out.println(temp.getChildNodes().item(k).getNodeName());
                    	 if(temp.getChildNodes().item(k).getNodeName().equals("学号")){
                    		 stuID = temp.getChildNodes().item(k).getTextContent();
                    	 } else if(temp.getChildNodes().item(k).getNodeName().equals("得分")){
                    		 score = Integer.parseInt( temp.getChildNodes().item(k).getTextContent() );
                    	 }
                     }
                }
                if(stuID.equals(studentNo)){
                	exist=true;
                	课程成绩类型 single = new 课程成绩类型();
                	成绩类型 singlescore = new 成绩类型();
                	singlescore.set学号(stuID);
                	singlescore.set得分(score);
                    single.set成绩性质(成绩性质类型.fromValue(nodeAttr.getNamedItem("成绩性质").getTextContent()));
                    single.set课程编号(nodeAttr.getNamedItem("课程编号").getTextContent());
                    single.get成绩().add(singlescore);
                    result.get课程成绩().add(single);
                }
            }
        }
        if(!exist)
        	throw new SearchScoreFault("查找的学号不存在","查找的学号不存在");
        return result;
	}

	@Override
	public String addScore(课程成绩类型 addScore) throws AddScoreFault {
		Document document = getDocument();
        // 检验课程和成绩性质是否已经存在
        
       NodeList nodes = document.getDocumentElement().getElementsByTagName("课程成绩");
       Element scoreType = null;
       for (int i = 0; i < nodes.getLength(); i++) {
           NamedNodeMap scoreAttr = nodes.item(i).getAttributes();
           if (scoreAttr.getNamedItem("课程编号").getTextContent().equals(addScore.get课程编号()) && scoreAttr.getNamedItem("成绩性质").getTextContent().equals(addScore.get成绩性质().toString()) ) {
               System.out.println("课程与成绩类型存在");
               scoreType = (Element) nodes.item(i);
               break;
           }
       }
       
       // 课程与成绩类型不存在，添加课程和成绩类型，暂时还没实现，不知道为什么是bug
       if(scoreType==null){
           System.out.println("课程与成绩类型不存在");
           scoreType = document.createElement("课程成绩");
           scoreType.setAttribute("成绩性质", addScore.get成绩性质().toString());
           scoreType.setAttribute("课程编号", addScore.get课程编号().toString());
       }
       Element score = document.createElement("成绩");
       Element studentID = document.createElement("学号");
       studentID.setTextContent(addScore.get成绩().get(0).get学号());
//       System.out.println(studentID.getTextContent());
       Element number = document.createElement("得分");
       number.setTextContent( String.valueOf(addScore.get成绩().get(0).get得分()) );
       score.appendChild(studentID);
       score.appendChild(number);
       //再把成绩添加进课程组
       scoreType.appendChild(score);
           
       return writeXML(document);    
	}

	@Override
	public String deleteScore(课程成绩类型 delScore) throws DeleteScoreFault {
		Document document = getDocument();
	       
        /*
         * 检验课程和成绩性质是否已经存在
         */
        NodeList nodes = document.getDocumentElement().getElementsByTagName("课程成绩");
        boolean exist=false;
        
        for (int i = 0; i < nodes.getLength(); i++) {
        	if(nodes.item(i).getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                continue;  
            }
            NamedNodeMap scoreAttr = nodes.item(i).getAttributes();
            String lessonid = scoreAttr.getNamedItem("课程编号").getTextContent();
            String type = scoreAttr.getNamedItem("成绩性质").getTextContent();
            if (lessonid.equals(delScore.get课程编号()) && type.equals(delScore.get成绩性质().toString())){
            	NodeList childNodes = nodes.item(i).getChildNodes();
            	for(int j=0;j<childNodes.getLength();j++){
            		 Node temp = childNodes.item(j);
                     if(temp.getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                         continue;  
                     }  
                     // 比较学号
                     for(int k=0;k<temp.getChildNodes().getLength();k++){
                    	 if(temp.getChildNodes().item(k).getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                             continue;  
                         } else{
                        	 //System.out.println(temp.getChildNodes().item(k).getNodeName());
                        	 if(temp.getChildNodes().item(k).getNodeName().equals("学号")){
//                        		System.out.println(temp.getChildNodes().item(k).getTextContent());
                        		 if(temp.getChildNodes().item(k).getTextContent().equals(delScore.get成绩().get(0).get学号())){
                        			 nodes.item(i).removeChild(temp);
                        			 exist=true;
                        		       break;
                        		 }
                        	 } 
                         }
                     }
            	}
            	break;
            }
        }
        if(!exist)
        	throw new DeleteScoreFault("删除的成绩不存在","删除的成绩不存在");
        return writeXML(document);
	}

	@Override
	public String modifyScore(课程成绩类型 modSocre) throws ModifyScoreFault {
		Document document = getDocument();
	       
        /*
         * 检验课程和成绩性质是否已经存在
         */
        NodeList nodes = document.getDocumentElement().getElementsByTagName("课程成绩");
        boolean exist=false;
        for (int i = 0; i < nodes.getLength(); i++) {
        	if(nodes.item(i).getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                continue;  
            }
            NamedNodeMap scoreAttr = nodes.item(i).getAttributes();
            
            String lessonid = scoreAttr.getNamedItem("课程编号").getTextContent();
            String type = scoreAttr.getNamedItem("成绩性质").getTextContent();
            if (lessonid.equals(modSocre.get课程编号()) && type.equals(modSocre.get成绩性质().toString())){
            	NodeList childNodes = nodes.item(i).getChildNodes();
            	for(int j=0;j<childNodes.getLength();j++){
            		 Node temp = childNodes.item(j);
                     if(temp.getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                         continue;  
                     }  
                     // 比较学号
                     boolean found = false;
                     for(int k=0;k<temp.getChildNodes().getLength();k++){
                    	 if(temp.getChildNodes().item(k).getNodeType() != Node.ELEMENT_NODE) {  //忽略空格  
                             continue;  
                         } else{
//                        	 System.out.println(temp.getChildNodes().item(k).getNodeName());
                        	 if(temp.getChildNodes().item(k).getNodeName().equals("学号")){
                        		 
                        		 if(temp.getChildNodes().item(k).getTextContent().equals(modSocre.get成绩().get(0).get学号())){
                        			 found=true;
                        		 }
                        	 } 
                        	 else if(temp.getChildNodes().item(k).getNodeName().equals("得分")){
                         		 if(found){
                         			temp.getChildNodes().item(k).setTextContent(modSocre.get成绩().get(0).get得分()+"");
                         			exist=true;
                         			found=false;
                         		       break;
                         		 }
                         	 } 
                         }
                    }
            	}
            	break;
            }
        }
        if(!exist)
        	throw new ModifyScoreFault("修改的成绩不存在","修改的成绩不存在");
        return writeXML(document);
	}
	
	/*
     * 将修改后的document对象写入XML中
     */
    private String writeXML(Document document){
        URL url = getClass().getResource("");
        String filePath = url.getPath().replace("build/classes/cn/edu/nju/jw/wsdl/", "");
        try{
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath + "文档3.xml"));
            transformer.transform(source, result);
            return "操作成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败： " + e.getMessage();
        }
    }
    	
    /**
     * 读ScoreList.xml文件
     */
    private Document getDocument(){
        URL url = getClass().getResource("");
        String filePath = url.getPath().replace("build/classes/cn/edu/nju/jw/wsdl/", "");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        
        Document document=null;
        try{    
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            document = builder.parse(filePath + "文档3.xml");
            //score = document.getDocumentElement();
        } catch(Exception e){
            e.printStackTrace();
        }
        return document;
    }

}
