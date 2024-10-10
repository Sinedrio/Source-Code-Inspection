package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected List<Integer> papelMoeda = Arrays.asList(2, 5, 10, 20, 50, 100);


    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        // Criar uma lista para armazenar as notas do troco
        List<Integer> troco = new ArrayList<>();

        int restante = saldo;

        // Percorrer as notas disponíveis em ordem decrescente
        for (int i = papelMoeda.length - 1; i >= 0; i--) {
            while (restante >= papelMoeda[i]) {
                troco.add(papelMoeda[i]);
                restante -= papelMoeda[i];
            }
        }
        // Resetar o saldo após calcular o troco
        saldo = 0;

        return troco.iterator();
    }


    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        } else if (saldo == 0) {
            throw new SaldoInsuficienteException();
        }
        saldo -= valor;
        return "**********\n";
    }



}
