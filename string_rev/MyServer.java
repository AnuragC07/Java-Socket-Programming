package string_rev;

import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String opString = "", ipString = "";
        while(!opString.equals("stop")){
            opString = din.readUTF();
            StringBuffer stb = new StringBuffer(opString);
            System.out.println("Client says: " + stb.reverse());

            ipString = br.readLine();
            dout.writeUTF(ipString);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
