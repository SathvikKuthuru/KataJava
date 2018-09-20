import java.util.List;

public class BinaryArrayToNumber {

	//Solution 1
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String s = "";
        for(Integer i : binary) s += i;
        return Integer.parseInt(s, 2);
    }
    
    //Solution 2
    public static int ConverBinaryArrayToIntTwo(List<Integer> binary) {
    	String s = "";
        for(Integer i : binary) s += i;
        int binaryNumber = Integer.parseInt(s);
        int decimal = 0;
        int p = 0;
        while(true){
          if(binaryNumber == 0){
            break;
          } else {
              int temp = binaryNumber%10;
              decimal += temp*Math.pow(2, p);
              binaryNumber = binaryNumber/10;
              p++;
           }
        }
        return decimal;
    }
    
    //Solution 3
    public static int ConvertBinaryArrayToIntThree(List<Integer> binary) {
        int sum = 0;
        for(int i = 0; i < binary.size(); i++) {
        	sum += binary.get(i)*Math.pow(2, binary.size()-i-1);
        }
        return sum;
    }
}
