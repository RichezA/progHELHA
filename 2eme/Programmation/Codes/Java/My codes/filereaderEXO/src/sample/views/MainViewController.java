package sample.views;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import sample.models.ExplorerState;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    public TableView<File> tableView;
    @FXML
    public BorderPane borderPane;
    @FXML
    public FlowPane pathBtnPane;
    @FXML
    public TableColumn<File, String> nameColumn;
    @FXML
    public TableColumn<File, String> sizeColumn;
    @FXML
    public TableColumn<File, String> typeColumn;
    MainViewInteraction interaction;
    Button btn;
    public void setInteraction(MainViewInteraction interaction){
        this.interaction = interaction;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sizeColumn.setCellValueFactory((param) -> {
            String size = "";
            final File file = param.getValue();
            if(file.isFile()) size = file.length() + "o";
            return new SimpleStringProperty(size);
        });
        nameColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getName()));
        typeColumn.setCellValueFactory((param) -> {
            final File file = param.getValue();
            String type = file.isFile() ? "fichier" : "dossier";
            return new SimpleStringProperty(type);
        });
    }


    public void initPathBar(ExplorerState explorerState){
        ArrayList<File> files;
        pathBtnPane.getChildren().clear();
        files = explorerState.getParentsAndCurrentFolder();
        for (File f : files){
            btn = new Button(f.getName());
            btn.setOnAction(event -> {
                interaction.showSubListing(f);
                interaction.onSelect(explorerState);
            });
            pathBtnPane.getChildren().add(btn);
        }
    }


    public void addAFileToView(ExplorerState explorerState){
        tableView.setItems(explorerState.getSubfiles());
    }

    public void clickNode(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            // get the node -> take it and pass it to main controller to refresh the explorer state
        }
    }
}
