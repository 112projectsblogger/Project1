package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * This class is used by XStream's object in process of creating xml String.
 * 
 * @author MJazy
 *
 */

public class CurriculumVitae {
	@SuppressWarnings("unused")
	private String fullName;
	@SuppressWarnings("unused")
	private String birthdate;
	@SuppressWarnings("unused")
	private String city;
	@SuppressWarnings("unused")
	private String phoneNumber;
	private String pictureLink;
	private List<String> college = new ArrayList<String>();
	private List<String> fieldOfStudy = new ArrayList<String>();
	private List<String> studyStartDate = new ArrayList<String>();
	private List<String> studyEndDate = new ArrayList<String>();
	private List<String> company = new ArrayList<String>();
	private List<String> post = new ArrayList<String>();
	private List<String> jobStartDate = new ArrayList<String>();
	private List<String> jobEndDate = new ArrayList<String>();
	private List<String> languageName = new ArrayList<String>();
	private List<String> languageLevel = new ArrayList<String>();
	@SuppressWarnings("unused")
	private String skills;

	public CurriculumVitae() {
	}

	/**
	 * Constructor that should be used to instantiate object with
	 * HttpServletRequest's data.
	 * 
	 * @param httpServletRequest containing relevant cv data.
	 */
	public CurriculumVitae(HttpServletRequest httpServletRequest) {
		this.setFullName(httpServletRequest.getParameter("fullName"));
		this.setBirthdate(httpServletRequest.getParameter("birthdate"));
		this.setCity(httpServletRequest.getParameter("city"));
		this.setPhoneNumber(httpServletRequest.getParameter("phoneNumber"));
		try {
			this.setPicture(httpServletRequest.getPart("picture").getInputStream());
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		this.setCollege(httpServletRequest.getParameterValues("college"));
		this.setFieldOfStudy(httpServletRequest.getParameterValues("fieldOfStudy"));
		this.setStudyStartDate(httpServletRequest.getParameterValues("studyStartDate"));
		this.setStudyEndDate(httpServletRequest.getParameterValues("studyEndDate"));
		this.setCompany(httpServletRequest.getParameterValues("company"));
		this.setPost(httpServletRequest.getParameterValues("post"));
		this.setJobStartDate(httpServletRequest.getParameterValues("jobStartDate"));
		this.setJobEndDate(httpServletRequest.getParameterValues("jobEndDate"));
		this.setLanguage(httpServletRequest.getParameterValues("languageName"));
		this.setLanguageLevel(httpServletRequest.getParameterValues("languageLevel"));
		this.setSkills(httpServletRequest.getParameter("skills"));

	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPicture(InputStream picturePartInputStream) throws IOException {
		pictureLink = PathPreparator.preparePath("picture.jpg");
		File file = new File(pictureLink);
		OutputStream outputStream = new FileOutputStream(file);
		byte[] buffer = new byte[4096];
		int length;

		while ((length = picturePartInputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		picturePartInputStream.close();
		outputStream.close();

	}

	public void setCollege(String[] college) {
		for (int index = 0; index < college.length; index++) {
			this.college.add(college[index]);
		}
	}

	public void setFieldOfStudy(String[] fieldOfStudy) {
		for (int index = 0; index < fieldOfStudy.length; index++) {
			this.fieldOfStudy.add(fieldOfStudy[index]);
		}
	}

	public void setStudyStartDate(String[] studyStartDate) {
		for (int index = 0; index < studyStartDate.length; index++) {
			this.studyStartDate.add(studyStartDate[index]);
		}
	}

	public void setStudyEndDate(String[] studyEndDate) {
		for (int index = 0; index < studyEndDate.length; index++) {
			this.studyEndDate.add(studyEndDate[index]);
		}
	}

	public void setCompany(String[] company) {
		for (int index = 0; index < company.length; index++) {
			this.company.add(company[index]);
		}
	}

	public void setPost(String[] post) {
		for (int index = 0; index < post.length; index++) {
			this.post.add(post[index]);
		}
	}

	public void setJobStartDate(String[] jobStartDate) {
		for (int index = 0; index < jobStartDate.length; index++) {
			this.jobStartDate.add(jobStartDate[index]);
		}
	}

	public void setJobEndDate(String[] jobEndDate) {
		for (int index = 0; index < jobEndDate.length; index++) {
			this.jobEndDate.add(jobEndDate[index]);
		}
	}

	public void setLanguage(String[] languageName) {
		for (int index = 0; index < languageName.length; index++) {
			this.languageName.add(languageName[index]);
		}
	}

	public void setLanguageLevel(String[] languageLevel) {
		for (int index = 0; index < languageLevel.length; index++) {
			this.languageLevel.add(languageLevel[index]);
		}
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
}
