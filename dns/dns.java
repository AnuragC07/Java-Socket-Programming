package dns;
import java.net.*;
import java.io.*;
import java.util.*;

public class dns {
    public static void main(String[] args) {
        int n;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("\n Menu: \n 1. DNS 2. Reverse DNS 3. Exit \n");
            System.out.println("Enter your choice = ");
            n = Integer.parseInt(System.console().readLine());

            if(n == 1){
                try{
                    System.out.println("Enter Host name = ");
                    String hname = bf.readLine();
                    InetAddress address = InetAddress.getByName(hname);
                    System.out.println("Host name: " + address.getHostName());
                    System.out.println("IP: " + address.getHostAddress());
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            if(n == 2){
                try{
                    System.out.println("Enter IP Address = ");
                    String ipString = bf.readLine();
                    InetAddress address = InetAddress.getByName(ipString);
                    System.out.println("IP: " + ipString);
                    System.out.println("Host name: " + address.getHostName());
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        while (!(n == 3));
    }
}
