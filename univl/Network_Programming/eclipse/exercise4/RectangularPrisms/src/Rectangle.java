import java.io.Serializable;

public class Rectangle extends Polygon implements Serializable {
    private double a, b;

    public Rectangle() {}

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setA(double value) {
        this.a = value;
    }

    public void setB(double value) {
        this.b = value;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    @Override
    public double getPerimeter() {
        return 2 *(getA() + getB());
    }

    @Override
    public double getArea() {
        return getA() * getB();
    }

    @Override
    public void printName() {
        System.out.println("Name: Rectangle");
    }

    @Override
    public String print() {
        return "Rectangle with sides " + getA() + " and " + getB() + ", has a perimeter L = " + getPerimeter() + " and an area P = " + getArea() + ".";
    }
}