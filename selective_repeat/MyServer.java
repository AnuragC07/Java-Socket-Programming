package selective_repeat;
import java.io.*;
import java.net.*;
public class MyServer {
    public static void main(String[] args) throws Exception{
        try{
            int a[] = {30, 40, 50, 60, 70, 80, 90, 100};
            ServerSocket ss = new ServerSocket(8011);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            System.out.println("The number of packets sent is: " + a.length);
            int size = a.length;
            dout.write(size);
            dout.flush();

            for(int i=0; i<size; i++){
                dout.write(a[i]);
                dout.flush();
            }

            int index = din.read();
            dout.write(a[index]);
            dout.flush();

            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
