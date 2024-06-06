package views;

import java.util.ArrayList;

import event.RodoviariaEvent;
import interfaces.RodoviariaListener;
import models.Assento;
import models.Rodoviaria;

public class Quiosque implements RodoviariaListener {
    @Override
    public void passagemComprada(RodoviariaEvent event) {
        Rodoviaria rodoviaria = (Rodoviaria) event.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nQuiosque sabe que passagem foi comprada");
        System.out.println("LISTAGEM ASSENTOS DO QUIOSQUE: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            System.out.println("Assento " + assento.getNumero() + ": " + status);
        }
    }

    @Override
    public void passagemReservada(RodoviariaEvent event) {
        Rodoviaria rodoviaria = (Rodoviaria) event.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nQuiosque sabe que passagem foi reservada");
        System.out.println("LISTAGEM ASSENTOS DO QUIOSQUE: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            System.out.println("Assento " + assento.getNumero() + ": " + status);
        }
    }

    @Override
    public void assentoLiberado(RodoviariaEvent event) {
        Rodoviaria rodoviaria = (Rodoviaria) event.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nQuiosque sabe que assento foi liberado");
        System.out.println("LISTAGEM ASSENTOS DO QUIOSQUE: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            System.out.println("Assento " + assento.getNumero() + ": " + status);
        }
    }
}
