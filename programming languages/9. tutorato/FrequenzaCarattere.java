import java.util.Scanner;

public class FrequenzaCarattere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci un numero di 10 cifre: ");
        String input = scanner.next();

        if (input.length() != 10) {
            System.out.println("Errore: Il numero deve essere di 10 cifre");
            return;
        }

        if (!isValidInt(input)) {
            System.out.println("Errore: Il numero deve contenere solo cifre");
            return;
        }

        int[] frequenze = contaFrequenze(input);

        System.out.println("Frequenza delle cifre:");
        for (int i = 0; i < frequenze.length; i++) {
            System.out.println(i + ": " + frequenze[i]);
        }
    }

    /**
     * Metodo che verifica se una stringa rappresenta un numero intero valido.
     */
    public static boolean isValidInt(String s) {
        if (s == null || s.isEmpty()) return false;

        int start = 0;
        char primoChar = s.charAt(0);

        // Controlla che siano cifre
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Conta le frequenze delle cifre da 0 a 9 in una stringa numerica.
     */
    public static int[] contaFrequenze(String s) {
        int[] frequenze = new int[10];

        for (int i = 0; i < s.length(); i++) {
            /*
             * I char sono file interi (es. '0' = 48; '1' = 49; ...).
             * Quindi se s.charAt(i) ritorna '5'(che vale 53) e gli sottraggo '0'(che vale 48) risulta 5(come intero)
             */
            int cifra = s.charAt(i) - '0';
            frequenze[cifra]++;
        }

        return frequenze;
    }
}

