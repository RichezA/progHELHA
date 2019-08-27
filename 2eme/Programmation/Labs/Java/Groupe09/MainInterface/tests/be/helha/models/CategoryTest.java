package be.helha.models;

import be.helha.models.exceptions.DuplicatedItemException;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategoryTest
{
    Category cat;
    Category nullCat;
    Product p1;
    Product p2;
    Scanner scan;


    @Before
    public void init()
    {
        cat = new Category("Fruits");
        nullCat = new Category(null);
        p1 = new Product("nom10", 10.0, "PIECE");
        p2 = new Product("nom20", 20.0, "KILO");
        scan = new Scanner("tests/categoriesTest.txt");
        cat.addProduct(p1);
        cat.addProduct(p2);
        cat.setScanner(scan);
    }


    @Test
    public void getName()
    {
        assertEquals(cat.getName(), "Fruits");
        assertEquals(nullCat.getName(), null);
    }


    @Test
    public void addProduct()
    {
        assertEquals(cat.getProducts().size(), 2);
        cat.addProduct(new Product("newProduct", 2500.0, "KILO"));
        assertEquals(cat.getProducts().size(), 3);
    }

    @Test(expected = DuplicatedItemException.class)
    public void checkDuplicatedProduct()
    {
        cat.addProduct(p2);
    }

    @Test
    public void getScanner() {
        assertEquals(nullCat.getScanner(), null);
        assertEquals(cat.getScanner(), scan);
    }

    @Test
    public void getProducts() {
        assertTrue(cat.getProducts().contains(p1));
        assertTrue(cat.getProducts().contains(p2));
    }
}