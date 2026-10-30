import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Usage: java TCPClient <hostname> <port>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        try(Socket socket = new Socket(hostname, port)){
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Connected to the server. Type END to quit.");

            String serverMessage;
            while ((serverMessage = reader.readLine()) != null) {
                System.out.println(serverMessage);

                if (serverMessage.contains(":") || serverMessage.contains("Result")) {
                    if (!serverMessage.startsWith("Result")) {
                        String userInput = keyboard.nextLine();
                        writer.println(userInput);

                        if (userInput.equalsIgnoreCase("END")) {
                            break;
                        }
                    }
                }
            }
        } catch(UnknownHostException e){
            System.out.println("Server not found: " + e.getMessage());
        } catch(IOException e){
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}