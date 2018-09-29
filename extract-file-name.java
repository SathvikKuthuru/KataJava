public class FileNameExtractor {
	public static String extractFileName(String d) {
		return d.substring(d.indexOf("_") + 1, d.indexOf(".", d.indexOf(".")+1));
	}
}
