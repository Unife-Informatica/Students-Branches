public class SumFromArgs {
    public static void main(String[] args) {
        // Controllo se è stato passato almeno un numero
        if (args.length == 0) {
            System.out.println("Errore: inserisci almeno un numero intero.");
            return;
        }

        int somma = 0;

        for (String arg : args) {
            if (!isValidInt(arg)) {
                System.out.println("Errore: \"" + arg + "\" non è un numero intero valido.");
                return;
            }

            // Conversione sicura dopo la validazione
            somma += Integer.parseInt(arg);
        }

        System.out.println("La somma è: " + somma);
    }

    /**
     * Metodo che verifica se una stringa rappresenta un numero intero valido.
     * Accetta segni '+' e '-' all'inizio, seguito solo da cifre.
     */
    public static boolean isValidInt(String s) {
        if (s == null || s.isEmpty()) return false;

        int start = 0;
        char primoChar = s.charAt(0);

        // Gestisce il segno iniziale
        if (primoChar == '+' || primoChar == '-') {
            if (s.length() == 1) return false; // "+" o "-" da solo non è un numero
            start = 1;
        }

        // Controlla che il resto siano cifre
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
