package LP.tutorati.tutorato1;
import java.util.Scanner;

public class es02 {
    public static void main(String[] args) {
        int[] tmp = new int[10];
        int somma=0;
        int media=0;
        Scanner obj = new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Inserisci il "+i+"numero: ");
            tmp[i]=obj.nextInt();
        }
        for(int i=0;i<10;i++){
    
            somma+=tmp[i];
        }
        media = somma/10;
        System.out.println("La media e': "+media);
        for(int i=0;i<10;i++){
            if(tmp[i]<media){
                System.out.println(tmp[i]);
            }
        }
        
    }
}
