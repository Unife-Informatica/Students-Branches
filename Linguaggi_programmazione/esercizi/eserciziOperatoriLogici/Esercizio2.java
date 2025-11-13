public class Esercizio2 {
  public static void main(String[] args) {
    int anno = 2024;
    if((anno%4 == 0 && anno%100 != 0) || anno%400 == 0){
      System.out.println("E' bisestile.");
    }else{
      System.out.println("Non e' bisestile.");
    }
  }
}
