package main;
import java.util.Random;


import java.util.ArrayList;
import java.util.Random;

public class Agencia {
    public String nome;
    public Integer codigo;
    public Gerente gerente;
    public ArrayList<Correntista> correntistas = new ArrayList<>();

    public Agencia (String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;

    }



    public String getNome() { return this.nome;}
    public Integer getCodigo() {
        return this.codigo;
    }


    public Integer getNumeroConta () {
        Random rand = new Random();
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound);

        return int_random;
    }

}
