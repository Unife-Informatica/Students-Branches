package LP.tutorati.tutorato1;
import java.util.Scanner;

public class es01 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int[] arr = new int[2];
        int risultato = 0;
        for(int i =0; i<2;i++){
            System.out.println("Inserisci il " + i +" numero");
            arr[i]=obj.nextInt();
        }
        for(int i=0;i<2;i++){
            risultato+=arr[i];
        }
        System.out.println(risultato);

    }
}
