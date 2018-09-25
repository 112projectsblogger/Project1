package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;


// Class related to processing input data and also returning relevant output.
// doPost method fills instance of CurriculumVitae class with data and also with runs conversion process with use of Converter.
// After it doGet method related to enabling download of pdf file is triggered.

@WebServlet("/enter-data")
@MultipartConfig
public class Servlet extends HttpServlet {

		
	private static final long serialVersionUID = 1L;

	private CurriculumVitae curriculumVitae = new CurriculumVitae();
	
	
	public void doGet(HttpServletResponse httpServletResponse) throws IOException {

		httpServletResponse.setContentType("APPLICATION/OCTECT-STREAM");
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename=cv.pdf");
		
		File file = new File(Converter.getFileLocationPath());
		FileInputStream fileInputStream = new FileInputStream(file);
		OutputStream outputStream = httpServletResponse.getOutputStream();
		
		byte[] buffer = new byte[4096];
		int length;
		
		while ((length = fileInputStream.read(buffer))>0) {
			outputStream.write(buffer, 0, length);
		}
		
		fileInputStream.close();
		outputStream.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException, ServletException {
		
		curriculumVitae.setFullName(request.getParameter("fullName"));
		curriculumVitae.setBirthdate(request.getParameter("birthdate"));
		curriculumVitae.setCity(request.getParameter("city"));
		curriculumVitae.setPhoneNumber(request.getParameter("phoneNumber"));
		curriculumVitae.setPicture(request.getPart("picture").getInputStream());	
		curriculumVitae.setCollege(request.getParameterValues("college"));
		curriculumVitae.setFieldOfStudy(request.getParameterValues("fieldOfStudy"));
		curriculumVitae.setStudyStartDate(request.getParameterValues("studyStartDate"));				
		curriculumVitae.setStudyEndDate(request.getParameterValues("studyEndDate"));			
		curriculumVitae.setCompany(request.getParameterValues("company"));
		curriculumVitae.setPost(request.getParameterValues("post"));
		curriculumVitae.setJobStartDate(request.getParameterValues("jobStartDate"));			
		curriculumVitae.setJobEndDate(request.getParameterValues("jobEndDate"));			
		curriculumVitae.setLanguage(request.getParameterValues("languageName"));
		curriculumVitae.setLanguageLevel(request.getParameterValues("languageLevel"));			
		curriculumVitae.setSkills(request.getParameter("skills"));			

		Converter converter = new Converter(curriculumVitae);
		try {
			converter.runConversionProcess();
		} catch (FOPException | TransformerException exception) {
			exception.printStackTrace();
		}
		doGet(httpServletResponse);	
	}				
}