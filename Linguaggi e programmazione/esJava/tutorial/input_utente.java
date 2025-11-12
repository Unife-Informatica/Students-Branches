package LP.esJava.tutorial;
import java.util.Scanner;
public class input_utente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual'e' il tuo nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual'e' il tuo cognome?");
        String cognome = scanner.nextLine();

        System.out.println("Quanti anni hai?");
        int eta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dove vivi?");
        String citta = scanner.nextLine();

        System.out.println("Sei single?");
        boolean single = scanner.nextBoolean();



        System.out.println("Ciao "+nome+" "+ " "+cognome);
        System.out.println("Hai: "+ eta + "anni");
        System.out.println("Vivi a: "+ citta);
        System.out.println("Sei single?: "+ single);
    }
}
