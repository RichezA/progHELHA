package be.helha.views;

import be.helha.models.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is our view controller for our "add a new product" window
 */
public class AddViewController
{
    // ATTRIBUTES
    @FXML
    public TextField textName;
    @FXML
    public TextField textPrice;
    @FXML
    public Button addButton;
    @FXML
    public Button cancelButton;
    @FXML
    public ToggleGroup group;

    private AddViewInteraction interaction;
    private Category category;

    // SETTERS
    public void setCategory(Category category)
    {
        this.category = category;
    }
    public void setInteraction(AddViewInteraction interaction)
    {
        this.interaction = interaction;
    }

    /**
     * This method is used when we want to add a new product to our product list. We get the different attributes that are needed to add a new product
     * We can catch exceptions during the input process, we then show an alert up to the screen.
     * After all our checks, we send the attributes needed to add a product to our main controller through our interface
     * @param actionEvent -> Any event that occur on our `Add the new product` button
     */
    public void addBtnEvent(ActionEvent actionEvent)
    {
        RadioButton rBtn = (RadioButton) group.getSelectedToggle();
        String name = textName.getText();
        double price;
        try
        {
            price = Double.parseDouble(textPrice.getText());
        }
        catch (Exception e)
        {
            Alert invalidInput = new Alert(Alert.AlertType.ERROR, "You cannot do that, please do not insert a comma (,) but a dot (.)", ButtonType.OK);
            invalidInput.setTitle("Input contains an invalid character");
            this.textPrice.clear();
            invalidInput.showAndWait();
            return;
        }
        String type = rBtn.getText().toUpperCase();
        if(!textPrice.getText().isEmpty()){
            interaction.addProduct(this.category, name, price, type);
        }
        interaction.closeAddWindow(actionEvent.getSource());
    }

    /**
     * * This method is used to close the "add a new product" window when asked from our main controller
     * @param actionEvent -> Any event that occur on our cancel button
     */
    public void cancelBtnEvent(ActionEvent actionEvent)
    {
        interaction.closeAddWindow(actionEvent.getSource());
    }
}
