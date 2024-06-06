package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.RodoviariaController;
import exceptions.CustomExceptions.AssentoIndisponivelException;
import exceptions.CustomExceptions.NumeroAssentoInvalidoException;
import exceptions.CustomExceptions.StatusInvalidoException;
import exceptions.CustomExceptions.TentativaLiberarAssentoDisponivelException;
import models.Rodoviaria;

public class TestesRodoviariaController {

    private Rodoviaria rodoviaria;
    private RodoviariaController controller;

    @BeforeEach
    public void setUp() {
        rodoviaria = new Rodoviaria();
        controller = new RodoviariaController(rodoviaria);
    }

    @Test
    public void testeCompraPassagemAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> controller.compraPassagem(0));
        assertThrows(NumeroAssentoInvalidoException.class, () -> controller.compraPassagem(11));
    }

    @Test
    public void testeCompraPassagemAssentoIndisponivel() {
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Indisponível");
            controller.compraPassagem(1);
        });
    }

    @Test
    public void testeReservaPassagemAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> controller.reservaPassagem(0));
        assertThrows(NumeroAssentoInvalidoException.class, () -> controller.reservaPassagem(11));
    }

    @Test
    public void testeReservaPassagemAssentoIndisponivel() {
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Indisponível");
            controller.reservaPassagem(1);
        });
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Reservado");
            controller.reservaPassagem(1);
        });
    }

    @Test
    public void testeLiberarAssentoAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> controller.liberarAssento(0));
        assertThrows(NumeroAssentoInvalidoException.class, () -> controller.liberarAssento(11));
    }

    @Test
    public void testeLiberarAssentoStatusDisponivel() throws StatusInvalidoException {
        rodoviaria.getAssento(1).setStatus("Disponível");
        assertThrows(TentativaLiberarAssentoDisponivelException.class, () -> controller.liberarAssento(1));
    }

    @Test
    public void testeCompraReservaLiberaAssento() throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        // Compra de passagem para o assento 1
        controller.compraPassagem(1);
        assertEquals("Indisponível", rodoviaria.getAssento(1).getStatus());

        // Reserva de passagem para o assento 2
        controller.reservaPassagem(2);
        assertEquals("Reservado", rodoviaria.getAssento(2).getStatus());

        // Liberação do assento 2
        controller.liberarAssento(2);
        assertEquals("Disponível", rodoviaria.getAssento(2).getStatus());
    }

    @Test
    public void testeLiberarAssentoJaDisponivel() throws StatusInvalidoException {
        rodoviaria.getAssento(1).setStatus("Disponível");
        assertThrows(TentativaLiberarAssentoDisponivelException.class, () -> controller.liberarAssento(1));
    }

    @Test
    public void testeCompraAssentoJaReservado() throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        // Reserva de passagem para o assento 1
        controller.reservaPassagem(1);
        assertEquals("Reservado", rodoviaria.getAssento(1).getStatus());

        // Tentativa de compra do assento 1 já reservado
        assertThrows(AssentoIndisponivelException.class, () -> controller.compraPassagem(1));
    }
}
