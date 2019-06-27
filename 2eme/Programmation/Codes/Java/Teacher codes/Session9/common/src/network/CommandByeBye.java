package network;

import models.User;

public class CommandByeBye extends Command {

    User user;

    public CommandByeBye(User user) {
        this.user = user;
    }


    @Override
    public void dispatch(Interaction interaction) {
        interaction.onByeBye(user);
    }
}
