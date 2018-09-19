package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Formatter;

class FormatterTest {

	String testString = "<CV><fullName>test</fullName><birthdate>test</birthdate><city>test</city><phoneNumber>test</phoneNumber>"
			+ "<pictureLink>C:/Users/MJazy/Documents/112Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project1/WEB-INF/classes/main/picture.jpg</pictureLink>"
			+ "<college><string></string></college><fieldOfStudy><string></string></fieldOfStudy><studyStartDate><string></string></studyStartDate><studyEndDate><string></string></studyEndDate>"
			+ "<company><string></string></company><post><string></string></post><jobStartDate><string></string></jobStartDate><jobEndDate><string></string></jobEndDate>"
			+ "<languageName><string></string></languageName><languageLevel><string></string></languageLevel>"
			+ "<skills><string></string></skills></CV>";
	
	Formatter formatter = new Formatter(testString);	
	
	@Test
	void formatStringTest() {
		String formattedTestString = "<CV><basicInformation><fullName>test</fullName><birthdate>test</birthdate><city>test</city><phoneNumber>test</phoneNumber>"
				+ "<pictureLink>C:/Users/MJazy/Documents/112Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project1/WEB-INF/classes/main/picture.jpg</pictureLink></basicInformation>"
				+ "<education><college><string></string></college><fieldOfStudy><string></string></fieldOfStudy><studyStartDate><string></string></studyStartDate><studyEndDate><string></string></studyEndDate></education>"
				+ "<experience><company><string></string></company><post><string></string></post><jobStartDate><string></string></jobStartDate><jobEndDate><string></string></jobEndDate></experience>"
				+ "<language><languageName><string></string></languageName><languageLevel><string></string></languageLevel></language>"
				+ "<skills><string></string></skills></CV>";
		assertEquals(formattedTestString, formatter.formatString());
	}

}