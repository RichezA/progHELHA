package network;

import models.Message;

public class CommandMessageSend extends Command {
    Message message;

    public CommandMessageSend(Message message) {
        this.message = message;
    }

    @Override
    public void dispatch(Interaction interaction) {
        interaction.onMessageSend(message);
    }
}
