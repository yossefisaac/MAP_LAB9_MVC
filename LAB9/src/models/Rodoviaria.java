package models;

import java.util.ArrayList;
import java.util.List;

import event.RodoviariaEvent;
import exceptions.CustomExceptions.AssentoIndisponivelException;
import exceptions.CustomExceptions.NumeroAssentoInvalidoException;
import exceptions.CustomExceptions.StatusInvalidoException;
import exceptions.CustomExceptions.TentativaLiberarAssentoDisponivelException;
import interfaces.RodoviariaListener;

public class Rodoviaria {
    private List<Assento> assentos;
    private List<RodoviariaListener> rodoviariaListeners;

    public Rodoviaria() {
        assentos = new ArrayList<>();
        rodoviariaListeners = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            assentos.add(new Assento(i, "Disponível"));
        }
    }

    public void compraPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        if (numero <= 0 || numero > assentos.size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = assentos.get(numero - 1);
        if (!assento.getStatus().equals("Disponível")) {
            throw new AssentoIndisponivelException();
        }
        assento.setStatus("Indisponível");
        disparaPassagemComprada();
    }

    public void reservaPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        if (numero <= 0 || numero > assentos.size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = assentos.get(numero - 1);
        if (!assento.getStatus().equals("Disponível")) {
            throw new AssentoIndisponivelException();
        }
        assento.setStatus("Reservado");
        disparaPassagemReservada();
    }

    public void liberarAssento(int numero) throws NumeroAssentoInvalidoException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        if (numero <= 0 || numero > assentos.size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = assentos.get(numero - 1);
        if (assento.getStatus().equals("Disponível")) {
            throw new TentativaLiberarAssentoDisponivelException();
        }
        assento.setStatus("Disponível");
        disparaLiberarAssento();
    }

    public void addRodoviariaListener(RodoviariaListener listener) {
        rodoviariaListeners.add(listener);
    }

    public void removeRodoviariaListener(RodoviariaListener listener) {
        rodoviariaListeners.remove(listener);
    }

    public void disparaPassagemComprada() {
        RodoviariaEvent event = new RodoviariaEvent(this);
        for (RodoviariaListener listener : rodoviariaListeners) {
            listener.passagemComprada(event);
        }
    }

    public void disparaPassagemReservada() {
        RodoviariaEvent event = new RodoviariaEvent(this);
        for (RodoviariaListener listener : rodoviariaListeners) {
            listener.passagemReservada(event);
        }
    }

    public void disparaLiberarAssento() {
        RodoviariaEvent event = new RodoviariaEvent(this);
        for (RodoviariaListener listener : rodoviariaListeners) {
            listener.assentoLiberado(event);
        }
    }

    public ArrayList<Assento> getAssentos() {
        return new ArrayList<>(assentos);
    }

    public Assento getAssento(int numeroAssento) {
        return assentos.get(numeroAssento - 1);
    }

    public String getCorStatus(String status) {
        switch (status) {
            case "Disponível":
                return "\u001B[32m\u2B24\u001B[0m"; // Verde
            case "Reservado":
                return "\u001B[33m\u2B24\u001B[0m"; // Amarelo
            case "Indisponível":
                return "\u001B[31m\u2B24\u001B[0m"; // Vermelho
            default:
                return "";
        }
    }
}
