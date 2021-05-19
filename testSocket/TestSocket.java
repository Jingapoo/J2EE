package testSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Getting the local host IP address, and ping this IP
 */
public class TestSocket {

    public static void main(String[] args) throws UnknownHostException, IOException{
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        /* 172.20.10.0 - 172.20.10.255 */
        System.out.println("The Host Computer IP address: " + ip);

        /* This is when to ping the IP see if we can reach this address */
        Process p = Runtime.getRuntime().exec("ping " + ip);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            if(line.length() != 0){
                sb.append(line + "\r\n");
            }
        }
        System.out.println("The return message is: ");
        System.out.println(sb.toString());
    }

}
