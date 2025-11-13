import java.util.List;

public class ValidatoreInput {
    public static void validaInput(String input, List<Prodotto> prodotti)
        throws FormatoInputNonValidoException, ProdottoNonValidoException {

        if (input == null || !input.contains("-")) {
            throw new FormatoInputNonValidoException("Formato non valido: manca '-'");
        }

        String[] parti = input.split("-");
        if (parti.length != 2) {
            throw new FormatoInputNonValidoException("Formato non valido: usa codice-quantità");
        }

        String codice = parti[0].trim();
        String quantitaStr = parti[1].trim();

        boolean trovato = false;
        for (Prodotto p : prodotti) {
            if (p.getCodice() == Integer.parseInt(codice)) {
                trovato = true;
                break;
            }
        }
        if (!trovato) {
            throw new ProdottoNonValidoException("Codice prodotto inesistente: " + codice);
        }

        try {
            int quantita = Integer.parseInt(quantitaStr);
            if (quantita <= 0) {
                throw new QuantitaNonValidaRuntimeException("Quantità non valida: " + quantita);
            }
        } catch (NumberFormatException e) {
            throw new FormatoInputNonValidoException("Quantità non numerica: " + quantitaStr);
        }
    }

    public static double TrovaPrezzoESomma(String input, List<Prodotto> prodotti){
        String[] parti = input.split("-");
        String codice = parti[0].trim();
        String quantita = parti[1].trim();
        double prezzo = 0.0;
        
        for(Prodotto p : prodotti){
            if(p.getCodice() == Integer.parseInt(codice)){
                prezzo = p.getPrezzo()*Integer.parseInt(quantita);
                break;
            }
        }

        return prezzo;
    }
}

