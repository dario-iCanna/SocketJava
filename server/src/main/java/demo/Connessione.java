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

                switch(stringaRicevuta){
                    case "1":
                        stringaRicevuta = in.readLine();
                        System.out.println("la string ricevuta e' " + stringaRicevuta);
                        out.writeBytes(stringaRicevuta.toUpperCase() + '\n');
                    break;
                    case "2":
                        stringaRicevuta = in.readLine();
                        System.out.println("la string ricevuta e' " + stringaRicevuta);
                        out.writeBytes(stringaRicevuta.toLowerCase() + '\n');
                    break;
                    case "3":
                        stringaRicevuta = in.readLine();
                        String nuovStr = "";
                        System.out.println("la string ricevuta e' " + stringaRicevuta);
                        for(int i = stringaRicevuta.length()-1; i>=0;i--){
                            char l=stringaRicevuta.charAt(i);
                            nuovStr += l;
                        }
                        out.writeBytes(nuovStr + '\n');
                    break;
                    case "4":
                        stringaRicevuta = in.readLine();
                        System.out.println("la string ricevuta e' " + stringaRicevuta);
                        out.writeBytes(""+stringaRicevuta.length() + '\n');
                    break;
                }
                
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
