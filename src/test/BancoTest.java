package test;

import main.Banco;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BancoTest {

    @Test
    public void deveCriarUmBancoComNomeInformado() {
        Banco banco = new Banco();
        banco.nome = "Banco da Newton";
        assertEquals("Banco da Newton", banco.nome);

    }
}
