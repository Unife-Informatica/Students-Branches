public class Consumi {

    private float val;

    public synchronized void setVal(float val) {
        this.val = val;
    }

    public synchronized float getVal() {
        return val;
    }
}
