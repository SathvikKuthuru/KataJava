public class BouncingBall {
	public static int bouncingBall(double h, double b, double w) {
		return (int) ((h <= 0 || b <= 0 || b >= 1 || w >= h) ? -1 : 2*(Math.ceil(Math.log(w/h)/Math.log(b)))-1);
	}
}
