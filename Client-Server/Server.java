import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.net.*;
import java.io.*;
public class Server{
    static Socket s;
    static ServerSocket serverSocket;
    public static void main (String [] args ) throws IOException, ScriptException {
        while(true){

            ServerSocket serverSocket = new ServerSocket(15123);
            s = serverSocket.accept();
            System.out.println("Accepted connection : " + s);

            BufferedReader readKb = new BufferedReader(new InputStreamReader(System.in));
            PrintStream writeC = new PrintStream(s.getOutputStream(), true);
            BufferedReader readC = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msgFromC , msgToC;
            while(true){
                if((msgFromC = readC.readLine()) != null )
                    System.out.println("CLient " + "name" + ":" + msgFromC);
                msgToC = readKb.readLine();
                writeC.println(msgToC);
                writeC.flush();
            }


        }


        //s.close();
        //System.out.println("File transfer complete");
    }


}


