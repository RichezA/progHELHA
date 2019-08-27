package be.helha.models;

import javafx.scene.image.Image;

import java.io.Serializable;

/**
 * This class defines a product. It implements the Serializable interface since we could send it through the network system
 */
public class Product implements Serializable
{
    // ATTRIBUTES
    private String name;
    private double price;
    private ProductType type;
    private String imageUrl;

    // CONSTRUCTORS
    /**
     * We do use this constructor when we don't have a specific image of the product concerned
     * @param name
     * @param price
     * @param type
     */
    public Product(String name, double price, String type)
    {
        this(name, price, type, Product.class.getResource("../../../images/Unknown.png").toString());
    }

    public Product(String name, double price, String type, String imageUrl)
    {
        this.name = name;
        this.price = price;
        this.type = ProductType.valueOf(type);
        this.imageUrl = imageUrl;
    }

    // GETTERS
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public Image getImage()
    {
        try{
            return new Image(this.imageUrl);
        } catch (Exception e)
        {
            this.imageUrl = this.getClass().getResource("/be/helha/views/Unknown.png").toString();
        }
        finally
        {
            return new Image(this.imageUrl);
        }
    }

    public ProductType getType()
    {
        return type;
    }

    /**
     * This method checks if an input name is equals to our product's name
     * @param name : String
     * @return Boolean -> true if the name attached as the parameter is the same as the current product one
     */
    public boolean hasName(String name)
    {
        return this.name.equals(name);
    }
}
