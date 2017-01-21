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
public class Client {
    private Scanner scan = new Scanner(System.in);
    
    public void run() {
        try {
            System.out.print("Masukkan ip server : ");
            String ipServer = scan.nextLine();
            Socket client = new Socket("127.0.0.1", 2323);
            
            Reply r = new Reply(client);
            r.start();
            
            System.out.println("Server terhubung || "+client.getRemoteSocketAddress());
            System.out.println("");
            while(true) {
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
