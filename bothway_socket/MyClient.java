package bothway_socket;

import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost",3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String opString = "", ipString = "";
        while(!opString.equals("stop")){
            opString = br.readLine();
            dout.writeUTF(opString);
            dout.flush();

            ipString = din.readUTF();
            System.out.println("Server says: " + ipString);
        }
        dout.close();
        s.close();
    }
}