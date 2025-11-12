
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Socio {

    int codice;
    String nome;
    int eta, categoria;
    List<Prenotazione> listaPrenotazioni = new ArrayList<>();

    public Socio(int codice, String nome, int eta, int categoria, List<Prenotazione> listaPrenotazioni) {
        this.codice = codice;
        this.nome = nome;
        this.eta = eta;
        this.categoria = categoria;
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public int getCategoria() {
        return categoria;
    }

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    @Override
    public String toString() {
        return getCodice() + "\t" + getNome() + "\t" + getEta() + "\t" + getCategoria() + "\t" + getListaPrenotazioni();
    }
}
