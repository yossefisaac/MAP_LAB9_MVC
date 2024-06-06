package controllers;

import exceptions.CustomExceptions.AssentoIndisponivelException;
import exceptions.CustomExceptions.NumeroAssentoInvalidoException;
import exceptions.CustomExceptions.StatusInvalidoException;
import exceptions.CustomExceptions.TentativaLiberarAssentoDisponivelException;
import models.Rodoviaria;

public class RodoviariaController {
    private Rodoviaria rodoviaria;

    public RodoviariaController(Rodoviaria rodoviaria) {
        this.rodoviaria = rodoviaria;
    }

    public void compraPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        rodoviaria.compraPassagem(numero);
    }

    public void reservaPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        rodoviaria.reservaPassagem(numero);
    }

    public void liberarAssento(int numero) throws NumeroAssentoInvalidoException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        rodoviaria.liberarAssento(numero);
    }
}
