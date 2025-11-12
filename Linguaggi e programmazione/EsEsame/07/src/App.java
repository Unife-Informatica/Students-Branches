import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Cliente> listaCliente=new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("clienti.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String[] split = riga.split(" ");
                switch(split[0]){
                    case "privato"->{
                        String tipoCliente=split[0];
                        int codiceCliente=Integer.parseInt(split[1]);
                        String indirizzo = bf.readLine();
                        String data=bf.readLine();
                        String nome = bf.readLine();
                        List<Premio> listaPremi=new ArrayList<>();
                        while((riga=bf.readLine())!=null&&!riga.trim().isEmpty()){
                            int premio = Integer.parseInt(riga);
                            listaPremi.add(new Premio(premio));
                        }
                        listaCliente.add(new Privato(tipoCliente, codiceCliente, indirizzo, data, nome, listaPremi));
                    }
                    case "azienda"->{
                        String tipoCliente=split[0];
                        int codiceCliente=Integer.parseInt(split[1]);
                        String indirizzo = bf.readLine();
                        String data=bf.readLine();
                        String ragioneSociale = bf.readLine();
                        int fatturato = Integer.parseInt(bf.readLine());
                        List<Premio> listaPremi=new ArrayList<>();
                        while((riga=bf.readLine())!=null&&!riga.trim().isEmpty()){
                            int premio = Integer.parseInt(riga);
                            listaPremi.add(new Premio(premio));
                        }
                        listaCliente.add(new Azienda(tipoCliente, codiceCliente, indirizzo, data, ragioneSociale, fatturato, listaPremi));
                    }
                    default->{
                        System.out.println("Tipo di cliente non trovato");
                    }
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
            throw new Exception("Impossibile aprire il file");
        }
        System.out.println("---------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Tipo","Codice","Nome","ragioneSociale","indirizzo","data","fatturato");
        for(Cliente c:listaCliente){
            int maxLen=20;
            switch(c){
                case Privato p->{
                    System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20s %-20s%n",
                        troncate(p.getTipoCliente(), maxLen),
                        p.getCodiceCliente(),
                        troncate(p.getNome(), maxLen),
                        "-",
                        troncate(p.getIndirizzo(), maxLen),
                        troncate(p.getIndirizzo(), maxLen),
                        "-"
                    );
                }
                case Azienda a->{
                        System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20s %-20s%n",
                            troncate(a.getTipoCliente(), maxLen),
                            a.getCodiceCliente(),
                            "-",
                            troncate(a.getRagioneSociale(),maxLen),
                            troncate(a.getIndirizzo(), maxLen),
                            troncate(a.getIndirizzo(), maxLen),
                            a.getFatturato()
                        );
                }
                default->{/*non utilizzato*/}
            }
        }
    }
    public static String troncate(String s, int maxLen){
        if(s==null) return "-";
        return (s.length()>maxLen)?s.substring(0,maxLen+1)+"...":s;
    }
}

