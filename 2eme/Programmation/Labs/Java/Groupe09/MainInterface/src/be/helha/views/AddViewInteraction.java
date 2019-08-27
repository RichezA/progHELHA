package be.helha.views;

import be.helha.models.Category;

/**
 * This interface is used between our main controller and our "add" view controller, it does manage the add of a new product and the closure of this window
 */
public interface AddViewInteraction
{

    void closeAddWindow(Object source);                                                     // Permits to close the window
    void addProduct(Category category, String name, double price, String type);             // Permits to add a new product
}
