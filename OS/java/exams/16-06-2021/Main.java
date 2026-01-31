import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valoreSoglia;

        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos;

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            pos = new PipedOutputStream(pis);
            oos = new ObjectOutputStream(pos);
            ois = new ObjectInputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
            sc.close();
            return;
        }

        do {
            System.out.print("Inserire il valore di soglia (100-200): ");
            valoreSoglia = sc.nextInt();
        } while (valoreSoglia < 100 || valoreSoglia > 200);

        sc.close();

        GeneraRilevazioni gr = new GeneraRilevazioni(oos);
        gr.start();

        int count = 0;
        int countCons = 0;

        while (count < 10) {
            try {
                Rilevazione r = (Rilevazione) ois.readObject();

                if (r.getVal() <= 50) System.out.println(
                    "basso - " + r.getVal()
                );
                else if (r.getVal() <= 100) System.out.println(
                    "moderato - " + r.getVal()
                );
                else System.out.println("alto - " + r.getVal());

                if (r.getVal() > valoreSoglia) countCons++;
                else countCons = 0;

                if (countCons >= 3) System.out.println("attenzione");

                count++;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }

        gr.terminaRilevazione();

        try {
            gr.join();
            ois.close();
            oos.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("Il thread GeneraRilevazioni è terminato");
    }
}
