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
            Socket client = new Socket(ipServer, 2323);
            System.out.println("Server terhubung || "+client.getRemoteSocketAddress());
            while(true) {
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                System.out.print("Chat : ");
                out.writeUTF(scan.nextLine());
                DataInputStream in = new DataInputStream(client.getInputStream());
                System.out.println("Server : "+in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
