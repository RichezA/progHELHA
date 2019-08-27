package be.helha.views;

import be.helha.models.Category;
import be.helha.models.OrderElement;
import be.helha.models.Product;

/**
 * This interface is used between our main controller and our main view controller to manage the adding and the changes that can occur on our products.
 */
public interface MainViewInteraction
{
    void setChoosenProduct(Product p);                                  // Sets the current product we're selecting
    void loadAddingWindow(Category c) throws Exception;                 // Shows up the "add a new product" window
    void updatePrice();                                                 // Updates the price
    void addToOrder();
}
