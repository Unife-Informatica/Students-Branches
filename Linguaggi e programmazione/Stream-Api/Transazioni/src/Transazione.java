
import java.time.LocalDate;

public class Transazione{
    private String tipo;
    private double importo;
    private LocalDate data;
    public Transazione(LocalDate data,double importo ,String tipo) {
        this.tipo = tipo;
        this.importo = importo;
        this.data = data;
    }
    public String getTipo() {
        return tipo;
    }
    public double getImporto() {
        return importo;
    }
    public LocalDate getData() {
        return data;
    }
    @Override
    public String toString(){
        return data + " , " + importo + " , " + tipo +"\n";
    }
}