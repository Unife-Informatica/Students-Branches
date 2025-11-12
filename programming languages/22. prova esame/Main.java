import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Automobili listaAuto = new Automobili("ordini.txt");

        listaAuto.stampa();

        System.out.print("Inserire modello da cercare: ");
        String in = console.next();
        listaAuto.printByCarContructor(in);

        console.close();
    }
}
