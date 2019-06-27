package network;

import models.Message;
import models.User;

import java.io.Serializable;

public abstract class Command implements Serializable {

    public abstract void dispatch(Interaction interaction);

    public interface Interaction {
        default void onConnect(User user) {}
        default void onMessageSend(Message message) {}
        default void onChangePseudo(String old, String newPseudo) {}
        default void onByeBye(User user) {}
    }
}
