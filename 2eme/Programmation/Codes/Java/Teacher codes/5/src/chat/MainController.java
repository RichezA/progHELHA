package chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField answerTF;

    @FXML
    private Button sendBtn;

    @FXML
    private VBox messagesBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialization");
    }

    @FXML
    void clickOnSend(ActionEvent event) {
        Label label = new Label(answerTF.getText());
//        messagesBox.getChildren().clear();
        messagesBox.getChildren().add(label);
        answerTF.setText("");
    }
    @FXML
    void clickOnUser(MouseEvent event) {

        if (event.getTarget() instanceof Text) {
            messagesBox.getChildren().clear();
            Label label = new Label(((Text)event.getTarget()).getText());
            messagesBox.getChildren().add(label);
        }

    }
    @FXML
    void clickOnUser2(MouseEvent event) {
        System.out.println("Click on user 2");
        event.consume();
    }
}
