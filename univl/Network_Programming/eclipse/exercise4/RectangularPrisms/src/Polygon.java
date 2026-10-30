import java.io.Serializable;

public abstract class Polygon implements Serializable {
    public abstract double getPerimeter();

    public abstract double getArea();

    public abstract void printName();

    public abstract String print();
}