package network;

public class CommandChangePseudo extends Command {

    String oldPseudo;
    String newPseudo;

    public CommandChangePseudo(String oldPseudo, String newPseudo) {
        this.oldPseudo = oldPseudo;
        this.newPseudo = newPseudo;
    }

    @Override
    public void dispatch(Interaction interaction) {
        interaction.onChangePseudo(oldPseudo, newPseudo);
    }
}
