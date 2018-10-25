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
                // The below three lines are used for maths purposes, client will provide the equation
                //   and server will solve the equation and return the result
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine a = scriptEngineManager.getEngineByName("js");
                String sum = a.eval(msgFromC).toString();
		
                writeC.println(sum);
                writeC.flush();
            }


        }


        //s.close();
        //System.out.println("File transfer complete");
    }


}


