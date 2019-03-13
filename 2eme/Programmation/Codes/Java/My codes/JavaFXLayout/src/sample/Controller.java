package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ScrollPane chatBox;

    @FXML
    private Label nameBar;

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
        ImageView imgView = new ImageView("/man.png");
        imgView.setPreserveRatio(true);imgView.setFitHeight(50);

        //messageBox.getChildren().add(label);
        FlowPane pane = new FlowPane();
        pane.setColumnHalignment(HPos.RIGHT); pane.setAlignment(Pos.TOP_RIGHT);
        pane.getChildren().add(label); pane.getChildren().add(imgView);


        messageBox.getChildren().add(pane);

        answerTF.setText("");
        chatBox.setVvalue(1.0);
    }

    @FXML
    void clickOnUser(MouseEvent event) {
        if(event.getTarget() instanceof Text){
            //messageBox.getChildren().clear();
            //Label label = new Label(((Text)event.getTarget()).getText());

            nameBar.setText(((Text) event.getTarget()).getText());
        }

    }

}
