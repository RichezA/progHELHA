package be.helha.views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.xml.soap.Text;

/**
 * This class is the view controller of our balance window
 */
public class BalanceViewController {
    // ATTRIBUTES
    private BalanceToMainViewInteraction interaction;

    @FXML
    TextField weightTxtBox;

    // SETTERS
    public void setInteraction(BalanceToMainViewInteraction interaction){
        this.interaction = interaction;
    }

    /**
     * This method is used to update the weight of the balance on the main window. Gets the value on the balance, check to see if it does have the good format
     * If so, it does send the weight to our main controller through an interface. If it does not then it will just reset the balance value to 0
     * @param event
     */
    @FXML
    public void updateWeight(KeyEvent event) {
        String curWeight = "0";
        boolean succesfulParse = true;
        try{
            if(weightTxtBox.getText().isEmpty())  curWeight = "0";
            else{
                curWeight = weightTxtBox.getText();
                try{
                    Integer.parseInt(curWeight);
                }catch(Exception e){
                    Alert invalidInput = new Alert(Alert.AlertType.ERROR, "You cannot do that, please do not insert a letter", ButtonType.OK);
                    invalidInput.setTitle("Input contains an invalid character");
                    this.weightTxtBox.clear();
                    invalidInput.showAndWait();
                    succesfulParse = false;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(succesfulParse) interaction.updateWeight(curWeight);
            else interaction.updateWeight("0");
        }
    }

    /**
     * @return 0 if our "Weight" TextBox is empty, if not, it sends the value associated with it
     */
    public String askBalanceWeight()
    {
        return weightTxtBox.getText().isEmpty() ? "0" : weightTxtBox.getText();
    }

    /**
     * This method is used to show an alert up to the screen if we try to "weight" a product that is registered as a "per piece" product
     */
    public void sendWrongProductType()
    {
        Alert invalidInput = new Alert(Alert.AlertType.ERROR, "You cannot do that, please select a product by weight", ButtonType.OK);
        invalidInput.setTitle("Wrong product type");
        this.weightTxtBox.clear();
        invalidInput.showAndWait();
    }

}
