public class Square {
	public static boolean isSquare(int n) {
		int x = (int) Math.sqrt(n);
		return x * x == n;
	}
}
