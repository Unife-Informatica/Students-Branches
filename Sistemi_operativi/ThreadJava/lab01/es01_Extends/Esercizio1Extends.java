package es01_Extends;
public class Esercizio1Extends{
  final static int N = 25;
  public static void main(String[] args) {
    System.out.printf("Esercizio1Extends");

    Accumulatore acc = new Accumulatore(0.0);
    CounterThread ct[] = new CounterThread[25];

    for(int i = 0; i < N; i++){
      ct[i] = new CounterThread(acc);
      ct[i].start();
    }

    for(int i = 0; i < N; i++){
      try{
        ct[i].join();
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
    System.out.println("Esercizio1Extends: accumulatore vale " + acc.getValue());
  }
}