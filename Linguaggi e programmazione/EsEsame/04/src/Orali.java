public class Orali extends Appello {
    int maxStudenti;
    public Orali(String tipoAppello, int codiceAppello, String docente, String corso, String data,int orario,int maxStudenti){
        super(tipoAppello, codiceAppello, docente, corso,data, orario);
        this.maxStudenti=maxStudenti;
    }
    public int getMaxStudenti(){
        return maxStudenti;
    }
}
