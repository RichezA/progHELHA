package be.helha.models;

import be.helha.models.exceptions.NotOrderedProductException;
import be.helha.models.exceptions.UnweightedProductException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class defines an order, it implements the interface Serializable, meaning that it can have a serializable or a deserialized state
 * The method `writeObject()` is responsible for writing the state of the object for its particular class, the `readObject()` one can restore it.
 * If you want to know more about Serialization and the Serializable interface, please refer to https://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
 */
public class Order implements Serializable
{
    // ATTRIBUTES
    private double price;
    private ArrayList<OrderElement> elements;

    // CONSTRUCTOR
    public Order()
    {
        this.price = 0.0;
        this.elements = new ArrayList<>();
    }

    // GETTERS
    public double getPrice()
    {
        return price;
    }

    public List<OrderElement> getElements()
    {
        return Collections.unmodifiableList(this.elements);
    }

    public OrderElement getElement(Product product)
    {
        for (OrderElement element : this.elements) {
            if(element.getProduct().getName().equals(product.getName())){
                return element;
            }
        }
        throw new NotOrderedProductException();
    }

    /**
     * This method is used when we want to add a new element to our order
     * @param product : the product we wish to add to our order
     * @param quantity : the quantity of its product
     */
    public void addElement(Product product, double quantity){
        if(quantity == 0){
            throw new UnweightedProductException();
        }

        if(this.containsProduct(product))
        {
            double oldPrice = this.getElement(product).getPrice();
            this.getElement(product).addQuantity(quantity);
            this.price += this.getElement(product).getPrice() - oldPrice;
        }
        else
        {
            OrderElement element = new OrderElement(product, quantity);
            this.elements.add(element);
            this.price += element.getPrice();
        }
    }

    /**
     * This method is used when we want to remove an element from the order
     * @param element : OrderElement
     */
    public void removeElement(OrderElement element){
        if(this.elements.contains(element))
        {
            this.elements.remove(element);
            this.price -= element.getPrice();
        }
    }

    /**
     * This method is used when we want to check if a product is already in the order list or not
     * @param product : the product we want to check it already exists
     * @return Boolean -> returns true if the product already exists
     */
    private boolean containsProduct(Product product)
    {
        for (OrderElement element : this.elements) {
            if(element.getProduct().getName().equals(product.getName())){
                return true;
            }
        }
        return false;
    }


}
