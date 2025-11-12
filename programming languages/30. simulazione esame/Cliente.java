
import java.util.HashMap;
import java.util.Map;

public class Cliente {

    int codice;
    String nome;
    Map<Integer, Double> servizi = new HashMap<>();

    public Cliente(int codice, String nome, Map<Integer, Double> servizi) {
        this.codice = codice;
        this.nome = nome;
        this.servizi = servizi;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, Double> getServizi() {
        return servizi;
    }

    @Override
    public String toString() {
        Dipendenti listaDipendenti = new Dipendenti("dipendenti.txt");
        double somma = 0.0;
        for(Integer id : servizi.keySet()) {
            somma += listaDipendenti.getCostoDipendente(id) * servizi.get(id);
        }
        return getCodice() + "\t" + getNome() + "\t" + somma;
    }
}
