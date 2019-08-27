package be.helha.controllers;

import be.helha.models.network.Client;
import be.helha.views.PaiementInteraction;
import be.helha.views.PaiementViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is the main controller for the payment window
 */
public class Main extends Application implements Observer, PaiementInteraction
{

    Client client;
    PaiementViewController paiementViewController;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        client = new Client(this);
        Thread thread = new Thread(client);
        thread.setDaemon(true);
        thread.start();
        this.loadPaiementInterface(primaryStage);
    }

    private void loadPaiementInterface(Stage primaryStage) throws IOException
    {
        FXMLLoader paiementViewLoader = new FXMLLoader(PaiementViewController.class.getResource("PaiementView.fxml"));
        paiementViewLoader.load();
        Parent root = paiementViewLoader.getRoot();
        paiementViewController = paiementViewLoader.getController();
        paiementViewController.setInteraction(this);
        primaryStage.setTitle("Payment");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> client.sendToServer("BYE"));
        paiementViewController.finishPaiement();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(arg instanceof String)
        {
            Platform.runLater(() -> paiementViewController.onReceivePaiement((String) arg));
        }
    }

    @Override
    public void acceptPaiement()
    {
        client.sendToServer("YES");
        paiementViewController.finishPaiement();
    }

    @Override
    public void denyPaiement()
    {
        client.sendToServer("NO");
        paiementViewController.showDeniedOrder();
        paiementViewController.finishPaiement();
    }
}
