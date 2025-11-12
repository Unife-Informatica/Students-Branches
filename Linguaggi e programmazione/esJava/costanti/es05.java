package LP.esJava.costanti;
public interface Costant{
    int LUNGHEZZA_MASSIMA = 100;
    String MESSAGGIO_BENVENUTO = "Benvenuto!";
}
public class es05 implements Costant {
    
    public static void main(String[] args) {
        System.out.println(LUNGHEZZA_MASSIMA);
        System.out.println(MESSAGGIO_BENVENUTO);
    }
}


