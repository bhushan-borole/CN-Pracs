

import java.io.*;
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

            StringBuilder sb = new StringBuilder(s);

            dataOutputStream.writeUTF(String.valueOf(sb.reverse()));

        }

    }
}
