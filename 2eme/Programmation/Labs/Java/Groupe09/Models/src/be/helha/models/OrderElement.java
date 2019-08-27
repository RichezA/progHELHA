package be.helha.models;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * This class is used to define an element of our order. As long as an instance of this object could go through our network system,
 * we need to implement the Serializable interface
 */
public class OrderElement implements Serializable
{
    // ATTRIBUTES
    private double price;
    private double quantity;
    private Product element;

    //CONSTRUCTOR
    public OrderElement(Product element, double quantity)
    {
        this.element = element;
        if(element.getType() == ProductType.KILO){
            this.quantity = quantity/1000;
        }
        else {
            this.quantity = quantity;
        }
        this.updatePrice();
    }

    // GETTERS
    public double getQuantity()
    {
        return this.quantity;
    }

    public Product getProduct()
    {
        return this.element;
    }

    public double getPrice(){
        return this.price;
    }

    /**
     * This method is used to add a defined quantity to an order element
     * @param quantity
     */
    public void addQuantity(double quantity)
    {
        if(element.getType() == ProductType.KILO){
            this.quantity += quantity/1000;
        }
        else {
            this.quantity += quantity;
        }
        this.updatePrice();
    }

    /**
     * This method is used to generate and format the "price sentence" that appears on the order list
     * @return String : the formatted string of our order element
     */
    public String getStringQuantityWithPrice()
    {
        DecimalFormat df = new DecimalFormat("0.###");
        return df.format(quantity) +  element.getType().getSimpleNotation() +" à " + element.getPrice() + "€";
    }

    /**
     * This method is used to update the price of an element
     */
    private void updatePrice()
    {
        price = element.getPrice() * quantity;
    }
}
