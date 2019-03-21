package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
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

//    @FXML
//    private Label userName;

    @FXML
    private Label currentUser;

//    @FXML
//    public void initialize(URL location, ResourceBundle resources){
//        System.out.println("Initialize");
//    }

    @FXML
    void clickOnSend(ActionEvent event){
        TextField input = (TextField) event.getSource();
        if(event.getSource() instanceof Button ||  input.getText().charAt(input.getText().length()) ==(String)KeyCode.ENTER) {
            Label label = new Label(" " + answerTF.getText());
            FlowPane pane = new FlowPane(); pane.setPadding(new Insets(0,10,0,0));
            ImageView img = new ImageView("./girl.png"); img.setFitWidth(50); img.setFitHeight(50);
            pane.getChildren().add(img);
            pane.getChildren().add(label);
            messageBox.getChildren().add(pane);
            answerTF.setText("");
        }
        else
        {

        }

    }

    @FXML
    void clickOnUser(MouseEvent event) {
        if(event.getTarget() instanceof Text){
            currentUser.setText(((Text) event.getTarget()).getText());
        }

    }

}
