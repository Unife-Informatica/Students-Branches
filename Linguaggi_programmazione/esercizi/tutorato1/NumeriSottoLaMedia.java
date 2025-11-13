import java.util.Scanner;

public class NumeriSottoLaMedia{
  public static void main(String[] args){
    int somma = 0, sottoMedia = 0;
    double media;
    int[] array = new int[10];
    Scanner console = new Scanner(System.in);
    for(int i = 0; i < 10; i++){
      array[i] = console.nextInt();
    }

    for(int i = 0; i < 10; i++){
      somma += array[i];
    }
    media = somma/10;

    for(int i = 0; i < 10; i++){
      if(array[i] < media){
        sottoMedia++;
      }
    }

    System.out.println("Media: " + media + "\n");
    System.out.println("Temperature sotto la media: " + sottoMedia);
  }
}