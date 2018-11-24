package main;

/**
 * This class is used to prepare paths for various files, result of only method includes path with Project1/build/classes/main/ and supplied String added.
 * @author MJazy
 *
 */

public class PathPreparator {
		
	public static String preparePath(String fileName) {
		String pathToBuildClassess = PathPreparator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		// First sign can be removed.
		String path = pathToBuildClassess.substring(1, pathToBuildClassess.length()) + "main/" + fileName;
		return path;
	}
	
}
