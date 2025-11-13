public class Esercizio9 {
  public static void main(String[] args) {
    String parole[] = {"casa", "cane", "gatto", "casa", "casa"};
    String paroleDaContare = "casa";
    int conteggio = 0;
    for(String parola : parole){
      if(parola.equals(paroleDaContare)){
        conteggio++;
      }
    }
    System.out.println(conteggio);
  }
}
