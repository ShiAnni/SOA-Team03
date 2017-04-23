package assignment4.xsl;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.UnsupportedEncodingException;    
  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.stream.StreamSource;  
  
import org.dom4j.Document;  
import org.dom4j.DocumentException;  
import org.dom4j.io.DocumentResult;  
import org.dom4j.io.DocumentSource;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.SAXReader;  
import org.dom4j.io.XMLWriter;

import assignment3.validator.XMLValidator;  
  
  
public class Xslt {  
/** 
 * @author Administrator 
 * @parame document,styleSheet 
 */  
  public static Document transformDocument(Document document,File styleSheet)  
    throws TransformerException  
  {  
    TransformerFactory factory = TransformerFactory.newInstance();  
    Transformer transformer = factory.newTransformer(new StreamSource(styleSheet));  
  
    DocumentSource source = new DocumentSource(document);  
    DocumentResult result = new DocumentResult();  
    transformer.transform(source, result);  
  
    Document transformedDoc = result.getDocument();  
  
    return transformedDoc;  
  }  
/** 
 * @return Document 
 * @throws UnsupportedEncodingException 
 * @throws FileNotFoundException 
 */   
  public Document getRoleXML() throws UnsupportedEncodingException, FileNotFoundException   
  {  
	  
        InputStream is=null;  
      
        is = new FileInputStream(new File("src/assignment4/source/StudentList.xml"));  
        SAXReader reader = new SAXReader();  
          
        try {  
            return reader.read(is);  
        } catch (DocumentException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            
            return null;  
        }     
    }  
  public static void main(String args[]) throws IOException  {  
    try {  
        Document doc = new Xslt().getRoleXML();          
        Document resultDoc = Xslt.transformDocument(doc, new File("src/assignment4/source/xslt.xsl"));  
          
        OutputFormat format = OutputFormat.createPrettyPrint();                                           
        format.setEncoding("UTF-8");   
          
        XMLWriter writer = new XMLWriter(new FileWriter(new File("src/assignment4/source/xml3.xml")),format);  
        writer.write(resultDoc);   
        writer.close();   
        System.out.println("Succeed");
    	boolean bool=XMLValidator.validateXML("src/assignment4/source/ScoreList.xsd", "src/assignment4/source/xml3.xml");
   	 	if(bool){
   	 		System.out.println("succeed");
   		 	}
   	 	else{
   		 System.out.println("fail");
   	 	}
        
  
          
    } catch (UnsupportedEncodingException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    } catch (FileNotFoundException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    } catch (TransformerException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }    
    }  
}  
