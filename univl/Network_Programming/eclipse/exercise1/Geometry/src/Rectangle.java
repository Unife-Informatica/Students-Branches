public class Rectangle extends Polygon{
	private double a, b;
	
	public Rectangle() {}
	
	public Rectangle(double a, double b) {
		this.a = 1;
		this.b = 1;
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
		return getA() + getB();
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
	public void print() {
		System.out.println("Rectangle with sides " + getA() + " and " + getB() + ", has a perimeter L = " + getPerimeter() + " and an area P = " + getArea() + ".");
	}
}