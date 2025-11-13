public class Esercizio4 {
  public static void main(String[] args) {
    int contatore = 0;
    String s1 = "Ciao come va?";
    char vocali[] = {'a','e','i','o','u'};
    for(char vocStr : s1.toCharArray()){
      for(char vocale : vocali){
        if(vocStr == vocale){
          contatore++;
        }
      }
    }
    System.out.println(contatore);
  }
}
