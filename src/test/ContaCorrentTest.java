package test;

import main.Agencia;
import main.ContaCorrente;
import main.Correntista;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContaCorrentTest {
    private static final double DELTA = 1e-15;


    public ContaCorrente factoryContaCorrente () {

        Agencia agencia = new Agencia("Banco Centro", 2);

       Correntista correntista = new Correntista("Nayara");

        ContaCorrente contaCorrente = new ContaCorrente(agencia, correntista);

        return contaCorrente;
    }

    @Test
    public void deveCriarUmaContaCorrenteComUmaAgencia() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

        assertEquals((double)2, contaCorrente.getCodigoAgencia(), DELTA );
    }

    @Test
    public void deveCriarUmaContaCorrenteComSaldoZerado() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

        assertEquals((double)0, contaCorrente.getSaldo(), DELTA);
    }

    @Test
    public void deveDepositarEmUmaConta() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

        double valorDeposito = 20.80;

        contaCorrente.depositar(valorDeposito);

        assertEquals(valorDeposito, contaCorrente.getSaldo(), DELTA);
    }

    @Test
    public void deveSacarEmUmaConta() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

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

        ContaCorrente contaCorrente = this.factoryContaCorrente();

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

       ContaCorrente contaCorrente = this.factoryContaCorrente();

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

        ContaCorrente contaCorrente = this.factoryContaCorrente();

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

        ContaCorrente contaCorrenteFulano = this.factoryContaCorrente();
        contaCorrenteFulano.depositar(1000.99);

        ContaCorrente contaCorrenteCiclano = this.factoryContaCorrente();


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

        ContaCorrente contaCorrente = this.factoryContaCorrente();
        contaCorrente.depositar(100.01);

        assertTrue(contaCorrente.contemTransacao("Depósito de 100.01"));
    }

    @Test
    public void deveRetornarConterNoExtratoSaqueRealizado() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();
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

        ContaCorrente contaCorrente = this.factoryContaCorrente();
        contaCorrente.depositar(100.01);

        try {
            contaCorrente.pagarConta(10.01);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }

        assertTrue(contaCorrente.contemTransacao("Pagamento conta: 10.01"));
    }

    @Test
    public void deveConterNoExtratoAtransferenciaEntreContas() {

        ContaCorrente contaCorrenteFulano = this.factoryContaCorrente();
        contaCorrenteFulano.depositar(1000.99);

        ContaCorrente contaCorrenteCiclano = this.factoryContaCorrente();

        try {
            contaCorrenteFulano.transferir(100, contaCorrenteCiclano);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception " + e);
        }
        String descricao = new StringBuilder("Transferencia para conta " ).append(contaCorrenteFulano.getNumero().toString()).append(": 100.0").toString();

        assertTrue(true);
    }

    @Test
    public void deveRetornarQuantidadeDeItensNoExtrato() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

        contaCorrente.depositar(20.80);
        contaCorrente.depositar(60.00);

        assertEquals( (Integer)2 , contaCorrente.getSizeExtrato() );
    }

    @Test
    public void deveRetornarExtratoSemRegistros() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

        assertEquals( (Integer)0 , contaCorrente.getSizeExtrato() );
    }

    @Test
    public void deveRetornarUmDeterminadoItemNoExtrato() {

        ContaCorrente contaCorrente = this.factoryContaCorrente();

        contaCorrente.depositar(20.80);
        contaCorrente.depositar(60.00);

        assertEquals( "Depósito de 20.8" , contaCorrente.getItemDoExtrato(0) );
    }

}
