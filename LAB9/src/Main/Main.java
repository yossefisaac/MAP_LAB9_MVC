package Main;

import controllers.RodoviariaController;
import exceptions.CustomExceptions.AssentoIndisponivelException;
import exceptions.CustomExceptions.NumeroAssentoInvalidoException;
import exceptions.CustomExceptions.StatusInvalidoException;
import exceptions.CustomExceptions.TentativaLiberarAssentoDisponivelException;
import models.Rodoviaria;
import views.Painel;
import views.Quiosque;

public class Main {
    public static void main(String[] args) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        Rodoviaria rodoviaria = new Rodoviaria();
        Painel painel = new Painel();
        Quiosque quiosque = new Quiosque();
        
        rodoviaria.addRodoviariaListener(painel);
        rodoviaria.addRodoviariaListener(quiosque);
        
        RodoviariaController controller = new RodoviariaController(rodoviaria);
        
        controller.compraPassagem(1);
        controller.reservaPassagem(5);
        controller.liberarAssento(5);
    }
}
