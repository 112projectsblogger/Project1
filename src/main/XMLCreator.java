package main;

import com.thoughtworks.xstream.XStream;

public class XMLCreator {
	public static String createXML(CurriculumVitae curriculumVitae) {
		XStream xStream = new XStream();
		xStream.alias("CV", curriculumVitae.getClass());
		String xml = xStream.toXML(curriculumVitae);
		return xml;
	}
}
