public class Esercizio7 {
  public class CostantiUtil{
    public static final String URL = "https://example.com";
    public static final int TIMEOUT = 5000;
  }

  public class UtilizzoCostantiUtil{
    public static void main(String[] args) {
      System.out.println("URL: " + CostantiUtil.URL);
      System.out.println("Timeout: " + CostantiUtil.TIMEOUT);
    }
  }
}
