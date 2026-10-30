import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.util.Scanner;

public class UDPServer {
    private static final int ECHOMAX = 1024;
    public static void main(String[] args) {
        int servPort = 4000;
        Scanner keyboard = new Scanner(System.in);

        try(DatagramSocket socket = new DatagramSocket(servPort)) {
            System.out.println("Server is listening on port " + servPort);
            String text;

            while(true) {
                DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
                socket.receive(packet);

                text = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("Client: " + text);

                if(text.equalsIgnoreCase("END")) {
                    break;
                }

                System.out.print("Server: ");
                String response = keyboard.nextLine();
                byte[] bytesToSend = response.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                        bytesToSend, bytesToSend.length,
                        packet.getAddress(), packet.getPort());
                socket.send(sendPacket);

                if(response.equalsIgnoreCase("END")) {
                    break;
                }
            }
            keyboard.close();
        }catch(IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}