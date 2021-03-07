package test;

import main.Agencia;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AgenciaTest {

    @Test
    public void deveCriarUmaAgenciaComNomeInformado() {
        Agencia agencia = new Agencia();
        agencia.nome = "Buritis";

        assertEquals("Buritis", agencia.nome);
    }

    @Test
    public void deveCriarUmaAgenciaComCodigoInformado() {
        Agencia agencia = new Agencia();
        agencia.codigo = 1;

        assertEquals((Integer)1, agencia.codigo);
    }

}
