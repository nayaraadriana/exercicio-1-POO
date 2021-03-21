package test;

import main.Correntista;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CorrentistaTest {

    @Test
    public void deveCriaUmCorrentistaComNomeInformado() {
        Correntista correntista = new Correntista("José Silva");

        assertEquals("José Silva", correntista.getNome());
    }

    @Test
    public void deveCriaUmCorrentistaComCpfInformado() {
        Correntista correntista = new Correntista("José Silva");
        correntista.cpf = "1122233344";

        assertEquals("1122233344", correntista.cpf);
    }
}
