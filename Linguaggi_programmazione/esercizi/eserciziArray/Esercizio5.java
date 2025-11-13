public class Esercizio5 {
  public static void main(String[] args) {
    String[] parole = {"casa", "cane", "gatto", "casa", "casa"};
    String parolaDaContare = "casa";
    int cont = 0;
    for(String parola : parole){
      if(parolaDaContare == parola){
        cont++;
      }
    }
    System.out.println(cont);
  }
}
