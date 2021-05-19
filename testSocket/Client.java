package testSocket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args){

        try{
            //Connect to local host 8888 port
            Socket s = new Socket("127.0.0.1", 8888);
            //System.out.println(s);
//            OutputStream os = s.getOutputStream();
//
//            //sending 110 to Server side
//            os.write(110);
//            os.close();

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            System.out.println("Client is typing....");

            Scanner sc = new Scanner(System.in);

            String str = sc.next();
            dos.writeUTF(str);

//            dos.writeUTF("Legendary!");  // hardcode
            dos.close();


            s.close();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
