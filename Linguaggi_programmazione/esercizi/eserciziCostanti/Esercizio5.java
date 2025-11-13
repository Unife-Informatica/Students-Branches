public class Esercizio5 {
    public interface Costanti {
        int LUNGHEZZA_MASSIMA = 100;
        String MESSAGGIO_DI_BENVENUTO = "Benvenuto!";
    }

    public static void main(String[] args) {
        System.out.println("Lunghezza massima: " + Costanti.LUNGHEZZA_MASSIMA);
        System.out.println(Costanti.MESSAGGIO_DI_BENVENUTO);
    }
}
