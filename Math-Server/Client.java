import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static int PORT = 15123;
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.137.1", PORT);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter expression: ");
            String input = sc.nextLine();

            dataOutputStream.writeUTF(input);
            dataOutputStream.flush();
	    
            if(input.equals("quit")){
                System.out.println("You exited the program");
                break;
            }

            String messageFromServer = dataInputStream.readUTF();
            System.out.println("Solution: " + messageFromServer);
        }

    }
}
