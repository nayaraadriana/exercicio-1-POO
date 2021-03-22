package main;

import java.util.ArrayList;

public class ContaCorrente {
    private Agencia agencia;
    private Correntista correntista;
    private Integer numero;
    public String senha;
    private double saldo = 0;
    private ArrayList<String> extrato = new ArrayList<>();

   public ContaCorrente (Agencia agencia, Correntista correntista) {
        this.agencia = agencia;
        this.correntista = correntista;
        this.numero = agencia.getNumeroConta();

   }

   public Integer getNumero() {
       return this.numero;
   }


    public Integer getCodigoAgencia (){
       return agencia.getCodigo();
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        this.extrato.add(String.format("Depósito de %s", valor));
        this.saldo += valor;
    }

    public void sacar(double valor) throws Exception {
        if(valor > this.getSaldo()) {
            throw new Exception("Saldo insuficiente");
        }
        this.extrato.add(String.format("Saque: %s", valor));
        this.saldo -= valor;
    }

    public void pagarConta(double valor) throws Exception {
        if(valor > this.getSaldo()) {
            throw new Exception("Saldo insuficiente");
        }
        this.extrato.add(String.format("Pagamento conta: %s", valor));
        this.saldo -= valor;
    }


    public void transferir(double valor, ContaCorrente contaBeneficiaria) throws  Exception{
        if(valor > this.getSaldo()) {
            throw new Exception("Saldo insuficiente");
        }
        this.extrato.add(String.format("Transferencia para conta %s: %s", contaBeneficiaria.numero, valor));
        contaBeneficiaria.depositar(valor);
    }

    public boolean contemTransacao(String transacao) {
        return this.extrato.contains(transacao);
    }

    public Integer getSizeExtrato () {
        return this.extrato.size();
    }

    public String getItemDoExtrato(Integer posicao) {
        return this.extrato.get(posicao);
    }

    public void atualizarCorrentista(Correntista correntista) {
       this.correntista = correntista;
    }

    public String getNomeCorrentista() {
       return this.correntista.getNome();
    }



}
