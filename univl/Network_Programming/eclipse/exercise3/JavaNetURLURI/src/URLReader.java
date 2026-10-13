import java.io.*;
import java.net.*;

public class URLReader {
    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            InputStream in = null;
            try{
                URI uri = URI.create(args[0]);
                URL u = uri.toURL();

                in = u.openStream(); //Open the URL for reading
                in = new BufferedInputStream(in); //Buffer the input to increase performance
                Reader r = new InputStreamReader(in); //Chain the InputStream to a Reader
                int c;

                File dat = new File("output.txt");
                PrintWriter outStream = null;
                try{
                    FileOutputStream outFS = new FileOutputStream(dat);
                    outStream = new PrintWriter(outFS);
                }catch(FileNotFoundException e){
                    System.out.println("Error opening the file" + e.getMessage());
                    System.exit(0);
                }
                while((c = r.read()) != -1){
                    outStream.print((char)c);
                }
                outStream.close();

            }catch(MalformedURLException e){
                System.err.println(args[0] + "is not a parseable URL");
                System.exit(1);
            }catch(IOException e){
                System.err.println(e.getMessage());
                System.exit(2);
            }finally {
                if(in != null){
                    try{
                        in.close();
                    }catch(IOException e){
                        System.err.println(e.getMessage());
                        System.exit(3);
                    }
                }
            }
        }
    }
}
