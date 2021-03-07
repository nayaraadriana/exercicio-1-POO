package test;

import main.Agencia;
import main.Gerente;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GerenteTest {

    @Test
    public void deveCriarUmGerenteComNomeInformado(){
        Gerente gerente = new Gerente();
        gerente.nome = "Manuel";
        assertEquals("Manuel", gerente.nome);
    }

    @Test
    public void deveAdicionarUmGerenteAumaAgencia() {
        Agencia agencia = new Agencia();
        agencia.codigo = 1;
        agencia.nome = "Buritis";

        Gerente gerente = new Gerente();
        gerente.nome = "Manuel";

        agencia.gerente = gerente;

        assertEquals(gerente, agencia.gerente);
    }
}
