import java.io.*;
import java.net.*;

public class RemoteJsonTransformer {
    public static void main(String[] args) throws Exception {
        if(args.length > 0){
            InputStream in = null;
            try{
                URI uri = new URI(args[0]);
                URL url = uri.toURL();

                in = url.openStream();
                in = new BufferedInputStream(in);
                Reader r = new InputStreamReader(in);
                int c;

                File f = null;
                if(args.length > 1 && !args[1].isEmpty()){
                    f = new File(args[1]);
                }else{
                    f = new File("output.txt");
                }

                PrintWriter outStream = null;
                try{
                    FileOutputStream outFS = new FileOutputStream(f);
                    outStream = new PrintWriter(outFS);
                }catch(FileNotFoundException e){
                    System.err.println("Error opening the file " + e.getMessage());
                    System.exit(0);
                }

                while((c = r.read()) != -1){
                    outStream.print(Character.toUpperCase((char)c));
                }
                outStream.close();

            }catch(MalformedURLException e){
                System.err.println(args[0] + " is not a parseable URL");
                System.exit(1);
            }
            catch(IOException e) {
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
        } else {
            System.err.println("Usage: java RemoteJsonTransformer <URL> [output_file]");
        }
    }
}
