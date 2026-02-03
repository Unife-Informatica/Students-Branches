public class Consumi{
    private float carburante=0.0F;

    public synchronized float getCarburante(){
        return carburante;
    }
    public synchronized void setCarburante(float carburante){
        this.carburante=carburante;
    }

}
