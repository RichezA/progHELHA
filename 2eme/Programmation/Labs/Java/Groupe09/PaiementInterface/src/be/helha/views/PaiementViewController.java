package be.helha.views;

import be.helha.controllers.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * This class is our main view controller for the payment interface
 */
public class PaiementViewController
{
    // ATTRIBUTES
    @FXML
    public Label priceLabel;
    @FXML
    public Label waitingLabel;
    @FXML
    public Button yesBtn;
    @FXML
    public Button noBtn;
    private PaiementInteraction interaction;

    /**
     * This method is used when we will press the "YES" button on our payment interface, it will send a request to our main controller to prevent the server that we accepted the payment
     * @param actionEvent -> an event that occured on our button
     */
    public void yesPressed(ActionEvent actionEvent)
    {
        interaction.acceptPaiement();
    }

    /**
     * This method is used when we will press the "NO" button on our payment interface, it will send a request to our main controller to prevent the server that we declined the payment
     * @param actionEvent -> an event that occured on our button
     */
    public void noPressed(ActionEvent actionEvent)
    {
        interaction.denyPaiement();
    }

    /**
     * This method is called by our main controller when we want to notify the user that we need to accept/deny the order payment
     * @param arg -> The price we have to pay, sent by the server
     */
    public void onReceivePaiement(String arg)
    {
        waitingLabel.setText("Would you pay ?");
        priceLabel.setText(arg);
        yesBtn.setVisible(true);
        noBtn.setVisible(true);
    }

    /**
     * This method is called by our main controller when we want to show the "Idle" mode up to the screen
     */
    public void finishPaiement()
    {
        waitingLabel.setText("Waiting for paiement...");
        priceLabel.setText("");
        yesBtn.setVisible(false);
        noBtn.setVisible(false);
    }

    public void showDeniedOrder(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Payment has been denied", ButtonType.OK);
        alert.setTitle("Error during the payment process");
        alert.setHeaderText("Error");
        alert.showAndWait();
    }

    /**
     * This method is used to instantiate our interface
     * @param main
     */
    public void setInteraction(PaiementInteraction main)
    {
        interaction = main;
    }
}
