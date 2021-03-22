package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Banco {
    private String nome;
    private Map<String, ContaCorrente> contasCorrentes = new HashMap<String, ContaCorrente>();

    public Banco (String nome){
        
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void adicionarContaCorrente(ContaCorrente contaCorrente) {

        this.contasCorrentes.put(contaCorrente.getCodigoAgencia().toString() + contaCorrente.getNumero().toString(), contaCorrente);
    }

    public void removerContaCorrente(ContaCorrente contaCorrente) {

        this.contasCorrentes.remove(contaCorrente.getCodigoAgencia().toString() + contaCorrente.getNumero().toString());
    }

    public boolean contemContaCorrente(ContaCorrente contaCorrente) {

        return this.contasCorrentes.containsKey(contaCorrente.getCodigoAgencia().toString() + contaCorrente.getNumero().toString());
    }

    public ContaCorrente  buscarPorContaCorrente(Integer codigoAgencia, Integer numeroContaCorrente) {
        return this.contasCorrentes.get(codigoAgencia.toString()+numeroContaCorrente.toString());
    }

    public HashMap<String, ContaCorrente> getContasCorrentes() {
        HashMap<String, ContaCorrente> copyContasCorrentes = new HashMap<>();
        copyContasCorrentes.putAll(this.contasCorrentes);
        return copyContasCorrentes;
    }

}
