public class TrafficLights {
  public static String updateLight(String current) {
    String[] a = {"green", "yellow", "red", "green"};
    return a[java.util.Arrays.asList(a).indexOf(current)+1];
  }
}
