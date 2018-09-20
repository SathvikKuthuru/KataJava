public class Compare {
  	
	public static int[] compare(int[] number1, int[] number2) {
	return number1[1]*(double)Math.log((double)number1[0]) < number2[1]*(double)Math.log((double)number2[0]) ? number2 : number1;
  }

}