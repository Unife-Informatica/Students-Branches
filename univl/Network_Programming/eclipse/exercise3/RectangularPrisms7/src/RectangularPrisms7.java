import java.io.*;

public class RectangularPrisms7 {
	public static void main(String[] args) throws IOException {
		File prisms = new File("RectangularPrisms7.txt");
		FileOutputStream outFS = null;
		
		try {
			outFS = new FileOutputStream(prisms);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + prisms.getName() + " " + e.getMessage());
			System.exit(0);
		}
		PrintWriter outStream = new PrintWriter(outFS);

        for(int i = 0; i < 7; i++) {
            double a = (i + 1) * 2.0;    
            double b = (i + 1) * 1.5;
            double height = (i + 1) * 3.0;

            RectangularPrism rp = new RectangularPrism();
            
            rp.setA(a);
            rp.setB(b);
            rp.setHeight(height);

            outStream.println(rp.print());
        }
		outStream.close();
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(prisms);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + prisms.getName() + " " + e.getMessage());
			System.exit(1);
		}
		BufferedReader buffR = new BufferedReader(fr);
		
		String line = buffR.readLine();
		while(line != null) {
			System.out.println(line);
			line = buffR.readLine();
		}
		buffR.close();
	}
}