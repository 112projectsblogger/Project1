package main;

import java.util.List;

/** 
 * Use of this class is related to createComplexElement method of Formatter class.
 * @author MJazy
 *
 */

public class Element {

	private String openingBracket;
	private String closingBracket;
	private List<String> content;
	
	public Element(String openingBracket, String closingBracket, List<String> content) {
		this.openingBracket = openingBracket;
		this.closingBracket = closingBracket;
		this.content = content;
	}
	
	public String getOpeningBracket() {
		return openingBracket;
	}
		
	public String getClosingBracket() {
		return closingBracket;
	}
		
	public List<String> getContent() {
		return content; 
	}
		
}
