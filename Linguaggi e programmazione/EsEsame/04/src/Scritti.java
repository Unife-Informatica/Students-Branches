public class Scritti extends Appello {
    String aula;
    int durata;
    public Scritti(String tipoAppello, int codiceAppello, String docente, String corso, String data,int orario,String aula,int durata){
        super(tipoAppello, codiceAppello, docente, corso, data, orario);
        this.aula=aula;
        this.durata=durata;
    }
    public String getAula(){
        return aula;
    }
    public int getDurata(){
        return durata;
    }
}
