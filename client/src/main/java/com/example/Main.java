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
        Socket s = new Socket("localhost", 3000);
        BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        boolean connessione = true;
        int tent = 0, livello = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci nome");
        out.writeBytes("" + input.nextLine() + '\n');

        while (connessione) {
            String numero;
            System.out.println("inserisci un numero");
            numero = input.nextLine();
            out.writeBytes("" + numero + '\n');
            tent++;
            String risposta = in.readLine();
            switch (risposta) {
                case "<":
                    System.out.println("numero Troppo piccolo");
                    break;
                case ">":
                    System.out.println("numero Troppo grande");
                    break;
                case "=":
                    System.out.println("Bravo hai indovinato in " + tent + " tentativi");
                    int size = Integer.parseInt(in.readLine());
                    for(int i = 0; i < size; i++){
                        System.out.println(in.readLine());
                    }
                    System.out.println("Fare una nuova partita? S/n");
                    char r = input.next().charAt(0);
                    if (r == 'S' || r == 's') {
                        tent = 0;
                        livello++;
                        out.writeBytes("S\n");
                    } else {
                        connessione = false;
                    }

                    break;
                default:
                    tent--;
            }
        }

        s.close();
    }
}