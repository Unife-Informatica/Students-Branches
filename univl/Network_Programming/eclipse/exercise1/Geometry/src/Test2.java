public class Test2 {
	public static void main(String[] args) {
		RectangularPrism[] prismArray = new RectangularPrism[8];

        for(int i = 0; i < prismArray.length; i++) {
            double a = (i + 1) * 2.0;    
            double b = (i + 1) * 1.5;
            double height = (i + 1) * 3.0;

            RectangularPrism rp = new RectangularPrism();
            
            rp.setA(a);
            rp.setB(b);
            rp.setHeight(height);
            prismArray[i] = rp;
        }
        
        RectangularPrism result = new RectangularPrism();
        for(int i = 0; i < prismArray.length; i++) {
        	if(result.getVolume() < prismArray[i].getVolume()) {
        		result = prismArray[i];
        	}
        }
        result.print();
	}
}