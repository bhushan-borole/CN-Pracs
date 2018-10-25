import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        int filesize = 1022386;
        int bytesRead;
        int currentTot = 0;
        try {
            Socket s = new Socket("192.168.29.165", 15123);
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