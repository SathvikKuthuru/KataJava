public class Line {
	public static String WhoIsNext(String[] names, int n) {
		while(n > 5) {
			n -= 4;
			n /= 2;
		}
		return names[n-1];
	}
}
