package main;

import com.thoughtworks.xstream.XStream;

/**
 * This class is related to creating xml String with use of XStream and
 * CurriculumVitae classes.
 * 
 * @author MJazy
 *
 */

public class XMLCreator {
	public static String createXML(CurriculumVitae curriculumVitae) {
		XStream xStream = new XStream();
		xStream.alias("CV", curriculumVitae.getClass());
		String xml = xStream.toXML(curriculumVitae);
		return xml;
	}
}
