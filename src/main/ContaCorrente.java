package main;

public class ContaCorrente {
    public Agencia agencia;
    public Integer numero;
    public String senha;
    private double saldo = 0;

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) throws Exception {
        if(valor > this.getSaldo()) {
            throw new Exception("Saldo insuficiente");
        }
        this.saldo -= valor;
    }

    public void pagarConta(double valor) throws Exception {
        if(valor > this.getSaldo()) {
            throw new Exception("Saldo insuficiente");
        }
        this.saldo -= valor;
    }


    public void transferir(double valor, ContaCorrente contaBeneficiaria) throws  Exception{
        if(valor > this.getSaldo()) {
            throw new Exception("Saldo insuficiente");
        }
        contaBeneficiaria.depositar(valor);

    }



}
