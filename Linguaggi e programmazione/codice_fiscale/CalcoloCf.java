package LP.codice_fiscale;

public class CalcoloCf {
    private String nome;
    private String cognome; 
    private String comune;
    private String data_di_nascita;
    private char sesso;
    public CalcoloCf(){
        nome = "Dario";
        cognome = "Briguglio";
        comune = "Ferrara";
        data_di_nascita = "20/02/2004";
        sesso = 'M';
    }
    public String calcoloCognome(){
        StringBuilder cod = new StringBuilder();
        char[] consonanti={'b','c','d','f','g','h','l','m','n','p','q','r','s','t','v','z'};
        char[] vocali={'a','e','i','o','u'};
        for(int i=0;i<cognome.length();i++){
            for(int j=0;i<consonanti.length;j++){
                if(cognome.charAt(i)==consonanti[j]){
                    cod.append(consonanti[j]);
                }
            }
        }
        return cod.toString();
    }
    public String calcoloNome(){
        String codNome;

        return codNome;
    }
    
}
