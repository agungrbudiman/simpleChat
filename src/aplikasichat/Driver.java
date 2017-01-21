/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasichat;

import java.util.Scanner;

/**
 *
 * @author agungrbudiman
 */
public class Driver {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1. Sebagai Server");
        System.out.println("2. Sebagai Client");
        System.out.print("Pilihan anda : ");
        int pil = scan.nextInt();
        
        switch(pil) {
            case 1 :
                Server s = new Server();
                s.run();
                break;
            case 2 :
                Client c = new Client();
                c.run();
                break;
        }
    }
}
