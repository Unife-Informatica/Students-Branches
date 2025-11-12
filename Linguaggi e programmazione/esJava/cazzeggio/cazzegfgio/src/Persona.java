interface PersonaConst {
    final String CONSONANTI = "bcdfghjklmnpqrstvwxyz",
                 VOCALI = "aeiou";
}

public class Persona implements PersonaConst{
    private String nome, cognome, dataNascita, comuneNascita, cf;
    private char sesso;


    public Persona() {}; 
    public Persona(String nome, String cognome, String dataNascita, String comuneNascita, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.comuneNascita = comuneNascita;
        this.sesso = sesso;
        this.cf = codeCognome(this.cognome);
    }

    public String getCF() { return this.cf; }

    private String codeCognome(String cognome) {
        String code = "";
        if(cognome.length() < 0) {
            throw new IllegalArgumentException("Error: valori insufficienti");
        }

        if(cognome.length() == 1) {
            code = cognome + "XX";
            return code.toUpperCase();
        } 
        
        if (cognome.length() == 2) {
            code = cognome + "X";
            return code.toUpperCase();
        }

        // se consonanti < 3 allora add consonanti
        for (int i = 0; i < cognome.length(); i++) {
            for (int j = 0; j < CONSONANTI.length(); j++) {
                if(cognome.toLowerCase().charAt(i) == CONSONANTI.charAt(j)) {
                    code = code + CONSONANTI.charAt(j);
                    if (code.length() == 3) {
                        return code;
                    }
                }
            }
        }


        for (int i = 0; i < cognome.length(); i++) {
            for (int j = 0; j < VOCALI.length(); j++) {
                if(cognome.toLowerCase().charAt(i) == VOCALI.charAt(j)) {
                    code = code + VOCALI.charAt(j);
                    if (code.length() == 3) {
                        return code;
                    }
                }
            }
        }
        return "";
    }
}
