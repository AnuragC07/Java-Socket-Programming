package stop_wait;

import java.net.*;
import java.io.*;

public class Receiver {
    public static void main(String[] args) throws Exception{
        Receiver swr = new Receiver();
        swr.run();
    }

    public void run() throws Exception{
        String temp = "any message", str = "exit";
        ServerSocket ss = new ServerSocket(9000);
        Socket s = ss.accept();
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());

        while(temp.compareTo(str) != 0){
            Thread.sleep(1000);
            temp = bf.readLine();
            if(temp.compareTo(str) == 0) break;
            System.out.println("Frame " + temp + " was received");
            Thread.sleep(500);
            ps.println("Received");
        }
        System.out.println("All frames were received successfully");
        s.close();
        ss.close();
    }
}
