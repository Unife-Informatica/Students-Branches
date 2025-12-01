public class Conto {
    private int saldo;

    public Conto() {
        this(0);
    }

    public Conto(int ammontare) {
        ingresso(ammontare);
    }

    public void ingresso(int ammontare) {
        saldo += ammontare;
    }

    public void uscita (int ammontare) {
        saldo-=ammontare;
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + saldo;
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
        Conto other = (Conto) obj;
        if (saldo != other.saldo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Conto [saldo=" + saldo + "]";
    }
    
}
