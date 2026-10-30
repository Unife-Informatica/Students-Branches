import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile {
    private ObjectInputStream input;

    public void openFile(){
        try{
            input = new ObjectInputStream(new FileInputStream("prisms9.ser"));
        }catch(IOException e){
            System.err.println("Error opening file!");
            System.exit(0);
        }
    }

    public void closeFile(){
        try{
            if(input != null){
                input.close();
            }
        }catch(IOException e){
            System.err.println("Error closing file!");
            System.exit(1);
        }
    }

    public void readRectangularPrism(){
        RectangularPrism r;
        int i = 1;
        try{
            while(true){
                r = (RectangularPrism) input.readObject();
                System.out.println((i++) + " " + r.getA() + " " + r.getB() + " " + r.getHeight());
            }
        }catch(EOFException eofe){
            return;
        }catch(ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

}
