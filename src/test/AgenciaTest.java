package test;

import main.Agencia;
import main.ContaCorrente;
import main.Correntista;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgenciaTest {

    @Test
    public void deveCriarUmaAgenciaComNomeInformado() {
        Agencia agencia = new Agencia( "Centro", 6545);

        assertEquals("Centro", agencia.getNome());

    }


    @Test
    public void deveCriarUmaAgenciaComCodigoInformado() {

        Agencia agencia = new Agencia( "Centro", 6545);

        assertEquals((Integer)6545, agencia.getCodigo());
    }

    @Test
    public void deveAdicionarCorrentistaNaAgencia() {
        Correntista correntista = new Correntista("Ana");
        correntista.cpf = "55566677788";

        Agencia agencia = new Agencia( "Centro", 6545);
        agencia.correntistas.add(correntista);

        assertTrue(agencia.correntistas.contains(correntista));
    }

}
