package be.helha.views;

import be.helha.models.Order;
import be.helha.models.OrderElement;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * This class is our view controller for the order list
 */
public class ListViewController
{
    // ATTRIBUTES
    @FXML
    public VBox commandVbox;
    @FXML
    public Label commandPrice;
    @FXML
    public Button cashBtn;

    private boolean readOnly = false;
    private final DecimalFormat df = new DecimalFormat("0.00");
    private Order order;
    private ListViewInteraction interaction;

    // SETETRS
    public void setOrder(Order order)
    {
        this.order = order;
    }

    public void setInteraction(ListViewInteraction interaction)
    {
        this.interaction = interaction;
    }

    /**
     * This method is used to refresh the order list when we just paid an order
     */
    public void refreshOrder()
    {
        commandVbox.getChildren().clear();
        for (OrderElement element : order.getElements()) {
            BorderPane bd = getCommandElementNode(element);
            commandVbox.getChildren().add(bd);
        }
        this.commandPrice.setText(df.format(order.getPrice())+"€");
    }

    /**
     * This method is used to generate and format the order list based on an order element
     * @param element : OrderElement the order element that we will format
     * @return BorderPane
     */
    private BorderPane getCommandElementNode(OrderElement element)
    {
        BorderPane bd = new BorderPane();
        if(!readOnly)bd.setOnMouseClicked(event -> interaction.deleteElement(element));
        bd.setStyle("-fx-background-color: #FFFFFF;");
        BorderPane bd1 = getNameAndPriceDetailsNode(element);
        bd.setPadding(new Insets(5,5,5,5));
        Label price = new Label(df.format(element.getPrice())+"€");
        BorderPane.setAlignment(price, Pos.CENTER);
        Font font = new Font("System Bold", 18);
        price.setFont(font);
        bd.setRight(price);
        bd.setCenter(bd1);
        return bd;
    }

    /**
     * This method is used to create and format the details for an order element by specifying its name and price (with quantity associated)
     * @param element : OrderElement
     * @return BorderPane
     */
    private BorderPane getNameAndPriceDetailsNode(OrderElement element)
    {
        BorderPane bd1 = new BorderPane();
        Label name = new Label(element.getProduct().getName());
        bd1.setTop(name);
        Label desc = new Label(element.getStringQuantityWithPrice());
        bd1.setBottom(desc);
        return bd1;
    }

    /**
     * This method is used to toggle the Client/Server view by removing or adding the button
     */
    public void toggleReadOnly()
    {
        readOnly = !readOnly;
        cashBtn.setVisible(!readOnly);
    }

    public void cashAction(ActionEvent actionEvent)
    {
        interaction.askPaiement();
    }
}
