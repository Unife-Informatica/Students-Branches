
import java.time.LocalDate;

class Transazione{
    private LocalDate data;
    private String tipo;
    private double importo;
    public Transazione(LocalDate data, double importo, String tipo){
        this.data=data;
        this.importo=importo;
        this.tipo=tipo;
    }
    public LocalDate getData() {
        return data;
    }
    public String getTipo() {
        return tipo;
    }
    public double getImporto() {
        return importo;
    }
    @Override
    public String toString() {
        return "Transazione [data=" + data + ", tipo=" + tipo + ", importo=" + importo + "]";
    }
    
}