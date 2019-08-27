package be.helha.models;

import be.helha.models.exceptions.NotOrderedProductException;
import be.helha.models.exceptions.UnweightedProductException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {
    Order orderTest;
    Product test;
    OrderElement elementTest;

    @Before
    public void initialize()
    {
        orderTest = new Order();
        test = new Product("Apple", 2.3, "PIECE");
        elementTest = new OrderElement(test, 1.0);
        orderTest.addElement(test, 1.0);
    }

    @Test
    public void getPrice()
    {
        assertEquals(String.valueOf(orderTest.getPrice()), "2.3");
    }

    @Test
    public void getElements()
    {
        List<OrderElement> testList= new ArrayList<>();
        testList.add(elementTest);
        assertEquals(orderTest.getElements().get(0).getProduct(), testList.get(0).getProduct());
    }

    @Test
    public void addElement()
    {
        int oldListSize = orderTest.getElements().size();
        orderTest.addElement(new Product("Beef", 20.0, "KILO"), 1.0);
        assertEquals(orderTest.getElements().size(), ++oldListSize);
    }

    @Test(expected = UnweightedProductException.class)
    public void addUnweightedElement(){
        orderTest.addElement(test, 0);
    }

    @Test
    public void removeElement()
    {
        int oldListSize = orderTest.getElements().size();
        orderTest.removeElement(orderTest.getElements().get(0));
        assertEquals(orderTest.getElements().size(), --oldListSize);
    }

    @Test
    public void getElement()
    {
        assertEquals(orderTest.getElement(orderTest.getElements().get(0).getProduct()).getProduct().getName(), "Apple");
    }

    @Test (expected = NotOrderedProductException.class)
    public void checkIfgetElementReturnsTheException()
    {
        Product product = new Product("Pork", 5.30, "KILO");
        orderTest.getElement(product);
    }

}
