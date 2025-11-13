import java.util.List;

public class CartaBrano {
  //CartaPrepagata carta;

  /*public CartaBrano(String sceltaCarta, List<CartaPrepagata> listaCarte){
    for(CartaPrepagata c : listaCarte){
      if(c.getCodice().equals(sceltaCarta)){
        this.carta = c;
      }
    }
  }*/

  public void attivaCarta(String sceltaCarta, List<CartaPrepagata> listaCarte) throws AttivazioneCartaException{
    for(CartaPrepagata c : listaCarte){
      if(c.getCodice().equals(sceltaCarta)){
        if(c.getStato() == true){
          throw new AttivazioneCartaException("Non è possibile attivare la carta perchè già attiva!");
        }else{
          c.setStato(true);
        }
      }
    }
  }

  public void acquistoBrani(String sceltaCarta, List<CartaPrepagata> listaCarte) throws AcquistoBraniException{
    for(CartaPrepagata c : listaCarte){
      if(c.getCodice().equals(sceltaCarta)){
        if(c.getStato() == false){
          throw new AcquistoBraniException("Non è possibile acquistare brani perchè la carta è disattivata!");
        }else{
          if(c.getNBraniDisp() == 0){
            throw new AcquistoBraniException("Non è possibile acquistare brani perchè il numero di brani disponibili è insuff.");
          }else{
            c.acquistaBrano();
          }
        }
      }
    }
  }

  public void ricaricaCarta(String sceltaCarta, List<CartaPrepagata> listaCarte) throws RicaricaBranoException{
    for(CartaPrepagata c : listaCarte){
      if(c.getCodice().equals(sceltaCarta)){
        if(c.getStato() == false){
          throw new RicaricaBranoException("Non è possibile ricaricare la carta perchè non è attiva!");
        }else{
          c.setNBraniDisp();
        }
      }
    }
  }
}
