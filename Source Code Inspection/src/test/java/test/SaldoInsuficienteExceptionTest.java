//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import exception.SaldoInsuficienteException;
//import org.junit.jupiter.api.Test;
//
//public class SaldoInsuficienteExceptionTest {
//
//    @Test
//    public void testLancarSaldoInsuficiente() {
//        Exception exception = assertThrows(SaldoInsuficienteException.class, () -> {
//            // Chame o método que deve lançar a exceção
//            ticketMachine.emitirTroco(20); // Supondo que o saldo é insuficiente
//        });
//        assertEquals("Saldo insuficiente", exception.getMessage());
//    }
//}
