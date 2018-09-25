public class Reverse {
	public static String reverseLetter(final String str) {
		StringBuilder a = new StringBuilder();
		for(int i = 0; i < str.length(); i++) if(Character.isLetter(str.charAt(i))) a.append(str.charAt(i));
		return a.reverse().toString();
	}
}
