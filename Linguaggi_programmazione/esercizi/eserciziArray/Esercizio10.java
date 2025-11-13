public class Esercizio10 {
  public static void main(String[] args) {
    String[] parole = {"casa", "cane", "gatto", "auto", "albero"};
    String parolaDaCercare = "gatto";
    int posizione = -1;
    for(int i = 0; i < parole.length; i++){
      if(parole[i].equals(parolaDaCercare)){
        posizione = i;
        break;
      }
    }
    System.out.println(posizione);
  }
}
