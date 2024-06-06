package event;

import models.Rodoviaria;

import java.util.EventObject;

public class RodoviariaEvent extends EventObject {

    public RodoviariaEvent(Rodoviaria source) {
        super(source);
    }
}
