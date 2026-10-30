import java.io.Serializable;

public class RectangularPrism extends Rectangle implements Serializable {
    private static final long serialVersionUID = 200L;
    private double height;

    public RectangularPrism() {}

    public RectangularPrism(double a, double b, double height) {
        super(a, b);
        this.height = height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double getArea() {
        return 2*(getA()*getB() + getA()*getHeight() + getB()*getHeight());
    }

    public double getVolume() {
        return getA()*getB()*getHeight();
    }

    @Override
    public void printName() {
        System.out.println("Name: Rectangular Prism");
    }

    @Override
    public String print() {
        return "Rectangular prism with a base with sides a = " + getA() + " and b = " + getB() + ", and a height " + getHeight() + ", has an area P = " + getArea() + " and a volume V = " + getVolume() + ".";
    }
}