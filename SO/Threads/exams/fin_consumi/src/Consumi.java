public class Consumi{
    private float valore=0;
    public synchronized float getConsumi(){
        return valore;
    }
    public synchronized void setConsumi(float valore){
        this.valore = valore;
    }
}