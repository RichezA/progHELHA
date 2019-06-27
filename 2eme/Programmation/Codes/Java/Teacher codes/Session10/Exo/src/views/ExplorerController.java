/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.ExplorerState;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author fpluquet
 */
public class ExplorerController implements Initializable {

    @FXML
    private FlowPane path;

    @FXML
    private TableView<File> table;

    @FXML
    private TableColumn<File, String> nameTC;

    @FXML
    private TableColumn<File, String> sizeTC;

    @FXML
    private TableColumn<File, String> typeTC;
    
    ExplorerState state;

    Interaction interaction;
    
    static public FXMLLoader getLoader() throws IOException {
        return new FXMLLoader(ExplorerController.class.getResource("Explorer.fxml"));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private void setTableInteractionEvents() {
        table.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                goToSelection();
            }
        });
        table.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                goToSelection();
            }
        });
    }    

    private void setCellValueFactories() {
//        nameTC.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getName())); // -> voir le fxml

        sizeTC.setCellValueFactory((param) -> {
            String size = "";
            final File file = param.getValue();
            if (file.isFile()) {
                size = file.length() + "o";
            }
            return new SimpleStringProperty(size);
        });

        typeTC.setCellValueFactory((param) -> {
            final File file = param.getValue();
            String type = file.isFile() ? "fichier" : "dossier";
            return new SimpleStringProperty(type);
        });
    }    

    private void goToSelection() {
        File file = table.getSelectionModel().getSelectedItems().get(0);
        interaction.onSelect(file);
    }

    private void changeCurrentFolder(File file) {
        interaction.onSelect(file);
        table.getSelectionModel().clearSelection();
    }

    private void setPathButtons() {
        final ObservableList<Node> children = path.getChildren();
        children.clear();
        EventHandler<ActionEvent> callback = (event) -> {
            Button button = (Button) event.getSource();
            File f = (File) button.getUserData();
            changeCurrentFolder(f);
        };
        state.getParentsAndCurrentFolder().forEach((f) -> {
            Button button = new Button(f.getName());
            button.setUserData(f);
            button.setOnAction(callback);
            children.add(button);
        });
    }

    public void setState(ExplorerState explorerState) {
        this.state = explorerState;
        state.getCurrentFolder().addListener((observable, oldValue, newValue) -> setPathButtons());
        setCellValueFactories();
        setTableInteractionEvents();
        table.setItems(state.getSubfiles());
    }
    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public interface Interaction {
        void onSelect(File file);
    }
    
}
