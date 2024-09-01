package bothway_socket;

import java.io.*;
import java.net.*;

class MyServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opString = "", ipString = "";
        while(!opString.equals("stop")){
            opString = din.readUTF();
            System.out.println("Client Says = " + opString);

            ipString = br.readLine();
            dout.writeUTF(ipString);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();

    }
}