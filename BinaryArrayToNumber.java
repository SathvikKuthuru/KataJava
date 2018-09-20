import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String s = "";
        for(Integer i : binary) s += i;
        return Integer.parseInt(s, 2);
    }
}