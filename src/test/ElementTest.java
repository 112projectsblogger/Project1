package test;

import static org.junit.jupiter.api.Assertions.*;
import main.Element;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ElementTest {

	List<String> elementContent = new ArrayList<String>();
	Element element = new Element("<test>", "</test>", elementContent);

	@Test
	void getOpeningBracketTest() {
		assertEquals("<test>", element.getOpeningBracket());
	}

	@Test
	void getClosingBracketTest() {
		assertEquals("</test>", element.getClosingBracket());
	}

	@Test
	void getContentTest() {
		assertEquals(elementContent, element.getContent());
	}

}
