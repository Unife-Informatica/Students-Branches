public class Test {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		RectangularPrism rp = new RectangularPrism();
		
		r.setA(5.0);
		r.setB(10.0);
		r.print();
		
		rp.setA(5.0);
		rp.setB(10.0);
		rp.setHeight(8.0);
		rp.print();
	}
}