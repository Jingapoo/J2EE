package testSocket;

/**
 * Setting up single connection between server, port 8888, start with server, can only type single word, if have space between words, it only recognize first word...
 * Server side only accepts data from client side, client side sending data...One way communication...
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){

        try{
            //Open server port 8888
            ServerSocket ss = new ServerSocket(8888);

            //Listening port 8888
            System.out.println("Listening port number: 8888");
            Socket s = ss.accept();

//            //System.out.println("There is a connection" + s);
//            InputStream is = s.getInputStream();
//            //Read client data
//            int msg = is.read();
//            System.out.println(msg);
//            is.close();

            InputStream is = s.getInputStream();
            //Encapsulate input stream into Data input stream
            DataInputStream dis = new DataInputStream(is);
            //Using readUTF read String
            String msg = dis.readUTF();
            System.out.println(msg);
            dis.close();


            s.close();
            ss.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
