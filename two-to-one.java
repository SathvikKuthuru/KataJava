import java.util.TreeSet;

public class TwoToOne {

	public static String longest(String s1, String s2) {
		TreeSet<String> h = new TreeSet<>();
		String s = "";
		for(int i = 0; i < s1.length(); i++) h.add(s1.substring(i, i+1));
		for(int i = 0; i < s2.length(); i++) h.add(s2.substring(i, i+1));
		for(String a : h) s += a;
		return s;
	}
}
