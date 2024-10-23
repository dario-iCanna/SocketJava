package demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Server avviato...");
        ServerSocket server = new ServerSocket(3000);
        Dati dati = new Dati();
        Random r = new Random();
        dati.getLivelli().add(r.nextInt(100));
        while (true) {
            Connessione c = new Connessione(server.accept(),dati);
            c.start();
        }

    }
}