package demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Connessione extends Thread {
    Socket s;
    int ind = 0;
    Dati dati;
    Random r;
    String nome = "";

    Connessione(Socket s, Dati dati) {
        super();
        this.s = s;
        this.dati = dati;
    }

    public void run() {
        try {
            System.out.println("un client si è collegato");
            BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            boolean connessione = true;
            nome = in.readLine();
            while (connessione) {
                String stringaRicevuta = in.readLine();
                try {
                    int n = Integer.parseInt(stringaRicevuta);
                    if (n != dati.getLivelli().get(ind)) {
                        if (n < dati.getLivelli().get(ind)) {
                            out.writeBytes("<\n");
                        } else {
                            out.writeBytes(">\n");
                        }
                    } else {
                        out.writeBytes("=\n");
                        if (ind == dati.getLivelli().size() - 1) {
                            dati.getClassifica().add(new ArrayList<String>());
                        }
                        dati.getClassifica().get(ind).add(in.readLine() + " Tentativi - " + nome);
                        for(int i = 0; i < dati.getClassifica().get(ind).size()-1; i++){
                            if(dati.getClassifica().get(ind).get(i).charAt(0) > dati.getClassifica().get(ind).get(i + 1).charAt(0)){
                                String f = dati.getClassifica().get(ind).get(i);
                                dati.getClassifica().get(ind).set(i, dati.getClassifica().get(ind).get(i + 1));
                                dati.getClassifica().get(ind).set(i+1, f);

                            }
                        }
                        out.writeBytes("" + dati.getClassifica().get(ind).size() + '\n');
                        for(int i = 0; i < dati.getClassifica().get(ind).size(); i++){
                            out.writeBytes(dati.getClassifica().get(ind).get(i)+ '\n');
                        }
                        if (in.readLine().equals("S")) {
                            ind++;
                            if (ind > dati.getLivelli().size() - 1) {
                                Random r = new Random();
                                dati.getLivelli().add(r.nextInt(100));
                            }
                        } else {
                            System.out.println("Connessione chiusa");
                            connessione = false;
                        }

                    }
                } catch (Exception e) {
                    out.writeBytes("!\n");
                }
            }

            s.close();
        } catch (

        Exception e) {

        }

    }
}
