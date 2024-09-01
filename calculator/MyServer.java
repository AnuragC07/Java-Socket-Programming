package calculator;

import java.net.*;
import java.io.*;

public class MyServer {
    public static void main(String[] args) throws Exception{
       ServerSocket ss = new ServerSocket(3333);
       
       while(true){
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        String str = din.readUTF();
        String res = calculate(str);
        System.out.println("Calculated result: " + res); 
        dout.writeUTF(res);
        dout.flush();

        din.close();
        dout.close();
        s.close();
       }
    }
    private static String calculate(String input){
        try {
            String[] parts = input.split(" ");
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if(num2 == 0){
                        return "Error division by 0";
                    }
                    result = num1 / num2;
                    break;
                default:
                    return "Error: Invalid operator";
            }
            return "Result: " + result;
        }
        catch (Exception e){
            return "Error: Invalid input format";
        }
    }
}