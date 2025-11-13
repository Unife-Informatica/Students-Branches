public class Esercizio1 {
  public static void main(String[] args) {
    int numGiorno = 2;
    String nomeGiorno;
    switch (numGiorno) {
      case 1:
        nomeGiorno = "Lunedi";
        break;
      
      case 2:
        nomeGiorno = "Martedi";
        break;

      case 3:
        nomeGiorno = "Mercoledi";
        break;

      case 4:
        nomeGiorno = "Giovedi";
        break;

      case 5:
        nomeGiorno = "Venerdi";
        break;

      case 6:
        nomeGiorno = "Sabato";
        break;

      case 7:
        nomeGiorno = "Domenica";
        break;
    
      default:
        nomeGiorno = "Giorno non valido";
        break;
    }
    System.out.println(nomeGiorno);
  }
}
