import java.util.Scanner;

public class FrequenzaCarattere {
  public static void main(String[] args) {
    boolean check = false;
    String numeroTel;
    int[] numeri = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int contatore = 0;
    Scanner console = new Scanner(System.in);
    do{
      numeroTel = console.nextLine();
      if(numeroTel.length() == 10){
        check = true;
      }else{
        System.out.println("Reinserisci il numero di telefono: numero caratteri errato: ");
      }
    }while(!check);

    for(int i = 0; i < numeri.length; i++){
      contatore = 0;
      for(int j = 0; j < numeroTel.length(); j++){
        if(numeri[i] == Character.getNumericValue(numeroTel.charAt(j))){
          contatore++;
        }
      }
      System.out.println("Il numero " + numeri[i] + " " + contatore + " volte");
    }
  }
}
