public class Autore{
    private String nome,genere;

    public Autore(String nome, String genere) {
        this.nome = nome;
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((genere == null) ? 0 : genere.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autore other = (Autore) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (genere == null) {
            if (other.genere != null)
                return false;
        } else if (!genere.equals(other.genere))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return " [Nome=" + nome + ", Genere=" + genere + "]";
    }

    

    
}