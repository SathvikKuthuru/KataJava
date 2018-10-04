public class Solution {
    public static String repeatStr(final int repeat, final String string) {
        return repeat - 1 >= 0 ? string + repeatStr(repeat - 1, string) : "";
    }
}
