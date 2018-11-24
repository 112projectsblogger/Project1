package main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;


/**
 * After using XMLCreator created xmlString doesn't have relevant format at the beginning. 
 * Formatting is related to display with use of Stylesheet.xsl.
 * @author MJazy
 *
 */

public class Formatter {
	
	private String xmlString;
	
	public Formatter(String xmlString){
		this.xmlString = xmlString;
	}
	
	public String formatString() {
		String fullNameElementString = prepareBasicElementString("<fullName>", "</fullName>");
		String birthdateElementString = prepareBasicElementString("<birthdate>", "</birthdate>");
		String cityElementString = prepareBasicElementString("<city>", "</city>");
		String phoneNumberElementString = prepareBasicElementString("<phoneNumber>", "</phoneNumber>");
		String pictureLinkElementString = prepareBasicElementString("<pictureLink>", "</pictureLink>");

		String basicInformationElementString = "<basicInformation>" + fullNameElementString + birthdateElementString + cityElementString + phoneNumberElementString + pictureLinkElementString + "</basicInformation>";
		
		List<String> collegeContent = prepareSimpleElementContent("<college>", "</college>", "</string>");
		Element collegeElement = new Element("<college>", "</college>", collegeContent);		
		List<String> fieldOfStudyContent = prepareSimpleElementContent("<fieldOfStudy>", "</fieldOfStudy>", "</string>");
		Element fieldOfStudyElement = new Element("<fieldOfStudy>", "</fieldOfStudy>", fieldOfStudyContent);
		List<String> studyStartDateContent = prepareSimpleElementContent("<studyStartDate>", "</studyStartDate>", "</string>");
		Element studyStartDateElement = new Element("<studyStartDate>", "</studyStartDate>", studyStartDateContent);
		List<String> studyEndDateContent = prepareSimpleElementContent("<studyEndDate>", "</studyEndDate>", "</string>");
		Element studyEndDateElement = new Element("<studyEndDate>", "</studyEndDate>", studyEndDateContent);

		String educationElementString = prepareComplexElementString ("<education>", "</education>", collegeElement, fieldOfStudyElement, studyStartDateElement, studyEndDateElement);
		
		
		List<String> companyContent = prepareSimpleElementContent("<company>", "</company>", "</string>");
		Element companyElement = new Element("<company>", "</company>", companyContent);
		List<String> postContent = prepareSimpleElementContent("<post>", "</post>", "</string>");
		Element postElement = new Element ("<post>", "</post>", postContent);
		List<String> jobStartDateContent = prepareSimpleElementContent("<jobStartDate>", "</jobStartDate>", "</string>");
		Element jobStartDateElement = new Element("<jobStartDate>", "</jobStartDate>", jobStartDateContent);
		List<String> jobEndDateContent = prepareSimpleElementContent("<jobEndDate>", "</jobEndDate>", "</string>");
		Element jobEndDateElement = new Element("<jobEndDate>", "</jobEndDate>", jobEndDateContent);
		String experienceElementString = prepareComplexElementString("<experience>", "</experience>", companyElement, postElement, jobStartDateElement, jobEndDateElement);
				
		List<String> languageNameContent = prepareSimpleElementContent("<languageName>", "</languageName>", "</string>");
		Element languageNameElement = new Element("<languageName>", "</languageName>", languageNameContent);
		List<String> languageLevelContent = prepareSimpleElementContent("<languageLevel>", "</languageLevel>", "</string>");
		Element languageLevelElement = new Element("<languageLevel>", "</languageLevel>", languageLevelContent);
		String languageElementString = prepareComplexElementString("<language>", "</language>", languageNameElement, languageLevelElement);		
		
		
		// Element skills doesn't have to be additionally formatted. 9 is the number of signs in "</skills>".
		String skillsElementString = xmlString.substring(xmlString.indexOf("<skills>"), xmlString.indexOf("</skills>")+9);
		
		xmlString = "<CV>" + basicInformationElementString + educationElementString + experienceElementString + languageElementString + skillsElementString + "</CV>";
		return xmlString;
	
	}
	

	
	// Complex - having more than one type of parent element inside.
	private static String prepareComplexElementString(String openingBracket, String closingBracket, Element... simpleElements) {
		
		String complexElementString = "";
		int simpleElementSize = simpleElements[0].getContent().size();
		for (int index = 0; index< simpleElementSize; index++) {
			complexElementString = complexElementString + openingBracket;
			for (Element simpleElement: simpleElements) {
				complexElementString = complexElementString + simpleElement.getOpeningBracket() + simpleElement.getContent().get(index) + simpleElement.getClosingBracket();
			}
			complexElementString = complexElementString + closingBracket;
		}
				
		return complexElementString;
		
	}
		
	// Simple - having no more than one type of parent element inside.
	private List<String> prepareSimpleElementContent(String elementOpeningBracket, String elementClosingBracket, String subelementName){
		int contentStartIndex = xmlString.indexOf(elementOpeningBracket)+elementOpeningBracket.length();		
		int contentEndIndex = xmlString.indexOf(elementClosingBracket);
		String content = xmlString.substring(contentStartIndex, contentEndIndex);
		List<Integer> stringEndPositionList = spotToSliceList(content, subelementName);
		List<String> stringList = new ArrayList<String>();
		
		int stringEndIndex;
		for (int index=0; index<stringEndPositionList.size(); index++) {
			stringEndIndex = stringEndPositionList.get(index);
			stringList.add(content.substring(0, stringEndIndex));
			content = content.substring(stringEndIndex, content.length());
			
		}		
		
		
		return stringList;
	}
	
	// Basic - not having any child elements.
	private String prepareBasicElementString(String openingBracket, String closingBracket) {
		String basicElementString = xmlString.substring(xmlString.indexOf(openingBracket), xmlString.indexOf(closingBracket)+closingBracket.length());
		return basicElementString;
	};

	
	private static List<Integer> spotToSliceList(String stringToSlice, String substringToSliceAfter) {
		
		List<Integer> spotsToSlice = new ArrayList<Integer>();
		int numberOfSpotsToSlice = StringUtils.countMatches(stringToSlice, substringToSliceAfter);
		for (int index=0; index < numberOfSpotsToSlice; index++) {
			int substringEndPosition = stringToSlice.indexOf(substringToSliceAfter)+substringToSliceAfter.length();
			if(spotsToSlice.isEmpty() == true) {
				spotsToSlice.add(substringEndPosition);
			}
			else {
				int lastIndex = spotsToSlice.size();
				spotsToSlice.add(substringEndPosition+spotsToSlice.indexOf(lastIndex)+1);
			}
			stringToSlice = stringToSlice.substring(substringEndPosition, stringToSlice.length());
		}		
				
		return spotsToSlice;
	}
			
}
