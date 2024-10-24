package test;

import static org.junit.jupiter.api.Assertions.*;

import core.PapelMoeda;
import org.junit.jupiter.api.Test;

public class PapelMoedaTest {

    @Test
    public void testCriarPapelMoeda() {
        PapelMoeda moeda = new PapelMoeda(10, 5);
        assertEquals(10, moeda.getValor());
        assertEquals(5, moeda.getQuantidade());
    }
}
