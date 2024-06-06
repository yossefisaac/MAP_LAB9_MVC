package models;

import exceptions.CustomExceptions.StatusInvalidoException;

public class Assento {
    private int numero;
    private String status;

    public Assento(int numero, String status) {
        this.numero = numero;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws StatusInvalidoException {
        if (!status.equals("Disponível") && !status.equals("Indisponível") && !status.equals("Reservado")) {
            throw new StatusInvalidoException("Status inválido: " + status);
        }
        this.status = status;
    }

    public Object setNumero(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNumero'");
    }
}
