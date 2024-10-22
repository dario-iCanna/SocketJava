package com.example;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Socket s = new Socket("localhost",3000);
        BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        boolean connessione = true;
        while(connessione){
            
            Scanner input = new Scanner(System.in);
            String parola;
            do{
                System.out.println("inserisci comando: 1.Maiuscolo, 2.Minuscolo, 3.Ribaltare, 4.Contare Caratteri, 0.Uscire");
                parola = input.next();
            }while(!parola.equals("1") &&!parola.equals("2")&&!parola.equals("3")&&!parola.equals("4")&&!parola.equals("0"));
            if(parola.equals("0")){
                out.writeBytes("!\n");
            }
            else{
                out.writeBytes(""+ parola + '\n');
            }
            if(!parola.equals("0")){
                System.out.println("Inserisci stringa");
                parola = input.next();
                out.writeBytes("" + parola +'\n');
                String stringaRicevuta = in.readLine();
                System.out.println("la string ricevuta e' " + stringaRicevuta);
            }
            else{
                System.out.println("Connessione chiusa");
                connessione = false;
            }
            
        }
        
        s.close();
    }
}