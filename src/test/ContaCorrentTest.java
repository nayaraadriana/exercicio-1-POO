package test;

import main.Agencia;
import main.ContaCorrente;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContaCorrentTest {
    private static final double DELTA = 1e-15;

    @Test
    public void deveCriarUmaContaCorrenteComUmaAgencia() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;

        assertEquals(agencia.codigo, contaCorrente.agencia.codigo);
    }

    @Test
    public void deveCriarUmaContaCorrenteComSaldoZerado() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";

        assertEquals((double)0, contaCorrente.getSaldo(), DELTA);
    }

    @Test
    public void deveDepositarEmUmaConta() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";

        double valorDeposito = 20.80;

        contaCorrente.depositar(valorDeposito);

        assertEquals(valorDeposito, contaCorrente.getSaldo(), DELTA);
    }

    @Test
    public void deveSacarEmUmaConta() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";

        double valorDeposito = 1000;
        contaCorrente.depositar(valorDeposito);

        try {
            contaCorrente.sacar(999);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertEquals(1, contaCorrente.getSaldo(), DELTA);
    }


    @Test
    public void deveLancarUmaExpectionAoTentarSacarEmUmaContaSemSaldoSuficiente() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";

        double valorDeposito = 100;
        contaCorrente.depositar(valorDeposito);

        try {
            contaCorrente.sacar(200);
        } catch (Exception e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }


    @Test
    public void devePagarUmConta() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";

        double valorDeposito = 100;
        contaCorrente.depositar(valorDeposito);

        try {
            contaCorrente.pagarConta(80);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertEquals(20, contaCorrente.getSaldo(), DELTA);
    }

    @Test
    public void deveFalharAoTentarPagarUmaContaMaiorDoQueOSaldoExistente() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";

        double valorDeposito = 100;
        contaCorrente.depositar(valorDeposito);

        try {
            contaCorrente.pagarConta(120);
        } catch (Exception e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }

    @Test
    public void deveTransferirEntreContasCorrentes() {

        Agencia agencia = new Agencia();
        agencia.nome = "Buritis";
        agencia.codigo = 2;

        ContaCorrente contaCorrenteFulano = new ContaCorrente();
        contaCorrenteFulano.agencia = agencia;
        contaCorrenteFulano.numero = 2030;
        contaCorrenteFulano.senha = "123456";
        contaCorrenteFulano.depositar(1000.99);

        ContaCorrente contaCorrenteCiclano = new ContaCorrente();
        contaCorrenteCiclano.agencia = agencia;
        contaCorrenteCiclano.numero = 6540;
        contaCorrenteCiclano.senha = "abide";

        try {
            contaCorrenteFulano.transferir(100, contaCorrenteCiclano);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertEquals(100.0, contaCorrenteCiclano.getSaldo(), DELTA);
    }

    @Test
    public void deveRetornarConterNoExtratoDepositoRealizado() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";
        contaCorrente.depositar(100.01);

        assertTrue(contaCorrente.contemTransacao("Depósito: 100.01"));
    }

    @Test
    public void deveRetornarConterNoExtratoSaqueRealizado() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";
        contaCorrente.depositar(100.01);

        try {
            contaCorrente.sacar(9.01);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertTrue(contaCorrente.contemTransacao("Saque: 9.01"));
    }

    @Test
    public void deveRetornarConterNoExtratoPagamentoDeConta() {

        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 2;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.agencia = agencia;
        contaCorrente.numero = 2030;
        contaCorrente.senha = "123456";
        contaCorrente.depositar(100.01);

        try {
            contaCorrente.pagarConta(10.01);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertTrue(contaCorrente.contemTransacao("Pagamento conta: 9.01"));
    }

    @Test
    public void deveConterNoExtratoAtransferenciaEntreContas() {

        Agencia agencia = new Agencia();
        agencia.nome = "Buritis";
        agencia.codigo = 2;

        ContaCorrente contaCorrenteFulano = new ContaCorrente();
        contaCorrenteFulano.agencia = agencia;
        contaCorrenteFulano.numero = 2030;
        contaCorrenteFulano.senha = "123456";
        contaCorrenteFulano.depositar(1000.99);

        ContaCorrente contaCorrenteCiclano = new ContaCorrente();
        contaCorrenteCiclano.agencia = agencia;
        contaCorrenteCiclano.numero = 6540;
        contaCorrenteCiclano.senha = "abide";

        try {
            contaCorrenteFulano.transferir(100, contaCorrenteCiclano);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertTrue(contaCorrenteFulano.contemTransacao("Transferencia para conta 6540: 100.0"));
    }

}
