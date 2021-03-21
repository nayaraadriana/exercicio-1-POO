package test;

import main.Agencia;
import main.Banco;
import org.junit.Test;

import static org.junit.Assert.*;

public class BancoTest {

    @Test
    public void deveCriarUmBancoComNomeInformado() {

        Banco banco = new Banco("Banco da Newton");

        assertEquals("Banco da Newton", banco.getNome());

    }


    @Test
    public void deveAdicionarUmaAgenciaAoBanco() {
        Banco banco = new Banco("Banco da Newton");
        Agencia agencia = new Agencia( "Santa Efigenia" , 2550);

        banco.agencias.add(agencia);

        assertTrue(banco.agencias.contains(agencia));
    }
}
