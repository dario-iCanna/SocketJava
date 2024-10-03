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
        Socket s = server.accept();
        System.out.println("un client si è collegato");
        BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String stringaRicevuta = in.readLine();
        System.out.println("la string ricevuta e' " + stringaRicevuta);
        out.writeBytes(stringaRicevuta.toUpperCase() + '\n');
        s.close();
    }
}