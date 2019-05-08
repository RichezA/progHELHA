package network;

import models.User;

public class CommandConnect extends Command {

    User user;

    public CommandConnect(User user) {
        this.user = user;
    }


    @Override
    public void dispatch(Interaction interaction) {
        interaction.onConnect(user);
    }
}
