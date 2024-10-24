package test;

import static org.junit.jupiter.api.Assertions.*;

import core.TicketMachine;
import exception.PapelMoedaInvalidaException;
import exception.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketMachineTest {

    private TicketMachine ticketMachine;

    @BeforeEach
    public void setUp() {
        ticketMachine = new TicketMachine(10); // Defina o valor do ticket
    }

    @Test
    public void testInserirPapelMoedaValido() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(10);
        assertEquals(10, ticketMachine.getSaldo());
    }

    @Test
    public void testInserirPapelMoedaInvalido() {
        Exception exception = assertThrows(PapelMoedaInvalidaException.class, () -> {
            ticketMachine.inserir(3); // Moeda inválida
        });
        assertNotNull(exception);
    }

    @Test
    public void testImprimirComSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        ticketMachine.inserir(20);
        String resultado = ticketMachine.imprimir();
        assertEquals("**********\n", resultado);
        assertEquals(10, ticketMachine.getSaldo()); // 20 - 10
    }

    @Test
    public void testImprimirComSaldoInsuficiente() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(5); // Saldo insuficiente
        Exception exception = assertThrows(SaldoInsuficienteException.class, () -> {
            ticketMachine.imprimir();
        });
        assertNotNull(exception);
    }
}
