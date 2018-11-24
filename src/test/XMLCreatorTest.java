package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import main.CurriculumVitae;
import main.PathPreparator;
import main.XMLCreator;


class XMLCreatorTest {
		
	@Test
	void createXMLTest() throws IOException {
		String pictureLinkContent = PathPreparator.preparePath("picture.jpg");	
		
		String relevantResult = "<CV>\n" + 
				"  <fullName>test</fullName>\n" + 
				"  <birthdate>test</birthdate>\n" + 
				"  <city>test</city>\n" + 
				"  <phoneNumber>test</phoneNumber>\n" + 
				"  <pictureLink>" + pictureLinkContent + "</pictureLink>\n" + 
				"  <college>\n" + 
				"    <string>test</string>\n" + 
				"  </college>\n" + 
				"  <fieldOfStudy>\n" + 
				"    <string>test</string>\n" + 
				"  </fieldOfStudy>\n" + 
				"  <studyStartDate>\n" + 
				"    <string>test</string>\n" + 
				"  </studyStartDate>\n" + 
				"  <studyEndDate>\n" + 
				"    <string>test</string>\n" + 
				"  </studyEndDate>\n" + 
				"  <company>\n" + 
				"    <string>test</string>\n" + 
				"  </company>\n" + 
				"  <post>\n" + 
				"    <string>test</string>\n" + 
				"  </post>\n" + 
				"  <jobStartDate>\n" + 
				"    <string>test</string>\n" + 
				"  </jobStartDate>\n" + 
				"  <jobEndDate/>\n" + 
				"  <languageName/>\n" + 
				"  <languageLevel/>\n" + 
				"</CV>";

		String testString = "test";
		String testArray[] = {"test"};			
		InputStream testInputStream = new ByteArrayInputStream("test data".getBytes());
		
		CurriculumVitae curriculumVitae = new CurriculumVitae();
		curriculumVitae.setFullName(testString);
		curriculumVitae.setBirthdate(testString);
		curriculumVitae.setCity(testString);
		curriculumVitae.setPhoneNumber(testString);
		curriculumVitae.setPicture(testInputStream);
		curriculumVitae.setCollege(testArray);
		curriculumVitae.setFieldOfStudy(testArray);
		curriculumVitae.setStudyStartDate(testArray);
		curriculumVitae.setStudyEndDate(testArray);
		curriculumVitae.setCompany(testArray);
		curriculumVitae.setPost(testArray);
		curriculumVitae.setJobStartDate(testArray);
		curriculumVitae.setFullName(testString);
		curriculumVitae.setFullName(testString);
		curriculumVitae.setFullName(testString);
		
		assertEquals(relevantResult, XMLCreator.createXML(curriculumVitae));
	}

}
