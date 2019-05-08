package network;

import models.User;

public class CommandGoodBye extends Command {
    User user;

    public CommandGoodBye(User user){ this.user = user; }
    @Override
    public void dispatch(Interaction interaction) {
        interaction.onByeBye(user);
    }
}
