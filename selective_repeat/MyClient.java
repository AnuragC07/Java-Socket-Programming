package selective_repeat;

import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class MyClient {
    public static void main(String[] args) throws Exception{
        try{
            int v[] = new int[10];
            int n = 0;
            Random rands = new Random();
            int rand = 0;
            Socket s = new Socket("Localhost", 8011);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());

            int size = din.read();
            System.out.println("Total number of frames = " + size);

            for(int i=0; i<size; i++){
                v[i] = din.read();
                System.out.println(v[i]);
            }

            rand = rands.nextInt(size);
            v[rand] = -1;

            for(int i=0; i<size; i++){
                System.out.println("Received frame = " + v[i]);
            }

            for(int i=0; i<size; i++){
                if(v[i] == -1){
                    System.out.println("request to retransmit frame number = " + (i+1) + " again!");
                    n = i;
                    dout.write(n); // 3. writes the corrupted index
                    dout.flush();
                }
            }

            v[n] = din.read();
            System.out.println("Received frame: " + v[n]);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }    
}
