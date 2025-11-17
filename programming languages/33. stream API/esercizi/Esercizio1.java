import java.util.Arrays;

@FunctionalInterface
interface Calcola {
    int calcola(int[] numeri);
}

public class Esercizio1 {

    public static void main(String[] args) {

        int numeri[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };


        Calcola somma = array -> Arrays.stream(array).sum();

        Calcola massimo = array -> Arrays.stream(array)
                                         .max()
                                         .getAsInt();

        Calcola minimo = array -> Arrays.stream(array)
                                        .min()
                                        .getAsInt();

        System.out.println("Somma: " + somma.calcola(numeri));
        System.out.println("Massimo: " + massimo.calcola(numeri));
        System.out.println("Minimo: " + minimo.calcola(numeri));
    }
}

