import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static int PORT = 15123;
    public static void main(String[] args) throws IOException {
        
	Socket s = new Socket("192.168.137.1", PORT); // run ipconfig in cmd, and search for ipv4 address in local area connection.
        System.out.println("You may begin chatting:");
        
	DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
        
	Scanner scanner = new Scanner(System.in);
        
	try {
            while(true){
                System.out.println("Enter Message: ");
                String input = scanner.nextLine();


                dataOutputStream.writeUTF(input);

                dataOutputStream.flush();

                if(input.equals("quit")){
                    System.out.println("You exited the program");
                    break;
                }

                String messageFromServer = dataInputStream.readUTF();
                System.out.println("Server: " + messageFromServer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
