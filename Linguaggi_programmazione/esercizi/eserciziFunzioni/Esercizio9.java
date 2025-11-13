public class Esercizio9 {
  public static void main(String[] args) {
    int anno = 2024;

    boolean isBisestile = isAnnoBisestile(anno);

    if(isBisestile){
      System.out.println("E' bisestile");
    }else{
      System.out.println("Non è bisestile");
    }
  }

  public static boolean isAnnoBisestile(int anno){
    if((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0){
      return true;
    }else{
      return false;
    }
  }
}
