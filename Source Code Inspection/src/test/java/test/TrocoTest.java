package test;

import static org.junit.jupiter.api.Assertions.*;

import core.Troco;
import org.junit.jupiter.api.Test;

public class TrocoTest {

    @Test
    public void testTroco() {
        Troco troco = new Troco(130); // Exemplo: 130 de troco
        assertNotNull(troco.getIterator()); // Verifica se o iterator não é nulo
    }
}
