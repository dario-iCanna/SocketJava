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
            System.out.println("inserisci stringa");
            String parola = input.next();
            out.writeBytes(""+ parola + '\n');
            if(!parola.equals("!")){
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