package test;

import main.Agencia;
import main.Banco;
import org.junit.Test;

import static org.junit.Assert.*;

public class BancoTest {

    @Test
    public void deveCriarUmBancoComNomeInformado() {
        Banco banco = new Banco();
        banco.nome = "Banco da Newton";
        assertEquals("Banco da Newton", banco.nome);

    }

    @Test
    public void deveAdicionarUmaAgenciaAoBanco() {
        Banco banco = new Banco();
        banco.nome = "Banco da Newton";
        Agencia agencia = new Agencia();
        agencia.nome = "Carlos Luz";
        agencia.codigo = 1;
        banco.agencias.add(agencia);

        assertTrue(banco.agencias.contains(agencia));
    }
}
