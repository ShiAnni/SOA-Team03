package assignment4.sax;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;


public class MySAXHandler extends DefaultHandler{
    private Map<String,String> scoreRecord = null;
    private List<Map<String,String>> multiScoreList = null;
    private List<List<Map<String,String>>> resultList = null;
    String currentTag = null;
    String currentVal = null;
    String nodeName = null;
    boolean lowerThanBound = false;
    int bound = 60;//存在分数低于Bound的课程成绩会被保留
    public MySAXHandler(String nodeName){
        this.nodeName = nodeName;
    }
    public List<List<Map<String,String>>> getList(){
        return resultList;
    }

    @Override
    public void startDocument() throws SAXException {
       //do nothing
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        //System.out.println("startElement--"+qName);
        if(qName.equals(nodeName)){
            resultList = new LinkedList<List<Map<String,String>>>();
            return;
        }
        if(qName.equals("课程成绩")){
            multiScoreList = new LinkedList<Map<String,String>>();
            Map<String,String> attrMap = new HashMap<String, String>();//用来存放课程成绩的属性
            if(attributes!=null && attrMap !=null){
                for(int i=0; i<attributes.getLength(); i++){
                    attrMap.put(attributes.getQName(i),attributes.getValue(i));
                }
            }
            multiScoreList.add(attrMap);
        }
        if(qName.equals("成绩")){
            scoreRecord = new HashMap<String, String>();
        }
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //System.out.println("characters");
        if(currentTag != null && scoreRecord !=null){
            currentVal = new String(ch,start,length);
            if(currentVal!=null && !currentVal.trim().equals("") && !currentVal.trim().equals("\n")){
                scoreRecord.put(currentTag,currentVal);
                if(currentTag.equals("得分")){
                    int temp = Integer.parseInt(currentVal);
                    if(!lowerThanBound && temp < bound) {

                        lowerThanBound = true;
                        System.out.println(scoreRecord.get("学号")+" 低于 "+bound+" 分, 实际得分 "+currentVal);
                    }
                }
            }
            currentTag = null;
            currentVal = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("--endElement()"+qName);
        if(qName.equals("得分")){
            multiScoreList.add(scoreRecord);
        }else if(qName.equals("课程成绩")){
            if(lowerThanBound)
                resultList.add(multiScoreList);
            lowerThanBound = false;
        }else if(qName.equals(nodeName)){
            //do nothing
        }
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("--endDocument()");
        System.out.println("共有 "+resultList.size()+" 个课程成绩中包含低于 "+bound+" 分的成绩记录");
        for(int i=0; i<resultList.size(); i++)
            System.out.println(resultList.get(i).toString());
        super.endDocument();
    }
}
