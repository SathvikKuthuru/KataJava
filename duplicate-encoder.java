import java.util.HashMap;

public class DuplicateEncoder {
	static String encode(String word){
		HashMap<Character, Integer> h = new HashMap<>();
		String s = "";
		word = word.toLowerCase();
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < word.length(); j++) {
				Character c = word.charAt(j);
				if(i%2 == 0) {
					if(!h.containsKey(c)) h.put(c, 1);
					else h.put(c, h.get(c)+1);
				} else s += h.get(c) == 1 ? "(" : ")";
			}
		}
		return s;
  }
}
