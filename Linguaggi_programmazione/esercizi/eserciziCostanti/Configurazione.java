public class Configurazione {
  public static final String DEFAULT_HOST = "localhost";
  public static final int DEFAULT_PORT = 8080;

  private String host;
  private int port;

  public Configurazione(){
    host = DEFAULT_HOST;
    port = DEFAULT_PORT;
  }

  public void stampaConfigurazione(){
    System.out.println("Host: " + host);
    System.out.println("Porta: " + port);
  }
}
