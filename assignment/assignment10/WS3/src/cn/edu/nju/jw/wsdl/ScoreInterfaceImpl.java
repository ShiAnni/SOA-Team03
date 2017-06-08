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

import cn.edu.nju.jw.schema.�ɼ���������;
import cn.edu.nju.jw.schema.�ɼ�����;
import cn.edu.nju.jw.schema.�γ̳ɼ��б�����;
import cn.edu.nju.jw.schema.�γ̳ɼ�����;
@WebService(endpointInterface="cn.edu.nju.jw.wsdl.ScoreInterface")  
public class ScoreInterfaceImpl implements ScoreInterface {

	@Override
	public �γ̳ɼ��б����� searchScore(String studentNo) throws SearchScoreFault {
		Document document = getDocument();
		�γ̳ɼ��б����� result = new �γ̳ɼ��б�����();
		boolean exist = false;
//		List<�γ̳ɼ�����> list = result.get�γ̳ɼ�();
        NodeList nodes = document.getDocumentElement().getElementsByTagName("�γ̳ɼ�");
        
        for(int i=0; i<nodes.getLength(); i++){
            NodeList childNodes = nodes.item(i).getChildNodes();
           
            NamedNodeMap nodeAttr = nodes.item(i).getAttributes();
            
//            System.out.println("�γ̱����ɼ�����:"+nodeAttr.getNamedItem("�ɼ�����")+"��"+nodeAttr.getNamedItem("�γ̱��"));
            for(int j=0; j<childNodes.getLength(); j++){
                Node temp = childNodes.item(j);
                if(temp.getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                    continue;  
                }  
                // �Ƚ�ѧ��
                String stuID="";
                int score=0;
                for(int k=0;k<temp.getChildNodes().getLength();k++){
                	 if(temp.getChildNodes().item(k).getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                         continue;  
                     } else{
                    	 //System.out.println(temp.getChildNodes().item(k).getNodeName());
                    	 if(temp.getChildNodes().item(k).getNodeName().equals("ѧ��")){
                    		 stuID = temp.getChildNodes().item(k).getTextContent();
                    	 } else if(temp.getChildNodes().item(k).getNodeName().equals("�÷�")){
                    		 score = Integer.parseInt( temp.getChildNodes().item(k).getTextContent() );
                    	 }
                     }
                }
                if(stuID.equals(studentNo)){
                	exist=true;
                	�γ̳ɼ����� single = new �γ̳ɼ�����();
                	�ɼ����� singlescore = new �ɼ�����();
                	singlescore.setѧ��(stuID);
                	singlescore.set�÷�(score);
                    single.set�ɼ�����(�ɼ���������.fromValue(nodeAttr.getNamedItem("�ɼ�����").getTextContent()));
                    single.set�γ̱��(nodeAttr.getNamedItem("�γ̱��").getTextContent());
                    single.get�ɼ�().add(singlescore);
                    result.get�γ̳ɼ�().add(single);
                }
            }
        }
        if(!exist)
        	throw new SearchScoreFault("���ҵ�ѧ�Ų�����","���ҵ�ѧ�Ų�����");
        return result;
	}

	@Override
	public String addScore(�γ̳ɼ����� addScore) throws AddScoreFault {
		Document document = getDocument();
        // ����γ̺ͳɼ������Ƿ��Ѿ�����
        
       NodeList nodes = document.getDocumentElement().getElementsByTagName("�γ̳ɼ�");
       Element scoreType = null;
       for (int i = 0; i < nodes.getLength(); i++) {
           NamedNodeMap scoreAttr = nodes.item(i).getAttributes();
           if (scoreAttr.getNamedItem("�γ̱��").getTextContent().equals(addScore.get�γ̱��()) && scoreAttr.getNamedItem("�ɼ�����").getTextContent().equals(addScore.get�ɼ�����().toString()) ) {
               System.out.println("�γ���ɼ����ʹ���");
               scoreType = (Element) nodes.item(i);
               break;
           }
       }
       
       // �γ���ɼ����Ͳ����ڣ���ӿγ̺ͳɼ����ͣ���ʱ��ûʵ�֣���֪��Ϊʲô��bug
       if(scoreType==null){
           System.out.println("�γ���ɼ����Ͳ�����");
           scoreType = document.createElement("�γ̳ɼ�");
           scoreType.setAttribute("�ɼ�����", addScore.get�ɼ�����().toString());
           scoreType.setAttribute("�γ̱��", addScore.get�γ̱��().toString());
       }
       Element score = document.createElement("�ɼ�");
       Element studentID = document.createElement("ѧ��");
       studentID.setTextContent(addScore.get�ɼ�().get(0).getѧ��());
//       System.out.println(studentID.getTextContent());
       Element number = document.createElement("�÷�");
       number.setTextContent( String.valueOf(addScore.get�ɼ�().get(0).get�÷�()) );
       score.appendChild(studentID);
       score.appendChild(number);
       //�ٰѳɼ���ӽ��γ���
       scoreType.appendChild(score);
           
       return writeXML(document);    
	}

	@Override
	public String deleteScore(�γ̳ɼ����� delScore) throws DeleteScoreFault {
		Document document = getDocument();
	       
        /*
         * ����γ̺ͳɼ������Ƿ��Ѿ�����
         */
        NodeList nodes = document.getDocumentElement().getElementsByTagName("�γ̳ɼ�");
        boolean exist=false;
        
        for (int i = 0; i < nodes.getLength(); i++) {
        	if(nodes.item(i).getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                continue;  
            }
            NamedNodeMap scoreAttr = nodes.item(i).getAttributes();
            String lessonid = scoreAttr.getNamedItem("�γ̱��").getTextContent();
            String type = scoreAttr.getNamedItem("�ɼ�����").getTextContent();
            if (lessonid.equals(delScore.get�γ̱��()) && type.equals(delScore.get�ɼ�����().toString())){
            	NodeList childNodes = nodes.item(i).getChildNodes();
            	for(int j=0;j<childNodes.getLength();j++){
            		 Node temp = childNodes.item(j);
                     if(temp.getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                         continue;  
                     }  
                     // �Ƚ�ѧ��
                     for(int k=0;k<temp.getChildNodes().getLength();k++){
                    	 if(temp.getChildNodes().item(k).getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                             continue;  
                         } else{
                        	 //System.out.println(temp.getChildNodes().item(k).getNodeName());
                        	 if(temp.getChildNodes().item(k).getNodeName().equals("ѧ��")){
//                        		System.out.println(temp.getChildNodes().item(k).getTextContent());
                        		 if(temp.getChildNodes().item(k).getTextContent().equals(delScore.get�ɼ�().get(0).getѧ��())){
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
        	throw new DeleteScoreFault("ɾ���ĳɼ�������","ɾ���ĳɼ�������");
        return writeXML(document);
	}

	@Override
	public String modifyScore(�γ̳ɼ����� modSocre) throws ModifyScoreFault {
		Document document = getDocument();
	       
        /*
         * ����γ̺ͳɼ������Ƿ��Ѿ�����
         */
        NodeList nodes = document.getDocumentElement().getElementsByTagName("�γ̳ɼ�");
        boolean exist=false;
        for (int i = 0; i < nodes.getLength(); i++) {
        	if(nodes.item(i).getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                continue;  
            }
            NamedNodeMap scoreAttr = nodes.item(i).getAttributes();
            
            String lessonid = scoreAttr.getNamedItem("�γ̱��").getTextContent();
            String type = scoreAttr.getNamedItem("�ɼ�����").getTextContent();
            if (lessonid.equals(modSocre.get�γ̱��()) && type.equals(modSocre.get�ɼ�����().toString())){
            	NodeList childNodes = nodes.item(i).getChildNodes();
            	for(int j=0;j<childNodes.getLength();j++){
            		 Node temp = childNodes.item(j);
                     if(temp.getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                         continue;  
                     }  
                     // �Ƚ�ѧ��
                     boolean found = false;
                     for(int k=0;k<temp.getChildNodes().getLength();k++){
                    	 if(temp.getChildNodes().item(k).getNodeType() != Node.ELEMENT_NODE) {  //���Կո�  
                             continue;  
                         } else{
//                        	 System.out.println(temp.getChildNodes().item(k).getNodeName());
                        	 if(temp.getChildNodes().item(k).getNodeName().equals("ѧ��")){
                        		 
                        		 if(temp.getChildNodes().item(k).getTextContent().equals(modSocre.get�ɼ�().get(0).getѧ��())){
                        			 found=true;
                        		 }
                        	 } 
                        	 else if(temp.getChildNodes().item(k).getNodeName().equals("�÷�")){
                         		 if(found){
                         			temp.getChildNodes().item(k).setTextContent(modSocre.get�ɼ�().get(0).get�÷�()+"");
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
        	throw new ModifyScoreFault("�޸ĵĳɼ�������","�޸ĵĳɼ�������");
        return writeXML(document);
	}
	
	/*
     * ���޸ĺ��document����д��XML��
     */
    private String writeXML(Document document){
        URL url = getClass().getResource("");
        String filePath = url.getPath().replace("build/classes/cn/edu/nju/jw/wsdl/", "");
        try{
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath + "�ĵ�3.xml"));
            transformer.transform(source, result);
            return "�����ɹ�";
        } catch (Exception e) {
            e.printStackTrace();
            return "����ʧ�ܣ� " + e.getMessage();
        }
    }
    	
    /**
     * ��ScoreList.xml�ļ�
     */
    private Document getDocument(){
        URL url = getClass().getResource("");
        String filePath = url.getPath().replace("build/classes/cn/edu/nju/jw/wsdl/", "");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        
        Document document=null;
        try{    
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            document = builder.parse(filePath + "�ĵ�3.xml");
            //score = document.getDocumentElement();
        } catch(Exception e){
            e.printStackTrace();
        }
        return document;
    }

}
