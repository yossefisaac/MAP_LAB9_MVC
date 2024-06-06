package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.CustomExceptions.StatusInvalidoException;
import models.Assento;

public class TestesAssento {
    private Assento assento;

    @BeforeEach
    public void setUp() {
        assento = new Assento(1, "Disponível");
    }

    @Test
    public void testeGetNumero() {
        assertEquals(1, assento.getNumero());
    }

    @Test
    public void testeGetStatus() {
        assertEquals("Disponível", assento.getStatus());
    }

    @Test
    public void testeSetStatusParaReservado() throws StatusInvalidoException {
        assento.setStatus("Reservado");
        assertEquals("Reservado", assento.getStatus());
    }

    @Test
    public void testeSetStatusParaIndisponivel() throws StatusInvalidoException {
        assento.setStatus("Indisponível");
        assertEquals("Indisponível", assento.getStatus());
    }

    @Test
    public void testeSetStatusParaDisponivelAPartirDeReservado() throws StatusInvalidoException {
        assento.setStatus("Reservado");
        assento.setStatus("Disponível");
        assertEquals("Disponível", assento.getStatus());
    }

    @Test
    public void testeSetStatusParaDisponivelAPartirDeIndisponivel() throws StatusInvalidoException {
        assento.setStatus("Indisponível");
        assento.setStatus("Disponível");
        assertEquals("Disponível", assento.getStatus());
    }

    @Test
    public void testeSetStatusInvalido() {
        assertThrows(StatusInvalidoException.class, () -> assento.setStatus("Status inválido"));
    }

    @Test
    public void testeNumeroAssentoImutavel() {
        assertThrows(UnsupportedOperationException.class, () -> assento.setNumero(2));
        assertEquals(1, assento.getNumero());
    }
}
