package be.helha.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderElementTest {

    OrderElement testElement;

    @Before
    public void initialize(){
        testElement = new OrderElement(new Product("Apple", 2.3, "KILO"), 1.0);
    }

    @Test
    public void getProduct() {
        assertEquals("Apple", testElement.getProduct().getName());
    }

    @Test
    public void getPrice() {
        assertEquals(0.0023, testElement.getPrice(), 0.0);
    }

    @Test
    public void addQuantity() {
        assertEquals(0.001, testElement.getQuantity(), 0.0);
        testElement.addQuantity(2.0);
        assertEquals(0.003, testElement.getQuantity(), 0.0);
    }

    @Test
    public void getStringQuantityWithPrice() {
        assertEquals("0.001kg à 2.3€", testElement.getStringQuantityWithPrice());
    }
}