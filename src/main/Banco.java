package main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Banco {
    private String nome;
    public ArrayList<Agencia> agencias = new ArrayList<>();

    public Banco (String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }


}
