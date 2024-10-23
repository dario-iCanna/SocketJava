package demo;

import java.util.ArrayList;

public class Dati {
    ArrayList<Integer> livelli;
    ArrayList<ArrayList<String>> classifica;
    Dati(){
        livelli = new ArrayList<Integer>();            
        classifica = new ArrayList<ArrayList<String>>();    

    }
    public ArrayList<Integer> getLivelli() {
        return livelli;
    }

    public ArrayList<ArrayList<String>> getClassifica() {
        return classifica;
    }
}
