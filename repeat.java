public class Repeater{
  public static String repeat(String s,long n){
    return s+(n<=1?"":repeat(s,n-1));
  }
}
