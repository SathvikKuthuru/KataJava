public class Solution {
  public int solution(int number) {
  return ((number-1)%15==0||(number-1)%3==0||(number-1)%5==0 ? number-1 : 0) + (number-1<=1 ? 0 : solution(number-1));
  }
}
