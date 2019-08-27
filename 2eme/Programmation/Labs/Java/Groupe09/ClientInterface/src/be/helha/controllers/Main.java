package be.helha.controllers;

import be.helha.models.Order;
import be.helha.models.network.Client;
import be.helha.views.ListViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application implements Observer
{
    // ATTRIBUTES
    private Client client;
    private ListViewController listViewController;
    //Order order;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.loadMainWindows(primaryStage);
        client = new Client(this);
        Thread thread = new Thread(client);
        thread.setDaemon(true);
        thread.start();
        listViewController.toggleReadOnly();
    }

    /**
     * This method is used to generate and show up to the screen the client main window
     * @param primaryStage : Stage
     * @throws Exception
     */
    private void loadMainWindows(Stage primaryStage) throws Exception
    {
        FXMLLoader mainViewLoader = new FXMLLoader(ListViewController.class.getResource("ListView.fxml"));
        mainViewLoader.load();
        listViewController = mainViewLoader.getController();
        Parent root = mainViewLoader.getRoot();
        primaryStage.setTitle("Client View");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> client.sendToServer("BYE"));
    }

    /**
     * As long as we do implement the Observer interface, we have to override this method, permitting us to update our order list when we are notified by an observable object
     * we do use `Platform.runLater(<lambda>)`, because as long as we do use multithreading to communicate in real time between our three interface,
     * we have to be sure that we're running our desired interaction during the correct thread (which is the javaFX one in our case).
     * If you want to know more about Observers and its implementations, please check the documentation at : https://docs.oracle.com/javase/7/docs/api/java/util/Observer.html#update(java.util.Observable,%20java.lang.Object)
     * @param o : Observable
     * @param arg : Object
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if(arg instanceof Order){
            listViewController.setOrder((Order) arg);
            Platform.runLater(() -> listViewController.refreshOrder());
        }
    }
}
