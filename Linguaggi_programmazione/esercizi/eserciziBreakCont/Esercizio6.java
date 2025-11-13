public class Esercizio6 {
  public static void main(String[] args) {
    String s1 = "ciao come va?";
    for(int i = 0; i < s1.length(); i++){
      if(s1.charAt(i) == 'o'){
        break;
      }
      System.out.println(s1.charAt(i));
    }
  }
}
