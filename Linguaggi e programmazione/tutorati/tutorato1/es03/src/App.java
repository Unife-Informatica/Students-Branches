
import java.util.Scanner;


public class App {
    public static void main(String[] args){
        String numTel;
        int[] conta = new int[10];
        Scanner obj = new Scanner(System.in);
        numTel = obj.nextLine();
        while(numTel.length()!=10){
            numTel = obj.nextLine();
        }
        for(int i=0;i<10;i++){
            conta[i]=0;
        }
        for(int i=0;i<10;i++){
            char carattere_corrente = numTel.charAt(i);
            int posizione = Character.getNumericValue(carattere_corrente);
            conta[posizione]++;
        }
        for(int i=0;i<10;i++){
            System.out.println("Numero " +i+" si ripete "+conta[i]+" volte");
        }
    }
}