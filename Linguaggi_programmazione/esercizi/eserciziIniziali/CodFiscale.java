public class CodFiscale {
  private String nome; 
  private String cognome; 
  private String comune; 
  private String data_nascita;
  private char sesso;


  public CodFiscale(){
    nome = "Gabriele";
    cognome = "Lambertini";
    comune = "Bologna";
    data_nascita = "20/07/2005";
    sesso = 'M';
  }

  public String calcoloCognome(){
    StringBuilder cod = new StringBuilder();
    char[] consonanti = {'b','c','d','f','g','h','m','n','p','q','r','s','t','v','z'};
    char[] vocali = {'a','e','i','o','u'};
    
    for(int i = 0; i < cognome.length(); i++){
      for(int j = 0; j < consonanti.length; j++){
        if(cognome.charAt(i) == consonanti[j]){
          
        }
      }
    }

    return cod;
  }
}
