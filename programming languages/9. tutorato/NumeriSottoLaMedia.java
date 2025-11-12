import java.util.Arrays;

public class NumeriSottoLaMedia {
    public static void main(String[] args) {
        // 1. Controllo numero argomenti
        if (args.length != 10) {
            System.out.println("Inserire 10 valori");
            return;
        }

        int[] valori = new int[10];

        // 2. Validazione e parsing
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (!isValidInt(arg)) {
                System.out.println("Errore: \"" + arg + "\" non è un numero intero valido.");
                return;
            }
            valori[i] = Integer.parseInt(arg);
        }

        // 3. Calcolo della media
        double somma = 0;
        for (int v : valori) {
            somma += v;
        }
        double media = somma / valori.length;

        // 4. Stampa dei numeri sotto la media
        System.out.println("Media: " + media);
        System.out.println("Numeri sotto la media:");
        for (int v : valori) {
            if (v < media) {
                System.out.println(v);
            }
        }
    }

    /**
     * Metodo che verifica se una stringa rappresenta un numero intero valido.
     * Accetta segni '+' e '-' all'inizio, seguito solo da cifre.
     */
    public static boolean isValidInt(String s) {
        if (s == null || s.isEmpty()) return false;

        int start = 0;
        char primoChar = s.charAt(0);

        if (primoChar == '+' || primoChar == '-') {
            if (s.length() == 1) return false; // "+" o "-" da solo non è valido
            start = 1;
        }

        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

