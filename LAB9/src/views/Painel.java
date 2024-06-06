package views;

import java.util.ArrayList;

import event.RodoviariaEvent;
import interfaces.RodoviariaListener;
import models.Assento;
import models.Rodoviaria;

public class Painel implements RodoviariaListener {
    @Override
    public void passagemComprada(RodoviariaEvent event) {
        Rodoviaria rodoviaria = (Rodoviaria) event.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nPainel sabe que passagem foi comprada");
        System.out.println("LISTAGEM ASSENTOS DO PAINEL: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            String cor = rodoviaria.getCorStatus(status);
            System.out.println("Assento " + assento.getNumero() + ": " + cor);
        }
    }

    @Override
    public void passagemReservada(RodoviariaEvent event) {
        Rodoviaria rodoviaria = (Rodoviaria) event.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nPainel sabe que passagem foi reservada");
        System.out.println("LISTAGEM ASSENTOS DO PAINEL: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            String cor = rodoviaria.getCorStatus(status);
            System.out.println("Assento " + assento.getNumero() + ": " + cor);
        }
    }

    @Override
    public void assentoLiberado(RodoviariaEvent event) {
        Rodoviaria rodoviaria = (Rodoviaria) event.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nPainel sabe que assento foi liberado");
        System.out.println("LISTAGEM ASSENTOS DO PAINEL: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            String cor = rodoviaria.getCorStatus(status);
            System.out.println("Assento " + assento.getNumero() + ": " + cor);
        }
    }
}

