
import java.time.LocalDate;

public class Noleggio {
    private String codNoleggio;
    private Cliente cliente;
    private Auto auto;
    private LocalDate data;
    public Noleggio(String codNoleggio, Cliente cliente, Auto auto,LocalDate data){
        this.codNoleggio=codNoleggio;
        this.cliente=cliente;
        this.auto=auto;
        this.data=data;
    }
    public void pagamento(int oreNoleggiate)throws SaldoInsufficiente, AutoGiaNoleggiata{
            auto.isNoleggiata();
            Pagamento metodo = cliente.getMetodoPagamento();
            double prezzo=oreNoleggiate*auto.getPrezzoOrario();
            if(prezzo>metodo.getSoldi()){
                throw new SaldoInsufficiente("Il saldo non e' sufficiente");
            }
            metodo.scalaSoldi(prezzo);
            System.out.println("Orario di noleggio: "+data);
            System.out.println(" Pagamento di: "+ prezzo+"$");
        }
    @Override
    public String toString(){
        return " Per auto: "+ auto.getModello()+" "+auto.getMarca()+" "+auto.getTarga()+"\n Soldi rimasti: "+cliente.getMetodoPagamento().getSoldi();
    }
}
