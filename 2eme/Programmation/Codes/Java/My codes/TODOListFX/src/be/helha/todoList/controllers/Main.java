package be.helha.todoList.controllers;

import be.helha.todoList.models.DuplicateException;
import be.helha.todoList.models.EmptyDescriptionException;
import be.helha.todoList.models.ToDoItem;
import be.helha.todoList.models.ToDoList;
import be.helha.todoList.views.MainViewController;
import be.helha.todoList.views.MainViewInteraction;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application implements MainViewInteraction {

    ToDoList toDoList;
    MainViewController controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        toDoList = new ToDoList();
        toDoList.addItem("Faire les courses");
        toDoList.addItem("Étudier");
        toDoList.addItem("Continuer et finir les projets");



        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/MainView.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        controller = loader.getController();
        controller.setToDoList(toDoList);
        controller.setInteraction(this);

        //Parent root = FXMLLoader.load(getClass().getResource("../views/MainView.fxml"));
        primaryStage.setTitle("ToDo2000");
        primaryStage.setScene(new Scene(root, 400, 800));
        primaryStage.show();
    }
    @Override
    public void removeItem(ToDoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez-vous vraiment supprimer cet élément?");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get() == ButtonType.OK){
            toDoList.removeItem(item);
            controller.updateToDoList();
        }
    }

    @Override
    public void addItem(String desc){
        try{
            toDoList.addItem(desc);
            controller.clearTaskField();
            controller.updateToDoList();
        }catch(DuplicateException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "TEXTE DUPLIQUÉ");
            controller.clearTaskField();
            alert.showAndWait();
        }catch(EmptyDescriptionException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "NON MAIS OH ???!!!");
            alert.showAndWait();
        }

    }

    @Override
    public void checkedBox(ToDoItem item) {
        item.toggleDone();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
