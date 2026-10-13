public class TestPolynomial {
	public static void main(String[] args) {
		double[] coeff1 = {10, -6, 7, 5};
		double[] coeff2 = {3, 2, 1};
		
		Polynomial p1 = new Polynomial(3);
		Polynomial p2 = new Polynomial(2);
		
		System.out.println("Printing p1: ");
		p1.copyCoefficients(coeff1);
		p1.printPolynomial();
		
		System.out.println("Printing p2: ");
		p2.copyCoefficients(coeff2);
		p2.printPolynomial();
		
		System.out.println("Printing p1 + p2: ");
		Polynomial p3 = p1.sum(p2);
		p3.sum(p3);
		p3.printPolynomial();
		
		System.out.println("Printing p1 evaluate: ");
		double evaluate = p1.evaluate(2);
		System.out.println("Evaluate: " + evaluate);

	}
}