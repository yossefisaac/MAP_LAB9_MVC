package interfaces;

import event.RodoviariaEvent;


public interface RodoviariaListener extends java.util.EventListener{

    public void passagemComprada (RodoviariaEvent rodoviariaEvent);
    public void passagemReservada(RodoviariaEvent rodoviariaEvent);
    public void assentoLiberado (RodoviariaEvent rodoviariaEvent);
}
