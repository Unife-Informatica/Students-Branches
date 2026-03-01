public class VerificaInput {
    public int sospette = 0;
    public synchronized void incrementaStringheSospette(){
        this.sospette++;
    }
    public synchronized int getNumeroStringheSospette(){
        return sospette;
    }

}
