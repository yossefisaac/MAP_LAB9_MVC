package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.CustomExceptions.AssentoIndisponivelException;
import exceptions.CustomExceptions.NumeroAssentoInvalidoException;
import models.Assento;
import models.Rodoviaria;

public class TestesRodoviaria {

    private Rodoviaria rodoviaria;

    @BeforeEach
    public void setUp() {
        rodoviaria = new Rodoviaria();
    }

    @Test
    public void testeComprarPassagemAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.compraPassagem(0));
    }

    @Test
    public void testeComprarPassagemAssentoIndisponivel() {
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Indisponível");
            rodoviaria.compraPassagem(1);
        });
    }

    @Test
    public void testeReservaPassagemAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.reservaPassagem(0));
    }

    @Test
    public void testeReservaPassagemAssentoIndisponivel() {
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Indisponível");
            rodoviaria.reservaPassagem(1);
        });
    }

    @Test
    public void testeLiberarAssentoAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.liberarAssento(0));
    }

    @Test
    public void testeReservarAssentoJaReservado() throws Exception {
        rodoviaria.reservaPassagem(1);
        assertThrows(AssentoIndisponivelException.class, () -> rodoviaria.reservaPassagem(1));
    }

    @Test
    public void testeGetAssentos() {
        ArrayList<Assento> assentos = rodoviaria.getAssentos();
        assertEquals(10, assentos.size());
    }

    @Test
    public void testeGetAssento() {
        Assento assento = rodoviaria.getAssento(1);
        assertEquals(1, assento.getNumero());
    }
}
