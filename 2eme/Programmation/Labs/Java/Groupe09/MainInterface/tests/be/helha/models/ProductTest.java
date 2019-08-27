package be.helha.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest {

    Product p1 = new Product("test1", 10.20, "KILO");

    @Test
    public void hasName() {
        assertEquals(p1.getName(), "test1");
    }
}