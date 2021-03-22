package test;

import main.Agencia;
import main.Banco;
import main.ContaCorrente;
import main.Correntista;
import org.junit.Test;

import static org.junit.Assert.*;

public class BancoTest {

    public ContaCorrente factoryContaCorrente () {

        Agencia agencia = new Agencia("Centro", 2);
        Correntista correntista = new Correntista("José");
        ContaCorrente contaCorrente = new ContaCorrente(agencia, correntista);

        return contaCorrente;
    }


    @Test
    public void deveCriarUmBancoComNomeInformado() {

        Banco banco = new Banco("Banco da Newton");

        assertEquals("Banco da Newton", banco.getNome());

    }


    @Test
    public void deveAdicionarUmaContaCorrenteAoBanco() {
        ContaCorrente contaCorrente = this.factoryContaCorrente();

        Banco banco = new Banco("Banco da Newton");
        banco.adicionarContaCorrente(contaCorrente);

        assertTrue(banco.contemContaCorrente(contaCorrente));
    }

    @Test
    public void deveFalharAoVerificarUmaContaInexistenteAssociadaAoBanco() {
        ContaCorrente contaCorrenteA = this.factoryContaCorrente();
        ContaCorrente contaCorrenteB = this.factoryContaCorrente();

        Banco banco = new Banco("Banco da Newton");
        banco.adicionarContaCorrente(contaCorrenteA);

        assertFalse(banco.contemContaCorrente(contaCorrenteB));
    }


    @Test
    public void deveBuscarPorContaCorrente() {
        ContaCorrente contaCorrenteA = this.factoryContaCorrente();
        ContaCorrente contaCorrenteB = this.factoryContaCorrente();

        Banco banco = new Banco("Banco da Newton");
        banco.adicionarContaCorrente(contaCorrenteA);
        banco.adicionarContaCorrente(contaCorrenteB);

        assertEquals(contaCorrenteA, banco.buscarPorContaCorrente(contaCorrenteA.getCodigoAgencia(), contaCorrenteA.getNumero()));
    }


    @Test
    public void deveEncerrarUmaContaBancaria() {
        ContaCorrente contaCorrenteA = this.factoryContaCorrente();

        Banco banco = new Banco("Banco da Newton");
        banco.adicionarContaCorrente(contaCorrenteA);
        banco.removerContaCorrente(contaCorrenteA);

        assertFalse(banco.contemContaCorrente(contaCorrenteA));
    }


}
