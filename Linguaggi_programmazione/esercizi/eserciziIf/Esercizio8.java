public class Esercizio8 {
  public static void main(String[] args) {
    char c1 = 'C';
    boolean isvocal = false;
    char vocali[] = {'A','E','I','O','U'};
    for(int i = 0; i < vocali.length; i++){
      if(Character.toLowerCase(c1) == vocali[i]){
        isvocal = true;
      }else{
        isvocal = false;
      }
    }
    if(isvocal){
      System.out.println("La lettera e' una vocale.");
    }else{
      System.out.println("La lettera e' una consonante.");
    }
  }
}
