import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            String str = (String)din.readUTF();
            System.out.println("Message = "+str);
            din.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}