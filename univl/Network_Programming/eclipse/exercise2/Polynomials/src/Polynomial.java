public class Polynomial { // Name of the class
	final static int MAX_DEGREE = 15; // Limit of Polynomial's degree
	private double[] coeff; // Coefficients Array
	private int degree; // Degree of the Polynomial
	
	public Polynomial(int degree) { // Constructor
		if(degree > 15 || degree < 0) {
			throw new IllegalArgumentException("Degree must be 15 or less"); // If degree > 15 -> Exception
		}
		this.degree = degree; // Assign degree passed by argument to the Polynomial
		this.coeff = new double[this.degree+1];
	}
	
	/*
	 * Method that copies all the array values passed by argument 
	 * into the Polynomial's array
	 * */
	public void copyCoefficients(double[] coeff) {
		if(this.coeff.length != this.coeff.length) {
			throw new IllegalArgumentException("Coefficient must be" + degree + 1);
		}
		for(int i = 0; i < coeff.length; i++) {
			this.coeff[i] = coeff[i];
		}
	}
	
	public void setCoefficient(double value, int i) {
		this.coeff[i] = value;
	}
	
	public double getCoefficient(int i) {
		return this.coeff[i];
	}
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public int getDegree() {
		return this.degree;
	}
	
	/*
	 *Method for printing the Polynomial in a suitable form */
	public void printPolynomial() {
		int tmpDegree = degree;
		for (int i = 0; i < this.coeff.length; i++) {
			if (this.coeff[i] >= 0) {
				System.out.print("+ " + this.coeff[i] + "X^" + tmpDegree + " ");
				tmpDegree--;
			} else {
				System.out.print(this.coeff[i] + "X^" + tmpDegree + " ");
				tmpDegree--;
			}
		}
		System.out.println(" ");
	}
	
	/*
	 * Method that calculates the value of the
	 * Polynomial for a given value of x*/
	public double evaluate(double x) {
		int tmpDegree = this.degree;
		double result = 0;
		for(int i = 0; i < this.coeff.length; i++) {
			if(tmpDegree > 0) {
				result += this.coeff[i]*(Math.pow(x, tmpDegree));
			}else {
				result += this.coeff[i];
			}
			tmpDegree--;
		}
		return result;
	}
	
	/*
	 * Method for calculating the sum of two Polynomials*/
	public Polynomial sum(Polynomial p) {
		int maxDegree = (this.degree > p.getDegree()) ? this.degree : p.getDegree();
		int minDegree = (this.degree < p.getDegree()) ? this.degree : p.getDegree();
		
		Polynomial result = new Polynomial(maxDegree);
		
		double[] res = new double[maxDegree + 1];
		
		// p1 > p2
		if (this.degree >= p.getDegree()) {
			while(minDegree >= 0) {
				res[maxDegree] = this.coeff[maxDegree] + p.getCoefficient(minDegree);
				minDegree--;
				maxDegree--;
			}
			for (int i = maxDegree; i >= 0; i--) {
				res[maxDegree] = this.coeff[maxDegree];
			}
			
		} else { // p2 > p1
			while(minDegree >= 0) {
				res[maxDegree] = p.getCoefficient(maxDegree) + this.coeff[minDegree];
				minDegree--;
				maxDegree--;
			}
			for (int i = maxDegree; i >= 0; i--) {
				res[maxDegree] = p.getCoefficient(maxDegree);
			}
			
		}
		
		result.copyCoefficients(res);
		return result;
	}
}