import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        if(args.length < 1) return;
        int port = Integer.parseInt(args[0]);
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is listening on port " + port);
            while(true){
                Socket socket = serverSocket.accept();
                SocketAddress clientAddress = socket.getRemoteSocketAddress();
                System.out.println("Handling client at " + clientAddress);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                String text;
                do{
                  //First number
                  writer.println("Server: Insert the first number: ");
                  text = reader.readLine();
                  int x = Integer.parseInt(text);

                  //Second number
                  writer.println("Server: Insert the second number: ");
                  text = reader.readLine();
                  int y = Integer.parseInt(text);


                  writer.println("Server: Insert(1, 2, 3 or 4) or (+, -, *, /): ");
                  text = reader.readLine();
                  String s = (String)text;

                  switch(s) {
                      case "1", "+":
                          writer.println("Result x + y = " + (x+y));
                          break;
                        case "2", "-":
                            writer.println("Result x - y = " + (x-y));
                            break;
                        case "3", "*":
                            writer.println("Result x * y = " + (x*y));
                            break;
                        case "4", "/":
                            writer.println("Result x / y = " + (x/y));
                            break;
                        default:
                            writer.println("Wrong choice! Choose again");
                  }
                }while(!text.equals("END"));
                socket.close();
            }
        }catch(IOException e){
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }

    }
}
