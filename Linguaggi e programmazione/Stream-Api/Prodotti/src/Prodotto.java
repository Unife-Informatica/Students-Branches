public class Prodotto {
    private String nome, categoria;
    private double prezzo;
    public Prodotto(String nome, String categoria, double prezzo) {
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }
    public String getNome() {
        return nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getPrezzo() {
        return prezzo;
    }
    @Override
    public String toString(){
        return nome +" "+prezzo+" "+categoria;
    }
}
