public abstract class Appello{
    String tipoAppello, docente, corso, data;
    int codiceAppello,orario;
    public Appello(String tipoAppello, int codiceAppello, String docente, String corso, String data,int orario){
        this.tipoAppello=tipoAppello;
        this.codiceAppello=codiceAppello;
        this.docente=docente;
        this.corso=corso;
        this.data=data;
        this.orario=orario;
    }
    public String getTipoAppello(){
        return tipoAppello;
    }
    public int getCodiceAppello(){
        return codiceAppello;
    }
    public String getDocente(){
        return docente;
    }
    public String getCorso(){
        return corso;
    }
    public String getData(){
        return data;
    }
    public int getOrario(){
        return orario;
    }
}