package be.helha.todoList.views;

import be.helha.todoList.models.DuplicateException;
import be.helha.todoList.models.ToDoItem;
import be.helha.todoList.models.ToDoList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController /*implements Initializable*/ {

    @FXML
    private VBox list;

    @FXML
    private TextField taskField;

    ToDoList toDoList;
    MainViewInteraction interaction;

    public void setToDoList(ToDoList list){
        this.toDoList = list;
        updateToDoList();
    }

    public void setInteraction(MainViewInteraction interaction){
        this.interaction = interaction;
    }

//    public void initialize(URL location, ResourceBundle resources) {}

    public void updateToDoList() {
        list.getChildren().clear();
        for (ToDoItem item : toDoList.getItems()) {
            list.getChildren().add(getItemView(item));
        }
    }

//    private void checkDoubleItem(String description){
//        for(ToDoItem item: toDoList.getItems()){
//            if(item.getDescription() == description) throw new DuplicateException();
//        }
//    }

    private BorderPane getItemView(ToDoItem item) {
        BorderPane borderPane = new BorderPane(); borderPane.setPadding(new Insets(5));
        borderPane.setLeft(getCheckBox(item));
        borderPane.setCenter(new Label(item.getDescription()));

        Button deleteBtn = new Button("x"); deleteBtn.setStyle("-fx-background-color: indianred"); BorderPane.setMargin(deleteBtn, new Insets(5,5,0,0));
        deleteBtn.setOnAction(event -> {
            interaction.removeItem(item);
        });

        borderPane.setRight(deleteBtn);
        return borderPane;
    }

    private CheckBox getCheckBox(ToDoItem item){
        CheckBox checkbox = new CheckBox();
        checkbox.setSelected(item.isDone());
        BorderPane.setMargin(checkbox, new Insets(5,0,0,5));

        checkbox.setOnMouseClicked(event -> { onCheckBoxClicked(item);});
        //checkbox.setOnAction(this::onCheckBoxClick);
        return checkbox;
    }

    private void onCheckBoxClick(ActionEvent actionEvent) {
        CheckBox source = (CheckBox) actionEvent.getSource();
        ToDoItem item = (ToDoItem) source.getUserData();
        interaction.checkedBox(item);
        System.out.println(item.isDone());
    }

    public void clearTaskField(){
        taskField.clear();
    }

    public void onAddTaskClicked(){
        interaction.addItem(taskField.getText());
//        taskField.clear();
    }

    public void onEnterPressed(KeyEvent keyE){
        if(keyE.getCode() == KeyCode.ENTER) onAddTaskClicked();
    }

    public void onCheckBoxClicked(ToDoItem item){
        interaction.checkedBox(item);
        System.out.println(item.isDone());
    }
}
