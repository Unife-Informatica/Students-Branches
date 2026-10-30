import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        if ((args.length < 1) || (args.length > 2)) {
            throw new IllegalArgumentException("Parameters: <Server> [<Port>]");
        }
        InetAddress serverAddress = InetAddress.getByName(args[0]);
        int servPort = (args.length == 2) ? Integer.parseInt(args[1]) : 4000;
        Scanner keyboard = new Scanner(System.in);
        String text;
        try(DatagramSocket socket = new DatagramSocket()) {
            do{
                System.out.print("Client: ");
                text = keyboard.nextLine();
                byte[] bytesToSend = text.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(bytesToSend,
                        bytesToSend.length, serverAddress, servPort);

                socket.send(sendPacket);
                if(text.equalsIgnoreCase("END")) {
                    break;
                }

                DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                socket.receive(receivePacket);

                String serverMsg = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                System.out.println("Server: " + serverMsg);

                if(serverMsg.equalsIgnoreCase("END")) {
                    break;
                }
            }while(!text.equalsIgnoreCase("END"));
            keyboard.close();
        }catch(IOException ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
}