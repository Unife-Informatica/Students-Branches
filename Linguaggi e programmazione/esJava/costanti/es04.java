package LP.esJava.costanti;

public class es04 {
    public static final double PI= 3.141592653589793;
    public static double CalcolareArea(double raggio){
        return raggio*raggio*PI;
    }
    public static void main(String[] args) {
        double raggio = 5.0;
        System.out.println("Area del cerchio: "+ CalcolareArea(raggio));

    }
}
