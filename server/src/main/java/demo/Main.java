package demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Server avviato...");
        ServerSocket server = new ServerSocket(3000);
        while(true){
            Connessione c = new Connessione(server.accept());
            c.start();
        }
        

    }
}