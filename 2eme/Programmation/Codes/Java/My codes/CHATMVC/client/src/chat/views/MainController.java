package chat.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Message;
import models.User;

public class MainController {

    @FXML
    private TextField answerTF;

    @FXML
    private Button sendBtn;

    @FXML
    private VBox messagesBox;

    @FXML
    private ScrollPane scrollPane;

    Interaction interaction;
    private User user;

    @FXML
    public void initialize() {
        System.out.println("Initialization");
        scrollPane.vvalueProperty().bind(messagesBox.heightProperty());
        messagesBox.getChildren().clear();
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    @FXML
    void clickOnSend(ActionEvent event) {
        interaction.onSendClick(answerTF.getText());
    }

    public void addMessage(Message message) {
        ImageView imageView = getImageView(message);
        Label label = getLabel(message);
        Pane messagePane = getMessagePane(imageView, label, message.getUser().equals(this.user));
        messagesBox.getChildren().add(messagePane);
    }

    private Pane getMessagePane(ImageView imageView, Label label, boolean isCurrentUser) {
        FlowPane messagePane = new FlowPane();
        FlowPane.setMargin(label, new Insets(5));
        if (isCurrentUser) {
            messagePane.setAlignment(Pos.TOP_RIGHT);
            messagePane.getChildren().add(label);
            messagePane.getChildren().add(imageView);
        } else {
            messagePane.setAlignment(Pos.TOP_LEFT);
            messagePane.getChildren().add(imageView);
            messagePane.getChildren().add(label);
        }
        return messagePane;
    }

    private Label getLabel(Message message) {
        return new Label(message.getText());
    }

    private ImageView getImageView(Message message) {
        String imageName = message.getUser().equals(this.user) ? "homme.png" : "femme.png";
        ImageView imageView = new ImageView(new Image(MainController.class.getResourceAsStream("../Images/" + imageName)));
        imageView.setFitHeight(44);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    public void cleanMessage() {
        answerTF.setText("");
    }

    @FXML
    void clickOnUser2(MouseEvent event) {
        System.out.println("Click on user 2");
        event.consume();
    }

    public void setCurrentUser(User user) {
        this.user = user;
    }

    public void addUser(User user) {
        messagesBox.getChildren().add(new Label(user.getName() + " s'est connecté"));
    }

    public void addModifiedUsername(String oldPseudo, String newPseudo){
        messagesBox.getChildren().add(new Label( oldPseudo + " est maintenant " + newPseudo));
    }

    public void addDisconnectedUser(User user) {
        messagesBox.getChildren().add(new Label( user.getName() + " s'est déconnecté"));
    }

    public interface Interaction {
        void onSendClick(String message);
    }
}
