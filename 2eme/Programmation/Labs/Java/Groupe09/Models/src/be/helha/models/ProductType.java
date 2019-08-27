package be.helha.models;

import java.io.Serializable;

/**
 * This enum is used to define a product being a "per piece" or a "by weight" one
 */
public enum ProductType implements Serializable
{

    KILO("KILO", "€/kg"),
    PIECE("PIECE", "€/p.");

    public final String name;
    public final String notation;

    private ProductType(final String name, final String notation)
    {
        this.name = name;
        this.notation = notation;
    }

    public String getSimpleNotation()
    {
        return this.notation.replace("€/", "");
    }
}
