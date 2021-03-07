package test;

import main.Agencia;
import main.Correntista;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void deveAdicionarCorrentistaNaAgencia() {
        Correntista correntista = new Correntista();
        correntista.nome = "Ana";
        correntista.cpf = "55566677788";

        Agencia agencia = new Agencia();
        agencia.correntistas.add(correntista);

        assertTrue(agencia.correntistas.contains(correntista));
    }

}
