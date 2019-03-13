package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private TextField answerTF;

    @FXML
    private Button sendBtn;

    @FXML
    private VBox messageBox;

    @FXML
    private Label userName;

    @FXML
    public void initialize(URL location, ResourceBundle resources){
        System.out.println("Initialize");
    }

    @FXML
    void clickOnSend(ActionEvent event){
        Label label = new Label(answerTF.getText() + "\n");
        messageBox.getChildren().clear();
        messageBox.getChildren().add(label);
        answerTF.setText("");
    }

    @FXML
    void clickOnUser(MouseEvent event) {
        if(event.getTarget() instanceof Text){
            messageBox.getChildren().clear();
            Label label = new Label(((Text)event.getTarget()).getText());
            messageBox.getChildren().add(label);
        }

    }

}
