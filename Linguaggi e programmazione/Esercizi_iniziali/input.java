package LP.Esercizi_iniziali;
import java.util.Scanner;


public class input {
    public static void main(String[] args) {
        int n1,n2;

        Scanner obj = new Scanner(System.in);
        System.out.println("Inserisci primo numero: ");
        n1= obj.nextInt();
        System.out.println("Inserisci secondo numero: ");
        n2= obj.nextInt();
        Integer i1 = Integer.valueOf(n1);
        Integer i2 = Integer.valueOf(n2);
        System.out.println(i1.toString()+i2.toString());
        

    }
}
