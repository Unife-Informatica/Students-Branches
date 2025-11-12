public class Automobile {
    char tipo;
    String nome, produttore;
    double bagagliaio;
    int peso, codice, marce;

    public Automobile() { };

    public Automobile(char tipo, String nome, String produttore, double bagagliaio, int peso, int codice) {
        this.tipo = tipo;
        this.nome = nome;
        this.produttore = produttore;
        this.bagagliaio = bagagliaio;
        this.peso = peso;
        this.codice = codice;
    }

    public Automobile(char tipo, String nome, String produttore, int marce, int peso, int codice) {
        this.tipo = tipo;
        this.nome = nome;
        this.produttore = produttore;
        this.marce = marce;
        this.peso = peso;
        this.codice = codice;
    }

    public char getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getProduttore() {
        return produttore;
    }

    public double getBagagliaio() {
        return bagagliaio;
    }

    public int getPeso() {
        return peso;
    }

    public int getCodice() {
        return codice;
    }

    public int getMarce() {
        return marce;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setBagagliaio(double bagagliaio) {
        this.bagagliaio = bagagliaio;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setMarce(int marce) {
        this.marce = marce;
    }
}
