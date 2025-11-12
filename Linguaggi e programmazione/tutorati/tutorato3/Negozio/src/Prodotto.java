public class Prodotto {
    String codice;
    String nome;
    int prezzo;
    public Prodotto(String codice,String nome,
    int prezzo){
        this.codice=codice;
        this.nome=nome;
        this.prezzo=prezzo; 
    }
    public String getCodice(){
        return this.codice;
    }
    public String getNome(){
        return this.nome;
    }
    public int prezzo(){
        return this.prezzo;
    }
}
