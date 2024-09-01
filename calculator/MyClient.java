package calculator;

import java.net.*;
import java.io.*;

public class MyClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        str = br.readLine();
        dout.writeUTF(str);
        dout.flush();
        dout.close();
        s.close();
    }
}