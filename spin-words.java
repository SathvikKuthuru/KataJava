public class SpinWords {
	public String spinWords(String s) {
		String n = "";
		for(String a : s.split(" ")) {
			n += (a.length() < 5 ? a : new StringBuilder(a).reverse().toString()) + " ";
		}
		return n.substring(0, n.length()-1);
	}
}
