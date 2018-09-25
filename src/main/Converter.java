package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

// With use of this class cv files with extensions .xml and .pdf are created.

public class Converter 
{
    
    private CurriculumVitae curriculumVitae;

    
	private final static String xmlFileLocationPath = PathPreparator.preparePath("cv.xml");
	private final static String pdfFileLocationPath = PathPreparator.preparePath("cv.pdf");  

	
	public Converter(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}
	
    public static String getFileLocationPath() {
    	return pdfFileLocationPath;
    }
    
    
    public void runConversionProcess() throws UnsupportedEncodingException, IOException, TransformerException, FOPException {
    	String xmlString = XMLCreator.createXML(curriculumVitae);
    	Formatter formatter = new Formatter(xmlString);
    	xmlString = formatter.formatString();
    	writeStringToFile(xmlString);
    	convertToPDF();
    	
    }
    
    private void writeStringToFile(String string) throws FileNotFoundException {
    	PrintWriter printWriter = new PrintWriter(xmlFileLocationPath);
    	printWriter.println(string);
    	printWriter.close();
    }
    
    
    
    public static void convertToPDF() throws IOException, FOPException, TransformerException {

        final String templateFileLocationPath = PathPreparator.preparePath("Stylesheet.xsl");
        File templateFile = new File(templateFileLocationPath);
        StreamSource streamSource = new StreamSource(new File(xmlFileLocationPath));
        String configurationFileLocationPath = PathPreparator.preparePath("fop.xconf");
        FopFactory fopFactory = FopFactory.newInstance(new File(configurationFileLocationPath).toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        OutputStream outputStream = new FileOutputStream(pdfFileLocationPath);
    	Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outputStream);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(templateFile));
        Result result = new SAXResult(fop.getDefaultHandler());
        
        transformer.transform(streamSource, result);
        outputStream.close();
        
    }
}