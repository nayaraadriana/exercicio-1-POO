package test;

import main.Gerente;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GerenteTest {

    @Test
    public void deveCriarUmGerenteComNomeInformado(){
        Gerente gerente = new Gerente();
        gerente.nome = "Manuel";
        assertEquals("Manuel", gerente.nome);
    }
}
