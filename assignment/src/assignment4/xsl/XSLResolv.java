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

import assignment4.validator.XMLValidator;


  
  
public class XSLResolv {  
	public static Document transformDocument(Document document, File styleSheet) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(styleSheet));

		DocumentSource source = new DocumentSource(document);
		DocumentResult result = new DocumentResult();
		transformer.transform(source, result);

		Document transformedDoc = result.getDocument();

		return transformedDoc;
	}

	public static Document getInputXML(){
		InputStream is = null;

		try {
			is = new FileInputStream(new File("src/assignment4/xml/文档2.xml"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		SAXReader reader = new SAXReader();

		try {
			return reader.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) throws IOException {
		try {
			Document doc = XSLResolv.getInputXML();
			boolean inputValidation = XMLValidator.validateXML("src/assignment4/schema/StudentList.xsd","src/assignment4/xml/文档2.xml");
			if (inputValidation) {
				System.out.println("succeed input file schema validation");
			} else {
				System.out.println("fail input file schema validation");
				return;
			}
			Document resultDoc = XSLResolv.transformDocument(doc, new File("src/assignment4/xsl/xslt.xsl"));

			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");

			XMLWriter writer = new XMLWriter(new FileWriter(new File("src/assignment4/xml/文档3.xml")), format);
			writer.write(resultDoc);
			writer.close();
			System.out.println("Succeed tranform xsl");
			
			boolean outputValidation = XMLValidator.validateXML("src/assignment4/schema/ScoreList.xsd","src/assignment4/xml/文档3.xml");
			if (outputValidation) {
				System.out.println("succeed output file schema validation");
			} else {
				System.out.println("fail output file schema validation");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}  

