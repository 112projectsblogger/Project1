package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.PathPreparator;

// Test related to PathPreparator class.

class PathPreparatorTest {

	@Test
	void preparePathTest() {
		String testPath = PathPreparator.preparePath("test.test");
		Assert.assertTrue(testPath.contains("Project1/build/classes/main/test.test"));
	}

}
