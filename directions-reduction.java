import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        ArrayList<String> a = new ArrayList<>(Arrays.asList(arr));
        int x = findIndex(a);
        while(x != -1) {
        	a.remove(x);
        	a.remove(x);
        	x = findIndex(a);
        }
        return a.toArray(new String[a.size()]);
    }
    
    static int findIndex(ArrayList<String> a) {
    	for(int i = 1; i < a.size(); i++) {
    		switch(a.get(i-1)) {
    		case "NORTH":
    			if(a.get(i) == "SOUTH") return i-1;
    			break;
    		case "SOUTH":
    			if(a.get(i) == "NORTH") return i-1;
    			break;
    		case "EAST":
    			if(a.get(i) == "WEST") return i-1;
    			break;
    		case "WEST":
    			if(a.get(i) == "EAST") return i-1;
    			break;
    		}
    	}
    	return -1;
    }
}
