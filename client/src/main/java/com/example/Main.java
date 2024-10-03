package com.example;

import java.io.BufferedReader;
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
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci stringa");
        out.writeBytes(""+ input.next() + '\n');
        String stringaRicevuta = in.readLine();
        System.out.println("la string ricevuta e' " + stringaRicevuta);
        s.close();
    }
}