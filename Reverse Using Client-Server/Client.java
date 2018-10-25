import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        int filesize = 1022386;
        int bytesRead;
        int currentTot = 0;
        try {
            Socket s = new Socket(local_ipv4_address_here, 15123); // run ipconfig in cmd, and search for ipv4 address in local area connection.
            BufferedReader readKb = new BufferedReader(new InputStreamReader(System.in));
            PrintStream writeS = new PrintStream(s.getOutputStream(), true);
            BufferedReader readS = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println("You may begin chatting :\n");
            String msgFromS, msgToS;
            while (true) {
                msgToS = readKb.readLine();
                writeS.println(msgToS);
                //writeS.flush();
                if ((msgFromS = readS.readLine()) != null) {
                    System.out.print("\nServer : " + msgFromS + "\n\nYou : ");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}