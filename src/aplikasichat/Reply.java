/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasichat;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author agungrbudiman
 */
public class Reply extends Thread {
    private Socket socket;
    
    public Reply(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        try {
            while(true) {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("Reply : "+in.readUTF());  
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
