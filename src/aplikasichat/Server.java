/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasichat;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author agungrbudiman
 */
public class Server {
    private ServerSocket serverSocket;
    private Scanner scan;
    
    public Server() {
        try {
            serverSocket = new ServerSocket(2323);
            serverSocket.setSoTimeout(50000);
            scan = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            System.out.println("Menunggu client....");
            Socket server = serverSocket.accept();
            
            Reply r = new Reply(server);
            r.start();
            
            System.out.println("Client terhubung || "+server.getRemoteSocketAddress());
            System.out.println("");
            while(true) {
               DataOutputStream out = new DataOutputStream(server.getOutputStream());
               out.writeUTF(scan.nextLine());  
            }
            
        }catch (SocketTimeoutException s) {
           System.out.println("Socket timeout");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
