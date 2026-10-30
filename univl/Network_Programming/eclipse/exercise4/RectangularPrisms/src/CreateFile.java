import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateFile {
    private ObjectOutputStream output;

    public void openFile(){
        try{
            output = new ObjectOutputStream(new FileOutputStream("prisms9.ser"));
        }catch(IOException e){
            System.err.println("Error opening file!");
            System.exit(0);
        }
    }

    public void closeFile(){
        try{
            if(output != null){
                output.close();
            }
        }catch(IOException e){
            System.err.println("Error closing file!");
            System.exit(1);
        }
    }

    public void addRectangularPrism(RectangularPrism x){
        try{
            output.writeObject(x);
        }catch(IOException e){
            System.err.println("Error writing to file!");
            System.exit(2);
        }
    }
}
