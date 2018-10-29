

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 15123;
    public static void main (String [] args ) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        while(true){
            String s = dataInputStream.readUTF();
            int option = dataInputStream.readInt();


            switch(option){
                case 1: dataOutputStream.writeUTF(s.toUpperCase());
                        break;
                case 2: dataOutputStream.writeUTF(s.toLowerCase());
                        break;
            }

        }

    }
}
