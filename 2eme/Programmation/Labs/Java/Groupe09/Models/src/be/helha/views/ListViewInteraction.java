package be.helha.views;

import be.helha.models.OrderElement;

/**
 * This interface is used between our main interface controller and our order list view controller
 */
public interface ListViewInteraction
{
    void deleteElement(OrderElement element);
    void askPaiement();
}
