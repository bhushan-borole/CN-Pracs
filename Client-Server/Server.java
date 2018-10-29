import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static final int PORT = 15123;
    public static void main (String [] args ) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        while(true){
            String messageFromClient = dataInputStream.readUTF();
            System.out.println("Client: " + messageFromClient);

            System.out.println("Enter Message: ");
            String s = scanner.nextLine();

            dataOutputStream.writeUTF(s);

            dataOutputStream.flush();

        }

    }
}
