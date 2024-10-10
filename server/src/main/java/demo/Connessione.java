package demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connessione extends Thread{
    Socket s;
    Connessione(Socket s){
        super();
        this.s = s; 
    }


    public void run() {
        try{
            System.out.println("un client si è collegato");
        BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
        boolean connessione = true;
        while(connessione){
            
            String stringaRicevuta = in.readLine();
            if(!stringaRicevuta.equals("!")){
                System.out.println("la string ricevuta e' " + stringaRicevuta);
                out.writeBytes(stringaRicevuta.toUpperCase() + '\n');
            }
            else{
                System.out.println("Connessione chiusa");
                connessione = false;
            }
        }
                
        s.close();
        }
        catch(Exception e){

        }
        
    }
}
