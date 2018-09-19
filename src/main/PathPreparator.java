package main;

public class PathPreparator {
		
	public static String preparePath(String fileName) {
		String pathToBuildClassess = PathPreparator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		// First sign can be removed.
		String path = pathToBuildClassess.substring(1, pathToBuildClassess.length()) + "main/" + fileName;
		return path;
	}
	
}
