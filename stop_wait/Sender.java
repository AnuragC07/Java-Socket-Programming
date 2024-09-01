package stop_wait;
import java.net.*;
import java.io.*;
import java.util.*;


public class Sender {
    public static void main(String[] args) throws Exception{
        Sender sws = new Sender();
        sws.run();
    }
    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of frames to be sent: ");
        int n = sc.nextInt();

        Socket s = new Socket("Localhost", 9000);
        PrintStream ps = new PrintStream(s.getOutputStream());

        for(int i=0; i<=n;){
            if(i == n){
                ps.println("exit");
                break;
            }
            System.out.println("Frame number " + i + " is sent");
            ps.println(i);
            BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String ack = bf.readLine();

            if(ack != null){
                System.out.println("Ack received from receiver");
                i++;
                Thread.sleep(4000);
            }
            else{
                ps.println(i);
            }
        }
        sc.close();
    }
}
