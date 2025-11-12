package LP.esJava.numeri;
import java.util.Scanner;

public class es09 {
    public static void main(String[] args){
        int[] n = new int[3];
        int min = 0;
        Scanner obj = new Scanner(System.in);
        for(int i = 0; i<3;i++){
            System.out.println("Inserisci il "+i+" numero: ");
            n[i]=obj.nextInt();
        }
        min = n[0];
        for(int i = 1; i<3;i++){
                if(n[i]<min){
                    min=n[i];
                }
        }
        System.out.println(min);
        double n1 = 8.4;
        double n2 = 3.5;
        double n3 = 4.5;
        double minimo = Math.min(Math.min(n1,n2),n3);
        2System.out.println(minimo);
    }
    
}
